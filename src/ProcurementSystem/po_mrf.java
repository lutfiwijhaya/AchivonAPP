/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ProcurementSystem;

import HumanResource.*;
import CustomResource.CandidateSession;
import CustomResource.MySession;
import CustomResource.koneksi;
import ProcurementSystem.po;
import ProcurementSystem.po_rfq;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author USER
 */
public class po_mrf extends javax.swing.JFrame {
 Statement stm;
    ResultSet rs;
    Connection koneksi;
    String role;
    /**
     * Creates new form Employe_list
     */
    public po_mrf() {
        initComponents();
        MyWindow1();
        openDB();
        tampil();
        
    }

    
    
    
    void table(){
       
    
    }
    
    void tampil(){
        System.out.println(CustomResource.CandidateSession.getidpo());
      try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("SELECT * FROM po inner join po_sq on po.sq_id = po_sq.id INNER JOIN po_rfq on po_sq.rfq_id = po_rfq.id inner join biz_partner on biz_partner.biz_id = po_rfq.biz_id  where po.id_po = '"+CustomResource.CandidateSession.getidpo()+"'");
            while (rs.next()) {
                
                double angka3 = Double.parseDouble(rs.getString("total2"));

                NumberFormat format = new DecimalFormat("#,###");
               
                String hasil3 = format.format(angka3);

                    t_idpo.setText("PO-" + rs.getString("id_po"));
                    t_suplier.setText("PO-" + rs.getString("name"));
                    t_amount.setText("Rp. " + hasil3);
                   
                ;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal ta mpil");
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

        dateChooser2 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        t_amount = new CustomResource.CustomTextfield();
        t_recieved = new CustomResource.CustomTextfield();
        t_idpo = new CustomResource.CustomTextfield();
        t_suplier = new CustomResource.CustomTextfield();

        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(t_recieved);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("FORM MRF");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 240, 40));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, -1));

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        t_amount.setEditable(false);
        t_amount.setLabelText("Amount");
        t_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_amountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_amountKeyTyped(evt);
            }
        });
        jPanel1.add(t_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 240, -1));

        t_recieved.setLabelText("Recieved Date");
        t_recieved.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_recievedKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_recievedKeyTyped(evt);
            }
        });
        jPanel1.add(t_recieved, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 190, -1));

        t_idpo.setEditable(false);
        t_idpo.setLabelText("ID PO");
        t_idpo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_idpoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_idpoKeyTyped(evt);
            }
        });
        jPanel1.add(t_idpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 190, -1));

        t_suplier.setEditable(false);
        t_suplier.setLabelText("Supplier");
        t_suplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_suplierKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_suplierKeyTyped(evt);
            }
        });
        jPanel1.add(t_suplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String mr_id3 = t_idpo.getText();

        String[] parts = mr_id3.split("-");
        String id = parts[1];
        
        try {
            stm = koneksi.createStatement();
            String sql = "insert into po_mrf (po_id,recieved_date) values('" + id + "'"
                    + ",'" + t_recieved.getText() + "')";
            stm.executeUpdate(sql);
            stm.close();
            JOptionPane.showMessageDialog(null, "Data Saved");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }
        
        
        
        
        

        try {
            stm = koneksi.createStatement();
            String sql = "UPDATE po SET status_po = '1' WHERE id_po = '" + id + "'";
            stm.executeUpdate(sql);
            stm.close();
            JOptionPane.showMessageDialog(null, "Data Saved");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }

Main.main.getMain().showForm(new po_list_po());
this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void t_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_amountKeyTyped

//        DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();;
//        String mySearch = textSearch.getText();
//        int row = jTable1.getRowCount();
//        for (int i = 0; i < row; i++) {
//            myModel.removeRow(0);
//        }
//        if (mySearch != null) {
//
//            try {
//                stm = koneksi.createStatement();
//                rs = stm.executeQuery("SELECT * FROM employee WHERE name LIKE '%" + mySearch + "%'");
//                while (rs.next()) {
//                    String[] data = {
//                       rs.getString("id"),
//                    rs.getString("karyawan_id"),
//                    rs.getString("name"),
//                    rs.getString("job_position")};
//                    myModel.insertRow(0, data);
//                }
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//            }
//        } else {
//
//            try {
//                stm = koneksi.createStatement();
//                rs = stm.executeQuery("select*from employee");
//                while (rs.next()) {
//                    String[] data = {
//                        rs.getString("id"),
//                    rs.getString("karyawan_id"),
//                    rs.getString("name"),
//                    rs.getString("job_position")};
//                    myModel.insertRow(0, data);
//                }
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//            }
//        }  
//        int row1 = jTable1.getRowCount();
//        System.out.println(row1);
    }//GEN-LAST:event_t_amountKeyTyped

    private void t_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_amountKeyReleased

       
    }//GEN-LAST:event_t_amountKeyReleased

    private void t_recievedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_recievedKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_recievedKeyReleased

    private void t_recievedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_recievedKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_recievedKeyTyped

    private void t_idpoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_idpoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_idpoKeyReleased

    private void t_idpoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_idpoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_idpoKeyTyped

    private void t_suplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_suplierKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_suplierKeyReleased

    private void t_suplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_suplierKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_suplierKeyTyped

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
            java.util.logging.Logger.getLogger(po_mrf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(po_mrf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(po_mrf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(po_mrf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new po_mrf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private CustomResource.CustomTextfield t_amount;
    private CustomResource.CustomTextfield t_idpo;
    private CustomResource.CustomTextfield t_recieved;
    private CustomResource.CustomTextfield t_suplier;
    // End of variables declaration//GEN-END:variables
}
