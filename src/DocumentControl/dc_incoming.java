/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DocumentControl;

import ProcurementSystem.*;
import CustomResource.koneksi;
import HumanResource.Employe_list;
import Main.MasterForm;
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
import javax.swing.JScrollBar;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author USER
 */
public class dc_incoming extends MasterForm {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    int id_po;
    int a = 1;
    int b = 1;
    String id;
    int period = 0;

    /**
     * Creates new form po
     */
    public dc_incoming() {
        initComponents();
        openDB();
        tampil_table();
        ckbox();

    }

    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
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
            rs = stm.executeQuery("select*from dc_incoming");
            while (rs.next()) {

                String[] data = {
                    rs.getString("doc_no"),
                    rs.getString("counter_party"),
                    rs.getString("doc_clasification"),
                    rs.getString("date_issue"),
                    rs.getString("date_received"),
                    rs.getString("description"),
                    rs.getString("yes_no"),
                    rs.getString("due_date"),
                    rs.getString("doc_no_cor"),
                    rs.getString("date_cor"),
                    rs.getString("method"),
                    rs.getString("remark"),
                    rs.getString("discipline"),
                    rs.getString("internal_clasification")};
                dataModel2.insertRow(0, data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal ta mpil");
        }
    }

    void set_kosong() {
        t_doc_no.setText("");
        t_doc_clasification.setText("");
        t_counter_party.setText("");
        t_date_received.setText("");
        t_description.setText("");
        t_method.setText("");
        t_due_date.setText("");
        t_doc_no_cor.setText("");
        t_due_date_cor.setText("");
        t_remark.setText("");
    }

    void reportx() {
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
                File templateFile = new File("C:\\Users\\USER\\OneDrive\\Documents\\incoming.xlsx");
                File selectedFile = excelFileChooser.getSelectedFile();
                String outputFilePath = selectedFile.getParent() + "\\" + selectedFile.getName() + ".xlsx";
                File outputFile = new File(outputFilePath);

                // Membaca data template ke dalam workbook
                FileInputStream templateFis = new FileInputStream(templateFile);
                workbook = new XSSFWorkbook(templateFis);
                templateFis.close();

                // Membuat sheet baru di workbook
                XSSFSheet sheetCopy = workbook.getSheet("Incoming");
               
             
                

                int row1 = 5;
                for (int i = 0; i < dataModelp.getRowCount(); i++) {

                    XSSFRow excelrow = sheetCopy.getRow(row1);
                    row1 = row1 + 1;
                    int col = 1;
                    for (int j = 0; j < dataModelp.getColumnCount(); j++) {
                        XSSFCell excelcell = excelrow.getCell(col);
                        if (excelcell == null) {
                            excelcell = excelrow.createCell(col);
                        }
                        col = col + 1;
                        
                        if (col == 13){
                        col = col + 1;
                        } else if (col == 15){
                        col = col + 1;
                        }
                        
                        excelcell.setCellValue(dataModelp.getValueAt(i, j).toString());
                    }
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
    
    private void searchTable(String searchValue) {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    jTable1.setRowSorter(sorter);
    
    RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchValue);
    sorter.setRowFilter(rowFilter);
}

    void tampil_table_date(){
     DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();
        int rowCount1 = dataModel2.getRowCount();

        for (int i = rowCount1 - 1; i >= 0; i--) {
            dataModel2.removeRow(i);
        }

        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from dc_incoming where date_issue BETWEEN '" + t_date_start.getText() + "' AND '" + t_date_end.getText() + "'");
            while (rs.next()) {

                String[] data = {
                    rs.getString("doc_no"),
                    rs.getString("counter_party"),
                    rs.getString("doc_clasification"),
                    rs.getString("date_issue"),
                    rs.getString("date_received"),
                    rs.getString("description"),
                    rs.getString("yes_no"),
                    rs.getString("due_date"),
                    rs.getString("doc_no_cor"),
                    rs.getString("date_cor"),
                    rs.getString("method"),
                    rs.getString("remark"),
                    rs.getString("discipline"),
                    rs.getString("internal_clasification")};
                dataModel2.insertRow(0, data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal ta mpil");
        }
    }
    
    void ckbox() {
        jCheckBox1.addActionListener(e -> {
            if (jCheckBox1.isSelected()) {
                tampil_table_date();
                period = 1;
               

            } else {
                tampil_table();
                period = 0;
               

            }
        });
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
        dateChooser5 = new com.raven.datechooser.DateChooser();
        dateChooser6 = new com.raven.datechooser.DateChooser();
        dateChooser7 = new com.raven.datechooser.DateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t_doc_clasification = new CustomResource.CustomTextfield();
        t_date_end = new CustomResource.CustomTextfield();
        t_doc_no = new CustomResource.CustomFormatField();
        t_description = new CustomResource.CustomTextfield();
        t_search = new CustomResource.CustomTextfield();
        jPanel2 = new javax.swing.JPanel();
        t_due_date = new CustomResource.CustomTextfield();
        jLabel4 = new javax.swing.JLabel();
        c_yes_no = new CustomResource.ComboBoxSuggestion();
        jPanel3 = new javax.swing.JPanel();
        t_due_date_cor = new CustomResource.CustomTextfield();
        jLabel5 = new javax.swing.JLabel();
        t_doc_no_cor = new CustomResource.CustomTextfield();
        t_counter_party = new CustomResource.CustomTextfield();
        jScrollPane25 = new javax.swing.JScrollPane();
        t_remark = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        t_date_received = new CustomResource.CustomTextfield();
        t_date_start = new CustomResource.CustomTextfield();
        jLabel6 = new javax.swing.JLabel();
        c_clasification = new CustomResource.ComboBoxSuggestion();
        c_discipline = new CustomResource.ComboBoxSuggestion();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        t_date_issue = new CustomResource.CustomTextfield();
        t_method = new CustomResource.CustomTextfield();

        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(t_due_date);

        dateChooser3.setDateFormat("yyyy-MM-dd");
        dateChooser3.setTextRefernce(t_date_end);

        dateChooser4.setDateFormat("yyyy-MM-dd");
        dateChooser4.setTextRefernce(t_due_date_cor);

        dateChooser5.setDateFormat("yyyy-MM-dd");
        dateChooser5.setTextRefernce(t_date_received);

        dateChooser6.setDateFormat("yyyy-MM-dd");
        dateChooser6.setTextRefernce(t_date_start);

        dateChooser7.setDateFormat("yyyy-MM-dd");
        dateChooser7.setTextRefernce(t_date_issue);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doc No", "Counter Party", "Doc Clasification", "Date Issue", "Date Received", "Description", "Counter Party Reply", "Counter Party Due Date", "ACV's Reply Corresponden", "Corresponden Date", "Method", "Remark", "Discipline Distributed", "Internal Clasification"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, 660, 140));

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LIST DOCUMENT INCOMING");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 650, 20));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INCOMING DOCUMENT");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 650, 20));

        t_doc_clasification.setLabelText("Doc. Clasification");
        jPanel1.add(t_doc_clasification, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 257, -1));

        t_date_end.setLabelText("End Date");
        t_date_end.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_date_endKeyTyped(evt);
            }
        });
        jPanel1.add(t_date_end, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 600, 130, -1));

        try {
            t_doc_no.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("'A'CV/HHHH-HH-HHHH-HHHH")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        t_doc_no.setLabelText("Doc No");
        t_doc_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_doc_noKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_doc_noKeyTyped(evt);
            }
        });
        jPanel1.add(t_doc_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 200, -1));

        t_description.setLabelText("Description");
        jPanel1.add(t_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 257, -1));

        t_search.setLabelText("Search");
        t_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_searchKeyReleased(evt);
            }
        });
        jPanel1.add(t_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, 257, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_due_date.setLabelText("Due Date");
        jPanel2.add(t_due_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Reply by Counter Party");
        jLabel4.setOpaque(true);
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 20));

        c_yes_no.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));
        c_yes_no.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        c_yes_no.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                c_yes_noPopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel2.add(c_yes_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 230, 70));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_due_date_cor.setLabelText("Date");
        jPanel3.add(t_due_date_cor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ACV's Reply Corresponden");
        jLabel5.setOpaque(true);
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 20));

        t_doc_no_cor.setLabelText("Doc No");
        t_doc_no_cor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_doc_no_corKeyTyped(evt);
            }
        });
        jPanel3.add(t_doc_no_cor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 230, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 250, 120));

        t_counter_party.setLabelText("Issued By (Counter Party)");
        t_counter_party.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_counter_partyKeyTyped(evt);
            }
        });
        jPanel1.add(t_counter_party, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 257, -1));

        t_remark.setColumns(20);
        t_remark.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        t_remark.setRows(5);
        t_remark.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                t_remarkMouseWheelMoved(evt);
            }
        });
        jScrollPane25.setViewportView(t_remark);

        jPanel1.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 200, 80));

        jLabel1.setText("Short By Date Range");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 560, -1, -1));

        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 490, 110, 30));

        t_date_received.setLabelText("Date Received");
        t_date_received.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_date_receivedKeyTyped(evt);
            }
        });
        jPanel1.add(t_date_received, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 160, -1));

        t_date_start.setLabelText("Start Date");
        t_date_start.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_date_startKeyTyped(evt);
            }
        });
        jPanel1.add(t_date_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 600, 120, -1));

        jLabel6.setText("Internal Classification");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, -1, -1));

        c_clasification.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Invoice", "Contract", "Proposal", "Other Info" }));
        c_clasification.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        c_clasification.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                c_clasificationPopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel1.add(c_clasification, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 160, 30));

        c_discipline.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MGT", "MKTG", "ADMIN", "COM-IT", "B-CNTR", "ENG", "PROC", "CONST", "MAT'L", "W/H", "QC", "HSE" }));
        c_discipline.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        c_discipline.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                c_disciplinePopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel1.add(c_discipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 160, 30));

        jLabel7.setText("Remark");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, -1, -1));

        jLabel8.setText("Discipline Distributed");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, -1, -1));

        jButton2.setText("Download Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 810, 120, 30));

        jCheckBox1.setText("Display By Date Range");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 620, -1, -1));

        t_date_issue.setLabelText("Date Issue");
        t_date_issue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_date_issueKeyTyped(evt);
            }
        });
        jPanel1.add(t_date_issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 160, -1));

        t_method.setLabelText("Method");
        t_method.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_methodKeyTyped(evt);
            }
        });
        jPanel1.add(t_method, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 200, -1));

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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void t_doc_no_corKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_doc_no_corKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_doc_no_corKeyTyped

    private void t_date_endKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_date_endKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_date_endKeyTyped

    private void t_doc_noKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_doc_noKeyPressed

    }//GEN-LAST:event_t_doc_noKeyPressed

    private void t_doc_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_doc_noKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_doc_noKeyTyped

    private void c_clasificationPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_c_clasificationPopupMenuWillBecomeVisible
     
    }//GEN-LAST:event_c_clasificationPopupMenuWillBecomeVisible

    private void t_counter_partyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_counter_partyKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_counter_partyKeyTyped

    private void t_remarkMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_t_remarkMouseWheelMoved

    }//GEN-LAST:event_t_remarkMouseWheelMoved

    private void t_date_receivedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_date_receivedKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_date_receivedKeyTyped

    private void t_date_startKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_date_startKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_date_startKeyTyped

    private void c_yes_noPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_c_yes_noPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_c_yes_noPopupMenuWillBecomeVisible

    private void c_disciplinePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_c_disciplinePopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_c_disciplinePopupMenuWillBecomeVisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            stm = koneksi.createStatement();
            String sql = "insert into dc_incoming(doc_no,doc_clasification,counter_party,date_issue,description,date_received,yes_no,due_date,doc_no_cor,date_cor,method,remark,discipline,internal_clasification) values('" + t_doc_no.getText() + "'"
                    + ",'" + t_doc_clasification.getText() + "'"
                    + ",'" + t_counter_party.getText() + "'"
                    + ",'" + t_date_issue.getText() + "'"
                    + ",'" + t_description.getText() + "'"
                    + ",'" + t_date_received.getText() + "'"
                    + ",'" + c_yes_no.getSelectedItem().toString() + "'"
                    + ",'" + t_due_date.getText() + "'"
                    + ",'" + t_doc_no_cor.getText() + "'"
                    + ",'" + t_due_date_cor.getText() + "'"
                    + ",'" + t_method.getText() + "'"
                    + ",'" + t_remark.getText() + "'"
                    + ",'" + c_discipline.getSelectedItem().toString() + "'"
                    + ",'" + c_clasification.getSelectedItem().toString() + "')";
            stm.executeUpdate(sql);
            stm.close();
            JOptionPane.showMessageDialog(null, "Data Saved");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }
        set_kosong();
        tampil_table();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        reportx();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void t_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_searchKeyReleased
String searchValue = t_search.getText();
        searchTable(searchValue);        // TODO add your handling code here:
    }//GEN-LAST:event_t_searchKeyReleased

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void t_date_issueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_date_issueKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_date_issueKeyTyped

    private void t_methodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_methodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_methodKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.ComboBoxSuggestion c_clasification;
    private CustomResource.ComboBoxSuggestion c_discipline;
    private CustomResource.ComboBoxSuggestion c_yes_no;
    private com.raven.datechooser.DateChooser dateChooser2;
    private com.raven.datechooser.DateChooser dateChooser3;
    private com.raven.datechooser.DateChooser dateChooser4;
    private com.raven.datechooser.DateChooser dateChooser5;
    private com.raven.datechooser.DateChooser dateChooser6;
    private com.raven.datechooser.DateChooser dateChooser7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JTable jTable1;
    private CustomResource.CustomTextfield t_counter_party;
    private CustomResource.CustomTextfield t_date_end;
    private CustomResource.CustomTextfield t_date_issue;
    private CustomResource.CustomTextfield t_date_received;
    private CustomResource.CustomTextfield t_date_start;
    private CustomResource.CustomTextfield t_description;
    private CustomResource.CustomTextfield t_doc_clasification;
    private CustomResource.CustomFormatField t_doc_no;
    private CustomResource.CustomTextfield t_doc_no_cor;
    private CustomResource.CustomTextfield t_due_date;
    private CustomResource.CustomTextfield t_due_date_cor;
    private CustomResource.CustomTextfield t_method;
    private javax.swing.JTextArea t_remark;
    private CustomResource.CustomTextfield t_search;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
