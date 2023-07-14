/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ProcurementSystem;

import CustomResource.koneksi;
import DocumentControl.dc_form_transmittal_view;
import HumanResource.Employe_list;
import Main.MasterForm;
import static Main.main.bodyPanel;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author USER
 */
public class po_rfq_view extends MasterForm {

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
    public po_rfq_view() {
        initComponents();
        openDB();

        tampil_form();
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

    void tampil_form() {

        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("SELECT * FROM po_rfq INNER JOIN biz_partner on po_rfq.biz_id = biz_partner.biz_id where id = '" + CustomResource.SessionAny.get_id_rfq() + "'");
            while (rs.next()) {
                t_id_po.setText(rs.getString("id"));
                t_name.setText(rs.getString("name"));
                t_email.setText(rs.getString("email"));
                t_hp.setText(rs.getString("no_hp"));
                t_address.setText(rs.getString("address") + " RT/RW " + rs.getString("rt") + "/" + rs.getString("rw") + ", " + rs.getString("city") + ", " + rs.getString("province") + " (" + rs.getString("postcode") + ")");
                t_tgl_rfq.setText(rs.getString("rfq_date"));
                t_estimate_deliv.setText(rs.getString("deliv_date"));
                t_payment.setText(rs.getString("payment"));
                t_close_date.setText(rs.getString("close_date"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }
    }

    void tampil_table() {

        DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();
        int rowCount1 = dataModel2.getRowCount();

        for (int i = rowCount1 - 1; i >= 0; i--) {
            dataModel2.removeRow(i);
        }
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from po_rfq_items INNER JOIN po_material_request on po_rfq_items.mr_id = po_material_request.id_material_request where rfq_id = '" + CustomResource.SessionAny.get_id_rfq() + "'");
            while (rs.next()) {

                String[] data = {
                    "MR-" + rs.getString("id_material_request"),
                    rs.getString("id_material_code"),
                    rs.getString("material_name"),
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

    void reportx() throws ParseException {
        DefaultTableModel dataModelp = (DefaultTableModel) jTable1.getModel();
        FileOutputStream excelfou = null;
        BufferedOutputStream excelbou = null;
        XSSFWorkbook workbook = null;
        JFileChooser excelFileChooser = new JFileChooser();
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xlsx");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                // Membuat objek File template dan output
                File templateFile = new File("C:\\Users\\USER\\OneDrive\\Documents\\Form_RFQ.xlsx");
                File selectedFile = excelFileChooser.getSelectedFile();
                String outputFilePath = selectedFile.getParent() + "\\" + selectedFile.getName() + ".xlsx";
                File outputFile = new File(outputFilePath);

                // Membaca data template ke dalam workbook
                FileInputStream templateFis = new FileInputStream(templateFile);
                workbook = new XSSFWorkbook(templateFis);
                templateFis.close();

                // Membuat sheet baru di workbook
                XSSFSheet sheetCopy = workbook.getSheet("Sheet1");

                XSSFRow excelrow11 = sheetCopy.getRow(8);
                if (excelrow11 == null) {
                    excelrow11 = sheetCopy.createRow(8); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell11 = excelrow11.getCell(1);
                if (excelcell11 == null) {
                    excelcell11 = excelrow11.createCell(1); // Buat sel baru jika belum ada
                }
                excelcell11.setCellValue(t_email.getText());

                XSSFRow excelrow12 = sheetCopy.getRow(9);
                if (excelrow12 == null) {
                    excelrow12 = sheetCopy.createRow(9); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell12 = excelrow12.getCell(1);
                if (excelcell12 == null) {
                    excelcell12 = excelrow12.createCell(1); // Buat sel baru jika belum ada
                }
                excelcell12.setCellValue(t_hp.getText());

                XSSFRow excelrow13 = sheetCopy.getRow(10);
                if (excelrow13 == null) {
                    excelrow13 = sheetCopy.createRow(10); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell13 = excelrow13.getCell(1);
                if (excelcell13 == null) {
                    excelcell13 = excelrow13.createCell(1); // Buat sel baru jika belum ada
                }
                excelcell13.setCellValue(t_address.getText());

                XSSFRow excelrow14 = sheetCopy.getRow(7);
                if (excelrow14 == null) {
                    excelrow14 = sheetCopy.createRow(7); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell14 = excelrow14.getCell(1);
                if (excelcell14 == null) {
                    excelcell14 = excelrow14.createCell(1); // Buat sel baru jika belum ada
                }
                excelcell14.setCellValue(t_name.getText());

                String tgl;
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
                DateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy");

                Date date = inputFormat.parse(t_tgl_rfq.getText());
                tgl = outputFormat.format(date);

                XSSFRow excelrow15 = sheetCopy.getRow(6);
                if (excelrow15 == null) {
                    excelrow15 = sheetCopy.createRow(6); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell15 = excelrow15.getCell(5);
                if (excelcell15 == null) {
                    excelcell15 = excelrow15.createCell(5); // Buat sel baru jika belum ada
                }
                excelcell15.setCellValue(tgl);
                
               date = inputFormat.parse(t_close_date.getText());
                tgl = outputFormat.format(date);

                XSSFRow excelrow16 = sheetCopy.getRow(32);
                if (excelrow16 == null) {
                    excelrow16 = sheetCopy.createRow(32); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell16 = excelrow16.getCell(2);
                if (excelcell16 == null) {
                    excelcell16 = excelrow16.createCell(2); // Buat sel baru jika belum ada
                }
                excelcell16.setCellValue(date);
                
                 date = inputFormat.parse(t_estimate_deliv.getText());
                tgl = outputFormat.format(date);

                XSSFRow excelrow17 = sheetCopy.getRow(33);
                if (excelrow17 == null) {
                    excelrow17 = sheetCopy.createRow(33); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell17 = excelrow17.getCell(2);
                if (excelcell17 == null) {
                    excelcell17 = excelrow17.createCell(2); // Buat sel baru jika belum ada
                }
                excelcell17.setCellValue(date);

                XSSFRow excelrow18 = sheetCopy.getRow(34);
                if (excelrow18 == null) {
                    excelrow18 = sheetCopy.createRow(34); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell18 = excelrow18.getCell(2);
                if (excelcell18 == null) {
                    excelcell18 = excelrow18.createCell(2); // Buat sel baru jika belum ada
                }
                excelcell18.setCellValue(t_payment.getText());

                int row1 = 15;
                for (int i = 0; i < dataModelp.getRowCount(); i++) {

                    XSSFRow excelrow = sheetCopy.getRow(row1);
                    row1 = row1 + 1;
                    int col = 0;
                    for (int j = 2; j < dataModelp.getColumnCount(); j++) {
                        XSSFCell excelcell = excelrow.getCell(col);
                        if (excelcell == null) {
                            excelcell = excelrow.createCell(col);
                        }
                        col = col + 1;

                        String mr_id = (String) dataModelp.getValueAt(i, 2);

                        String[] parts = mr_id.split("-");
                        

                        String id = parts[0];
                        String id1 = parts[1];
                        String id2 = parts[2];
                        

                        if (col == 1) {
                            excelcell.setCellValue(id);
                        } else if (col == 2) {
                            excelcell.setCellValue(id1);
                        } else if (col == 3) {
                            excelcell.setCellValue(id2);
                        } else if (col == 4) {
                            excelcell.setCellValue(dataModelp.getValueAt(i, 5).toString());
                        } else if (col == 5) {
                            excelcell.setCellValue(dataModelp.getValueAt(i, 4).toString());
                        } else if (col == 6) {
                            excelcell.setCellValue(dataModelp.getValueAt(i, 6).toString());
                        }

                    }
                }
                int hex = dataModelp.getRowCount(); 
               
                for (int i = hex + 15; i < 130; i++) {
                    XSSFRow excelrow = sheetCopy.createRow(i);

                }
                // Menulis workbook ke dalam file output
                excelfou = new FileOutputStream(outputFile);
                excelbou = new BufferedOutputStream(excelfou);
                workbook.write(excelbou);
                JOptionPane.showMessageDialog(null, "Data Saved");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (excelbou != null) {
                        excelbou.close();
                    }
                    if (excelfou != null) {
                        excelfou.close();
                    }

                    if (workbook != null) {
                        workbook.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
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
        dateChooser3 = new com.raven.datechooser.DateChooser();
        dateChooser4 = new com.raven.datechooser.DateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        t_id_po = new CustomResource.CustomTextfield();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t_name = new CustomResource.CustomTextfield();
        t_hp = new CustomResource.CustomTextfield();
        t_email = new CustomResource.CustomTextfield();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        t_tgl_rfq = new CustomResource.CustomTextfield();
        t_payment = new CustomResource.CustomTextfield();
        t_estimate_deliv = new CustomResource.CustomTextfield();
        t_close_date = new CustomResource.CustomTextfield();
        jScrollPane3 = new javax.swing.JScrollPane();
        t_address = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();

        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(t_estimate_deliv);

        dateChooser3.setDateFormat("yyyy-MM-dd");
        dateChooser3.setTextRefernce(t_tgl_rfq);

        dateChooser4.setDateFormat("yyyy-MM-dd");
        dateChooser4.setTextRefernce(t_close_date);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_id_po.setEditable(false);
        t_id_po.setLabelText("ID RFQ");
        jPanel1.add(t_id_po, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 150, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MR ID", "ID Material", "Material Name", "Date Request", "Stock Needs", "Qty", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 660, 140));

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LIST ITEMS REQUEST");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 650, 20));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("REQUEST FOR QUATATION");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 650, 20));

        t_name.setEditable(false);
        t_name.setLabelText("Supplier");
        jPanel1.add(t_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 257, -1));

        t_hp.setEditable(false);
        t_hp.setLabelText("Mobile No");
        jPanel1.add(t_hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 257, -1));

        t_email.setEditable(false);
        t_email.setLabelText("E-mail");
        jPanel1.add(t_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 257, -1));

        jButton7.setText("Download Excel File");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 570, -1, -1));

        jButton8.setText("Back To RFQ List");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, 120, -1));

        t_tgl_rfq.setEnabled(false);
        t_tgl_rfq.setLabelText("RFQ Date");
        jPanel1.add(t_tgl_rfq, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 257, -1));

        t_payment.setEditable(false);
        t_payment.setLabelText("Payment Condition");
        t_payment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_paymentKeyTyped(evt);
            }
        });
        jPanel1.add(t_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 257, -1));

        t_estimate_deliv.setEnabled(false);
        t_estimate_deliv.setLabelText("Estimate Date Delivery");
        t_estimate_deliv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_estimate_delivKeyTyped(evt);
            }
        });
        jPanel1.add(t_estimate_deliv, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 257, -1));

        t_close_date.setEnabled(false);
        t_close_date.setLabelText("RFQ Close Date");
        jPanel1.add(t_close_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 257, -1));

        t_address.setEditable(false);
        t_address.setColumns(20);
        t_address.setLineWrap(true);
        t_address.setRows(5);
        t_address.setToolTipText("Address");
        t_address.setWrapStyleWord(true);
        jScrollPane3.setViewportView(t_address);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        jLabel1.setText("Address");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        jButton9.setText("Send To SQ Queque");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 570, 150, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void t_estimate_delivKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_estimate_delivKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_estimate_delivKeyTyped

    private void t_paymentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_paymentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_paymentKeyTyped

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
showForm(new po_list_rfq());
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            reportx();
            // TODO add your handling code here:
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
int respon = JOptionPane.showConfirmDialog(null, "Send To SQ Queque ?", "Option", JOptionPane.YES_NO_OPTION);
        if (respon == 0) {
        try {
            stm = koneksi.createStatement();
            String sql = "UPDATE po_rfq SET status = '1' WHERE id = '" + t_id_po.getText() + "'";
            stm.executeUpdate(sql);
            stm.close();
            JOptionPane.showMessageDialog(null, "Data Saved");
            showForm(new po_list_rfq());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser dateChooser2;
    private com.raven.datechooser.DateChooser dateChooser3;
    private com.raven.datechooser.DateChooser dateChooser4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea t_address;
    private CustomResource.CustomTextfield t_close_date;
    private CustomResource.CustomTextfield t_email;
    private CustomResource.CustomTextfield t_estimate_deliv;
    private CustomResource.CustomTextfield t_hp;
    private CustomResource.CustomTextfield t_id_po;
    private CustomResource.CustomTextfield t_name;
    private CustomResource.CustomTextfield t_payment;
    private CustomResource.CustomTextfield t_tgl_rfq;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
