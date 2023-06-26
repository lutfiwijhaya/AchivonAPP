/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ProcurementSystem;

import CustomResource.koneksi;
import Main.MasterForm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class po_material_request extends MasterForm {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    String item;
    String discipline;
    String spec;
    String id_spec;
    String name_material;
    String name_discipline;
    String name_spek;

    /**
     * Creates new form po_request
     */
    public po_material_request() {
        initComponents();
        openDB();
   
        tampil_material();
        tampil_comboboxspek();
        tampil_combospek();
        tampil_table();

    }

    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }

    void tampil_material() {
        try {
            cb_material.removeAllItems();
            ResultSet myRess = koneksi.createStatement().executeQuery("select*from po_material");
            while (myRess.next()) {
                cb_material.addItem(myRess.getString("id_material_code") + "-" + myRess.getString("name_material"));
            }
        } catch (SQLException ex) {
        }
    }

   

    void combobox_material() {

        item = cb_material.getSelectedItem().toString();
        String[] parts = item.split("-");
        String id = parts[0];
        String name = parts[1];
        item = id;
        name_material = name;
    }

    void getidspek() {
        discipline = cb_discipline.getSelectedItem().toString();
        String[] parts = discipline.split("-");
        String id = parts[0];
        String name = parts[1];
        discipline = id;
        name_discipline = name;
        spec = item + discipline;
    }

    void getidspek2() {
        id_spec = cb_spek.getSelectedItem().toString();
        String[] parts = id_spec.split("-");
        String id = parts[0];
        String name = parts[1];
        id_spec = id;
        name_spek = name;
    }

    void tampil_comboboxspek() {
        try {
            cb_discipline.removeAllItems();
            ResultSet myRess = koneksi.createStatement().executeQuery("select*from po_material_discipline where id_material_code = '" + item + "'");
            while (myRess.next()) {
                cb_discipline.addItem(myRess.getString("id_discipline_code") + "-" + myRess.getString("name_discipline"));
            }
        } catch (SQLException ex) {
        }

    }

    void tampil_combospek() {
        try {
            cb_spek.removeAllItems();
            ResultSet myRess = koneksi.createStatement().executeQuery("select*from po_material_spek where id_discipline_code = '" + spec + "'");
            while (myRess.next()) {
                cb_spek.addItem(myRess.getString("id_material_spek") + "-" + myRess.getString("name_spek"));
            }
        } catch (SQLException ex) {
        }
    }

    void getIdRequest() {

        t_id_po.setText(item + "-" + discipline + "-" + id_spec);
    }

    void submit() {
        DefaultTableModel ImportDataExel = (DefaultTableModel) jTable1.getModel();

        String dtabel_id_po = t_id_po.getText();
        String dtabel_material = name_material;
        String dtabel_discipline = name_discipline;
        String dtabel_spec = name_spek;
        String dtabel_tanggal = t_tgl_po.getText();
        String dtabel_stok = t_stok.getText();
        String dtabel_qty = box_qty4.getSelectedItem().toString();
        String dtabel_remark = t_remark.getText();
        
        try {
            stm = koneksi.createStatement();
            String sql = "insert into po_material_request (id_material_code,material,discipline,spec,tanggal_request,stok,qty,remark) values('" + dtabel_id_po + "'"
                    + ",'" + dtabel_material + "'"
                    + ",'" + dtabel_discipline + "'"
                    + ",'" + dtabel_spec + "'"
                    + ",'" + dtabel_tanggal + "'"
                    + ",'" + dtabel_stok + "'"
                    + ",'" + dtabel_qty + "'"
                    + ",'" + dtabel_remark + "')";
            stm.executeUpdate(sql);
            stm.close();
            JOptionPane.showMessageDialog(null, "Request Sent Successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }

        tampil_table();
 

    }

    void tampil_table() {

        DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();
        int rowCount1 = dataModel2.getRowCount();
         for (int i = rowCount1 - 1; i >= 0; i--) {
            dataModel2.removeRow(i);
        }
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from po_material_request");
            while (rs.next()) {
             

                String[] data = {
                    "MR-"+rs.getString("id_material_request"),
                    rs.getString("id_material_code"),
                    rs.getString("material"),
                    rs.getString("discipline"),
                    rs.getString("spec"),
                    rs.getString("tanggal_request"),
                    rs.getString("stok"),
                    rs.getString("qty"),
                    rs.getString("remark")};
                dataModel2.insertRow(0, data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal ta mpil");
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

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        t_id_po = new CustomResource.CustomTextfield();
        t_stok = new CustomResource.CustomTextfield();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cb_discipline = new CustomResource.ComboBoxSuggestion();
        jScrollPane25 = new javax.swing.JScrollPane();
        t_remark = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        t_tgl_po = new CustomResource.CustomTextfield();
        jButton7 = new javax.swing.JButton();
        cb_material = new CustomResource.ComboBoxSuggestion();
        box_qty4 = new CustomResource.ComboBoxSuggestion();
        cb_spek = new CustomResource.ComboBoxSuggestion();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(t_tgl_po);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_id_po.setEnabled(false);
        t_id_po.setLabelText("Material ID");
        jPanel1.add(t_id_po, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 150, -1));

        t_stok.setLabelText("Stock Needs");
        t_stok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_stokKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_stokKeyTyped(evt);
            }
        });
        jPanel1.add(t_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 130, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Material Request", "ID Material", "Material", "Discipline", "Spec", "Date Request", "Stok", "Qty", "Remark"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setDoubleBuffered(true);
        jTable1.setFillsViewportHeight(true);
        jTable1.setFocusCycleRoot(true);
        jTable1.setShowHorizontalLines(true);
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 550, 140));

        cb_discipline.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "QTY", "Pcs", "Ctn", "Ball", "Roll" }));
        cb_discipline.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_discipline.setName(""); // NOI18N
        cb_discipline.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cb_disciplinePopupMenuWillBecomeVisible(evt);
            }
        });
        cb_discipline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_disciplineActionPerformed(evt);
            }
        });
        jPanel1.add(cb_discipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 190, -1));

        t_remark.setColumns(20);
        t_remark.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        t_remark.setRows(5);
        t_remark.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                t_remarkMouseWheelMoved(evt);
            }
        });
        jScrollPane25.setViewportView(t_remark);

        jPanel1.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 210, -1));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LIST REQUEST MATERIAL");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 550, 20));

        t_tgl_po.setLabelText("Date Request");
        jPanel1.add(t_tgl_po, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 230, -1));

        jButton7.setText("SUBMIT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 140, 30));

        cb_material.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "QTY", "Pcs", "Ctn", "Ball", "Roll" }));
        cb_material.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_material.setName(""); // NOI18N
        cb_material.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cb_materialPopupMenuWillBecomeVisible(evt);
            }
        });
        cb_material.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_materialActionPerformed(evt);
            }
        });
        jPanel1.add(cb_material, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 190, -1));

        box_qty4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "QTY", "Pcs", "Ctn", "Ball", "Roll" }));
        box_qty4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        box_qty4.setName(""); // NOI18N
        box_qty4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                box_qty4PopupMenuWillBecomeVisible(evt);
            }
        });
        box_qty4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_qty4ActionPerformed(evt);
            }
        });
        jPanel1.add(box_qty4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 100, -1));

        cb_spek.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "QTY", "Pcs", "Ctn", "Ball", "Roll" }));
        cb_spek.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_spek.setName(""); // NOI18N
        cb_spek.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cb_spekPopupMenuWillBecomeVisible(evt);
            }
        });
        cb_spek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_spekActionPerformed(evt);
            }
        });
        jPanel1.add(cb_spek, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 190, -1));

        jLabel4.setBackground(new java.awt.Color(0, 51, 51));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("REQUEST MATERIAL");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 530, 20));

        jLabel2.setText("Choose Spec");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, -1));

        jLabel5.setText("Remark");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));

        jLabel6.setText("Choose Material");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        jLabel7.setText("Choose Discipline");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1212, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void t_stokKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_stokKeyReleased

    }//GEN-LAST:event_t_stokKeyReleased

    private void t_stokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_stokKeyTyped

    }//GEN-LAST:event_t_stokKeyTyped

    private void cb_disciplinePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb_disciplinePopupMenuWillBecomeVisible

    }//GEN-LAST:event_cb_disciplinePopupMenuWillBecomeVisible

    private void cb_disciplineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_disciplineActionPerformed
        if (cb_discipline.getSelectedItem() == null) {
        } else {
            getidspek();
            tampil_combospek();

        }
    }//GEN-LAST:event_cb_disciplineActionPerformed

    private void t_remarkMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_t_remarkMouseWheelMoved

    }//GEN-LAST:event_t_remarkMouseWheelMoved

    private void cb_materialPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb_materialPopupMenuWillBecomeVisible

    }//GEN-LAST:event_cb_materialPopupMenuWillBecomeVisible

    private void cb_materialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_materialActionPerformed
        if (cb_material.getSelectedItem() == null) {
        } else {
            combobox_material();
            tampil_comboboxspek();
        }
    }//GEN-LAST:event_cb_materialActionPerformed

    private void box_qty4PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_box_qty4PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_box_qty4PopupMenuWillBecomeVisible

    private void box_qty4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_qty4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_qty4ActionPerformed

    private void cb_spekPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb_spekPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_spekPopupMenuWillBecomeVisible

    private void cb_spekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_spekActionPerformed
        if (cb_spek.getSelectedItem() == null) {
        } else {
            getidspek2();
            getIdRequest();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cb_spekActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        submit();             // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.ComboBoxSuggestion box_qty4;
    private CustomResource.ComboBoxSuggestion cb_discipline;
    private CustomResource.ComboBoxSuggestion cb_material;
    private CustomResource.ComboBoxSuggestion cb_spek;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JTable jTable1;
    private CustomResource.CustomTextfield t_id_po;
    private javax.swing.JTextArea t_remark;
    private CustomResource.CustomTextfield t_stok;
    private CustomResource.CustomTextfield t_tgl_po;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
