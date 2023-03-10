/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import CustomResource.koneksi;
import Main.MasterForm;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author hi
 */
public class AddJobVacancy extends MasterForm {

    Statement stm;
    ResultSet rs;

    Connection koneksi;
    String id;

    /**
     * Creates new form AddJobVacancy
     */
    public AddJobVacancy() {
        initComponents();
        MyWindow();
        openDB();
        table_id();
        hapus_row();
        tampil();
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);

    }

    void table_id() {
//mendapatkan model kolom pada JTable
        TableColumnModel columnModel = jTable2.getColumnModel();
//mendapatkan TableColumn pada indeks kolom yang ingin disembunyikan
        TableColumn column = columnModel.getColumn(0);
//menyembunyikan kolom dengan mengatur lebar kolom menjadi 0
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
//mengakses nilai pada kolom yang disembunyikan
        int rowIndex = 0; //indeks baris
        Object value = jTable2.getValueAt(rowIndex, 0);
        
        
        //mendapatkan model kolom pada JTable
        TableColumnModel columnModel1 = jTable1.getColumnModel();
//mendapatkan TableColumn pada indeks kolom yang ingin disembunyikan
        TableColumn column1 = columnModel1.getColumn(0);
//menyembunyikan kolom dengan mengatur lebar kolom menjadi 0
        column1.setMinWidth(0);
        column1.setMaxWidth(0);
        column1.setWidth(0);
        column1.setPreferredWidth(0);
//mengakses nilai pada kolom yang disembunyikan
        int rowIndex1 = 0; //indeks baris
        Object value1 = jTable1.getValueAt(rowIndex1, 0);
    }

    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }

    void hapus_row() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
        int rowCount1 = model1.getRowCount();

        for (int i = rowCount1 - 1; i >= 0; i--) {
            model1.removeRow(i);
        }

    }

    void tampil() {

        DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from job_facancy");
            while (rs.next()) {
                String[] data = {
                    rs.getString("id_job"),
                    rs.getString("name_job")};
                dataModel2.insertRow(0, data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }

        try {
            t_lamaran.removeAllItems();
            ResultSet myRess = koneksi.createStatement().executeQuery("select*from job_facancy");
            while (myRess.next()) {
                t_lamaran.addItem(myRess.getString("name_job"));
            }
        } catch (SQLException ex) {
        }

        DefaultTableModel dataModel3 = (DefaultTableModel) jTable1.getModel();
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("SELECT * FROM job_facancy INNER JOIN job_facancy_discipline on job_facancy.id_job = job_facancy_discipline.id_job");
            while (rs.next()) {
                String[] data = {
                    rs.getString("id"),
                    rs.getString("name_job"),
                    rs.getString("name_dicipline")};
                dataModel3.insertRow(0, data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        customTextfield1 = new CustomResource.CustomTextfield();
        customTextfield2 = new CustomResource.CustomTextfield();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel86 = new javax.swing.JLabel();
        t_lamaran = new CustomResource.ComboBoxSuggestion();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        customTextfield3 = new CustomResource.CustomTextfield();
        customTextfield4 = new CustomResource.CustomTextfield();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "id", "Posisi/Position", "Dicipline"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 370, 110));

        jButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton1.setText("Tambah/Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 110, 30));

        jButton2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton2.setText("Hapus / Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, 110, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("Add Job Vacancy");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 40));

        customTextfield1.setLabelText("Disiplin/Dicipline");
        add(customTextfield1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 240, -1));

        customTextfield2.setLabelText("Cari / Search");
        customTextfield2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customTextfield2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customTextfield2KeyTyped(evt);
            }
        });
        add(customTextfield2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 240, -1));

        jTable2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "id ", "Posisi/Position"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(0);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 240, 110));

        jLabel86.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel86.setText("Posisi/Position");
        add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 100, 30));

        t_lamaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Test", " " }));
        t_lamaran.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        t_lamaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_lamaranActionPerformed(evt);
            }
        });
        add(t_lamaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 190, 30));

        jLabel87.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel87.setText("Tambah Disiplin/Add Dicipilne");
        add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 170, 30));

        jLabel88.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel88.setText("Tambah Posisi Lowongan kerja/Add Job Vacancy");
        add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 290, 30));

        customTextfield3.setLabelText("Tambah Posisi/Add Position");
        add(customTextfield3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 240, -1));

        customTextfield4.setLabelText("Cari / Search");
        customTextfield4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customTextfield4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customTextfield4KeyTyped(evt);
            }
        });
        add(customTextfield4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 240, -1));

        jButton3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton3.setText("Tambah/Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 110, 30));

        jButton4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton4.setText("Hapus / Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 110, 30));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            Statement stm = koneksi.createStatement();

            rs = stm.executeQuery("select*from job_facancy where name_job = '" + t_lamaran.getSelectedItem() + "'");
            while (rs.next()) {
                id = rs.getString("id_job");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Statement stm = koneksi.createStatement();
            String sql = "Insert Into job_facancy_discipline(id_job,name_dicipline) value ('" + id + "','" + customTextfield1.getText() + "') ";

            stm.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        customTextfield1.setText("");
        hapus_row();
        tampil();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int[] selectedRows = jTable1.getSelectedRows();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = selectedRows.length - 1; i >= 0; i--) {

            try {
                stm = koneksi.createStatement();
                String c = (String) model.getValueAt(selectedRows[i], 0);
            
                String sql = "DELETE FROM job_facancy_discipline where id = '" + c + "'";
                model.removeRow(selectedRows[i]);
                stm.executeUpdate(sql);
                stm.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
            }

        }

        hapus_row();
        tampil();       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void t_lamaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_lamaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_lamaranActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Statement stm = koneksi.createStatement();
            String sql = "Insert Into job_facancy(name_job) value ('" + customTextfield3.getText() + "') ";

            stm.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
       
customTextfield3.setText("");
        
hapus_row();
        tampil();

// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//        try {
//                    stm = koneksi.createStatement();
//
//                    String sql = "DELETE FROM job_facancy";
//
//                    stm.executeUpdate(sql);
//                    stm.close();
//                } catch (SQLException e) {
//                    JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
//                }
//        
        TableColumnModel columnModel = jTable2.getColumnModel();

        int[] selectedRows = jTable2.getSelectedRows();

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            String c = (String) model.getValueAt(selectedRows[i], 0);
            try {
                stm = koneksi.createStatement();

                String sql = "DELETE FROM job_facancy where id_job = '" + c + "'";
                String sql1 = "DELETE FROM job_facancy_discipline where id_job = '" + c + "'";
                model.removeRow(selectedRows[i]);
                stm.executeUpdate(sql);
                stm.executeUpdate(sql1);
                stm.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
            }

        }

        hapus_row();
        tampil();

//        int jtabelrows = jTable2.getRowCount();
//
//        for (int i = 0; i <= jtabelrows - 1; i++) {
//            if (jTable2.getValueAt(i, 0) == null) {
//            } else {
//                String dtabel_nama = jTable2.getValueAt(i, 0).toString();
//                
//                try {
//                    stm = koneksi.createStatement();
//
//                    String sql = "insert into job_facancy (name_job) value('" + dtabel_nama + "')";
//
//                    stm.executeUpdate(sql);
//                    stm.close();
//                } catch (SQLException e) {
//                    JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
//                }
//            }
//        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void customTextfield4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customTextfield4KeyTyped

        DefaultTableModel myModel = (DefaultTableModel) jTable2.getModel();;
        String mySearch = customTextfield4.getText();
        int row = jTable2.getRowCount();
        for (int i = 0; i < row; i++) {
            myModel.removeRow(0);
        }
        if (mySearch != null) {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM job_facancy WHERE name_job LIKE '%" + mySearch + "%'");
                while (rs.next()) {
                    String[] data = {
                        rs.getString("id_job"),
                        rs.getString("name_job")};
                    myModel.insertRow(0, data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        } else {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("select*from job_facancy");
                while (rs.next()) {
                    String[] data = {
                        rs.getString("id_job"),
                        rs.getString("name_job")};
                    myModel.insertRow(0, data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_customTextfield4KeyTyped

    private void customTextfield4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customTextfield4KeyReleased
        DefaultTableModel myModel = (DefaultTableModel) jTable2.getModel();;
        String mySearch = customTextfield4.getText();
        int row = jTable2.getRowCount();
        for (int i = 0; i < row; i++) {
            myModel.removeRow(0);
        }
        if (mySearch != null) {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM job_facancy WHERE name_job LIKE '%" + mySearch + "%'");
                while (rs.next()) {
                    String[] data = {
                        rs.getString("id_job"),
                        rs.getString("name_job")};
                    myModel.insertRow(0, data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        } else {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("select*from job_facancy");
                while (rs.next()) {
                    String[] data = {
                        rs.getString("id_job"),
                        rs.getString("name_job")};
                    myModel.insertRow(0, data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        }  // TODO add your handling code here:
    }//GEN-LAST:event_customTextfield4KeyReleased

    private void customTextfield2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customTextfield2KeyTyped
DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();;
        String mySearch = customTextfield2.getText();
        int row = jTable1.getRowCount();
        for (int i = 0; i < row; i++) {
            myModel.removeRow(0);
        }
        if (mySearch != null) {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM job_facancy INNER JOIN job_facancy_discipline on job_facancy.id_job = job_facancy_discipline.id_job WHERE name_dicipline LIKE '%" + mySearch + "%'");
                while (rs.next()) {
                    String[] data = {
                        rs.getString("id"),
                    rs.getString("name_job"),
                    rs.getString("name_dicipline")};
                    myModel.insertRow(0, data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        } else {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM job_facancy INNER JOIN job_facancy_discipline on job_facancy.id_job = job_facancy_discipline.id_job");
                while (rs.next()) {
                    String[] data = {
                         rs.getString("id"),
                    rs.getString("name_job"),
                    rs.getString("name_dicipline")};
                    myModel.insertRow(0, data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_customTextfield2KeyTyped

    private void customTextfield2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customTextfield2KeyReleased
DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();;
        String mySearch = customTextfield2.getText();
        int row = jTable1.getRowCount();
        for (int i = 0; i < row; i++) {
            myModel.removeRow(0);
        }
        if (mySearch != null) {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM job_facancy INNER JOIN job_facancy_discipline on job_facancy.id_job = job_facancy_discipline.id_job WHERE name_dicipline LIKE '%" + mySearch + "%'");
                while (rs.next()) {
                    String[] data = {
                        rs.getString("id"),
                    rs.getString("name_job"),
                    rs.getString("name_dicipline")};
                    myModel.insertRow(0, data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        } else {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM job_facancy INNER JOIN job_facancy_discipline on job_facancy.id_job = job_facancy_discipline.id_job");
                while (rs.next()) {
                    String[] data = {
                         rs.getString("id"),
                    rs.getString("name_job"),
                    rs.getString("name_dicipline")};
                    myModel.insertRow(0, data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        }          // TODO add your handling code here:
    }//GEN-LAST:event_customTextfield2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.CustomTextfield customTextfield1;
    private CustomResource.CustomTextfield customTextfield2;
    private CustomResource.CustomTextfield customTextfield3;
    private CustomResource.CustomTextfield customTextfield4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private CustomResource.ComboBoxSuggestion t_lamaran;
    // End of variables declaration//GEN-END:variables

    private void MyWindow() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height - 45);
        this.setPreferredSize(screen);
//        MainPanel.setPreferredSize(screen);
//        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = (screen.width/2) - (this.getSize().width/2);
//        int y = (screen.height/2) - (this.getSize().height/2);
//        this.setLocation(x,y);
    }

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
