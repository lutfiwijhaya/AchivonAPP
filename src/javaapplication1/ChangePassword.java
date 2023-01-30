/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hi
 */
public class ChangePassword extends javax.swing.JPanel {

    /**
     * Creates new form ChangePassword
     */
    public ChangePassword() {
        initComponents();
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
        textOldPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        textNewPass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        textConfirmPass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 550, 310, 30));

        jLabel2.setText("Password Lama / Old Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 170, 30));

        textOldPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add(textOldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 250, 30));

        jLabel3.setText("Password Baru / New Password");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 170, 30));

        textNewPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add(textNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 250, 30));

        jLabel4.setText("Konfirmasi Password Baru / Confirmation New Password");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 310, 30));

        textConfirmPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add(textConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 250, 30));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 250, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection myConn;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet  myRess = myConn.createStatement().executeQuery("SELECT * FROM employee WHERE karyawan_id = '"+MySession.get_karyawanID()+"'");
            if(myRess.next()){
                if (textOldPass.getText().equals(myRess.getString("password"))){
                    if (textNewPass.getText().equals(textConfirmPass.getText())) {
                        try{
                            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
                            myConn.createStatement().executeUpdate("UPDATE employee SET password = '"+textNewPass.getText()+"'");
                            
                            JOptionPane.showMessageDialog(null,"Password Berhasil di Perbarui");
//                            MainPanel().setVisible(true);
                            
                        }catch(SQLException e){
                            JOptionPane.showMessageDialog(null,"Tidak dapat terhubung ke Jaringan Silahkan coba beberapa saat lagi");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Password Baru Anda Tidak Sesuai dengan Konfirmasi Password");
                        textNewPass.requestFocus();
                        textNewPass.setText("");
                        textConfirmPass.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Password Lama Anda Tidak Sesuai");
                    textOldPass.requestFocus();
                    textOldPass.setText("");
                }
            }
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Mendapatkan Informasi");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField textConfirmPass;
    private javax.swing.JPasswordField textNewPass;
    private javax.swing.JPasswordField textOldPass;
    // End of variables declaration//GEN-END:variables
}
