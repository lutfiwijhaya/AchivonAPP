/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

/**
 *
 * @author hi
 */
import CustomResource.MySession;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import CustomResource.koneksi;
import Main.MasterForm;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.table.DefaultTableModel;

public class CandidateApplication extends MasterForm {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    DefaultTableModel ImportDataExel;
    String crudimage = "";
    String da = null;
    int id_employee;
    String tanggal;
    

    /**
     * Creates new form CandidateApplication
     */
    public CandidateApplication() {
        initComponents();
        openDB();
        tampil();
        MyWindow();
        currentBox();
        codeCountryBox();
        id_employee();
        jToggleButton1.setEnabled(false);
        get_tanggal();
        jScrollPane18.getVerticalScrollBar().setUnitIncrement(16);
        
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        model2.addRow(new Object[]{"22-OKT-2022", "Universitas Serang Raya", getSubTableDataAcademic(), "Sistem Informasi"});
        model2.addRow(new Object[]{"22-OKT-2022", "Universitas Serang Raya", getSubTableDataAcademic(), "Sistem Informasi"});
        jTable2.autoRowHeight(jTable2);
        
        DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
        model3.addRow(new Object[]{"John", "", "12-may-1976", getSubTableDataFamily(), ""});
        model3.addRow(new Object[]{"Deep", "", "02-jan-1982", getSubTableDataFamily(), ""});
        jTable3.autoRowHeight(jTable3);
        
        DefaultTableModel model4 = (DefaultTableModel) jTable4.getModel();
        model4.addRow(new Object[]{"22-Des-2022", "Udemy", "Udemy", getSubTableDataCertificate(), ""});
        model4.addRow(new Object[]{"02-Nov-2022", "Dicoding", "Dicoding", getSubTableDataCertificate(), ""});
        jTable4.autoRowHeight(jTable4);
        
        DefaultTableModel model5 = (DefaultTableModel) jTable5.getModel();
        model5.addRow(new Object[]{"Example name", "Example Position", getSubTableDataCareer(), ""});
        model5.addRow(new Object[]{"Example name", "Example Position", getSubTableDataCareer(), ""});
        jTable5.autoRowHeight(jTable5);
    }
    
    private DefaultTableModel getSubTableDataAcademic() {
        DefaultTableModel data = new DefaultTableModel();
        data.setColumnCount(2);
        data.addRow(new Object[]{new CustomResource.Header("Provinsi / Province",100), new CustomResource.Header("Kota / City")});
        data.addRow(new Object[]{"Banten", "Kota Serang"});
//        data.addRow(new Object[]{1, "Vital", "$ 70", getSubTableData1()});
//        data.addRow(new Object[]{1, "Fanta", "$ 20", getSubTableData1()});
//        data.addRow(new Object[]{1, "Coca", getSubTableData1(), getSubTableData1()});
        return data;
    }
    private DefaultTableModel getSubTableDataFamily() {
        DefaultTableModel data = new DefaultTableModel();
        data.setColumnCount(2);
        data.addRow(new Object[]{new CustomResource.Header("YA / YES",100), new CustomResource.Header("TIDAK / NO")});
        data.addRow(new Object[]{"YA / YES", ""});
//        data.addRow(new Object[]{1, "Vital", "$ 70", getSubTableData1()});
//        data.addRow(new Object[]{1, "Fanta", "$ 20", getSubTableData1()});
//        data.addRow(new Object[]{1, "Coca", getSubTableData1(), getSubTableData1()});
        return data;
    }
    private DefaultTableModel getSubTableDataCertificate() {
        DefaultTableModel data = new DefaultTableModel();
        data.setColumnCount(2);
        data.addRow(new Object[]{new CustomResource.Header("Provinsi / Province",100), new CustomResource.Header("Kota / City")});
        data.addRow(new Object[]{"Jawa Timur", "Sragen"});
//        data.addRow(new Object[]{"jawa Timur", "ngawi"});
//        data.addRow(new Object[]{1, "Vital", "$ 70", getSubTableData1()});
//        data.addRow(new Object[]{1, "Fanta", "$ 20", getSubTableData1()});
//        data.addRow(new Object[]{1, "Coca", getSubTableData1(), getSubTableData1()});
        return data;
    }
    private DefaultTableModel getSubTableDataCareer() {
        DefaultTableModel data = new DefaultTableModel();
        data.setColumnCount(2);
        data.addRow(new Object[]{new CustomResource.Header("Dari Tanggal / Start Date",100), new CustomResource.Header("Sampai Tanggal / End Date")});
        data.addRow(new Object[]{"1-jan-1999", "1-jan-2000"});
//        data.addRow(new Object[]{1, "Vital", "$ 70", getSubTableData1()});
//        data.addRow(new Object[]{1, "Fanta", "$ 20", getSubTableData1()});
//        data.addRow(new Object[]{1, "Coca", getSubTableData1(), getSubTableData1()});
        return data;
    }
    
//    private DefaultTableModel getSubTableData1() {
//        DefaultTableModel data = new DefaultTableModel();
//        data.setColumnCount(3);
//        data.addRow(new Object[]{new CustomResource.Header("No", 10), new CustomResource.Header("Type"), new CustomResource.Header("Qty")});
//        data.addRow(new Object[]{1, "Unit", "50"});
//        data.addRow(new Object[]{1, "Case", "70"});
//        data.addRow(new Object[]{1, "Box", "3"});
//        return data;
//    }

    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }

    private void tampil() {
        Connection myConn;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM countries");
            while (myRess.next()) {
                homeCountry.addItem(myRess.getString("name"));
            }
        } catch (SQLException ex) {
        }
        homeCountry.setEnabled(true);
    }

    private void setfokus() {
        jTable3.requestFocus();
        jTable3.editCellAt(0, 0);
    }

    private void id_employee() {
        String sql = "select max(id_employee) from cd_employee ";
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int a = rs.getInt(1);
                id_employee = a + 1;
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    private void simpan_family() {
        jTable3.editCellAt(0, 0);
        DefaultTableModel tabelfamily = (DefaultTableModel) jTable3.getModel();
        int htabelfamily = jTable3.getRowCount();

        for (int i = 0; i <= htabelfamily - 1; i++) {
            if (jTable3.getValueAt(i, 0) == null) {
            }else{
                String dtabel_nama = jTable3.getValueAt(i, 0).toString();
                String dtabel_hub = jTable3.getValueAt(i, 1).toString();
                String dtabel_tgl = jTable3.getValueAt(i, 2).toString();
                String dtabel_tinggal = jTable3.getValueAt(i, 3).toString();
                String dtabel_hp = jTable3.getValueAt(i, 3).toString();
                try {
                    stm = koneksi.createStatement();
                    String sql = "insert into cd_family (id_employee,name,hubungan,Birthday,cohabit,No_HP) values('" + da + "'"
                            + ",'" + dtabel_nama + "'"
                            + ",'" + dtabel_hub + "'"
                            + ",'" + dtabel_tgl + "'"
                            + ",'" + dtabel_tinggal + "','" + dtabel_hp + "')";

                    stm.executeUpdate(sql);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    private void simpan_serifikat() {
        jTable4.editCellAt(0, 0);
        DefaultTableModel ImportDataExel = (DefaultTableModel) jTable4.getModel();
        int jtabelrows = jTable4.getRowCount();

        for (int i = 0; i <= jtabelrows - 1; i++) {
            if (jTable4.getValueAt(i, 0) == null) {
            } else {
                String dtabel_tgl = jTable4.getValueAt(i, 0).toString();
                String dtabel_nama = jTable4.getValueAt(i, 1).toString();
                String dtabel_autor = jTable4.getValueAt(i, 2).toString();
                String dtabel_lokasi = jTable4.getValueAt(i, 3).toString();
                String dtabel_no = jTable4.getValueAt(i, 3).toString();
                try {
                    stm = koneksi.createStatement();
                    String sql = "insert into cd_certificates (id_employee,acquisition,name_certificate,location,name_authority,no_certificate) values('" + da + "'"
                            + ",'" + dtabel_tgl + "'"
                            + ",'" + dtabel_nama + "'"
                            + ",'" + dtabel_autor + "'"
                            + ",'" + dtabel_lokasi + "','" + dtabel_no + "')";

                    stm.executeUpdate(sql);
                    stm.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    private void simpan_career() {
        jTable4.editCellAt(0, 0);
        DefaultTableModel ImportDataExel = (DefaultTableModel) jTable4.getModel();
        int jtabelrows = jTable4.getRowCount();

        for (int i = 0; i <= jtabelrows - 1; i++) {
            if (jTable4.getValueAt(i, 0) == null) {
            } else {
                String dtabel_nama = jTable4.getValueAt(i, 0).toString();
                String dtabel_posisi = jTable4.getValueAt(i, 1).toString();
                String dtabel_period = jTable4.getValueAt(i, 2).toString();
                String dtabel_career = jTable4.getValueAt(i, 3).toString();
                try {
                    stm = koneksi.createStatement();
                    String sql = "insert into cd_summary_career (id_employee,company_name,job_position,period,career) values('" + da + "'"
                            + ",'" + dtabel_nama + "'"
                            + ",'" + dtabel_posisi + "'"
                            + ",'" + dtabel_period + "'"
                            + ",'" + dtabel_career + "')";

                    stm.executeUpdate(sql);
                    stm.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
    
    private void simpan_motivation() {
        String g_ta = jTextArea1.getText();
        String g_ta2 = jTextArea2.getText();
        try {
            stm = koneksi.createStatement();
            String sql = "insert into cd_motivation (id_employee,motivation1,motivation2) values('" + da + "'"
                    + ",'" + g_ta + "'"
                    + ",'" + g_ta2 + "')";

            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void get_tanggal() {
        Date ys = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yyy");
        tanggal = s.format(ys);
    }

    public void currentBox() {
        Connection myConn;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM countries");
            while (myRess.next()) {
                curentCountry.addItem(myRess.getString("name"));
            }
        } catch (SQLException ex) {
        }
        curentCountry.setEnabled(true);
    }
    
    public void codeCountryBox() {
        Connection myConn;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM countries");
            while (myRess.next()) {
                t_kodeNegara.addItem(myRess.getString("name") +" "+ myRess.getString("phone_code"));
            }
        } catch (SQLException ex) {
        }
        curentCountry.setEnabled(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGrupGender = new javax.swing.ButtonGroup();
        radioGrupStatus = new javax.swing.ButtonGroup();
        jScrollPane18 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel75 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        jLabel81 = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JSeparator();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jSeparator28 = new javax.swing.JSeparator();
        jSeparator29 = new javax.swing.JSeparator();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jSeparator30 = new javax.swing.JSeparator();
        jLabel87 = new javax.swing.JLabel();
        jSeparator31 = new javax.swing.JSeparator();
        jLabel88 = new javax.swing.JLabel();
        jSeparator32 = new javax.swing.JSeparator();
        jSeparator33 = new javax.swing.JSeparator();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jSeparator34 = new javax.swing.JSeparator();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jSeparator35 = new javax.swing.JSeparator();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel93 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane25 = new javax.swing.JScrollPane();
        t_halamat = new javax.swing.JTextArea();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        t_calamat = new javax.swing.JTextArea();
        jCheckBox = new javax.swing.JCheckBox();
        jLabel99 = new javax.swing.JLabel();
        t_tgl = new com.toedter.calendar.JDateChooser();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jSeparator41 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelfoto = new javax.swing.JLabel();
        t_nama = new CustomResource.CustomTextfield();
        t_ktp = new CustomResource.CustomTextfield();
        t_tlhir = new CustomResource.CustomTextfield();
        t_gaji = new CustomResource.CustomTextfield();
        t_hp = new CustomResource.CustomTextfield();
        t_email = new CustomResource.CustomTextfield();
        t_bpjsKetenagakerjaan = new CustomResource.CustomTextfield();
        t_dicipline = new CustomResource.CustomTextfield();
        t_bpjsKesehatan = new CustomResource.CustomTextfield();
        jLabel94 = new javax.swing.JLabel();
        curentCountry = new CustomResource.ComboBoxSuggestion();
        cprov = new CustomResource.ComboBoxSuggestion();
        ccity = new CustomResource.ComboBoxSuggestion();
        t_ckec = new CustomResource.CustomTextfield();
        t_cdesa = new CustomResource.CustomTextfield();
        homeCountry = new CustomResource.ComboBoxSuggestion();
        homeState = new CustomResource.ComboBoxSuggestion();
        homeCity = new CustomResource.ComboBoxSuggestion();
        t_hkec = new CustomResource.CustomTextfield();
        t_ddesa = new CustomResource.CustomTextfield();
        t_npwp = new CustomResource.CustomFormatField();
        t_lamaran = new CustomResource.ComboBoxSuggestion();
        t_lajang = new CustomResource.RadioButtonCustom();
        t_menikah = new CustomResource.RadioButtonCustom();
        t_pria = new CustomResource.RadioButtonCustom();
        t_wanita = new CustomResource.RadioButtonCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new CustomResource.TableCustom();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new CustomResource.TableCustom();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new CustomResource.TableCustom();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new CustomResource.TableCustom();
        t_kodeNegara = new CustomResource.ComboBoxSuggestion();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel71.setText("2. Riwayat Pendidikan / Academic");
        jPanel1.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 850, -1, 30));

        jSeparator25.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator25.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 870, 650, 20));

        jLabel75.setText("Tanggal Lahir / Birth Date");
        jPanel1.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, -1, 30));

        jLabel77.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel77.setText("Status Pernikahan / Marital Status");
        jPanel1.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, -1, 20));

        jLabel80.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel80.setText("Jenis Kelamin / Gender");
        jPanel1.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 120, 20));
        jPanel1.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, 40, 20));

        jLabel81.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel81.setText("Tempat Tinggal saat ini / Current Address");
        jPanel1.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, -1, 20));
        jPanel1.add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 490, 50, 20));

        jLabel82.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel82.setText("Negara / Country");
        jPanel1.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 540, -1, 30));

        jLabel83.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel83.setText("Provinsi / Province");
        jPanel1.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 580, -1, 30));

        jLabel84.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel84.setText("Kota / City");
        jPanel1.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 620, -1, 30));
        jPanel1.add(jSeparator28, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 80, 20));
        jPanel1.add(jSeparator29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 50, 20));

        jLabel85.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel85.setText("Alamat Rumah / Home Address");
        jPanel1.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, -1, 20));

        jLabel86.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel86.setText("1. Data Diri / Personal Information");
        jPanel1.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 200, 30));

        jSeparator30.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator30, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 640, 20));

        jLabel87.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel87.setText("3. Status Keluarga / Family Status");
        jPanel1.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 990, 200, 30));

        jSeparator31.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator31, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 1010, 650, 20));

        jLabel88.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel88.setText("4. Sertifikat Resmi Keahlian / Authorized Certificate Skill");
        jPanel1.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 1140, 330, 30));

        jSeparator32.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator32.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator32, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1160, 530, 20));

        jSeparator33.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator33.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator33, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 1300, 550, 20));

        jLabel89.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel89.setText("5. Ringkasan Status Karir / Summary of Carrer Status");
        jPanel1.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 1280, 310, 30));

        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel90.setText("1. Motivasi untuk Melamar");
        jPanel1.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 1450, 350, 30));

        jSeparator34.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator34.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator34, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 1440, 570, 20));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane23.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1490, 800, 130));

        jLabel91.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel91.setText("6. Pengenalan diri untuk bergabung degan kami");
        jPanel1.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 1420, 440, 30));
        jPanel1.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 2250, 350, 30));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane24.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1670, 800, 130));

        jSeparator35.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator35, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 1830, 790, 20));

        jCheckBox5.setText("Saya menjamin bahwa seluruh uraian di atas adalah benar");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 1870, -1, -1));

        jLabel93.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel93.setText("7. SKCK");
        jPanel1.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 1810, 50, 30));

        jToggleButton1.setText("SIMPAN / SAVE");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 1920, 120, 40));

        t_halamat.setColumns(20);
        t_halamat.setRows(5);
        jScrollPane25.setViewportView(t_halamat);

        jPanel1.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 740, 210, -1));

        jLabel97.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel97.setText("Alamat / Address");
        jPanel1.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 770, 100, 30));

        t_calamat.setColumns(20);
        t_calamat.setRows(5);
        jScrollPane26.setViewportView(t_calamat);

        jPanel1.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 770, 190, -1));

        jCheckBox.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jCheckBox.setText("Sama dengan alamat Rumah / Same as Home Address");
        jCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, -1, -1));

        jLabel99.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel99.setText("Posisi Yang Dilamar /Job Applying");
        jPanel1.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, 30));
        jPanel1.add(t_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 190, -1));

        jLabel101.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel101.setText("Negara / Country");
        jPanel1.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, -1, 20));

        jLabel102.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel102.setText("Alamat / Address");
        jPanel1.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 730, -1, 30));

        jLabel103.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel103.setText("Provinsi / Province");
        jPanel1.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, -1, 30));

        jLabel104.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel104.setText("Kota / City");
        jPanel1.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 590, -1, 30));

        jSeparator41.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator41, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 540, 20));

        jButton1.setText("Ambil Foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        jLabel1.setText("...");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 100, -1));

        labelfoto.setBackground(new java.awt.Color(255, 255, 204));
        labelfoto.setOpaque(true);
        jPanel1.add(labelfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 100, 90));

        t_nama.setLabelText("Nama / Name");
        jPanel1.add(t_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 340, -1));

        t_ktp.setLabelText("KTP No.");
        jPanel1.add(t_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 340, -1));

        t_tlhir.setLabelText("Tempat Lahir / Birth Place");
        jPanel1.add(t_tlhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 340, -1));

        t_gaji.setLabelText("Estimasi Gaji / Sallary");
        jPanel1.add(t_gaji, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 340, -1));

        t_hp.setLabelText("No HP");
        t_hp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_hpActionPerformed(evt);
            }
        });
        t_hp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_hpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_hpKeyTyped(evt);
            }
        });
        jPanel1.add(t_hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 210, 210, -1));

        t_email.setLabelText("Email");
        t_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_emailActionPerformed(evt);
            }
        });
        jPanel1.add(t_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 340, -1));

        t_bpjsKetenagakerjaan.setLabelText("No BPJS Ketenagakerjaan");
        jPanel1.add(t_bpjsKetenagakerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 340, -1));

        t_dicipline.setLabelText("Discipline");
        jPanel1.add(t_dicipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 340, -1));

        t_bpjsKesehatan.setLabelText("No BPJS Kesehatan");
        t_bpjsKesehatan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_bpjsKesehatanKeyTyped(evt);
            }
        });
        jPanel1.add(t_bpjsKesehatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 340, -1));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel94.setText("2. Lainnya (Kepribadian/Latar Belakang Keluarga)");
        jPanel1.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 1630, 350, 30));

        curentCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curentCountryActionPerformed(evt);
            }
        });
        jPanel1.add(curentCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 540, 190, 30));

        cprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cprovActionPerformed(evt);
            }
        });
        jPanel1.add(cprov, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 580, 190, -1));

        ccity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccityActionPerformed(evt);
            }
        });
        jPanel1.add(ccity, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 620, 190, -1));

        t_ckec.setLabelText("Kecamatan / Districts");
        t_ckec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_ckecActionPerformed(evt);
            }
        });
        jPanel1.add(t_ckec, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 660, 310, -1));

        t_cdesa.setLabelText("Desa / Vilage");
        t_cdesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cdesaActionPerformed(evt);
            }
        });
        jPanel1.add(t_cdesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 710, 310, -1));

        homeCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeCountryActionPerformed(evt);
            }
        });
        jPanel1.add(homeCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 190, 30));

        homeState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeStateActionPerformed(evt);
            }
        });
        jPanel1.add(homeState, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 190, 30));

        homeCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeCityActionPerformed(evt);
            }
        });
        jPanel1.add(homeCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 590, 190, 30));

        t_hkec.setLabelText("Kecamatan / Districts");
        t_hkec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_hkecActionPerformed(evt);
            }
        });
        jPanel1.add(t_hkec, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 630, 310, -1));

        t_ddesa.setLabelText("Desa / Vilage");
        t_ddesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_ddesaActionPerformed(evt);
            }
        });
        jPanel1.add(t_ddesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 680, 310, -1));

        try {
            t_npwp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###.#-###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        t_npwp.setLabelText("No NPWP");
        t_npwp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_npwpActionPerformed(evt);
            }
        });
        jPanel1.add(t_npwp, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 430, 340, -1));

        t_lamaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_lamaranActionPerformed(evt);
            }
        });
        jPanel1.add(t_lamaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 190, 30));

        radioGrupStatus.add(t_lajang);
        t_lajang.setText("Single");
        jPanel1.add(t_lajang, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, -1, -1));

        radioGrupStatus.add(t_menikah);
        t_menikah.setText("Married");
        jPanel1.add(t_menikah, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 190, -1, -1));

        radioGrupGender.add(t_pria);
        t_pria.setText("Male");
        jPanel1.add(t_pria, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, -1, -1));

        radioGrupGender.add(t_wanita);
        t_wanita.setText("Female");
        jPanel1.add(t_wanita, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 160, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal Lulus / Graduation Date", "Nama Sekolah / School Name", "Lokasi / Location", "Jurusan / Major"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 880, 850, 100));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Anggota / Members Name", "Relation / Hubungan", "Tanggal lahir / Birthday", "Tinggal bersama / Cohabit", "No Handphone"
            }
        ));
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(4).setHeaderValue("No Sertifikat / Certificate No.");
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1020, 850, 100));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Diakuisisi / Acquisition", "Nama Sertifikat / Sertifikat Name", "Nama Penyelenggara / Authority Name", "Lokasi / Location", "No Sertifikat / Certificate No."
            }
        ));
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(4).setHeaderValue("No Sertifikat / Certificate No.");
        }

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1170, 850, 100));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Perusahaan / Company name", "Posisi Pekerjaan / Job Position", "Periode / Period", "Karir / Career"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1310, 850, 100));

        t_kodeNegara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_kodeNegaraActionPerformed(evt);
            }
        });
        jPanel1.add(t_kodeNegara, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, 120, 30));

        jScrollPane18.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 1169, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String currentdirectory = "C:\\Users\\USER\\Pictures";
        JFileChooser imageFileChooser = new JFileChooser(currentdirectory);
        imageFileChooser.setDialogTitle("Pilih gambar...");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        imageFileChooser.setFileFilter(fnef);
        imageFileChooser.setFileFilter(fnef);
        int imagechooser = imageFileChooser.showOpenDialog(null);
        if (imagechooser == JFileChooser.APPROVE_OPTION) {
            File imagefile = imageFileChooser.getSelectedFile();
            crudimage = imagefile.getAbsolutePath();
            jLabel1.setText(crudimage);
            ImageIcon imageicon = new ImageIcon(crudimage);
            Image imageResize = imageicon.getImage().getScaledInstance(labelfoto.getWidth(), labelfoto.getHeight(), Image.SCALE_SMOOTH);
            labelfoto.setIcon(new ImageIcon(imageResize));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxActionPerformed
        curentCountry.setSelectedItem(homeCountry.getSelectedItem());
        cprov.setSelectedItem(homeState.getSelectedItem());
        ccity.setSelectedItem(homeCity.getSelectedItem());
        t_ckec.setText(t_hkec.getText());
        t_calamat.setText(t_halamat.getText());
        t_cdesa.setText(t_ddesa.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        t_pria.setActionCommand("Laki - laki");
        t_wanita.setActionCommand("Perempuan");
        t_lajang.setActionCommand("Lajang");
        t_menikah.setActionCommand("Menikah");
        String g_nama = t_nama.getText();
        String g_ktp = t_tlhir.getText();
        String g_gender = radioGrupGender.getSelection().getActionCommand();
        String g_status = radioGrupStatus.getSelection().getActionCommand();
        String g_tlahir = t_tlhir.getText();
        String g_tgl = String.valueOf(fm.format(t_tgl.getDate()));
        String g_hp = t_hp.getText();
        String g_email = t_email.getText();
        String g_bpjs = t_bpjsKetenagakerjaan.getText();
        String g_npwp = t_npwp.getText();
        String g_lamaran = (String) t_lamaran.getSelectedItem();
        String g_gaji = t_gaji.getText();
        String g_discipline = t_dicipline.getText();
        
        String g_hnegara = (String) homeCountry.getSelectedItem();
        String g_hprov = (String) homeCity.getSelectedItem();
        String g_hkota = (String) homeCity.getSelectedItem();
        String g_cnegara = (String) curentCountry.getSelectedItem();
        String g_cprov = (String) cprov.getSelectedItem();
        String g_ckota = (String) ccity.getSelectedItem();
        String g_hkec = t_hkec.getText();
        String g_ckec = t_ckec.getText();
        String g_hdesa = t_ddesa.getText();
        String g_cdesa = t_cdesa.getText();
        String g_halamat = t_halamat.getText();
        String g_calamat = t_calamat.getText();
        String sp = ", ";
        String full_curent = g_calamat + sp + g_cdesa + sp + g_ckec + sp + g_ckota + sp + g_cprov + sp + g_cnegara;
        String full_home = g_halamat + sp + g_hdesa + sp + g_hkec + sp + g_hkota + sp + g_hprov + sp + g_hnegara;

        try {
            stm = koneksi.createStatement();
            String sql = "insert into cd_employee (nama,KTP,email,NPWP,sex,b_place,birthday,marital,No_HP,BPJS,Applying_A,D_Salary,discipline,cd_date_apply) values('" + g_nama + "'"
                    + ",'" + g_ktp + "'"
                    + ",'" + g_email + "'"
                    + ",'" + g_npwp + "'"
                    + ",'" + g_gender + "'"
                    + ",'" + g_tlahir + "'"
                    + ",'" + g_tgl + "'"
                    + ",'" + g_status + "'"
                    + ",'" + g_hp + "'"
                    + ",'" + g_bpjs + "'"
                    + ",'" + g_lamaran + "'"
                    + ",'" + g_gaji + "'"
                    + ",'" + g_discipline + "'"
                    + ",'" + tanggal + "')";

            stm.executeUpdate(sql);

            try {
                Statement stm = koneksi.createStatement();

                rs = stm.executeQuery("select*from cd_employee where KTP like '%" + t_tlhir.getText() + "%'");
                while (rs.next()) {
                    da = rs.getString("id_employee");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String sql0 = "insert into cd_adress (id_employee,h_negara,h_prov,h_kab,h_kec,h_desa,h_alamat,c_negara,c_prov,c_kab,c_kec,c_desa,c_alamat,full_home,full_current) values('" + da + "'"
                    + ",'" + g_hnegara + "'"
                    + ",'" + g_hprov + "'"
                    + ",'" + g_hkota + "'"
                    + ",'" + g_hkec + "'"
                    + ",'" + g_hdesa + "'"
                    + ",'" + g_halamat + "'"
                    + ",'" + g_cnegara + "'"
                    + ",'" + g_cprov + "'"
                    + ",'" + g_ckota + "'"
                    + ",'" + g_ckec + "'"
                    + ",'" + g_cdesa + "'"
                    + ",'" + g_calamat + "'"
                    + ",'" + full_home + "'"
                    + ",'" + full_curent + "')";

            stm.executeUpdate(sql0);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }

        jTable2.editCellAt(0, 0);
        DefaultTableModel ImportDataExel = (DefaultTableModel) jTable2.getModel();
        int jtabelrows = jTable2.getRowCount();

        for (int i = 0; i <= jtabelrows - 1; i++) {
            if (jTable2.getValueAt(i, 0) == null) {

            } else {
                String dtabel_tgl = jTable2.getValueAt(i, 0).toString();
                String dtabel_univ = jTable2.getValueAt(i, 1).toString();
                String dtabel_lokasi = jTable2.getValueAt(i, 2).toString();
                String dtabel_jurusan = jTable2.getValueAt(i, 3).toString();

                try {
                    stm = koneksi.createStatement();
                    String sql = "insert into cd_academic (id_employee,Graduation,School_Name,location,major) values('" + da + "'"
                            + ",'" + dtabel_tgl + "'"
                            + ",'" + dtabel_univ + "'"
                            + ",'" + dtabel_lokasi + "'"
                            + ",'" + dtabel_jurusan + "')";

                    stm.executeUpdate(sql);

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        simpan_family();
        simpan_serifikat();
        simpan_career();
        simpan_motivation();
        JOptionPane.showMessageDialog(null, "Data Tersimpan");
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        jToggleButton1.setEnabled(true);
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void t_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_emailActionPerformed

    private void t_hpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_hpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_hpActionPerformed

    private void t_hpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_hpKeyTyped
        String a ;
        String b = "-";
        if(t_hp.getText().length()<2){
            t_hp.setText("(0)");
        }else if (t_hp.getText().length() == 6) {
            t_hp.setText(t_hp.getText()+"-");
//        }else if(t_hp.getText().length() == 7){
//            a = t_hp.getText();
//            a = a.replaceAll(b, "");
//            t_hp.setText(a);
        }else if(t_hp.getText().length() == 11){
            t_hp.setText(t_hp.getText()+"-");
//        }else if(t_hp.getText().length() == 12){
//            a = t_hp.getText();
//            a = a.replaceAll(b, "");
//            t_hp.setText(a);
        }else if(t_hp.getText().length() == 17){
            t_hp.setText(t_hp.getText());
            evt.consume();
        }
    }//GEN-LAST:event_t_hpKeyTyped

    private void curentCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curentCountryActionPerformed
        Connection myConn;
        try {

            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM states WHERE country_name ='" + curentCountry.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                cprov.addItem(myRess.getString("name"));
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_curentCountryActionPerformed

    private void cprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cprovActionPerformed
        Connection myConn;
        try {
            ccity.removeAllItems();
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM cities WHERE state_name ='" + cprov.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                ccity.addItem(myRess.getString("name"));
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_cprovActionPerformed

    private void t_ckecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_ckecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_ckecActionPerformed

    private void t_cdesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cdesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cdesaActionPerformed

    private void homeStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeStateActionPerformed
        Connection myConn;
        try {

            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM cities WHERE state_name ='" + homeState.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                homeCity.addItem(myRess.getString("name"));
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_homeStateActionPerformed

    private void homeCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeCountryActionPerformed
        Connection myConn;
        try {

            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM states WHERE country_name ='" + homeCountry.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                homeState.addItem(myRess.getString("name"));
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_homeCountryActionPerformed

    private void homeCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeCityActionPerformed

    private void t_hkecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_hkecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_hkecActionPerformed

    private void t_ddesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_ddesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_ddesaActionPerformed

    private void ccityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ccityActionPerformed

    private void t_npwpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_npwpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_npwpActionPerformed

    private void t_lamaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_lamaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_lamaranActionPerformed

    private void t_hpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_hpKeyReleased
     // TODO add your handling code here:
    }//GEN-LAST:event_t_hpKeyReleased

    private void t_bpjsKesehatanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_bpjsKesehatanKeyTyped
//        asd
    }//GEN-LAST:event_t_bpjsKesehatanKeyTyped

    private void t_kodeNegaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_kodeNegaraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_kodeNegaraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.ComboBoxSuggestion ccity;
    private CustomResource.ComboBoxSuggestion cprov;
    private CustomResource.ComboBoxSuggestion curentCountry;
    private CustomResource.ComboBoxSuggestion homeCity;
    private CustomResource.ComboBoxSuggestion homeCountry;
    private CustomResource.ComboBoxSuggestion homeState;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator41;
    private CustomResource.TableCustom jTable2;
    private CustomResource.TableCustom jTable3;
    private CustomResource.TableCustom jTable4;
    private CustomResource.TableCustom jTable5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelfoto;
    private javax.swing.ButtonGroup radioGrupGender;
    private javax.swing.ButtonGroup radioGrupStatus;
    private CustomResource.CustomTextfield t_bpjsKesehatan;
    private CustomResource.CustomTextfield t_bpjsKetenagakerjaan;
    private javax.swing.JTextArea t_calamat;
    private CustomResource.CustomTextfield t_cdesa;
    private CustomResource.CustomTextfield t_ckec;
    private CustomResource.CustomTextfield t_ddesa;
    private CustomResource.CustomTextfield t_dicipline;
    private CustomResource.CustomTextfield t_email;
    private CustomResource.CustomTextfield t_gaji;
    private javax.swing.JTextArea t_halamat;
    private CustomResource.CustomTextfield t_hkec;
    private CustomResource.CustomTextfield t_hp;
    private CustomResource.ComboBoxSuggestion t_kodeNegara;
    private CustomResource.CustomTextfield t_ktp;
    private CustomResource.RadioButtonCustom t_lajang;
    private CustomResource.ComboBoxSuggestion t_lamaran;
    private CustomResource.RadioButtonCustom t_menikah;
    private CustomResource.CustomTextfield t_nama;
    private CustomResource.CustomFormatField t_npwp;
    private CustomResource.RadioButtonCustom t_pria;
    private com.toedter.calendar.JDateChooser t_tgl;
    private CustomResource.CustomTextfield t_tlhir;
    private CustomResource.RadioButtonCustom t_wanita;
    // End of variables declaration//GEN-END:variables
    
    
    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void MyWindow() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height - 45);
        this.setPreferredSize(new Dimension(screen.width, screen.height - 100));

//        int x = (screen.width/2) - (this.getSize().width/2);
//        int y = (screen.height/2) - (this.getSize().height/2);
//        this.setPreferredSize(x,y);
    }

    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
