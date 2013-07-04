/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler.classes;

import java.util.Enumeration;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Administrador
 */
public class Arbol {
    static DefaultTreeModel X;
    static String[] operations;
    public void Arborize(String Expresion, JTree jTree, JTextArea jText) {


        int ErrorCount = 0;
        DefaultMutableTreeNode ErrorAsign = null,ErrorIgualdad = null,ErrorSeparador = null,ErrorJerarquia
                = null, ErrorOperador = null,ErrorVariables = null;
        if (!VerificarAsignaciones(0, Expresion)) {
            ErrorAsign = new DefaultMutableTreeNode("Error. Solo puede Existir una igualdad");
            ErrorCount++;
        }
        if (!VerificarEspaciado(Expresion)) {
            ErrorIgualdad = new DefaultMutableTreeNode("Error. La Expresion contiene Asignacion Invalida");
            ErrorCount++;
        }
        if (VerificarSeparadores(Expresion)) {
            ErrorSeparador = new DefaultMutableTreeNode("Error. Hay Parentesis o separadores sin cierre");
            ErrorCount++;
        }
        if (!VerificarSeparadoresJerarquia(Expresion)) {
            ErrorJerarquia = new DefaultMutableTreeNode("Error. La Jerarquia de los operadores no es correcta");
            ErrorCount++;
        }
        if (VerificarContinuidad(Expresion)) {
            ErrorOperador = new DefaultMutableTreeNode("Error. No pueden existir operadores juntos");
            ErrorCount++;
        }
        if (VerificarVariables(Expresion)) {
           ErrorVariables = new DefaultMutableTreeNode("Error. Las Variables no pueden abarcar mas de un Caracter.");
           ErrorCount++;
        }

        if (ErrorCount != 0)
            { DefaultMutableTreeNode Root = new DefaultMutableTreeNode("Errores");
            jTree.setModel(new DefaultTreeModel(Root));
            if (ErrorAsign != null) Root.add(ErrorAsign);
            if (ErrorIgualdad != null) Root.add(ErrorIgualdad);
            if (ErrorSeparador != null) Root.add(ErrorSeparador);
            if (ErrorJerarquia != null) Root.add(ErrorJerarquia);
            if (ErrorOperador != null) Root.add(ErrorOperador);
            if (ErrorVariables != null) Root.add(ErrorVariables);

            TreePath path = new TreePath(jTree.getModel().getRoot());
            jTree.expandPath(path);

            return;
        }
        String node = "";
//        Expresion = FixImplicitOperation(Expresion);
        for (int i = 0; i < Expresion.length(); i++) {
            if(!Expresion.substring(i, i+1).equals("(") &&
                !Expresion.substring(i, i+1).equals("{") &&
                !Expresion.substring(i, i+1).equals("[")){
                node = " N("+Expresion.substring(i, i+1)+",0)";
                Expresion += node;
            break;
            }
        }


        int totalNumberOperators, initOperators, finOperators;
        DefaultMutableTreeNode Y = new DefaultMutableTreeNode(Expresion);
        Expresion = Expresion.replace(node, "");
        X = new DefaultTreeModel(Y);
        String init = null, fin = null;
        totalNumberOperators = this.countOperators(Expresion);
        operations = new String [totalNumberOperators];

        init = Expresion.substring(0, Expresion.indexOf("=")).trim();
        fin = Expresion.substring(Expresion.indexOf("=") + 1, Expresion.length()).trim();
        this.calculateOperation(operations, init, fin, '=', totalNumberOperators-1);

        if(init.length() == 1)
            init += " T("+init+",0)";
        if(fin.length() == 1)
            fin += " T(0,"+fin+")";

        String nodeInit = "", nodeFin = "";
        for (int i = 0; i < init.length(); i++) {
            if(!init.substring(i, i+1).equals("(") &&
                !init.substring(i, i+1).equals("{") &&
                !init.substring(i, i+1).equals("[")){
                nodeInit = " N("+init.substring(i, i+1)+",0)";
                init += nodeInit;
            break;
            }
        }

        for (int i = 0; i < fin.length(); i++) {
            if(!fin.substring(i, i+1).equals("(") &&
                !fin.substring(i, i+1).equals("{") &&
                !fin.substring(i, i+1).equals("[")){
                nodeFin = " N("+fin.substring(i, i+1)+",0)";
                fin += nodeFin;
            break;
            }
        }

        DefaultMutableTreeNode YsubIzq = new DefaultMutableTreeNode(init);
        DefaultMutableTreeNode YsubDer = new DefaultMutableTreeNode(fin);
        
        Y.add(YsubIzq);
        Y.add(YsubDer);
        Expresar(YsubIzq.getUserObject().toString().replace(nodeInit, ""), YsubIzq, this.countOperators(init));
        Expresar(YsubDer.getUserObject().toString().replace(nodeFin, ""), YsubDer, (totalNumberOperators-1));
        jTree.setModel(X);

        

        TreeModel model = jTree.getModel();

  DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) model.getRoot();
  // Just changing enumeration kind here
  Enumeration<DefaultMutableTreeNode> en = rootNode.postorderEnumeration();
  String postOrder = "";


        Enumeration<DefaultMutableTreeNode> postOrden = rootNode.postorderEnumeration();
        while(postOrden.hasMoreElements()){
            DefaultMutableTreeNode aux = (DefaultMutableTreeNode)postOrden.nextElement();
            String value = aux.toString();
            if(value.length() > 7 && value.charAt(value.length()-3) == ',')
                value = value.substring(0,value.length()-7);
            if(aux.isLeaf())jText.setText(jText.getText()+value+" , ");
            else if(tieneOperador(value)){
                char c = obtenerOperador(value);
                if(c=='=')jText.setText(jText.getText()+" = ");
                else jText.setText(jText.getText()+obtenerOperador(value)+" , ");
            }
        }
        
  
//  while (en.hasMoreElements())
//  {
//     DefaultMutableTreeNode nodef = en.nextElement();
//     String value = nodef.toString();
//
//     if(value.length() > 7 && value.charAt(value.length()-3) == ','){
//
//          if(!postOrder.equals("")){
//          String [] arrays = postOrder.replaceAll(" ", "").split(",");
//          for (int i = 0; i < arrays.length; i++) {
//             String string = arrays[i];
//
//             value = value.replace(string, "");
//            }
//          postOrder += (value.substring(0,value.length()-7)+", ");
//
//          }else{
//          postOrder += (value.substring(0,value.length()-7)+", ");
//     }
//
//  }
//  jText.setText(postOrder);
//
//
//    }
    }

    boolean tieneOperador(String cadena){
        boolean b=false;
        for(int i=0;i<cadena.length();i++){
            if(esOperador(""+cadena.charAt(i))){
                b=true;
            }
        }
        return b;
    }

    boolean esOperador(String c){
        boolean b=false;
        if(c.equalsIgnoreCase("+")||c.equalsIgnoreCase("-")||c.equalsIgnoreCase("*")||c.equalsIgnoreCase("/")||c.equalsIgnoreCase("^")){
            b=true;
        }
        return b;
    }

    char obtenerOperador(String cadena){
         if(cadena.charAt(0)=='(' && cadena.charAt(cadena.length()-1)==')'){
            cadena=cadena.substring(1,cadena.length()-1);
        }
         if(cadena.charAt(0)=='[' && cadena.charAt(cadena.length()-1)==']'){
            cadena=cadena.substring(1,cadena.length()-1);
        }
         if(cadena.charAt(0)=='{' && cadena.charAt(cadena.length()-1)=='}'){
            cadena=cadena.substring(1,cadena.length()-1);
        }
        String c[]=new String[2];
        int x;
        x=buscarSeparacion(cadena);
        return cadena.charAt(x);
    }

    int separador(String cadena,char ch){
        boolean p=false,l=false,c=false;
        int i=-1;
        for(i=0;i<cadena.length();i++){
                if(cadena.charAt(i)=='('){
                    p=true;
                }
                if(cadena.charAt(i)=='['){
                    c=true;
                }
                if(cadena.charAt(i)=='{'){
                    l=true;
                }
            if(!p&&!l&&!c){
                if(cadena.charAt(i)==ch)return i;

            }else{

                if(cadena.charAt(i)==')'){
                    p=false;
                }
                if(cadena.charAt(i)==']'){
                    c=false;
                }
                if(cadena.charAt(i)=='}'){
                    l=false;
                }
            }
        }
        return i;
    }

    int buscarSeparacion(String cadena){
        int i=-1;
        if(buscar(cadena,'='))return separador(cadena,'=');
        if(buscar(cadena,'+'))return separador(cadena,'+');
        if(buscar(cadena,'-'))return separador(cadena,'-');
        if(buscar(cadena,'*'))return separador(cadena,'*');
        if(buscar(cadena,'/'))return separador(cadena,'/');
        if(buscar(cadena,'^'))return separador(cadena,'^');
        return i;
    }

    boolean buscar(String cadena,char ch){
        boolean b=false;
        boolean p=false,l=false,c=false;
        int i;
        for(i=0;i<cadena.length();i++){
                if(cadena.charAt(i)=='('){
                    p=true;
                }
                if(cadena.charAt(i)=='['){
                    c=true;
                }
                if(cadena.charAt(i)=='{'){
                    l=true;
                }
            if(!p&&!l&&!c){
                if(cadena.charAt(i)==ch)return true;

            }else{

                if(cadena.charAt(i)==')'){
                    p=false;
                }
                if(cadena.charAt(i)==']'){
                    c=false;
                }
                if(cadena.charAt(i)=='}'){
                    l=false;
                }
            }
        }

        return b;
    }

    public static boolean VerificarAsignaciones(int count, String X) {
        if (X.indexOf("=") == -1 && count != 1) {
            return false;
        } else {
            if (X.indexOf("=") != -1) {
                count++;
                return VerificarAsignaciones(count, X.substring(X.indexOf("=") + 1, X.length()));
            } else {
                return true;
            }
        }
    }

    public static boolean VerificarEspaciado(String X) {
        X = X.trim();
        if (X.startsWith("=") || X.endsWith("=")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean VerificarSeparadores(String X) {
        int countpar = 0,countkey = 0,countblock = 0;

        for (int i = 0; i < X.length(); i++) {

            char Y = X.charAt(i);

            switch(Y)
            {
                case '(': countpar++; break;
                case ')': countpar--; break;
                case '[': countblock++; break;
                case ']': countblock--; break;
                case '{': countkey++; break;
                case '}': countkey--; break;

            }

        }


        if (countpar != 0 || countblock != 0 || countkey != 0) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean VerificarSeparadoresJerarquia(String X) {
        int countpar = 0,countkey = 0,countblock = 0;
        boolean openk = false, openb = false, openp = false;

        for (int i = 0; i < X.length(); i++) {

            char Y = X.charAt(i);


            if (Y == '{') {
                 if(openb == true || openp == true)
                return false;
                 countkey++; openk = true;

            }
            if (Y == '}'){
                if(openb == true || openp == true)
                return false;
                countkey--; if(countkey == 0) openk = false;
            }



            if(Y == '['){
                 if(openp == true)
                return false;
                countblock++; openb = true;

            }
            if(Y == ']'){
                 if(openp == true)
                return false;
                countblock--; if(countblock == 0) openb = false;
            }

            if(Y == '('){
                countpar++; openp = true;
            }
            if(Y == ')'){
                countpar--; if(countpar == 0) openp = false;
            }
        
        }


        if (countpar == 0 || countblock == 0 || countkey == 0) {
            return true;
        } else {
            return false;
        }

    }

    public String FixImplicitOperation(String X){

        X += " ";
        for (int i = 0; i < X.length() - 1; i++) {

            char Y = X.charAt(i);
            char Z = X.charAt(i + 1);
            boolean YisElemental = (Y == '+' || Y == '-');
            boolean ZisElemental = (Z == '+' || Z == '-');
            boolean ZisOpeningSeparator = (Z == '(' || Z == '[' || Z == '{');
            boolean YisOpeningSeparator = (Y == '(' || Y == '[' || Y == '{');
            boolean ZisEndingSeparator = (Z == ')' || Z == ']' || Z == '}');
            boolean YisEndingSeparator = (Y == ')' || Y == ']' || Y == '}');

            if(Character.isLetterOrDigit(Y) && ZisOpeningSeparator) {
               X = X.substring(0,i+1) + "*" + X.substring(i+1, X.length());
            }
            if(Character.isLetterOrDigit(Y) && Character.isLetterOrDigit(Z)){
               X = X.substring(0,i+1) + "*" + X.substring(i+1, X.length());
            }
            if(YisEndingSeparator && Character.isLetterOrDigit(Z))
            {
               X = X.substring(0,i+1) + "*" + X.substring(i+1, X.length());
            }
            if(YisEndingSeparator && ZisOpeningSeparator)
            {
               X = X.substring(0,i+1) + "*" + X.substring(i+1, X.length());
            }
            if(YisElemental && ZisOpeningSeparator)
            {
               X = X.substring(0,i+1) + "1" + X.substring(i+1, X.length());
            }
            if(YisOpeningSeparator && ZisElemental)
            {
               X = X.substring(0,i+1) + "0" + X.substring(i+1, X.length());
            }
            
        }
        X = X.replace(",", ".");
        return X.trim();

    }

    public boolean VerificarVariables(String X) {
        boolean Error = false;
        X += " ";
        for (int i = 0; i < X.length() - 1; i++) {

            char Y = X.charAt(i);
            char Z = X.charAt(i + 1);

            if (Character.isLetter(Y) && Character.isLetter(Z)) {
                return true;
            }

        }
        return Error;

    }

    public boolean isOperator(char C) {
        return (C == '+' || C == '-' || C == '*' || C == '/' || C == '^');
    }

    public boolean VerificarContinuidad(String X) {
        boolean Error = false;
        X += " ";
        for (int i = 0; i < X.length() - 1; i++) {

            char Y = X.charAt(i);
            char Z = X.charAt(i + 1);

            if (isOperator(Y) && isOperator(Z)) {
                return true;
            }

        }
        return Error;

    }

    public void Expresar(String Z, DefaultMutableTreeNode Node, int index) {

        String init = null, fin = null, sig=null;
        int countkey = 0, countblock = 0, countpar = 0;
        boolean openk = false, openb = false, openp = false;
        int ActualIndex = -1;
        int ActualPriority = Integer.MAX_VALUE;
        boolean stop = false;


        for (int i = 0; i < Z.length(); i++) {
            if (stop == false) {
                char Y = Z.charAt(i);

                switch (Y)
                {   case '{': openk = true; countkey++; break;
                    case '}': countkey--; if(countkey == 0) openk = false;  break;
                    case '[': openb = true; countblock++; break;
                    case ']': countblock--; if(countblock == 0) openb = false; break;
                    case '(': openp = true; countpar++; break;
                    case ')': countpar--; if(countpar == 0) openp = false; break;


                }
              if (!openk && !openb && !openp) {
                    if (Y == '+') {
                        ActualPriority = 1;
                        ActualIndex = i;
                        stop = true;
                    }
                    if (Y == '-' && i != 0) {
                        if (ActualPriority > 2) {
                            ActualPriority = 2;
                            ActualIndex = i;
                        }
                    }

                    if (Y == '*') {
                        if (ActualPriority > 3) {
                            ActualPriority = 3;
                            ActualIndex = i;
                        }
                    }

                    if (Y == '/') {
                        if (ActualPriority > 4) {
                            ActualPriority = 4;
                            ActualIndex = i;
                        }
                    }
                    if (Y == '^') {
                        if (ActualPriority > 5) {
                            ActualPriority = 5;
                            ActualIndex = i;
                        }
                    }
                }
            }
        }

        if (ActualIndex != -1) {

            init = Z.substring(0, ActualIndex).trim();
            fin = Z.substring(ActualIndex + 1, Z.length()).trim();
            sig = ""+Z.charAt(ActualIndex);
        }
        
        if (init != null && fin != null && sig != null) {
        int initOperators, finOperators;
        this.calculateOperation(operations, init, fin, sig.charAt(0), index);

            if(init.length() == 1)
                init += " T("+init+",0)";
            if(fin.length() == 1)
                fin += " T(0,"+fin+")";
//nodo inicial
            
             String nodeInit = "", nodeFin = "";
        for (int i = 0; i < init.length(); i++) {
            if(!init.substring(i, i+1).equals("(") &&
                !init.substring(i, i+1).equals("{") &&
                !init.substring(i, i+1).equals("[")){
                nodeInit = " N("+init.substring(i, i+1)+",0)";
                init += nodeInit;
            break;
            }
        }

        //nodo final
        for (int i = 0; i < fin.length(); i++) {
            if(!fin.substring(i, i+1).equals("(") &&
                !fin.substring(i, i+1).equals("{") &&
                !fin.substring(i, i+1).equals("[")){
                nodeFin = " N("+fin.substring(i, i+1)+",0)";
                fin += nodeFin;
            break;
            }
        }
            DefaultMutableTreeNode InitNode = new DefaultMutableTreeNode(init);
            DefaultMutableTreeNode FinNode = new DefaultMutableTreeNode(fin);
            Node.add(InitNode);
            Node.add(FinNode);

            // E x p r e s a r ! ! ! 
            Expresar(init.replace(nodeInit, ""), InitNode, this.countOperators(init));
            Expresar(fin.replace(nodeFin, ""), FinNode, (index-1));
        } else {
            if (((Z.startsWith("(")) && Z.endsWith(")")) || ((Z.startsWith("[")) &&
                    Z.endsWith("]")) || ((Z.startsWith("{")) && Z.endsWith("}")))
            {
                Z = Z.substring(1, Z.length() - 1).trim();
                if (Z.equalsIgnoreCase("")) Z = "0";
                Expresar(Z, Node, 0);
            }
            else {
                Z.replace("(", "");
                Z.replace(")", "");
                Z.replace("[", "");
                Z.replace("]", "");
                Z.replace("{", "");
                Z.replace("}", "");

                Node.setUserObject(Z);
            }
        }
    }

    public void calculateOperation(String[] operations, String init, String fin, char sign, int index){
		int initOperators = this.countOperators(init);
		int finOperators = this.countOperators(fin);
		String op1, op2;
		if(initOperators < 1)
		    op1 = init;
		else
		    op1 = "Op"+initOperators;
		if(finOperators < 1)
		    op2 = fin;
		else
		    op2 = "Op"+(index-1);
                if(index > 0)
            operations[index-1] = op1+" = "+op2;

	}

	public int countOperators(String code){
	        int count = 0;
	        for (int i = 0; i < code.length(); i++) {
	            char caracter = code.charAt(i);
	            if(caracter == '+'){
	                count++;
	                continue;
	            }
	            if(caracter == '-'){
	                count++;
	                continue;
	            }
	            if(caracter == '*'){
	                count++;
	                continue;
	            }
	            if(caracter == '/'){
	                count++;
	                continue;
	            }
	            if(caracter == '^'){
	                count++;
	                continue;
	            }
	        }
	        return count;
    }

}
