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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author USER
 */
public class Employe_list extends javax.swing.JFrame {
    Statement stm;
    ResultSet rs;
    Connection koneksi;
    String role;
    /**
     * Creates new form Employe_list
     */
    public Employe_list() {
        initComponents();
        MyWindow1();
        openDB();
        table();
        tampil();
    }
    
    
     private void searchTable(String searchValue) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);

        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchValue);
        sorter.setRowFilter(rowFilter);
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
        jScrollPane1 = new scroolbarWin11.ScrollPaneWin11();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        t_search = new CustomResource.CustomTextfield();

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

        t_search.setLabelText("Cari / Search");
        t_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_searchActionPerformed(evt);
            }
        });
        t_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_searchKeyTyped(evt);
            }
        });
        jPanel1.add(t_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 240, -1));

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
            System.out.println(CustomResource.EmployeeSession.getKTPAllocation());
            Main.main.getMain().showForm(new AllocationAnnouncement());
            this.dispose();
        }

if (CustomResource.EmployeeSession.getsesiform().equals("3")){
    
                 DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();       
    
    
CustomResource.EmployeeSession.setbiz_id(dataModel2.getValueAt(jTable1.getSelectedRow(), 0).toString());
    System.out.println(CustomResource.EmployeeSession.getbiz_id());
   
Main.main.getMain().showForm(new po_rfq());
  this.dispose();
}





        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void t_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_searchKeyTyped

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
    }//GEN-LAST:event_t_searchKeyTyped

    private void t_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_searchKeyReleased
 String searchValue = t_search.getText();
        searchTable(searchValue);



//        //candidate
//        if ("2".equals(MySession.get_Role())){
//            role = "1";
//        }else if ("3".equals(MySession.get_Role())){
//            role = "2";
//        }
//        if (CustomResource.EmployeeSession.getsesiform().equals("1")){
//            DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
//            String mySearch = textSearch.getText();
//            int row = jTable1.getRowCount();
//            for (int i = 0; i < row; i++) {
//                myModel.removeRow(0);
//            }
//            if (mySearch != null) {
//                try {
//                    stm = koneksi.createStatement();
//                    rs = stm.executeQuery("SELECT * FROM cd_employee WHERE approval = "+role+" AND Nama LIKE '%" + mySearch + "%'");
//                    while (rs.next()) {
//                        String[] data = {
//                           rs.getString("id_employee"),
//                        rs.getString("KTP"),
//                        rs.getString("Nama"),
//                        rs.getString("Applying_A")};
//                        myModel.insertRow(0, data);
//                    }
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                }
//            } else {
//                try {
//                    stm = koneksi.createStatement();
//                    rs = stm.executeQuery("select*from cd_employee where approval = "+role+"");
//                    while (rs.next()) {
//                        String[] data = {
//                           rs.getString("id_employee"),
//                        rs.getString("KTP"),
//                        rs.getString("Nama"),
//                        rs.getString("Applying_A")};
//                        myModel.insertRow(0, data);
//                    }
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                }
//            }  
//            int row1 = jTable1.getRowCount();
//            if (row1 == 0){
//                if (mySearch != null) {
//                    try {
//                        stm = koneksi.createStatement();
//                        rs = stm.executeQuery("SELECT * FROM cd_employee WHERE approval = "+role+" AND KTP LIKE '%" + mySearch + "%'");
//                        while (rs.next()) {
//                            String[] data = {
//                              rs.getString("id_employee"),
//                            rs.getString("KTP"),
//                            rs.getString("Nama"),
//                            rs.getString("Applying_A")};
//                            myModel.insertRow(0, data);
//                        }
//
//
//                    } catch (Exception e) {
//                        JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                    }
//                } else {
//                    try {
//                        stm = koneksi.createStatement();
//                        rs = stm.executeQuery("select*from cd_employee where approval = "+role+"");
//                        while (rs.next()) {
//                            String[] data = {
//                               rs.getString("id_employee"),
//                            rs.getString("KTP"),
//                            rs.getString("Nama"),
//                            rs.getString("Applying_A")};
//                            myModel.insertRow(0, data);
//                        }
//
//                    } catch (Exception e) {
//                        JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                    }
//                }  
//            }
//            int row2 = jTable1.getRowCount();
//            if (row2 == 0){
//                if (mySearch != null) {
//                    try {
//                        stm = koneksi.createStatement();
//                        rs = stm.executeQuery("SELECT * FROM cd_employee WHERE approval = "+role+" AND Applying_A LIKE '%" + mySearch + "%'");
//                        while (rs.next()) {
//                            String[] data = {
//                              rs.getString("id_employee"),
//                            rs.getString("KTP"),
//                            rs.getString("Nama"),
//                            rs.getString("Applying_A")};;
//                            myModel.insertRow(0, data);
//                        }
//                    } catch (Exception e) {
//                        JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                    }
//                } else {
//                    try {
//                        stm = koneksi.createStatement();
//                        rs = stm.executeQuery("select*from cd_employee where approval = "+role+"");
//                        while (rs.next()) {
//                            String[] data = {
//                                rs.getString("id_employee"),
//                            rs.getString("KTP"),
//                            rs.getString("Nama"),
//                            rs.getString("Applying_A")};
//                            myModel.insertRow(0, data);
//                        }
//                    } catch (Exception e) {
//                        JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                    }
//                }
//            }
//        }else{
//            //sesi 2 employee  
//            if (CustomResource.EmployeeSession.getsesiform().equals("2")){
//                DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
//                String mySearch = textSearch.getText();
//                int row = jTable1.getRowCount();
//                for (int i = 0; i < row; i++) {
//                    myModel.removeRow(0);
//                }
//                if (mySearch != null) {
//                    try {
//                        stm = koneksi.createStatement();
//                        rs = stm.executeQuery("SELECT * FROM employee WHERE name LIKE '%" + mySearch + "%'");
//                        while (rs.next()) {
//                            String[] data = {
//                               rs.getString("id"),
//                            rs.getString("karyawan_id"),
//                            rs.getString("name"),
//                            rs.getString("job_position")};
//                            myModel.insertRow(0, data);
//                        }
//                    } catch (Exception e) {
//                        JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                    }
//                } else {
//                    try {
//                        stm = koneksi.createStatement();
//                        rs = stm.executeQuery("select*from employee");
//                        while (rs.next()) {
//                            String[] data = {
//                                rs.getString("id"),
//                            rs.getString("karyawan_id"),
//                            rs.getString("name"),
//                            rs.getString("job_position")};
//                            myModel.insertRow(0, data);
//                        }
//                    } catch (Exception e) {
//                        JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                    }
//                }  
//                int row1 = jTable1.getRowCount();
//                if (row1 == 0){
//                    if (mySearch != null) {
//                        try {
//                            stm = koneksi.createStatement();
//                            rs = stm.executeQuery("SELECT * FROM employee WHERE karyawan_id LIKE '%" + mySearch + "%'");
//                            while (rs.next()) {
//                                String[] data = {
//                                   rs.getString("id"),
//                                rs.getString("karyawan_id"),
//                                rs.getString("name"),
//                                rs.getString("job_position")};
//                                myModel.insertRow(0, data);
//                            }
//                        } catch (Exception e) {
//                            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                        }
//                    } else {
//                        try {
//                            stm = koneksi.createStatement();
//                            rs = stm.executeQuery("select*from employee");
//                            while (rs.next()) {
//                                String[] data = {
//                                    rs.getString("id"),
//                                rs.getString("karyawan_id"),
//                                rs.getString("name"),
//                                rs.getString("job_position")};
//                                myModel.insertRow(0, data);
//                            }
//                        } catch (Exception e) {
//                            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                        }
//                    }
//                }
//                int row2 = jTable1.getRowCount();
//                if (row2 == 0){
//                    if (mySearch != null) {
//                        try {
//                            stm = koneksi.createStatement();
//                            rs = stm.executeQuery("SELECT * FROM employee WHERE job_position LIKE '%" + mySearch + "%'");
//                            while (rs.next()) {
//                                String[] data = {
//                                   rs.getString("id"),
//                                rs.getString("karyawan_id"),
//                                rs.getString("name"),
//                                rs.getString("job_position")};
//                                myModel.insertRow(0, data);
//                            }
//                        } catch (Exception e) {
//                            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                        }
//                    } else {
//                        try {
//                            stm = koneksi.createStatement();
//                            rs = stm.executeQuery("select*from employee");
//                            while (rs.next()) {
//                                String[] data = {
//                                    rs.getString("id"),
//                                rs.getString("karyawan_id"),
//                                rs.getString("name"),
//                                rs.getString("job_position")};
//                                myModel.insertRow(0, data);
//                            }
//                        } catch (Exception e) {
//                            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                        }
//                    }
//                }
//            }
//        }
//        if (mySearch != null) {
//           
//            
//            try {
//                stm = koneksi.createStatement();
//                rs = stm.executeQuery("SELECT * FROM biz_partner WHERE partner_id LIKE '%" + mySearch + "%'");
//                while (rs.next()) {
//                    String[] data = {
//                        rs.getString("biz_id"),
//                    rs.getString("partner_id"),
//                    rs.getString("name"),
//                    rs.getString("city")};
//                    myModel.insertRow(0, data);
//                }
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//            }
//            if (mySearch != null) {
//                try {
//                    stm = koneksi.createStatement();
//                    rs = stm.executeQuery("SELECT * FROM biz_partner WHERE name LIKE '%" + mySearch + "%'");
//                    while (rs.next()) {
//                        String[] data = {
//                            rs.getString("biz_id"),
//                        rs.getString("partner_id"),
//                        rs.getString("name"),
//                        rs.getString("city")};
//                        myModel.insertRow(0, data);
//                    }
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                }
//            } else {
//                try {
//                    stm = koneksi.createStatement();
//                    rs = stm.executeQuery("select*from biz_partner");
//                    while (rs.next()) {
//                        String[] data = {
//                            rs.getString("biz_id"),
//                        rs.getString("partner_id"),
//                        rs.getString("name"),
//                        rs.getString("city")};
//                        myModel.insertRow(0, data);
//                    }
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//                }
//            }     
//        }
    }//GEN-LAST:event_t_searchKeyReleased

    private void t_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_searchActionPerformed

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
            java.util.logging.Logger.getLogger(Employe_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employe_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employe_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employe_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employe_list().setVisible(true);
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
    private CustomResource.CustomTextfield t_search;
    // End of variables declaration//GEN-END:variables
}
