/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler.classes;

/**
 *
 * @author clases
 */
public class Main {
    public static void main(String[] args) {
        
           a: for (int k = 0; k < 3; k++) {

            for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
          
                System.out.println("k = "+k+"   i = "+i+ "   j = "+j);
                if(i==2)
                    continue a;
            }
        }
    }
    }

    
}
