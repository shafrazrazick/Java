package Cliente;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class ImagesFond extends javax.swing.JFrame implements ActionListener {
    private javax.swing.JButton avat1;
    private javax.swing.JButton avat2;
    private javax.swing.JButton avta3;
    private javax.swing.JButton avta4;
    private javax.swing.JButton avta5;
    private javax.swing.JButton avta6;
    private javax.swing.JButton avta7;
    private javax.swing.JButton avta8;
    private javax.swing.JPanel jPanel1;
    
    public ImagesFond() {
        initComponents();
        setTitle("Seleccionar Avatares");
        setIconImage(new ImageIcon("logo.png").getImage());
        setResizable(false);
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        avat1 = new javax.swing.JButton();
        avat2 = new javax.swing.JButton();
        avta3 = new javax.swing.JButton();
        avta4 = new javax.swing.JButton();
        avta5 = new javax.swing.JButton();
        avta6 = new javax.swing.JButton();
        avta8 = new javax.swing.JButton();
        avta7 = new javax.swing.JButton();
        jPanel1.setBackground(Color.red);
        
        avat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/avatars/avatar1.jpg"))); // NOI18N
        avat1.addActionListener(this);

        avat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/avatars/avatar2.jpg"))); // NOI18N
        avat2.addActionListener(this);

        avta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/avatars/avatar3.jpg"))); // NOI18N
        avta3.addActionListener(this);

        avta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/avatars/avatar4.jpg"))); // NOI18N
        avta4.addActionListener(this);

        avta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/avatars/avatar5.jpg"))); // NOI18N
        avta5.addActionListener(this);

        avta6.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/avatars/avatar6.jpg"))); // NOI18N
        avta6.addActionListener(this);

        avta8.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/avatars/avatar7.jpg"))); // NOI18N
        avta8.addActionListener(this);

        avta7.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/avatars/linux.jpg"))); // NOI18N
        avta7.addActionListener(this);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avta5, 0, 0, Short.MAX_VALUE)
                    .addComponent(avat1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(avat2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(avta6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(avta3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avta4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(avta8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(avta7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avat2)
                    .addComponent(avat1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avta3)
                    .addComponent(avta4))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(avta6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(avta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(avta8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(avta7, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if(evt.getSource()==avat1){
            VentCliente.nomImage="img/avatars/avatar1.jpg";
        } if(evt.getSource()==avat2){
            VentCliente.nomImage="img/avatars/avatar2.jpg";
        }if(evt.getSource()==avta3){
            VentCliente.nomImage="img/avatars/avatar3.jpg";
        } if(evt.getSource()==avta4){
            VentCliente.nomImage="img/avatars/avatar4.jpg";
        }if(evt.getSource()==avta5){
            VentCliente.nomImage="img/avatars/avatar5.jpg";
        }if(evt.getSource()==avta6){
            VentCliente.nomImage="img/avatars/avatar6.jpg";
        }if(evt.getSource()==avta7){
            VentCliente.nomImage="img/avatars/linux.jpg";
        } if(evt.getSource()==avta8){
            VentCliente.nomImage="img/avatars/avatar7.jpg";
        }

        VentCliente.avatar.asignar(VentCliente.nomImage);
        setVisible(false);
    }
}
