/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import CustomResource.EmployeeSession;
import CustomResource.koneksi;
import Main.MasterForm;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;

/**
 *
 * @author hi
 */
public class ClearanceList extends MasterForm {
    Statement stm;
    ResultSet rs;
    Connection koneksi;
    JasperReport jasperreport;
    JasperDesign jasperdesign;
    JasperPrint jasperprint;
    Map<String, Object> param = new HashMap<String, Object>();
    DefaultTableModel myModel;
    String id = null;

    public ClearanceList() {
        initComponents();
        openDB();
        settable();
        myShow();
        MyWindow();
//        CandidateSession.setCandidateID("");
        ((DefaultTableCellRenderer)MyTable.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);
    }
    void  settable (){
        String [] header = {"id","Karyawan Id / Employee Id", "KTP", "Nama / Name", "Email", "No. Hp", "Posisi / Job Position", "Disiplin / Discipline", "Tanggal pengunduran diri / Resignation Date"};
        myModel = new DefaultTableModel(header,0);
        MyTable.setModel(myModel);
//        actiontable event = new actiontable() {
//            @Override
//            public void lihat(int row) {
//                try {
//                    String tnama = (String) MyTable.getValueAt(row, 1);
//                    String email = (String) MyTable.getValueAt(row, 5);
//                    id = (String) MyTable.getValueAt(row, 0);
//                    Class.forName("com.mysql.jdbc.Driver");
//
//                    File O = new File("C:\\Users\\USER\\JaspersoftWorkspace\\MyReports\\cdemployee.jrxml");
//                    jasperdesign = JRXmlLoader.load(O);
//                    param.clear();
//                    jasperreport = JasperCompileManager.compileReport(jasperdesign);
//                    param.put("id",id);
//                    jasperprint = JasperFillManager.fillReport(jasperreport, param, kon);
//                    JasperViewer.viewReport(jasperprint, false);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            @Override
//            public void tambah(int row) {
//                System.out.println("tambah");
//            }
//            @Override
//            public void hapus(int row) {
//                System.out.println("hapus");
//            }
//        };
//        MyTable.getColumnModel().getColumn(10).setCellRenderer(new callrender());
        MyTable.setDefaultEditor(Object.class, null);
        MyTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        MyTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        MyTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        MyTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        MyTable.getColumnModel().getColumn(5).setPreferredWidth(150);
        MyTable.getColumnModel().getColumn(6).setPreferredWidth(170);
        MyTable.getColumnModel().getColumn(7).setPreferredWidth(170);
        MyTable.getColumnModel().getColumn(8).setPreferredWidth(170);
        
        
//        MyTable.getColumnModel().removeColumn(MyTable.getColumnModel().getColumn(10));
        
//        MyTable.getColumnModel().getColumn(10).setCellEditor(new celleditor(event));     
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new raven.scroll.win11.ScrollPaneWin11();
        MyTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        textSearch = new CustomResource.CustomTextfield();

        setPreferredSize(new java.awt.Dimension(900, 585));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 850, 180));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Daftar pengajuan izin karyawan / Employee clearance List");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 40));

        jSeparator1.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 840, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Logo4.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, -1, -1));

        textSearch.setLabelText("Cari / Search");
        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSearchKeyTyped(evt);
            }
        });
        jPanel1.add(textSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 460, -1));

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
        try{
            EmployeeSession.setKTPClearance(myModel.getValueAt(MyTable.getSelectedRow(), 2).toString());
            Main.main.getMain().showForm(new EmployeeClearance());    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_MyTableMouseClicked

    private void textSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyTyped
        myShow();
    }//GEN-LAST:event_textSearchKeyTyped

    private void MyTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MyTableMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MyTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private CustomResource.CustomTextfield textSearch;
    // End of variables declaration//GEN-END:variables

    private void myShow() {
        String mySearch = textSearch.getText();
        int row = MyTable.getRowCount();
        for(int i = 0; i < row; i++){
            myModel.removeRow(0);
        }
        try {
            ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM employee_clearance inner join employee on employee_clearance.karyawan_id = employee.karyawan_id");
            while (myRess.next()) {
                String myData [] = {myRess.getString(11),myRess.getString(12), myRess.getString(13), myRess.getString(14),myRess.getString(19), 
                                    myRess.getString(20),myRess.getString(23) ,myRess.getString(16)};
                myModel.addRow(myData);
            }
        } catch (SQLException ex) {
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
