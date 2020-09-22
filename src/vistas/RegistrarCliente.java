/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Victor
 */
public class RegistrarCliente extends javax.swing.JFrame {

    String user;

    /**
     * Creates new form RegistrarCliente
     */
    public RegistrarCliente() {
        initComponents();
        user = Login.user;

        setTitle("Registro de clientes- sesion de " + user);
        setSize(530, 350);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // metodo para cambiar el fono de pantalla de la interfas 
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel1_walpaper.getWidth(), jLabel1_walpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel1_walpaper.setIcon(icono);
        this.repaint();

    }

    /// esto solo cambia el icono de la interfas 
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Txt_Nombre = new javax.swing.JTextField();
        Txt_mail = new javax.swing.JTextField();
        Txt_Telefono = new javax.swing.JTextField();
        Txt_Direccion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Jlabel_footer = new javax.swing.JLabel();
        jLabel1_walpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de clientes ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Direccion");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registrar Cliente");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        Txt_Nombre.setBackground(new java.awt.Color(153, 153, 255));
        Txt_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Txt_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        Txt_mail.setBackground(new java.awt.Color(153, 153, 255));
        Txt_mail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Txt_mail.setForeground(new java.awt.Color(255, 255, 255));
        Txt_mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_mail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Txt_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_mailActionPerformed(evt);
            }
        });
        getContentPane().add(Txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        Txt_Telefono.setBackground(new java.awt.Color(153, 153, 255));
        Txt_Telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Txt_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        Txt_Telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_Telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Txt_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        Txt_Direccion.setBackground(new java.awt.Color(153, 153, 255));
        Txt_Direccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Txt_Direccion.setForeground(new java.awt.Color(255, 255, 255));
        Txt_Direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_Direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Txt_Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 120, 100));

        Jlabel_footer.setText("Creado por Victor Carreño");
        getContentPane().add(Jlabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));
        getContentPane().add(jLabel1_walpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Txt_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_mailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int validacion = 0;
        String nombre;
        String email;
        String telefono;
        String direccion;

        nombre = Txt_Nombre.getText().trim();
        email = Txt_mail.getText().trim();
        telefono = Txt_Telefono.getText().trim();
        direccion = Txt_Direccion.getText().trim();

        if (nombre.equals("")) {
            Txt_Nombre.setBackground(Color.red);
            validacion++;
        }
        if (email.equals("")) {
            Txt_mail.setBackground(Color.red);
            validacion++;
        }
        if (telefono.equals("")) {
            Txt_Telefono.setBackground(Color.red);
            validacion++;
        }
        if (direccion.equals("")) {
            Txt_Direccion.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) {

            try {
                Connection cn = Conexion.Conectar();
                String Griselda = "insert into clientes values (?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(Griselda);

                pst.setInt(1, 0);
                pst.setString(2, nombre);
                pst.setString(3, email);
                pst.setString(4, telefono);
                pst.setString(5, direccion);
                /// esta linea registra en la BD el ultimo usuario que realizo la modificacion 
                pst.setString(6, user);

                pst.executeUpdate();
                cn.close();
                Limpiar();

                Txt_Nombre.setBackground(Color.yellow);
                Txt_mail.setBackground(Color.yellow);
                Txt_Telefono.setBackground(Color.yellow);
                Txt_Direccion.setBackground(Color.yellow);

                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("error al conectar en vista registrar clientes " + e);
                JOptionPane.showMessageDialog(null, "error al registrar , contactar al administrador  ");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos ");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel_footer;
    private javax.swing.JTextField Txt_Direccion;
    private javax.swing.JTextField Txt_Nombre;
    private javax.swing.JTextField Txt_Telefono;
    private javax.swing.JTextField Txt_mail;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_walpaper;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {

        Txt_Nombre.setText("");
        Txt_mail.setText("");
        Txt_Telefono.setText("");
        Txt_Direccion.setText("");

    }
}