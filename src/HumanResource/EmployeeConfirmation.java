/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import CustomResource.CandidateSession;
import CustomResource.MySession;
import CustomResource.koneksi;
import Main.MasterForm;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author hi
 */
public class EmployeeConfirmation extends MasterForm {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    String tanggal;
    String da;
   
    JasperReport jasperreport;
    JasperDesign jasperdesign;
    JasperPrint jasperprint;
    Map<String, Object> param = new HashMap<String, Object>();

    /**
     * Creates new form EmployeeConfirmation
     */
    public EmployeeConfirmation() {
        initComponents();
        openDB();
        MyWindow();
        get_tanggal();
        jScrollPane3.getVerticalScrollBar().setUnitIncrement(16);
        getMyRole();
    }
    
    void get_tanggal() {
        Date ys = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yyy");
        tanggal = s.format(ys);
        l_tgl.setText(tanggal);
        l_emnama1.setText(MySession.get_nama());
        l_emnama.setText(MySession.get_nama());
        jLabel37.setText(MySession.get_JobPosition());
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        l_cadd = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        l_tgl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel38 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        l_hadd = new javax.swing.JLabel();
        l_name = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        l_emnama = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        l_email = new javax.swing.JLabel();
        l_ktp = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        l_emnama1 = new javax.swing.JLabel();
        l_name1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new CustomResource.ComboBoxSuggestion();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        l_hp = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel24.setText("A3. Position");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 850, -1, -1));

        l_date.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(l_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 180, 13));

        jLabel33.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel33.setText(":");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 790, 20, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel7.setText("A5. KTP No.");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel20.setText("A1. Name");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel22.setText("B1. Name");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 790, -1, -1));

        l_cadd.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(l_cadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 440, 13));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setText("A4. Current Address");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText(":");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 20, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel9.setText(":");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 20, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel23.setText("B2. Signature Date");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 820, -1, -1));

        l_tgl.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(l_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 820, 270, 13));

        jSeparator1.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 730, 880, 20));

        jLabel38.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel38.setText("Signature");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 550, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setText("A2. Signature Date");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel10.setText(":");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 20, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("B. EMPLOYMENT APPROVAL");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 750, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel12.setText(":");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 20, -1));

        jLabel37.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 850, 300, 13));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel11.setText(":");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 20, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setText("A3. Home Address");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));

        jLabel31.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel31.setText(":");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 850, 20, -1));
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 1140, -1, -1));

        l_hadd.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(l_hadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 440, 13));

        l_name.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        l_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_name.setText("asd");
        jPanel1.add(l_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 610, 270, 13));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel13.setText(":");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 20, -1));

        l_emnama.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        l_emnama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_emnama.setText("asd");
        jPanel1.add(l_emnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 1050, 270, 13));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("A. EMPLOYEE CONFIRMATION");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel8.setText("A7. E-mail.");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));

        l_email.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(l_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 230, 13));

        l_ktp.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(l_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 390, 13));

        jLabel40.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel40.setText("Signature");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 990, -1, -1));

        jLabel32.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel32.setText(":");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 820, 20, -1));
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 1140, 80, 20));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel25.setText("Select Candidate Employee");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 133, -1, 20));

        jToggleButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jToggleButton1.setText("Pilih / Select");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, -1, 30));

        l_emnama1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(l_emnama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 790, 270, 13));

        l_name1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(l_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 250, 13));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 255));
        jLabel14.setText("Employee Confirmation");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 240, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel15.setText("of Section A on behalf of The Company with the approval of The Company's Human Resources Director.");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 900, 610, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel16.setText("I (Employee) has confirmed all matters in accordance with The Company’s (means PT. ACHIVON PRESTASI ABADI’s)");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 610, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel17.setText("human resources management standard regulations from the date of signing this agreement, and as a result, I assure ");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 610, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel18.setText("that I will thoroughly perform and strictly comply with the tasks given and duties. In addition, I confirm that I will work");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 610, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel19.setText("very diligently without raising any objection in the overtime including working day and non-working day, special task");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, 610, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel26.setText("and special work at the request of The Company, and I made signature above on this employee confirmation.");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 610, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel27.setText("I confirm that the above Employee has signed the confirmation of Section A, and approve the hiring of the Employee");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 880, 610, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("Reject");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 1070, 130, 30));

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Sign");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1070, 130, 30));

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 255));
        jButton3.setText("Reject");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 640, 130, 30));

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Sign");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 640, 130, 30));

        jLabel28.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel28.setText("A6. Mobile (HP) No.");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setText(":");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 20, -1));

        l_hp.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(l_hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 230, 13));

        jToggleButton2.setText("jToggleButton2");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 1120, -1, -1));

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1229, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        addtext();  // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        Connection myConn;
//        try{
//            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
//            myConn.createStatement().executeUpdate("UPDATE cd_employee SET `approval` = '2', `approved_by` = '"+MySession.get_karyawanID()+"' WHERE KTP = '"+l_ktp.getText()+"'");
////            while (myRess.next()) {
////                JOptionPane.showMessageDialog(null, "Lamaran Berhasil diteruskan");
////            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
////                JOptionPane.showMessageDialog(null, "Lamaran gagal Diteruskan");
//            
//        }
        
// try {
//                   
//                    Class.forName("com.mysql.jdbc.Driver");
//String filePath = "src/Doc/notification_cd.pdf";
//                    Connection kon =DriverManager.getConnection("jdbc:mysql://localhost/achivonapp","root","");
//                    File O = new File("C:\\Users\\USER\\JaspersoftWorkspace\\MyReports\\notification_cd.jrxml");
//                    jasperdesign = JRXmlLoader.load(O);
////                    param.clear();
//                    jasperreport = JasperCompileManager.compileReport(jasperdesign);
////                    param.put("nama",l_name1.getText());
////                    param.put("tgl",tanggal);
//                    jasperprint = JasperFillManager.fillReport(jasperreport, param);
//                    JasperExportManager.exportReportToPdfFile(jasperprint, filePath);
//                    JasperViewer.viewReport(jasperprint, false);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }   
//



        String to = "lutfiwijhaya@gmail.com";
        String from = "lutfiwijhaya@achivon.co.id";
        String emailPassword = "Achivon123";
//        String emailPassword = "scqrsacneyuellbe";
        String subject = "EmployeeNotification";
        String testemail = "test doang \n baris baru";
        
        Properties proper = new Properties();
        proper.put("mail.smtp.auth","true");
        proper.put("mail.smtp.starttls.enable","true");
        proper.put("mail.smtp.ssl.protocols","TLSv1.2");
        proper.put("mail.smtp.host","mail.achivon.co.id");
        proper.put("mail.smtp.port","465");
            proper.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        

        
        Session mailSession = Session.getDefaultInstance(proper, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, emailPassword);
            }
            
        });
        try {
            MimeMessage myMessage = new MimeMessage(mailSession);
            myMessage.setFrom(new InternetAddress(from));
            myMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            myMessage.setSubject(subject);
            myMessage.setContent(testemail,"text/plain");
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            String file = "src/Doc/test.pdf";
            String fileName = "resume.pdf";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(source.getName());
            multipart.addBodyPart(messageBodyPart);
            myMessage.setContent(multipart);
            System.out.println("Sending");
            Transport.send(myMessage);
            System.out.println("Done");
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        try{
           koneksi.createStatement().executeUpdate("UPDATE cd_employee SET `approval` = '2', `approved_by` = '"+MySession.get_nama()+"' WHERE KTP = '"+l_ktp.getText()+"'");
//            while (myRess.next()) {
                JOptionPane.showMessageDialog(null, "berhasil tanda tangan \n Succesed signature");
//            }
        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
                JOptionPane.showMessageDialog(null, "gagal di tanda tangan \n Failed Signature");
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
  try {
                    Statement stm = koneksi.createStatement();

                    rs = stm.executeQuery("select*from cd_employee where KTP = " + l_ktp.getText() + "");
                    while (rs.next()) {
                        da = rs.getString("id_employee");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        
        try {

//                    Class.forName("com.mysql.jdbc.Driver");
//String filePath = "src/Doc/test.pdf";
                    Connection kon =DriverManager.getConnection("jdbc:mysql://localhost/achivonapp","root","");
//                    File O = new File("C:\\Program Files (x86)\\AchivonAPP\\cdemployee.jasper");
//                    jasperdesign = JRXmlLoader.load(O);
                    param.clear();
//                    jasperreport = JasperCompileManager.compileReport(jasperdesign);
                    param.put("id",da);
                    param.put("tgl",l_tgl.getText());
                    
//                    jasperprint = JasperFillManager.fillReport(jasperreport, param, kon);
//                    JasperExportManager.exportReportToPdfFile(jasperprint, filePath);
//                    JasperViewer.viewReport(jasperprint, false);
            String reportPath = "C:\\Users\\USER\\JaspersoftWorkspace\\MyReports\\notification_cd.jasper";
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, param, kon);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private CustomResource.ComboBoxSuggestion jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel l_cadd;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_email;
    private javax.swing.JLabel l_emnama;
    private javax.swing.JLabel l_emnama1;
    private javax.swing.JLabel l_hadd;
    private javax.swing.JLabel l_hp;
    private javax.swing.JLabel l_ktp;
    private javax.swing.JLabel l_name;
    private javax.swing.JLabel l_name1;
    private javax.swing.JLabel l_tgl;
    // End of variables declaration//GEN-END:variables
    private void MyWindow() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height - 45);
        this.setPreferredSize(new Dimension(screen.width, screen.height - 100));

//        int x = (screen.width/2) - (this.getSize().width/2);
//        int y = (screen.height/2) - (this.getSize().height/2);
//        this.setPreferredSize(x,y);
    }
    private void getMyRole(){
        if("2".equals(MySession.get_Role())){
            jLabel24.setVisible(false);
            jLabel33.setVisible(false);
            jLabel22.setVisible(false);
            jLabel23.setVisible(false);
            l_tgl.setVisible(false);
            jLabel27.setVisible(false);
            jLabel31.setVisible(false);
            l_emnama.setVisible(false);
            jLabel40.setVisible(false);
            jLabel32.setVisible(false);
            l_emnama1.setVisible(false);
            jLabel31.setVisible(false);
            jLabel21.setVisible(false);
            jLabel15.setVisible(false);
            jLabel37.setVisible(false);
//            labelName.setVisible(false);
            jSeparator1.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select * from cd_employee WHERE approval = '1'");
                while (rs.next()) {
                    jComboBox1.addItem(rs.getString(2).trim());
                    addtext();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            jButton4.setVisible(false);
            jButton3.setVisible(false);
            
            try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select * from cd_employee WHERE approval = '2'");
                while (rs.next()) {
                    jComboBox1.addItem(rs.getString(2).trim());
                    addtext();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void addtext() {

        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select * from cd_employee inner join cd_adress on cd_employee.id_employee = cd_adress.id_employee where Nama = '" + jComboBox1.getSelectedItem() + "'");

            while (rs.next()) {
                
                l_name1.setText(rs.getString(2).trim());
                l_name.setText(rs.getString(18));
                l_date.setText(rs.getString(15).trim());
                l_ktp.setText(rs.getString(3).trim());
                l_hp.setText(rs.getString(10).trim());
                l_hadd.setText(rs.getString(32).trim());
                l_cadd.setText(rs.getString(33).trim());
                l_email.setText(rs.getString(4).trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @Override
    public void formrefresh() {
    }
}
