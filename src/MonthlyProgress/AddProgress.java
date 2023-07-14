/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package MonthlyProgress;
import CustomResource.koneksi;
import Main.MasterForm;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author USER
 */
public class AddProgress extends MasterForm {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    int period = 0;

    /**
     * Creates new form AddProgress
     */
    public AddProgress() {
        initComponents();
        openDB();
        table_id();
        tampil_project();
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

    void tampil_project() {
        try {
            cb_project.removeAllItems();
            ResultSet myRess = koneksi.createStatement().executeQuery("select*from project");
            while (myRess.next()) {
                cb_project.addItem(myRess.getString("project_no"));
            }
        } catch (SQLException ex) {
        }

    }

    void tampil_idsite() {

        try {
            cb_no_site.removeAllItems();
            ResultSet myRess = koneksi.createStatement().executeQuery("select*from no_site where project_no = '" + cb_project.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                cb_no_site.addItem(myRess.getString("id_site"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonthlyProgress.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void tampil() {
        DefaultTableModel dataModel2 = (DefaultTableModel) jTable4.getModel();
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from mp_plan where id_mp_plan = '" + cb_no_site.getSelectedItem().toString() + "' and project_no = '" + cb_project.getSelectedItem().toString() + "'");
            while (rs.next()) {
                double persenPlan = rs.getDouble("persen_plan");
                String formattedPersenPlan = String.format("%.4f", persenPlan).replace(",", ".");

                String[] data = {
                    rs.getString("id"),
                    rs.getString("id_mp_plan") + "-" + rs.getString("no_id"),
                    rs.getString("name_plan"),
                    formattedPersenPlan};
                dataModel2.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }
    }

    void hapus_row() {
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

    }

    void table_id() {
        TableColumnModel columnModel = jTable4.getColumnModel();
        TableColumn column = columnModel.getColumn(0);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
        int rowIndex = 0;
        Object value = jTable4.getValueAt(rowIndex, 0);
        TableColumnModel columnModel2 = jTable3.getColumnModel();
        TableColumn column2 = columnModel2.getColumn(0);
        column2.setMinWidth(0);
        column2.setMaxWidth(0);
        column2.setWidth(0);
        column2.setPreferredWidth(0);
        int rowIndex2 = 0;
        Object value2 = jTable3.getValueAt(rowIndex2, 0);
        TableColumnModel columnModel3 = jTable2.getColumnModel();
        TableColumn column3 = columnModel3.getColumn(0);
        column3.setMinWidth(0);
        column3.setMaxWidth(0);
        column3.setWidth(0);
        column3.setPreferredWidth(0);
        int rowIndex3 = 0; //indeks baris
        Object value3 = jTable2.getValueAt(rowIndex3, 0);
    }

    void tampil_tablework() {
        int row = jTable3.getSelectedRow();
        String b = ((String) jTable3.getValueAt(row, 1));
        t_id_step.setText(b);
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from mp_progress where id_work_step = '" + b + "' and project_no = '" + cb_project.getSelectedItem().toString() + "'");
            while (rs.next()) {
                String[] data = {
                    rs.getString("id"),
                    rs.getString("id_work_step"),
                    rs.getString("tanggal"),
                    rs.getString("achived")};
                dataModel2.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }
    }

    void hitungweighted() {
        DefaultTableModel dataModel = (DefaultTableModel) jTable2.getModel();
        int rowCount = dataModel.getRowCount();
        // Variabel untuk menyimpan jumlah
        float total = 0.0f;
        // Looping untuk menghitung jumlah pada kolom tertentu
        for (int i = 0; i < rowCount; i++) {
            total += Float.parseFloat(dataModel.getValueAt(i, 3).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
        }
        String a = String.valueOf(total);
        t_total_achived.setText(a);
        int row = jTable3.getSelectedRow();
        String b = ((String) jTable3.getValueAt(row, 5));
        Float c = Float.valueOf(b);
        Float d = (total / c) * 100f;
        String weight = String.format("%.4f", d).replace(",", ".");
        t_weight_achived.setText(String.valueOf(weight));
    }

    void updateweight() {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        int rows = jTable3.getSelectedRow();
        String b = ((String) jTable3.getValueAt(rows, 1));
        String c = ((String) jTable3.getValueAt(rows, 5));
        Float total_volume = Float.valueOf(c);
        String d = ((String) jTable3.getValueAt(rows, 3));
        Float total_weight = Float.valueOf(d);
        Float total_achived = Float.valueOf(t_total_achived.getText());
        int rowCount = model.getRowCount();
        for (int row = 0; row < rowCount; row++) {
            Object currentValue = model.getValueAt(row, 1);
            if (currentValue != null && currentValue.toString().equals(b)) {
                Float total = (total_achived / total_volume) * total_weight;
                String hasil = String.format("%.4f", total).replace(",", ".");
                model.setValueAt(t_total_achived.getText(), row, 6);
                model.setValueAt(hasil, row, 7);
            }
        }
    }

    void tampilw() {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            String b = ((String) jTable3.getValueAt(i, 1));
            DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();
            int rowCount1 = model1.getRowCount();
            for (int x = rowCount1 - 1; x >= 0; x--) {
                model1.removeRow(x);
            }

            DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("select*from mp_progress where id_work_step = '" + b + "' and project_no = '" + cb_project.getSelectedItem().toString() + "'");
                while (rs.next()) {
                    String[] data = {
                        rs.getString("id"),
                        rs.getString("id_work_step"),
                        rs.getString("tanggal"),
                        rs.getString("achived")};
                    dataModel2.addRow(data);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }

            DefaultTableModel dataModel = (DefaultTableModel) jTable2.getModel();
            int rowCount2 = dataModel.getRowCount();
            // Variabel untuk menyimpan jumlah
            float total = 0.0f;
            // Looping untuk menghitung jumlah pada kolom tertentu
            for (int z = 0; z < rowCount2; z++) {
                total += Float.parseFloat(dataModel.getValueAt(z, 3).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
            }
            String a = String.valueOf(total);
            t_total_achived.setText(a);
            String n = ((String) jTable3.getValueAt(i, 5));
            Float c = Float.valueOf(n);
            Float d = (total / c) * 100f;
            String weight = String.format("%.4f", d).replace(",", ".");
            t_weight_achived.setText(String.valueOf(weight));

            DefaultTableModel model5 = (DefaultTableModel) jTable3.getModel();
            String x = ((String) jTable3.getValueAt(i, 1));
            String z = ((String) jTable3.getValueAt(i, 5));
            Float total_volume = Float.valueOf(z);
            String v = ((String) jTable3.getValueAt(i, 3));
            Float total_weight = Float.valueOf(v);
            Float total_achived = Float.valueOf(t_total_achived.getText());
            int rowCount5 = model5.getRowCount();
            int colCount = model.getColumnCount();

            for (int row = 0; row < rowCount5; row++) {
                Object currentValue = model5.getValueAt(row, 1);
                if (currentValue != null && currentValue.toString().equals(x)) {
                    // Nilai ditemukan, lakukan update dengan nilai baru
                    Float total1 = (total_achived / total_volume) * total_weight;
                    String hasil = String.format("%.4f", total1).replace(",", ".");
                    model.setValueAt(t_total_achived.getText(), row, 6); // update nilai menjadi "456"
                    model.setValueAt(hasil, row, 7); // update nilai menjadi "456"
                }
            }
        }
    }

    void hitungtotalweight() {
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            String b = ((String) jTable4.getValueAt(i, 1));
            String[] parts = b.split("-");
            String id_pr = parts[0];
            String id_pl = parts[1];

            DefaultTableModel modelm = (DefaultTableModel) jTable3.getModel();
            int rowCountm = modelm.getRowCount();

            for (int o = rowCountm - 1; o >= 0; o--) {
                modelm.removeRow(o);
            }

            DefaultTableModel dataModel2 = (DefaultTableModel) jTable3.getModel();
            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("select*from mp_work_step where id_mp_plan = '" + id_pr + "' and id_no_plan = '" + id_pl + "' and project_no = '" + cb_project.getSelectedItem().toString() + "'");
                while (rs.next()) {
                    double persenWorkStep = rs.getDouble("persen_work_step");
                    String formattedPersenWorkStep = String.format("%.4f", persenWorkStep).replace(",", ".");

                    String[] data = {
                        rs.getString("id"),
                        rs.getString("id_mp_plan") + "-" + rs.getString("id_no_plan") + "-" + rs.getString("id_work_step"),
                        rs.getString("name_work_step"),
                        formattedPersenWorkStep,
                        rs.getString("unit"),
                        rs.getString("total_work_volume")};
                    dataModel2.addRow(data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }

            tampilw();

            DefaultTableModel dataModelp = (DefaultTableModel) jTable4.getModel();
            DefaultTableModel dataModelw = (DefaultTableModel) jTable3.getModel();
            int rowCount3 = dataModelw.getRowCount();

            // Variabel untuk menyimpan jumlah
            float total_achived = 0.0f;
            float total_volume = 0.0f;

            float weight = 0.0f;
            float total = 0.0f;
            // Looping untuk menghitung jumlah pada kolom tertentu
            for (int t = 0; t < rowCount3; t++) {
                total_achived += Float.parseFloat(dataModelw.getValueAt(t, 6).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
            }
            for (int t = 0; t < rowCount3; t++) {
                total_volume += Float.parseFloat(dataModelw.getValueAt(t, 5).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
            }
            weight = Float.parseFloat(dataModelp.getValueAt(i, 3).toString());
            total = (total_achived / total_volume) * weight;
            String r = String.format("%.4f", total).replace(",", ".");
            dataModelp.setValueAt(r, i, 4);

        }
        DefaultTableModel dataModelp = (DefaultTableModel) jTable4.getModel();
        DefaultTableModel dataModelw = (DefaultTableModel) jTable3.getModel();
        float total_w_v = 0.0f;
        float total_w_p = 0.0f;
        int rowCount4 = dataModelp.getRowCount();
        for (int t = 0; t < rowCount4; t++) {
            total_w_v += Float.parseFloat(dataModelp.getValueAt(t, 3).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
        }
        for (int t = 0; t < rowCount4; t++) {
            total_w_p += Float.parseFloat(dataModelp.getValueAt(t, 4).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
        }
        String w_v = String.format("%.4f", total_w_v).replace(",", ".");
        String w_p = String.format("%.4f", total_w_p).replace(",", ".");

        jLabel7.setText(w_v);
        jLabel5.setText(w_p);

    }

    void hitungtotalweight2() {
        int row = jTable4.getSelectedRow();
        DefaultTableModel dataModelp = (DefaultTableModel) jTable4.getModel();
        DefaultTableModel dataModelw = (DefaultTableModel) jTable3.getModel();
        int rowCount3 = dataModelw.getRowCount();
        // Variabel untuk menyimpan jumlah
        float total_achived = 0.0f;
        float total_volume = 0.0f;
        float weight = 0.0f;
        float total = 0.0f;
        // Looping untuk menghitung jumlah pada kolom tertentu
        for (int t = 0; t < rowCount3; t++) {
            total_achived += Float.parseFloat(dataModelw.getValueAt(t, 6).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
        }
        for (int t = 0; t < rowCount3; t++) {
            total_volume += Float.parseFloat(dataModelw.getValueAt(t, 5).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
        }
        weight = Float.parseFloat(dataModelp.getValueAt(row, 3).toString());
        total = (total_achived / total_volume) * weight;
        String r = String.format("%.4f", total).replace(",", ".");
        dataModelp.setValueAt(r, row, 4);
    }

    void reportx() {
        DefaultTableModel dataModelp = (DefaultTableModel) jTable4.getModel();
        DefaultTableModel dataModelw = (DefaultTableModel) jTable3.getModel();
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
                File templateFile = new File("C:\\Users\\hi\\OneDrive\\Documents\\data.xlsx");
                File selectedFile = excelFileChooser.getSelectedFile();
                String outputFilePath = selectedFile.getParent() + "\\" + selectedFile.getName() + ".xlsx";
                File outputFile = new File(outputFilePath);

                // Membaca data template ke dalam workbook
                FileInputStream templateFis = new FileInputStream(templateFile);
                workbook = new XSSFWorkbook(templateFis);
                templateFis.close();

                // Membuat sheet baru di workbook
                XSSFSheet sheet = workbook.getSheet("Sheet1");
                XSSFSheet sheetCopy; //= workbook.createSheet(cb_project.getSelectedItem().toString());
                sheetCopy = workbook.cloneSheet(workbook.getSheetIndex(sheet));
                workbook.setSheetOrder("Sheet1 (2)", 0);
                workbook.setSheetName(0, cb_project.getSelectedItem().toString());
                workbook.removeSheetAt(1);

                DefaultTableModel model = (DefaultTableModel) jTable4.getModel();

                int rowCount = model.getRowCount();
                int hex = 9;
                for (int i = 0; i < rowCount; i++) {

                    String b = ((String) jTable4.getValueAt(i, 1));
                    String[] parts = b.split("-");
                    String id_pr = parts[0];
                    String id_pl = parts[1];

                    DefaultTableModel modelm = (DefaultTableModel) jTable3.getModel();
                    int rowCountm = modelm.getRowCount();

                    for (int o = rowCountm - 1; o >= 0; o--) {
                        modelm.removeRow(o);
                    }

                    DefaultTableModel dataModel2 = (DefaultTableModel) jTable3.getModel();
                    try {
                        stm = koneksi.createStatement();
                        rs = stm.executeQuery("select*from mp_work_step where id_mp_plan = '" + id_pr + "' and id_no_plan = '" + id_pl + "' and project_no = '" + cb_project.getSelectedItem().toString() + "'");
                        while (rs.next()) {
                            double persenWorkStep = rs.getDouble("persen_work_step");
                            String formattedPersenWorkStep = String.format("%.4f", persenWorkStep).replace(",", ".");

                            String[] data = {
                                rs.getString("id"),
                                rs.getString("id_mp_plan") + "-" + rs.getString("id_no_plan") + "-" + rs.getString("id_work_step"),
                                rs.getString("name_work_step"),
                                formattedPersenWorkStep,
                                rs.getString("unit"),
                                rs.getString("total_work_volume")};
                            dataModel2.addRow(data);
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e + "data gagal tampil");
                    }

                    if (period == 0) {
                        tampilw();
                        System.out.println(0);
                    }
                    if (period == 1) {
                        tampilw_period();
                        System.out.println(1);
                    }

                    for (int m = 2; m < dataModelw.getColumnCount(); m++) {
                           if (hex % 8 == 5) {
                              
                                hex = hex + 2;
                               
                            }
                        XSSFRow excelrow = sheetCopy.getRow(hex);
                        hex = hex + 1;
                        for (int j = 0; j < dataModelw.getRowCount(); j++) {
                          
                            XSSFCell excelcell = excelrow.getCell(j + 3);
                             excelcell.setCellValue(dataModelw.getValueAt(j, m).toString());
                            if (hex % 8 == 3 || hex % 8 == 7) {
                                excelcell.setCellValue(dataModelw.getValueAt(j, m).toString() + "%");
                            }
                            if (hex % 8 == 1) {
                                excelcell.setCellValue(dataModelw.getValueAt(j, m).toString() + "%");
                            } 
                        }
                        
                    }
                   

                    int rowCount3 = dataModelw.getRowCount();

                    // Variabel untuk menyimpan jumlah
                    float total_achived = 0.0f;
                    float total_volume = 0.0f;

                    float weight = 0.0f;
                    float total = 0.0f;
                    // Looping untuk menghitung jumlah pada kolom tertentu
                    for (int t = 0; t < rowCount3; t++) {
                        total_achived += Float.parseFloat(dataModelw.getValueAt(t, 6).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
                    }
                    for (int t = 0; t < rowCount3; t++) {
                        total_volume += Float.parseFloat(dataModelw.getValueAt(t, 5).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
                    }
                    weight = Float.parseFloat(dataModelp.getValueAt(i, 3).toString());
                    total = (total_achived / total_volume) * weight;
                    String r = String.format("%.4f", total).replace(",", ".");
                    dataModelp.setValueAt(r, i, 4);

                }

                float total_w_v = 0.0f;
                float total_w_p = 0.0f;
                int rowCount4 = dataModelp.getRowCount();
                for (int t = 0; t < rowCount4; t++) {
                    total_w_v += Float.parseFloat(dataModelp.getValueAt(t, 3).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
                }
                for (int t = 0; t < rowCount4; t++) {
                    total_w_p += Float.parseFloat(dataModelp.getValueAt(t, 4).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
                }
                String w_v = String.format("%.4f", total_w_v).replace(",", ".");
                String w_p = String.format("%.4f", total_w_p).replace(",", ".");

                jLabel7.setText(w_v);
                jLabel5.setText(w_p);

                int row = 9;
                int row1 = 9 + 7;

//                 Menyalin data dari table ke dalam sheet
                XSSFRow excelrow1 = sheetCopy.getRow(2);
                XSSFCell excelcell1 = excelrow1.getCell(1);
                excelcell1.setCellValue(cb_project.getSelectedItem().toString());

                excelrow1 = sheetCopy.getRow(3);
                excelcell1 = excelrow1.getCell(1);
                excelcell1.setCellValue(jLabel2.getText());

                excelrow1 = sheetCopy.getRow(6);
                excelcell1 = excelrow1.getCell(0);
                excelcell1.setCellValue(cb_no_site.getSelectedItem().toString());

                excelrow1 = sheetCopy.getRow(6);
                excelcell1 = excelrow1.getCell(1);
                excelcell1.setCellValue(jLabel1.getText());

                excelrow1 = sheetCopy.getRow(7);
                excelcell1 = excelrow1.getCell(2);
                excelcell1.setCellValue(jLabel7.getText() + "%");

                excelrow1 = sheetCopy.getRow(8);
                excelcell1 = excelrow1.getCell(2);
                excelcell1.setCellValue(jLabel5.getText() + "%");

                if (period == 1) {
                    String s_stgl;
                    String e_stgl;
                    DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    DateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy");
                    try {
                        Date date = inputFormat.parse(stgl.getText());
                        s_stgl = outputFormat.format(date);
                        date = inputFormat.parse(etgl.getText());
                        e_stgl = outputFormat.format(date);

                        excelrow1 = sheetCopy.getRow(3);
                        excelcell1 = excelrow1.getCell(11);
                        excelcell1.setCellValue(s_stgl + " / " + e_stgl);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                
                
                for (int i = 0; i < dataModelp.getRowCount(); i++) {

                    XSSFRow excelrow = sheetCopy.getRow(row1);
                    row1 = row1 + 8;

                    for (int j = 4; j < dataModelp.getColumnCount(); j++) {
                        XSSFCell excelcell = excelrow.getCell(2);

                        excelcell.setCellValue(dataModelp.getValueAt(i, j).toString() + "%");
                    }
                }

                for (int i = 0; i < dataModelp.getRowCount(); i++) {

                    XSSFRow excelrow = sheetCopy.getRow(row);

                    row = row + 8;

                    int cell = 0;
                    for (int j = 1; j < dataModelp.getColumnCount() - 1; j++) {
                        XSSFCell excelcell = excelrow.getCell(cell);
                        cell = cell + 1;

                        if (cell == 3) { 
                            excelrow = sheetCopy.getRow(row - 7);
                            excelcell = excelrow.getCell(cell - 1);
                            excelcell.setCellValue(dataModelp.getValueAt(i, j).toString() + "%");

                        } else {
                            excelcell.setCellValue(dataModelp.getValueAt(i, j).toString());

                        }
                    }
                }

                for (int i = hex; i < 130; i++) {
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

    void tampil_tablework_period() {
        int row = jTable3.getSelectedRow();
        String b = ((String) jTable3.getValueAt(row, 1));
        t_id_step.setText(b);

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from mp_progress where id_work_step = '" + b + "' and project_no = '" + cb_project.getSelectedItem().toString() + "' AND tanggal BETWEEN '" + stgl.getText() + "' AND '" + etgl.getText() + "' ");
            while (rs.next()) {
                String[] data = {
                    rs.getString("id"),
                    rs.getString("id_work_step"),
                    rs.getString("tanggal"),
                    rs.getString("achived")};
                dataModel2.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }

    }

    void tampilw_period() {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            String b = ((String) jTable3.getValueAt(i, 1));
            DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();
            int rowCount1 = model1.getRowCount();
            for (int x = rowCount1 - 1; x >= 0; x--) {
                model1.removeRow(x);
            }
            DefaultTableModel dataModel2 = (DefaultTableModel) jTable2.getModel();
            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("select*from mp_progress where id_work_step = '" + b + "' and project_no = '" + cb_project.getSelectedItem().toString() + "' AND tanggal BETWEEN '" + stgl.getText() + "' AND '" + etgl.getText() + "'");
                while (rs.next()) {
                    String[] data = {
                        rs.getString("id"),
                        rs.getString("id_work_step"),
                        rs.getString("tanggal"),
                        rs.getString("achived")};
                    dataModel2.addRow(data);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }

            DefaultTableModel dataModel = (DefaultTableModel) jTable2.getModel();
            int rowCount2 = dataModel.getRowCount();

            // Variabel untuk menyimpan jumlah
            float total = 0.0f;

            // Looping untuk menghitung jumlah pada kolom tertentu
            for (int z = 0; z < rowCount2; z++) {
                total += Float.parseFloat(dataModel.getValueAt(z, 3).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
            }
            String a = String.valueOf(total);

            t_total_achived.setText(a);

            String n = ((String) jTable3.getValueAt(i, 5));
            Float c = Float.valueOf(n);
            Float d = (total / c) * 100f;
            String weight = String.format("%.4f", d).replace(",", ".");
            t_weight_achived.setText(String.valueOf(weight));
            DefaultTableModel model5 = (DefaultTableModel) jTable3.getModel();
            String x = ((String) jTable3.getValueAt(i, 1));
            String z = ((String) jTable3.getValueAt(i, 5));
            Float total_volume = Float.valueOf(z);
            String v = ((String) jTable3.getValueAt(i, 3));
            Float total_weight = Float.valueOf(v);
            Float total_achived = Float.valueOf(t_total_achived.getText());
            int rowCount5 = model5.getRowCount();
            int colCount = model.getColumnCount();
            for (int row = 0; row < rowCount5; row++) {
                Object currentValue = model5.getValueAt(row, 1);
                if (currentValue != null && currentValue.toString().equals(x)) {
                    // Nilai ditemukan, lakukan update dengan nilai baru
                    Float total1 = (total_achived / total_volume) * total_weight;
                    String hasil = String.format("%.4f", total1).replace(",", ".");
                    model.setValueAt(t_total_achived.getText(), row, 6); // update nilai menjadi "456"
                    model.setValueAt(hasil, row, 7); // update nilai menjadi "456"
                }
            }
        }
    }

    void hitungtotalweight_period() {
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {

            String b = ((String) jTable4.getValueAt(i, 1));
            String[] parts = b.split("-");
            String id_pr = parts[0];
            String id_pl = parts[1];

            DefaultTableModel modelm = (DefaultTableModel) jTable3.getModel();
            int rowCountm = modelm.getRowCount();

            for (int o = rowCountm - 1; o >= 0; o--) {
                modelm.removeRow(o);
            }

            DefaultTableModel dataModel2 = (DefaultTableModel) jTable3.getModel();
            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("select*from mp_work_step where id_mp_plan = '" + id_pr + "' and id_no_plan = '" + id_pl + "' and project_no = '" + cb_project.getSelectedItem().toString() + "'");
                while (rs.next()) {
                    double persenWorkStep = rs.getDouble("persen_work_step");
                    String formattedPersenWorkStep = String.format("%.4f", persenWorkStep).replace(",", ".");

                    String[] data = {
                        rs.getString("id"),
                        rs.getString("id_mp_plan") + "-" + rs.getString("id_no_plan") + "-" + rs.getString("id_work_step"),
                        rs.getString("name_work_step"),
                        formattedPersenWorkStep,
                        rs.getString("unit"),
                        rs.getString("total_work_volume")};
                    dataModel2.addRow(data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }

            tampilw_period();

            DefaultTableModel dataModelp = (DefaultTableModel) jTable4.getModel();
            DefaultTableModel dataModelw = (DefaultTableModel) jTable3.getModel();
            int rowCount3 = dataModelw.getRowCount();

            // Variabel untuk menyimpan jumlah
            float total_achived = 0.0f;
            float total_volume = 0.0f;
            float weight = 0.0f;
            float total = 0.0f;

            // Looping untuk menghitung jumlah pada kolom tertentu
            for (int t = 0; t < rowCount3; t++) {
                total_achived += Float.parseFloat(dataModelw.getValueAt(t, 6).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
            }
            for (int t = 0; t < rowCount3; t++) {
                total_volume += Float.parseFloat(dataModelw.getValueAt(t, 5).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
            }

            weight = Float.parseFloat(dataModelp.getValueAt(i, 3).toString());

            total = (total_achived / total_volume) * weight;
            String r = String.format("%.4f", total).replace(",", ".");
            dataModelp.setValueAt(r, i, 4);

        }
        DefaultTableModel dataModelp = (DefaultTableModel) jTable4.getModel();
        DefaultTableModel dataModelw = (DefaultTableModel) jTable3.getModel();
        float total_w_v = 0.0f;
        float total_w_p = 0.0f;
        int rowCount4 = dataModelp.getRowCount();
        for (int t = 0; t < rowCount4; t++) {
            total_w_v += Float.parseFloat(dataModelp.getValueAt(t, 3).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
        }
        for (int t = 0; t < rowCount4; t++) {
            total_w_p += Float.parseFloat(dataModelp.getValueAt(t, 4).toString()); // Mengambil data dari kolom ke-2 dan menjumlahkannya
        }
        String w_v = String.format("%.4f", total_w_v).replace(",", ".");
        String w_p = String.format("%.4f", total_w_p).replace(",", ".");

        jLabel7.setText(w_v);
        jLabel5.setText(w_p);
    }

    void ckbox() {
        jCheckBox1.addActionListener(e -> {
            if (jCheckBox1.isSelected()) {
                hapus_row();
                tampil();
                hitungtotalweight_period();
                period = 1;

            } else {
                hapus_row();
                tampil();
                hitungtotalweight();
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

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        dateChooser3 = new com.raven.datechooser.DateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cb_no_site = new CustomResource.ComboBoxSuggestion();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        t_tgl_achived = new CustomResource.CustomTextfield();
        t_achived = new CustomResource.CustomTextfield();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        t_id_step = new CustomResource.CustomTextfield();
        t_weight_achived = new CustomResource.CustomTextfield();
        t_total_achived = new CustomResource.CustomTextfield();
        cb_project = new CustomResource.ComboBoxSuggestion();
        jLabel87 = new javax.swing.JLabel();
        stgl = new CustomResource.CustomTextfield();
        etgl = new CustomResource.CustomTextfield();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(t_tgl_achived);

        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(stgl);

        dateChooser3.setDateFormat("yyyy-MM-dd");
        dateChooser3.setTextRefernce(etgl);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Table Activity Description");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 1030, 20));

        cb_no_site.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Test", " " }));
        cb_no_site.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_no_site.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_no_siteActionPerformed(evt);
            }
        });
        jPanel1.add(cb_no_site, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 260, 30));

        jLabel86.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel86.setText("Chose Project");
        jPanel1.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 90, 30));

        jTable2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "id", "ID Work Step", "Date Achived", "Achived"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 640, 300, 160));

        jTable3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "ID Work Step", "Work Step", "Weight Value", "Unit", "Total Voulume", "Achived", "Weight Progress"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 1030, 210));

        jLabel4.setBackground(new java.awt.Color(0, 51, 51));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("History Progress");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, 740, 20));

        jLabel6.setBackground(new java.awt.Color(0, 51, 51));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Progress");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 1030, 20));

        t_tgl_achived.setLabelText("Date Achived");
        jPanel1.add(t_tgl_achived, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 680, 170, -1));

        t_achived.setLabelText("Achived");
        t_achived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_achivedActionPerformed(evt);
            }
        });
        t_achived.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_achivedKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_achivedKeyTyped(evt);
            }
        });
        jPanel1.add(t_achived, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 680, 90, -1));

        jLabel8.setBackground(new java.awt.Color(0, 51, 51));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Table Work Step");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 1030, 20));

        jLabel9.setBackground(new java.awt.Color(0, 51, 51));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DETAIL MEASUREMENT PROGRESS");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 1030, 20));

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 730, 140, 30));

        jTable4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Activity ID", "Activity Description", "W/V", "Weight Progress"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable4MouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 1030, 110));

        jLabel10.setBackground(new java.awt.Color(0, 51, 51));
        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Cut Off Date");
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 320, 20));

        t_id_step.setEnabled(false);
        t_id_step.setLabelText("Achived");
        t_id_step.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_id_stepActionPerformed(evt);
            }
        });
        t_id_step.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_id_stepKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_id_stepKeyTyped(evt);
            }
        });
        jPanel1.add(t_id_step, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 90, -1));

        t_weight_achived.setLabelText("Weighted Progress");
        t_weight_achived.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_weight_achivedKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_weight_achivedKeyTyped(evt);
            }
        });
        jPanel1.add(t_weight_achived, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 710, 90, -1));

        t_total_achived.setLabelText("Total Achived");
        t_total_achived.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_total_achivedKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_total_achivedKeyTyped(evt);
            }
        });
        jPanel1.add(t_total_achived, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 660, 70, -1));

        cb_project.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Test", " " }));
        cb_project.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cb_project.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_projectActionPerformed(evt);
            }
        });
        jPanel1.add(cb_project, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 260, 30));

        jLabel87.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel87.setText("Chose Activity");
        jPanel1.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 90, 30));

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
        jPanel1.add(stgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 110, -1));

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
        jPanel1.add(etgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 110, -1));

        jLabel11.setBackground(new java.awt.Color(0, 51, 51));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Chose Progres");
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 280, 20));

        jButton1.setText("SAVE AS EXCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 760, -1, -1));

        jCheckBox1.setText("Display By Date Range");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, -1, -1));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        jLabel2.setText("jLabel1");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 280, -1, -1));

        jLabel7.setText("jLabel5");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_no_siteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_no_siteActionPerformed
        if (cb_no_site.getSelectedItem() == null) {
            jLabel1.setText("");
        } else {
            try {

                ResultSet myRess = koneksi.createStatement().executeQuery("select*from no_site where project_no = '" + cb_project.getSelectedItem().toString() + "' and id_site = '" + cb_no_site.getSelectedItem().toString() + "' ");
                while (myRess.next()) {
                    jLabel1.setText(myRess.getString("name_site"));
                }
            } catch (SQLException ex) {
            }
            if (period == 0) {
                hapus_row();
                tampil();
                hitungtotalweight();
            }
            if (period == 1) {
                hapus_row();
                tampil();
                hitungtotalweight_period();
            }
        }
    }//GEN-LAST:event_cb_no_siteActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseEntered

    private void t_achivedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_achivedKeyReleased

    }//GEN-LAST:event_t_achivedKeyReleased

    private void t_achivedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_achivedKeyTyped

    }//GEN-LAST:event_t_achivedKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            Statement stm = koneksi.createStatement();
            String sql = "Insert Into mp_progress (project_no,id_work_step,tanggal,achived) value ('" + cb_project.getSelectedItem().toString() + "','" + t_id_step.getText() + "','" + t_tgl_achived.getText() + "','" + t_achived.getText() + "') ";

            stm.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        t_achived.setText("");

        if (period == 0) {
            tampilw();
            tampil_tablework();
            hitungweighted();
            hitungtotalweight2();
        }
        if (period == 1) {
            tampilw_period();
            tampil_tablework_period();
            hitungweighted();
            hitungtotalweight2();
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        int row = jTable4.getSelectedRow();
        String b = ((String) jTable4.getValueAt(row, 1));
        String[] parts = b.split("-");
        String id_pr = parts[0];
        String id_pl = parts[1];

        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        DefaultTableModel dataModel2 = (DefaultTableModel) jTable3.getModel();
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from mp_work_step where id_mp_plan = '" + id_pr + "' and id_no_plan = '" + id_pl + "' and project_no = '" + cb_project.getSelectedItem().toString() + "'");
            while (rs.next()) {
                double persenWorkStep = rs.getDouble("persen_work_step");
                String formattedPersenWorkStep = String.format("%.4f", persenWorkStep).replace(",", ".");

                String[] data = {
                    rs.getString("id"),
                    rs.getString("id_mp_plan") + "-" + rs.getString("id_no_plan") + "-" + rs.getString("id_work_step"),
                    rs.getString("name_work_step"),
                    formattedPersenWorkStep,
                    rs.getString("unit"),
                    rs.getString("total_work_volume")};
                dataModel2.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }
        if (period == 0) {
            tampilw();
        }
        if (period == 1) {
            tampilw_period();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseEntered

    private void t_id_stepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_id_stepKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_id_stepKeyReleased

    private void t_id_stepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_id_stepKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_id_stepKeyTyped

    private void t_id_stepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_id_stepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_id_stepActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        if (period == 0) {
            tampil_tablework();
            hitungweighted();
            updateweight();
        }
        if (period == 1) {
            tampil_tablework_period();
            hitungweighted();
            updateweight();
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void t_weight_achivedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_weight_achivedKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_weight_achivedKeyReleased

    private void t_weight_achivedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_weight_achivedKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_weight_achivedKeyTyped

    private void t_achivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_achivedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_achivedActionPerformed

    private void t_total_achivedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_total_achivedKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_total_achivedKeyReleased

    private void t_total_achivedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_total_achivedKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_total_achivedKeyTyped

    private void cb_projectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_projectActionPerformed
        if (cb_project.getSelectedItem() == null) {
            jLabel2.setText("");
        } else {
            try {

                ResultSet myRess = koneksi.createStatement().executeQuery("select*from project where project_no = '" + cb_project.getSelectedItem().toString() + "'");
                while (myRess.next()) {
                    jLabel2.setText(myRess.getString("project_name"));
                }
            } catch (SQLException ex) {
            }
            hapus_row();
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            int rowCount = model.getRowCount();

            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            tampil_idsite();

        }
    }//GEN-LAST:event_cb_projectActionPerformed

    private void stglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stglActionPerformed

    private void stglKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stglKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_stglKeyReleased

    private void stglKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stglKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_stglKeyTyped

    private void etglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etglActionPerformed

    private void etglKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etglKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_etglKeyReleased

    private void etglKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etglKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_etglKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        reportx();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

    }//GEN-LAST:event_jCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.ComboBoxSuggestion cb_no_site;
    private CustomResource.ComboBoxSuggestion cb_project;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private com.raven.datechooser.DateChooser dateChooser3;
    private CustomResource.CustomTextfield etgl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private CustomResource.CustomTextfield stgl;
    private CustomResource.CustomTextfield t_achived;
    private CustomResource.CustomTextfield t_id_step;
    private CustomResource.CustomTextfield t_tgl_achived;
    private CustomResource.CustomTextfield t_total_achived;
    private CustomResource.CustomTextfield t_weight_achived;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
