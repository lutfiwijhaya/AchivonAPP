/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ProcurementSystem;

import CustomResource.koneksi;
import Main.MasterForm;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class po_form_po extends MasterForm {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    int id_po;
    long a = 1;
    long b = 1;

    /**
     * Creates new form po
     */
    public po_form_po() {
        initComponents();
      
        openDB();
        cb_rfq();

       

    }

    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }

    void cb_rfq() {
        try {
            cb_rfq.removeAllItems();
            ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM po_sq INNER JOIN po_rfq on po_sq.rfq_id = po_rfq.id INNER JOIN biz_partner on po_rfq.biz_id = biz_partner.biz_id where po_sq.status = '1'");
            while (myRess.next()) {
                cb_rfq.addItem("SQ-" + myRess.getString("po_sq.id") + "-" + "(" + myRess.getString("name") + ")");
            }
        } catch (SQLException ex) {
        }

    }

    void add() {
        String mr_id3 = cb_rfq.getSelectedItem().toString();

        String[] parts = mr_id3.split("-");
        String id = parts[1];

        try {
            ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM po_sq INNER JOIN po_rfq on po_sq.rfq_id = po_rfq.id INNER JOIN biz_partner on po_rfq.biz_id = biz_partner.biz_id where po_sq.id = '" + id + "'");
            while (myRess.next()) {
                double angka = Double.parseDouble(myRess.getString("amount"));
                double angka1 = Double.parseDouble(myRess.getString("total1"));
                double angka2 = Double.parseDouble(myRess.getString("ppn"));
                double angka3 = Double.parseDouble(myRess.getString("total2"));

                NumberFormat format = new DecimalFormat("#,###");
                String hasil = format.format(angka);
                String hasil1 = format.format(angka1);
                String hasil2 = format.format(angka2);
                String hasil3 = format.format(angka3);
                String a = myRess.getString("address") + " " + "RT" + "/" + myRess.getString("rt") + "RW" + "/" + myRess.getString("rw") + " " + myRess.getString("city") + " " + myRess.getString("province") + " " + myRess.getString("postcode");
                t_supplier.setText(myRess.getString("name"));
                t_email.setText(myRess.getString("email"));
                t_mobile.setText(myRess.getString("no_hp"));
                t_address.setText(a);
                t_disc.setText(myRess.getString("disc"));
                t_amount.setText("Rp. " +hasil);
                t_total_1.setText("Rp. " +hasil1);
                t_ppn.setText("Rp. " +hasil2);
                t_total_2.setText("Rp. " +hasil3);
               
            }
        } catch (SQLException ex) {
        }

    }

    void cb_material() {
        try {

            String[] parts = cb_rfq.getSelectedItem().toString().split("-");
            String id = parts[1];
            DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
            int rowCount1 = dataModel2.getRowCount();

            for (int i = rowCount1 - 1; i >= 0; i--) {
                dataModel2.removeRow(i);
            }

            ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM po_sq INNER JOIN po_rfq on po_sq.rfq_id = po_rfq.id INNER JOIN po_rfq_items on po_rfq.id = po_rfq_items.rfq_id where po_sq.id = '" + id + "'");
            while (myRess.next()) {

                String[] data = {
                    "RFQ-" + myRess.getString("rfq_id"),
                    "MR-" + myRess.getString("mr_id"),
                    myRess.getString("material_name"),
                    myRess.getString("stock_needs"),
                    myRess.getString("price"),
                    myRess.getString("total")};
                dataModel2.addRow(data);

            }
        } catch (SQLException ex) {
        }

    }

//    void add_from_cb() {
//        String[] parts = cb_mr.getSelectedItem().toString().split("-");
//        String id = parts[1];
//
//        DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
//        int rowCount1 = dataModel2.getRowCount();
//
//        for (int i = rowCount1 - 1; i >= 0; i--) {
//            String[] parts1 = dataModel2.getValueAt(i, 1).toString().split("-");
//            String id1 = parts1[1];
//
//            if (id.equals(id1)) {
//                Mobile.setText((String) dataModel2.getValueAt(i, 2));
//                t_stok.setText((String) dataModel2.getValueAt(i, 3));
//                t_price.setText((String) dataModel2.getValueAt(i, 4));
//
//            }
//
//        }
//
//    }
//
//    void add_from_table() {
//        int i = jTable2.getSelectedRow();
//        DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
//        Mobile.setText((String) dataModel2.getValueAt(i, 2));
//        t_stok.setText((String) dataModel2.getValueAt(i, 3));
//        t_price.setText((String) dataModel2.getValueAt(i, 4));
//
//        String cb = (String) dataModel2.getValueAt(i, 1) + "-(" + dataModel2.getValueAt(i, 2) + ")";
//        cb_mr.setSelectedItem(cb);
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        t_cc = new CustomResource.CustomTextfield();
        t_total_2 = new CustomResource.CustomTextfield();
        jLabel2 = new javax.swing.JLabel();
        cb_rfq = new CustomResource.ComboBoxSuggestion();
        t_disc = new CustomResource.CustomTextfield();
        t_amount = new CustomResource.CustomTextfield();
        t_total_1 = new CustomResource.CustomTextfield();
        t_ppn = new CustomResource.CustomTextfield();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        t_supplier = new CustomResource.CustomTextfield();
        t_address = new CustomResource.CustomTextfield();
        t_email = new CustomResource.CustomTextfield();
        t_mobile = new CustomResource.CustomTextfield();
        t_po_date = new CustomResource.CustomTextfield();
        t_deliv_date = new CustomResource.CustomTextfield();
        t_desc = new CustomResource.CustomTextfield();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(t_po_date);

        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(t_deliv_date);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_cc.setLabelText("CC");
        jPanel1.add(t_cc, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 257, -1));

        t_total_2.setEditable(false);
        t_total_2.setLabelText("Total");
        jPanel1.add(t_total_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 650, 160, -1));

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Form PO");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 650, 20));

        cb_rfq.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_rfq.setName(""); // NOI18N
        cb_rfq.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cb_rfqPopupMenuWillBecomeVisible(evt);
            }
        });
        cb_rfq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_rfqActionPerformed(evt);
            }
        });
        jPanel1.add(cb_rfq, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 400, -1));

        t_disc.setEditable(false);
        t_disc.setLabelText("Disc %");
        t_disc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_discActionPerformed(evt);
            }
        });
        t_disc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_discKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_discKeyTyped(evt);
            }
        });
        jPanel1.add(t_disc, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, 160, -1));

        t_amount.setEditable(false);
        t_amount.setLabelText("Amount");
        t_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_amountKeyReleased(evt);
            }
        });
        jPanel1.add(t_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 160, -1));

        t_total_1.setEditable(false);
        t_total_1.setLabelText("Total");
        jPanel1.add(t_total_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, 160, -1));

        t_ppn.setEditable(false);
        t_ppn.setLabelText("PPN 11%");
        jPanel1.add(t_ppn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 600, 160, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RFQ ID", "MR ID", "Material Name", "Stock Needs", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 660, 140));

        jLabel4.setText("Choose SQ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        jButton8.setText("SUBMIT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 710, 140, 30));

        t_supplier.setEditable(false);
        t_supplier.setLabelText("Supplier");
        jPanel1.add(t_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 257, -1));

        t_address.setEditable(false);
        t_address.setLabelText("Address");
        jPanel1.add(t_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 257, -1));

        t_email.setEditable(false);
        t_email.setLabelText("E-Mail");
        jPanel1.add(t_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 257, -1));

        t_mobile.setEditable(false);
        t_mobile.setLabelText("Mobile");
        jPanel1.add(t_mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 257, -1));

        t_po_date.setLabelText("Po Date");
        jPanel1.add(t_po_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 257, -1));

        t_deliv_date.setLabelText("Delivery Date");
        jPanel1.add(t_deliv_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 257, -1));

        t_desc.setLabelText("Description");
        jPanel1.add(t_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 257, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_rfqPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb_rfqPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_rfqPopupMenuWillBecomeVisible

    private void cb_rfqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_rfqActionPerformed
        if (cb_rfq.getSelectedItem() == null) {

        } else {
            add();
            cb_material();

            DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();

            int rowCount = dataModel2.getRowCount();
            long total = 0L;

// Looping untuk menghitung jumlah pada kolom tertentu
            for (int i = 0; i < rowCount; i++) {
                total += Long.parseLong(dataModel2.getValueAt(i, 5).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
            }

// Menampilkan hasil jumlah
//            t_amount.setText(String.valueOf(total));
//
//            long disc = Long.valueOf(t_disc.getText());
//            long total1 = total - (total * disc / 100);
//            t_total_1.setText(String.valueOf(total1));
//            long ppn = total1 * 11 / 100;
//            long total2 = total1 + (total1 * 11 / 100);
//            t_ppn.setText(String.valueOf(ppn));
//            t_total_2.setText(String.valueOf(total2));

        }       // TODO add your handling code here:
    }//GEN-LAST:event_cb_rfqActionPerformed

    private void t_discActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_discActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_discActionPerformed

    private void t_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_amountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_amountKeyReleased

    private void t_discKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_discKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_discKeyTyped

    private void t_discKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_discKeyReleased
//        long total = Long.valueOf(t_amount.getText());
//        long disc = Long.valueOf(t_disc.getText());
//        long total1 = total - (total * disc / 100L);
//        t_total_1.setText(String.valueOf(total1));
//        long ppn = total1 * 11L / 100L;
//        long total2 = total1 + (total1 * 11L / 100L);
//        t_ppn.setText(String.valueOf(ppn));
//        t_total_2.setText(String.valueOf(total2));        // TODO add your handling code here:
    }//GEN-LAST:event_t_discKeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        String[] parts1 = cb_rfq.getSelectedItem().toString().split("-");
        String id1 = parts1[1];

        try {
            stm = koneksi.createStatement();
            String sql = "insert into po (sq_id,po_date,po_delivery_date,description,cc) values('" + id1 + "'"
                    + ",'" + t_po_date.getText() + "'"
                    + ",'" + t_deliv_date.getText() + "'"
                    + ",'" + t_desc.getText() + "'"
                    + ",'" + t_cc.getText() + "')";
            stm.executeUpdate(sql);
            stm.close();
            JOptionPane.showMessageDialog(null, "Data Saved");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }
        
          try {
            stm = koneksi.createStatement();
            String sql1 = "UPDATE po_sq SET status = '2' WHERE id = '" + id1 + "'";
            stm.executeUpdate(sql1);
            stm.close();
            JOptionPane.showMessageDialog(null, "Data Saved");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }

       cb_rfq();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.ComboBoxSuggestion cb_rfq;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private CustomResource.CustomTextfield t_address;
    private CustomResource.CustomTextfield t_amount;
    private CustomResource.CustomTextfield t_cc;
    private CustomResource.CustomTextfield t_deliv_date;
    private CustomResource.CustomTextfield t_desc;
    private CustomResource.CustomTextfield t_disc;
    private CustomResource.CustomTextfield t_email;
    private CustomResource.CustomTextfield t_mobile;
    private CustomResource.CustomTextfield t_po_date;
    private CustomResource.CustomTextfield t_ppn;
    private CustomResource.CustomTextfield t_supplier;
    private CustomResource.CustomTextfield t_total_1;
    private CustomResource.CustomTextfield t_total_2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
