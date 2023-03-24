/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ukk_sppamalia;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author ASUS
 */
public class laporan extends javax.swing.JFrame {
    
    Connection con;
    DefaultTableModel tm;
    
    
    public void connect(){
        con=null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_sppamalia","root","");
        }catch (Exception e){
            System.out.print("ERROR KUERI KE DATABASE:\n "+e+"\n\n");
        }
    }
    
    public void ambilData(){
        tm=new DefaultTableModel(null, new Object[] {"NISN", "Nama", "Kelas", "Tanggal Bayar", "Bulan", "Jumlah", "Status"});
        jTable1.setModel(tm);
        tm.getDataVector().removeAllElements();
        try {
            PreparedStatement s = con.prepareStatement("SELECT pembayaran.nisn, siswa.nama, kelas.nama_kelas, pembayaran.tgl_bayar, pembayaran.bulan, "
                    + "pembayaran.jumlah_bayar FROM pembayaran INNER JOIN siswa USING(nisn) INNER JOIN kelas USING(id_kelas)");
                    
            ResultSet r = s.executeQuery();
            while (r.next()) {
                Object[] data = {
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getString(4),
                    r.getString(5),
                    r.getString(6), 
                    "Lunas"
                };
                tm.addRow(data);
            }
        }catch (Exception e){
            System.out.print("ERROR KUERI KE DATABASE:\n" + e + "n\n");
        }
    }
    /**
     * Creates new laporan
     */
    public laporan() {
        initComponents();
        connect();
        ambilData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtcari = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnExt = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Laporan");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(178, 201, 202));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe Script", 1, 27)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/laporan.png"))); // NOI18N
        jLabel11.setText("Laporan");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 60));

        jPanel5.setBackground(new java.awt.Color(147, 181, 176));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/search.png"))); // NOI18N
        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel13.setText("Cari pembayaran by NISN :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 840, -1));

        jPanel4.setBackground(new java.awt.Color(147, 181, 176));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 800, 320));

        btnExt.setBackground(new java.awt.Color(178, 201, 202));
        btnExt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit.png"))); // NOI18N
        btnExt.setText("Kembali");
        btnExt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtActionPerformed(evt);
            }
        });
        jPanel4.add(btnExt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 100, -1));

        jButton2.setBackground(new java.awt.Color(178, 201, 202));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\RPLScada\\Downloads\\cetak.png")); // NOI18N
        jButton2.setText("Cetak");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 350, 100, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 840, 400));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Papan tulis2.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 60, -1, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tm=new DefaultTableModel(null, new Object[] {"NISN", "Nama", "Kelas", "Tanggal Bayar", "Bulan", ""
                + "Jumlah", "Status"});
        jTable1.setModel(tm);
        tm.getDataVector().removeAllElements();
        try {
            PreparedStatement s = con.prepareStatement("SELECT pembayaran.nisn, siswa.nama, kelas.nama_kelas, pembayaran.tgl_bayar, pembayaran.bulan,"
                    + "pembayaran.jumlah_bayar FROM pembayaran INNER JOIN siswa USING(nisn) INNER JOIN kelas "
                    + "USING(id_kelas) where pembayaran.tgl_bayar LIKE '%"+txtcari.getText().toString()+"%'");
            ResultSet r = s.executeQuery();
            while (r.next()) {
                Object[] data = {
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getString(4),
                    r.getString(5),
                    r.getString(6),
                    "Lunas"
                };
                tm.addRow(data);
            }
        }catch (Exception e){
            System.out.print("ERROR KUERI KE DATABASE:\n" + e + "n\n");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtActionPerformed
        // TODO add your handling code here:
        menu m=new menu();
        m.show();
        this.dispose();
    }//GEN-LAST:event_btnExtActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            HashMap parameter = new HashMap();
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_sppamalia","root","");
            File file = new File ("src/Ukk_sppamalia/cetak.jasper");
            JasperReport jr = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, con);
            JasperViewer.viewReport(jp, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
            
            }catch (Exception e){
            System.out.print("ERROR KUERI KE DATABASE:\n" + e + "n\n");
        }
    
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables
}
