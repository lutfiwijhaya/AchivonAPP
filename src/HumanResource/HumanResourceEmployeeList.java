/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package HumanResource;

import CustomResource.CandidateSession;
import CustomResource.MySession;
import CustomResource.koneksi;
import ProcurementSystem.po;
import ProcurementSystem.po_rfq;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author USER
 */
public class HumanResourceEmployeeList extends javax.swing.JFrame {
    Statement stm;
    ResultSet rs;
    Connection koneksi;
    String role;
    /**
     * Creates new form Employe_list
     */
    public HumanResourceEmployeeList() {
        initComponents();
        MyWindow1();
        openDB();
        table();
        tampil();
    }

    private void table(){
        DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();
        dataModel2.addRow(new Object[]{});
        //mendapatkan model kolom pada JTable
        TableColumnModel columnModel = jTable1.getColumnModel();
        //mendapatkan TableColumn pada indeks kolom yang ingin disembunyikan
        TableColumn column = columnModel.getColumn(0);
        TableColumn column1 = columnModel.getColumn(1);
        //menyembunyikan kolom dengan mengatur lebar kolom menjadi 0
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
        column1.setMinWidth(80);
        column1.setMaxWidth(80);
        column1.setWidth(80);
        column1.setPreferredWidth(80);
        //mengakses nilai pada kolom yang disembunyikan
        int rowIndex = 0; //indeks baris
        Object value = jTable1.getValueAt(rowIndex, 0);
        int rowCount = dataModel2.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            dataModel2.removeRow(i);
        }
    }
    
    private void tampil(){
        if("2".equals(MySession.get_Role())){
            if (CustomResource.EmployeeSession.getsesiform().equals("1")){
                jLabel1.setText("Daftar Kandidat/Candidate List");
                DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();
                try {
                    stm = koneksi.createStatement();
                    rs = stm.executeQuery("select * from cd_employee WHERE approval = '1'");
                    while (rs.next()) {
                        String[] data = {
                            rs.getString("id_employee"),
                            rs.getString("KTP"),
                            rs.getString("Nama"),
                            rs.getString("Applying_A")};
                        dataModel2.insertRow(0, data);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e + "data gagal tampil");
                }
            }
        } else if("1".equals(MySession.get_Role())){
            if (CustomResource.EmployeeSession.getsesiform().equals("1")){
                jLabel1.setText("Daftar Kandidat/Candidate List");
                DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();
                try {
                    stm = koneksi.createStatement();
                    rs = stm.executeQuery("select * from cd_employee WHERE approval = '2'");
                    while (rs.next()) {
                        String[] data = {
                            rs.getString("id_employee"),
                            rs.getString("KTP"),
                            rs.getString("Nama"),
                            rs.getString("Applying_A")};
                        dataModel2.insertRow(0, data);
                    }

                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
                }
            }
        }
        if (CustomResource.EmployeeSession.getsesiform().equals("2")){  
            DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();
            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("select * from employee");
                while (rs.next()) {
                    String[] data = {
                        rs.getString("id"),
                        rs.getString("karyawan_id"),
                        rs.getString("name"),
                        rs.getString("job_position")};
                    dataModel2.insertRow(0, data);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        }
        if (CustomResource.EmployeeSession.getsesiform().equals("3")){
            DefaultTableModel myModel;
            String[] header1 = {"id", "Partner_ID", "Name", "City"};
            myModel = new DefaultTableModel(header1, 1);
            jTable1.setModel(myModel);      
            myModel.addRow(new Object[]{});
            //mendapatkan model kolom pada JTable
            TableColumnModel columnModel = jTable1.getColumnModel();
            //mendapatkan TableColumn pada indeks kolom yang ingin disembunyikan
            TableColumn column = columnModel.getColumn(0);
            TableColumn column1 = columnModel.getColumn(1);
            //menyembunyikan kolom dengan mengatur lebar kolom menjadi 0
            column.setMinWidth(0);
            column.setMaxWidth(0);
            column.setWidth(0);
            column.setPreferredWidth(0);
            column1.setMinWidth(80);
            column1.setMaxWidth(80);
            column1.setWidth(80);
            column1.setPreferredWidth(80);
            //mengakses nilai pada kolom yang disembunyikan
            int rowIndex = 0; //indeks baris
            Object value = jTable1.getValueAt(rowIndex, 0);
            int rowCount = myModel.getRowCount();

            for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("select * from biz_partner");
                while (rs.next()) {
                    String[] data = {
                        rs.getString("biz_id"),
                        rs.getString("partner_id"),
                        rs.getString("name"),
                        rs.getString("city")};
                    myModel.insertRow(0, data);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        }  
    }
    
    private void MyWindow1(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width/2) - (this.getSize().width/2);
        int y = (screen.height/2) - (this.getSize().height/2);
        this.setLocation(x,y);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new raven.scroll.win11.ScrollPaneWin11();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Employe ID", "Nama", "Posisi"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 130));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Bizz Partner List");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 240, 40));

        jButton1.setText("Tambah/Add Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, -1));

        jButton2.setText("Batal/Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //candidate
        if (CustomResource.EmployeeSession.getsesiform().equals("1")){
            DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();        
            CustomResource.CandidateSession.setCandidateID(dataModel2.getValueAt(jTable1.getSelectedRow(), 0).toString());
            Main.main.getMain().showForm(new EmployeeConfirmation());
            this.dispose();
        }     
        if (CustomResource.EmployeeSession.getsesiform().equals("2")){
            DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();       
            CustomResource.EmployeeSession.setKTPAllocation(dataModel2.getValueAt(jTable1.getSelectedRow(), 0).toString());
            AllocationAnnouncement.addtext();
            this.dispose();
        }

        if (CustomResource.EmployeeSession.getsesiform().equals("3")){
            DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();       
            CustomResource.EmployeeSession.setbiz_id(dataModel2.getValueAt(jTable1.getSelectedRow(), 0).toString());
            Main.main.getMain().showForm(new po_rfq());
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void textSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchKeyTyped

    private void textSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchKeyReleased

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchActionPerformed

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
            java.util.logging.Logger.getLogger(HumanResourceEmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HumanResourceEmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HumanResourceEmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HumanResourceEmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HumanResourceEmployeeList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
