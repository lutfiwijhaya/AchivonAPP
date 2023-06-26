/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DocumentControl;

import ProcurementSystem.*;
import CustomResource.koneksi;
import HumanResource.Employe_list;
import Main.MasterForm;
import static Main.main.bodyPanel;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author USER
 */
public class dc_list_transmittal extends MasterForm {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    int id_po;
    int a = 1;
    int b = 1;
    String id;

    /**
     * Creates new form po
     */
    public dc_list_transmittal() {
        initComponents();
        openDB();
        table_id2();
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

    void table_id2() {
//mendapatkan model kolom pada JTable
        TableColumnModel columnModel = jTable1.getColumnModel();
//mendapatkan TableColumn pada indeks kolom yang ingin disembunyikan
        TableColumn column = columnModel.getColumn(0);
//menyembunyikan kolom dengan mengatur lebar kolom menjadi 0
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
//mengakses nilai pada kolom yang disembunyikan
        int rowIndex = 0; //indeks baris
        Object value = jTable1.getValueAt(rowIndex, 0);

        JTable table = new JTable(jTable1.getModel()) {
            public boolean getScrollableTracksViewportWidth() {
                return getPreferredSize().width < getParent().getWidth();
            }
        };
    }

    void tampil_table() {

        DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();
        int rowCount1 = dataModel2.getRowCount();

        for (int i = rowCount1 - 1; i >= 0; i--) {
            dataModel2.removeRow(i);
        }

        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("SELECT * FROM dc_transmittal");
            while (rs.next()) {

                String[] data = {
                    rs.getString("id"),
                    rs.getString("t_to"),
                    rs.getString("attn"),
                    rs.getString("cc"),
                    rs.getString("issued"),
                    rs.getString("date"),
                    rs.getString("transmittal_no"),
                    rs.getString("project_no"),
                    rs.getString("contract_no"),
                    rs.getString("t_for"),
                    rs.getString("media"),
                    rs.getString("following"),
                    rs.getString("transmitted_for"),
                    rs.getString("submitted"),
                    rs.getString("project_tittle"),
                    rs.getString("contract_tile")};
                dataModel2.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal ta mpil");
        }
    }

    void tampil_table2() {

        DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
        DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
        int rowCount1 = dataModel2.getRowCount();

        for (int i = rowCount1 - 1; i >= 0; i--) {
            dataModel2.removeRow(i);
        }
        int row = jTable1.getSelectedRow();

        String mr_id3 = (String) dataModel.getValueAt(row, 0);

        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("SELECT * FROM dc_transmittal_atc where id_transmittal = '" + mr_id3 + "'");
            while (rs.next()) {
                String[] data = {
                    rs.getString("doc_no"),
                    rs.getString("size"),
                    rs.getString("rev"),
                    rs.getString("copy"),
                    rs.getString("tittle")};
                dataModel2.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal ta mpil");
        }
    }

    private void searchTable(String searchValue) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);

        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchValue);
        sorter.setRowFilter(rowFilter);
    }
    
     public void showForm(MasterForm form) {
      
        bodyPanel.removeAll();
        bodyPanel.add(form);
        bodyPanel.revalidate();
        bodyPanel.repaint();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser2 = new com.raven.datechooser.DateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        t_search = new CustomResource.CustomTextfield();

        dateChooser2.setDateFormat("yyyy-MM-dd");

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "To", "Attn", "CC", "Issued From", "Date", "Transmittal No", "Project No", "Contract No", "For", "Media Type", "The Following", "Transmitted For", "Submitted As", "Project Tittle", "Contract Tile"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 660, 140));

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LIST ATTACHMENT");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 660, 20));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LIST TRANSMITTAL");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 660, 20));

        jButton7.setText("View");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 560, 102, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Document No", "Size", "Rev", "Copy", "Tittle"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 660, 220));

        jButton9.setText("Delete From List");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 560, 120, -1));

        t_search.setLabelText("Search");
        t_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_searchKeyTyped(evt);
            }
        });
        jPanel1.add(t_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 170, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        String mr_id3 = (String) dataModel.getValueAt(row, 0);
        CustomResource.SessionAny.set_dc_id_list_transmittal(mr_id3);
        
        showForm(new dc_form_transmittal_view());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        tampil_table2();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void t_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_searchKeyReleased
        String searchValue = t_search.getText();
        searchTable(searchValue);
    }//GEN-LAST:event_t_searchKeyReleased

    private void t_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_searchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_searchKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private CustomResource.CustomTextfield t_search;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
