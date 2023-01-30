/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication1;

import javax.swing.JFrame;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

import java.sql.Statement;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author lutfi
 */
public class inputexel extends javax.swing.JFrame {
Statement stm;
    ResultSet rs;
    Connection koneksi;
DefaultTableModel ImportDataExel;
    /**
     * 
     */
    public inputexel() {
        initComponents();
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
    
    
    inputexel(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Karyawan", "Nama", "JK", "tgllahir", "Umur", "NoKTP", "Status", "Alamat", "Alamat Sekarang", "Email", "NoHP", "NPWP", "BPJS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabel1.setAutoscrolls(false);
        tabel1.setName(""); // NOI18N
        tabel1.setShowHorizontalLines(true);
        tabel1.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tabel1);
        if (tabel1.getColumnModel().getColumnCount() > 0) {
            tabel1.getColumnModel().getColumn(1).setResizable(false);
            tabel1.getColumnModel().getColumn(2).setResizable(false);
            tabel1.getColumnModel().getColumn(3).setResizable(false);
            tabel1.getColumnModel().getColumn(4).setResizable(false);
            tabel1.getColumnModel().getColumn(5).setResizable(false);
            tabel1.getColumnModel().getColumn(6).setResizable(false);
            tabel1.getColumnModel().getColumn(7).setResizable(false);
            tabel1.getColumnModel().getColumn(8).setResizable(false);
            tabel1.getColumnModel().getColumn(9).setResizable(false);
            tabel1.getColumnModel().getColumn(10).setResizable(false);
            tabel1.getColumnModel().getColumn(11).setResizable(false);
        }

        jButton1.setText("AMBIL DATA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SIMPAN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("RESET");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1)
                        .addGap(61, 61, 61)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(322, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jToggleButton1))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel ImportDataExel = (DefaultTableModel) tabel1.getModel();
        ImportDataExel.setRowCount(0);
        
        FileInputStream exelFIS = null;
        BufferedInputStream exelBIS = null;
        XSSFWorkbook exelIWB = null;

        String currentDirectoryPath = "C:\\Users\\lutfi\\Documents";
        JFileChooser exelimport = new JFileChooser(currentDirectoryPath);

        FileNameExtensionFilter filterextensi = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xslm");
        exelimport.setFileFilter(filterextensi);
        
        int exelChooser = exelimport.showOpenDialog(null);

        if (exelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                File exelFile = exelimport.getSelectedFile();
                exelFIS = new FileInputStream(exelFile);
                exelBIS = new BufferedInputStream(exelFIS);
                exelIWB = new XSSFWorkbook(exelBIS);
                XSSFSheet exelsheet = exelIWB.getSheetAt(0);

                for (int i = 6; i <= exelsheet.getLastRowNum(); i++) {
                    XSSFRow exelrow = exelsheet.getRow(i);
                    XSSFCell dataid = exelrow.getCell(1);
                    XSSFCell datanama = exelrow.getCell(2);
                    XSSFCell datajk = exelrow.getCell(3);
                    XSSFCell datatgllhr = exelrow.getCell(4);
                    XSSFCell dataage = exelrow.getCell(5);
                    XSSFCell dataktp = exelrow.getCell(6);
                    XSSFCell datastts = exelrow.getCell(7);
                    XSSFCell dataaddress = exelrow.getCell(8);
                    XSSFCell datacaddress = exelrow.getCell(9);
                    XSSFCell dataemail = exelrow.getCell(10);
                    XSSFCell datanohp = exelrow.getCell(11);
                    XSSFCell datanpwp = exelrow.getCell(12);
                    XSSFCell databpjs = exelrow.getCell(14);
                    
                    
                   
                    
                    ImportDataExel.addRow(new Object[] {dataid,datanama,datajk,datatgllhr,dataage,dataktp,datastts,dataaddress,datacaddress,dataemail,datanohp,datanpwp,databpjs});
                }
                
                

            } catch (FileNotFoundException ex) {
                   ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 DefaultTableModel ImportDataExel = (DefaultTableModel) tabel1.getModel();
        int jtabelrows = tabel1.getRowCount();
        
        
        for (int i = 0; i <=jtabelrows - 1; i++){
        
          String  dtabel_id = tabel1.getValueAt(i,0).toString();
       String dtabel_nama = tabel1.getValueAt(i,1).toString();
        String dtabel_jk = tabel1.getValueAt(i,2).toString();
        String dtabel_tgllhr = tabel1.getValueAt(i,3).toString();
        String dtabel_age = tabel1.getValueAt(i,4).toString();
        String dtabel_ktp = tabel1.getValueAt(i,5).toString();
        String dtabel_stts = tabel1.getValueAt(i,6).toString();
        String dtabel_address = tabel1.getValueAt(i,7).toString();
        String dtabel_caddress = tabel1.getValueAt(i,8).toString();
        String dtabel_email = tabel1.getValueAt(i,9).toString();
        String dtabel_nohp = tabel1.getValueAt(i,10).toString();
       String dtabel_npwp = tabel1.getValueAt(i,11).toString();
        String dtabel_bpjs = tabel1.getValueAt(i,12).toString();
       
        
       double did = Double.parseDouble(dtabel_id);
       int iid = (int)did;
       
       double dbpjs = Double.parseDouble(dtabel_bpjs);
       int ibpjs = (int)dbpjs;
       
       double dktp = Double.parseDouble(dtabel_ktp);
       int iktp = (int)dktp;
       
       
   try {
                stm = koneksi.createStatement();
                String sql = "insert into employee_joining values('" + iid + "'"
                        + ",'" + dtabel_nama + "'"
                        + ",'" + dtabel_jk+ "'"
                        + ",'" + dtabel_tgllhr + "'"
                        + ",'" + dtabel_age + "'"
                        + ",'" + iktp + "'"
                        + ",'" + dtabel_stts + "'"
                        + ",'" + dtabel_address + "'"
                        + ",'" + dtabel_caddress + "'"
                        + ",'" + dtabel_email + "'"
                        + ",'" + dtabel_nohp + "'"
                        + ",'" + dtabel_npwp + "'"
                        + ",'" + ibpjs + "')";
                
                stm.executeUpdate(sql);
                stm.close();
               
            } catch (SQLException e) {
                 JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
            }
       
       
        }
        
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
       DefaultTableModel ImportDataExel = (DefaultTableModel) tabel1.getModel();
        
        int rowCount = ImportDataExel.getRowCount();
        for (int i= rowCount - 1;i>=0;i--){
        ImportDataExel.removeRow(i);
        
        
        }



        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(inputexel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inputexel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inputexel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inputexel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inputexel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tabel1;
    // End of variables declaration//GEN-END:variables
}
