package compiler.classes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Postfijo {
    char Operador;
    int Prioridad;
    char Arreglo[] = "+-*/^".toCharArray();
    public Postfijo(char Operador){
        this.Operador = Operador;
        for(int i=0; i<5; i++){
            if(Operador == Arreglo[i])
                this.Prioridad = i+1;
        }
    }

    public char getOperador(){
        return Operador;
    }

    public int getPrioridad(){
        return Prioridad;
    }
}
