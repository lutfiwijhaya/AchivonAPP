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
import Employee.ChangePassword;
import Employee.EmployeeProfilePanel;
import Main.MasterForm;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.table.DefaultTableModel;

public class CandidateApplicationPersonal extends MasterForm{
 Statement stm;
    ResultSet rs;
    Connection koneksi;
    ResultSet rsf;
    DefaultTableModel ImportDataExel;
    String crudimage = "";
    String da = null;
    int id_employee;
    String tanggal;
    private static String g_nama;
    private static String g_ktp;
    private static String g_gender;
    private static String g_status;
    private static String g_tlahir;
    private static String g_tgl;
    private static String g_hp;
    private static String g_email;
    private static String g_bpjsket;
    private static String g_bpjskes;
    private static String g_npwp;
    private static String g_lamaran;
    private static String g_gaji;
    private static String g_discipline;

    private static String g_hnegara;
    private static String g_hprov;
    private static String g_hkota;
    private static String g_cnegara;
    private static String g_cprov;
    private static String g_ckota;
    private static String g_hkec;
    private static String g_ckec;
    private static String g_hdesa;
    private static String g_cdesa;
    private static String g_halamat;
    private static String g_calamat;
    private static String sp = ", ";
    private static String full_curent;
    private static String full_home;
   
    public CandidateApplicationPersonal() {
        initComponents();
        openDB();
        tampil();
        MyWindow();
        currentBox();
        id_employee();
//        jToggleButton1.setEnabled(false);
        get_tanggal();
        jScrollPane18.getVerticalScrollBar().setUnitIncrement(16);
       t_hp.setText("(0)");
     
    }

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
//            myRess.last();
//            int jumlahdata = myRess.getRow();
//            myRess.first();

        } catch (SQLException ex) {
        }

        homeCountry.setEnabled(true);

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
//            myRess.last();
//            int jumlahdata = myRess.getRow();
//            myRess.first();

        } catch (SQLException ex) {
        }
        curentCountry.setEnabled(true);
    }
    
     public class func{
    public ResultSet find (String s){
        try {
            PreparedStatement st = koneksi.prepareStatement("select * from cd_foto where id = ?");
            st.setString(1, s);
            rsf=st.executeQuery();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CandidateApplicationPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
    return rsf;
    
    }
    
    
    
    }
    
    
    
    

    public static String get_nama() {
        return g_nama;
    }

    public static String get_ktp() {
        return g_ktp;
    }

    public static String get_gender() {
        return g_gender;
    }

    public static String get_status() {
        return g_status;
    }

    public static String get_tlahir() {
        return g_tlahir;
    }

    public static String get_tgl() {
        return g_tgl;
    }

    public static String get_hp() {
        return g_hp;
    }

    public static String get_email() {
        return g_email;
    }

    public static String get_bpjsket() {
        return g_bpjsket;
    }

    public static String get_bpjskes() {
        return g_bpjskes;
    }

    public static String get_npwp() {
        return g_npwp;
    }

    public static String get_lamaran() {
        return g_lamaran;
    }

    public static String get_gaji() {
        return g_gaji;
    }

    public static String get_discipline() {
        return g_discipline;
    }

    public static String get_hnegara() {
        return g_hnegara;
    }

    public static String get_hprov() {
        return g_hprov;
    }

    public static String get_hkota() {
        return g_hkota;
    }

    public static String get_cnegara() {
        return g_cnegara;
    }

    public static String get_cprov() {
        return g_cprov;
    }

    public static String get_ckota() {
        return g_ckota;
    }

    public static String get_hkec() {
        return g_hkec;
    }

    public static String get_ckec() {
        return g_ckec;
    }

    public static String get_hdesa() {
        return g_hdesa;
    }

    public static String get_cdesa() {
        return g_cdesa;
    }

    public static String get_halamat() {
        return g_halamat;
    }

    public static String get_calamat() {
        return g_calamat;
    }

    public static String get_full_curent() {
        return full_curent;
    }

    public static String get_full_home() {
        return full_home;
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel98 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel75.setText("Tanggal Lahir / Birth Date");
        jPanel1.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, -1, 40));

        jLabel77.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel77.setText("Status Pernikahan / Marital Status");
        jPanel1.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, -1, 20));

        jLabel80.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel80.setText("Jenis Kelamin / Gender");
        jPanel1.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 120, 20));
        jPanel1.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, 40, 20));

        jLabel81.setText("Tempat Tinggal saat ini / Current Address");
        jPanel1.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, -1, 20));
        jPanel1.add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 490, 50, 20));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel82.setText("Negara / Country");
        jPanel1.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 540, -1, 30));

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel83.setText("Provinsi / Province");
        jPanel1.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 580, -1, 30));

        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel84.setText("Kota / City");
        jPanel1.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 620, -1, 30));
        jPanel1.add(jSeparator28, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 490, 80, 20));
        jPanel1.add(jSeparator29, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, 50, 20));

        jLabel85.setText("Alamat Rumah / Home Address");
        jPanel1.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, -1, 20));

        jLabel86.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel86.setText("1. Data Diri / Personal Information");
        jPanel1.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 200, 30));

        jSeparator30.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator30, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 640, 20));

        t_halamat.setColumns(20);
        t_halamat.setRows(5);
        jScrollPane25.setViewportView(t_halamat);

        jPanel1.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 740, 210, -1));

        jLabel97.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jPanel1.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 1070, 100, 30));

        t_calamat.setColumns(20);
        t_calamat.setRows(5);
        jScrollPane26.setViewportView(t_calamat);

        jPanel1.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 770, 190, -1));

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

        t_tgl.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(t_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 442, 190, 30));

        jLabel101.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel101.setText("Negara / Country");
        jPanel1.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, -1, 20));

        jLabel102.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel102.setText("Alamat / Address");
        jPanel1.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 730, -1, 30));

        jLabel103.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel103.setText("Provinsi / Province");
        jPanel1.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, -1, 30));

        jLabel104.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel104.setText("Kota / City");
        jPanel1.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 590, -1, 30));

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
        t_ktp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_ktpKeyTyped(evt);
            }
        });
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
        jPanel1.add(t_hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 340, -1));

        t_email.setLabelText("Email");
        t_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_emailActionPerformed(evt);
            }
        });
        jPanel1.add(t_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 340, -1));

        t_bpjsKetenagakerjaan.setLabelText("No BPJS Ketenagakerjaan");
        t_bpjsKetenagakerjaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_bpjsKetenagakerjaanKeyTyped(evt);
            }
        });
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

        curentCountry.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        curentCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curentCountryActionPerformed(evt);
            }
        });
        jPanel1.add(curentCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 540, 190, 30));

        cprov.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cprovActionPerformed(evt);
            }
        });
        jPanel1.add(cprov, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 580, 190, -1));

        ccity.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
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

        homeCountry.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        homeCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeCountryActionPerformed(evt);
            }
        });
        jPanel1.add(homeCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 190, 30));

        homeState.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        homeState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeStateActionPerformed(evt);
            }
        });
        jPanel1.add(homeState, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 190, 30));

        homeCity.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
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
        jPanel1.add(t_hkec, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 630, 320, -1));

        t_ddesa.setLabelText("Desa / Vilage");
        t_ddesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_ddesaActionPerformed(evt);
            }
        });
        jPanel1.add(t_ddesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 680, 320, -1));

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

        t_lamaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "test" }));
        t_lamaran.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
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

        jButton2.setText("Kembali / Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 990, 130, 30));

        jButton3.setText("Lanjut / Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 990, 130, 30));

        jLabel98.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel98.setText("Alamat / Address");
        jPanel1.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 770, 100, 30));

        jScrollPane18.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE))
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
        t_cdesa.setText(t_ddesa.getText());       // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxActionPerformed

    private void t_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_emailActionPerformed

    private void t_hpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_hpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_hpActionPerformed

    private void t_hpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_hpKeyTyped
        String a ;
        String b = "-";
        if(t_hp.getText().length()<3){
            t_hp.setText("(0)");
        }else if (t_hp.getText().length() == 6) {
            t_hp.setText(t_hp.getText()+"-");
        }else if(t_hp.getText().length() == 7){
StringBuffer sb = new StringBuffer(t_hp.getText());
       sb.setLength(6); 
       t_hp.setText(""+sb);
        }else if(t_hp.getText().length() == 11){
            t_hp.setText(t_hp.getText()+"-");
        }else if(t_hp.getText().length() == 12){
           StringBuffer sb = new StringBuffer(t_hp.getText());
       sb.setLength(11); 
       t_hp.setText(""+sb);
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
            //            myRess.last();
            //            int jumlahdata = myRess.getRow();
            //            myRess.first();

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
char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) ||(c==KeyEvent.VK_DELETE))){
            evt.consume();
        }//        asd
    }//GEN-LAST:event_t_bpjsKesehatanKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        t_pria.setActionCommand("Laki - laki");
        t_wanita.setActionCommand("Perempuan");
        t_lajang.setActionCommand("Lajang");
        t_menikah.setActionCommand("Menikah");
        g_nama = t_nama.getText();
        g_ktp = t_ktp.getText();
        g_gender = radioGrupGender.getSelection().getActionCommand();
        g_status = radioGrupStatus.getSelection().getActionCommand();
        g_tlahir = t_tlhir.getText();
        g_tgl = String.valueOf(fm.format(t_tgl.getDate()));
        g_hp = t_hp.getText();
        g_email = t_email.getText();
        g_bpjsket = t_bpjsKetenagakerjaan.getText();
        g_bpjskes = t_bpjsKesehatan.getText();
        g_npwp = t_npwp.getText();
        g_lamaran = (String) t_lamaran.getSelectedItem();
        g_gaji = t_gaji.getText();
        g_discipline = t_dicipline.getText();

        g_hnegara = (String) homeCountry.getSelectedItem();
        g_hprov = (String) homeCity.getSelectedItem();
        g_hkota = (String) homeCity.getSelectedItem();
        g_cnegara = (String) curentCountry.getSelectedItem();
        g_cprov = (String) cprov.getSelectedItem();
        g_ckota = (String) ccity.getSelectedItem();
        g_hkec = t_hkec.getText();
        g_ckec = t_ckec.getText();
        g_hdesa = t_ddesa.getText();
        g_cdesa = t_cdesa.getText();
        g_halamat = t_halamat.getText();
        g_calamat = t_calamat.getText();

        full_curent = g_calamat + sp + g_cdesa + sp + g_ckec + sp + g_ckota + sp + g_cprov + sp + g_cnegara;
        full_home = g_halamat + sp + g_hdesa + sp + g_hkec + sp + g_hkota + sp + g_hprov + sp + g_hnegara;
         File foto = new File(crudimage);
      

        Main.main.getMain().showForm(new CandidateApplicationAcademic());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void t_ktpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_ktpKeyTyped
char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) ||(c==KeyEvent.VK_DELETE))){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_ktpKeyTyped

    private void t_bpjsKetenagakerjaanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_bpjsKetenagakerjaanKeyTyped
char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) ||(c==KeyEvent.VK_DELETE))){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_bpjsKetenagakerjaanKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.ComboBoxSuggestion ccity;
    private CustomResource.ComboBoxSuggestion cprov;
    private CustomResource.ComboBoxSuggestion curentCountry;
    private CustomResource.ComboBoxSuggestion homeCity;
    private CustomResource.ComboBoxSuggestion homeCountry;
    private CustomResource.ComboBoxSuggestion homeState;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator41;
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
    }
}
