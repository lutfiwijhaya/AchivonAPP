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
import Main.MainPanel;
import Main.MasterForm;
import Main.NewJPanel;
import Main.main;
import com.mysql.cj.jdbc.Blob;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;
import jxl.write.DateTime;

public class CandidateApplicationedit extends MasterForm {

    Statement stm;
    ResultSet rs;
    ResultSet rsf;
    Connection koneksi;
    DefaultTableModel ImportDataExel;
    String crudimage = "p";
    String da = MySession.get_cd_ktp();
    int id_employee;
    String tanggal;
    String sp = ", ";
    String full_curent;
    String full_home;
    int k = 0;
    String jk;
    String stt;
    byte[] img;

    public CandidateApplicationedit() {
        initComponents();
        openDB();
        tampil();
        MyWindow();
        currentBox();
        codeCountryBox();
        id_employee();
//        jToggleButton1.setEnabled(false);
        get_tanggal();
        jScrollPane18.getVerticalScrollBar().setUnitIncrement(16);
        homeCountry.setSelectedItem("Indonesia");
        curentCountry.setSelectedItem("Indonesia");
        tampil_academic();
        tampildata();

        jPanel1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                try {
                    CandidateApplicationedit.func f = new CandidateApplicationedit.func();
                    rsf = f.find(da);
                    if (rsf.next()) {
                        byte[] img = rsf.getBytes("foto");

                        ImageIcon imageicon = new ImageIcon(img);

                        Image imageResize = imageicon.getImage().getScaledInstance(labelfoto.getWidth(), labelfoto.getHeight(), Image.SCALE_SMOOTH);
                        labelfoto.setIcon(new ImageIcon(imageResize));
                    }
                } catch (Exception er) {
                }
            }
        });

    }

    private DefaultTableModel getSubTableDataAcademic() {
        DefaultTableModel data = new DefaultTableModel();
//        DefaultTableModel data1 = new DefaultTableModel();
        data.setColumnCount(2);
        data.addRow(new Object[]{new CustomResource.Header("Provinsi / Province", 100), new CustomResource.Header("Kota / City")});
        data.addRow(new Object[]{"Banten", "Kota Serang"});
        data.addRow(new Object[]{"Banten", "Kota Serang"});
        data.addRow(new Object[]{"Banten", "Kota Serang"});
        data.addRow(new Object[]{"Banten", "Kota Serang"});
//        data1.addRow(new Object[]{"Ban", "Kota "});
//        data.addRow(new Object[]{1, "Vital", "$ 70", getSubTableData1()});
//        data.addRow(new Object[]{1, "Fanta", "$ 20", getSubTableData1()});
//        data.addRow(new Object[]{1, "Coca", getSubTableData1(), getSubTableData1()});
        return data;
    }

    private DefaultTableModel getSubTableDataFamily() {
        DefaultTableModel data = new DefaultTableModel();
        data.setColumnCount(2);
        data.addRow(new Object[]{new CustomResource.Header("YA / YES", 100), new CustomResource.Header("TIDAK / NO")});
        data.addRow(new Object[]{"YA / YES", ""});
//        data.addRow(new Object[]{1, "Vital", "$ 70", getSubTableData1()});
//        data.addRow(new Object[]{1, "Fanta", "$ 20", getSubTableData1()});
//        data.addRow(new Object[]{1, "Coca", getSubTableData1(), getSubTableData1()});
        return data;
    }

    private DefaultTableModel getSubTableDataCertificate() {
        DefaultTableModel data = new DefaultTableModel();
        data.setColumnCount(2);
        data.addRow(new Object[]{new CustomResource.Header("Provinsi / Province", 100), new CustomResource.Header("Kota / City")});
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
        data.addRow(new Object[]{new CustomResource.Header("Dari Tanggal / Start Date", 100), new CustomResource.Header("Sampai Tanggal / End Date")});
        data.addRow(new Object[]{"1-jan-1999", "1-jan-2000"});
//        data.addRow(new Object[]{1, "Vital", "$ 70", getSubTableData1()});
//        data.addRow(new Object[]{1, "Fanta", "$ 20", getSubTableData1()});
//        data.addRow(new Object[]{1, "Coca", getSubTableData1(), getSubTableData1()});
        return data;
    }

    void tablec() {
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        model2.addRow(new Object[]{"22-OKT-2022", "Universitas Serang Raya", getSubTableDataAcademic(), "Sistem Informasi"});
        model2.addRow(new Object[]{"22-OKT-2022", "Serang Raya", getSubTableDataAcademic(), "Sistem Informasi"});
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

        ((DefaultTableCellRenderer) jTable2.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);

        ((DefaultTableCellRenderer) jTable3.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);

        ((DefaultTableCellRenderer) jTable4.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);

        ((DefaultTableCellRenderer) jTable5.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);

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
            } else {
                String dtabel_nama = jTable3.getValueAt(i, 0).toString();
                String dtabel_hub = jTable3.getValueAt(i, 1).toString();
                String dtabel_tgl = jTable3.getValueAt(i, 2).toString();
                String dtabel_tinggal = jTable3.getValueAt(i, 3).toString();
                String dtabel_hp = jTable3.getValueAt(i, 4).toString();
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
                String dtabel_autor = jTable4.getValueAt(i, 3).toString();
                String dtabel_lokasi = jTable4.getValueAt(i, 2).toString();
                String dtabel_no = jTable4.getValueAt(i, 4).toString();
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

        DefaultTableModel ImportDataExel = (DefaultTableModel) jTable5.getModel();
        int jtabelrows = jTable5.getRowCount();

        for (int i = 0; i <= jtabelrows - 1; i++) {
            if (jTable5.getValueAt(i, 0) == null) {
            } else {
                String dtabel_nama = jTable5.getValueAt(i, 0).toString();
                String dtabel_posisi = jTable5.getValueAt(i, 1).toString();
                String dtabel_period = jTable5.getValueAt(i, 2).toString();
                String dtabel_career = jTable5.getValueAt(i, 3).toString();
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
        String g_ta = t_motif.getText();
        String g_ta2 = t_latar.getText();
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

    void hapusdb() {
        try {
            stm = koneksi.createStatement();
            String sql1 = "DELETE FROM cd_motivation WHERE id_employee = " + da + "";
            String sql2 = "DELETE FROM cd_summary_career WHERE id_employee = " + da + "";
            String sql3 = "DELETE FROM cd_certificates WHERE id_employee = " + da + "";
            String sql4 = "DELETE FROM cd_family WHERE id_employee = " + da + "";
            String sql5 = "DELETE FROM cd_academic WHERE id_employee = " + da + "";

            stm.executeUpdate(sql1);
            stm.executeUpdate(sql2);
            stm.executeUpdate(sql3);
            stm.executeUpdate(sql4);
            stm.executeUpdate(sql5);

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
                // t_kodeNegara.addItem(myRess.getString("name") +" "+ myRess.getString("phone_code"));
            }
        } catch (SQLException ex) {
        }
        curentCountry.setEnabled(true);
    }

    void tampildata() {
        try {
            Statement stm = koneksi.createStatement();

            rs = stm.executeQuery("select*from cd_employee where id_employee = " + da + "");
            while (rs.next()) {
                t_lamaran.addItem(rs.getString("Applying_A"));
                t_lamaran.setSelectedItem(rs.getString("Applying_A"));
                t_gaji.setText(rs.getString("D_Salary"));
                t_dicipline.setText(rs.getString("discipline"));
                jk = rs.getString("sex");
                stt = rs.getString("marital");
                t_pria.setSelected(true);
                t_nama.setText(rs.getString("Nama"));
                t_ktp.setText(rs.getString("KTP"));
                t_tlhir.setText(rs.getString("b_place"));
                String b_d = (rs.getString("birthday"));
                SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
                Date det = fm.parse(b_d);
                t_tgl_personal.setDate(det);
                t_hp.setText(rs.getString("No_HP"));
                t_email.setText(rs.getString("email"));
                t_bpjsKesehatan.setText(rs.getString("BPJS"));
                t_bpjsKetenagakerjaan.setText(rs.getString("bpjs_ket"));
                t_npwp.setText(rs.getString("NPWP"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Statement stm = koneksi.createStatement();

            rs = stm.executeQuery("select*from cd_adress where id_employee = " + da + "");
            while (rs.next()) {

                homeCountry.setSelectedItem(rs.getString("h_negara"));
                homeState.setSelectedItem(rs.getString("h_prov"));
                homeCity.setSelectedItem(rs.getString("h_kab"));
                curentCountry.setSelectedItem(rs.getString("c_negara"));
                cprov.setSelectedItem(rs.getString("c_prov"));
                ccity.setSelectedItem(rs.getString("c_kab"));
                t_hkec.setText(rs.getString("h_kec"));
                t_ddesa.setText(rs.getString("h_desa"));
                t_halamat.setText(rs.getString("h_alamat"));
                t_ckec.setText(rs.getString("c_kec"));
                t_cdesa.setText(rs.getString("c_desa"));
                t_calamat.setText(rs.getString("c_alamat"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Statement stm = koneksi.createStatement();

            rs = stm.executeQuery("select*from cd_motivation where id_employee = " + da + "");
            while (rs.next()) {

                t_motif.setText(rs.getString("motivation1"));
                t_latar.setText(rs.getString("motivation2"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (jk.length() == 4) {
            t_pria.setSelected(true);
        } else {
            t_wanita.setSelected(true);
        }

        if (stt.length() == 6) {
            t_lajang.setSelected(true);
        } else {
            t_menikah.setSelected(true);
        }

    }

    void tampil_academic() {
        DefaultTableModel dataModel = (DefaultTableModel) jTable2.getModel();
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from cd_academic where id_employee = " + da + "");
            while (rs.next()) {
                String[] data = {
                    rs.getString("Graduation"), rs.getString("School_name"), rs.getString("location"), rs.getString("major"),};
                dataModel.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }

        DefaultTableModel dataModel1 = (DefaultTableModel) jTable3.getModel();
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from cd_family where id_employee = " + da + "");
            while (rs.next()) {
                String[] data = {
                    rs.getString("name"), rs.getString("hubungan"), rs.getString("Birthday"), rs.getString("cohabit"), rs.getString("No_HP")};
                dataModel1.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }

        DefaultTableModel dataModel2 = (DefaultTableModel) jTable4.getModel();
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from cd_certificates where id_employee = " + da + "");
            while (rs.next()) {
                String[] data = {
                    rs.getString("acquisition"), rs.getString("name_certificate"), rs.getString("location"), rs.getString("name_authority"), rs.getString("no_certificate")};
                dataModel2.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }

        DefaultTableModel dataModel3 = (DefaultTableModel) jTable5.getModel();
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from cd_summary_career where id_employee = " + da + "");
            while (rs.next()) {
                String[] data = {
                    rs.getString("company_name"), rs.getString("job_position"), rs.getString("period"), rs.getString("career"),};
                dataModel3.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }
    }

    void tampil_foto() {
        try {
            CandidateApplicationedit.func f = new CandidateApplicationedit.func();
            rsf = f.find(t_ktp.getText());
            if (rsf.next()) {
                img = rsf.getBytes("foto");

                ImageIcon imageicon = new ImageIcon(img);

                Image imageResize = imageicon.getImage().getScaledInstance(labelfoto.getWidth(), labelfoto.getHeight(), Image.SCALE_SMOOTH);
                labelfoto.setIcon(new ImageIcon(imageResize));

            }
        } catch (Exception e) {
        }
    }

    public class func {

        public ResultSet find(String s) {
            try {
                PreparedStatement st = koneksi.prepareStatement("select * from cd_foto where id_employee = ?");
                st.setString(1, s);
                rsf = st.executeQuery();

            } catch (SQLException ex) {
                Logger.getLogger(CandidateApplicationPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
            return rsf;

        }

    }

    //test
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
        buttongrup = new javax.swing.ButtonGroup();
        jScrollPane18 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel75 = new javax.swing.JLabel();
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
        t_motif = new javax.swing.JTextArea();
        jLabel91 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        t_latar = new javax.swing.JTextArea();
        jSeparator35 = new javax.swing.JSeparator();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel93 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane25 = new javax.swing.JScrollPane();
        t_halamat = new javax.swing.JTextArea();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        t_calamat = new javax.swing.JTextArea();
        jLabel99 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jSeparator41 = new javax.swing.JSeparator();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new CustomResource.TableCustom();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new CustomResource.TableCustom();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new CustomResource.TableCustom();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new CustomResource.TableCustom();
        jLabel76 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        t_wanita = new javax.swing.JRadioButton();
        t_pria = new javax.swing.JRadioButton();
        t_lajang = new javax.swing.JRadioButton();
        t_menikah = new javax.swing.JRadioButton();
        t_tgl_personal = new com.toedter.calendar.JDateChooser();
        jCheckBox1 = new javax.swing.JCheckBox();
        t_lokasi = new CustomResource.ComboBoxSuggestion();
        t_sekolah = new CustomResource.CustomTextfield();
        t_tgl = new com.toedter.calendar.JYearChooser();
        jLabel2 = new javax.swing.JLabel();
        t_jurusan = new CustomResource.CustomTextfield();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        r_y = new CustomResource.RadioButtonCustom();
        r_n = new CustomResource.RadioButtonCustom();
        jLabel3 = new javax.swing.JLabel();
        t_hp1 = new CustomResource.CustomTextfield();
        jButton3 = new javax.swing.JButton();
        t_tgl_family = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        t_hubungan = new CustomResource.ComboBoxSuggestion();
        jLabel5 = new javax.swing.JLabel();
        t_nama1 = new CustomResource.CustomTextfield();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        t_tgl_certificate = new com.toedter.calendar.JDateChooser();
        t_lokasi1 = new CustomResource.ComboBoxSuggestion();
        jLabel7 = new javax.swing.JLabel();
        t_nama2 = new CustomResource.CustomTextfield();
        t_author = new CustomResource.CustomTextfield();
        t_sertifikat = new CustomResource.CustomTextfield();
        jButton6 = new javax.swing.JButton();
        t_nama3 = new CustomResource.CustomTextfield();
        t_posisi = new CustomResource.CustomTextfield();
        jLabel8 = new javax.swing.JLabel();
        bulan_awal = new com.toedter.calendar.JMonthChooser();
        tahun_awal = new com.toedter.calendar.JYearChooser();
        jLabel9 = new javax.swing.JLabel();
        bulan_akhir = new com.toedter.calendar.JMonthChooser();
        tahun_akhir = new com.toedter.calendar.JYearChooser();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel71.setText("2. Riwayat Pendidikan / Academic");
        jPanel1.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 850, -1, 30));

        jSeparator25.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator25.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 870, 650, 20));

        jLabel75.setText("Tanggal Lahir / Birth Date : ");
        jPanel1.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, -1, 20));
        jPanel1.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, 40, 20));

        jLabel81.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel81.setText("Tempat Tinggal saat ini / Current Address");
        jPanel1.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, -1, 20));
        jPanel1.add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 460, 50, 20));

        jLabel82.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel82.setText("Negara / Country");
        jPanel1.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 510, -1, 30));

        jLabel83.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel83.setText("Provinsi / Province");
        jPanel1.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, -1, 30));

        jLabel84.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel84.setText("Kota / City");
        jPanel1.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, -1, 30));
        jPanel1.add(jSeparator28, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 80, 20));
        jPanel1.add(jSeparator29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 50, 20));

        jLabel85.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel85.setText("Alamat Rumah / Home Address");
        jPanel1.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, 20));

        jLabel86.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel86.setText("1. Data Diri / Personal Information");
        jPanel1.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 200, 30));

        jSeparator30.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator30, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 640, 20));

        jLabel87.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel87.setText("3. Status Keluarga / Family Status");
        jPanel1.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 1190, 200, 30));

        jSeparator31.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator31, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 1210, 650, 20));

        jLabel88.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel88.setText("4. Sertifikat Resmi Keahlian / Authorized Certificate Skill");
        jPanel1.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1550, 330, 30));

        jSeparator32.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator32.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator32, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 1570, 530, 20));

        jSeparator33.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator33.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator33, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 1920, 550, 20));

        jLabel89.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel89.setText("5. Ringkasan Status Karir / Summary of Carrer Status");
        jPanel1.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1900, 310, 30));

        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel90.setText("1. Motivasi untuk Melamar");
        jPanel1.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 2310, 350, 30));

        jSeparator34.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator34.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator34, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 2300, 570, 20));

        t_motif.setColumns(20);
        t_motif.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        t_motif.setRows(5);
        jScrollPane23.setViewportView(t_motif);

        jPanel1.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 2350, 800, 130));

        jLabel91.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel91.setText("6. Pengenalan diri untuk bergabung degan kami");
        jPanel1.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 2280, 440, 30));

        t_latar.setColumns(20);
        t_latar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        t_latar.setRows(5);
        jScrollPane24.setViewportView(t_latar);

        jPanel1.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 2550, 800, 130));

        jSeparator35.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator35, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 2720, 790, 20));

        jCheckBox5.setText("Saya menjamin bahwa seluruh uraian di atas adalah benar");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 2780, -1, -1));

        jLabel93.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel93.setText("7. SKCK");
        jPanel1.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 2700, 50, 30));

        jToggleButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jToggleButton1.setText("BACK/KEMBALI");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 2820, 120, 40));

        t_halamat.setColumns(20);
        t_halamat.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        t_halamat.setRows(5);
        jScrollPane25.setViewportView(t_halamat);

        jPanel1.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 740, 210, -1));

        jLabel97.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel97.setText("Alamat / Address");
        jPanel1.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 730, 100, 30));

        t_calamat.setColumns(20);
        t_calamat.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        t_calamat.setRows(5);
        jScrollPane26.setViewportView(t_calamat);

        jPanel1.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 730, 210, -1));

        jLabel99.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel99.setText("Posisi Yang Dilamar /Job Applying");
        jPanel1.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, 30));

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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("...");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 100, -1));

        labelfoto.setBackground(new java.awt.Color(255, 255, 204));
        labelfoto.setOpaque(true);
        jPanel1.add(labelfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 100, 90));

        t_nama.setLabelText("Nama / Name");
        jPanel1.add(t_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 340, -1));

        t_ktp.setLabelText("KTP No.");
        t_ktp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_ktpKeyReleased(evt);
            }
        });
        jPanel1.add(t_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 340, -1));

        t_tlhir.setLabelText("Tempat Lahir / Birth Place");
        jPanel1.add(t_tlhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 340, -1));

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
        jPanel1.add(t_hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 340, -1));

        t_email.setLabelText("Email");
        t_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_emailActionPerformed(evt);
            }
        });
        jPanel1.add(t_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 250, 340, -1));

        t_bpjsKetenagakerjaan.setLabelText("No BPJS Ketenagakerjaan");
        jPanel1.add(t_bpjsKetenagakerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, 340, -1));

        t_dicipline.setLabelText("Discipline");
        jPanel1.add(t_dicipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 340, -1));

        t_bpjsKesehatan.setLabelText("No BPJS Kesehatan");
        t_bpjsKesehatan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_bpjsKesehatanKeyTyped(evt);
            }
        });
        jPanel1.add(t_bpjsKesehatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 340, -1));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel94.setText("2. Lainnya (Kepribadian/Latar Belakang Keluarga)");
        jPanel1.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 2490, 350, 30));

        curentCountry.setEditable(false);
        curentCountry.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        curentCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curentCountryActionPerformed(evt);
            }
        });
        jPanel1.add(curentCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 510, 190, 30));

        cprov.setEditable(false);
        cprov.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cprovActionPerformed(evt);
            }
        });
        jPanel1.add(cprov, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 550, 190, -1));

        ccity.setEditable(false);
        ccity.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        ccity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccityActionPerformed(evt);
            }
        });
        jPanel1.add(ccity, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 590, 190, -1));

        t_ckec.setLabelText("Kecamatan / Districts");
        t_ckec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_ckecActionPerformed(evt);
            }
        });
        jPanel1.add(t_ckec, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 630, 310, -1));

        t_cdesa.setLabelText("Desa / Vilage");
        t_cdesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cdesaActionPerformed(evt);
            }
        });
        jPanel1.add(t_cdesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 680, 310, -1));

        homeCountry.setEditable(false);
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
        jPanel1.add(t_npwp, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, 340, -1));

        t_lamaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Test", " " }));
        t_lamaran.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        t_lamaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_lamaranActionPerformed(evt);
            }
        });
        jPanel1.add(t_lamaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 190, 30));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal Lulus / Graduation Date", "Nama Sekolah / School Name", "Lokasi / Location", "Jurusan / Major"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1070, 850, 100));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Anggota / Members Name", "Relation / Hubungan", "Tanggal lahir / Birthday", "Tinggal bersama / Cohabit", "No HP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1410, 850, 100));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Diakuisisi / Acquisition", "Nama Sertifikat / Sertifikat Name", "Nama Penyelenggara / Authority Name", "Lokasi / Location", "No Sertifikat / Certificate No."
            }
        ));
        jTable4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 1770, 850, 100));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Perusahaan / Company name", "Posisi Pekerjaan / Job Position", "Periode / Period", "Karir / Career"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(2).setPreferredWidth(280);
        }

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 2150, 850, 100));

        jLabel76.setText("Jenis Kelamin/Gender");
        jPanel1.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, -1, 20));

        jLabel78.setText("Tanggal Lahir / Birth Date");
        jPanel1.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, -1, 20));

        jButton1.setText("Lihat Foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        jToggleButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jToggleButton2.setText("SIMPAN / SAVE");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 2820, 120, 40));

        radioGrupGender.add(t_wanita);
        t_wanita.setText("Female");
        jPanel1.add(t_wanita, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 150, -1, -1));

        radioGrupGender.add(t_pria);
        t_pria.setText("Male");
        jPanel1.add(t_pria, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, -1, 20));

        radioGrupStatus.add(t_lajang);
        t_lajang.setText("Single");
        t_lajang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_lajangActionPerformed(evt);
            }
        });
        jPanel1.add(t_lajang, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, -1, 20));

        radioGrupStatus.add(t_menikah);
        t_menikah.setText("Married");
        jPanel1.add(t_menikah, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 180, -1, -1));
        jPanel1.add(t_tgl_personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 150, -1));

        jCheckBox1.setText("Sama Dengan Home Address");
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 480, -1, -1));

        t_lokasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "test" }));
        t_lokasi.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(t_lokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 960, 210, -1));

        t_sekolah.setLabelText("Nama Sekolah / School Name & Graduate Years\n");
        jPanel1.add(t_sekolah, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 890, 280, -1));
        jPanel1.add(t_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 910, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Lokasi / Location");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 960, -1, 30));

        t_jurusan.setLabelText("Jurusan / Major");
        jPanel1.add(t_jurusan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1000, 310, -1));

        jButton4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton4.setText("Add/Tambah");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 1030, 110, 30));

        jButton2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton2.setText("Hapus / Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 2250, 110, 30));

        buttongrup.add(r_y);
        r_y.setText("Ya / Yes");
        r_y.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(r_y, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1250, -1, -1));

        buttongrup.add(r_n);
        r_n.setText("Tidak / No");
        r_n.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(r_n, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 1250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setText("Tinggal Bersama / Cohabit");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1230, 190, -1));

        t_hp1.setLabelText("No Handphone");
        t_hp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_hp1ActionPerformed(evt);
            }
        });
        t_hp1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_hp1KeyTyped(evt);
            }
        });
        jPanel1.add(t_hp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1280, 260, -1));

        jButton3.setText("Simpan / Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 1730, -1, 30));

        t_tgl_family.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(t_tgl_family, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 1360, 250, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setText("Tanggal Lahir / Birthday");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 1340, 190, 20));

        t_hubungan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kakek", "Nenek", "Ayah", "Ibu", "Kakak", "Adik", "Suami", "Istri", "Anak laki - laki", "Anak Perempuan" }));
        t_hubungan.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(t_hubungan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 1300, 250, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setText("Hubungan / Relation");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 1280, 190, 20));

        t_nama1.setLabelText("Nama Anggota / Member Name");
        jPanel1.add(t_nama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 1230, 250, -1));

        jButton5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton5.setText("Hapus / Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 1170, 110, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setText("diakuisisi Tanggal / acquisition date");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1600, 180, -1));

        t_tgl_certificate.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jPanel1.add(t_tgl_certificate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1620, 220, 30));

        t_lokasi1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Serang", " " }));
        t_lokasi1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jPanel1.add(t_lokasi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 1620, 270, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel7.setText("Lokasi / Location");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 1600, 90, -1));

        t_nama2.setLabelText("Nama Sertifikat / Certificate Namel");
        jPanel1.add(t_nama2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1660, 270, -1));

        t_author.setLabelText("Nama Badan Penyelenggara / Authority Name");
        jPanel1.add(t_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1710, 270, -1));

        t_sertifikat.setLabelText("No. Sertifikat");
        jPanel1.add(t_sertifikat, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 1660, 270, -1));

        jButton6.setText("Simpan / Save");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 1360, -1, 30));

        t_nama3.setLabelText("Nama Perusahaan / Company name");
        jPanel1.add(t_nama3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1940, 248, -1));

        t_posisi.setLabelText("Posisi Pekerjaan / Job Position");
        jPanel1.add(t_posisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1990, 248, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel8.setText("Periode (dari Tahun)");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 2040, 190, -1));
        jPanel1.add(bulan_awal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 2060, -1, -1));
        jPanel1.add(tahun_awal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 2060, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel9.setText("Periode (sampai Tahun)");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 2090, 190, -1));
        jPanel1.add(bulan_akhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 2110, -1, -1));
        jPanel1.add(tahun_akhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 2110, -1, -1));

        jButton7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton7.setText("Simpan / Save");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 2100, -1, 31));

        jButton8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton8.setText("Hapus / Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 1510, 110, 30));

        jButton9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton9.setText("Hapus / Delete");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 1870, 110, 30));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1023, 2976, 130, 30));

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

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int row = jTable4.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.removeRow(row);  // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int row = jTable3.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.removeRow(row);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int hari = 01;
        int bln_awal = Integer.valueOf(bulan_awal.getMonth() + 1);
        int bln_akhir = Integer.valueOf(bulan_akhir.getMonth() + 1);
        int thn_awal = Integer.valueOf(tahun_awal.getYear());
        int thn_akhir = Integer.valueOf(tahun_akhir.getYear());
        LocalDate tgl_awal = LocalDate.of(thn_awal, bln_awal, hari);
        LocalDate tgl_akhir = LocalDate.of(thn_akhir, bln_akhir, hari);
        int hasil_tahun = Period.between(tgl_awal, tgl_akhir).getYears();
        int hasil_bulan = Period.between(tgl_awal, tgl_akhir).getMonths();

        DefaultTableModel dataModel = (DefaultTableModel) jTable5.getModel();
        List list = new ArrayList<>();
        jTable5.setAutoCreateColumnsFromModel(true);
        list.add(t_nama.getText());
        list.add(t_posisi.getText());
        list.add("(" + tgl_awal.getMonth() + "-" + tgl_awal.getYear() + ")" + " - " + "(" + tgl_akhir.getMonth() + "-" + tgl_akhir.getYear() + ")");
        list.add(hasil_tahun + " Tahun " + hasil_bulan + " Bulan");
        dataModel.addRow(list.toArray());
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
        String tanggal_family = String.valueOf(fm.format(t_tgl_family.getDate()));
        r_y.setActionCommand("Yes");
        r_n.setActionCommand("No");
        DefaultTableModel dataModel = (DefaultTableModel) jTable3.getModel();
        List list = new ArrayList<>();
        jTable3.setAutoCreateColumnsFromModel(true);
        list.add(t_nama1.getText());
        list.add(t_hubungan.getSelectedItem());
        list.add(tanggal_family);
        list.add(buttongrup.getSelection().getActionCommand());
        list.add(t_hp1.getText());
        dataModel.addRow(list.toArray());        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int row = jTable2.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.removeRow(row);           // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
        String tanggal_certificate = String.valueOf(fm.format(t_tgl_certificate.getDate()));

        DefaultTableModel dataModel = (DefaultTableModel) jTable4.getModel();
        List list = new ArrayList<>();
        jTable4.setAutoCreateColumnsFromModel(true);
        list.add(tanggal);
        list.add(t_nama.getText());
        list.add(t_author.getText());
        list.add(t_lokasi.getSelectedItem());
        list.add(t_sertifikat.getText());
        dataModel.addRow(list.toArray());
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void t_hp1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_hp1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        String a;
        String b = "-";
        if (t_hp1.getText().length() < 3) {
            t_hp1.setText("(0)");
        } else if (t_hp1.getText().length() == 6) {
            t_hp1.setText(t_hp1.getText() + "-");
        } else if (t_hp1.getText().length() == 7) {
            StringBuffer sb = new StringBuffer(t_hp1.getText());
            sb.setLength(6);
            t_hp1.setText("" + sb);
        } else if (t_hp1.getText().length() == 11) {
            t_hp1.setText(t_hp1.getText() + "-");
        } else if (t_hp1.getText().length() == 12) {
            StringBuffer sb = new StringBuffer(t_hp1.getText());
            sb.setLength(11);
            t_hp1.setText("" + sb);
        } else if (t_hp1.getText().length() == 17) {
            t_hp1.setText(t_hp1.getText());
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_hp1KeyTyped

    private void t_hp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_hp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_hp1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jTable5.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.removeRow(row);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        SimpleDateFormat fm = new SimpleDateFormat("yyyy");
        String tanggal = String.valueOf(fm.format(t_tgl.getYear()));
        DefaultTableModel dataModel = (DefaultTableModel) jTable2.getModel();

        String name = t_sekolah.getText();
        int year = t_tgl.getYear();
        String major = t_jurusan.getText();
        String loc = t_lokasi.getSelectedItem().toString();

        List list = new ArrayList<>();
        jTable2.setAutoCreateColumnsFromModel(true);
        list.add(t_tgl.getYear());
        list.add(t_sekolah.getText());
        list.add(t_lokasi.getSelectedItem());
        list.add(t_jurusan.getText());
        dataModel.addRow(list.toArray());

        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        hapusdb();
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String g_tgl_personal = String.valueOf(fm.format(t_tgl_personal.getDate()));
        t_pria.setActionCommand("Male");
        t_wanita.setActionCommand("Female");
        t_lajang.setActionCommand("Single");
        t_menikah.setActionCommand("Married");
        full_home = t_halamat.getText() + sp + t_ddesa.getText() + sp + t_hkec.getText() + sp + homeCity.getSelectedItem() + sp + homeState.getSelectedItem() + sp + homeCountry.getSelectedItem();
        full_curent = t_calamat.getText() + sp + t_cdesa.getText() + sp + t_ckec.getText() + sp + ccity.getSelectedItem() + sp + cprov.getSelectedItem() + sp + curentCountry.getSelectedItem();
        try {
            stm = koneksi.createStatement();
            String sql9 = "update cd_employee set nama='" + t_nama.getText() + "',KTP ='" + t_ktp.getText() + "',"
                    + "email='" + t_email.getText() + "',NPWP='" + t_npwp.getText() + "',"
                    + "sex='" + radioGrupGender.getSelection().getActionCommand() + "',b_place='" + t_tlhir.getText() + "',"
                    + "birthday='" + g_tgl_personal + "',marital='" + radioGrupStatus.getSelection().getActionCommand() + "',"
                    + "No_HP='" + t_hp.getText() + "',BPJS='" + t_bpjsKesehatan.getText() + "',"
                    + "bpjs_ket='" + t_bpjsKetenagakerjaan.getText() + "',Applying_A='" + t_lamaran.getSelectedItem() + "',"
                    + "D_Salary='" + t_gaji.getText() + "',discipline='" + t_dicipline.getText() + "',"
                    + "approval='" + k + "' where id_employee='" + da + "'";
//            String sql = " into cd_employee (nama,KTP,email,NPWP,sex,b_place,birthday,marital,No_HP,BPJS,bpjs_ket,Applying_A,D_Salary,discipline,cd_date_apply,approval) values('" + t_nama.getText() + "'"
//                    + ",'" + t_ktp.getText() + "'"
//                    + ",'" + t_email.getText() + "'"
//                    + ",'" + t_npwp.getText() + "'"
//                    + ",'" + radioGrupGender.getSelection().getActionCommand() + "'"
//                    + ",'" + g_tgl_personal + "'"
//                    + ",'" + t_tgl_personal.getDate() + "'"
//                    + ",'" + radioGrupStatus.getSelection().getActionCommand() + "'"
//                    + ",'" + t_hp.getText() + "'"
//                    + ",'" + t_bpjsKesehatan.getText() + "'"
//                    + ",'" + t_bpjsKetenagakerjaan.getText() + "'"
//                    + ",'" + t_lamaran.getSelectedItem() + "'"
//                    + ",'" + t_gaji.getText() + "'"
//                    + ",'" + t_dicipline.getText() + "'"
//                    + ",'" + tanggal + "'"
//                    + ",'" + k + "') where id_employee = " + da + " ";

            stm.executeUpdate(sql9);
            String sql2 = "DELETE FROM cd_adress WHERE id_employee = " + da + "";
            String sql0 = "insert into cd_adress (id_employee,h_negara,h_prov,h_kab,h_kec,h_desa,h_alamat,c_negara,c_prov,c_kab,c_kec,c_desa,c_alamat,full_home,full_current) values('" + da + "'"
                    + ",'" + homeCountry.getSelectedItem() + "'"
                    + ",'" + homeState.getSelectedItem() + "'"
                    + ",'" + homeCity.getSelectedItem() + "'"
                    + ",'" + t_hkec.getText() + "'"
                    + ",'" + t_ddesa.getText() + "'"
                    + ",'" + t_halamat.getText() + "'"
                    + ",'" + curentCountry.getSelectedItem() + "'"
                    + ",'" + cprov.getSelectedItem() + "'"
                    + ",'" + ccity.getSelectedItem() + "'"
                    + ",'" + t_ckec.getText() + "'"
                    + ",'" + t_cdesa.getText() + "'"
                    + ",'" + t_calamat.getText() + "'"
                    + ",'" + full_home + "'"
                    + ",'" + full_curent + "')";

            stm.executeUpdate(sql2);
            stm.executeUpdate(sql0);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }

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
        File foto = new File(crudimage);
        if (crudimage.length() != 1) {
            try {
                stm = koneksi.createStatement();
                String sql = " delete from cd_foto where id_employee = " + da + "";
                stm.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(CandidateApplicationedit.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                InputStream fhoto = new FileInputStream(foto);
                String inputfoto = "INSERT INTO cd_foto(foto,id_employee)  VALUE (?,?)";
                PreparedStatement ifoto = this.koneksi.prepareStatement(inputfoto);
                ifoto.setBlob(1, fhoto);
                ifoto.setString(2, da);
                int ph = ifoto.executeUpdate();
                if (ph > 0) {
                    JOptionPane.showMessageDialog(null, "foto masuk");
                }

            } catch (SQLException ex) {
                Logger.getLogger(CandidateApplicationPersonal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CandidateApplicationedit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        JOptionPane.showMessageDialog(null, "Data Tersimpan");

        Main.main.getMain().showForm(new NewJPanel());
    }//GEN-LAST:event_jToggleButton2ActionPerformed

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
            if (imagefile.length() < 204800) {
                crudimage = imagefile.getAbsolutePath();
                jLabel1.setText(crudimage);

                ImageIcon imageicon = new ImageIcon(crudimage);
                Image imageResize = imageicon.getImage().getScaledInstance(labelfoto.getWidth(), labelfoto.getHeight(), Image.SCALE_SMOOTH);
                labelfoto.setIcon(new ImageIcon(imageResize));
            } else {
                JOptionPane.showMessageDialog(null, "Maximum Size (200kb)");
            }

        }       // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void t_lamaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_lamaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_lamaranActionPerformed

    private void t_npwpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_npwpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_npwpActionPerformed

    private void t_ddesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_ddesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_ddesaActionPerformed

    private void t_hkecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_hkecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_hkecActionPerformed

    private void homeCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeCityActionPerformed

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

    private void t_cdesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cdesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cdesaActionPerformed

    private void t_ckecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_ckecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_ckecActionPerformed

    private void ccityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ccityActionPerformed

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

    private void t_bpjsKesehatanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_bpjsKesehatanKeyTyped
        //        asd
    }//GEN-LAST:event_t_bpjsKesehatanKeyTyped

    private void t_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_emailActionPerformed

    private void t_hpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_hpKeyTyped
        String a;
        String b = "-";
        if (t_hp.getText().length() < 2) {
            t_hp.setText("(0)");
        } else if (t_hp.getText().length() == 6) {
            t_hp.setText(t_hp.getText() + "-");

        } else if (t_hp.getText().length() == 11) {
            t_hp.setText(t_hp.getText() + "-");

        } else if (t_hp.getText().length() == 17) {
            t_hp.setText(t_hp.getText());
            evt.consume();
        }
    }//GEN-LAST:event_t_hpKeyTyped

    private void t_hpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_hpKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_hpKeyReleased

    private void t_hpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_hpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_hpActionPerformed

    private void t_ktpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_ktpKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_ktpKeyReleased

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
//        Main.main.getMain().showForm(new CandidateApplicationIntroduction());
        Main.main.getMain().showForm(new MainPanel());
        main.getMain().setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        jToggleButton2.setEnabled(true);
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void t_lajangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_lajangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_lajangActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        try {
            CandidateApplicationedit.func f = new CandidateApplicationedit.func();
            rsf = f.find(da);
            if (rsf.next()) {
                byte[] img = rsf.getBytes("foto");

                ImageIcon imageicon = new ImageIcon(img);

                Image imageResize = imageicon.getImage().getScaledInstance(labelfoto.getWidth(), labelfoto.getHeight(), Image.SCALE_SMOOTH);
                labelfoto.setIcon(new ImageIcon(imageResize));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jPanel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JMonthChooser bulan_akhir;
    private com.toedter.calendar.JMonthChooser bulan_awal;
    private javax.swing.ButtonGroup buttongrup;
    private CustomResource.ComboBoxSuggestion ccity;
    private CustomResource.ComboBoxSuggestion cprov;
    private CustomResource.ComboBoxSuggestion curentCountry;
    private CustomResource.ComboBoxSuggestion homeCity;
    private CustomResource.ComboBoxSuggestion homeCountry;
    private CustomResource.ComboBoxSuggestion homeState;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
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
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    public static javax.swing.JLabel labelfoto;
    private CustomResource.RadioButtonCustom r_n;
    private CustomResource.RadioButtonCustom r_y;
    private javax.swing.ButtonGroup radioGrupGender;
    private javax.swing.ButtonGroup radioGrupStatus;
    private CustomResource.CustomTextfield t_author;
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
    private CustomResource.CustomTextfield t_hp1;
    private CustomResource.ComboBoxSuggestion t_hubungan;
    private CustomResource.CustomTextfield t_jurusan;
    private CustomResource.CustomTextfield t_ktp;
    private javax.swing.JRadioButton t_lajang;
    private CustomResource.ComboBoxSuggestion t_lamaran;
    private javax.swing.JTextArea t_latar;
    private CustomResource.ComboBoxSuggestion t_lokasi;
    private CustomResource.ComboBoxSuggestion t_lokasi1;
    private javax.swing.JRadioButton t_menikah;
    private javax.swing.JTextArea t_motif;
    private CustomResource.CustomTextfield t_nama;
    private CustomResource.CustomTextfield t_nama1;
    private CustomResource.CustomTextfield t_nama2;
    private CustomResource.CustomTextfield t_nama3;
    private CustomResource.CustomFormatField t_npwp;
    private CustomResource.CustomTextfield t_posisi;
    private javax.swing.JRadioButton t_pria;
    private CustomResource.CustomTextfield t_sekolah;
    private CustomResource.CustomTextfield t_sertifikat;
    private com.toedter.calendar.JYearChooser t_tgl;
    private com.toedter.calendar.JDateChooser t_tgl_certificate;
    private com.toedter.calendar.JDateChooser t_tgl_family;
    private com.toedter.calendar.JDateChooser t_tgl_personal;
    private CustomResource.CustomTextfield t_tlhir;
    private javax.swing.JRadioButton t_wanita;
    private com.toedter.calendar.JYearChooser tahun_akhir;
    private com.toedter.calendar.JYearChooser tahun_awal;
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
