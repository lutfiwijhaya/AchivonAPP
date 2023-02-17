/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import Main.MasterForm;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author hi
 */
public class AllocationAnnouncement extends MasterForm {
    DefaultTableModel myModel3;
    /**
     * Creates new form AllocationAnnouncement
     */
    public AllocationAnnouncement() {
        initComponents();
        
        
        MyWindow();
//        myModel3 = new DefaultTableModel();
//        String [] header = {"Name", "Discipline", "Position", "Description Alocation", "Initial Join Date", "Alocation Date"};
//        
        ((DefaultTableCellRenderer)jTable1.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);
//        jTable1.setModel(myModel3);
        tampil();
    }

    private void tampil() {
        Connection myConn;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM employee");
            while (myRess.next()) {
                textSearch.addItem(myRess.getString("name"));
            }
        } catch (SQLException ex) {
        }
        textSearch.setEnabled(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textSearch = new CustomResource.ComboBoxSuggestion();
        textName = new CustomResource.CustomTextfield();
        textDiscipline = new CustomResource.CustomTextfield();
        textPosition = new CustomResource.CustomTextfield();
        textDescription = new CustomResource.CustomTextfield();
        textJoinDate = new CustomResource.CustomTextfield();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        t_tgl = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Dicipline", "Position", "Description Allocation", "Initial Join Date", "Alocation Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 311, 804, 120));

        jButton2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 255));
        jButton2.setText("Back / Kembali");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 190, 40));

        jButton3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 255));
        jButton3.setText("Batal / Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 430, 140, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Allocation Announcement");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 320, 40));

        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });
        add(textSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 270, -1));

        textName.setLabelText("Name");
        add(textName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 280, -1));

        textDiscipline.setLabelText("Discipline");
        add(textDiscipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 280, -1));

        textPosition.setLabelText("Position");
        add(textPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 280, -1));

        textDescription.setLabelText("Description Allocation");
        add(textDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 280, -1));

        textJoinDate.setLabelText("Initial Join Date");
        add(textJoinDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 280, -1));

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Send / Kirim");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 530, 190, 40));

        jButton5.setBackground(new java.awt.Color(51, 51, 255));
        jButton5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Tambah / Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 240, 130, 40));

        t_tgl.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        add(t_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 190, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        Connection myConn;
        try {

            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM employee WHERE name ='" + textSearch.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                textName.setText(myRess.getString("name"));
                textPosition.setText(myRess.getString("job_position"));
                textDiscipline.setText(myRess.getString("job_position"));
                textJoinDate.setText(myRess.getString("birthday"));
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_textSearchActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        SimpleDateFormat fm = new SimpleDateFormat("dd-MMM-yyyy");
        String tanggal = String.valueOf(fm.format(t_tgl.getDate()));
           
        DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
        List list = new ArrayList<>();
        jTable1.setAutoCreateColumnsFromModel(true);
        list.add(textName.getText());
        list.add(textDiscipline.getText());
        list.add(textPosition.getText());
        list.add(textDescription.getText());
        list.add(textJoinDate.getText());
        list.add(tanggal);
        dataModel.addRow(list.toArray());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.removeRow( row );
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel tabelfamily = (DefaultTableModel) jTable1.getModel();
        int htabelfamily = jTable1.getRowCount();
        String to = "ririnwahyuni998@gmail.com";
        String from = "erlanggamurti@gmail.com";
        String emailPassword = "ymcnciygeelburto";
        String subject = "AllocationAnnouncement";
        
        
        Properties proper = new Properties();
        proper.put("mail.smtp.auth","true");
        proper.put("mail.smtp.starttls.enable","true");
        proper.put("mail.smtp.ssl.protocols","TLSv1.2");
        proper.put("mail.smtp.host","smtp.gmail.com");
        proper.put("mail.smtp.port","587");
        for (int i = 0; i <= htabelfamily - 1; i++) {
            if (jTable1.getValueAt(i, 0) == null) {
            }else{
                String dtabel_desc = jTable1.getValueAt(i, 3).toString();
                Session mailSession = Session.getDefaultInstance(proper, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, emailPassword);
                }});
                try {
                    String testemail = dtabel_desc;
                    MimeMessage myMessage = new MimeMessage(mailSession);
                    myMessage.setFrom(new InternetAddress(from));
                    myMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    myMessage.setSubject(subject);
                    myMessage.setContent(testemail,"text/plain");
                    MimeBodyPart messageBodyPart = new MimeBodyPart();

                    Multipart multipart = new MimeMultipart();

                    String file = "src/Doc/HAII TESTING.docx";
                    String fileName = "Doc.docx";
                    DataSource source = new FileDataSource(file);
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName(fileName);
                    messageBodyPart.setText(dtabel_desc);
       

                    multipart.addBodyPart(messageBodyPart);

                    myMessage.setContent(multipart);

                    System.out.println("Sending");

                    Transport.send(myMessage);

                    System.out.println("Done");
                } catch (MessagingException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser t_tgl;
    private CustomResource.CustomTextfield textDescription;
    private CustomResource.CustomTextfield textDiscipline;
    private CustomResource.CustomTextfield textJoinDate;
    private CustomResource.CustomTextfield textName;
    private CustomResource.CustomTextfield textPosition;
    private CustomResource.ComboBoxSuggestion textSearch;
    // End of variables declaration//GEN-END:variables
    
    private void myShow() {
        Connection myConn;
        String mySearch = textSearch.getSelectedItem().toString();
        int row = jTable1.getRowCount();
        for(int i = 0; i < row; i++){
            myModel3.removeRow(0);
        }
        if (mySearch != null) {
            try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM employee WHERE name LIKE '%"+mySearch+"%'");
            while (myRess.next()) {
                String myData [] = {myRess.getString(4),myRess.getString(13),myRess.getString(13)};
                myModel3.addRow(myData);
            }
            } catch (SQLException ex) {
//                Logger.getLogger(CandidateList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
                ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM employee");
                while (myRess.next()) {
                    
                    String myData [] = {myRess.getString(4),myRess.getString(13),myRess.getString(13)};
                    myModel3.addRow(myData);
                
                }
            } catch (SQLException ex) {
//                Logger.getLogger(CandidateList.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println("javaapplication1.CandidateList.myShow()");
            }
        }
    }
    
    private void MyWindow(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height-45);
        this.setPreferredSize(new Dimension(screen.width, screen.height-100));
    }
    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
