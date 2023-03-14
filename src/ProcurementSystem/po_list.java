/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ProcurementSystem;

import CustomResource.CandidateSession;
import CustomResource.koneksi;
import Main.MasterForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USER
 */
public class po_list extends MasterForm {
 Statement stm;
    ResultSet rs;
    Connection koneksi;
    Map<String, Object> param = new HashMap<String, Object>();
    int o= 0;
    int d= 1;
    String b = "name";
   
    
    /**
     * Creates new form po_list
     */
    public po_list() {
        initComponents();
        openDB();
        tampil();
        ckbox();
        
      
    }
    
    void ckbox(){
      jCheckBox1.addActionListener(e -> {
      if (jCheckBox1.isSelected()) {
          d = 1;
        System.out.println(d);
      } else {
           d = 3;
        System.out.println(d);
      }
    });
      
      jCheckBox2.addActionListener(e -> {
      if (jCheckBox2.isSelected()) {
           o = 0;
        System.out.println(0);
      } else {
           o = 3;
        System.out.println(o);
      }
    });
    jCheckBox1.setSelected(true);
    jCheckBox2.setSelected(true);
    }
    
    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }
    
    void tampil(){
    try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                        myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
    }
    
    
    void kondisi_tampil(){
        
           String c = boxTax1.getSelectedItem().toString();

        if (c.equals("ID")) {
            b = "id_po";
        } else if (c.equals("Nama Supplier")) {
            b = "name";
        } else if (c.equals("Kota")) {
            b = "city";
        }
        
        if (o==0 && d==1){
           try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                         myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        } else if (o==0 && d==3){
         try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where status_po = 0 and " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                         myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        
        }  else if (o==3 && d==1){
         try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where status_po = 1 and " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                        myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};
                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        
        }  else {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
        
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

        dateChooser2 = new com.raven.datechooser.DateChooser();
        dateChooser3 = new com.raven.datechooser.DateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        textSearch = new CustomResource.CustomTextfield();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        boxTax1 = new CustomResource.ComboBoxSuggestion();
        etgl = new CustomResource.CustomTextfield();
        stgl = new CustomResource.CustomTextfield();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(stgl);

        dateChooser3.setDateFormat("yyyy-MM-dd");
        dateChooser3.setTextRefernce(etgl);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID PO", "Supplier ID", "Name Supplier", "Mobile No Supplier", "Email Supplier", "Supplier Addres", "PO Date Entered", "Delivery Date", "PO Descrition", "Amount", "Discon %", "Amount After Disc", "PPN 11%", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1140, 290));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ITEM LIST");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 1140, 20));

        jButton2.setText("View Report ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, -1));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, -1, -1));

        jButton4.setText("Mark Done");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID PO", "Name Item", "Price", "Spec", "Size", "Stock", "Qty", "Total Price", "Remark"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 1140, 320));

        jLabel4.setBackground(new java.awt.Color(0, 51, 51));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Status PO");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 260, 20));

        textSearch.setLabelText("Search");
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });
        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSearchKeyTyped(evt);
            }
        });
        jPanel1.add(textSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 250, -1));

        jCheckBox1.setText("Done");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 90, -1, -1));

        jCheckBox2.setText("On Process");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, -1, -1));

        boxTax1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Search Category", "ID", "Nama Supplier", " " }));
        boxTax1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        boxTax1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                boxTax1PopupMenuWillBecomeVisible(evt);
            }
        });
        boxTax1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTax1ActionPerformed(evt);
            }
        });
        jPanel1.add(boxTax1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 150, -1));

        etgl.setLabelText("End Date");
        etgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etglActionPerformed(evt);
            }
        });
        etgl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                etglKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                etglKeyTyped(evt);
            }
        });
        jPanel1.add(etgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 110, -1));

        stgl.setLabelText("Start Date");
        stgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stglActionPerformed(evt);
            }
        });
        stgl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stglKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stglKeyTyped(evt);
            }
        });
        jPanel1.add(stgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 110, -1));

        jButton5.setText("Short");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 51, 51));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PURCHASE ORDER LIST");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 1140, 20));

        jLabel6.setBackground(new java.awt.Color(0, 51, 51));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Search");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 420, 20));

        jLabel7.setBackground(new java.awt.Color(0, 51, 51));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Short by date");
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 390, 20));

        jButton6.setText("View Report Summary");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 430, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
 try {
     int row = jTable1.getSelectedRow();
       
  String b = ((String) jTable1.getValueAt(row, 0));

    
         DefaultTableModel myModel = (DefaultTableModel) jTable2.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po_item where id_po = "+b+"");
                while (myRess.next()) {
//                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                        myRess.getString("name_item"),
                        myRess.getString("price_item"),
                        myRess.getString("spec"),
                        myRess.getString("size"),
                        myRess.getString("stok"),
                        myRess.getString("qty"),
                        myRess.getString("total_price"),  
                        myRess.getString("remark")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  

        int[] selectedRows = jTable1.getSelectedRows();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            String c = (String) model.getValueAt(selectedRows[i], 0);
            try {
                stm = koneksi.createStatement();

                String sql = "DELETE FROM po where id_po = '" + c + "'";
                String sql1 = "DELETE FROM po_item where id_po = '" + c + "'";
                model.removeRow(selectedRows[i]);
                stm.executeUpdate(sql);
                stm.executeUpdate(sql1);
                stm.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
            }

        }    
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  try {
        int row = jTable1.getSelectedRow();
       
  String b = ((String) jTable1.getValueAt(row, 0));
  
//                    Class.forName("com.mysql.jdbc.Driver");
//String filePath = "src/Doc/test.pdf";
                    Connection kon =DriverManager.getConnection("jdbc:mysql://localhost/achivonapp","root","");
//                    File O = new File("C:\\Program Files (x86)\\AchivonAPP\\cdemployee.jasper");
//                    jasperdesign = JRXmlLoader.load(O);
                    param.clear();
//                    jasperreport = JasperCompileManager.compileReport(jasperdesign);
                    param.put("id_po",b);
//                    jasperprint = JasperFillManager.fillReport(jasperreport, param, kon);
//                    JasperExportManager.exportReportToPdfFile(jasperprint, filePath);
//                    JasperViewer.viewReport(jasperprint, false);
            String reportPath = "C:\\Users\\USER\\JaspersoftWorkspace\\MyReports\\PO_list.jasper";
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, param, kon);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchActionPerformed

    private void textSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyReleased
   String c = boxTax1.getSelectedItem().toString();

        if (c.equals("ID")) {
            b = "id_po";
        } else if (c.equals("Nama Supplier")) {
            b = "name";
        } else if (c.equals("Kota")) {
            b = "city";
        }
        
        if (o==0 && d==1){
           try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                         myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        } else if (o==0 && d==3){
         try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where status_po = 0 and " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                         myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        
        }  else if (o==3 && d==1){
         try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where status_po = 1 and " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                        myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};
                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        
        }  else {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
        
        }      

    }//GEN-LAST:event_textSearchKeyReleased

    private void textSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyTyped
       

        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchKeyTyped

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
  String c = boxTax1.getSelectedItem().toString();

        if (c.equals("ID")) {
            b = "id_po";
        } else if (c.equals("Nama Supplier")) {
            b = "name";
        } else if (c.equals("Kota")) {
            b = "city";
        }
        
        if (o==0 && d==1){
           try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                         myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        } else if (o==0 && d==3){
         try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where status_po = 0 and " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                         myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        
        }  else if (o==3 && d==1){
         try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where status_po = 1 and " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                        myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};
                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        
        }  else {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
        
        }  
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        String c = boxTax1.getSelectedItem().toString();

        if (c.equals("ID")) {
            b = "id_po";
        } else if (c.equals("Nama Supplier")) {
            b = "name";
        } else if (c.equals("Kota")) {
            b = "city";
        }
        
        if (o==0 && d==1){
           try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                         myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        } else if (o==0 && d==3){
         try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where status_po = 0 and " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                         myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        
        }  else if (o==3 && d==1){
         try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where status_po = 1 and " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                        myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};
                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        
        }  else {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
        
        }  
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void boxTax1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_boxTax1PopupMenuWillBecomeVisible
        boxTax1.removeItem("Search Category");    // TODO add your handling code here:
    }//GEN-LAST:event_boxTax1PopupMenuWillBecomeVisible

    private void boxTax1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTax1ActionPerformed
 String c = boxTax1.getSelectedItem().toString();

        if (c.equals("ID")) {
            b = "id_po";
        } else if (c.equals("Nama Supplier")) {
            b = "name";
        } else if (c.equals("Kota")) {
            b = "city";
        }
        
        if (o==0 && d==1){
           try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                         myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        } else if (o==0 && d==3){
         try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where status_po = 0 and " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                         myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        
        }  else if (o==3 && d==1){
         try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where status_po = 1 and " + b + " LIKE '%" + textSearch.getText() + "%'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                        myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};
                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        
        }  else {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
        
        }                // TODO add your handling code here:
    }//GEN-LAST:event_boxTax1ActionPerformed

    private void etglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etglActionPerformed

    private void etglKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etglKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_etglKeyReleased

    private void etglKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etglKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_etglKeyTyped

    private void stglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stglActionPerformed

    private void stglKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stglKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_stglKeyReleased

    private void stglKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stglKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_stglKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
 String c = boxTax1.getSelectedItem().toString();

        if (c.equals("ID")) {
            b = "id_po";
        } else if (c.equals("Nama Supplier")) {
            b = "name";
        } else if (c.equals("Kota")) {
            b = "city";
        }
        
        if (o==0 && d==1){
           try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where " + b + " LIKE '%" + textSearch.getText() + "%' AND tgl_po BETWEEN '"+stgl.getText()+"' AND '"+etgl.getText()+"'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                         myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        } else if (o==0 && d==3){
         try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where status_po = 0 and " + b + " LIKE '%" + textSearch.getText() + "%' AND tgl_po BETWEEN '"+stgl.getText()+"' AND '"+etgl.getText()+"'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                         myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        
        }  else if (o==3 && d==1){
         try {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
                ResultSet myRess = koneksi.createStatement().executeQuery("select * from po inner join biz_partner on po.biz_id = biz_partner.biz_id where status_po = 1 and " + b + " LIKE '%" + textSearch.getText() + "%' AND tgl_po BETWEEN '"+stgl.getText()+"' AND '"+etgl.getText()+"'");
                while (myRess.next()) {
                     String a =  myRess.getString("address") + " " +"RT"+"/"+ myRess.getString("rt")+"RW"+"/"+ myRess.getString("rw")+" "+myRess.getString("city")+" "+myRess.getString("province")+" "+myRess.getString("postcode") ;
                    String myData[] = {myRess.getString("id_po"),
                        myRess.getString("partner_id"),
                        myRess.getString("name"),
                        myRess.getString("no_hp"),
                        myRess.getString("email"),a,
                        myRess.getString("tgl_po"),
                        myRess.getString("delivery_date"),
                        myRess.getString("description_po"),
                        myRess.getString("amount"),
                        myRess.getString("diskon"),
                        myRess.getString("total1"),
                        myRess.getString("ppn"),
                        myRess.getString("total2")};
                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        
        }  else {
         DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
         int rowCount = myModel.getRowCount();
          for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
        
        }              
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
 try {
                    stm = koneksi.createStatement();
                    String sql = "truncate po_report";

                    stm.executeUpdate(sql);
                    stm.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
                }
        DefaultTableModel ImportDataExel = (DefaultTableModel) jTable1.getModel();
        int jtabelrows = jTable1.getRowCount();

        for (int i = 0; i <= jtabelrows - 1; i++) {
            if (jTable1.getValueAt(i, 0) == null) {
            } else {
                String dtabel_id_po = jTable1.getValueAt(i, 0).toString();
                String dtabel_biz_id = jTable1.getValueAt(i, 1).toString();
                String dtabel_name_sup = jTable1.getValueAt(i, 2).toString();
                String dtabel_hp = jTable1.getValueAt(i, 3).toString();
                String dtabel_email = jTable1.getValueAt(i, 4).toString();
                String dtabel_add = jTable1.getValueAt(i, 5).toString();
                String dtabel_po_date = jTable1.getValueAt(i, 6).toString();
                String dtabel_deliv_date = jTable1.getValueAt(i, 7).toString();
                String dtabel_desc = jTable1.getValueAt(i, 8).toString();
                String dtabel_amount = jTable1.getValueAt(i, 9).toString();
                String dtabel_disk = jTable1.getValueAt(i, 10).toString();
                String dtabel_total1 = jTable1.getValueAt(i, 11).toString();
                String dtabel_ppn = jTable1.getValueAt(i, 12).toString();
                String dtabel_total2 = jTable1.getValueAt(i, 13).toString();
                
                try {
                    stm = koneksi.createStatement();
                    String sql = "insert into po_report (id_po,biz_id,nama_sup,hp_sup,email_sup,addres_sup,po_date,deliv_date,po_desc,amount,diskon,total1,ppn,total2) values('" + dtabel_id_po + "'"
                            + ",'" + dtabel_biz_id+ "'"
                            + ",'" + dtabel_name_sup + "'"
                            + ",'" + dtabel_hp + "'"
                            + ",'" + dtabel_email + "'"
                            + ",'" + dtabel_add + "'"
                            + ",'" + dtabel_po_date + "'"
                            + ",'" + dtabel_deliv_date + "'"
                            + ",'" + dtabel_desc + "'"
                            + ",'" + dtabel_amount + "'"
                            + ",'" + dtabel_disk + "'"
                            + ",'" + dtabel_total1 + "'"
                            + ",'" + dtabel_ppn + "'"
                            + ",'" + dtabel_total2 + "')";

                    stm.executeUpdate(sql);
                    stm.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
                }
            }
        }   
        
try {
        
       
  String b = "0";
  
//                    Class.forName("com.mysql.jdbc.Driver");
//String filePath = "src/Doc/test.pdf";
                    Connection kon =DriverManager.getConnection("jdbc:mysql://localhost/achivonapp","root","");
//                    File O = new File("C:\\Program Files (x86)\\AchivonAPP\\cdemployee.jasper");
//                    jasperdesign = JRXmlLoader.load(O);
                    param.clear();
//                    jasperreport = JasperCompileManager.compileReport(jasperdesign);
                    param.put("id_po",b);
//                    jasperprint = JasperFillManager.fillReport(jasperreport, param, kon);
//                    JasperExportManager.exportReportToPdfFile(jasperprint, filePath);
//                    JasperViewer.viewReport(jasperprint, false);
            String reportPath = "C:\\Users\\USER\\JaspersoftWorkspace\\MyReports\\PO_summary.jasper";
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, param, kon);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }  

// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
int respon = JOptionPane.showConfirmDialog(null, "Purchase Order Has Done ?", "Option", JOptionPane.YES_NO_OPTION);
        if (respon == 0) {
            try {
         stm = koneksi.createStatement();
         int row = jTable1.getSelectedRow();
         
         String b = ((String) jTable1.getValueAt(row, 0));
         String sql9 = "update po set status_po = '1' where id_po='" + b + "'";
         
         stm.executeUpdate(sql9); 
JOptionPane.showMessageDialog(null, "PO status has been changed"); 
kondisi_tampil();
// TODO add your handling code here:
     } catch (SQLException ex) {
         Logger.getLogger(po_list.class.getName()).log(Level.SEVERE, null, ex);
     }
        
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.ComboBoxSuggestion boxTax1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private com.raven.datechooser.DateChooser dateChooser3;
    private CustomResource.CustomTextfield etgl;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private CustomResource.CustomTextfield stgl;
    private CustomResource.CustomTextfield textSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
