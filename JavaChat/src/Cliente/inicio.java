package Cliente;

import de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class inicio extends javax.swing.JFrame {
    public inicio() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("CocodriloChat - Conexión");
        setIconImage(new ImageIcon(getClass().getResource("img/icon.png")).getImage());
        getRootPane().setDefaultButton(bConectar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bConectar = new javax.swing.JButton();
        tServer = new javax.swing.JTextField();
        tNick = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        mArchivo = new javax.swing.JMenu();
        mSalir = new javax.swing.JMenuItem();
        mSeparador = new javax.swing.JMenu();
        mAyuda = new javax.swing.JMenu();
        mAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Servidor");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Nick");

        bConectar.setText("Conectar");
        bConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConectarActionPerformed(evt);
            }
        });

        tServer.setText("kikeex.no-ip.biz");

        tNick.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tNickKeyPressed(evt);
            }
        });

        mArchivo.setText("Archivo");

        mSalir.setText("Salir");
        mSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSalirActionPerformed(evt);
            }
        });
        mArchivo.add(mSalir);

        jMenuBar1.add(mArchivo);

        mSeparador.setText("    ");
        jMenuBar1.add(mSeparador);

        mAyuda.setText("Ayuda");

        mAcercaDe.setText("Acerca de..");
        mAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAcercaDeActionPerformed(evt);
            }
        });
        mAyuda.add(mAcercaDe);

        jMenuBar1.add(mAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tNick, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(tServer, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(bConectar)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(bConectar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConectarActionPerformed
        String server = (String) tServer.getText();
        String nick = tNick.getText();
        if (server.equals("")) {
            JOptionPane.showMessageDialog(null,"Debes ingresar un servidor ", "Oops! Error", JOptionPane.ERROR_MESSAGE);
            this.tServer.requestFocus();
        }else{
            if (nick.equals("")) {
                JOptionPane.showMessageDialog(null,"Debes ingresar un nick ", "Oops! Error", JOptionPane.ERROR_MESSAGE);
                this.tNick.requestFocus();
            }else{
                try {
                    Cliente.IP_SERVER = server;
                    Cliente.nomCliente = nick;
                    VentCliente p = new VentCliente();
                    setVisible(false);
                } catch (IOException ex) {
                    Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_bConectarActionPerformed

    private void tNickKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNickKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String server = (String) tServer.getText();
            String nick = tNick.getText();
            if (server.equals("")) {
                JOptionPane.showMessageDialog(null,"Debes ingresar un servidor ", "Oops! Error", JOptionPane.ERROR_MESSAGE);
            }else{
                if (nick.equals("")) {
                    JOptionPane.showMessageDialog(null,"Debes ingresar un nick ", "Oops! Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    try {
                        Cliente.IP_SERVER = server;
                        Cliente.nomCliente = nick;
                        VentCliente p = new VentCliente();
                        setVisible(false);
                    } catch (IOException ex) {
                        Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_tNickKeyPressed

    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mSalirActionPerformed

    private void mAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAcercaDeActionPerformed
        VentanaAyuda va = new VentanaAyuda();
        va.setVisible(true);
        va.setResizable(false);
    }//GEN-LAST:event_mAcercaDeActionPerformed
    public static void main(String args[]) {
        try{
            UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error en Look And Feel", "Error:" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bConectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mAcercaDe;
    private javax.swing.JMenu mArchivo;
    private javax.swing.JMenu mAyuda;
    private javax.swing.JMenuItem mSalir;
    private javax.swing.JMenu mSeparador;
    private javax.swing.JTextField tNick;
    private javax.swing.JTextField tServer;
    // End of variables declaration//GEN-END:variables
}
