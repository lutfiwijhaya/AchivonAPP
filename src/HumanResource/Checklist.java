/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import CustomResource.MySession;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import CustomResource.koneksi;
import static HumanResource.AllocationAnnouncement.textDescription;
import static HumanResource.AllocationAnnouncement.textDiscipline;
import static HumanResource.AllocationAnnouncement.textJoinDate;
import static HumanResource.AllocationAnnouncement.textName;
import static HumanResource.AllocationAnnouncement.textPosition;
import Main.MasterForm;
import com.toedter.calendar.JCalendar;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jnafilechooser.api.JnaFileChooser;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author hi
 */
public class Checklist extends MasterForm {
    Statement stm;
    ResultSet rs;
    Connection koneksi;
    JasperReport jasperreport;
    JasperDesign jasperdesign;
    JasperPrint jasperprint;
    Map<String, Object> param = new HashMap<String, Object>();
    DefaultTableModel myModel;
     String id = null;

    public Checklist() {
        initComponents();
        openDB();
        myShow();
        MyWindow();
        ((DefaultTableCellRenderer)MyTable.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);

    }
    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }
    
    private void track(){
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("SELECT * FROM employee WHERE id =" +CustomResource.EmployeeSession.getKTPAllocation()+ "");
            while (rs.next()) {
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new scroolbarWin11.ScrollPaneWin11();
        MyTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        textSearch = new CustomResource.CustomTextfield();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 585));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null,  new Boolean(true),  new Boolean(true),  new Boolean(true),  new Boolean(true),  new Boolean(true),  new Boolean(true),  new Boolean(true),  new Boolean(true),  new Boolean(true),  new Boolean(true),  new Boolean(true),  new Boolean(true),  new Boolean(true),  new Boolean(true),  new Boolean(true), null}
            },
            new String [] {
                "id", "Karyawan Id / Employee Id", "Nama / Name", "KTP", "application form", "summary status", "Resume", "self introduction", "academic certificate", "Career and certificate", "personal identification card", "photo", "police statement", "Bank Account", "report medical check up", "family certificate", "tax identification", "BPJS Kesehatan", "BPJS Ketenagakerjaan", "family contact point"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MyTable.setAutoResizeMode(0);
        MyTable.setRowHeight(40);
        MyTable.setShowHorizontalLines(true);
        MyTable.setShowVerticalLines(true);
        MyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MyTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MyTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(MyTable);
        if (MyTable.getColumnModel().getColumnCount() > 0) {
            MyTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            MyTable.getColumnModel().getColumn(1).setPreferredWidth(170);
            MyTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            MyTable.getColumnModel().getColumn(3).setMinWidth(130);
            MyTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            MyTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            MyTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            MyTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            MyTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            MyTable.getColumnModel().getColumn(8).setPreferredWidth(120);
            MyTable.getColumnModel().getColumn(9).setPreferredWidth(150);
            MyTable.getColumnModel().getColumn(10).setPreferredWidth(170);
            MyTable.getColumnModel().getColumn(11).setPreferredWidth(100);
            MyTable.getColumnModel().getColumn(12).setPreferredWidth(100);
            MyTable.getColumnModel().getColumn(13).setPreferredWidth(100);
            MyTable.getColumnModel().getColumn(14).setPreferredWidth(150);
            MyTable.getColumnModel().getColumn(15).setPreferredWidth(100);
            MyTable.getColumnModel().getColumn(16).setPreferredWidth(100);
            MyTable.getColumnModel().getColumn(17).setPreferredWidth(120);
            MyTable.getColumnModel().getColumn(18).setPreferredWidth(150);
            MyTable.getColumnModel().getColumn(19).setPreferredWidth(170);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 850, 180));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Daftar Kelengkapan Dokumen karyawan /  Complete list of employee documents");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 450, 40));

        jSeparator1.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 740, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Logo4.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, -1, -1));

        textSearch.setLabelText("Cari / Search");
        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSearchKeyTyped(evt);
            }
        });
        jPanel1.add(textSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 460, -1));

        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("Save as excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 510, -1, -1));

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 510, -1, -1));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1295, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MyTableMouseClicked

    private void textSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyTyped
        myShow();
    }//GEN-LAST:event_textSearchKeyTyped

    private void MyTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MyTableMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tracer();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        saving();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MyTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private CustomResource.CustomTextfield textSearch;
    // End of variables declaration//GEN-END:variables

    private void myShow() {
        Connection myConn;
        String mySearch = textSearch.getText();
        DefaultTableModel model = (DefaultTableModel) MyTable.getModel();
//        int rowCount = model.getRowCount();
//        for(int i = 0; i < rowCount; i++){
//            model.removeRow(i);
//        }
        if (mySearch != null){
            int row = MyTable.getRowCount();
            for(int i = 0; i < row; i++){
                model.removeRow(0);
            }
            try {
                myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
                ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM employee WHERE status_employee = 1 AND name LIKE '%" + mySearch + "%'");
                int i = 1;
                while (myRess.next()) {
                    String myData [] = {myRess.getString(1), myRess.getString(2),myRess.getString(4), myRess.getString(3)};
                    model.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        }else{
            try {
                myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
                ResultSet myRess1 = myConn.createStatement().executeQuery("SELECT * FROM employee WHERE status_employee = 1 ORDER BY karyawan_id ASC");
                int i = 1;
                while (myRess1.next()) {
                    String myData [] = {myRess1.getString(1), myRess1.getString(2),myRess1.getString(4), myRess1.getString(3)};
                    model.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        }
    }
    
    private void saving(){
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        try{
            DefaultTableModel model = (DefaultTableModel) MyTable.getModel();
            int rowCount = model.getRowCount();
            int colCount = model.getColumnCount();
            String[] columns = {
                "aplication_form=? ",
                "summary=? ",
                "resume=? ",
                "self=? ",
                "academic_certificate=? ",
                "career_certificate=? ",
                "personal_id_card=? ",
                "photo=? ",
                "skck=? ",
                "bank=? ",
                "report_mcu=? ",
                "family_cerificate=? ",
                "npwp=? ",
                "bpjs_kesehatan=? ",
                "bpjs_tenaga_kerja=? ",
                "family_contact_point=? "
            };
            int count = 0;
            for(int row = 0; row < rowCount; row++){
                System.out.println(model.getValueAt(row, 1) + "\t");
                for(int col = 4; col < colCount; col++){
                    String sql = "UPDATE checklist SET "
                        + columns[count]
                        + "WHERE karyawan_id=?";
//                    pstmt = koneksi.prepareStatement(sql);
//                    String sql = "UPDATE checklist SET"
//                            + "aplication_form=?, "
//                            + "summary=?, "
//                            + "resume=?, "
//                            + "self=?, "
//                            + "academic_certificate=?, "
//                            + "career_certificate=?, "
//                            + "personal_id_card=?, "
//                            + "photo=?, "
//                            + "skck=?, "
//                            + "bank=?, "
//                            + "report_mcu=?, "
//                            + "family_cerificate=?, "
//                            + "npwp=?, "
//                            + "bpjs_kesehatan=?, "
//                            + "bpjs_tenaga_kerja=?, "
//                            + "family_contact_point=? "
//                            + "WHERE karyawan_id=?";

                    Object isChecked3 = (Boolean)model.getValueAt(row, col);
                    if (isChecked3 != null) {
//                        pstmt.setString(1, "1");
                        System.out.println(columns[count] + ", 1" + "\t");
                    }else{
//                        pstmt.setString(1, "0");
                        System.out.println(columns[count] + ", 0" + "\t");
                    }
                    
//                    pstmt.setString(2, model.getValueAt(row, 1).toString());
//                    pstmt.executeUpdate();
                    
                    count++;
                    if (count == 16) {
                        count = 0; 
                    }
                }
            }
        }catch (Error e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan \nFailed to save data");
            e.printStackTrace();
        } finally {
        }
    }
    
    private void tracer(){
        JCalendar date = new JCalendar();
        Date currentDate = date.getDate();
        DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        
        String templateFilePath = "src/Doc/Check Employee Document.xlsx";
        
        try {
            FileInputStream templateFile = new FileInputStream(templateFilePath);
            Workbook workbook = new XSSFWorkbook(templateFile);
            
            Sheet sheet = workbook.getSheet("Sheet1");
            
            DefaultTableModel model = (DefaultTableModel) MyTable.getModel();
            int rowCount = model.getRowCount();
            int colCount = model.getColumnCount();
            int mynum = 1;
            
            sheet.getRow(1).getCell(0).setCellValue("Tanggal Updated : " + sdf.format(currentDate));
            
            for (int i = 0; i < rowCount; i++) {
                String description = (String) model.getValueAt(i, 1);
                String description1 = (String) model.getValueAt(i, 2);
                String description2 = (String) model.getValueAt(i, 3);
                    
                sheet.getRow(5+i).getCell(0).setCellValue(mynum);
                sheet.getRow(5+i).getCell(1).setCellValue(description);
                sheet.getRow(5+i).getCell(2).setCellValue(description1);
                sheet.getRow(5+i).getCell(3).setCellValue(description2);
                for (int col = 4;  col < colCount; col++) {
                    Object value = model.getValueAt(i, col);
                    if (value != null && value instanceof Boolean == true) {
                        sheet.getRow(5+i).getCell(col).setCellValue("✓");
                    }else{
                        sheet.getRow(5+i).getCell(col).setCellValue("-");
                    }
                }
                mynum++;
            }
            
            templateFile.close();

            JnaFileChooser fileChooser = new JnaFileChooser();
            fileChooser.setTitle("Simpan File Output");
            fileChooser.addFilter("Excel Files", "xlsx");
            boolean userSelection = fileChooser.showSaveDialog(null);

            if (userSelection) {
                File outputFile = fileChooser.getSelectedFile();
                String outputFilePath = outputFile.getAbsolutePath();
                if (!outputFilePath.toLowerCase().endsWith(".xlsx")) {
                    outputFilePath += ".xlsx";
                    outputFile = new File(outputFilePath);
                }
                int count = 1;
                while (outputFile.exists()) {
                    String newFileName = outputFile.getName().replaceFirst("[.][^.]+$", "") + "(" + count + ")"
                            + outputFile.getName().substring(outputFile.getName().lastIndexOf("."));
                    String parentDirectory = outputFile.getParent();
                    outputFilePath = parentDirectory + File.separator + newFileName;
                    outputFile = new File(outputFilePath);
                    count++;
                }
                FileOutputStream outputFileStream = new FileOutputStream(outputFile);
                workbook.write(outputFileStream);
                workbook.close();
                outputFileStream.close();
            } else {
                
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Sorry, Something went Wrong");
        }
    }
    
    private void MyWindow(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height);
        this.setPreferredSize(new Dimension(screen.width, screen.height));
    }

    @Override
    public void formrefresh() {
    }
}
