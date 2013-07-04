package compiler.view;

import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeNode extends DefaultMutableTreeNode {

   private TreeNode hizq,hder;
   private String expresion,iz,de,codigo,operacion;
   private int nivel;
   private boolean lado;
   private char operador;

   /**
    * Constructor de la clase TreeNode
    * @param e  Expresion del nodo
    * @param l  Nivel de la expresion, posicion para comunicar los metodos
    *           de separadores cuando se encuentran mas de un separador
    * @param IndiceOP Indice de ubicacion del operador y donde se va a
    *                 separar la expresion
    * @param Operadores Cadena de caracteres para la jerarquia de operadores
    * @param or Determinar si es hijo izquierdo(true) o derecho(false)
    */
   public TreeNode(String e,int l,int IndiceOP,String Operadores,boolean or){
    expresion = e.trim();
    nivel = l;
    lado = or;
    operador = expresion.charAt(IndiceOP);

    //Creacion de Hijos
    if(IndiceOP != 0){
      iz = expresion.substring(0,IndiceOP);
      de = expresion.substring(IndiceOP+1);}
    else{ iz = de = "";}
    hizq = SepararExp(iz.trim(),nivel,Operadores,true);
    if(hizq != null) this.add(hizq);
    hder = SepararExp(de.trim(),nivel,Operadores,false);
    if(hder != null) this.add(hder);

    //Creacion de Codigos de Activacion e inicializacion de Codigos de Tres
    //Direcciones
    if(this.isLeaf())
    {  operacion = expresion;
       if(lado) CodigodeActivacion("T("+expresion+",0)");
       else     CodigodeActivacion("T(0,"+expresion+")");
    }
    else
       CodigodeActivacion("N"+hizq.ObtenerCodigo());
   }

   @Override
   public String toString(){
     return expresion + "      :      " + ObtenerCodigoCto();
   }

   /**
    * Metodo para la creacion de los hijos de la raiz
    * @param exp  Expresion a la cual se va a buscar el operador
    * @param nivel Nivel de la expresion, posicion para comunicar los metodos
    *              de separadores cuando se encuentran mas de un separador
    * @param operadores  Cadena de caracteres para la jerarquia de operadores
    * @param l     Determinar si es hijo izquierdo(true) o derecho(false)
    * @return Nodo del arbol
    */
   private TreeNode SepararExp(String exp,int nivel,String operadores,boolean l) {
    if(exp.trim().length() == 0) return null;
    char[] ops = operadores.toCharArray();
    int ajg = 0;
    boolean aux = false;
    for(char a : ops)
     for(int i=ajg;i<exp.length();i++)
      if(Character.isMirrored(exp.charAt(i))){
        if(i == 0) aux = true;
        switch(exp.charAt(i)){
            case '{': i = Separador(exp.substring(i+1),'}',i); break;
            case '[': i = Separador(exp.substring(i+1),']',i); break;
            case '(': i = Separador(exp.substring(i+1),')',i); break;
          }
        if(i == exp.length()-1 && aux) return SepararExp(exp.substring(1,i),nivel,operadores,l);
        else{
          if(aux) ajg = i;
         aux=false; continue;}
      }
      else{
        if(exp.charAt(i) == a)
          return new TreeNode(exp,nivel,i,operadores,l);
      }
    return new TreeNode(exp,nivel,0,operadores,l);
  }

   /**
    * Buscar el cierre del separador si encuentra uno abierto
    * @param exp Expresion donde se va a buscar el cierre
    * @param cierre Separador de cierre que se va a buscar
    * @param nivel Nivel de la expresion, posicion para comunicar los metodos
    *              de separadores cuando se encuentran mas de un separador
    * @return Indice donde se encuentra el cierre del separador
    */
   private int Separador(String exp,char cierre,int nivel){
   int aux=0;
   for(int i=0;i<exp.length();i++)
   { if(Character.isMirrored(exp.charAt(i)))
     {  if(exp.charAt(i) == cierre) return i+1+nivel;
        switch(exp.charAt(i)){
            case '{': i = Separador(exp.substring(i+1),'}',i);
            case '[': i = Separador(exp.substring(i+1),']',i);
            case '(': i = Separador(exp.substring(i+1),')',i);
       }
     }
     aux = i;
   }
   //System.out.println(exp+" : "+nivel+" : "+aux+" : "+(aux+nivel));
   return aux+nivel;
  }

// <editor-fold defaultstate="collapsed" desc="Metodos Simples">
    public void NuevaExpresion(String exp) {  expresion = exp;  }

    public void CodigodeActivacion(String cod) {  codigo = cod;  }

    public String ObtenerCodigo() {   return codigo.substring(1);  }

    public String ObtenerCodigoCto() {  return codigo;  }

    public void NuevoCodigo(String cod) {  codigo = cod;  }

    public String ObtenerExpresion() {  return expresion;  }

    public char ObtenerOperador() {  return operador;  }

    public void NuevaOperacion(String op) {operacion = op;  }

    public TreeNode ObtenerHijoIzq(){ return hizq;}

    public TreeNode ObtenerHijoDer(){ return hder;}

    public String ObtenerOperacion() {  return operacion; }// </editor-fold>

   /**
    *  Crear Codigos de Tres Direcciones
    * @param nro Numero de Operacion
    * @param cod Area de Texto para mostrar la operacion
    * @return indice de la siguiente operacion
    */
   public int TresDirecciones(int nro,JTextArea cod){
      if(isLeaf()) return nro;
      nro = hizq.TresDirecciones(nro,cod);
      nro = hder.TresDirecciones(nro,cod);
      cod.append("OP"+nro+" = "+hizq.ObtenerOperacion()+" "+ObtenerOperador()
              +" "+hder.ObtenerOperacion()+"\n");
      NuevaOperacion("OP"+nro);
      return nro+1;
   }

   public String NPF(){
      String npf = "";
      if(isLeaf())
       if(npf.length() == 0) return expresion;
       else  return npf+","+expresion;
      npf += hizq.NPF()+",";
      npf += hder.NPF();
      return npf+","+ObtenerOperador();
   }

   public String postfija(){
     return (isLeaf()) ? ObtenerExpresion()+" " : hizq.postfija()+hder.postfija()+ObtenerOperador()+" ";
   }
}