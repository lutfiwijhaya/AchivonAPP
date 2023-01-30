/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author hi
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.table.DefaultTableModel;
public class CandidateApplication extends javax.swing.JPanel {
    Statement stm;
    ResultSet rs;
    Connection koneksi;
    DefaultTableModel ImportDataExel;
    /**
     * Creates new form CandidateApplication
     */
    public CandidateApplication() {
        initComponents();
    }

     String da = null;
    int id_employee;

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
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM states WHERE country_name ='" + homeCountry.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                homeState.addItem(myRess.getString("name"));
            }
//            myRess.last();
//            int jumlahdata = myRess.getRow();
//            myRess.first();

        } catch (SQLException ex) {
        }

        homeCountry.setEnabled(false);

    }

    private void setfokus() {
        jTable2.requestFocus();
        jTable2.editCellAt(0, 0);
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

    private void simpan_family (){
    
     jTable3.editCellAt(0, 0);
        DefaultTableModel tabelfamily = (DefaultTableModel) jTable3.getModel();
        int htabelfamily = jTable3.getRowCount();

        for (int i = 0; i <= htabelfamily - 1; i++) {
 if(jTable3.getValueAt(i,0) == null ){ 
              
} else {
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
            }}

        }      
    
    
    }
    
    private void simpan_serifikat(){
        jTable1.editCellAt(0,0);
     DefaultTableModel ImportDataExel = (DefaultTableModel) jTable1.getModel();
        int jtabelrows = jTable1.getRowCount();

        for (int i = 0; i <= jtabelrows - 1; i++) {
 if(jTable1.getValueAt(i,0) == null ){ 
              
} else {
            String dtabel_tgl = jTable1.getValueAt(i, 0).toString();
            String dtabel_nama = jTable1.getValueAt(i, 1).toString();
            String dtabel_autor = jTable1.getValueAt(i, 2).toString();
            String dtabel_lokasi = jTable1.getValueAt(i, 3).toString();
            String dtabel_no = jTable1.getValueAt(i, 3).toString();

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

        }}    
    
    
    
    }
    
    private void simpan_career(){
     jTable4.editCellAt(0, 0);
        DefaultTableModel ImportDataExel = (DefaultTableModel) jTable4.getModel();
        int jtabelrows = jTable4.getRowCount();

        for (int i = 0; i <= jtabelrows - 1; i++) {
 if(jTable4.getValueAt(i,0) == null ){ 
              
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

        }  }  
    
    
    
    } 
    
    private void simpan_motivation(){
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
            
    
    
    public void currentBox() {
        Connection myConn;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM states WHERE country_name ='" + curentCountry.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                cprov.addItem(myRess.getString("name"));
            }
//            myRess.last();
//            int jumlahdata = myRess.getRow();
//            myRess.first();

        } catch (SQLException ex) {
        }
        curentCountry.setEnabled(false);
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
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        t_nama = new javax.swing.JTextField();
        t_ktp = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        t_tlhir = new javax.swing.JTextField();
        homeCity = new javax.swing.JComboBox<>();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel75 = new javax.swing.JLabel();
        homeCountry = new javax.swing.JComboBox<>();
        homeState = new javax.swing.JComboBox<>();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        t_bpjs = new javax.swing.JTextField();
        t_email = new javax.swing.JTextField();
        t_hp = new javax.swing.JTextField();
        t_wanita = new javax.swing.JRadioButton();
        jLabel79 = new javax.swing.JLabel();
        t_pria = new javax.swing.JRadioButton();
        t_menikah = new javax.swing.JRadioButton();
        jLabel80 = new javax.swing.JLabel();
        t_lajang = new javax.swing.JRadioButton();
        jSeparator26 = new javax.swing.JSeparator();
        jLabel81 = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JSeparator();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        cprov = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        ccity = new javax.swing.JComboBox<>();
        jSeparator28 = new javax.swing.JSeparator();
        jSeparator29 = new javax.swing.JSeparator();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jSeparator30 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel87 = new javax.swing.JLabel();
        jSeparator31 = new javax.swing.JSeparator();
        jLabel88 = new javax.swing.JLabel();
        jSeparator32 = new javax.swing.JSeparator();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jSeparator33 = new javax.swing.JSeparator();
        jLabel89 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
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
        jLabel95 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel96 = new javax.swing.JLabel();
        t_gaji = new javax.swing.JTextField();
        jScrollPane25 = new javax.swing.JScrollPane();
        t_halamat = new javax.swing.JTextArea();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        t_calamat = new javax.swing.JTextArea();
        t_ddesa = new javax.swing.JTextField();
        t_cdesa = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jCheckBox = new javax.swing.JCheckBox();
        curentCountry = new javax.swing.JComboBox<>();
        t_lamaran = new javax.swing.JComboBox<>();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        t_npwp = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        t_tgl = new com.toedter.calendar.JDateChooser();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jSeparator36 = new javax.swing.JSeparator();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jSeparator37 = new javax.swing.JSeparator();
        jLabel116 = new javax.swing.JLabel();
        jSeparator38 = new javax.swing.JSeparator();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jSeparator39 = new javax.swing.JSeparator();
        jSeparator40 = new javax.swing.JSeparator();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jSeparator41 = new javax.swing.JSeparator();
        jLabel122 = new javax.swing.JLabel();
        jSeparator42 = new javax.swing.JSeparator();
        jLabel123 = new javax.swing.JLabel();
        jSeparator43 = new javax.swing.JSeparator();
        jSeparator44 = new javax.swing.JSeparator();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jSeparator45 = new javax.swing.JSeparator();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jSeparator46 = new javax.swing.JSeparator();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel71.setText("2. Riwayat Pendidikan");
        jPanel1.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 740, -1, 30));

        jLabel72.setText("Nama / Name");
        jPanel1.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 30));

        jLabel73.setText("No KTP");
        jPanel1.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 30));

        t_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_namaActionPerformed(evt);
            }
        });
        t_nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_namaKeyTyped(evt);
            }
        });
        jPanel1.add(t_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 190, -1));
        jPanel1.add(t_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 190, -1));

        jLabel74.setText("Tempat Lahir / Birth Place");
        jPanel1.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 30));
        jPanel1.add(t_tlhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 190, -1));

        homeCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeCityActionPerformed(evt);
            }
        });
        jPanel1.add(homeCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 190, -1));

        jSeparator25.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 760, 650, 20));

        jLabel75.setText("Tanggal Lahir / Birth Date");
        jPanel1.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 30));

        homeCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indonesia" }));
        homeCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeCountryActionPerformed(evt);
            }
        });
        jPanel1.add(homeCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 190, -1));

        homeState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeStateActionPerformed(evt);
            }
        });
        jPanel1.add(homeState, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 190, -1));

        jLabel76.setText("No Handphone");
        jPanel1.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, 30));

        jLabel77.setText("Status Pernikahan / \nMarital Status");
        jPanel1.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 20));

        jLabel78.setText("No BPJS");
        jPanel1.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, 30));
        jPanel1.add(t_bpjs, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 190, -1));
        jPanel1.add(t_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 190, -1));

        t_hp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_hpKeyTyped(evt);
            }
        });
        jPanel1.add(t_hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 190, -1));

        radioGrupGender.add(t_wanita);
        t_wanita.setText("Wanita");
        jPanel1.add(t_wanita, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        jLabel79.setText("Email");
        jPanel1.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, 30));

        radioGrupGender.add(t_pria);
        t_pria.setSelected(true);
        t_pria.setText("Pria");
        t_pria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_priaActionPerformed(evt);
            }
        });
        jPanel1.add(t_pria, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        radioGrupStatus.add(t_menikah);
        t_menikah.setText("Sudah Menikah");
        jPanel1.add(t_menikah, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        jLabel80.setText("Jenis Kelamin / Gender");
        jPanel1.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));

        radioGrupStatus.add(t_lajang);
        t_lajang.setSelected(true);
        t_lajang.setText("Lajang");
        jPanel1.add(t_lajang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));
        jPanel1.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 40, 20));

        jLabel81.setText("Tempat Tinggal saat ini / Current Address");
        jPanel1.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, 20));
        jPanel1.add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 320, 50, 20));

        jLabel82.setText("Negara / Country");
        jPanel1.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, -1, 20));

        jLabel83.setText("Provinsi / Province");
        jPanel1.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, -1, 30));

        cprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cprovActionPerformed(evt);
            }
        });
        jPanel1.add(cprov, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 190, -1));

        jLabel84.setText("Kota / City");
        jPanel1.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 530, -1, 30));

        jPanel1.add(ccity, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 530, 190, -1));
        jPanel1.add(jSeparator28, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 80, 20));
        jPanel1.add(jSeparator29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 50, 20));

        jLabel85.setText("Alamat Rumah / Home Address");
        jPanel1.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, 20));

        jLabel86.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel86.setText("1. Data Diri / Personal Information");
        jPanel1.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 300, 30));

        jSeparator30.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator30, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 540, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Diraih pada Tanggal", "Nama Sertifikat", "Nama Badan Penyelenggara", "Lokasi Penyelenggara", "No. Sertifikat"
            }
        ));
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1260, 850, 170));

        jTable2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tanggal Lulus", "Nama Sekolah/Universitas", "Lokasi", "Jurusan/Bidang Keahlian"
            }
        ));
        jTable2.setCellSelectionEnabled(true);
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2.setShowHorizontalLines(true);
        jTable2.setShowVerticalLines(true);
        jTable2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable2InputMethodTextChanged(evt);
            }
        });
        jScrollPane20.setViewportView(jTable2);

        jPanel1.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 780, 850, 170));

        jLabel87.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel87.setText("3. Status Keluarga");
        jPanel1.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 990, 160, 30));

        jSeparator31.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator31, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 1010, 680, 20));

        jLabel88.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel88.setText("4. Sertifikat Resmi Keahlian");
        jPanel1.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1220, 250, 30));

        jSeparator32.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator32, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1240, 600, 20));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama Anggota", "Hubungan", "Tanggal Lahir", "Tinggal Bersama  (Ya atau Tidak)", "No Handphone"
            }
        ));
        jTable3.setShowHorizontalLines(true);
        jTable3.setShowVerticalLines(true);
        jScrollPane21.setViewportView(jTable3);

        jPanel1.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1040, 850, 150));

        jSeparator33.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator33, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1480, 630, 20));

        jLabel89.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel89.setText("5. Ringkasan Status Karir");
        jPanel1.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1460, 230, 30));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Perusahaan", "Posisi Pekerjaan", "Periode (mm-yyyy - mmm-yyyy)", "Karir (Tahun atau Bulan)"
            }
        ));
        jTable4.setShowHorizontalLines(true);
        jTable4.setShowVerticalLines(true);
        jScrollPane22.setViewportView(jTable4);

        jPanel1.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1510, 850, 170));

        jLabel90.setText("1. Motivasi untuk Melamar");
        jPanel1.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1750, 350, 30));

        jSeparator34.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator34, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 1730, 430, 20));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane23.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1790, 800, 130));

        jLabel91.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel91.setText("6. Pengenalan diri untuk bergabung degan kami");
        jPanel1.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1710, 440, 30));

        jLabel92.setText("2. Lainnya (Kepribadian/Latar Belakang Keluarga)");
        jPanel1.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1930, 350, 30));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane24.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1970, 800, 130));

        jSeparator35.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator35, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 2140, 720, 20));

        jCheckBox5.setText("Saya menjamin bahwa seluruh uraian di atas adalah benar");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 2190, -1, -1));

        jLabel93.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel93.setText("7. SKCK Asli");
        jPanel1.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 2120, 120, 30));
        jPanel1.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 2290, 280, 30));

        jToggleButton1.setText("SIMPAN");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 2260, 90, 40));

        jLabel96.setText("No NPWP");
        jPanel1.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, 30));
        jPanel1.add(t_gaji, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 190, -1));

        t_halamat.setColumns(20);
        t_halamat.setRows(5);
        jScrollPane25.setViewportView(t_halamat);

        jPanel1.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        jLabel97.setText("Alamat / Address");
        jPanel1.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, 30));

        t_calamat.setColumns(20);
        t_calamat.setRows(5);
        jScrollPane26.setViewportView(t_calamat);

        jPanel1.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, -1, -1));
        jPanel1.add(t_ddesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 190, -1));

        t_cdesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cdesaActionPerformed(evt);
            }
        });
        jPanel1.add(t_cdesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 570, 190, -1));

        jLabel98.setText("Desa / Vilage");
        jPanel1.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 570, 80, 30));

        jCheckBox.setText("Sama dengan alamat Rumah / Same as Home Address");
        jCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 630, -1, -1));

        curentCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indonesia" }));
        curentCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curentCountryActionPerformed(evt);
            }
        });
        jPanel1.add(curentCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 190, -1));

        t_lamaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(t_lamaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 190, -1));

        jLabel99.setText("Posisi Yang Dilamar /Job Applying");
        jPanel1.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, 20));

        jLabel100.setText("Estimasi Gaji / Sallary");
        jPanel1.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, -1));
        jPanel1.add(t_npwp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 190, -1));

        jButton6.setText("test b academi");
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 980, -1, -1));
        jPanel1.add(t_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 190, -1));

        jLabel101.setText("Negara / Country");
        jPanel1.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, 20));

        jLabel102.setText("Alamat / Address");
        jPanel1.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, 30));

        jLabel103.setText("Provinsi / Province");
        jPanel1.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, 30));

        jLabel104.setText("Kota / City");
        jPanel1.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, 30));

        jLabel105.setText("Desa / Vilage");
        jPanel1.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 80, 30));

        jLabel106.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel106.setText("2. Riwayat Pendidikan");
        jPanel1.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 740, -1, 30));

        jLabel107.setText("Nama / Name");
        jPanel1.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 30));

        jLabel108.setText("No KTP");
        jPanel1.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 30));

        jLabel109.setText("Tempat Lahir / Birth Place");
        jPanel1.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 30));

        jSeparator36.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator36, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 760, 650, 20));

        jLabel110.setText("Tanggal Lahir / Birth Date");
        jPanel1.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 30));

        jLabel111.setText("No Handphone");
        jPanel1.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, 30));

        jLabel112.setText("Status Pernikahan / \nMarital Status");
        jPanel1.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 20));

        jLabel113.setText("No BPJS");
        jPanel1.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, 30));

        jLabel114.setText("Email");
        jPanel1.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, 30));

        jLabel115.setText("Jenis Kelamin / Gender");
        jPanel1.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));
        jPanel1.add(jSeparator37, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 40, 20));

        jLabel116.setText("Tempat Tinggal saat ini / Current Address");
        jPanel1.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, 20));
        jPanel1.add(jSeparator38, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 320, 50, 20));

        jLabel117.setText("Negara / Country");
        jPanel1.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, -1, 20));

        jLabel118.setText("Provinsi / Province");
        jPanel1.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, -1, 30));

        jLabel119.setText("Kota / City");
        jPanel1.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 530, -1, 30));
        jPanel1.add(jSeparator39, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 80, 20));
        jPanel1.add(jSeparator40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 50, 20));

        jLabel120.setText("Alamat Rumah / Home Address");
        jPanel1.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, 20));

        jLabel121.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel121.setText("1. Data Diri / Personal Information");
        jPanel1.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 300, 30));

        jSeparator41.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator41, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 540, 20));

        jLabel122.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel122.setText("3. Status Keluarga");
        jPanel1.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 990, 160, 30));

        jSeparator42.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator42, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 1010, 680, 20));

        jLabel123.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel123.setText("4. Sertifikat Resmi Keahlian");
        jPanel1.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1220, 250, 30));

        jSeparator43.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator43, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1240, 600, 20));

        jSeparator44.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator44, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1480, 630, 20));

        jLabel124.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel124.setText("5. Ringkasan Status Karir");
        jPanel1.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1460, 230, 30));

        jLabel125.setText("1. Motivasi untuk Melamar");
        jPanel1.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1750, 350, 30));

        jSeparator45.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator45, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 1730, 430, 20));

        jLabel126.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel126.setText("6. Pengenalan diri untuk bergabung degan kami");
        jPanel1.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1710, 440, 30));

        jLabel127.setText("2. Lainnya (Kepribadian/Latar Belakang Keluarga)");
        jPanel1.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1930, 350, 30));

        jSeparator46.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator46, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 2140, 720, 20));

        jLabel128.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel128.setText("7. SKCK Asli");
        jPanel1.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 2120, 120, 30));
        jPanel1.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 2310, 280, 40));
        jPanel1.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 2290, 280, 30));

        jLabel131.setText("No NPWP");
        jPanel1.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, 30));

        jLabel132.setText("Alamat / Address");
        jPanel1.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, 30));

        jLabel133.setText("Desa / Vilage");
        jPanel1.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 570, 80, 30));

        jLabel134.setText("Posisi Yang Dilamar /Job Applying");
        jPanel1.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, 20));

        jLabel135.setText("Estimasi Gaji / Sallary");
        jPanel1.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, -1));

        jButton8.setText("test b academi");
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 980, -1, -1));

        jLabel136.setText("Negara / Country");
        jPanel1.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, 20));

        jLabel137.setText("Alamat / Address");
        jPanel1.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, 30));

        jLabel138.setText("Provinsi / Province");
        jPanel1.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, 30));

        jLabel139.setText("Kota / City");
        jPanel1.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, 30));

        jLabel140.setText("Desa / Vilage");
        jPanel1.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 80, 30));

        jScrollPane18.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void t_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_namaActionPerformed

    private void t_namaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_namaKeyTyped
        if (t_nama.getText().length()>25){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_namaKeyTyped

    private void homeCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeCityActionPerformed

    private void homeCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeCountryActionPerformed
      Connection myConn;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM states WHERE country_name ='" + homeCountry.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                homeState.addItem(myRess.getString("name"));
            }
//            myRess.last();
//            int jumlahdata = myRess.getRow();
//            myRess.first();

        } catch (SQLException ex) {
        }

    }//GEN-LAST:event_homeCountryActionPerformed

    private void homeStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeStateActionPerformed
       Connection myConn;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM states WHERE country_name ='" + homeCountry.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                homeState.addItem(myRess.getString("name"));
            }
//            myRess.last();
//            int jumlahdata = myRess.getRow();
//            myRess.first();

        } catch (SQLException ex) {
        }


    }//GEN-LAST:event_homeStateActionPerformed

    private void t_hpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_hpKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) ||(c==KeyEvent.VK_DELETE))){
            evt.consume();
        }
        if (t_hp.getText().length()>13){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_hpKeyTyped

    private void t_priaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_priaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_priaActionPerformed

    private void cprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cprovActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cprovActionPerformed

    private void jTable2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable2InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2InputMethodTextChanged

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        jToggleButton1.setEnabled(true);             // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        t_pria.setActionCommand("Laki - laki");
        t_wanita.setActionCommand("Perempuan");
        t_lajang.setActionCommand("Laki - laki");
        t_menikah.setActionCommand("Perempuan");

        String g_nama = t_nama.getText();
        String g_ktp = t_ktp.getText();
        String g_gender = radioGrupGender.getSelection().getActionCommand();
        String g_status = radioGrupStatus.getSelection().getActionCommand();
        String g_tlahir = t_tlhir.getText();
        String g_tgl = String.valueOf(fm.format(t_tgl.getDate()));
        String g_hp = t_hp.getText();
        String g_email = t_email.getText();
        String g_bpjs = t_bpjs.getText();
        String g_npwp = t_npwp.getText();
        String g_lamaran = (String) t_lamaran.getSelectedItem();
        String g_gaji = t_gaji.getText();

        String g_hnegara = (String) homeCountry.getSelectedItem();
        String g_hprov = (String) homeState.getSelectedItem();
        String g_hkota = (String) homeCity.getSelectedItem();
        String g_cnegara = (String) curentCountry.getSelectedItem();
        String g_cprov = (String) cprov.getSelectedItem();
        String g_ckota = (String) ccity.getSelectedItem();
        String g_hdesa = t_ddesa.getText();
        String g_cdesa = t_cdesa.getText();
        String g_halamat = t_halamat.getText();
        String g_calamat = t_calamat.getText();

        try {
            stm = koneksi.createStatement();
            String sql = "insert into cd_employee (nama,KTP,email,NPWP,sex,b_place,birthday,marital,No_HP,BPJS,Applying_A,D_Salary) values('" + g_nama + "'"
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
            + ",'" + g_gaji + "')";

            stm.executeUpdate(sql);

            try {
                Statement stm = koneksi.createStatement();

                rs = stm.executeQuery("select*from cd_employee where KTP like '%" + t_ktp.getText() + "%'");
                while (rs.next()) {
                    da = rs.getString("id_employee");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String sql0 = "insert into cd_adress (id_employee,h_negara,h_prov,h_kab,h_desa,h_alamat,c_negara,c_prov,c_kab,c_desa,c_alamat) values('" + da + "'"
            + ",'" + g_hnegara + "'"
            + ",'" + g_hprov + "'"
            + ",'" + g_hkota + "'"
            + ",'" + g_hdesa + "'"
            + ",'" + g_halamat + "'"
            + ",'" + g_cnegara + "'"
            + ",'" + g_cprov + "'"
            + ",'" + g_ckota + "'"
            + ",'" + g_cdesa + "'"
            + ",'" + g_calamat + "')";

            stm.executeUpdate(sql0);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }

        jTable2.editCellAt(0, 0);
        DefaultTableModel ImportDataExel = (DefaultTableModel) jTable2.getModel();
        int jtabelrows = jTable2.getRowCount();

        for (int i = 0; i <= jtabelrows - 1; i++) {
            if(jTable2.getValueAt(i,0) == null ){

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
                }}

            }

            simpan_family();
            simpan_serifikat();
            simpan_career();
            simpan_motivation();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
            this.dispose();

            // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void t_cdesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cdesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cdesaActionPerformed

    private void jCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxActionPerformed
        cprov.setSelectedItem(homeState.getSelectedItem());
        ccity.setSelectedItem(homeCity.getSelectedItem());
        t_calamat.setText(t_halamat.getText());
        t_cdesa.setText(t_ddesa.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxActionPerformed

    private void curentCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curentCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_curentCountryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ccity;
    private javax.swing.JComboBox<String> cprov;
    private javax.swing.JComboBox<String> curentCountry;
    private javax.swing.JComboBox<String> homeCity;
    private javax.swing.JComboBox<String> homeCountry;
    private javax.swing.JComboBox<String> homeState;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
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
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
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
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator38;
    private javax.swing.JSeparator jSeparator39;
    private javax.swing.JSeparator jSeparator40;
    private javax.swing.JSeparator jSeparator41;
    private javax.swing.JSeparator jSeparator42;
    private javax.swing.JSeparator jSeparator43;
    private javax.swing.JSeparator jSeparator44;
    private javax.swing.JSeparator jSeparator45;
    private javax.swing.JSeparator jSeparator46;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.ButtonGroup radioGrupGender;
    private javax.swing.ButtonGroup radioGrupStatus;
    private javax.swing.JTextField t_bpjs;
    private javax.swing.JTextArea t_calamat;
    private javax.swing.JTextField t_cdesa;
    private javax.swing.JTextField t_ddesa;
    private javax.swing.JTextField t_email;
    private javax.swing.JTextField t_gaji;
    private javax.swing.JTextArea t_halamat;
    private javax.swing.JTextField t_hp;
    private javax.swing.JTextField t_ktp;
    private javax.swing.JRadioButton t_lajang;
    private javax.swing.JComboBox<String> t_lamaran;
    private javax.swing.JRadioButton t_menikah;
    private javax.swing.JTextField t_nama;
    private javax.swing.JTextField t_npwp;
    private javax.swing.JRadioButton t_pria;
    private com.toedter.calendar.JDateChooser t_tgl;
    private javax.swing.JTextField t_tlhir;
    private javax.swing.JRadioButton t_wanita;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
