/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Compiladores II
 * José Oberto C.I 20380444
 *
 * Created on 26-sep-2011, 23:44:41
 */

package compiler.view;
import compiler.classes.Acerca;
import compiler.classes.Lexico;
import compiler.classes.Sintactico;
import compiler.classes.Arbol;
import compiler.classes.Nodo;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import java.awt.AWTException;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Administrador
 */
public class TextDeveloperView extends javax.swing.JFrame {
    

    static  TextDeveloperView view;
    public static String FONT_FACE = "Arial";
    public static String FONT_COLOR = "black";
    public static int FONT_SIZE = 12;
    public static int FONT_STYLE = Font.PLAIN;
    public static String originalText, outcommentText;
    //public static int jComboBox2.getSelectedItem(12);
    TreeNode prueba;
    private Acerca w1 = new Acerca();

    /** Creates new form TextDeveloperView */
    public TextDeveloperView() {
        
        initComponents();

        SimpleDateFormat miformato = new SimpleDateFormat("dd/MM/yyyy");
        String Fecha = miformato.format(new Date());
        jTextField3.setText(Fecha);
        

        
      //se declara el objeto tipo icono
        final TrayIcon iconoSystemTray;
        //se verifica que el SystemTray sea soportado
        if (SystemTray.isSupported()) {
            //se obtiene una instancia estática de la clase SystemTray
            SystemTray tray = SystemTray.getSystemTray();
            //esta es la imagen de icono
            Image imagenIcono = Toolkit.getDefaultToolkit().getImage("logo.png");
            //este listener nos permite capturar cualquier tipo de evento
            //que se haga con el mouse sobre el icono
            MouseListener mouseListener = new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Icono del System Tray - Mouse clicked!");
                }
                public void mouseEntered(MouseEvent e) {
                    System.out.println("Icono del System Tray - Mouse entered!");
                }
                public void mouseExited(MouseEvent e) {
                    System.out.println("Icono del System Tray - Mouse exited!");
                }
                public void mousePressed(MouseEvent e) {
                    System.out.println("Icono del System Tray - Mouse pressed!");
                }
                public void mouseReleased(MouseEvent e) {
                    System.out.println("Icono del System Tray - Mouse released!");
                }
            };
            //este listener se asociara con un item del menu contextual
            //que aparece al hacer click derecho sobre el icono
            ActionListener escuchadorSalir = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Saliendo...");
                    System.exit(0);
                    
                }
                
                
            };
            
                ActionListener abridor = new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    
              view.setLocationRelativeTo(null);
              view.setVisible(true);

                    
                    
                }
                
                
            };
            
            
            //menu que aparece al hacer click derecho
            PopupMenu popup = new PopupMenu();
            MenuItem item = new MenuItem("Salir");
            
            MenuItem item2 = new MenuItem("Abrir");
           // item2.setEnabled(false);
            item2.addActionListener(abridor);
            item.addActionListener(escuchadorSalir);
            popup.add(item2);
            popup.addSeparator();
            popup.add(item);
            
            
            //iniciamos el objeto TrayIcon
            iconoSystemTray = new TrayIcon(imagenIcono, "Monster Compiler V 2.0", popup);
            //este tipo de listener captura el doble click sobre el icono
            ActionListener accionMostrarMensaje = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    iconoSystemTray.displayMessage("¡Bienvenido!",
                            "Espero que Monster Compiler te dea de utilidad! :)",
                            
                            TrayIcon.MessageType.INFO);
                }
            };
 
            iconoSystemTray.setImageAutoSize(true);
            iconoSystemTray.addActionListener(accionMostrarMensaje);
            iconoSystemTray.addMouseListener(mouseListener);
 
            //se debe capturar una excepción en caso que falle la adicion de un icono
            try {
                tray.add(iconoSystemTray);
            } catch (AWTException e) {
                System.err.println("No es posible agregar el icono al System Tray");
            }
        }
        else
            System.err.println("Tu sistema no soporta el System Tray");

                
        
        

        

    }
    


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ExpInput = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImages(null);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/monitor.png"))); // NOI18N
        jButton6.setToolTipText("Ejecutar Analisis Lexico");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/mano2.png"))); // NOI18N
        jButton5.setToolTipText("Ejecutar Analisis Sintactico");
        jButton5.setMaximumSize(new java.awt.Dimension(70, 50));
        jButton5.setMinimumSize(new java.awt.Dimension(70, 50));
        jButton5.setPreferredSize(new java.awt.Dimension(70, 50));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/delete.png"))); // NOI18N
        jButton4.setToolTipText("Borrar casillas");
        jButton4.setPreferredSize(new java.awt.Dimension(70, 50));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/arbol.png"))); // NOI18N
        jButton3.setToolTipText("Construir Arbol");
        jButton3.setPreferredSize(new java.awt.Dimension(70, 50));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/save.png"))); // NOI18N
        jButton2.setToolTipText("Guardar archivo");
        jButton2.setPreferredSize(new java.awt.Dimension(70, 50));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/open.png"))); // NOI18N
        jButton1.setToolTipText("Abrir archivo");
        jButton1.setPreferredSize(new java.awt.Dimension(70, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane1.setViewportView(jEditorPane1);

        jTabbedPane1.addTab("     EDITOR      ", jScrollPane1);

        jLabel11.setText("Todas Las Palabras");

        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });

        jLabel12.setText("Palabras simples");

        jLabel13.setText("Palabras compuestas");

        jLabel14.setText("Errores Sintacticos");

        jLabel15.setText("Expresion matematica");

        ExpInput.setColumns(20);
        ExpInput.setRows(5);
        jScrollPane4.setViewportView(ExpInput);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox12, 0, 0, Short.MAX_VALUE)
                                .addComponent(jComboBox10, 0, 0, Short.MAX_VALUE)
                                .addComponent(jComboBox11, 0, 0, Short.MAX_VALUE)))))
                .addGap(159, 159, 159))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ANALISIS SINTACTICO", jPanel2);

        jLabel1.setText("Longitud de la cadena original: ");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel3.setText("Programa fuente sin comentarios:");

        jLabel2.setText("Comentarios:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Numero de espacios en blanco/saltos de linea/saltos de carro:");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Programa fuente sin espacios en blanco:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel6.setText("Letras:");

        jLabel7.setText("Numeros:");

        jLabel8.setText("Operadores:");

        jLabel9.setText("Separadores:");

        jLabel10.setText("Errores:");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane3))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox5, 0, 120, Short.MAX_VALUE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.TRAILING, 0, 120, Short.MAX_VALUE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(464, 464, 464)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel5)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(44, 44, 44))
        );

        jTabbedPane1.addTab("ANALISIS LEXICO", jPanel3);

        jScrollPane5.setViewportView(jTree1);

        jTextArea3.setColumns(20);
        jTextArea3.setEditable(false);
        jTextArea3.setRows(5);
        jTextArea3.setEnabled(false);
        jTextArea3.setOpaque(false);
        jScrollPane6.setViewportView(jTextArea3);

        jLabel16.setText("Arbol");

        jLabel17.setText("Tres Direcciones");

        jLabel18.setText("Notacion Postfija");

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setEnabled(false);
        jTextArea4.setOpaque(false);
        jScrollPane7.setViewportView(jTextArea4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                    .addComponent(jLabel16)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("     ARBOL     ", jPanel4);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/monster.png"))); // NOI18N

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/help.png"))); // NOI18N
        jButton7.setToolTipText("Construir Arbol");
        jButton7.setPreferredSize(new java.awt.Dimension(70, 50));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19))
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Editor
        jEditorPane1.setText("");
        
        //Sintactico
        ExpInput.setText("");
        jComboBox9.removeAllItems();
        jComboBox10.removeAllItems();
        jComboBox11.removeAllItems();
        jComboBox12.removeAllItems();
        
        //Lexico
        jTextField1.setText("");
        jTextArea1.setText("");
        jTextField2.setText("");
        jTextArea2.setText("");
        jComboBox3.removeAllItems();
        jComboBox4.removeAllItems();
        jComboBox5.removeAllItems();
        jComboBox6.removeAllItems();
        jComboBox7.removeAllItems();
        
        //Arbol
        jTextArea3.setText("");
        jTextArea4.setText("");
        jTextField4.setText("");
        DefaultMutableTreeNode Root = new DefaultMutableTreeNode("Nodo");
        Root.add(new DefaultMutableTreeNode("Hijo"));
        jTree1.setModel(new DefaultTreeModel(Root));
        
       
        
        //Regresar a pestaña Editor
        this.jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    if (jEditorPane1.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Escriba alguna exprecion en la pestaña Editor para crear el Analisis Lexico.", "Campo Editor vacio", JOptionPane.ERROR_MESSAGE);
    }else{
        this.jTabbedPane1.setSelectedIndex(2);
        originalText = this.jEditorPane1.getText();
        this.jTextField1.setText(String.valueOf(originalText.length()));
        ArrayList aux = new Lexico().getComents(originalText);
        Iterator i = aux.iterator();
        this.jComboBox3.removeAllItems();
        outcommentText = originalText;
        while(i.hasNext()){
            String commentx = i.next().toString();
            this.jComboBox3.addItem(commentx);
            outcommentText = outcommentText.replace(commentx, "");
        }
        this.jTextArea1.setText(outcommentText.replace("@", ""));
        this.jTextField2.setText(String.valueOf(new Lexico().getSpacesNumber(originalText)));
        this.jTextArea2.setText(new Lexico().deleteSpaces(outcommentText));
        new Lexico().verifyCharacters(new Lexico().deleteSpaces(outcommentText), this.jComboBox4,
                this.jComboBox5, this.jComboBox6, this.jComboBox7, this.jComboBox8);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    if (jEditorPane1.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Escriba alguna exprecion en la pestaña Editor para crear el Analisis Sintactico.", "Campo Editor vacio", JOptionPane.ERROR_MESSAGE);
    }else{
        this.jTabbedPane1.setSelectedIndex(1);
        String outcomment = "";
        String code = this.jEditorPane1.getText();
        ArrayList aux = new Lexico().getComents(code);
        Iterator i = aux.iterator();
        outcomment = code;
        while(i.hasNext()){
            String commentx = i.next().toString();
            outcomment = outcomment.replace(commentx, "");
        }
        this.jTextArea1.setText(outcomment.replace("@", ""));
        new Sintactico().addWords(outcomment.replaceAll("\n", " ").
                replaceAll("\t", " ").replaceAll("\r", " "),
                jComboBox9, jComboBox10, jComboBox11, jComboBox12);
        this.ExpInput.setText(new Sintactico().getMathExpression(outcomment.replace(" ", "")));
        }
    }//GEN-LAST:event_jButton5ActionPerformed
static TreeSet Variables = new TreeSet();
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //ExpInput
        if (ExpInput.getText().trim().isEmpty()) {//Valida si el ExpInput esta vacio
                    //DefaultMutableTreeNode Root = new DefaultMutableTreeNode("Escriba su Expresion");
                    //Root.add(new DefaultMutableTreeNode("En el Editor"));
                    //jTree1.setModel(new DefaultTreeModel(Root));
                    //JOptionPane.showMessageDialog(null, "Escriba alguna exprecion en la pestaña Editor para generar el Arbol. (Expresion)", "Campo Editor vacio", JOptionPane.ERROR_MESSAGE);
            if(jEditorPane1.getText().trim().isEmpty()) {//Valida si el jEditorPane1 esta vacio
                    DefaultMutableTreeNode Root = new DefaultMutableTreeNode("Escriba su Expresion");
                    Root.add(new DefaultMutableTreeNode("En el Editor"));
                    jTree1.setModel(new DefaultTreeModel(Root));
                    JOptionPane.showMessageDialog(null, "Escriba alguna exprecion en la pestaña Editor para generar el Arbol.", "Campo Editor vacio", JOptionPane.ERROR_MESSAGE);
            } else {                       
                try {
                    this.jTabbedPane1.setSelectedIndex(3);
                    this.jTextArea4.setText("");
                    this.jTextArea3.setText("");
                    new Arbol().Arborize(jEditorPane1.getText(), jTree1, jTextArea4);
                } catch (NullPointerException E) {
                    System.out.println("null pointer");                
                }                    
        
                for(int i = 0; i < jEditorPane1.getText().length(); i++)
                    {
                        char c = jEditorPane1.getText().charAt(i);
                        if (Character.isLetter(c))
                            Variables.add(c);
                    }
            Nodo td = new Nodo(this.jEditorPane1.getText().replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll(" ", ""));//CREA EL NODO RAIZ DEL ARBOL
            jTextArea3.setVisible(true);//VUELVE VISIBLE LA JTEXTAREA, NO SE XQ, PERO NECESARIO
            td.TresDirecciones(1, jTextArea3);//LLAMA AL METODO DE CREACION DE 3DIRECCIONES        
        
            }
            
        } else {
            try {
                this.jTabbedPane1.setSelectedIndex(3);
                this.jTextArea4.setText("");
                this.jTextArea3.setText("");
                new Arbol().Arborize(ExpInput.getText(), jTree1, jTextArea4);
            } catch (NullPointerException E) {
                System.out.println("null pointer");                
            }                    
        
            for(int i = 0; i < ExpInput.getText().length(); i++)
                {
                    char c = ExpInput.getText().charAt(i);
                    if (Character.isLetter(c))
                        Variables.add(c);
                }
        Nodo td = new Nodo(this.ExpInput.getText().replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll(" ", ""));//CREA EL NODO RAIZ DEL ARBOL
        jTextArea3.setVisible(true);//VUELVE VISIBLE LA JTEXTAREA, NO SE XQ, PERO NECESARIO
        td.TresDirecciones(1, jTextArea3);//LLAMA AL METODO DE CREACION DE 3DIRECCIONES
        }       
       
        jTextArea3.setVisible(false);
        jTextArea4.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    public String notpost(TreeNode nodo){
     if(nodo.isLeaf()) return nodo.ObtenerExpresion()+",";
     return notpost(nodo.ObtenerHijoIzq())+notpost(nodo.ObtenerHijoDer())
             +""+nodo.ObtenerOperador()+",";
   }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String Text="";
       String Todo="";
       JFileChooser fc=new JFileChooser(System.getProperty("user.dir"));
       FileNameExtensionFilter filter1 = new FileNameExtensionFilter("MonsterCo (*.mnstr)", "mnster");
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto plano (*.txt)", "txt");
       fc.setFileFilter(filter);
       fc.setFileFilter(filter1);
       int returnVal = fc.showOpenDialog(this);
           File Abrir=fc.getSelectedFile();
            try{
               if(returnVal == JFileChooser.APPROVE_OPTION) {
                   ExpInput.setText("");
                   FileReader Fichero=new FileReader(Abrir);
                   BufferedReader leer=new BufferedReader(Fichero);
                        while((Text=leer.readLine())!=null){
                            System.out.println(Text);
                            Todo=Todo+Text+"\n";
                            jEditorPane1.setText(Todo); //append Concatena la linea leida
                            jTextField4.setText("Abierto: " +fc.getSelectedFile().getName());
                            }
                    leer.close();
                }
              }
          catch(IOException ioe){
            //System.out.println(ioe);
            JOptionPane.showMessageDialog(null, ioe, "Error", JOptionPane.ERROR_MESSAGE);
            }
            
           
            
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       JFileChooser fc=new JFileChooser(System.getProperty("user.dir"));
       fc.setAcceptAllFileFilterUsed(false);
       fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
       fc.setCurrentDirectory (new File ("."));
       fc.setSelectedFile(new File(".jcp"));
       FileNameExtensionFilter filter1 = new FileNameExtensionFilter("MonsterCo (*.mstr)", "mstr");
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto plano (*.txt)", "txt");
       fc.setFileFilter(filter);
       fc.setFileFilter(filter1);
       int returnVal = fc.showSaveDialog(this);   //Muestra el diálogo
       if(returnVal == JFileChooser.APPROVE_OPTION) { 
           File fFile =  fc.getSelectedFile ();
       if (fFile.exists ()) {
           int response = JOptionPane.showConfirmDialog (null, "¿Desea sobreescribir el archivo?","El archivo ya existe", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
           if (response == JOptionPane.CANCEL_OPTION) return;
       }
       try {
           PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter (fFile)));
           out.print (jEditorPane1.getText());
           out.flush ();
           out.close ();
   } catch (Exception ioe) { 
       JOptionPane.showMessageDialog(null, ioe, "Error", JOptionPane.ERROR_MESSAGE);
       return;
   } 
       JOptionPane.showMessageDialog(null, "El archivo " + fc.getSelectedFile().getName() + " se guardo con exito.", "Guardado con exito", JOptionPane.INFORMATION_MESSAGE);         

//        if (jEditorPane1.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Escriba alguna exprecion en el Editor. Para generar Notacion Postfifa del Arbol.");
//            //System.out.println("No hay datos que validar");
//        }else{
//        //this.jTabbedPane1.setSelectedIndex(3);
//        //this.jTextArea4.setText("");
//        char Car;
//        int aux1, aux2;
//        String todo;
//        String Exp = this.jEditorPane1.getText();  //PARA CONSEGUIR LA EXP
//        Stack<Object> PilaVariable = new Stack<Object>();
//        Stack<Postfijo> PilaOperador = new Stack<Postfijo>();
//        String Izquierda = Exp.substring(0, Exp.indexOf("="));
//        String Derecha = Exp.substring(Exp.indexOf("=")+1);
//        System.out.println(Izquierda);
//        System.out.println(Derecha);
//        
//        todo = "IZQUIERDA\n"+Izquierda +"\n"+ "\nDERECHA\n" +Derecha+"\n";
//        jTextArea4.setText(todo);
//        
//        for(int i=0; i<Izquierda.length(); i++){
//            if(Character.isLetter(Izquierda.charAt(i))){
//                PilaVariable.push(Izquierda.charAt(i));
//                System.out.println("LETRA");
//                System.out.println(PilaVariable.size());
//                
//                todo = todo +"\nLETRA\n"+ PilaVariable.size();
//                jTextArea4.setText(todo);
//            }
//            else{ PilaOperador.push(new Postfijo(Izquierda.charAt(i))); 
//            System.out.println("OPERADOR");
//            todo = todo + "\nOPERADOR\n";
//            
//            }
//            if(PilaOperador.size() == 2){
//                aux1 = PilaOperador.lastElement().getPrioridad();
//                aux2 = PilaOperador.firstElement().getPrioridad();
//                if(aux2 > aux1){
//                    String NuevaVariable = PilaVariable.pop().toString()+PilaOperador.pop().toString()+PilaVariable.pop().toString();
//                    todo = todo + NuevaVariable;
//                    System.out.println ("Nueva Variable: " + NuevaVariable);
//                    jTextArea4.setText(NuevaVariable);
//                    
//                }
//            }
//            else continue;
//        }
      }
    }//GEN-LAST:event_jButton2ActionPerformed

private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jComboBox9ActionPerformed

private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jTextField4ActionPerformed

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
w1.setVisible(true);
w1.setLocationRelativeTo(null);
        // TODO add your handling code here:
}//GEN-LAST:event_jButton7ActionPerformed
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        
try
        {
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error en Look And Feel",
                                          "Error:" + ex.getMessage(),
                                          JOptionPane.ERROR_MESSAGE);
            
         
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
                
                view = new TextDeveloperView();
                view.setLocationRelativeTo(null);
                view.setVisible(true);
                view.setTitle("Monster Compiler V 2.0");
                view.setIconImage(new ImageIcon("logo.png").getImage());
                view.setResizable(false);      
                DefaultMutableTreeNode Root = new DefaultMutableTreeNode("Nodo");
                Root.add(new DefaultMutableTreeNode("Hijo"));
                
                view.jTree1.setModel(new DefaultTreeModel(Root));
                
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ExpInput;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

  
}
