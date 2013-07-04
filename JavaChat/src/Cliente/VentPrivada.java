package Cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class VentPrivada extends JFrame implements ActionListener{
    private Emoticones emo=new Emoticones();
    private JTextPane panMostrar;
    private JTextField txtMensage;
    private JButton butEnviar;
    private Cliente cliente;
    private String amigo="";
    
    public VentPrivada(Cliente cliente){
        super("Amigo");
        setLayout(new BorderLayout());
        setSize(300,300);
        setLocation(570,90);
        
        this.cliente=cliente;
        txtMensage = new JTextField(30);
        txtMensage.addActionListener(this);
        butEnviar = new JButton("Enviar");
        butEnviar.addActionListener(this);
        panMostrar = new JTextPane(); 
        panMostrar.setEditable(false);

        JPanel panAbajo = new JPanel();
        panAbajo.setLayout(new BorderLayout());
        panAbajo.add(new JLabel("  Ingrese mensage a enviar:"), BorderLayout.NORTH);
        panAbajo.add(txtMensage, BorderLayout.CENTER);
        panAbajo.add(butEnviar, BorderLayout.EAST);
        
        add(new JScrollPane(panMostrar),BorderLayout.CENTER);
        add(panAbajo,BorderLayout.SOUTH);
        addWindowListener(new WindowListener(){         
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
            }
            @Override
            public void windowClosed(WindowEvent e) {}
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        
        txtMensage.requestFocus();
    }
    public void setAmigo(String ami){      
        this.amigo=ami;
        this.setTitle(ami);      
    }
    private void cerrarVentana(){       
        this.setVisible(false);      
    }
    public void mostrarMsg(String msg){
        try {
            Document chat = panMostrar.getDocument();
            String user = msg.substring(0, msg.indexOf("> ")+2);
            msg = msg.replace(user, "");
            SimpleAttributeSet attrb = new SimpleAttributeSet();
            StyleConstants.setBold(attrb, true);
            StyleConstants.setForeground(attrb, Color.red);
            chat.insertString(chat.getLength(), user, attrb);
            if(emo.hayEmoticos(msg)){
                emo.getEmo(msg, panMostrar);
            }else{
                String oldText = this.panMostrar.getText();
                String newText = oldText + msg;
                this.panMostrar.setText(newText);
            }
            chat.insertString(panMostrar.getDocument().getLength(), "\n", null);
            panMostrar.setCaretPosition(chat.getLength());
        } catch (BadLocationException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String mensaje = txtMensage.getText();              
        mostrarMsg(cliente.getNombre()+"> "+mensaje);
        cliente.flujo(amigo,mensaje);
        txtMensage.setText("");
    }
}
