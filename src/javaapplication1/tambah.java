package javaapplication1;

import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hi
 */
public class tambah extends javax.swing.JFrame {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    DefaultTableModel ImportDataExel;

    /**
     * Creates new form MainApp
     */
    public tambah() {
        initComponents();
        openDB();
        tampil();
        currentBox();
        id_employee();
        jToggleButton1.setEnabled(false);

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

        radioGrupStatus = new javax.swing.ButtonGroup();
        radioGrupGender = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        t_nama = new javax.swing.JTextField();
        t_ktp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        t_tlhir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        homeCity = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        homeCountry = new javax.swing.JComboBox<>();
        homeState = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        t_bpjs = new javax.swing.JTextField();
        t_email = new javax.swing.JTextField();
        t_hp = new javax.swing.JTextField();
        t_wanita = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        t_pria = new javax.swing.JRadioButton();
        t_menikah = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        t_lajang = new javax.swing.JRadioButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cprov = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        ccity = new javax.swing.JComboBox<>();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jSeparator17 = new javax.swing.JSeparator();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel30 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel29 = new javax.swing.JLabel();
        t_gaji = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        t_halamat = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        t_calamat = new javax.swing.JTextArea();
        t_ddesa = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        t_cdesa = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        t_tgl = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        curentCountry = new javax.swing.JComboBox<>();
        t_lamaran = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        t_npwp = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setAutoscrolls(true);

        jPanel1.setAutoscrolls(true);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("2. Riwayat Pendidikan");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 740, -1, 30));

        jLabel3.setText("Nama");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 30));

        jLabel4.setText("No KTP");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 30));

        t_nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_namaKeyTyped(evt);
            }
        });
        jPanel1.add(t_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 190, -1));

        t_ktp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_ktpKeyTyped(evt);
            }
        });
        jPanel1.add(t_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 190, -1));

        jLabel5.setText("Tempat Lahir");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 30));

        t_tlhir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_tlhirKeyTyped(evt);
            }
        });
        jPanel1.add(t_tlhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 190, -1));

        jLabel6.setText("Alamat");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, 30));

        homeCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeCityActionPerformed(evt);
            }
        });
        jPanel1.add(homeCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 190, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 760, 650, 20));

        jLabel7.setText("Tanggal Lahir");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 30));

        jLabel8.setText("Negara");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, 30));

        jLabel9.setText("Provinsi");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, 30));

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

        jLabel10.setText("No Handphone");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, 30));

        jLabel11.setText("Status Pernikahan");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, 30));

        jLabel12.setText("No BPJS");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, 30));

        t_bpjs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_bpjsKeyTyped(evt);
            }
        });
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
        jPanel1.add(t_wanita, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        jLabel14.setText("Email");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, 30));

        radioGrupGender.add(t_pria);
        t_pria.setSelected(true);
        t_pria.setText("Pria");
        jPanel1.add(t_pria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        radioGrupStatus.add(t_menikah);
        t_menikah.setText("Sudah Menikah");
        jPanel1.add(t_menikah, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        jLabel15.setText("Jenis Kelamin");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 30));

        radioGrupStatus.add(t_lajang);
        t_lajang.setSelected(true);
        t_lajang.setText("Lajang");
        jPanel1.add(t_lajang, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 80, 20));

        jLabel16.setText("Tempat Tinggal saat ini");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, -1, 30));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 320, 70, 20));

        jLabel17.setText("Negara");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, -1, 30));

        jLabel18.setText("Provinsi");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, -1, 30));

        cprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cprovActionPerformed(evt);
            }
        });
        jPanel1.add(cprov, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 190, -1));

        jLabel19.setText("Kota / Daerah");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 530, -1, 30));

        jPanel1.add(ccity, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 530, 190, -1));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 100, 20));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 100, 20));

        jLabel20.setText("Alamat Rumah");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setText("1. Data Diri");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 30));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 740, 20));

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
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1270, 850, 170));

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
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2.setShowHorizontalLines(true);
        jTable2.setShowVerticalLines(true);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable2InputMethodTextChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 790, 850, 170));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setText("3. Status Keluarga");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 990, 160, 30));

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 1010, 680, 20));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setText("4. Sertifikat Resmi Keahlian");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1220, 250, 30));

        jSeparator13.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1240, 600, 20));

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
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable3);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1040, 850, 170));

        jSeparator14.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1480, 630, 20));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel24.setText("5. Ringkasan Status Karir");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1460, 230, 30));

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
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable4);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1520, 850, 170));

        jLabel26.setText("1. Motivasi untuk Melamar");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1750, 350, 30));

        jSeparator16.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 1730, 430, 20));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane6.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1780, 800, 130));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel27.setText("6. Pengenalan diri untuk bergabung degan kami");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1710, 440, 30));

        jLabel28.setText("2. Lainnya (Kepribadian/Latar Belakang Keluarga)");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1930, 350, 30));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane7.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1960, 800, 130));

        jSeparator17.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 2140, 720, 20));

        jCheckBox1.setText("Saya menjamin bahwa seluruh uraian di atas adalah benar");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 2200, -1, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel30.setText("7. SKCK Asli");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 2120, 120, 30));
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 2320, 280, 30));
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 2290, 280, 30));

        jToggleButton1.setText("SIMPAN");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 2260, 90, 40));

        jLabel29.setText("No NPWP");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, 30));

        t_gaji.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_gajiKeyTyped(evt);
            }
        });
        jPanel1.add(t_gaji, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 190, -1));

        t_halamat.setColumns(20);
        t_halamat.setRows(5);
        jScrollPane8.setViewportView(t_halamat);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        jLabel25.setText("Kota / Daerah");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, 30));

        jLabel34.setText("Alamat");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, 30));

        t_calamat.setColumns(20);
        t_calamat.setRows(5);
        jScrollPane9.setViewportView(t_calamat);

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, -1, -1));

        t_ddesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_ddesaActionPerformed(evt);
            }
        });
        jPanel1.add(t_ddesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 190, -1));

        jLabel35.setText("Desa");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, -1, 30));

        t_cdesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cdesaActionPerformed(evt);
            }
        });
        jPanel1.add(t_cdesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 570, 190, -1));

        jLabel37.setText("Desa");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 570, -1, 30));

        jCheckBox2.setText("Sama dengan alamat Rumah");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 630, -1, -1));
        jPanel1.add(t_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 170, -1));

        jLabel31.setText("Negara");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, -1, 30));

        curentCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indonesia" }));
        curentCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curentCountryActionPerformed(evt);
            }
        });
        jPanel1.add(curentCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 190, -1));

        t_lamaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(t_lamaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 190, -1));

        jLabel1.setText("Posisi Yang Dilamar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, -1));

        jLabel13.setText("Estimasi Gaji");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, -1));
        jPanel1.add(t_npwp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 190, -1));

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));
        jPanel2.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, -1, -1));

        jButton1.setText("Ambil Foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 690, -1, -1));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String currentdirectory = "C:\\Users\\USER\\Pictures";
        JFileChooser imageFileChooser = new JFileChooser(currentdirectory);
        int imagechooser = imageFileChooser.showOpenDialog(null);
        imageFileChooser.showOpenDialog(null);
        imageFileChooser.setDialogTitle("Pilih gambar...");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","png","jpg","jpeg");
        imageFileChooser.setFileFilter(fnef);

        if (imagechooser == JFileChooser.APPROVE_OPTION){

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void curentCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curentCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_curentCountryActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        cprov.setSelectedItem(homeState.getSelectedItem());
        ccity.setSelectedItem(homeCity.getSelectedItem());
        t_calamat.setText(t_halamat.getText());
        t_cdesa.setText(t_ddesa.getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void t_cdesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cdesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cdesaActionPerformed

    private void t_ddesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_ddesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_ddesaActionPerformed

    private void t_gajiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_gajiKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) ||(c==KeyEvent.VK_DELETE))){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_gajiKeyTyped

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // simpan data diri
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

        //simpan academic
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
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        jToggleButton1.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jTable2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable2InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2InputMethodTextChanged

    private void cprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cprovActionPerformed
        Connection myConn;
        try {
            ccity.removeAllItems();
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM cities WHERE state_name ='" + cprov.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                ccity.addItem(myRess.getString("name"));
            }
            //            myRess.last();
            //            int jumlahdata = myRess.getRow();
            //            myRess.first();

        } catch (SQLException ex) {
        }     // TODO add your handling code here:
    }//GEN-LAST:event_cprovActionPerformed

    private void t_hpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_hpKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) ||(c==KeyEvent.VK_DELETE))){
            evt.consume();
        }
        if (t_hp.getText().length()>13){
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_t_hpKeyTyped

    private void t_bpjsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_bpjsKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) ||(c==KeyEvent.VK_DELETE))){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_bpjsKeyTyped

    private void homeStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeStateActionPerformed
        Connection myConn;
        try {
            homeCity.removeAllItems();
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            ResultSet myRess = myConn.createStatement().executeQuery("SELECT * FROM cities WHERE state_name ='" + homeState.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                homeCity.addItem(myRess.getString("name"));
            }
            //            myRess.last();
            //            int jumlahdata = myRess.getRow();
            //            myRess.first();

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
            //            myRess.last();
            //            int jumlahdata = myRess.getRow();
            //            myRess.first();

        } catch (SQLException ex) {
        }

    }//GEN-LAST:event_homeCountryActionPerformed

    private void homeCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeCityActionPerformed

    private void t_tlhirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_tlhirKeyTyped
        if (t_tlhir.getText().length()>20){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_tlhirKeyTyped

    private void t_ktpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_ktpKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) ||(c==KeyEvent.VK_DELETE))){
            evt.consume();
        }
        if (t_ktp.getText().length()>16){
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_t_ktpKeyTyped

    private void t_namaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_namaKeyTyped
        if (t_nama.getText().length()>25){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_namaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tambah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ccity;
    private javax.swing.JComboBox<String> cprov;
    private javax.swing.JComboBox<String> curentCountry;
    private javax.swing.JComboBox<String> homeCity;
    private javax.swing.JComboBox<String> homeCountry;
    private javax.swing.JComboBox<String> homeState;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
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

}
