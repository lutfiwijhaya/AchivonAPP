/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ProcurementSystem;

import CustomResource.koneksi;
import HumanResource.Employe_list;
import Main.MasterForm;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class po extends MasterForm {
 Statement stm;
    ResultSet rs;
    Connection koneksi;
    int id_po;
    int a = 1;
    int b= 1;
    /**
     * Creates new form po
     */
    public po() {
        initComponents();
        openDB();
        addtext();
        id_employee();
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
    
    
    private void id_employee() {
        String sql = "select max(id_po) from po";
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int a = rs.getInt(1);
                id_po = a + 1;
               
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        String id = Integer.toString(id_po);
        t_id_po.setText(id);
        
    }
    
     private void addtext() {

        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select * from biz_partner where biz_id = "+ CustomResource.EmployeeSession.getbiz_id()+"");

            while (rs.next()) {
                String a =  rs.getString("address") + " " +"RT"+"/"+ rs.getString("rt")+"RW"+"/"+ rs.getString("rw")+" "+rs.getString("city")+" "+rs.getString("province")+" "+rs.getString("postcode") ;
                t_name.setText(rs.getString("name"));
                t_hp.setText(rs.getString("no_hp"));
                t_emial.setText(rs.getString("email"));
                t_addres.setText(a);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        dateChooser2 = new com.raven.datechooser.DateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        t_id_po = new CustomResource.CustomTextfield();
        t_name_item = new CustomResource.CustomTextfield();
        t_po_desc = new CustomResource.CustomTextfield();
        t_stok = new CustomResource.CustomTextfield();
        jButton3 = new javax.swing.JButton();
        t_size = new CustomResource.CustomTextfield();
        t_total_2 = new CustomResource.CustomTextfield();
        t_price = new CustomResource.CustomTextfield();
        t_total = new CustomResource.CustomTextfield();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        box_qty = new CustomResource.ComboBoxSuggestion();
        jButton6 = new javax.swing.JButton();
        jScrollPane25 = new javax.swing.JScrollPane();
        t_remark = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t_name = new CustomResource.CustomTextfield();
        t_hp = new CustomResource.CustomTextfield();
        t_emial = new CustomResource.CustomTextfield();
        t_tgl_po = new CustomResource.CustomTextfield();
        t_tgl_delivery = new CustomResource.CustomTextfield();
        t_addres = new CustomResource.CustomTextfield();
        t_spec = new CustomResource.CustomTextfield();
        t_disc = new CustomResource.CustomTextfield();
        t_amount = new CustomResource.CustomTextfield();
        t_total_1 = new CustomResource.CustomTextfield();
        t_ppn = new CustomResource.CustomTextfield();
        jButton7 = new javax.swing.JButton();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(t_tgl_po);

        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(t_tgl_delivery);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_id_po.setEnabled(false);
        t_id_po.setLabelText("ID PO");
        jPanel1.add(t_id_po, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 150, -1));

        t_name_item.setLabelText("Name of Item");
        jPanel1.add(t_name_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 257, -1));

        t_po_desc.setLabelText("PO Description");
        jPanel1.add(t_po_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 257, -1));

        t_stok.setLabelText("Stok");
        t_stok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_stokKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_stokKeyTyped(evt);
            }
        });
        jPanel1.add(t_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 130, -1));

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 940, 120, 40));

        t_size.setLabelText("Size");
        jPanel1.add(t_size, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 257, -1));

        t_total_2.setEnabled(false);
        t_total_2.setLabelText("Total");
        jPanel1.add(t_total_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 880, 160, -1));

        t_price.setLabelText("Price");
        t_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_priceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_priceKeyTyped(evt);
            }
        });
        jPanel1.add(t_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, 257, -1));

        t_total.setEnabled(false);
        t_total.setLabelText("Total");
        t_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_totalKeyReleased(evt);
            }
        });
        jPanel1.add(t_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 257, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PO", "Name Item", "Spec", "Size", "Stok", "Qty", "Price", "Total", "Remark"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, 660, 140));

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 140, 30));

        jButton5.setText("Submit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 940, 120, 40));

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Items List");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 650, 20));

        box_qty.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "QTY", "Pcs", "Ctn", "Ball", "Roll" }));
        box_qty.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        box_qty.setName(""); // NOI18N
        box_qty.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                box_qtyPopupMenuWillBecomeVisible(evt);
            }
        });
        box_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_qtyActionPerformed(evt);
            }
        });
        jPanel1.add(box_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 100, -1));

        jButton6.setText("Add Supplier");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 102, -1));

        t_remark.setColumns(20);
        t_remark.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        t_remark.setRows(5);
        t_remark.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                t_remarkMouseWheelMoved(evt);
            }
        });
        jScrollPane25.setViewportView(t_remark);

        jPanel1.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 210, -1));

        jLabel1.setText("Remark");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PURCHASE ORDER");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 650, 20));

        t_name.setEnabled(false);
        t_name.setLabelText("Supplier");
        jPanel1.add(t_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 257, -1));

        t_hp.setEnabled(false);
        t_hp.setLabelText("Mobile No");
        jPanel1.add(t_hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 257, -1));

        t_emial.setEnabled(false);
        t_emial.setLabelText("E-mail");
        jPanel1.add(t_emial, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 257, -1));

        t_tgl_po.setLabelText("PO Date");
        jPanel1.add(t_tgl_po, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 257, -1));

        t_tgl_delivery.setLabelText("Delivery Date");
        jPanel1.add(t_tgl_delivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 257, -1));

        t_addres.setEnabled(false);
        t_addres.setLabelText("Address");
        jPanel1.add(t_addres, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 257, -1));

        t_spec.setLabelText("Spec");
        jPanel1.add(t_spec, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 257, -1));

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
        jPanel1.add(t_disc, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 730, 160, -1));

        t_amount.setEnabled(false);
        t_amount.setLabelText("Amount");
        t_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_amountKeyReleased(evt);
            }
        });
        jPanel1.add(t_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 730, 160, -1));

        t_total_1.setEnabled(false);
        t_total_1.setLabelText("Total");
        jPanel1.add(t_total_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 780, 160, -1));

        t_ppn.setEnabled(false);
        t_ppn.setLabelText("PPN 11%");
        jPanel1.add(t_ppn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 830, 160, -1));

        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 690, 102, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
        List list = new ArrayList<>();
        jTable1.setAutoCreateColumnsFromModel(true);
        list.add(id_po);
        list.add(t_name_item.getText());
        list.add(t_spec.getText());
        list.add(t_size.getText());
        list.add(t_stok.getText());
        list.add(box_qty.getSelectedItem());
        list.add(t_price.getText());
        list.add(t_total.getText());
        list.add(t_remark.getText());
//         int rowCount1 = dataModel.getRowCount();
//         for (int i = rowCount1 - 1; i >= 0; i--) {
//               dataModel.removeRow(i);
//            }
        dataModel.insertRow(0, list.toArray());   
        


int rowCount = dataModel.getRowCount();

// Variabel untuk menyimpan jumlah
long total = 0L;

// Looping untuk menghitung jumlah pada kolom tertentu
for (int i = 0; i < rowCount; i++) {
    total += Long.parseLong(dataModel.getValueAt(i, 7).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
}

// Menampilkan hasil jumlah
t_amount.setText(String.valueOf(total));
 
long disc = Long.valueOf(t_disc.getText());
long total1 = total - (total * disc / 100);
t_total_1.setText(String.valueOf(total1));
long ppn = total1 * 11 / 100 ;
long total2 = total1 + (total1 * 11 / 100);
t_ppn.setText(String.valueOf(ppn));
t_total_2.setText(String.valueOf(total2));





// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
 try {
     String a = "0";
                stm = koneksi.createStatement();
                String sql = "insert into po (id_po,biz_id,amount,diskon,total1,ppn,total2,tgl_po,delivery_date,description_po,status_po) values('" + t_id_po.getText() + "'"
                        + ",'" + CustomResource.EmployeeSession.getbiz_id() + "'"
                        + ",'" + t_amount.getText() + "'"
                        + ",'" + t_disc.getText() + "'"
                        + ",'" + t_total_1.getText() + "'"
                        + ",'" + t_ppn.getText() + "'"
                        + ",'" + t_total_2.getText() + "'"
                        + ",'" + t_tgl_po.getText() + "'"
                        + ",'" + t_tgl_delivery.getText() + "'"
                        + ",'" + t_po_desc.getText() + "'"
                        + ",'" +a+ "')";

                stm.executeUpdate(sql);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
            }
 
 
        DefaultTableModel ImportDataExel = (DefaultTableModel) jTable1.getModel();
        int jtabelrows = jTable1.getRowCount();

        for (int i = 0; i <= jtabelrows - 1; i++) {
            if (jTable1.getValueAt(i, 0) == null) {
            } else {
                String dtabel_id_po = jTable1.getValueAt(i, 0).toString();
                String dtabel_name = jTable1.getValueAt(i, 1).toString();
                String dtabel_price = jTable1.getValueAt(i, 6).toString();
                String dtabel_spec = jTable1.getValueAt(i, 2).toString();
                String dtabel_size = jTable1.getValueAt(i, 3).toString();
                String dtabel_stok = jTable1.getValueAt(i, 4).toString();
                String dtabel_qty = jTable1.getValueAt(i, 5).toString();
                String dtabel_total_price = jTable1.getValueAt(i, 7).toString();
                String dtabel_remark = jTable1.getValueAt(i, 8).toString();
                try {
                    stm = koneksi.createStatement();
                    String sql = "insert into po_item (id_po,name_item,price_item,spec,size,stok,qty,total_price,remark) values('" + dtabel_id_po + "'"
                            + ",'" + dtabel_name + "'"
                            + ",'" + dtabel_price + "'"
                            + ",'" + dtabel_spec + "'"
                            + ",'" + dtabel_size + "'"
                            + ",'" + dtabel_stok + "'"
                            + ",'" + dtabel_qty + "'"
                            + ",'" + dtabel_total_price + "'"
                            + ",'" + dtabel_remark + "')";

                    stm.executeUpdate(sql);
                    stm.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
 
 
 
  JOptionPane.showMessageDialog(null, "Data Tersimpan");
 Main.main.getMain().showForm(new po());

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void box_qtyPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_box_qtyPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_box_qtyPopupMenuWillBecomeVisible

    private void box_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_qtyActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
CustomResource.EmployeeSession.setsesiform("3");
        new Employe_list().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void t_remarkMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_t_remarkMouseWheelMoved
       
    }//GEN-LAST:event_t_remarkMouseWheelMoved

    private void t_stokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_stokKeyTyped
 char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_stokKeyTyped

    private void t_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_priceKeyReleased

       if(t_stok.getText().equals("")){
       
        } else {
       a = Integer.valueOf(t_stok.getText());
      b = Integer.valueOf(t_price.getText());
     int c = a * b;
     String d = String.valueOf(c);
     t_total.setText(d);
      }
     



        // TODO add your handling code here:
    }//GEN-LAST:event_t_priceKeyReleased

    private void t_stokKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_stokKeyReleased
      if(t_price.getText().equals("")){
       
        } else {
       a = Integer.valueOf(t_stok.getText());
      b = Integer.valueOf(t_price.getText());
     int c = a * b;
     String d = String.valueOf(c);
     t_total.setText(d);
      } // TODO add your handling code here:
    }//GEN-LAST:event_t_stokKeyReleased

    private void t_discActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_discActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_discActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
  int[] selectedRows = jTable1.getSelectedRows();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            model.removeRow(selectedRows[i]);
        }    
        
        
        DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
        int rowCount = dataModel.getRowCount();

// Variabel untuk menyimpan jumlah
long total = 0L;

// Looping untuk menghitung jumlah pada kolom tertentu
for (int i = 0; i < rowCount; i++) {
    total += Long.parseLong(dataModel.getValueAt(i, 7).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
}

// Menampilkan hasil jumlah
t_amount.setText(String.valueOf(total));
 
long disc = Long.valueOf(t_disc.getText());
long total1 = total - (total * disc / 100);
t_total_1.setText(String.valueOf(total1));
long ppn = total1 * 11 / 100 ;
long total2 = total1 + (total1 * 11 / 100);
t_ppn.setText(String.valueOf(ppn));
t_total_2.setText(String.valueOf(total2));



// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.ComboBoxSuggestion box_qty;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JTable jTable1;
    private CustomResource.CustomTextfield t_addres;
    private CustomResource.CustomTextfield t_amount;
    private CustomResource.CustomTextfield t_disc;
    private CustomResource.CustomTextfield t_emial;
    private CustomResource.CustomTextfield t_hp;
    private CustomResource.CustomTextfield t_id_po;
    private CustomResource.CustomTextfield t_name;
    private CustomResource.CustomTextfield t_name_item;
    private CustomResource.CustomTextfield t_po_desc;
    private CustomResource.CustomTextfield t_ppn;
    private CustomResource.CustomTextfield t_price;
    private javax.swing.JTextArea t_remark;
    private CustomResource.CustomTextfield t_size;
    private CustomResource.CustomTextfield t_spec;
    private CustomResource.CustomTextfield t_stok;
    private CustomResource.CustomTextfield t_tgl_delivery;
    private CustomResource.CustomTextfield t_tgl_po;
    private CustomResource.CustomTextfield t_total;
    private CustomResource.CustomTextfield t_total_1;
    private CustomResource.CustomTextfield t_total_2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
