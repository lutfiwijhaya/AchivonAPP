/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package MonthlyProgress;

import CustomResource.koneksi;
import Main.MasterForm;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author USER
 */
public class MonthlyProgress extends MasterForm {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    String id_mp_plan;
    String no_id;
    String id_pr = "0";
    String id_pl = "p";
    String id_work;

    /**
     * Creates new form MonthlyProgress
     */
    public MonthlyProgress() {
        initComponents();
        openDB();
        table_id();
        tampil_project();
        tampil_add_activity();
        tampil_idsite();
        hapus_row();
        if (cb_no_site.getSelectedItem() == null) {
        } else {tampil();}

    }

    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }

    void tampil_idsite() {

        try {
            cb_no_site.removeAllItems();
            ResultSet myRess = koneksi.createStatement().executeQuery("select*from no_site where project_no = '" + cb_project.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                cb_no_site.addItem(myRess.getString("id_site"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonthlyProgress.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void id_mp_plan() {
        id_mp_plan = cb_no_site.getSelectedItem().toString() + no_id;
        System.out.println(id_mp_plan);

    }

    void no_id_plan() {
        String sql = "select max(no_id) from mp_plan where id_mp_plan = '" + cb_no_site.getSelectedItem().toString() + "' and project_no = '" + cb_project.getSelectedItem().toString() + "'";
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int a = rs.getInt(1) + 1;
                no_id = String.valueOf(a);
                System.out.println(no_id);
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }

    }

    void no_id_work_step() {
        String sql = "select max(id_work_step) from mp_work_step where id_mp_plan = '" + id_pr + "' and id_no_plan = '" + id_pl + "' and project_no = '" + cb_project.getSelectedItem().toString() + "'";
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int a = rs.getInt(1) + 1;
                id_work = String.valueOf(a);
                System.out.println(no_id);
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }

    }

    void hapus_row() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

    }

    void tampil_project() {
        try {
            cb_project.removeAllItems();
            ResultSet myRess = koneksi.createStatement().executeQuery("select*from project");
            while (myRess.next()) {
                cb_project.addItem(myRess.getString("project_no"));
            }
        } catch (SQLException ex) {
        }

    }

    void tampil_add_activity() {
        cb_no_activity.removeAllItems();
        for (int i = 0; i < 26; i++) {
            char huruf = (char) ('A' + i);
            cb_no_activity.addItem(huruf + "000");
        }
        try {
            ResultSet myRess = koneksi.createStatement().executeQuery("select*from no_site where project_no = '" + cb_project.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                cb_no_activity.removeItem(myRess.getString("id_site"));
            }
        } catch (SQLException ex) {
        }
    }

    void tampil() {
       

        DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from mp_plan where id_mp_plan = '" + cb_no_site.getSelectedItem().toString() + "' and project_no = '" + cb_project.getSelectedItem().toString() + "'");
            while (rs.next()) {
                String[] data = {
                    rs.getString("id"),
                    rs.getString("id_mp_plan") + "-" + rs.getString("no_id"),
                    rs.getString("name_plan"),
                    rs.getString("persen_plan")};
                dataModel2.insertRow(0, data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }

        try {
            cb_plan.removeAllItems();
            ResultSet myRess = koneksi.createStatement().executeQuery("select*from mp_plan where id_mp_plan = '" + cb_no_site.getSelectedItem().toString() + "' and project_no = '" + cb_project.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                cb_plan.addItem(myRess.getString("id_mp_plan") + "-" + myRess.getString("no_id") + "-" + myRess.getString("name_plan"));
            }
        } catch (SQLException ex) {
        }

    }

    void tampil_work_step() {
        DefaultTableModel dataModel2 = (DefaultTableModel) jTable3.getModel();
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from mp_work_step where id_mp_plan = '" + id_pr + "' and id_no_plan = '" + id_pl + "' and project_no = '" + cb_project.getSelectedItem().toString() + "'");
            while (rs.next()) {
                String[] data = {
                    rs.getString("id"),
                    rs.getString("id_mp_plan") + "-" + rs.getString("id_no_plan") + "-" + rs.getString("id_work_step"),
                    rs.getString("name_work_step"),
                    rs.getString("persen_work_step"),
                    rs.getString("unit"),
                    rs.getString("total_work_volume")};
                dataModel2.insertRow(0, data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }

    }

    void where() {
        String item = cb_plan.getSelectedItem().toString();
        String[] parts = item.split("-");
        id_pr = parts[0];
        id_pl = parts[1];
        no_id_work_step();

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cb_no_site = new CustomResource.ComboBoxSuggestion();
        jLabel86 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        t_name_plan = new CustomResource.CustomTextfield();
        t_plan_weight = new CustomResource.CustomTextfield();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        t_name_work_step = new CustomResource.CustomTextfield();
        t_volume = new CustomResource.CustomTextfield();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        cb_plan = new CustomResource.ComboBoxSuggestion();
        t_persen_work = new CustomResource.CustomTextfield();
        jLabel88 = new javax.swing.JLabel();
        cb_unit = new CustomResource.ComboBoxSuggestion();
        jLabel89 = new javax.swing.JLabel();
        cb_project = new CustomResource.ComboBoxSuggestion();
        jLabel90 = new javax.swing.JLabel();
        cb_no_activity = new CustomResource.ComboBoxSuggestion();
        jLabel5 = new javax.swing.JLabel();
        t_name_activity = new CustomResource.CustomTextfield();
        jButton7 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Add Activity");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 360, 20));

        cb_no_site.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Test", " " }));
        cb_no_site.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_no_site.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_no_siteActionPerformed(evt);
            }
        });
        jPanel1.add(cb_no_site, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 260, 30));

        jLabel86.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel86.setText("Chose Activity");
        jPanel1.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 90, 30));

        jLabel4.setBackground(new java.awt.Color(0, 51, 51));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Add Work Step");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 350, 20));

        t_name_plan.setLabelText("Name Activity Description");
        jPanel1.add(t_name_plan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 240, -1));

        t_plan_weight.setLabelText("Weight Value (%)");
        t_plan_weight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_plan_weightKeyTyped(evt);
            }
        });
        jPanel1.add(t_plan_weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 110, -1));

        jTable2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "id", "ID Plan", "Name Plan", "Weighted Plan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 360, 110));

        jButton3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton3.setText("Tambah/Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 110, 30));

        jButton4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton4.setText("Hapus / Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 110, 30));

        t_name_work_step.setLabelText("Work Step");
        jPanel1.add(t_name_work_step, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 240, -1));

        t_volume.setLabelText("Volume");
        t_volume.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_volumeKeyTyped(evt);
            }
        });
        jPanel1.add(t_volume, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 100, -1));

        jButton5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton5.setText("Tambah/Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 100, 30));

        jTable3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "ID Work Plan", "Work Step", "Weight Value", "Unit", "Total Voulume"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 360, 110));

        jButton6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton6.setText("Hapus / Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 110, 30));

        jLabel87.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel87.setText("Chose Plan");
        jPanel1.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 100, 30));

        cb_plan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Test", " " }));
        cb_plan.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_plan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_planActionPerformed(evt);
            }
        });
        jPanel1.add(cb_plan, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 260, 30));

        t_persen_work.setLabelText("Weight Value (%)");
        t_persen_work.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_persen_workKeyTyped(evt);
            }
        });
        jPanel1.add(t_persen_work, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 110, -1));

        jLabel88.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel88.setText("Unit");
        jPanel1.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, 30));

        cb_unit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SET" }));
        cb_unit.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_unitActionPerformed(evt);
            }
        });
        jPanel1.add(cb_unit, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 110, 30));

        jLabel89.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel89.setText("Chose Project");
        jPanel1.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        cb_project.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Test", " " }));
        cb_project.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_project.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_projectActionPerformed(evt);
            }
        });
        jPanel1.add(cb_project, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 260, 30));

        jLabel90.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel90.setText("Add Activity");
        jPanel1.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, 30));

        cb_no_activity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A000", "B000", "C000", "D000", "F000", "G000", "H000", "I000", "J000", "K000", "L000", "M000", " " }));
        cb_no_activity.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_no_activity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_no_activityActionPerformed(evt);
            }
        });
        jPanel1.add(cb_no_activity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 260, 30));

        jLabel5.setBackground(new java.awt.Color(0, 51, 51));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Add Activity Description");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 360, 20));

        t_name_activity.setLabelText("Name Activity");
        jPanel1.add(t_name_activity, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 240, -1));

        jButton7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton7.setText("Tambah/Add");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 110, 30));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_no_siteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_no_siteActionPerformed
        if (cb_no_site.getSelectedItem() == null) {
        } else {
            DefaultTableModel model1 = (DefaultTableModel) jTable3.getModel();
            int rowCount1 = model1.getRowCount();

            for (int i = rowCount1 - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            hapus_row();
            tampil();
             t_plan_weight.setText("");
        t_name_plan.setText("");
        }
    }//GEN-LAST:event_cb_no_siteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        no_id_plan();

        try {
            Statement stm = koneksi.createStatement();
            String sql = "Insert Into mp_plan (project_no,id_mp_plan,no_id,name_plan,persen_plan) value ('" + cb_project.getSelectedItem().toString() + "','" + cb_no_site.getSelectedItem().toString() + "','" + no_id + "','" + t_name_plan.getText() + "','" + t_plan_weight.getText() + "')";

            stm.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        t_plan_weight.setText("");
        t_name_plan.setText("");

        hapus_row();
        tampil();
//        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String item = cb_plan.getSelectedItem().toString();
        String[] parts = item.split("-");
        id_pr = parts[0];
        id_pl = parts[1];
        no_id_work_step();

        try {
            Statement stm = koneksi.createStatement();
            String sql = "Insert Into mp_work_step (project_no,id_mp_plan,id_no_plan,id_work_step,name_work_step,persen_work_step,unit,total_work_volume) value ('" + cb_project.getSelectedItem().toString() + "','" + id_pr + "','" + id_pl + "',"
                    + "'" + id_work + "',"
                    + "'" + t_name_work_step.getText() + "',"
                    + "'" + t_persen_work.getText() + "',"
                    + "'" + cb_unit.getSelectedItem().toString() + "',"
                    + "'" + t_volume.getText() + "')";

            stm.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        if (cb_plan.getSelectedItem() == null) {
        } else {

            DefaultTableModel model1 = (DefaultTableModel) jTable3.getModel();
            int rowCount1 = model1.getRowCount();

            for (int i = rowCount1 - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            where();
            tampil_work_step();
            t_name_work_step.setText("");
            t_persen_work.setText("");
            t_volume.setText("");
            t_name_work_step.requestFocus();


        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cb_planActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_planActionPerformed

        if (cb_plan.getSelectedItem() == null) {
        } else {

            DefaultTableModel model1 = (DefaultTableModel) jTable3.getModel();
            int rowCount1 = model1.getRowCount();

            for (int i = rowCount1 - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            where();
            tampil_work_step();
             t_name_work_step.setText("");
            t_persen_work.setText("");
            t_volume.setText("");

        }// TODO add your handling code here:
    }//GEN-LAST:event_cb_planActionPerformed

    private void cb_unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_unitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_unitActionPerformed

    private void cb_projectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_projectActionPerformed
        if (cb_project.getSelectedItem() == null) {
        } else {
            tampil_add_activity();
            tampil_idsite();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_cb_projectActionPerformed

    private void cb_no_activityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_no_activityActionPerformed
t_name_activity.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_cb_no_activityActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
 

        try {
            Statement stm = koneksi.createStatement();
            String sql = "Insert Into no_site (id_site,project_no,name_site) value ('" + cb_no_activity.getSelectedItem().toString() + "','" + cb_project.getSelectedItem().toString() + "','" + t_name_activity.getText() + "')";

            stm.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        t_name_activity.setText("");
        tampil_add_activity();
        tampil_idsite();
             
    }//GEN-LAST:event_jButton7ActionPerformed

    private void t_plan_weightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_plan_weightKeyTyped
char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        if (t_plan_weight.getText().length() > 2) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_t_plan_weightKeyTyped

    private void t_persen_workKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_persen_workKeyTyped
char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        if (t_persen_work.getText().length() > 2) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_t_persen_workKeyTyped

    private void t_volumeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_volumeKeyTyped
char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        if (t_volume.getText().length() > 2) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_t_volumeKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.ComboBoxSuggestion cb_no_activity;
    private CustomResource.ComboBoxSuggestion cb_no_site;
    private CustomResource.ComboBoxSuggestion cb_plan;
    private CustomResource.ComboBoxSuggestion cb_project;
    private CustomResource.ComboBoxSuggestion cb_unit;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private CustomResource.CustomTextfield t_name_activity;
    private CustomResource.CustomTextfield t_name_plan;
    private CustomResource.CustomTextfield t_name_work_step;
    private CustomResource.CustomTextfield t_persen_work;
    private CustomResource.CustomTextfield t_plan_weight;
    private CustomResource.CustomTextfield t_volume;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
