package Cliente;

import java.awt.*;
import javax.swing.*;

public class Avatares extends JPanel{
    private String imagen;
    private int cX,cY;
    public Avatares(String nombre,int x,int y){
        cX=x;
        cY=y;
        imagen=nombre;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon i = new ImageIcon(getClass().getResource(imagen));
        g.drawImage(i.getImage(),0,0,this);
        //g.drawImage(getToolkit().getImage(imagen),0,0,this);
    }
    public void asignar(String i){
        imagen=i;
        repaint();
    }
    public String obtenerNombre(){
        return imagen;
    }
    @Override
    public Dimension getPreferredSize()	{
        return new Dimension(cX,cY);
    }
    @Override
    public Dimension getMinimumSize(){
        return getPreferredSize();
    }
}
