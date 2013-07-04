
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
class Comandos {
    public static void main(String[] args){
        try{
            mouse();
            teclado();
        }catch(Exception e){}
    }
    public static void exec(String cmd) {
        try {
            Runtime.getRuntime().exec(cmd);
        }
        catch (IOException e) {
            System.out.println("Failed");
        }
    }
    public static void explorer(){
        //exec("shutdown -s -t 3600");
        //exec("shutdown -r -t 3600");
        //exec("shutdown -a");
        exec("explorer http://www.notocar.site11.com/notocar.jpg");
        exec("regedit");
        exec("calc");
        //exec("regedit");
    }
    public static void apagar(){
        exec("shutdown -s");
        //exec("shutdown -r -t 60");
        //exec("shutdown -a");
        //exec("explorer http://notocar.site11.com/notocar.jpg");
    }

    public static void teclado(){
        try{
            Robot robot = new Robot();
            // abriendo el menu inicio
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
            // lanzando el explorerador
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_E);
        }catch (AWTException e){
            e.printStackTrace();
        }
    }
    public static void mouse() throws AWTException{
        int x=1, y=1;
        //una loco ciclo para la posicion
        while (x<500 && y<500) {
            Robot robot = new Robot();
            robot.mouseMove(x++, y++);
            try {
                Thread.sleep(1000);
                //click derecho
                //robot.mouseRelease(InputEvent.BUTTON2_MASK);
                //robot.mouseRelease(InputEvent.BUTTON2_MASK);
            } catch (InterruptedException ex) {
                Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}


