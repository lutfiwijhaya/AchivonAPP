/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ProcurementSystem;

import HumanResource.*;
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
public class AddMaterialList extends MasterForm {
    
    Statement stm;
    ResultSet rs;

    Connection koneksi;
    String id;
    String item = "a";
    String spec = "a";
    String spec1 = "a";

    /**
     * Creates new form AddJobVacancy
     */
    public AddMaterialList() {
        initComponents();
        MyWindow();
        openDB();
        table_id();
        hapus_row();
        tampil();
        tampil_cb_matrial();
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
        
          //mendapatkan model kolom pada JTable
        TableColumnModel columnModel2 = jTable3.getColumnModel();
//mendapatkan TableColumn pada indeks kolom yang ingin disembunyikan
        TableColumn column2 = columnModel2.getColumn(0);
//menyembunyikan kolom dengan mengatur lebar kolom menjadi 0
        column2.setMinWidth(0);
        column2.setMaxWidth(0);
        column2.setWidth(0);
        column2.setPreferredWidth(0);
//mengakses nilai pada kolom yang disembunyikan
        int rowIndex2 = 0; //indeks baris
        Object value2 = jTable3.getValueAt(rowIndex2, 0);
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
    void combobox_material(){
        
           item = cb_material.getSelectedItem().toString();
    String[] parts = item.split("-");
    String id = parts[0];
    item = id;

    }
    
    
      void combobox_spek(){
        
           spec = cb_spek.getSelectedItem().toString();
    String[] parts = spec.split("-");
    String id = parts[0];
    String id1 = parts[1];
    spec = id+id1;
    spec1 = id;

    }
    
    

    void tampil() {

        DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from po_material");
            while (rs.next()) {
                String[] data = {
                    rs.getString("id_material"),
                    rs.getString("id_material_code"),
                    rs.getString("name_material")};
                dataModel2.insertRow(0, data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal ta mpil");
        }

         try {
            cb_material.removeAllItems();
            ResultSet myRess = koneksi.createStatement().executeQuery("select*from po_material");
            while (myRess.next()) {
               cb_material.addItem(myRess.getString("id_material_code")+"-"+myRess.getString("name_material"));
            }
        } catch (SQLException ex) {
        }
       

        

    }
    
    
    void tampil_cb_matrial(){
        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
        int rowCount1 = model1.getRowCount();

        for (int i = rowCount1 - 1; i >= 0; i--) {
            model1.removeRow(i);
        }
        
     DefaultTableModel dataModel3 = (DefaultTableModel) jTable1.getModel();
       try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("SELECT * FROM po_material_discipline where id_material_code = '"+item+"'");
            while (rs.next()) {
                String[] data = {
                    rs.getString("id_material_discipline"),
                    
                    rs.getString("id_discipline_code"),
                    rs.getString("name_discipline")};
                dataModel3.insertRow(0, data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }
    
    
    
    }
    
    void tampil_table_spek(){
        DefaultTableModel model1 = (DefaultTableModel) jTable3.getModel();
        int rowCount1 = model1.getRowCount();

        for (int i = rowCount1 - 1; i >= 0; i--) {
            model1.removeRow(i);
        }
        
     DefaultTableModel dataModel3 = (DefaultTableModel) jTable3.getModel();
       try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("SELECT * FROM po_material_spek where id_discipline_code = '"+spec+"'");
            while (rs.next()) {
                String[] data = {
                   
                    rs.getString("id_material_spek"),
                    rs.getString("name_spek")};
                dataModel3.insertRow(0, data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }
    
    
    
    }
    
    void tampil_comboboxspek(){
     try {
            cb_spek.removeAllItems();
            ResultSet myRess = koneksi.createStatement().executeQuery("select*from po_material_discipline where id_material_code = '"+item+"'");
            while (myRess.next()) {
               cb_spek.addItem(myRess.getString("id_material_code")+"-"+myRess.getString("id_discipline_code")+"-"+myRess.getString("name_discipline"));
            }
        } catch (SQLException ex) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        t_discipline_code = new CustomResource.CustomTextfield();
        customTextfield2 = new CustomResource.CustomTextfield();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel86 = new javax.swing.JLabel();
        cb_material = new CustomResource.ComboBoxSuggestion();
        t_material_code = new CustomResource.CustomTextfield();
        customTextfield4 = new CustomResource.CustomTextfield();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        t_material_name = new CustomResource.CustomTextfield();
        jLabel90 = new javax.swing.JLabel();
        cb_spek = new CustomResource.ComboBoxSuggestion();
        jButton5 = new javax.swing.JButton();
        customTextfield7 = new CustomResource.CustomTextfield();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        t_name_dicipline = new CustomResource.CustomTextfield();
        t_spek = new CustomResource.CustomTextfield();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "id", "ID Discipline", "Discipline"
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 370, 110));

        jButton2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton2.setText("Hapus / Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, 110, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("Add Material List");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, 40));

        t_discipline_code.setLabelText("ID For Discipline (Must Be Unique)");
        t_discipline_code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_discipline_codeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_discipline_codeKeyTyped(evt);
            }
        });
        jPanel1.add(t_discipline_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 240, -1));

        customTextfield2.setLabelText("Cari / Search");
        customTextfield2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customTextfield2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customTextfield2KeyTyped(evt);
            }
        });
        jPanel1.add(customTextfield2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 240, -1));

        jTable2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "id ", "Code Material", "Name Material"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 370, 110));

        jLabel86.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel86.setText("Material List");
        jPanel1.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 100, 30));

        cb_material.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Test", " " }));
        cb_material.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_material.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_materialActionPerformed(evt);
            }
        });
        jPanel1.add(cb_material, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 190, 30));

        t_material_code.setLabelText("ID For Material (Must Be Unique)");
        t_material_code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_material_codeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_material_codeKeyTyped(evt);
            }
        });
        jPanel1.add(t_material_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 240, -1));

        customTextfield4.setLabelText("Cari / Search");
        customTextfield4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customTextfield4ActionPerformed(evt);
            }
        });
        customTextfield4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customTextfield4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customTextfield4KeyTyped(evt);
            }
        });
        jPanel1.add(customTextfield4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 240, -1));

        jButton3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton3.setText("Tambah/Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 110, 30));

        jButton4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton4.setText("Hapus / Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 110, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton1.setText("Tambah/Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 110, 30));

        t_material_name.setLabelText("Material Name");
        jPanel1.add(t_material_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 240, -1));

        jLabel90.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel90.setText("Discipline List");
        jPanel1.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 100, 30));

        cb_spek.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Test", " " }));
        cb_spek.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_spek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_spekActionPerformed(evt);
            }
        });
        jPanel1.add(cb_spek, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 190, 30));

        jButton5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton5.setText("Tambah/Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 110, 30));

        customTextfield7.setLabelText("Cari / Search");
        customTextfield7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customTextfield7KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customTextfield7KeyTyped(evt);
            }
        });
        jPanel1.add(customTextfield7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 240, -1));

        jTable3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "id", "Spesification"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 370, 110));

        jButton6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton6.setText("Hapus / Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 660, 110, 30));

        jLabel6.setBackground(new java.awt.Color(0, 51, 51));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Add Spec List");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 370, 20));

        jLabel7.setBackground(new java.awt.Color(0, 51, 51));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Add Material List");
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 370, 20));

        jLabel8.setBackground(new java.awt.Color(0, 51, 51));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Add Discipline List");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 370, 20));

        t_name_dicipline.setLabelText("Discipline");
        jPanel1.add(t_name_dicipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 240, -1));

        t_spek.setLabelText("Spec");
        jPanel1.add(t_spek, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 240, -1));

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       
           

        try {
            String full = item + t_discipline_code.getText();
            Statement stm = koneksi.createStatement();
            String sql = "Insert po_material_discipline (id_material_code,id_discipline_code,name_discipline,full_discipline_code) value ('"+item+"','"+t_discipline_code.getText()+"','"+ t_name_dicipline.getText()+"','"+full+"') ";

            stm.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        t_discipline_code.setText("");
        t_name_dicipline.setText("");
        
        tampil_cb_matrial();
        tampil_comboboxspek();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int[] selectedRows = jTable1.getSelectedRows();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = selectedRows.length - 1; i >= 0; i--) {

            try {
                stm = koneksi.createStatement();
                String c = (String) model.getValueAt(selectedRows[i], 1);
                String c1 = item+c;
            
                String sql = "DELETE FROM po_material_discipline where full_discipline_code = '" + c1 + "'";
                String sql1 = "DELETE FROM po_material_spek where id_discipline_code = '" + c1 + "'";
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
        tampil_cb_matrial();
        tampil_comboboxspek();
        tampil_table_spek();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Statement stm = koneksi.createStatement();
            String sql = "Insert Into po_material (id_material_code,name_material) value ('" + t_material_code.getText() + "','" + t_material_name.getText() + "') ";

            stm.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ID '"+t_material_code.getText()+"' Sudah Ada !!");
        }
       
t_material_code.setText("");
t_material_name.setText("");
        
hapus_row();
        tampil();
        tampil_comboboxspek();

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
            String c = (String) model.getValueAt(selectedRows[i], 1);
            try {
                stm = koneksi.createStatement();

                String sql = "DELETE FROM po_material where id_material_code = '" + c + "'";
                String sql1 = "DELETE FROM po_material_discipline where id_material_code = '" + c + "'";
                String sql2 = "DELETE FROM po_material_spek where id_material_code = '" + c + "'";
                
                model.removeRow(selectedRows[i]);
                stm.executeUpdate(sql);
                stm.executeUpdate(sql1);
                stm.executeUpdate(sql2);
                stm.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
            }

        }

        hapus_row();
        tampil();
        tampil_cb_matrial();
        tampil_comboboxspek();
        tampil_table_spek();
        

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
//
//        DefaultTableModel myModel = (DefaultTableModel) jTable2.getModel();;
//        String mySearch = customTextfield4.getText();
//        int row = jTable2.getRowCount();
//        for (int i = 0; i < row; i++) {
//            myModel.removeRow(0);
//        }
//        if (mySearch != null) {
//
//            try {
//                stm = koneksi.createStatement();
//                rs = stm.executeQuery("SELECT * FROM job_facancy WHERE name_job LIKE '%" + mySearch + "%'");
//                while (rs.next()) {
//                    String[] data = {
//                        rs.getString("id_job"),
//                        rs.getString("name_job")};
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
//                rs = stm.executeQuery("select*from job_facancy");
//                while (rs.next()) {
//                    String[] data = {
//                        rs.getString("id_job"),
//                        rs.getString("name_job")};
//                    myModel.insertRow(0, data);
//                }
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
//            }
//        }
//        // TODO add your handling code here:
    }//GEN-LAST:event_customTextfield4KeyTyped

    private void customTextfield4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customTextfield4KeyReleased
        DefaultTableModel myModel = (DefaultTableModel) jTable2.getModel();;
        String mySearch = customTextfield4.getText();
        int row = jTable2.getRowCount();
        for (int i = 0; i < row; i++) {
            myModel.removeRow(0);
        }
       

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM po_material WHERE id_material_code LIKE '%" + mySearch + "%'");
                while (rs.next()) {
                    String[] data = {
                        rs.getString("id_material"),
                    rs.getString("id_material_code"),
                    rs.getString("name_material")};
                    myModel.insertRow(0, data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
         if (jTable2.getRowCount() == 0) {

            try {
               stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM po_material WHERE name_material LIKE '%" + mySearch + "%'");
                while (rs.next()) {
                    String[] data = {
                      rs.getString("id_material"),
                    rs.getString("id_material_code"),
                    rs.getString("name_material")};
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

    private void cb_spekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_spekActionPerformed
 if (cb_spek.getSelectedItem() == null){
          
      } else {
     combobox_spek();
     tampil_table_spek();
     
      }
 


// TODO add your handling code here:
    }//GEN-LAST:event_cb_spekActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
try {
            Statement stm = koneksi.createStatement();
            String sql = "Insert po_material_spek(id_material_code,id_discipline_code,name_spek) value ('"+spec1+"','"+spec+"','"+t_spek.getText()+"') ";

            stm.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        t_spek.setText("");
        
        tampil_table_spek();
         
        

// TODO add your handling code here:
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void customTextfield7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customTextfield7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_customTextfield7KeyReleased

    private void customTextfield7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customTextfield7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_customTextfield7KeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
 int[] selectedRows = jTable3.getSelectedRows();

        DefaultTableModel model = (DefaultTableModel) jTable3 .getModel();
        for (int i = selectedRows.length - 1; i >= 0; i--) {

            try {
                stm = koneksi.createStatement();
                String c = (String) model.getValueAt(selectedRows[i], 0);
             
            
                String sql = "DELETE FROM po_material_spek where id_material_spek = '" +c+ "'";
             
                model.removeRow(selectedRows[i]);
                stm.executeUpdate(sql);
              
                stm.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
            }

        }

        hapus_row();
        tampil();     
        tampil_cb_matrial();
        tampil_comboboxspek();
        tampil_table_spek();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void customTextfield4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customTextfield4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customTextfield4ActionPerformed

    private void cb_materialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_materialActionPerformed
      if (cb_material.getSelectedItem() == null){
          
      } else {combobox_material();
      
      tampil_cb_matrial();
     tampil_comboboxspek();
      }
  
    }//GEN-LAST:event_cb_materialActionPerformed

    private void t_material_codeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_material_codeKeyTyped
if (t_material_code.getText().length() > 1) {
            evt.consume();
        }   
    }//GEN-LAST:event_t_material_codeKeyTyped

    private void t_material_codeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_material_codeKeyReleased
t_material_code.setText(t_material_code.getText().toUpperCase());         // TODO add your handling code here:


    }//GEN-LAST:event_t_material_codeKeyReleased

    private void t_discipline_codeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_discipline_codeKeyTyped
if (t_discipline_code.getText().length() > 1) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_t_discipline_codeKeyTyped

    private void t_discipline_codeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_discipline_codeKeyReleased
     t_discipline_code.setText(t_discipline_code.getText().toUpperCase());    // TODO add your handling code here:
    }//GEN-LAST:event_t_discipline_codeKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.ComboBoxSuggestion cb_material;
    private CustomResource.ComboBoxSuggestion cb_spek;
    private CustomResource.CustomTextfield customTextfield2;
    private CustomResource.CustomTextfield customTextfield4;
    private CustomResource.CustomTextfield customTextfield7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private CustomResource.CustomTextfield t_discipline_code;
    private CustomResource.CustomTextfield t_material_code;
    private CustomResource.CustomTextfield t_material_name;
    private CustomResource.CustomTextfield t_name_dicipline;
    private CustomResource.CustomTextfield t_spek;
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
