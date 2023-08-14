/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ProcurementSystem;

import CustomResource.koneksi;
import Main.MasterForm;
import static Main.main.bodyPanel;
import java.awt.Font;
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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author USER
 */
public class po_sq_view extends MasterForm {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    int id_po;
    long a = 1;
    long b = 1;
    String id_rfq;

    /**
     * Creates new form po
     */
    public po_sq_view() {
        initComponents();
        openDB();
        tampil_form();
        tampil_table();
        tampil_rfq();

        System.out.println(CustomResource.SessionAny.get_id_sq());

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
//            rs = stm.executeQuery("SELECT * FROM po_sq INNER JOIN po_rfq_items on po_sq.rfq_id = po_rfq_items.rfq_id where  po_sq.id = '" + CustomResource.SessionAny.get_id_sq() + "'");
            rs = stm.executeQuery("SELECT * FROM po_sq where  po_sq.id = '" + CustomResource.SessionAny.get_id_sq() + "'");
            while (rs.next()) {

                double amount = Double.parseDouble(rs.getString("amount"));
                double disc = Double.parseDouble(rs.getString("disc"));
                double total1 = Double.parseDouble(rs.getString("total1"));
                double ppn = Double.parseDouble(rs.getString("ppn"));
                double total2 = Double.parseDouble(rs.getString("total2"));
                NumberFormat format = new DecimalFormat("#,###");
                String s_amount = format.format(amount);
                String s_disc = format.format(disc);
                String s_total1 = format.format(total1);
                String s_ppn = format.format(ppn);
                String s_total2 = format.format(total2);
                t_sq.setText("SQ-" + rs.getString("id"));
                t_date.setText(rs.getString("date"));
                t_date_rfq.setText(rs.getString("rfq_date"));
                t_date_estimate.setText(rs.getString("delivery_date"));
                t_payment.setText(rs.getString("payment"));
                t_amount.setText("Rp. " + s_amount);
                t_disc.setText("Rp. " + s_disc);
                t_total_1.setText("Rp. " + s_total1);
                t_total_2.setText("Rp. " + s_total2);
                t_ppn.setText("Rp. " + s_ppn);
                id_rfq = rs.getString("rfq_id");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }
    }

    void tampil_rfq() {
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("SELECT * FROM po_rfq INNER JOIN biz_partner on po_rfq.biz_id = biz_partner.biz_id where id = '" + id_rfq + "'");
            while (rs.next()) {
                t_from.setText(rs.getString("name"));
                t_email.setText(rs.getString("email"));
                t_contact.setText(rs.getString("no_hp"));
                t_address.setText(rs.getString("address") + " RT/RW " + rs.getString("rt") + "/" + rs.getString("rw") + ", " + rs.getString("city") + ", " + rs.getString("province") + " (" + rs.getString("postcode") + ")");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }

    }

    void tampil_table() {

        DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
        int rowCount1 = dataModel2.getRowCount();

        for (int i = rowCount1 - 1; i >= 0; i--) {
            dataModel2.removeRow(i);
        }
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from po_rfq_items INNER JOIN po_sq on po_rfq_items.rfq_id = po_sq.rfq_id INNER JOIN po_material_request on po_rfq_items.mr_id = po_material_request.id_material_request where po_sq.id = '" + CustomResource.SessionAny.get_id_sq() + "'");
            while (rs.next()) {

                double angka = Double.parseDouble(rs.getString("price"));
                double angka1 = Double.parseDouble(rs.getString("total"));

                NumberFormat format = new DecimalFormat("#,###");
                String hasil = format.format(angka);
                String hasil1 = format.format(angka1);

                String[] data = {
                    "MR-" + rs.getString("mr_id"),
                    rs.getString("material_name"),
                    rs.getString("po_material_request.qty"),
                    rs.getString("stock_needs"),
                    "Rp. " + hasil,
                    "Rp. " + hasil1};
                dataModel2.insertRow(0, data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal ta mpil");
        }
    }

    public void showForm(MasterForm form) {

        bodyPanel.removeAll();
        bodyPanel.add(form);
        bodyPanel.revalidate();
        bodyPanel.repaint();

    }

    void reportx() throws ParseException {
        DefaultTableModel dataModelp = (DefaultTableModel) jTable2.getModel();
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
                File templateFile = new File("C:\\Users\\USER\\OneDrive\\Documents\\Form_SQ.xlsx");
                File selectedFile = excelFileChooser.getSelectedFile();
                String outputFilePath = selectedFile.getParent() + "\\" + selectedFile.getName() + ".xlsx";
                File outputFile = new File(outputFilePath);

                // Membaca data template ke dalam workbook
                FileInputStream templateFis = new FileInputStream(templateFile);
                workbook = new XSSFWorkbook(templateFis);
                templateFis.close();

                // Membuat sheet baru di workbook
                XSSFSheet sheetCopy = workbook.getSheet("Sheet1");

                XSSFRow excelrow11 = sheetCopy.getRow(7);
                if (excelrow11 == null) {
                    excelrow11 = sheetCopy.createRow(7); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell11 = excelrow11.getCell(2);
                if (excelcell11 == null) {
                    excelcell11 = excelrow11.createCell(2); // Buat sel baru jika belum ada
                }
                excelcell11.setCellValue(t_from.getText());

                XSSFRow excelrow12 = sheetCopy.getRow(8);
                if (excelrow12 == null) {
                    excelrow12 = sheetCopy.createRow(8); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell12 = excelrow12.getCell(2);
                if (excelcell12 == null) {
                    excelcell12 = excelrow12.createCell(2); // Buat sel baru jika belum ada
                }
                excelcell12.setCellValue(t_email.getText());

                XSSFRow excelrow13 = sheetCopy.getRow(9);
                if (excelrow13 == null) {
                    excelrow13 = sheetCopy.createRow(9); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell13 = excelrow13.getCell(2);
                if (excelcell13 == null) {
                    excelcell13 = excelrow13.createCell(2); // Buat sel baru jika belum ada
                }
                excelcell13.setCellValue(t_contact.getText());

                XSSFRow excelrow14 = sheetCopy.getRow(10);
                if (excelrow14 == null) {
                    excelrow14 = sheetCopy.createRow(10); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell14 = excelrow14.getCell(2);
                if (excelcell14 == null) {
                    excelcell14 = excelrow14.createCell(2); // Buat sel baru jika belum ada
                }
                excelcell14.setCellValue(t_address.getText());

                String tgl;
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
                DateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy");

                Date date = inputFormat.parse(t_date_rfq.getText());
                tgl = outputFormat.format(date);

                XSSFRow excelrow15 = sheetCopy.getRow(7);
                if (excelrow15 == null) {
                    excelrow15 = sheetCopy.createRow(7); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell15 = excelrow15.getCell(7);
                if (excelcell15 == null) {
                    excelcell15 = excelrow15.createCell(7); // Buat sel baru jika belum ada
                }
                excelcell15.setCellValue(tgl);

                date = inputFormat.parse(t_date.getText());
                tgl = outputFormat.format(date);

                XSSFRow excelrow16 = sheetCopy.getRow(8);
                if (excelrow16 == null) {
                    excelrow16 = sheetCopy.createRow(8); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell16 = excelrow16.getCell(7);
                if (excelcell16 == null) {
                    excelcell16 = excelrow16.createCell(7); // Buat sel baru jika belum ada
                }
                excelcell16.setCellValue(tgl);

                date = inputFormat.parse(t_date_estimate.getText());
                tgl = outputFormat.format(date);

                XSSFRow excelrow17 = sheetCopy.getRow(9);
                if (excelrow17 == null) {
                    excelrow17 = sheetCopy.createRow(9); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell17 = excelrow17.getCell(7);
                if (excelcell17 == null) {
                    excelcell17 = excelrow17.createCell(7); // Buat sel baru jika belum ada
                }
                excelcell17.setCellValue(tgl);

                XSSFRow excelrow18 = sheetCopy.getRow(10);
                if (excelrow18 == null) {
                    excelrow18 = sheetCopy.createRow(10); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell18 = excelrow18.getCell(7);
                if (excelcell18 == null) {
                    excelcell18 = excelrow18.createCell(7); // Buat sel baru jika belum ada
                }
                excelcell18.setCellValue(t_payment.getText());

                CellStyle borderStyle = workbook.createCellStyle();
                borderStyle.setBorderTop(BorderStyle.THIN);
                borderStyle.setBorderBottom(BorderStyle.THIN);
                borderStyle.setBorderLeft(BorderStyle.THIN);
                borderStyle.setBorderRight(BorderStyle.THIN);

                int row1 = 15;
                for (int i = 0; i < dataModelp.getRowCount(); i++) {

                    XSSFRow excelrow = sheetCopy.getRow(row1);
                    XSSFCell excelcell25 = excelrow.getCell(0);
                    if (excelcell25 == null) {
                        excelcell25 = excelrow.createCell(0);
                    }
                    excelcell25.setCellValue(row1 - 14);
                    row1 = row1 + 1;
                    int col = 1;
                    for (int j = 0; j < dataModelp.getColumnCount() + 2; j++) {
                        XSSFCell excelcell = excelrow.getCell(col);
                        if (excelcell == null) {
                            excelcell = excelrow.createCell(col);
                        }
                        col = col + 1;

                        String mr_id = (String) dataModelp.getValueAt(i, 1);

                        String[] parts = mr_id.split("-");

                        String id = parts[0];
                        String id1 = parts[1];
                        String id2 = mr_id.substring(mr_id.indexOf("-") + 1).trim();

                        if (col == 2) {
                            excelcell.setCellValue(id);
                        } else if (col == 3) {
                            excelcell.setCellValue(id1);
                        } else if (col == 4) {
                            excelcell.setCellValue(id2);
                        } else if (col == 5) {
                            excelcell.setCellValue(dataModelp.getValueAt(i, 2).toString());
                        } else if (col == 6) {
                            excelcell.setCellValue(dataModelp.getValueAt(i, 3).toString());
                        } else if (col == 7) {
                            excelcell.setCellValue(dataModelp.getValueAt(i, 4).toString());
                        } else if (col == 8) {
                            excelcell.setCellValue(dataModelp.getValueAt(i, 5).toString());
                        }

                    }

                    for (int j = 0; j < 9; j++) {
                        XSSFCell excelcell24 = excelrow.getCell(j);
                        if (excelcell24 == null) {
                            excelcell24 = excelrow.createCell(j);
                        }
                        excelcell24.setCellStyle(borderStyle);

                    }
                }

                XSSFRow excelrow19 = sheetCopy.getRow(row1);
                if (excelrow19 == null) {
                    excelrow19 = sheetCopy.createRow(row1); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell19 = excelrow19.getCell(7);
                if (excelcell19 == null) {
                    excelcell19 = excelrow19.createCell(7); // Buat sel baru jika belum ada
                }
                excelcell19.setCellValue(t_amount.getText());

                XSSFCell excelcell25 = excelrow19.getCell(6);
                if (excelcell25 == null) {
                    excelcell25 = excelrow19.createCell(6); // Buat sel baru jika belum ada
                }

                CellStyle boldStyle = excelcell25.getSheet().getWorkbook().createCellStyle();
                XSSFFont boldFont = excelcell25.getSheet().getWorkbook().createFont();
                boldFont.setBold(true);
                boldStyle.setFont(boldFont);
                excelcell25.setCellValue("Amount.");
                excelcell25.setCellStyle(boldStyle);

                XSSFRow excelrow20 = sheetCopy.getRow(row1 + 1);
                if (excelrow20 == null) {
                    excelrow20 = sheetCopy.createRow(row1 + 1); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell20 = excelrow20.getCell(7);
                if (excelcell20 == null) {
                    excelcell20 = excelrow20.createCell(7); // Buat sel baru jika belum ada
                }
                excelcell20.setCellValue(t_disc.getText());

                XSSFCell excelcell26 = excelrow20.getCell(6);
                if (excelcell26 == null) {
                    excelcell26 = excelrow20.createCell(6); // Buat sel baru jika belum ada
                }
                excelcell26.setCellValue("Disc.");
                 excelcell26.setCellStyle(boldStyle);

                XSSFRow excelrow21 = sheetCopy.getRow(row1 + 2);
                if (excelrow21 == null) {
                    excelrow21 = sheetCopy.createRow(row1 + 2); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell21 = excelrow21.getCell(7);
                if (excelcell21 == null) {
                    excelcell21 = excelrow21.createCell(7); // Buat sel baru jika belum ada
                }
                excelcell21.setCellValue(t_total_1.getText());

                XSSFCell excelcell27 = excelrow21.getCell(6);
                if (excelcell27 == null) {
                    excelcell27 = excelrow21.createCell(6); // Buat sel baru jika belum ada
                }
                excelcell27.setCellValue("Total1.");
                 excelcell27.setCellStyle(boldStyle);

                XSSFRow excelrow22 = sheetCopy.getRow(row1 + 3);
                if (excelrow22 == null) {
                    excelrow22 = sheetCopy.createRow(row1 + 3); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell22 = excelrow22.getCell(7);
                if (excelcell22 == null) {
                    excelcell22 = excelrow22.createCell(7); // Buat sel baru jika belum ada
                }
                excelcell22.setCellValue(t_ppn.getText());

                XSSFCell excelcell28 = excelrow22.getCell(6);
                if (excelcell28 == null) {
                    excelcell28 = excelrow22.createCell(6); // Buat sel baru jika belum ada
                }
                excelcell28.setCellValue("PPN.");
                 excelcell28.setCellStyle(boldStyle);

                XSSFRow excelrow23 = sheetCopy.getRow(row1 + 4);
                if (excelrow23 == null) {
                    excelrow23 = sheetCopy.createRow(row1 + 4); // Buat baris baru jika belum ada
                }
                XSSFCell excelcell23 = excelrow23.getCell(7);
                if (excelcell23 == null) {
                    excelcell23 = excelrow23.createCell(7); // Buat sel baru jika belum ada
                }
                excelcell23.setCellValue(t_total_2.getText());

                XSSFCell excelcell29 = excelrow23.getCell(6);
                if (excelcell29 == null) {
                    excelcell29 = excelrow23.createCell(6); // Buat sel baru jika belum ada
                }
                excelcell29.setCellValue("Total 2.");
                 excelcell29.setCellStyle(boldStyle);

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
        t_total_2 = new CustomResource.CustomTextfield();
        jLabel2 = new javax.swing.JLabel();
        t_disc = new CustomResource.CustomTextfield();
        t_amount = new CustomResource.CustomTextfield();
        t_total_1 = new CustomResource.CustomTextfield();
        t_ppn = new CustomResource.CustomTextfield();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        t_date = new CustomResource.CustomTextfield();
        t_date_rfq = new CustomResource.CustomTextfield();
        t_payment = new CustomResource.CustomTextfield();
        t_date_estimate = new CustomResource.CustomTextfield();
        t_sq = new CustomResource.CustomTextfield();
        jButton9 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        t_from = new CustomResource.CustomTextfield();
        t_email = new CustomResource.CustomTextfield();
        t_contact = new CustomResource.CustomTextfield();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        t_address = new javax.swing.JTextArea();

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_total_2.setEditable(false);
        t_total_2.setLabelText("Total");
        jPanel1.add(t_total_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 750, 160, -1));

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Form Supplier Quatation");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 650, 20));

        t_disc.setEditable(false);
        t_disc.setLabelText("Discon");
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
        jPanel1.add(t_disc, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 600, 160, -1));

        t_amount.setEditable(false);
        t_amount.setLabelText("Amount");
        t_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_amountKeyReleased(evt);
            }
        });
        jPanel1.add(t_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 600, 160, -1));

        t_total_1.setEditable(false);
        t_total_1.setLabelText("Total");
        jPanel1.add(t_total_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 650, 160, -1));

        t_ppn.setEditable(false);
        t_ppn.setLabelText("PPN 11%");
        jPanel1.add(t_ppn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 700, 160, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MR ID", "Item Name", "Unit", "QTY", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 660, 140));

        t_date.setLabelText("Date Quatation");
        t_date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_dateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_dateKeyTyped(evt);
            }
        });
        jPanel1.add(t_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 257, -1));

        t_date_rfq.setEditable(false);
        t_date_rfq.setLabelText("Date RFQ");
        t_date_rfq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_date_rfqKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_date_rfqKeyTyped(evt);
            }
        });
        jPanel1.add(t_date_rfq, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 257, -1));

        t_payment.setEditable(false);
        t_payment.setLabelText("Payment Condition");
        t_payment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_paymentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_paymentKeyTyped(evt);
            }
        });
        jPanel1.add(t_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 257, -1));

        t_date_estimate.setLabelText("Estimate Delivery");
        t_date_estimate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_date_estimateActionPerformed(evt);
            }
        });
        t_date_estimate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_date_estimateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_date_estimateKeyTyped(evt);
            }
        });
        jPanel1.add(t_date_estimate, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 257, -1));

        t_sq.setEditable(false);
        t_sq.setLabelText("SQ - ID");
        t_sq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_sqActionPerformed(evt);
            }
        });
        t_sq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_sqKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_sqKeyTyped(evt);
            }
        });
        jPanel1.add(t_sq, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 257, -1));

        jButton9.setText("Back To SQ List");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 820, 120, -1));

        jButton7.setText("Download Excel File");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 820, -1, -1));

        jButton10.setText("Approve SQ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 820, 150, -1));

        t_from.setEditable(false);
        t_from.setLabelText("From");
        t_from.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_fromKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_fromKeyTyped(evt);
            }
        });
        jPanel1.add(t_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 257, -1));

        t_email.setEditable(false);
        t_email.setLabelText("Email");
        t_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_emailKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_emailKeyTyped(evt);
            }
        });
        jPanel1.add(t_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 257, -1));

        t_contact.setEditable(false);
        t_contact.setLabelText("Contact");
        t_contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_contactKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_contactKeyTyped(evt);
            }
        });
        jPanel1.add(t_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 257, -1));

        jLabel1.setText("Address");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, -1));

        t_address.setEditable(false);
        t_address.setColumns(20);
        t_address.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        t_address.setLineWrap(true);
        t_address.setRows(5);
        t_address.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                t_addressMouseWheelMoved(evt);
            }
        });
        jScrollPane25.setViewportView(t_address);

        jPanel1.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 210, -1));

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
        // TODO add your handling code here:
    }//GEN-LAST:event_t_discKeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void t_dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_dateKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_dateKeyReleased

    private void t_dateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_dateKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_dateKeyTyped

    private void t_date_rfqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_date_rfqKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_date_rfqKeyReleased

    private void t_date_rfqKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_date_rfqKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_date_rfqKeyTyped

    private void t_paymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_paymentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_paymentKeyReleased

    private void t_paymentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_paymentKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_paymentKeyTyped

    private void t_date_estimateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_date_estimateKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_date_estimateKeyReleased

    private void t_date_estimateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_date_estimateKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_date_estimateKeyTyped

    private void t_date_estimateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_date_estimateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_date_estimateActionPerformed

    private void t_sqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_sqKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_sqKeyReleased

    private void t_sqKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_sqKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_sqKeyTyped

    private void t_sqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_sqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_sqActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        showForm(new po_list_sq());
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            reportx();

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String mr_id = t_sq.getText();

        String[] parts = mr_id.split("-");

        String id = parts[1];

        int respon = JOptionPane.showConfirmDialog(null, "Aprrove SQ ?", "Option", JOptionPane.YES_NO_OPTION);
        if (respon == 0) {
            try {
                stm = koneksi.createStatement();
                String sql = "UPDATE po_sq SET status = '1' WHERE id = '" + id + "'";
                stm.executeUpdate(sql);
                stm.close();
                JOptionPane.showMessageDialog(null, "Data Saved");
                showForm(new po_list_sq());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void t_fromKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_fromKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_fromKeyReleased

    private void t_fromKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_fromKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_fromKeyTyped

    private void t_emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_emailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_emailKeyReleased

    private void t_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_emailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_emailKeyTyped

    private void t_contactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_contactKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_contactKeyReleased

    private void t_contactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_contactKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_contactKeyTyped

    private void t_addressMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_t_addressMouseWheelMoved

    }//GEN-LAST:event_t_addressMouseWheelMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea t_address;
    private CustomResource.CustomTextfield t_amount;
    private CustomResource.CustomTextfield t_contact;
    private CustomResource.CustomTextfield t_date;
    private CustomResource.CustomTextfield t_date_estimate;
    private CustomResource.CustomTextfield t_date_rfq;
    private CustomResource.CustomTextfield t_disc;
    private CustomResource.CustomTextfield t_email;
    private CustomResource.CustomTextfield t_from;
    private CustomResource.CustomTextfield t_payment;
    private CustomResource.CustomTextfield t_ppn;
    private CustomResource.CustomTextfield t_sq;
    private CustomResource.CustomTextfield t_total_1;
    private CustomResource.CustomTextfield t_total_2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
