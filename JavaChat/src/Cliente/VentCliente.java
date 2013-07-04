package Cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.JOptionPane.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class VentCliente extends JFrame implements ActionListener {
    static Avatares avatar;
    static String nomImage="/logo.png";
    private Emoticones emo=new Emoticones();
    private JTextPane panMostrar;
    private JTextField txtMensage;
    private JButton butEnviar;
    private JLabel lblNomUser;
    private JList lstActivos;
    private JButton butPrivado, butactualiza;
    private Cliente cliente;	
    private JMenuBar barraMenu;
    private JMenu JMAyuda;
    private JMenuItem help;
    private VentanaAyuda va;
    private Vector<String> nomUsers;
    private VentPrivada ventPrivada;
    
    public VentCliente() throws IOException {
        super("CocodriloChat V 1.0");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setLayout(new BorderLayout());
        setSize(450, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("img/icon.png")).getImage());
        setVisible(true);
        
        txtMensage = new JTextField(30);
        txtMensage.addActionListener(this);
        
        lblNomUser = new JLabel("Usuario <<  >>");
        lblNomUser.setHorizontalAlignment(JLabel.CENTER);
        
        butEnviar = new JButton("Enviar");
        //butEnviar.setIcon(new ImageIcon("img/E-Mail.png") );
        butEnviar.addActionListener(this);
        
        lstActivos=new JList();
        
        butPrivado=new JButton("Privado");
        butPrivado.setIcon(new ImageIcon("/Cliente/img/Users.png") );
        butPrivado.addActionListener(this);
       
        help=new JMenuItem("Acerca de");
        help.setActionCommand("help");
        help.addActionListener(this);
        
        JMAyuda=new JMenu("Ayuda");
        JMAyuda.add(help);
        
        butactualiza=new JButton ("Actualizar");
        butactualiza.addActionListener(this);
        
        barraMenu=new JMenuBar();
        barraMenu.add(JMAyuda);
        barraMenu.add(butactualiza);
        
        avatar= new Avatares (nomImage,131,131);
        avatar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased( MouseEvent event )            {
               checkForTriggerEvent( event );
            }
            private void checkForTriggerEvent( MouseEvent event ){
               new ImagesFond().setVisible(true);
               ImagesFond.setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);
            }
        });
        
        panMostrar = new JTextPane();
        panMostrar.setEditable(false);            
        panMostrar.setForeground(Color.BLUE);
        panMostrar.setBorder(javax.swing.BorderFactory.createMatteBorder(3,3,3,3,new Color(25,10,80)));		
        
        JPanel panAbajo = new JPanel();
        panAbajo.setLayout(new BorderLayout());
        panAbajo.add(new JLabel("Ingrese mensage a enviar:"),BorderLayout.NORTH);
        panAbajo.add(txtMensage, BorderLayout.CENTER);
        panAbajo.add(butEnviar, BorderLayout.EAST);
        
        JPanel panRight = new JPanel();
        panRight.setLayout(new BorderLayout());
        panRight.add(lblNomUser, BorderLayout.NORTH);
        panRight.add(new JScrollPane(panMostrar), BorderLayout.CENTER);
        panRight.add(panAbajo,BorderLayout.SOUTH);
        
        JPanel panLeft=new JPanel();
        panLeft.setLayout(new BorderLayout());
        panLeft.add(new JScrollPane(this.lstActivos),BorderLayout.CENTER);
        panLeft.add(this.butPrivado,BorderLayout.NORTH);
        panLeft.add(this.avatar,BorderLayout.PAGE_END);
        
        JSplitPane sldCentral=new JSplitPane();
        sldCentral.setDividerLocation(100);
        sldCentral.setDividerSize(7);
        sldCentral.setOneTouchExpandable(true);
        sldCentral.setLeftComponent(panLeft);
        sldCentral.setRightComponent(panRight);
        
        add(sldCentral, BorderLayout.CENTER);   
        add(barraMenu,BorderLayout.NORTH);
        
        cliente=new Cliente(this);
        cliente.conexion();     
        nomUsers=new Vector();
        ponerActivos(cliente.pedirUsuarios());
        ventPrivada=new VentPrivada(cliente);
        
        txtMensage.requestFocus();//pedir el focus	
        //String smyles[]={":)",";)",":D",";D",">:(",":(",":o","8)","???","::)",":P",":-[",":-X",":-\\",":-*",":'("};
    }
    public void setNombreUser(String user){
        lblNomUser.setText("Usuario: " + user);
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
    private void ponerActivos(Vector datos){
        nomUsers=datos;
        ponerDatosList(this.lstActivos,nomUsers);
    }
    public void agregarUser(String user){
        nomUsers.add(user);
        ponerDatosList(this.lstActivos,nomUsers);
        avatar.asignar(nomImage);
    }
    public void retirraUser(String user){
        nomUsers.remove(user);
        ponerDatosList(this.lstActivos,nomUsers);
    }
    private void ponerDatosList(JList list,final Vector datos){
        list.setModel(new AbstractListModel() {
            @Override
            public int getSize() {
                return datos.size();
            }
            @Override
            public Object getElementAt(int i){
                return datos.get(i);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        String comand=(String)evt.getActionCommand();
        if(comand.compareTo("help")==0){
            va=new VentanaAyuda();
            va.setVisible(true);
        }
        if(evt.getSource()==this.butEnviar || evt.getSource()==this.txtMensage){
            String mensaje = txtMensage.getText();        
            cliente.flujo(mensaje);
            txtMensage.setText("");
        }else if(evt.getSource()==this.butPrivado){
            int pos=this.lstActivos.getSelectedIndex();
            if(pos>=0){
                ventPrivada.setAmigo(nomUsers.get(pos));           
                ventPrivada.setVisible(true);
            }
        }
        if (evt.getSource()==this.butactualiza){//ACTUALIZAR!!!!!!!!
            ponerActivos(cliente.pedirUsuarios());
            ponerDatosList(lstActivos,nomUsers);
        }
    }
    public void mensageAmigo(String amigo,String msg){
        ventPrivada.setAmigo(amigo);           
        ventPrivada.mostrarMsg(msg);        
        ventPrivada.setVisible(true);
    }
}