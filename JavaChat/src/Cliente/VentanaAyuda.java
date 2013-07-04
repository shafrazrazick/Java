package Cliente;

import javax.swing.*;
import java.net.URL;

public class VentanaAyuda extends JFrame{
    JScrollPane panelPrincipal;
    JEditorPane html;
    
    public VentanaAyuda() {
        super("Acerca de CocodriloChat:");
        setSize(600,700);
        setLocation(450,0);
        panelPrincipal=new JScrollPane();
        try{ 
            URL url=getClass().getResource("/index.html");
            html=new JEditorPane(url);
            html.setEditable(false);
            setVisible(true);
        }catch(Exception e){
            e.getMessage();
        }
        JViewport jv=panelPrincipal.getViewport();
        jv.add(html);
        setContentPane(panelPrincipal);
    }
}
