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
public class dc_form_transmittal extends MasterForm {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    int id_po;
    int a = 1;
    int b = 1;
    String id;
    int period = 0;
    int id3;

    /**
     * Creates new form po
     */
    public dc_form_transmittal() {
        initComponents();
        openDB();

    }

    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }

    void set_kosong() {
        t_transmittal_no.setText("");
        t_attn.setText("");
        t_copy.setText("");

        t_issued.setText("");
        t_contract.setText("");

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
                File templateFile = new File("C:\\Users\\USER\\OneDrive\\Documents\\form_transmittal.xlsx");
                File selectedFile = excelFileChooser.getSelectedFile();
                String outputFilePath = selectedFile.getParent() + "\\" + selectedFile.getName() + ".xlsx";
                File outputFile = new File(outputFilePath);

                // Membaca data template ke dalam workbook
                FileInputStream templateFis = new FileInputStream(templateFile);
                workbook = new XSSFWorkbook(templateFis);
                templateFis.close();

                // Membuat sheet baru di workbook
                XSSFSheet sheetCopy = workbook.getSheet("Form Transmittal");

                XSSFRow excelrow14 = sheetCopy.getRow(5);
                if (excelrow14 == null) {
                    excelrow14 = sheetCopy.createRow(5); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell14 = excelrow14.getCell(2);
                if (excelcell14 == null) {
                    excelcell14 = excelrow14.createCell(2); // Buat sel baru jika belum ada
                }
                excelcell14.setCellValue(t_project_tittle.getText());

                XSSFRow excelrow15 = sheetCopy.getRow(6);
                if (excelrow15 == null) {
                    excelrow15 = sheetCopy.createRow(6); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell15 = excelrow15.getCell(2);
                if (excelcell15 == null) {
                    excelcell15 = excelrow15.createCell(2); // Buat sel baru jika belum ada
                }
                excelcell15.setCellValue(t_contract_tile.getText());

                XSSFRow excelrow1 = sheetCopy.getRow(10);
                if (excelrow1 == null) {
                    excelrow1 = sheetCopy.createRow(10); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell1 = excelrow1.getCell(5);
                if (excelcell1 == null) {
                    excelcell1 = excelrow1.createCell(5); // Buat sel baru jika belum ada
                }
                excelcell1.setCellValue(t_to.getText());

                XSSFRow excelrow2 = sheetCopy.getRow(12);
                if (excelrow2 == null) {
                    excelrow2 = sheetCopy.createRow(12); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell2 = excelrow2.getCell(5);
                if (excelcell2 == null) {
                    excelcell2 = excelrow2.createCell(5); // Buat sel baru jika belum ada
                }
                excelcell2.setCellValue(t_attn.getText());

                XSSFRow excelrow3 = sheetCopy.getRow(13);
                if (excelrow3 == null) {
                    excelrow3 = sheetCopy.createRow(13); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell3 = excelrow3.getCell(5);
                if (excelcell3 == null) {
                    excelcell3 = excelrow3.createCell(5); // Buat sel baru jika belum ada
                }
                excelcell3.setCellValue(t_cc.getText());

                XSSFRow excelrow4 = sheetCopy.getRow(15);
                if (excelrow4 == null) {
                    excelrow4 = sheetCopy.createRow(15); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell4 = excelrow4.getCell(5);
                if (excelcell4 == null) {
                    excelcell4 = excelrow4.createCell(5); // Buat sel baru jika belum ada
                }
                excelcell4.setCellValue(t_issued.getText());

                XSSFRow excelrow5 = sheetCopy.getRow(10);
                if (excelrow5 == null) {
                    excelrow5 = sheetCopy.createRow(10); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell5 = excelrow5.getCell(17);
                if (excelcell5 == null) {
                    excelcell5 = excelrow5.createCell(17); // Buat sel baru jika belum ada
                }
                excelcell5.setCellValue(t_date_issue.getText());

                XSSFRow excelrow6 = sheetCopy.getRow(11);
                if (excelrow6 == null) {
                    excelrow6 = sheetCopy.createRow(11); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell6 = excelrow6.getCell(17);
                if (excelcell6 == null) {
                    excelcell6 = excelrow6.createCell(17); // Buat sel baru jika belum ada
                }
                excelcell6.setCellValue(t_transmittal_no.getText());

                XSSFRow excelrow7 = sheetCopy.getRow(12);
                if (excelrow7 == null) {
                    excelrow7 = sheetCopy.createRow(12); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell7 = excelrow7.getCell(17);
                if (excelcell7 == null) {
                    excelcell7 = excelrow7.createCell(17); // Buat sel baru jika belum ada
                }
                excelcell7.setCellValue(t_project_no.getText());

                XSSFRow excelrow8 = sheetCopy.getRow(13);
                if (excelrow8 == null) {
                    excelrow8 = sheetCopy.createRow(13); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell8 = excelrow8.getCell(17);
                if (excelcell8 == null) {
                    excelcell8 = excelrow8.createCell(17); // Buat sel baru jika belum ada
                }
                excelcell8.setCellValue(t_contract.getText());

                int row;
                int col = 0;

                if (c_for.getSelectedItem().toString().equals("ACHIVON")) {
                    row = 1;
                } else {
                    row = 3;
                }

                XSSFRow excelrow9 = sheetCopy.getRow(row);
                if (excelrow9 == null) {
                    excelrow9 = sheetCopy.createRow(row); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell9 = excelrow9.getCell(16);
                if (excelcell9 == null) {
                    excelcell9 = excelrow9.createCell(16); // Buat sel baru jika belum ada
                }
                excelcell9.setCellValue("P");

                if (c_media.getSelectedItem().toString().equals("HARD COPY")) {
                    row = 18;
                    col = 8;
                } else if (c_media.getSelectedItem().toString().equals("SOFT COPY")) {
                    row = 18;
                    col = 14;
                } else {
                    row = 18;
                    col = 18;
                }

                XSSFRow excelrow10 = sheetCopy.getRow(row);
                if (excelrow10 == null) {
                    excelrow10 = sheetCopy.createRow(row); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell10 = excelrow10.getCell(col);
                if (excelcell10 == null) {
                    excelcell10 = excelrow10.createCell(col); // Buat sel baru jika belum ada
                }
                excelcell10.setCellValue("P");

                if (c_following.getSelectedItem().toString().equals("PROPOSAL")) {
                    row = 20;
                    col = 8;
                } else if (c_following.getSelectedItem().toString().equals("PLAN")) {
                    row = 22;
                    col = 8;
                } else if (c_following.getSelectedItem().toString().equals("OTHER")) {
                    row = 24;
                    col = 8;
                } else if (c_following.getSelectedItem().toString().equals("CLARIFICATION")) {
                    row = 20;
                    col = 14;
                } else if (c_following.getSelectedItem().toString().equals("PROCEDURE")) {
                    row = 22;
                    col = 14;
                } else if (c_following.getSelectedItem().toString().equals("LETTER")) {
                    row = 20;
                    col = 18;
                } else if (c_following.getSelectedItem().toString().equals("REPORT")) {
                    row = 22;
                    col = 18;
                }

                XSSFRow excelrow11 = sheetCopy.getRow(row);
                if (excelrow11 == null) {
                    excelrow11 = sheetCopy.createRow(row); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell11 = excelrow11.getCell(col);
                if (excelcell11 == null) {
                    excelcell11 = excelrow11.createCell(col); // Buat sel baru jika belum ada
                }
                excelcell11.setCellValue("P");

                if (c_transmittal_for.getSelectedItem().toString().equals("RECOMENDATION")) {
                    row = 26;
                    col = 8;
                } else if (c_transmittal_for.getSelectedItem().toString().equals("RECORD")) {
                    row = 28;
                    col = 8;
                } else if (c_transmittal_for.getSelectedItem().toString().equals("OTHER")) {
                    row = 30;
                    col = 8;
                } else if (c_transmittal_for.getSelectedItem().toString().equals("INFORMATION")) {
                    row = 26;
                    col = 14;
                } else if (c_transmittal_for.getSelectedItem().toString().equals("APPROVAL")) {
                    row = 28;
                    col = 14;
                } else if (c_transmittal_for.getSelectedItem().toString().equals("REVIEW")) {
                    row = 26;
                    col = 18;
                } else if (c_transmittal_for.getSelectedItem().toString().equals("CONSTRUCTION")) {
                    row = 28;
                    col = 18;
                }

                XSSFRow excelrow12 = sheetCopy.getRow(row);
                if (excelrow12 == null) {
                    excelrow12 = sheetCopy.createRow(row); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell12 = excelrow12.getCell(col);
                if (excelcell12 == null) {
                    excelcell12 = excelrow12.createCell(col); // Buat sel baru jika belum ada
                }
                excelcell12.setCellValue("P");

                if (c_sub.getSelectedItem().toString().equals("PRELIMINARY")) {
                    row = 32;
                    col = 8;
                } else if (c_sub.getSelectedItem().toString().equals("REVISION")) {
                    row = 32;
                    col = 14;
                } else {
                    row = 32;
                    col = 18;
                }

                XSSFRow excelrow13 = sheetCopy.getRow(row);
                if (excelrow13 == null) {
                    excelrow13 = sheetCopy.createRow(row); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell13 = excelrow13.getCell(col);
                if (excelcell13 == null) {
                    excelcell13 = excelrow13.createCell(col); // Buat sel baru jika belum ada
                }
                excelcell13.setCellValue("P");

                XSSFSheet sheet = workbook.getSheet("Transmittal");

                int row1 = 4;
                for (int i = 0; i < dataModelp.getRowCount(); i++) {

                    XSSFRow excelrow = sheet.getRow(row1);
                    row1 = row1 + 1;
                    int col1 = 1;
                    for (int j = 0; j < dataModelp.getColumnCount(); j++) {
                        XSSFCell excelcell = excelrow.getCell(col1);
                        if (excelcell == null) {
                            excelcell = excelrow.createCell(col1);
                        }
                        col1 = col1 + 1;

                        if (col1 == 13) {
                            col1 = col1 + 1;
                        } else if (col1 == 15) {
                            col1 = col1 + 1;
                        }

                        excelcell.setCellValue(dataModelp.getValueAt(i, j).toString());
                    }
                }

                int row2 = 38;
                for (int i = 0; i < dataModelp.getRowCount(); i++) {

                    XSSFRow excelrow = sheetCopy.getRow(row2);
                    row2 = row2 + 1;
                    int col1 = 4;
                    for (int j = 0; j < dataModelp.getColumnCount(); j++) {
                        XSSFCell excelcell = excelrow.getCell(col1);
                        if (excelcell == null) {
                            excelcell = excelrow.createCell(col1);
                        }
                        col1 = col1 + 1;

                        if (col1 == 5) {
                            col1 = col1 + 2;
                        } else if (col1 == 8) {
                            col1 = col1 + 1;
                        } else if (col1 == 10) {
                            col1 = col1 + 1;
                        } else if (col1 == 12) {
                            col1 = col1 + 1;
                        } else if (col1 == 15) {
                            col1 = col1 + 1;
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
        t_attn = new CustomResource.CustomTextfield();
        t_transmittal_no = new CustomResource.CustomFormatField();
        t_issued = new CustomResource.CustomTextfield();
        t_copy = new CustomResource.CustomTextfield();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        c_media = new CustomResource.ComboBoxSuggestion();
        c_for = new CustomResource.ComboBoxSuggestion();
        jLabel8 = new javax.swing.JLabel();
        t_date_issue = new CustomResource.CustomTextfield();
        t_contract = new CustomResource.CustomTextfield();
        t_cc = new CustomResource.CustomTextfield();
        t_project_no = new CustomResource.CustomTextfield();
        jLabel7 = new javax.swing.JLabel();
        c_following = new CustomResource.ComboBoxSuggestion();
        jLabel9 = new javax.swing.JLabel();
        c_transmittal_for = new CustomResource.ComboBoxSuggestion();
        jLabel10 = new javax.swing.JLabel();
        c_sub = new CustomResource.ComboBoxSuggestion();
        t_to = new CustomResource.CustomTextfield();
        t_title = new CustomResource.CustomTextfield();
        t_size = new CustomResource.CustomTextfield();
        t_rev = new CustomResource.CustomTextfield();
        t_doc_no = new CustomResource.CustomTextfield();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        t_project_tittle = new CustomResource.CustomTextfield();
        t_contract_tile = new CustomResource.CustomTextfield();

        dateChooser2.setDateFormat("yyyy-MM-dd");

        dateChooser3.setDateFormat("yyyy-MM-dd");

        dateChooser4.setDateFormat("yyyy-MM-dd");

        dateChooser5.setDateFormat("yyyy-MM-dd");

        dateChooser6.setDateFormat("yyyy-MM-dd");

        dateChooser7.setDateFormat("yyyy-MM-dd");
        dateChooser7.setTextRefernce(t_date_issue);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Document NO", "Size", "Rev", "Copy", "Title/Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 610, 660, 140));

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ATTACHMENT LIST");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 650, 20));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FORM TRANSMITTAL");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 650, 20));

        t_attn.setLabelText("ATTN");
        jPanel1.add(t_attn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 257, -1));

        try {
            t_transmittal_no.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("'A'CV/HHH-'H'-T-HHHH")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        t_transmittal_no.setLabelText("Transmittal No");
        t_transmittal_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_transmittal_noKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_transmittal_noKeyTyped(evt);
            }
        });
        jPanel1.add(t_transmittal_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 200, -1));

        t_issued.setLabelText("ISSUED FROM");
        jPanel1.add(t_issued, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 257, -1));

        t_copy.setLabelText("Copy");
        t_copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_copyActionPerformed(evt);
            }
        });
        t_copy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_copyKeyTyped(evt);
            }
        });
        jPanel1.add(t_copy, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, 50, -1));

        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 810, 110, 30));

        jLabel6.setText("Media Type");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        c_media.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HARD COPY", "SOFT COPY", "OTHERS" }));
        c_media.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        c_media.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                c_mediaPopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel1.add(c_media, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 160, 30));

        c_for.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACHIVON", "CLIENT" }));
        c_for.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        c_for.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                c_forPopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel1.add(c_for, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 160, 30));

        jLabel8.setText("FOR");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, -1, -1));

        t_date_issue.setLabelText("Date");
        t_date_issue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_date_issueKeyTyped(evt);
            }
        });
        jPanel1.add(t_date_issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 160, -1));

        t_contract.setLabelText("Contract No");
        t_contract.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_contractKeyTyped(evt);
            }
        });
        jPanel1.add(t_contract, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 200, -1));

        t_cc.setLabelText("CC");
        jPanel1.add(t_cc, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 257, -1));

        t_project_no.setLabelText("Project No");
        t_project_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_project_noKeyTyped(evt);
            }
        });
        jPanel1.add(t_project_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 200, -1));

        jLabel7.setText("The Followong");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, -1, -1));

        c_following.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PROPOSAL", "CLARIFICATION", "LETTER", "PLAN", "PROCEDURE", "REPORT", "OTHERS" }));
        c_following.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        c_following.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                c_followingPopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel1.add(c_following, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 160, 30));

        jLabel9.setText("Transmitted For");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, -1, -1));

        c_transmittal_for.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RECOMENDATION", "INFORMATION", "REVIEW", "RECORD", "APPROVAL", "CONSTRUCTION", "OTHERS" }));
        c_transmittal_for.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        c_transmittal_for.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                c_transmittal_forPopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel1.add(c_transmittal_for, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 160, 30));

        jLabel10.setText("Submitted as");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, -1, -1));

        c_sub.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PRELIMINARY", "REVISION", "FINAL" }));
        c_sub.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        c_sub.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                c_subPopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel1.add(c_sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, 160, 30));

        t_to.setLabelText("TO");
        t_to.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_toActionPerformed(evt);
            }
        });
        t_to.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_toKeyTyped(evt);
            }
        });
        jPanel1.add(t_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 257, -1));

        t_title.setLabelText("Title/Description");
        t_title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_titleActionPerformed(evt);
            }
        });
        t_title.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_titleKeyTyped(evt);
            }
        });
        jPanel1.add(t_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 257, -1));

        t_size.setLabelText("Size");
        t_size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_sizeActionPerformed(evt);
            }
        });
        t_size.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_sizeKeyTyped(evt);
            }
        });
        jPanel1.add(t_size, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 50, -1));

        t_rev.setLabelText("Rev");
        t_rev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_revActionPerformed(evt);
            }
        });
        t_rev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_revKeyTyped(evt);
            }
        });
        jPanel1.add(t_rev, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, 50, -1));

        t_doc_no.setLabelText("NO Document");
        t_doc_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_doc_noActionPerformed(evt);
            }
        });
        t_doc_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_doc_noKeyTyped(evt);
            }
        });
        jPanel1.add(t_doc_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, 257, -1));

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 580, -1, -1));

        jButton4.setText("Delete Row");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 750, -1, -1));

        t_project_tittle.setLabelText("Project Tittle");
        t_project_tittle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_project_tittleKeyTyped(evt);
            }
        });
        jPanel1.add(t_project_tittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 200, -1));

        t_contract_tile.setLabelText("Contract Tile");
        t_contract_tile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_contract_tileKeyTyped(evt);
            }
        });
        jPanel1.add(t_contract_tile, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 200, -1));

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

    private void t_transmittal_noKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_transmittal_noKeyPressed

    }//GEN-LAST:event_t_transmittal_noKeyPressed

    private void t_transmittal_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_transmittal_noKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_transmittal_noKeyTyped

    private void c_mediaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_c_mediaPopupMenuWillBecomeVisible

    }//GEN-LAST:event_c_mediaPopupMenuWillBecomeVisible

    private void t_copyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_copyKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_copyKeyTyped

    private void c_forPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_c_forPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_c_forPopupMenuWillBecomeVisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String sql1 = "select max(id) from dc_transmittal";
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery(sql1);
            while (rs.next()) {
                int a = rs.getInt(1);
                id3 = a + 1;

            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }

        try {

            stm = koneksi.createStatement();
            String sql = "insert into dc_transmittal(id,t_to,attn,cc,issued,date,transmittal_no,project_no,contract_no,t_for,media,following,transmitted_for,submitted,project_tittle,contract_tile) values('" + id3 + "'"
                    + ",'" + t_to.getText() + "'"
                    + ",'" + t_attn.getText() + "'"
                    + ",'" + t_cc.getText() + "'"
                    + ",'" + t_issued.getText() + "'"
                    + ",'" + t_date_issue.getText() + "'"
                    + ",'" + t_transmittal_no.getText() + "'"
                    + ",'" + t_project_no.getText() + "'"
                    + ",'" + t_contract.getText() + "'"
                    + ",'" + c_for.getSelectedItem().toString() + "'"
                    + ",'" + c_media.getSelectedItem().toString() + "'"
                    + ",'" + c_following.getSelectedItem().toString() + "'"
                    + ",'" + c_transmittal_for.getSelectedItem().toString() + "'"
                    + ",'" + c_sub.getSelectedItem().toString() + "'"
                    + ",'" + t_project_tittle.getText() + "'"
                    + ",'" + t_contract_tile.getText() + "')";
            stm.executeUpdate(sql);
            stm.close();
            JOptionPane.showMessageDialog(null, "Data Saved");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }
        int jtabelrows = jTable1.getRowCount();
        for (int i = 0; i <= jtabelrows - 1; i++) {
            DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();

            String mr_id = (String) model1.getValueAt(i, 0);
            String mr_id1 = (String) model1.getValueAt(i, 1);
            String mr_id2 = (String) model1.getValueAt(i, 2);
            String mr_id3 = (String) model1.getValueAt(i, 3);
            String mr_id4 = (String) model1.getValueAt(i, 4);

            try {
                stm = koneksi.createStatement();
                String sql = "insert into dc_transmittal_atc (doc_no,size,rev,copy,tittle,id_transmittal) values('" + mr_id + "'"
                        + ",'" + mr_id1 + "'"
                        + ",'" + mr_id2 + "'"
                        + ",'" + mr_id3 + "'"
                        + ",'" + mr_id4 + "'"
                        + ",'" + id3 + "')";
                stm.executeUpdate(sql);
                stm.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
            }

        }

        int response = JOptionPane.showOptionDialog(null, "save as excel file ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (response == JOptionPane.YES_OPTION) {
            reportx();
        } else if (response == JOptionPane.NO_OPTION) {

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void t_date_issueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_date_issueKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_date_issueKeyTyped

    private void t_contractKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_contractKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_contractKeyTyped

    private void t_project_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_project_noKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_project_noKeyTyped

    private void c_followingPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_c_followingPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_c_followingPopupMenuWillBecomeVisible

    private void c_transmittal_forPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_c_transmittal_forPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_c_transmittal_forPopupMenuWillBecomeVisible

    private void c_subPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_c_subPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_c_subPopupMenuWillBecomeVisible

    private void t_copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_copyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_copyActionPerformed

    private void t_toActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_toActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_toActionPerformed

    private void t_toKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_toKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_toKeyTyped

    private void t_titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_titleActionPerformed

    private void t_titleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_titleKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_titleKeyTyped

    private void t_sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_sizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_sizeActionPerformed

    private void t_sizeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_sizeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_sizeKeyTyped

    private void t_revActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_revActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_revActionPerformed

    private void t_revKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_revKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_revKeyTyped

    private void t_doc_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_doc_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_doc_noActionPerformed

    private void t_doc_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_doc_noKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_doc_noKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();

        String[] data = {
            t_doc_no.getText(),
            t_size.getText(),
            t_rev.getText(),
            t_copy.getText(),
            t_title.getText()};
        dataModel2.insertRow(0, data);

        // TOD add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        if (selectedRowIndex >= 0) {
            model.removeRow(selectedRowIndex);
        } else {
            // Tidak ada baris yang dipilih, berikan pesan atau tindakan lain sesuai kebutuhan.
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void t_project_tittleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_project_tittleKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_project_tittleKeyTyped

    private void t_contract_tileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_contract_tileKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_contract_tileKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.ComboBoxSuggestion c_following;
    private CustomResource.ComboBoxSuggestion c_for;
    private CustomResource.ComboBoxSuggestion c_media;
    private CustomResource.ComboBoxSuggestion c_sub;
    private CustomResource.ComboBoxSuggestion c_transmittal_for;
    private com.raven.datechooser.DateChooser dateChooser2;
    private com.raven.datechooser.DateChooser dateChooser3;
    private com.raven.datechooser.DateChooser dateChooser4;
    private com.raven.datechooser.DateChooser dateChooser5;
    private com.raven.datechooser.DateChooser dateChooser6;
    private com.raven.datechooser.DateChooser dateChooser7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private CustomResource.CustomTextfield t_attn;
    private CustomResource.CustomTextfield t_cc;
    private CustomResource.CustomTextfield t_contract;
    private CustomResource.CustomTextfield t_contract_tile;
    private CustomResource.CustomTextfield t_copy;
    private CustomResource.CustomTextfield t_date_issue;
    private CustomResource.CustomTextfield t_doc_no;
    private CustomResource.CustomTextfield t_issued;
    private CustomResource.CustomTextfield t_project_no;
    private CustomResource.CustomTextfield t_project_tittle;
    private CustomResource.CustomTextfield t_rev;
    private CustomResource.CustomTextfield t_size;
    private CustomResource.CustomTextfield t_title;
    private CustomResource.CustomTextfield t_to;
    private CustomResource.CustomFormatField t_transmittal_no;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
