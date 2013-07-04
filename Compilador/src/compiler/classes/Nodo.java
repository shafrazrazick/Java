package compiler.classes;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class Nodo {

   /** Expresion del nodo */ String expresion;
   /** Operacion para tres direcciones*/ String operacion;
   /** Operador que separa la expresion*/ char op;
   /** Booleano para saber si el nodo no tiene hijos*/ boolean hoja;
   /** Hijo izquierdo del nodo*/ Nodo hijoizq;
   /** Hijo derecho del nodo*/ Nodo hijoder;

   /**
    * @param exp Expresion que va a tener el nodo
    */
   public Nodo(String exp){
      expresion = exp;
      String aux, izquierdo, derecho;
      int i = SepararExp(expresion); //Buscar el indice del operador que va a
                                     //separar la expresion
      if(i == -1){                   //Si no hay mas operadores, es hoja
        hijoizq = hijoder = null;
        hoja = true;

      }
      else{

        izquierdo = exp.substring(0,i);
        if(((izquierdo.startsWith("(")) && izquierdo.endsWith(")")) || ((izquierdo.startsWith("[")) &&
                    izquierdo.endsWith("]")) || ((izquierdo.startsWith("{")) && izquierdo.endsWith("}"))){
                    izquierdo = izquierdo.substring(1, izquierdo.length()-1);
                    System.out.println(izquierdo);
        }
        hijoizq = new Nodo(izquierdo);//Expresion izquierda para crear hijo
        derecho = exp.substring(i+1);
        if(((derecho.startsWith("(")) && derecho.endsWith(")")) || ((derecho.startsWith("[")) &&
                    derecho.endsWith("]")) || ((derecho.startsWith("{")) && derecho.endsWith("}"))){
                    derecho = derecho.substring(1, derecho.length()-1);
                    System.out.println(derecho);
        }
        hijoder = new Nodo(derecho);//Expresion derecha para crear hijo
        op = exp.charAt(i);//Establecer el operador
        hoja = false;//No es hoja
      }
      if(esHoja()) EstablecerOperacion(expresion);// Si es hoja la operacion va
                                                  //a ser la expresion
   }

    public Nodo(JEditorPane Exp) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

   /**
    *@param e Expresion a la cual se va a buscar el operador
    (A+P-K)+9=H^[R-(2+B)-C]*7
    */
   private int SepararExp(String e){
        String init = null, fin = null, sig=null;
        int countkey = 0, countblock = 0, countpar = 0;
        boolean openk = false, openb = false, openp = false;
        int ActualIndex = -1;
        int ActualPriority = Integer.MAX_VALUE;
        boolean stop = false;

        int open = 0;
        String aux = "";
        char[] operadores = "=+-*/^".toCharArray();
        aux = e;
        for(char a : operadores)
            for(int i=0;i<aux.length();i++){
                if(aux.charAt(i) == '(' || aux.charAt(i) == '[' || aux.charAt(i) == '{')
                    open++;
                if(aux.charAt(i) == ')' || aux.charAt(i) == ']' || aux.charAt(i) == '}')
                    open--;
                if(aux.charAt(i) == a && open == 0)
                return i;
            }
        return -1;// si no encuentra operador
        
   }

   /**
    * Metodo para determinar si el nodo es hoja o no
    * @return true si es hoja, false caso contrario
    */
   public boolean esHoja(){ return hoja;}

   /**
    * Obtener la operacion, en pocas palabras el OPN
    * @return la operacion
    */
   public String ObtenerOperacion(){  return operacion;}

   /**
    * Establece la operacion que va a tener el nodo
    * @param opn la nueva operacion
    */
   public void EstablecerOperacion(String opn){ operacion = opn; }

   /**
    * Operador que se uso para separar la expresion del nodo
    * @return el operador mencionado
    */
   public char ObtenerOperador(){ return op;}

   /**
    * Metodo para establecer las operaciones de los nodos y los codigos de
    * tres direcciones
    * @param i numero de operacion
    * @param codigos area de texto donde se van a mostrar las operaciones
    * @return numero de operacion siguiente
    */
   public int TresDirecciones(int i, JTextArea codigos){
     if(esHoja()) return i;//Si es hoja no hacer nada

     //Recorrido en postorden, primero izquierda, despues derecha,despues el centro
     i = hijoizq.TresDirecciones(i, codigos);
     i = hijoder.TresDirecciones(i, codigos);
     EstablecerOperacion("OP"+i);
     codigos.append(ObtenerOperacion()+" = "+hijoizq.ObtenerOperacion()+" "+
             ObtenerOperador()+" "+hijoder.ObtenerOperacion()+"\n");
     return i+1;
   }

   
}
