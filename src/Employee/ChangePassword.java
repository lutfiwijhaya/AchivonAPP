/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import CustomResource.MySession;
import CustomResource.koneksi;
import Main.MasterForm;
import javax.swing.JOptionPane;

/**
 *
 * @author hi
 */
public class ChangePassword extends MasterForm {
    Connection koneksi;
    public ChangePassword() {
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        textConfirmPass = new CustomResource.PasswordField();
        textNewPass = new CustomResource.PasswordField();
        textOldPass = new CustomResource.PasswordField();

        setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textConfirmPass.setLabelText("Konfirmasi Password Baru / Confirm new Password");
        textConfirmPass.setShowAndHide(true);

        textNewPass.setLabelText("Password saat ini / Current Password");
        textNewPass.setShowAndHide(true);

        textOldPass.setLabelText("Password saat ini / Current Password");
        textOldPass.setShowAndHide(true);
        textOldPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textOldPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 445, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 175, Short.MAX_VALUE)
                .addComponent(textOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(textConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 110, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textOldPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textOldPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textOldPassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ResultSet  myRess = koneksi.createStatement().executeQuery("SELECT * FROM employee WHERE karyawan_id = '"+MySession.get_karyawanID()+"'");
            if(myRess.next()){
                if (textOldPass.getText().equals(myRess.getString("password"))){
                    if (textNewPass.getText().equals(textConfirmPass.getText())) {
                        if (textNewPass.getText().length()<4) {
                            JOptionPane.showMessageDialog(null, "Pastikan Minimal Password 8 Character");
                        }else{
                            try{
                                koneksi.createStatement().executeUpdate("UPDATE employee SET password = '"+textNewPass.getText()+"' WHERE karyawan_id = '"+MySession.get_karyawanID()+"'");

                                JOptionPane.showMessageDialog(null,"Password Berhasil di Perbarui");
                                //                            MainPanel().setVisible(true);

                            }catch(SQLException e){
                                JOptionPane.showMessageDialog(null,"Tidak dapat terhubung ke Jaringan Silahkan coba beberapa saat lagi");
                            }
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
    private CustomResource.PasswordField textConfirmPass;
    private CustomResource.PasswordField textNewPass;
    private CustomResource.PasswordField textOldPass;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
    }
}
