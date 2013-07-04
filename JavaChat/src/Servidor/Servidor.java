package Servidor;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

class Servidor extends JFrame{
    JTextArea txaMostrar;
    TrayIcon ti;

    private void mostrar(){
        setVisible(true);
        SystemTray.getSystemTray().remove(ti);
        this.toFront();
        this.setState(Frame.NORMAL);
    }
    public Servidor(){
        super("Consola servidor");
        txaMostrar=new JTextArea();
        txaMostrar.setEditable(false);
        setContentPane(new JScrollPane(txaMostrar));
        setSize(350,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Image i = new ImageIcon(getClass().getResource("/logo.png")).getImage();
        setLocationRelativeTo(null);
        setIconImage(i.getScaledInstance(16, 16, Image.SCALE_AREA_AVERAGING));
        ti = new TrayIcon(i.getScaledInstance(16, 16, Image.SCALE_AREA_AVERAGING));
        ti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrar();
            }
        });
        ti.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrar();
            }
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        this.addWindowListener(new WindowListener() {
            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) {}
            @Override public void windowClosed(WindowEvent e) {}
            @Override
            public void windowIconified(WindowEvent e) {
                if(SystemTray.isSupported()){
                    setVisible(false);
                    try {
                        SystemTray.getSystemTray().add(ti);
                    } catch (AWTException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}
        });
    }
    public void mostrar(String msg){
        txaMostrar.append(msg+"\n");
        txaMostrar.setCaretPosition(txaMostrar.getDocument().getLength());
    }
    public void runServer(){
        ServerSocket serv=null;//para comunicacion
        ServerSocket serv2=null;//para enviar mensajes
        boolean listening=true;
        try{
            serv=new ServerSocket(8081);
            serv2=new ServerSocket(8082);
            mostrar(".::Servidor activo :");
            while(listening){
                Socket sock=null,sock2=null;
                try {
                    mostrar("Esperando Usuarios");
                    sock=serv.accept();
                    sock2=serv2.accept();
                } catch (IOException e){
                    mostrar("Accept failed: " + serv + ", " + e.getMessage());
                    continue;
                }
                threadServidor user=new threadServidor(sock,sock2,this);
                user.start();
            }
        }catch(IOException e){
            mostrar("error :"+e);
        }
    }
    public static void main(String abc[]) throws IOException{
        Servidor ser= new Servidor();
        ser.runServer();
    }
}