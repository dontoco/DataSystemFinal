/*
 * Video 85
To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class InformacionEquipo extends javax.swing.JFrame {

    int IDcliente_update = 0, IDequipo = 0;
    String user = "", nom_cliente = "";

    /**
     * Creates new form InformacionEquipo
     */
    public InformacionEquipo() {
        initComponents();
        user = Login.user;
        IDequipo = Informacion_cliente.IDequipo;
        IDcliente_update = GestionarClientes.IDclienteUpdate;
        // /esta conexion es unicamente para obtener el nombre del cliente 
        try {
            Connection cn = Conexion.Conectar();
            String MartaSQL = "select nombre_cliente from clientes where id_cliente = '" + IDcliente_update + "'";
            PreparedStatement pst = cn.prepareStatement(MartaSQL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nom_cliente = rs.getString("nombre_cliente");
            }

        } catch (SQLException e) {
            System.err.println("error al obtener el nombre del cliente " + e);

        }

        try {
            Connection cn = Conexion.Conectar();
            String angelSQL = "select * from equipos where id_equipo = '" + IDequipo + "'";
            PreparedStatement pst = cn.prepareStatement(angelSQL);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cmb_tipoEquipo.setSelectedItem(rs.getString("tipo_equipo"));
                Cmb_marcas.setSelectedItem(rs.getString("marca"));
                cmb_estatus.setSelectedItem(rs.getString("estatus"));

                TxtModelo.setText(rs.getString("modelo"));
                txtNserie.setText(rs.getString("num_serie"));
                txtultimamod.setText(rs.getString("ultima_modificacion"));

                // recuperacion de fechas 
                String dia = "";
                String mes = "";
                String ano = "";

                dia = rs.getString("dia_ingreso");
                mes = rs.getString("mes_ingreso");
                ano = rs.getString("ano_ingreso");

                TxtFecha.setText(dia + " del " + " del " + ano);

                jTextPane_observaciones.setText(rs.getString("observaciones"));
                jTextPane_comentariosTecnico.setText(rs.getString("comentarios_tecnicos"));

                /// verificar linea de codigo donde registra el datos en tabla 
                jLabel2_RevisionTecnicaDe.setText("comentarios y actualizacion del Tecnico " + rs.getString("revision_tecnica"));

            }

        } catch (SQLException e) {
            System.err.println("error al consultar la informacion del equipo " + e);
        }

        setSize(670, 530);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Equipo del cliente " + nom_cliente);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_walpaper.getWidth(), jLabel_walpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_walpaper.setIcon(icono);
        this.repaint();

        Txt_NombreCliente.setText(nom_cliente);

    }

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

        jLabel_titulo = new javax.swing.JLabel();
        jLabel2_Nombre = new javax.swing.JLabel();
        jLabel2_Nombre1 = new javax.swing.JLabel();
        jLabel2_Nombre2 = new javax.swing.JLabel();
        jLabel2_Nombre3 = new javax.swing.JLabel();
        jLabel2_Nombre4 = new javax.swing.JLabel();
        jLabel2_Nombre5 = new javax.swing.JLabel();
        jLabel2_Nombre6 = new javax.swing.JLabel();
        jLabel2_Nombre7 = new javax.swing.JLabel();
        jLabel2_Nombre8 = new javax.swing.JLabel();
        jLabel2_RevisionTecnicaDe = new javax.swing.JLabel();
        Txt_NombreCliente = new javax.swing.JTextField();
        TxtModelo = new javax.swing.JTextField();
        txtNserie = new javax.swing.JTextField();
        txtultimamod = new javax.swing.JTextField();
        TxtFecha = new javax.swing.JTextField();
        cmb_tipoEquipo = new javax.swing.JComboBox<>();
        Cmb_marcas = new javax.swing.JComboBox<>();
        cmb_estatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane_observaciones = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane_comentariosTecnico = new javax.swing.JTextPane();
        jButton1_actualizarEq = new javax.swing.JButton();
        jLabel_walpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Informacion de Equipo");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel2_Nombre.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre.setText("Nombre Cliente");
        getContentPane().add(jLabel2_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel2_Nombre1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre1.setText("Tipo de equipo");
        getContentPane().add(jLabel2_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel2_Nombre2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre2.setText("Marca");
        getContentPane().add(jLabel2_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel2_Nombre3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre3.setText("modelo");
        getContentPane().add(jLabel2_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel2_Nombre4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre4.setText("Serie");
        getContentPane().add(jLabel2_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel2_Nombre5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre5.setText("Fecha ingreso");
        getContentPane().add(jLabel2_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        jLabel2_Nombre6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_Nombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre6.setText("Ultima mod por");
        getContentPane().add(jLabel2_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel2_Nombre7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_Nombre7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre7.setText("Estatus");
        getContentPane().add(jLabel2_Nombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jLabel2_Nombre8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_Nombre8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre8.setText("Daño reportado ");
        getContentPane().add(jLabel2_Nombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        jLabel2_RevisionTecnicaDe.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_RevisionTecnicaDe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_RevisionTecnicaDe.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_RevisionTecnicaDe.setText("Comentarios y actualizacion tecnico");
        getContentPane().add(jLabel2_RevisionTecnicaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        Txt_NombreCliente.setEditable(false);
        Txt_NombreCliente.setBackground(new java.awt.Color(153, 153, 255));
        Txt_NombreCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Txt_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        Txt_NombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_NombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Txt_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, 20));

        TxtModelo.setBackground(new java.awt.Color(153, 153, 255));
        TxtModelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        TxtModelo.setForeground(new java.awt.Color(255, 255, 255));
        TxtModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtModelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, 20));

        txtNserie.setBackground(new java.awt.Color(153, 153, 255));
        txtNserie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtNserie.setForeground(new java.awt.Color(255, 255, 255));
        txtNserie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNserie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtNserie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 210, 20));

        txtultimamod.setEditable(false);
        txtultimamod.setBackground(new java.awt.Color(153, 153, 255));
        txtultimamod.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtultimamod.setForeground(new java.awt.Color(255, 255, 255));
        txtultimamod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtultimamod.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtultimamod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 210, 20));

        TxtFecha.setEditable(false);
        TxtFecha.setBackground(new java.awt.Color(153, 153, 255));
        TxtFecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        TxtFecha.setForeground(new java.awt.Color(255, 255, 255));
        TxtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtFecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 180, 20));

        cmb_tipoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multifuncional" }));
        getContentPane().add(cmb_tipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        Cmb_marcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Apple", "HP", "Compaq", "Asus", "Dell", "Lenovo", "Sony", "Generico(clon)", "Samsung", "Pacard bell", "Olidata", "Gear", "E machine", "Toshiba", "No especificado" }));
        getContentPane().add(Cmb_marcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo Ingreso", "No Reparado", "En Revision", "Reparado", "Entregado" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jScrollPane1.setViewportView(jTextPane_observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 330, 120));

        jTextPane_comentariosTecnico.setEditable(false);
        jScrollPane2.setViewportView(jTextPane_comentariosTecnico);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 330, 120));

        jButton1_actualizarEq.setBackground(new java.awt.Color(153, 153, 225));
        jButton1_actualizarEq.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton1_actualizarEq.setForeground(new java.awt.Color(255, 255, 255));
        jButton1_actualizarEq.setText("Actualizar Equipo");
        jButton1_actualizarEq.setBorder(null);
        jButton1_actualizarEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_actualizarEqActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_actualizarEq, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 210, 35));
        getContentPane().add(jLabel_walpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1_actualizarEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_actualizarEqActionPerformed
        // TODO add your handling code here:

        int validacion = 0;
        String tipo_equipo, marca, modelo, num_serie, estatus, observaciones;

        tipo_equipo = cmb_tipoEquipo.getSelectedItem().toString();
        estatus = cmb_estatus.getSelectedItem().toString();
        marca = Cmb_marcas.getSelectedItem().toString();

        modelo = TxtModelo.getText();
        num_serie = txtNserie.getText();
        observaciones = jTextPane_observaciones.getText();

        if (modelo.equals("")) {
            TxtModelo.setBackground(Color.red);
            validacion++;

        }
        if (num_serie.equals("")) {
            txtNserie.setBackground(Color.red);
            validacion++;

        }
        if (observaciones.equals("")) {
            jTextPane_observaciones.setText("sin observaciones");
            validacion++;

        }
        if (validacion == 0) {
            try {
                Connection cn = Conexion.Conectar();
                String CristiSQL = "update equipos set tipo_equipo=?, marca=?, modelo=?, num_serie=?, observaciones=?, estatus=?, ultima_modificacion=? "
                        + "where id_equipo = '" + IDequipo + "'";
                PreparedStatement pst = cn.prepareStatement(CristiSQL);

                pst.setString(1, tipo_equipo);
                pst.setString(2, marca);
                pst.setString(3, modelo);
                pst.setString(4, num_serie);
                pst.setString(5, observaciones);
                pst.setString(6, estatus);
                pst.setString(7, user);

                pst.executeUpdate();
                cn.close();

                Limpiar();

                txtNserie.setBackground(Color.GREEN);
                Txt_NombreCliente.setBackground(Color.GREEN);
                TxtFecha.setBackground(Color.GREEN);
                TxtModelo.setBackground(Color.GREEN);
                txtultimamod.setText(user);

                JOptionPane.showMessageDialog(null, "actualizacion correcta");

            } catch (SQLException e) {
                System.err.println("error ern actualizar equipo " + e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "debe llenar todos los campos");
        }


    }//GEN-LAST:event_jButton1_actualizarEqActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cmb_marcas;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtModelo;
    private javax.swing.JTextField Txt_NombreCliente;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_tipoEquipo;
    private javax.swing.JButton jButton1_actualizarEq;
    private javax.swing.JLabel jLabel2_Nombre;
    private javax.swing.JLabel jLabel2_Nombre1;
    private javax.swing.JLabel jLabel2_Nombre2;
    private javax.swing.JLabel jLabel2_Nombre3;
    private javax.swing.JLabel jLabel2_Nombre4;
    private javax.swing.JLabel jLabel2_Nombre5;
    private javax.swing.JLabel jLabel2_Nombre6;
    private javax.swing.JLabel jLabel2_Nombre7;
    private javax.swing.JLabel jLabel2_Nombre8;
    private javax.swing.JLabel jLabel2_RevisionTecnicaDe;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_walpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane_comentariosTecnico;
    private javax.swing.JTextPane jTextPane_observaciones;
    private javax.swing.JTextField txtNserie;
    private javax.swing.JTextField txtultimamod;
    // End of variables declaration//GEN-END:variables
public void Limpiar() {
        txtNserie.setText("");
        Txt_NombreCliente.setText("");
        TxtFecha.setText("");
        TxtModelo.setText("");
    }
}
