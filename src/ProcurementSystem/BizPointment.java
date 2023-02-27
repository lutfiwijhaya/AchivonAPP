/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ProcurementSystem;

import CustomResource.MySession;
import CustomResource.koneksi;
import Main.MasterForm;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author hi
 */
public class BizPointment extends MasterForm {

    Connection koneksi;
    Statement stm;
    ResultSet rs;
    int id3;
    String b = null;
    String id_biz;

    DefaultTableModel myModel;

    public BizPointment() {
        initComponents();
        openDB();
        CountryBox();
        id_employee();
        country.setSelectedItem("Indonesia");

        String[] header = {"id", "Partner ID", "Register Date", "Name", "Telp or HP", "Email", "city/district", "Address", "tax payer", "pph"};
        myModel = new DefaultTableModel(header, 1);
        MyTable.setModel(myModel);
        MyTable.setDefaultEditor(Object.class, null);
//        MyTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        MyTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        MyTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        MyTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(6).setPreferredWidth(150);
        MyTable.getColumnModel().getColumn(7).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(8).setPreferredWidth(170);
        MyTable.getColumnModel().getColumn(9).setPreferredWidth(50);
        table_id();
        tampil();
        jButton4.setEnabled(false);
        jButton1.setEnabled(false);
    }

    void table_id() {
//mendapatkan model kolom pada JTable
        TableColumnModel columnModel = MyTable.getColumnModel();
//mendapatkan TableColumn pada indeks kolom yang ingin disembunyikan
        TableColumn column = columnModel.getColumn(0);
//menyembunyikan kolom dengan mengatur lebar kolom menjadi 0
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
//mengakses nilai pada kolom yang disembunyikan
        int rowIndex = 0; //indeks baris
        Object value = MyTable.getValueAt(rowIndex, 0);
    }

    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }

    private void id_employee() {
        String sql = "select max(partner_id3) from biz_partner";
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int a = rs.getInt(1);
                id3 = a + 1;
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    void tampil() {
        try {
            int rowCount = myModel.getRowCount();

            for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
            }
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from biz_partner");
            while (rs.next()) {
                String[] data = {
                    rs.getString("biz_id"),
                    rs.getString("partner_id"),
                    rs.getString("register_date"),
                    rs.getString("name"),
                    rs.getString("no_hp"),
                    rs.getString("email"),
                    rs.getString("city"),
                    rs.getString("address"),
                    rs.getString("tax_payer"),
                    rs.getString("pph"),};
                myModel.insertRow(0, data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }
    }

    void set_kosong() {
        idIntegrated.setText("");
        boxID1.setSelectedItem("ID #1");
        boxID2.setSelectedItem("ID #2");

        textID3.setText("");
        textName.setText("");
        t_hp.setText("(0)");
        textMail.setText("");
        country.setSelectedItem("Indonesia");
        province.setSelectedItem("Province");
        city.setSelectedItem("City / District");
        customTextfield6.setText("");
        customTextfield7.setText("");
        customTextfield8.setText("");
        customTextfield14.setText("");
        textRT.setText("");
        textRW.setText("");
        textPostcode.setText("");
        textAddress.setText("");
        textNPWP.setText("");
        boxPPH.setSelectedItem("PPh23 (%)");
        boxTax.setSelectedItem("Tax Payer");
        comboBoxSuggestion8.setSelectedItem("Price");
        comboBoxSuggestion9.setSelectedItem("Cordination");
        comboBoxSuggestion10.setSelectedItem("Delivery");
        comboBoxSuggestion11.setSelectedItem("Quality");

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
        jProgressBar1 = new javax.swing.JProgressBar();
        idIntegrated = new CustomResource.CustomTextfield();
        boxID1 = new CustomResource.ComboBoxSuggestion();
        boxID2 = new CustomResource.ComboBoxSuggestion();
        textID3 = new CustomResource.CustomTextfield();
        textName = new CustomResource.CustomTextfield();
        t_hp = new CustomResource.CustomTextfield();
        textMail = new CustomResource.CustomTextfield();
        country = new CustomResource.ComboBoxSuggestion();
        province = new CustomResource.ComboBoxSuggestion();
        city = new CustomResource.ComboBoxSuggestion();
        customTextfield6 = new CustomResource.CustomTextfield();
        customTextfield7 = new CustomResource.CustomTextfield();
        customTextfield8 = new CustomResource.CustomTextfield();
        textRT = new CustomResource.CustomTextfield();
        textRW = new CustomResource.CustomTextfield();
        textPostcode = new CustomResource.CustomTextfield();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAddress = new javax.swing.JTextArea();
        textDateRegister = new CustomResource.CustomTextfield();
        boxTax = new CustomResource.ComboBoxSuggestion();
        boxPPH = new CustomResource.ComboBoxSuggestion();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MyTable = new javax.swing.JTable();
        textSearch = new CustomResource.CustomTextfield();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxSuggestion8 = new CustomResource.ComboBoxSuggestion();
        comboBoxSuggestion9 = new CustomResource.ComboBoxSuggestion();
        comboBoxSuggestion10 = new CustomResource.ComboBoxSuggestion();
        comboBoxSuggestion11 = new CustomResource.ComboBoxSuggestion();
        customTextfield14 = new CustomResource.CustomTextfield();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        textNPWP = new CustomResource.CustomFormatField();
        boxTax1 = new CustomResource.ComboBoxSuggestion();
        jButton6 = new javax.swing.JButton();

        dateChooser1.setDateFormat("dd-MMM-yyyy");
        dateChooser1.setTextRefernce(textDateRegister);

        setBackground(new java.awt.Color(255, 255, 255));

        idIntegrated.setEnabled(false);
        idIntegrated.setLabelText("ID Integrated");

        boxID1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID #1" }));
        boxID1.setEnabled(false);
        boxID1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        boxID1.setName(""); // NOI18N

        boxID2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID #2" }));
        boxID2.setEnabled(false);
        boxID2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        textID3.setEnabled(false);
        textID3.setLabelText("ID #3");

        textName.setLabelText("Name");

        t_hp.setLabelText("Telp or HP");
        t_hp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_hpKeyTyped(evt);
            }
        });

        textMail.setLabelText("e-mail");

        country.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Country" }));
        country.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryActionPerformed(evt);
            }
        });

        province.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Province" }));
        province.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        province.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provinceActionPerformed(evt);
            }
        });

        city.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "City / District" }));
        city.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        customTextfield6.setLabelText("PIC");
        customTextfield6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customTextfield6ActionPerformed(evt);
            }
        });

        customTextfield7.setLabelText("PIC");

        customTextfield8.setLabelText("PIC");
        customTextfield8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customTextfield8ActionPerformed(evt);
            }
        });

        textRT.setLabelText("RT");
        textRT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textRTActionPerformed(evt);
            }
        });
        textRT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textRTKeyTyped(evt);
            }
        });

        textRW.setLabelText("RW");
        textRW.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textRWKeyTyped(evt);
            }
        });

        textPostcode.setLabelText("Postcode");
        textPostcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textPostcodeKeyTyped(evt);
            }
        });

        textAddress.setColumns(20);
        textAddress.setRows(5);
        textAddress.setToolTipText("Address");
        jScrollPane1.setViewportView(textAddress);

        textDateRegister.setLabelText("Reg. Date");
        textDateRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDateRegisterActionPerformed(evt);
            }
        });

        boxTax.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tax Payer", "Yes", "No" }));
        boxTax.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        boxPPH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PPh23 (%)", "1%", "1,5%", "2%", "2,5%", "3%", "3,5%", "4%", "4,5%", "5%", "5,5%", "6%", "6,5%", "7%", "7,5%", "8%", "8,5%", "9%", "9,5%", "10%" }));
        boxPPH.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLabel1.setText("Address");

        MyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(MyTable);

        textSearch.setLabelText("Search");
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });
        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSearchKeyTyped(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Biz. Partner");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PIC");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(0, 51, 51));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Evaluation of Biz. Partner");
        jLabel4.setOpaque(true);

        comboBoxSuggestion8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Price", "Very Low", "Low", "Moderate", "High", "Very High" }));

        comboBoxSuggestion9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cordination" }));

        comboBoxSuggestion10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Delivery" }));

        comboBoxSuggestion11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quality", "Best", "Moderate", "Worst" }));

        customTextfield14.setLabelText("Remark / Specific Note");

        jLabel5.setBackground(new java.awt.Color(0, 51, 51));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("List - Biz. Partner Status");
        jLabel5.setOpaque(true);

        jButton1.setText("Initialize");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Register");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel Edit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        try {
            textNPWP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###.#-###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textNPWP.setLabelText("No NPWP");
        textNPWP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNPWPActionPerformed(evt);
            }
        });

        boxTax1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Search Category", "ID Partener", "Nama", "Kota", " " }));
        boxTax1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        boxTax1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTax1ActionPerformed(evt);
            }
        });

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 163, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textID3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxID1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxID2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idIntegrated, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(customTextfield14, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                                .addGap(60, 60, 60))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboBoxSuggestion8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(comboBoxSuggestion9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxSuggestion10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxSuggestion11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(city, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(province, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(country, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(t_hp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(textRT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textRW, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(customTextfield8, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(customTextfield7, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(customTextfield6, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(boxPPH, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textNPWP, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                            .addComponent(textDateRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(boxTax, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(boxTax1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idIntegrated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boxID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textID3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(t_hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(customTextfield7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(customTextfield8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(province, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textDateRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customTextfield6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textRT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textRW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNPWP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxPPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSuggestion8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSuggestion9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSuggestion10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSuggestion11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customTextfield14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxTax1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4)
                    .addComponent(jButton6))
                .addContainerGap(165, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = MyTable.getSelectedRow();
        String a = ((String) MyTable.getValueAt(row, 0));
        id_biz = a;
        System.out.println(a);

        try {
            Statement stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from biz_partner where biz_id = " + a + "");
            while (rs.next()) {

                customTextfield6.setText(rs.getString("pic1"));
                customTextfield7.setText(rs.getString("pic2"));
                customTextfield8.setText(rs.getString("pic3"));
                customTextfield14.setText(rs.getString("remark"));
                textName.setText(rs.getString("name"));
                t_hp.setText(rs.getString("no_hp"));
                textMail.setText(rs.getString("email"));
                textRT.setText(rs.getString("rt"));
                textRW.setText(rs.getString("rw"));
                textPostcode.setText(rs.getString("postcode"));
                textAddress.setText(rs.getString("address"));
                textNPWP.setText(rs.getString("npwp_no"));
                textDateRegister.setText(rs.getString("register_date"));

                country.setSelectedItem(rs.getString("country"));

                province.setSelectedItem(rs.getString("province"));

                city.setSelectedItem(rs.getString("city"));

                boxTax.setSelectedItem(rs.getString("tax_payer"));

                boxPPH.setSelectedItem(rs.getString("pph"));

                comboBoxSuggestion8.setSelectedItem(rs.getString("price"));

                comboBoxSuggestion9.setSelectedItem(rs.getString("cordination"));

                comboBoxSuggestion10.setSelectedItem(rs.getString("delivery"));

                comboBoxSuggestion11.setSelectedItem(rs.getString("quality"));
                idIntegrated.setText(rs.getString("partner_id"));
                boxID1.setSelectedItem("ID #1");
                boxID2.setSelectedItem("ID #2");
                textID3.setText("");
jButton1.setEnabled(true);
jButton2.setEnabled(false);
jButton3.setEnabled(false);
jButton4.setEnabled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO biz_partner (partner_id, partner_id1, partner_id2, partner_id3, name, no_hp, email, country, province, city, rt, rw, postcode, address, register_date, tax_payer, npwp_no, pph,pic1,pic2,pic3,price,cordination,delivery,quality,remark) VALUES (?,?,?,?,?,?,?,?,?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = koneksi.prepareStatement(sql);
            // Mengisi nilai parameter
            stmt.setString(1, boxID1.getSelectedItem().toString() + "-" + boxID2.getSelectedItem().toString() + "-" + textID3.getText());
            stmt.setString(2, boxID1.getSelectedItem().toString());
            stmt.setString(3, boxID2.getSelectedItem().toString());
            stmt.setString(4, textID3.getText());
            stmt.setString(5, textName.getText());
            stmt.setString(6, t_hp.getText());
            stmt.setString(7, textMail.getText());
            stmt.setString(8, country.getSelectedItem().toString());
            stmt.setString(9, province.getSelectedItem().toString());
            stmt.setString(10, city.getSelectedItem().toString());
            stmt.setString(11, textRT.getText());
            stmt.setString(12, textRW.getText());
            stmt.setString(13, textPostcode.getText());
            stmt.setString(14, textAddress.getText());
            stmt.setString(15, textDateRegister.getText());
            stmt.setString(16, boxTax.getSelectedItem().toString());
            stmt.setString(17, textNPWP.getText());
            stmt.setString(18, boxPPH.getSelectedItem().toString());
            stmt.setString(19, customTextfield6.getText());
            stmt.setString(20, customTextfield7.getText());
            stmt.setString(21, customTextfield8.getText());
            stmt.setString(22, comboBoxSuggestion8.getSelectedItem().toString());
            stmt.setString(23, comboBoxSuggestion9.getSelectedItem().toString());
            stmt.setString(24, comboBoxSuggestion10.getSelectedItem().toString());
            stmt.setString(25, comboBoxSuggestion11.getSelectedItem().toString());
            stmt.setString(26, customTextfield14.getText());
            // Mengeksekusi perintah SQL
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil mendaftarkan \nSucceed registering");
            // Menampilkan jumlah baris yang terpengaruh
//            int rowsAffected = stmt.executeUpdate();
//            System.out.println("Jumlah baris yang terpengaruh: " + rowsAffected);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Menutup objek PreparedStatement dan Connection
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//                
//                if (koneksi != null) {
//                    koneksi.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
        tampil();
        set_kosong();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchActionPerformed

    private void textRTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textRTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textRTActionPerformed

    private void customTextfield6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customTextfield6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customTextfield6ActionPerformed

    private void customTextfield8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customTextfield8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customTextfield8ActionPerformed

    private void countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryActionPerformed
        try {
            ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM states WHERE country_name ='" + country.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                province.addItem(myRess.getString("name"));
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_countryActionPerformed

    private void provinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provinceActionPerformed
        try {
            String id = Integer.toString(id3);
            ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM cities WHERE state_name ='" + province.getSelectedItem().toString() + "'");
            while (myRess.next()) {
                boxID1.removeAllItems();
                boxID2.removeAllItems();
                city.addItem(myRess.getString("name"));
                boxID1.addItem(myRess.getString("state_code"));
                boxID1.setSelectedItem(myRess.getString("state_code"));
                boxID2.addItem(myRess.getString("state_id"));
                boxID2.setSelectedItem(myRess.getString("state_id"));
                textID3.setText(id);
                idIntegrated.setText("" + boxID1.getSelectedItem() + "-" + boxID2.getSelectedItem() + "-" + id + "");
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_provinceActionPerformed

    private void t_hpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_hpKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        String a;
        String b = "-";
        if (t_hp.getText().length() < 3) {
            t_hp.setText("(0)");
        } else if (t_hp.getText().length() == 6) {
            t_hp.setText(t_hp.getText() + "-");
        } else if (t_hp.getText().length() == 7) {
            StringBuffer sb = new StringBuffer(t_hp.getText());
            sb.setLength(6);
            t_hp.setText("" + sb);
        } else if (t_hp.getText().length() == 11) {
            t_hp.setText(t_hp.getText() + "-");
        } else if (t_hp.getText().length() == 12) {
            StringBuffer sb = new StringBuffer(t_hp.getText());
            sb.setLength(11);
            t_hp.setText("" + sb);
        } else if (t_hp.getText().length() == 17) {
            t_hp.setText(t_hp.getText());
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_hpKeyTyped

    private void textRTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textRTKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        if (textRT.getText().length() > 2) {
            evt.consume();
        }      // TODO add your handling code here:
    }//GEN-LAST:event_textRTKeyTyped

    private void textRWKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textRWKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        if (textRW.getText().length() > 2) {
            evt.consume();
        }       // TODO add your handling code here:
    }//GEN-LAST:event_textRWKeyTyped

    private void textPostcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPostcodeKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        if (textPostcode.getText().length() > 4) {
            evt.consume();
        }       // TODO add your handling code here:
    }//GEN-LAST:event_textPostcodeKeyTyped

    private void textDateRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDateRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDateRegisterActionPerformed

    private void textNPWPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNPWPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNPWPActionPerformed

    private void boxTax1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTax1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxTax1ActionPerformed

    private void textSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyTyped
        String a = boxTax1.getSelectedItem().toString();

        if (a.equals("ID Partener")) {
            b = "partner_id";
        } else if (a.equals("Nama")) {
            b = "name";
        } else if (a.equals("Kota")) {
            b = "city";
        }

        System.out.println(b);

        String mySearch = textSearch.getText();
        int row = MyTable.getRowCount();
        for (int i = 0; i < row; i++) {
            myModel.removeRow(0);
        }
        if (mySearch != null) {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM biz_partner WHERE " + b + " LIKE '%" + mySearch + "%'");
                while (rs.next()) {
                    String[] data = {
                        rs.getString("biz_id"),
                        rs.getString("partner_id"),
                        rs.getString("register_date"),
                        rs.getString("name"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("city"),
                        rs.getString("address"),
                        rs.getString("tax_payer"),
                        rs.getString("pph"),};
                    myModel.insertRow(0, data);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        } else {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("select*from biz_partner");
                while (rs.next()) {
                    String[] data = {
                        rs.getString("biz_id"),
                        rs.getString("partner_id"),
                        rs.getString("register_date"),
                        rs.getString("name"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("city"),
                        rs.getString("address"),
                        rs.getString("tax_payer"),
                        rs.getString("pph"),};
                    myModel.insertRow(0, data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchKeyTyped

    private void textSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyReleased
        String a = boxTax1.getSelectedItem().toString();

        if (a.equals("ID Partener")) {
            b = "partner_id";
        } else if (a.equals("Nama")) {
            b = "name";
        } else if (a.equals("Kota")) {
            b = "city";
        }

        System.out.println(b);

        String mySearch = textSearch.getText();
        int row = MyTable.getRowCount();
        for (int i = 0; i < row; i++) {
            myModel.removeRow(0);
        }
        if (mySearch != null) {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM biz_partner WHERE " + b + " LIKE '%" + mySearch + "%'");
                while (rs.next()) {
                    String[] data = {
                       rs.getString("biz_id"),
                        rs.getString("partner_id"),
                        rs.getString("register_date"),
                        rs.getString("name"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("city"),
                        rs.getString("address"),
                        rs.getString("tax_payer"),
                        rs.getString("pph"),};
                    myModel.insertRow(0, data);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        } else {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("select*from biz_partner");
                while (rs.next()) {
                    String[] data = {
                       rs.getString("biz_id"),
                        rs.getString("partner_id"),
                        rs.getString("register_date"),
                        rs.getString("name"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("city"),
                        rs.getString("address"),
                        rs.getString("tax_payer"),
                        rs.getString("pph"),};
                    myModel.insertRow(0, data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        }


    }//GEN-LAST:event_textSearchKeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int respon = JOptionPane.showConfirmDialog(null, "ANDA YAKIN UNTUK KELUAR", "Option", JOptionPane.YES_NO_OPTION);
        if (respon == 0) {
            int[] selectedRows = MyTable.getSelectedRows();

            for (int i = selectedRows.length - 1; i >= 0; i--) {

                try {
                    stm = koneksi.createStatement();
                    String c = (String) myModel.getValueAt(selectedRows[i], 0);

                    String sql = "DELETE FROM biz_partner where biz_id = " + c + "";
                    myModel.removeRow(selectedRows[i]);
                    stm.executeUpdate(sql);
                    stm.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "error" + e, "GAGAL", JOptionPane.WARNING_MESSAGE);
                }

            }

            tampil();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Statement stm = koneksi.createStatement();
            String sql = "update biz_partner set name='" + textName.getText() + "',no_hp ='" + t_hp.getText() + "',"
                    + "email='" + textMail.getText() + "',country='" + country.getSelectedItem().toString() + "',"
                    + "province='" + province.getSelectedItem().toString() + "',city='" + city.getSelectedItem().toString() + "',"
                    + "rt='" + textRT.getText() + "',rw='" + textRW.getText() + "',"
                    + "postcode='" + textPostcode.getText() + "',address='" + textAddress.getText() + "',"
                    + "register_date='" + textDateRegister.getText() + "',tax_payer='" + boxTax.getSelectedItem().toString() + "',"
                    + "npwp_no='" + textNPWP.getText() + "',pph='" + boxPPH.getSelectedItem().toString() + "',"
                    + "pic1='" + customTextfield6.getText() + "',pic2='" + customTextfield7.getText() + "',"
                    + "pic3='" + customTextfield8.getText() + "',price='" + comboBoxSuggestion8.getSelectedItem().toString() + "',"
                    + "cordination='" + comboBoxSuggestion9.getSelectedItem().toString() + "',delivery='" + comboBoxSuggestion10.getSelectedItem().toString() + "',"
                    + "quality='" + comboBoxSuggestion11.getSelectedItem().toString() + "',remark='" + customTextfield14.getText() + "' where biz_id='" + id_biz + "'";

            stm.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } 
        set_kosong();
jButton1.setEnabled(false);
jButton2.setEnabled(true);
jButton3.setEnabled(true);
jButton4.setEnabled(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        set_kosong(); 
        jButton1.setEnabled(false);
jButton2.setEnabled(true);
jButton3.setEnabled(true);
jButton4.setEnabled(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MyTable;
    private CustomResource.ComboBoxSuggestion boxID1;
    private CustomResource.ComboBoxSuggestion boxID2;
    private CustomResource.ComboBoxSuggestion boxPPH;
    private CustomResource.ComboBoxSuggestion boxTax;
    private CustomResource.ComboBoxSuggestion boxTax1;
    private CustomResource.ComboBoxSuggestion city;
    private CustomResource.ComboBoxSuggestion comboBoxSuggestion10;
    private CustomResource.ComboBoxSuggestion comboBoxSuggestion11;
    private CustomResource.ComboBoxSuggestion comboBoxSuggestion8;
    private CustomResource.ComboBoxSuggestion comboBoxSuggestion9;
    private CustomResource.ComboBoxSuggestion country;
    private CustomResource.CustomTextfield customTextfield14;
    private CustomResource.CustomTextfield customTextfield6;
    private CustomResource.CustomTextfield customTextfield7;
    private CustomResource.CustomTextfield customTextfield8;
    private com.raven.datechooser.DateChooser dateChooser1;
    private CustomResource.CustomTextfield idIntegrated;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private CustomResource.ComboBoxSuggestion province;
    private CustomResource.CustomTextfield t_hp;
    private javax.swing.JTextArea textAddress;
    private CustomResource.CustomTextfield textDateRegister;
    private CustomResource.CustomTextfield textID3;
    private CustomResource.CustomTextfield textMail;
    private CustomResource.CustomFormatField textNPWP;
    private CustomResource.CustomTextfield textName;
    private CustomResource.CustomTextfield textPostcode;
    private CustomResource.CustomTextfield textRT;
    private CustomResource.CustomTextfield textRW;
    private CustomResource.CustomTextfield textSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formrefresh() {
    }

    private void myShow() {
        String mySearch = textSearch.getText();
        int row = MyTable.getRowCount();
        for (int i = 0; i < row; i++) {
            myModel.removeRow(0);
        }
        try {
            ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM employee_absence inner join employee on employee_absence.karyawan_id = employee.karyawan_id");
            while (myRess.next()) {
                String myData[] = {myRess.getString(17), myRess.getString(18), myRess.getString(19), myRess.getString(20), myRess.getString(25),
                    myRess.getString(26), myRess.getString(29), myRess.getString(22)};
                myModel.addRow(myData);
            }
        } catch (SQLException ex) {
        }
    }

    private void CountryBox() {
        try {
            ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM countries");
            while (myRess.next()) {
                country.addItem(myRess.getString("name"));
            }
        } catch (SQLException ex) {
        }
        country.setEnabled(true);
    }
}
