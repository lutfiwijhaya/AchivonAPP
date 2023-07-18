/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import CustomResource.koneksi;
import Main.MasterForm;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author hi
 */
public class AllocationAnnouncement extends MasterForm {
    public static Connection koneksi;
    public static Statement stm;
    public static ResultSet rs;
    String mail;
    public AllocationAnnouncement() {
        initComponents();
        openDB();
        MyWindow();
        ((DefaultTableCellRenderer)jTable1.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);
        addtext();
    }
    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }
    public static void addtext() {
        
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("SELECT * FROM employee WHERE id =" +CustomResource.EmployeeSession.getKTPAllocation()+ "");
            while (rs.next()) {
                textName.setText(rs.getString("name"));
                textPosition.setText(rs.getString("job_position"));
                textDiscipline.setText(rs.getString("job_position"));
                textJoinDate.setText(rs.getString("birthday"));
                textDescription.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jScrollPane1 = new scroolbarWin11.ScrollPaneWin11();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textName = new CustomResource.CustomTextfield();
        textDiscipline = new CustomResource.CustomTextfield();
        textPosition = new CustomResource.CustomTextfield();
        textDescription = new CustomResource.CustomTextfield();
        textJoinDate = new CustomResource.CustomTextfield();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        t_tgl = new CustomResource.CustomTextfield();
        jButton1 = new javax.swing.JButton();

        dateChooser1.setForeground(new java.awt.Color(51, 51, 255));
        dateChooser1.setTextRefernce(t_tgl);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Dicipline", "Position", "Description Allocation", "Initial Join Date", "Alocation Date", "email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        }

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

        textName.setLabelText("Nama / Name");
        add(textName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 280, -1));

        textDiscipline.setLabelText(" Disiplin / Discipline");
        add(textDiscipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 280, -1));

        textPosition.setLabelText("Posisi / Position");
        add(textPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 280, -1));

        textDescription.setLabelText("Deskripsi Alokasi / Description Allocation");
        add(textDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 280, -1));

        textJoinDate.setLabelText("Tanggal Bergabung / Initial Join Date");
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

        t_tgl.setLabelText("Tanggal Alokasi / Allocation Date");
        t_tgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_tglActionPerformed(evt);
            }
        });
        add(t_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 170, -1));

        jButton1.setText("Ambil/Take Data Emoloyee");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 180, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("SELECT * FROM employee WHERE id =" +CustomResource.EmployeeSession.getKTPAllocation()+ "");
            while (rs.next()) {
                mail = rs.getString("email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
        
        String[] rowData = new String[7];
        rowData[0] = textName.getText();
        rowData[1] = textDiscipline.getText();
        rowData[2] = textPosition.getText();
        rowData[3] = textDescription.getText();
        rowData[4] = textJoinDate.getText();
        rowData[5] = t_tgl.getText();
        rowData[6] = mail;
        dataModel.addRow(rowData);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.removeRow( row );
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel tabelfamily = (DefaultTableModel) jTable1.getModel();
        int htabelfamily = jTable1.getRowCount();
        String subject = "Allocation Announcement";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        for (int i = 0; i <= htabelfamily - 1; i++) {
            if (jTable1.getValueAt(i, 0) == null) {
            }else{
                String dtabel_desc = jTable1.getValueAt(i, 3).toString();
                final String username = "yourmurti@gmail.com";
                final String password = "ordaawiiidswfwww";

                Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    }
                );
                try {
                    for ( i = 0; i <= htabelfamily - 1; i++) {
                        try {
                            String templateFilePath = "src/Doc/Allocation Announcement1.xlsx";
                            String outputFilePath = "src/Doc/Allocation Announcement.xlsx";
                            
                            File outputFile = new File(outputFilePath);
                            if (outputFile.exists()) {
                                outputFile.delete();
                                System.out.println("terhapus");
                            }
                            
                            FileInputStream templateFile = new FileInputStream(templateFilePath);
                            Workbook workbook = new XSSFWorkbook(templateFile);

                            Sheet sheet = workbook.getSheet("Sheet1");

                            sheet.getRow(9).getCell(0).setCellValue((String) tabelfamily.getValueAt(i, 0));
                            sheet.getRow(9).getCell(2).setCellValue((String) tabelfamily.getValueAt(i, 1));
                            sheet.getRow(9).getCell(3).setCellValue((String) tabelfamily.getValueAt(i, 2));
                            sheet.getRow(9).getCell(4).setCellValue((String) tabelfamily.getValueAt(i, 3));
                            sheet.getRow(9).getCell(6).setCellValue((String) tabelfamily.getValueAt(i, 4));
                            sheet.getRow(9).getCell(8).setCellValue((String) tabelfamily.getValueAt(i, 5));

                            templateFile.close();
                            
                            FileOutputStream outputStream = new FileOutputStream(outputFile);
                            workbook.write(outputStream);
                            workbook.close();
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        
                        String filePath = "src/Doc/Allocation Announcement.xlsx";
                        
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(username));
                        message.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse((String) tabelfamily.getValueAt(i, 6)));
                        message.setSubject(subject);

                        MimeBodyPart messageBodyPart = new MimeBodyPart();
                        messageBodyPart.setText((String) tabelfamily.getValueAt(i, 3));

                        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                        
                        attachmentBodyPart.attachFile(filePath);
                        Multipart multipart = new MimeMultipart();
                        multipart.addBodyPart(messageBodyPart);
                        multipart.addBodyPart(attachmentBodyPart);
                        message.setContent(multipart);
                        Transport.send(message);
                    }
                    JOptionPane.showMessageDialog(this, "successfully sent message\nBerhasil Mengirim Pesan");
                } catch (MessagingException e) {
                    JOptionPane.showMessageDialog(this, "Failed to send message\nGagal mengirim Pesan");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Sorry, Something went wrong\nMaaf, terjadi kesalahan");
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CustomResource.EmployeeSession.setsesiform("2");
        new HumanResourceEmployeeList().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void t_tglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_tglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_tglActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public static CustomResource.CustomTextfield t_tgl;
    public static CustomResource.CustomTextfield textDescription;
    public static CustomResource.CustomTextfield textDiscipline;
    public static CustomResource.CustomTextfield textJoinDate;
    public static CustomResource.CustomTextfield textName;
    public static CustomResource.CustomTextfield textPosition;
    // End of variables declaration//GEN-END:variables
    
    private void MyWindow(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height-45);
        this.setPreferredSize(new Dimension(screen.width, screen.height-100));
    }
    @Override
    public void formrefresh() {
    }
}
