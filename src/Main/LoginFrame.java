/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

//import com.sun.jdi.connect.spi.Connection;
import CustomResource.Welcome;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import CustomResource.MySession;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author hi
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        super("ACV-OS-Login");
        initComponents();
        MyWindow();
        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource(".//Pictures//Logo.png"));
        this.setIconImage(logo.getImage());
//        openeye.setVisible(false);
//        openeye1.setVisible(false);
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
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textKaryawanid = new CustomResource.CustomFormatField();
        textMail = new CustomResource.CustomTextfield();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textRepeatPassword = new CustomResource.PasswordField();
        textPassword = new CustomResource.PasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PT.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 40, 20));

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 260, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Achivon");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 70, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Prestasi Abadi");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 120, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Logo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 200, 130));

        try {
            textKaryawanid.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("U-#-######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textKaryawanid.setLabelText("id Karyawan / Employee id");
        textKaryawanid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textKaryawanidKeyPressed(evt);
            }
        });
        jPanel1.add(textKaryawanid, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 260, -1));

        textMail.setLabelText("Email");
        textMail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textMailKeyPressed(evt);
            }
        });
        jPanel1.add(textMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 260, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/envelope.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/person.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/password.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/password.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        textRepeatPassword.setLabelText("Konfirmasi Password / Confirm Password");
        textRepeatPassword.setShowAndHide(true);
        textRepeatPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textRepeatPasswordKeyPressed(evt);
            }
        });
        jPanel1.add(textRepeatPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 260, -1));

        textPassword.setLabelText("Kata Sandi / Password");
        textPassword.setShowAndHide(true);
        textPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textPasswordKeyPressed(evt);
            }
        });
        jPanel1.add(textPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 260, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Welcome to ACV's Operation System (Login)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("All rights reserved by PT. Achivon Prestasi Abadi®");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 784, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(135, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(7, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Sign in");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 240, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection myConn;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet  myRess = myConn.createStatement().executeQuery("SELECT * FROM employee WHERE karyawan_id = '"+textKaryawanid.getText()+"'");
            if(myRess.next()){
                if (textPassword.getText().length()<4) {
                    JOptionPane.showMessageDialog(null, "Pastikan kata sandi Manimal 4 karakter \n Make sure the password is at least 4 characters");
                }else{
                    if (textPassword.getText().equals(textRepeatPassword.getText())) {
                        if (textMail.getText().equals(myRess.getString("email"))){
                            if (textPassword.getText().equals(myRess.getString("password"))) {
                                JOptionPane.showMessageDialog(null, "Berhasil Login \n successfully logged in");
                                MySession.set_karyawanID(myRess.getString("karyawan_id"));
                                MySession.set_nama(myRess.getString("name"));
                                MySession.set_ktp(myRess.getString("ktp"));
                                MySession.set_birthPlace(myRess.getString("birth_place"));
                                MySession.set_Birthday(myRess.getString("birthday"));
                                MySession.set_sex(myRess.getString("sex"));
                                MySession.set_marital(myRess.getString("marital"));
                                MySession.set_email(myRess.getString("email"));
                                MySession.set_mobileNumber(myRess.getString("no_hp"));
                                MySession.set_BPJS(myRess.getString("bpjs"));
                                MySession.set_NPWP(myRess.getString("npwp"));
                                MySession.set_JobPosition(myRess.getString("job_position"));
                                MySession.set_Sallary(myRess.getString("sallary"));
                                new Welcome().setVisible(true);
                                this.dispose();
                            }else{
                                JOptionPane.showMessageDialog(rootPane,"Kata Sandi Anda Salah \n your password is wrong");
                                textPassword.setText("");
                                textRepeatPassword.setText("");
                                textPassword.requestFocus();
                            }        
                        }else{
                            JOptionPane.showMessageDialog(rootPane,"Surel Anda Tidak Sesuai \n Your Email does not Match");
                            textMail.setText("");
                            textMail.requestFocus();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Kata Sandi dan Konfirmasi kata Sandi anda Tidak Sesuai \n Your Password and Confirm Password Doesn't Match");
                        textPassword.setText("");
                        textRepeatPassword.setText("");
                        textPassword.requestFocus();
                    }
                }
            }else {
                JOptionPane.showMessageDialog(rootPane, "pengguna Tidak Ditemukan \n User not Found");
                textKaryawanid.setText("");
                textPassword.setText("");
                textRepeatPassword.setText("");
                textMail.setText("");
                textKaryawanid.requestFocus();
                
            }
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Mendapatkan Informasi \n Failed to Retrieve Information");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textKaryawanidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textKaryawanidKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            textPassword.requestFocus();
        }
    }//GEN-LAST:event_textKaryawanidKeyPressed

    private void textPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPasswordKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            textRepeatPassword.requestFocus();
        }
    }//GEN-LAST:event_textPasswordKeyPressed

    private void textRepeatPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textRepeatPasswordKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            textMail.requestFocus();
        }
    }//GEN-LAST:event_textRepeatPasswordKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            Connection myConn;
            try {
                myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
                ResultSet  myRess = myConn.createStatement().executeQuery("SELECT * FROM employee WHERE karyawan_id = '"+textKaryawanid.getText()+"'");
                if(myRess.next()){
                    if (textPassword.getText().length()<4) {
                        JOptionPane.showMessageDialog(null, "Pastikan kata sandi Manimal 4 karakter \n Make sure the password is at least 4 characters");
                    }else{
                        if (textPassword.getText().equals(textRepeatPassword.getText())) {
                            if (textMail.getText().equals(myRess.getString("email"))){
                                if (textPassword.getText().equals(myRess.getString("password"))) {
                                    JOptionPane.showMessageDialog(null, "Berhasil Login \n successfully logged in");
                                    MySession.set_karyawanID(myRess.getString("karyawan_id"));
                                    MySession.set_nama(myRess.getString("name"));
                                    MySession.set_ktp(myRess.getString("ktp"));
                                    MySession.set_birthPlace(myRess.getString("birth_place"));
                                    MySession.set_Birthday(myRess.getString("birthday"));
                                    MySession.set_sex(myRess.getString("sex"));
                                    MySession.set_marital(myRess.getString("marital"));
                                    MySession.set_email(myRess.getString("email"));
                                    MySession.set_mobileNumber(myRess.getString("no_hp"));
                                    MySession.set_BPJS(myRess.getString("bpjs"));
                                    MySession.set_NPWP(myRess.getString("npwp"));
                                    MySession.set_JobPosition(myRess.getString("job_position"));
                                    MySession.set_Sallary(myRess.getString("sallary"));
                                    new Welcome().setVisible(true);
                                    this.dispose();
                                }else{
                                    JOptionPane.showMessageDialog(rootPane,"Kata Sandi Anda Salah \n your password is wrong");
                                    textPassword.setText("");
                                    textRepeatPassword.setText("");
                                    textPassword.requestFocus();
                                }        
                            }else{
                                JOptionPane.showMessageDialog(rootPane,"Surel Anda Tidak Sesuai \n Your Email does not Match");
                                textMail.setText("");
                                textMail.requestFocus();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Kata Sandi dan Konfirmasi kata Sandi anda Tidak Sesuai \n Your Password and Confirm Password Doesn't Match");
                            textPassword.setText("");
                            textRepeatPassword.setText("");
                            textPassword.requestFocus();
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(rootPane, "pengguna Tidak Ditemukan \n User not Found");
                    textKaryawanid.setText("");
                    textPassword.setText("");
                    textRepeatPassword.setText("");
                    textMail.setText("");
                    textKaryawanid.requestFocus();

                }
            }catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Mendapatkan Informasi \n Failed to Retrieve Information");
            }
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void textMailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMailKeyPressed
        int key = evt.getKeyCode();
        if (key == 10) {
            Connection myConn;
            try {
                myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
                ResultSet  myRess = myConn.createStatement().executeQuery("SELECT * FROM employee WHERE karyawan_id = '"+textKaryawanid.getText()+"'");
                if(myRess.next()){
                    if (textPassword.getText().length()<4) {
                        JOptionPane.showMessageDialog(null, "Pastikan kata sandi Manimal 4 karakter \n Make sure the password is at least 4 characters");
                    }else{
                        if (textPassword.getText().equals(textRepeatPassword.getText())) {
                            if (textMail.getText().equals(myRess.getString("email"))){
                                if (textPassword.getText().equals(myRess.getString("password"))) {
                                    JOptionPane.showMessageDialog(null, "Berhasil Login \n successfully logged in");
                                    MySession.set_karyawanID(myRess.getString("karyawan_id"));
                                    MySession.set_nama(myRess.getString("name"));
                                    MySession.set_ktp(myRess.getString("ktp"));
                                    MySession.set_birthPlace(myRess.getString("birth_place"));
                                    MySession.set_Birthday(myRess.getString("birthday"));
                                    MySession.set_sex(myRess.getString("sex"));
                                    MySession.set_marital(myRess.getString("marital"));
                                    MySession.set_email(myRess.getString("email"));
                                    MySession.set_mobileNumber(myRess.getString("no_hp"));
                                    MySession.set_BPJS(myRess.getString("bpjs"));
                                    MySession.set_NPWP(myRess.getString("npwp"));
                                    MySession.set_JobPosition(myRess.getString("job_position"));
                                    MySession.set_Sallary(myRess.getString("sallary"));
                                    new Welcome().setVisible(true);
                                    this.dispose();
                                }else{
                                    JOptionPane.showMessageDialog(rootPane,"Kata Sandi Anda Salah \n your password is wrong");
                                    textPassword.setText("");
                                    textRepeatPassword.setText("");
                                    textPassword.requestFocus();
                                }        
                            }else{
                                JOptionPane.showMessageDialog(rootPane,"Surel Anda Tidak Sesuai \n Your Email does not Match");
                                textMail.setText("");
                                textMail.requestFocus();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Kata Sandi dan Konfirmasi kata Sandi anda Tidak Sesuai \n Your Password and Confirm Password Doesn't Match");
                            textPassword.setText("");
                            textRepeatPassword.setText("");
                            textPassword.requestFocus();
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(rootPane, "pengguna Tidak Ditemukan \n User not Found");
                    textKaryawanid.setText("");
                    textPassword.setText("");
                    textRepeatPassword.setText("");
                    textMail.setText("");
                    textKaryawanid.requestFocus();

                }
            }catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Gagal Mendapatkan Informasi \n Failed to Retrieve Information");
            }
        }
    }//GEN-LAST:event_textMailKeyPressed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private CustomResource.CustomFormatField textKaryawanid;
    private CustomResource.CustomTextfield textMail;
    private CustomResource.PasswordField textPassword;
    private CustomResource.PasswordField textRepeatPassword;
    // End of variables declaration//GEN-END:variables
    private void MyWindow(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setSize(screen.width, screen.height-45);
//        this.setPreferredSize(new Dimension(screen.width, screen.height-100));
        
        int x = (screen.width/2) - (this.getSize().width/2);
        int y = (screen.height/2) - (this.getSize().height/2);
        this.setLocation(x,y);
    }
}
