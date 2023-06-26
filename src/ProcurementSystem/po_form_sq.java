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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class po_form_sq extends MasterForm {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    int id_po;
    long a = 1;
    long b = 1;

    /**
     * Creates new form po
     */
    public po_form_sq() {
        initComponents();
        openDB();
        cb_rfq();

        t_disc.setText("0");

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
            ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM po_rfq INNER JOIN biz_partner on po_rfq.biz_id = biz_partner.biz_id where status = '1'");
            while (myRess.next()) {
                cb_rfq.addItem("RFQ-" + myRess.getString("id") + "-" + "(" + myRess.getString("name") + ")");
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

            cb_mr.removeAllItems();

            ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM po_rfq_items where rfq_id = '" + id + "'");
            while (myRess.next()) {
                cb_mr.addItem("MR-" + myRess.getString("mr_id") + "-" + "(" + myRess.getString("material_name") + ")");
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

    void add_from_cb() {
        String[] parts = cb_mr.getSelectedItem().toString().split("-");
        String id = parts[1];

        DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
        int rowCount1 = dataModel2.getRowCount();

        for (int i = rowCount1 - 1; i >= 0; i--) {
            String[] parts1 = dataModel2.getValueAt(i, 1).toString().split("-");
            String id1 = parts1[1];

            if (id.equals(id1)) {
                t_name_item.setText((String) dataModel2.getValueAt(i, 2));
                t_stok.setText((String) dataModel2.getValueAt(i, 3));
                t_price.setText((String) dataModel2.getValueAt(i, 4));

            }

        }

    }

    void add_from_table() {
        int i = jTable2.getSelectedRow();
        DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
        t_name_item.setText((String) dataModel2.getValueAt(i, 2));
        t_stok.setText((String) dataModel2.getValueAt(i, 3));
        t_price.setText((String) dataModel2.getValueAt(i, 4));

        String cb = (String) dataModel2.getValueAt(i, 1) + "-(" + dataModel2.getValueAt(i, 2) + ")";
        cb_mr.setSelectedItem(cb);

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
        t_name_item = new CustomResource.CustomTextfield();
        t_stok = new CustomResource.CustomTextfield();
        t_total_2 = new CustomResource.CustomTextfield();
        t_price = new CustomResource.CustomTextfield();
        t_total = new CustomResource.CustomTextfield();
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
        jLabel5 = new javax.swing.JLabel();
        cb_mr = new CustomResource.ComboBoxSuggestion();
        jButton9 = new javax.swing.JButton();
        t_date = new CustomResource.CustomTextfield();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(t_date);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_name_item.setEditable(false);
        t_name_item.setLabelText("Name of Item");
        jPanel1.add(t_name_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 257, -1));

        t_stok.setEditable(false);
        t_stok.setLabelText("Stok");
        t_stok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_stokKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_stokKeyTyped(evt);
            }
        });
        jPanel1.add(t_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 140, -1));

        t_total_2.setEnabled(false);
        t_total_2.setLabelText("Total");
        jPanel1.add(t_total_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 690, 160, -1));

        t_price.setLabelText("Price");
        t_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_priceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_priceKeyTyped(evt);
            }
        });
        jPanel1.add(t_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 257, -1));

        t_total.setEnabled(false);
        t_total.setLabelText("Total");
        t_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_totalKeyReleased(evt);
            }
        });
        jPanel1.add(t_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 257, -1));

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Form Sales Quatation");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 650, 20));

        cb_rfq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "QTY", "Pcs", "Ctn", "Ball", "Roll" }));
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
        jPanel1.add(cb_rfq, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 400, -1));

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
        jPanel1.add(t_disc, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 540, 160, -1));

        t_amount.setEnabled(false);
        t_amount.setLabelText("Amount");
        t_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_amountKeyReleased(evt);
            }
        });
        jPanel1.add(t_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, 160, -1));

        t_total_1.setEnabled(false);
        t_total_1.setLabelText("Total");
        jPanel1.add(t_total_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 590, 160, -1));

        t_ppn.setEnabled(false);
        t_ppn.setLabelText("PPN 11%");
        jPanel1.add(t_ppn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 640, 160, -1));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 660, 140));

        jLabel4.setText("Choose RFQ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        jButton8.setText("SUBMIT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 750, 140, 30));

        jLabel5.setText("Choose Material");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, -1));

        cb_mr.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_mr.setName(""); // NOI18N
        cb_mr.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cb_mrPopupMenuWillBecomeVisible(evt);
            }
        });
        cb_mr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mrActionPerformed(evt);
            }
        });
        jPanel1.add(cb_mr, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 400, -1));

        jButton9.setText("Add");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 140, 30));

        t_date.setLabelText("Date");
        t_date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_dateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_dateKeyTyped(evt);
            }
        });
        jPanel1.add(t_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 257, -1));

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
            cb_material();
            t_name_item.setText("");
            t_price.setText("0");
            t_total.setText("0");
            t_stok.setText("");

        }       // TODO add your handling code here:
    }//GEN-LAST:event_cb_rfqActionPerformed

    private void t_stokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_stokKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_stokKeyTyped

    private void t_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_priceKeyReleased

        if (t_stok.getText().equals("")) {

        } else {
            a = Long.valueOf(t_stok.getText());
            b = Long.valueOf(t_price.getText());
            long c = a * b;
            String d = String.valueOf(c);
            t_total.setText(d);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_t_priceKeyReleased

    private void t_stokKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_stokKeyReleased
        if (t_price.getText().equals("")) {

        } else {
            a = Long.valueOf(t_stok.getText());
            b = Long.valueOf(t_price.getText());
            long c = a * b;
            String d = String.valueOf(c);
            t_total.setText(d);
        } // TODO add your handling code here:
    }//GEN-LAST:event_t_stokKeyReleased

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
        long total = Long.valueOf(t_amount.getText());
        long disc = Long.valueOf(t_disc.getText());
        long total1 = total - (total * disc / 100L);
        t_total_1.setText(String.valueOf(total1));
        long ppn = total1 * 11L / 100L;
        long total2 = total1 + (total1 * 11L / 100L);
        t_ppn.setText(String.valueOf(ppn));
        t_total_2.setText(String.valueOf(total2));        // TODO add your handling code here:
    }//GEN-LAST:event_t_discKeyReleased

    private void t_totalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_totalKeyReleased
//      if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE) {
//            return;
//        }
//
//        String text = t_total.getText().replaceAll(",", "");
//        double value = Double.parseDouble(text);
//
//        DecimalFormat formatter = new DecimalFormat("#,###.##");
//        String formattedText = formatter.format(value);
//
//        t_total.setText(formattedText);   // TODO add your handling code here:
    }//GEN-LAST:event_t_totalKeyReleased

    private void t_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_priceKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }            // TODO add your handling code here:
    }//GEN-LAST:event_t_priceKeyTyped

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        String[] parts1 = cb_rfq.getSelectedItem().toString().split("-");
        String id1 = parts1[1];

        try {
            stm = koneksi.createStatement();
            String sql = "insert into po_sq (rfq_id,amount,disc,total1,ppn,total2,date) values('" + id1 + "'"
                    + ",'" + t_amount.getText() + "'"
                    + ",'" + t_disc.getText() + "'"
                    + ",'" + t_total_1.getText() + "'"
                    + ",'" + t_ppn.getText() + "'"
                    + ",'" + t_total_2.getText() + "'"
                    + ",'" + t_date.getText() + "')";
            stm.executeUpdate(sql);
            stm.close();
            JOptionPane.showMessageDialog(null, "Data Saved");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }

        int jtabelrows = jTable2.getRowCount();

        for (int i = 0; i <= jtabelrows - 1; i++) {
            DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();

            String mr_id = (String) model1.getValueAt(i, 1);
            String rfq_id = (String) model1.getValueAt(i, 0);
            String price = (String) model1.getValueAt(i, 4);
            String total = (String) model1.getValueAt(i, 5);

            String[] parts = mr_id.split("-");
            String id = parts[1];
            String[] parts2 = rfq_id.split("-");
            String id2 = parts2[1];

            try {
                stm = koneksi.createStatement();
                String sql = "UPDATE po_rfq_items SET price = '" + price + "',total = '" + total + "' WHERE rfq_id = '" + id2 + "' and mr_id = '" + id + "'";
                stm.executeUpdate(sql);
                stm.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
            }

        }
        
        
        
        String mr_id3 = cb_rfq.getSelectedItem().toString();

        String[] parts = mr_id3.split("-");
        String id = parts[1];

        try {
            stm = koneksi.createStatement();
            String sql = "UPDATE po_rfq SET status = '2' WHERE id = '" + id + "'";
            stm.executeUpdate(sql);
            stm.close();
            JOptionPane.showMessageDialog(null, "Data Saved");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }
        cb_rfq();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void cb_mrPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb_mrPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_mrPopupMenuWillBecomeVisible

    private void cb_mrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mrActionPerformed

        if (cb_mr.getSelectedItem() == null) {

        } else {
            add_from_cb();
            if (t_stok.getText().equals("")) {

            } else {
                a = Long.valueOf(t_stok.getText());
                b = Long.valueOf(t_price.getText());
                long c = a * b;
                String d = String.valueOf(c);
                t_total.setText(d);
            }

        } // TODO add your handling code here:
    }//GEN-LAST:event_cb_mrActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
        String[] parts = cb_mr.getSelectedItem().toString().split("-");
        String id = parts[0] + "-" + parts[1];
        int rowCount1 = dataModel2.getRowCount();
        for (int i = rowCount1 - 1; i >= 0; i--) {

            if (dataModel2.getValueAt(i, 1).equals(id)) {
                dataModel2.setValueAt(t_price.getText(), i, 4);
                dataModel2.setValueAt(t_total.getText(), i, 5);

            }

        }

        int rowCount = dataModel2.getRowCount();

// Variabel untuk menyimpan jumlah
        long total = 0L;

// Looping untuk menghitung jumlah pada kolom tertentu
        for (int i = 0; i < rowCount; i++) {
            total += Long.parseLong(dataModel2.getValueAt(i, 5).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
        }

// Menampilkan hasil jumlah
        t_amount.setText(String.valueOf(total));

        long disc = Long.valueOf(t_disc.getText());
        long total1 = total - (total * disc / 100);
        t_total_1.setText(String.valueOf(total1));
        long ppn = total1 * 11 / 100;
        long total2 = total1 + (total1 * 11 / 100);
        t_ppn.setText(String.valueOf(ppn));
        t_total_2.setText(String.valueOf(total2));

// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        add_from_table();        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void t_dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_dateKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_dateKeyReleased

    private void t_dateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_dateKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_dateKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.ComboBoxSuggestion cb_mr;
    private CustomResource.ComboBoxSuggestion cb_rfq;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private CustomResource.CustomTextfield t_amount;
    private CustomResource.CustomTextfield t_date;
    private CustomResource.CustomTextfield t_disc;
    private CustomResource.CustomTextfield t_name_item;
    private CustomResource.CustomTextfield t_ppn;
    private CustomResource.CustomTextfield t_price;
    private CustomResource.CustomTextfield t_stok;
    private CustomResource.CustomTextfield t_total;
    private CustomResource.CustomTextfield t_total_1;
    private CustomResource.CustomTextfield t_total_2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}