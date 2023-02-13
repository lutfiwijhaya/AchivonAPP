/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import CustomResource.koneksi;
import Main.MasterForm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hi
 */
public class CandidateApplicationCertificates extends MasterForm {

    java.sql.Statement stm;
    ResultSet rs;
    java.sql.Connection koneksi;

    /**
     * Creates new form CandidateApplicationFamily
     */
    public CandidateApplicationCertificates() {
        initComponents();
        ((DefaultTableCellRenderer)jTable1.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);
    openDB();
    
    }
    
      private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator31 = new javax.swing.JSeparator();
        jLabel87 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        t_nama = new CustomResource.CustomTextfield();
        t_sertifikat = new CustomResource.CustomTextfield();
        jLabel1 = new javax.swing.JLabel();
        t_lokasi = new CustomResource.ComboBoxSuggestion();
        t_tgl = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        t_author = new CustomResource.CustomTextfield();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator31.setForeground(new java.awt.Color(255, 0, 0));
        add(jSeparator31, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 430, 20));

        jLabel87.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel87.setText("4. sertifikat keahlian / Sklill Authorized Certificates");
        add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 300, 30));

        jTable1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "diakuisisi Tanggal / acquisition date", "Nama Sertifikat / Certificate Name", "Nama Badan Penyelenggara / Authority Name", "Lokasi Penyelenggara / Location", "No. Sertifikat"
            }
        ));
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jScrollPane2.setViewportView(jTable1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 700, 90));

        t_nama.setLabelText("Nama Sertifikat / Certificate Namel");
        add(t_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 270, -1));

        t_sertifikat.setLabelText("No. Sertifikat");
        add(t_sertifikat, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 270, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("diakuisisi Tanggal / acquisition date");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 180, -1));

        t_lokasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Serang", " " }));
        t_lokasi.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        add(t_lokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 270, -1));

        t_tgl.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        add(t_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 220, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Lokasi / Location");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 90, -1));

        t_author.setLabelText("Nama Badan Penyelenggara / Authority Name");
        add(t_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 270, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton1.setText("Lanjut / Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 510, 120, 30));

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add/Tambah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 300, 120, 30));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Hapus / Delete");
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 440, 120, 30));

        jButton5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton5.setText("Kembali / Back");
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 120, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 String sql0 = "truncate cd_certificate_sementara";
        try {
            stm = koneksi.createStatement();
            stm.executeUpdate(sql0);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CandidateApplicationAcademic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        DefaultTableModel tabelfamily = (DefaultTableModel) jTable1.getModel();
        int htabelfamily = jTable1.getRowCount();

        for (int i = 0; i <= htabelfamily - 1; i++) {
            if (jTable1.getValueAt(i, 0) == null) {
            } else {
                String dtabel_tanggal = jTable1.getValueAt(i, 0).toString();
                String dtabel_nama = jTable1.getValueAt(i, 1).toString();
                String dtabel_author = jTable1.getValueAt(i, 2).toString();
                String dtabel_lokasi = jTable1.getValueAt(i, 3).toString();
                String dtabel_no = jTable1.getValueAt(i, 4).toString();

                try {
                    stm = koneksi.createStatement();
                    String sql = "insert into cd_certificate_sementara (tangal,nama,author,lokasi,no_sertificate) values('" + dtabel_tanggal + "'"
                            + ",'" + dtabel_nama + "'"
                            + ",'" + dtabel_author + "'"
                            + ",'" + dtabel_lokasi + "','" + dtabel_no + "')";
                    stm.executeUpdate(sql);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
                }

            }
        }        Main.main.getMain().showForm(new CandidateApplicationCareer());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
        String tanggal = String.valueOf(fm.format(t_tgl.getDate()));

        DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
        List list = new ArrayList<>();
        jTable1.setAutoCreateColumnsFromModel(true);
        list.add(tanggal);
        list.add(t_nama.getText());
        list.add(t_author.getText());
        list.add(t_lokasi.getSelectedItem());
        list.add(t_sertifikat.getText());
        dataModel.addRow(list.toArray());
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JTable jTable1;
    private CustomResource.CustomTextfield t_author;
    private CustomResource.ComboBoxSuggestion t_lokasi;
    private CustomResource.CustomTextfield t_nama;
    private CustomResource.CustomTextfield t_sertifikat;
    private com.toedter.calendar.JDateChooser t_tgl;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
    
    }
}
