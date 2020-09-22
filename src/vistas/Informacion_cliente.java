/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Conexion;
import java.sql.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static vistas.GestionarClientes.IDclienteUpdate;

/**
 *
 * @author Victor
 */
public class Informacion_cliente extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();

    int IDcliente_update = 0;
    public static int IDequipo = 0;
    String user = "";

    /**
     * Creates new form Informacion_cliente
     */
    public Informacion_cliente() {
        initComponents();
        user = Login.user;
        IDcliente_update = GestionarClientes.IDclienteUpdate;

        setSize(630, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        /// esto impide que el programa se cierre cuando finaliza esta interfas
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // metodo que cambia el fondo de pantalla de la aplicacion 
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel1_wallpaper.getWidth(), jLabel1_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel1_wallpaper.setIcon(icono);
        this.repaint();

        try {
            Connection cn = Conexion.Conectar();
            String NadiaSQL = "select * from clientes where id_cliente = '" + IDcliente_update + "'";
            PreparedStatement pst = cn.prepareStatement(NadiaSQL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                setTitle("informacion del cliente " + rs.getString("nombre_cliente") + "Sesion de - " + user);
                jLabel_titulo.setText("informacion del cliente" + rs.getString("nombre_cliente"));

                TxtNombre.setText(rs.getString("nombre_cliente"));
                Txtmail.setText(rs.getString("mail_cliente"));
                Txt_direccion.setText(rs.getString("dir_cliente"));
                Txt_telefono.setText(rs.getString("tel_cliente"));
                TxtUltimamodificacion.setText(rs.getString("ultima_modificacion"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("error en la consulta de cliente" + e);
            JOptionPane.showMessageDialog(null, "error al cargar!!! contacte al administrador");
        }

        //llenado de la tabla equipos 
        try {
            Connection cn = Conexion.Conectar();
            String MariaSQL = "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + IDcliente_update + "'";
            PreparedStatement pst = cn.prepareStatement(MariaSQL);

            ResultSet rs = pst.executeQuery();

            jTable_equipos = new JTable(model);
            jScrollPane1_equipo.setViewportView(jTable_equipos);

            model.addColumn("ID_equipos");
            model.addColumn("tipo de Equipo");
            model.addColumn("Marca ");
            model.addColumn("Estatus ");

            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);

                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("error en el llenado de la tabla equipo " + e);
        }

        jTable_equipos.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_equipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDequipo = (int) model.getValueAt(fila_point, columna_point);

                    /// validar esto 
                    // Informacion_cliente Caliente = new Informacion_cliente();
                    //  Caliente.setVisible(true);
                    
                    ///video 85
                    IDequipo = (int) model.getValueAt(fila_point, columna_point);
                    InformacionEquipo claudia = new InformacionEquipo();
                    claudia.setVisible(true);
                    
                } else {
                }
            }
        });

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

        jScrollPane1_equipo = new javax.swing.JScrollPane();
        jTable_equipos = new javax.swing.JTable();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel2_Nombre = new javax.swing.JLabel();
        jLabel2_Mail = new javax.swing.JLabel();
        jLabel2_telefono = new javax.swing.JLabel();
        jLabel2_Direccion = new javax.swing.JLabel();
        jLabel2_Ultimamod = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        Txtmail = new javax.swing.JTextField();
        Txt_telefono = new javax.swing.JTextField();
        Txt_direccion = new javax.swing.JTextField();
        TxtUltimamodificacion = new javax.swing.JTextField();
        jButton_registrar = new javax.swing.JButton();
        jButton1_RestauraPASS1 = new javax.swing.JButton();
        jButton_imprimir_reporte = new javax.swing.JButton();
        jLabel1_wallpaper = new javax.swing.JLabel();
        jLabel2_footer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_equipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1_equipo.setViewportView(jTable_equipos);

        getContentPane().add(jScrollPane1_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 380, 180));

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Informacion del Cliente");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2_Nombre.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_Nombre.setText("Nombre");
        getContentPane().add(jLabel2_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel2_Mail.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_Mail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_Mail.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_Mail.setText("email");
        getContentPane().add(jLabel2_Mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel2_telefono.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_telefono.setText("telefono");
        getContentPane().add(jLabel2_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel2_Direccion.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_Direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_Direccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_Direccion.setText("Direccion");
        getContentPane().add(jLabel2_Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel2_Ultimamod.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2_Ultimamod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2_Ultimamod.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2_Ultimamod.setText("Ultima modificacion");
        getContentPane().add(jLabel2_Ultimamod, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        TxtNombre.setBackground(new java.awt.Color(153, 153, 255));
        TxtNombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        TxtNombre.setForeground(new java.awt.Color(255, 255, 255));
        TxtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, 20));

        Txtmail.setBackground(new java.awt.Color(153, 153, 255));
        Txtmail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Txtmail.setForeground(new java.awt.Color(255, 255, 255));
        Txtmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txtmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Txtmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, 20));

        Txt_telefono.setBackground(new java.awt.Color(153, 153, 255));
        Txt_telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        Txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, 20));

        Txt_direccion.setBackground(new java.awt.Color(153, 153, 255));
        Txt_direccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        Txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, 20));

        TxtUltimamodificacion.setBackground(new java.awt.Color(153, 153, 255));
        TxtUltimamodificacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        TxtUltimamodificacion.setForeground(new java.awt.Color(255, 255, 255));
        TxtUltimamodificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtUltimamodificacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TxtUltimamodificacion.setEnabled(false);
        getContentPane().add(TxtUltimamodificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 210, 20));

        jButton_registrar.setBackground(new java.awt.Color(153, 153, 225));
        jButton_registrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_registrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registrar.setText("Registrar Equipo");
        jButton_registrar.setBorder(null);
        jButton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 210, 35));

        jButton1_RestauraPASS1.setBackground(new java.awt.Color(153, 153, 225));
        jButton1_RestauraPASS1.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton1_RestauraPASS1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1_RestauraPASS1.setText("Actualizar Cliente");
        jButton1_RestauraPASS1.setBorder(null);
        jButton1_RestauraPASS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_RestauraPASS1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_RestauraPASS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 210, 35));

        jButton_imprimir_reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton_imprimir_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_imprimir_reporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_imprimir_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 120, 100));
        getContentPane().add(jLabel1_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        jLabel2_footer.setText("Creado por Victor Carreño ");
        getContentPane().add(jLabel2_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarActionPerformed
        // TODO add your handling code here:
        Registrar_equipo registroeqp = new Registrar_equipo();
        registroeqp.setVisible(true);

    }//GEN-LAST:event_jButton_registrarActionPerformed

    private void jButton1_RestauraPASS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_RestauraPASS1ActionPerformed
        // TODO add your handling code here:

        int validacion = 0;
        String nombre, mail, telefono, direccion;

        nombre = TxtNombre.getText().trim();
        direccion = Txt_direccion.getText().trim();
        mail = Txtmail.getText().trim();
        telefono = Txt_telefono.getText().trim();

        if (nombre.equals("")) {
            TxtNombre.setBackground(Color.red);
            validacion++;
        }
        if (mail.equals("")) {
            Txtmail.setBackground(Color.red);
            validacion++;
        }
        if (telefono.equals("")) {
            Txt_telefono.setBackground(Color.red);
            validacion++;
        }
        if (direccion.equals("")) {
            Txt_direccion.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) {

            try {
                Connection cn = Conexion.Conectar();
                String catalinaSQL = "update clientes set nombre_cliente=?, mail_cliente=?, tel_cliente=?, dir_cliente=?, ultima_modificacion=? "
                        + "where id_cliente = '" + IDcliente_update + "'";

                PreparedStatement pst = cn.prepareStatement(catalinaSQL);
                pst.setString(1, nombre);
                pst.setString(2, mail);
                pst.setString(3, telefono);
                pst.setString(4, direccion);
                pst.setString(5, user);

                pst.executeUpdate();

                cn.close();

                Limpiar();

                TxtNombre.setBackground(Color.yellow);
                Txt_direccion.setBackground(Color.yellow);
                Txtmail.setBackground(Color.yellow);
                Txt_telefono.setBackground(Color.yellow);
                TxtUltimamodificacion.setText(user);

                JOptionPane.showMessageDialog(null, "actualizacion correcta");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("Error al actualizar cliente " + e);

            }

        } else {
            JOptionPane.showMessageDialog(null, "debe llenar todos los campos");
        }


    }//GEN-LAST:event_jButton1_RestauraPASS1ActionPerformed

    private void jButton_imprimir_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_imprimir_reporteActionPerformed
        // TODO add your handling code here:
        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + TxtNombre.getText().trim() + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");

            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informacion del cliente. \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tablaCliente = new PdfPTable(5);
            tablaCliente.addCell("ID");
            tablaCliente.addCell("Nombre");

            tablaCliente.addCell("email");
            tablaCliente.addCell("Telefono");
            tablaCliente.addCell("Direccion");

            try {
                Connection cn = Conexion.Conectar();
                String PaulaSQL = "select * from clientes where id_cliente = '" + IDcliente_update + "'";
                PreparedStatement pst = cn.prepareStatement(PaulaSQL);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tablaCliente.addCell(rs.getString(1));// ID cliente
                        tablaCliente.addCell(rs.getString(2));// nombre
                        tablaCliente.addCell(rs.getString(3));// email
                        tablaCliente.addCell(rs.getString(4));// Telefono
                        tablaCliente.addCell(rs.getString(5));// direccion cliente

                        documento.add(tablaCliente);

                    } while (rs.next());

                    Paragraph parrafo2 = new Paragraph();
                    parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo2.add("\n \n Equipos Registrados. \n \n");
                    parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                    documento.add(parrafo2);

                    PdfPTable tablaEquipos = new PdfPTable(4);
                    tablaEquipos.addCell("ID_equipo");
                    tablaEquipos.addCell("Tipo");
                    tablaEquipos.addCell("Marca");
                    tablaEquipos.addCell("Estatus");

                    try {
                        Connection cn2 = Conexion.Conectar();
                        String DanielaSQL = ""
                                + "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + IDcliente_update + "'";
                        
                        
                        
                        PreparedStatement pst2 = cn.prepareStatement(DanielaSQL);
                        
                        
                        ResultSet rs2 = pst2.executeQuery();
                        
                        if (rs2.next()) {
                            do{
                                tablaEquipos.addCell(rs2.getString(1));
                                tablaEquipos.addCell(rs2.getString(2));// 
                                tablaEquipos.addCell(rs2.getString(3));
                                tablaEquipos.addCell(rs2.getString(4));// Estatus equipo
                                
                            }while(rs2.next());
                            documento.add(tablaEquipos);
                        } 
                                
                    } catch (SQLException e) {
                        
                        System.err.println("error al cargar equipos ");
                    }

                }
            } catch (SQLException e) {
                System.err.println("error al obtener datos del cliente 448 " + e );
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente");

        } catch (DocumentException | IOException e) {
            System.err.println("error en pdf o ruta de imagen");
            JOptionPane.showMessageDialog(null, "error al generar el pdf contacte a administrador");
        }
    }//GEN-LAST:event_jButton_imprimir_reporteActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtUltimamodificacion;
    private javax.swing.JTextField Txt_direccion;
    private javax.swing.JTextField Txt_telefono;
    private javax.swing.JTextField Txtmail;
    private javax.swing.JButton jButton1_RestauraPASS1;
    private javax.swing.JButton jButton_imprimir_reporte;
    private javax.swing.JButton jButton_registrar;
    private javax.swing.JLabel jLabel1_wallpaper;
    private javax.swing.JLabel jLabel2_Direccion;
    private javax.swing.JLabel jLabel2_Mail;
    private javax.swing.JLabel jLabel2_Nombre;
    private javax.swing.JLabel jLabel2_Ultimamod;
    private javax.swing.JLabel jLabel2_footer;
    private javax.swing.JLabel jLabel2_telefono;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1_equipo;
    private javax.swing.JTable jTable_equipos;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {

        TxtNombre.setText("");
        Txt_direccion.setText("");
        Txtmail.setText("");
        Txt_telefono.setText("");

    }

}
