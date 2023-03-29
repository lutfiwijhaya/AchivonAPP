/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ProcurementSystem;

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
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JScrollBar;
import javax.swing.JTable;

/**
 *
 * @author hi
 */
public class BizPointment extends MasterForm {

    Connection koneksi;
    Statement stm;
    ResultSet rs;
    int id3;
    String b = "partner_id";
    String id_biz;

    DefaultTableModel myModel;
    DefaultTableModel myModel1;

    public BizPointment() {
        initComponents();
        openDB();
        CountryBox();

        country.setSelectedItem("Indonesia");
        String[] header = {"id", "Partner ID", "Register Reason Date", "Name", "Telp or HP", "Email", "Country", "Province", "city/district", "Address", "PostCode", "tax payer", "NPWP", "pph", "PIC Name", "PIC Mobile No", "PIC Email", "Price", "Cordination", "Delivery", "Quality", "Remark"};
        String[] header1 = {"id", "Partner ID", "Name", "City"};
        myModel = new DefaultTableModel(header, 1);
        myModel1 = new DefaultTableModel(header1, 1);
//        String[] header = {"id", "Partner ID", "Register Reason Date", "Name", "Telp or HP", "Email", "Country", "Province", "city/district", "Address", "PostCode", "tax payer", "NPWP", "pph", "PIC Name", "PIC Mobile No", "PIC Email", "Price", "Cordination", "Delivery", "Quality", "Remark"};
//        String[] header1 = {"id", "Partner ID", "Name", "City"};
//        myModel = new DefaultTableModel(header, 1);
        MyTable.setModel(myModel);
//        myModel1 = new DefaultTableModel(header1, 1);
        MyTable2.setModel(myModel1);
        MyTable.setDefaultEditor(Object.class, null);
        MyTable2.setDefaultEditor(Object.class, null);
        MyTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        MyTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        MyTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(6).setPreferredWidth(150);
        MyTable.getColumnModel().getColumn(7).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(8).setPreferredWidth(170);
        MyTable.getColumnModel().getColumn(9).setPreferredWidth(50);
        MyTable.getColumnModel().getColumn(10).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(11).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(12).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(13).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(14).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(15).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(16).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(17).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(18).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(19).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(20).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(21).setPreferredWidth(100);
        MyTable2.getColumnModel().getColumn(3).setPreferredWidth(105);
        MyTable2.getColumnModel().getColumn(2).setPreferredWidth(105);
        table_id();
        table_id2();
        tampil();
        scrol();
    }

    void scrol() {
        // Add an AdjustmentListener to the vertical scroll bar of the first scroll pane
        JScrollBar verticalScrollBar1 = jScrollPane2.getVerticalScrollBar();
        verticalScrollBar1.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                // Get the value of the first scroll bar and set it to the second one
                JScrollBar verticalScrollBar2 = jScrollPane4.getVerticalScrollBar();
                verticalScrollBar2.setValue(e.getValue());
            }
        });

        // Add an AdjustmentListener to the vertical scroll bar of the first scroll pane
        JScrollBar verticalScrollBar11 = jScrollPane4.getVerticalScrollBar();
        verticalScrollBar1.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                // Get the value of the first scroll bar and set it to the second one
                JScrollBar verticalScrollBar2 = jScrollPane2.getVerticalScrollBar();
                verticalScrollBar2.setValue(e.getValue());
            }
        });
    }

    void tampil() {
        try {
            int rowCount = myModel.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                myModel.removeRow(i);
                myModel1.removeRow(i);
            }
            stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from biz_partner");
            while (rs.next()) {
                String add = rs.getString("address") + " RT/RW " + rs.getString("rt") + "/" + rs.getString("rw");
                String[] data = {
                    rs.getString("biz_id"),
                    rs.getString("partner_id"),
                    rs.getString("register_date"),
                    rs.getString("name"),
                    rs.getString("no_hp"),
                    rs.getString("email"),
                    rs.getString("country"),
                    rs.getString("province"),
                    rs.getString("city"),
                    add,
                    rs.getString("postcode"),
                    rs.getString("tax_payer"),
                    rs.getString("npwp_no"),
                    rs.getString("pph"),
                    rs.getString("pic1"),
                    rs.getString("pic2"),
                    rs.getString("pic3"),
                    rs.getString("price"),
                    rs.getString("cordination"),
                    rs.getString("delivery"),
                    rs.getString("quality"),
                    rs.getString("remark"),};
                String[] data1 = {data[0], data[1], data[3], data[8]};
                myModel.insertRow(0, data);
                myModel1.insertRow(0, data1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }
    }

    void table_id() {
//mendapatkan model kolom pada JTable
        TableColumnModel columnModel = MyTable.getColumnModel();
//mendapatkan TableColumn pada indeks kolom yang ingin disembunyikan
        TableColumn column = columnModel.getColumn(0);
        TableColumn column1 = columnModel.getColumn(1);
        TableColumn column2 = columnModel.getColumn(3);
        TableColumn column3 = columnModel.getColumn(8);
//menyembunyikan kolom dengan mengatur lebar kolom menjadi 0
        column.setMinWidth(0);
        column1.setMinWidth(0);
        column2.setMinWidth(0);
        column3.setMinWidth(0);
        column1.setMaxWidth(0);
        column2.setMaxWidth(0);
        column3.setMaxWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column3.setWidth(0);
        column2.setWidth(0);
        column1.setWidth(0);
        column.setPreferredWidth(0);
        column3.setPreferredWidth(0);
        column2.setPreferredWidth(0);
        column1.setPreferredWidth(0);
//mengakses nilai pada kolom yang disembunyikan
        int rowIndex = 0; //indeks baris
        Object value = MyTable.getValueAt(rowIndex, 0);
        JTable table = new JTable(MyTable.getModel()) {
            public boolean getScrollableTracksViewportWidth() {
                return getPreferredSize().width < getParent().getWidth();
            }
        };
    }

    void table_id2() {
//mendapatkan model kolom pada JTable
        TableColumnModel columnModel = MyTable2.getColumnModel();
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

        JTable table = new JTable(MyTable.getModel()) {
            public boolean getScrollableTracksViewportWidth() {
                return getPreferredSize().width < getParent().getWidth();
            }
        };
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
        String sql = "select max(partner_id3) from biz_partner where partner_id1 = '" + boxID1.getSelectedItem() + "' AND partner_id2 = '" + boxID2.getSelectedItem() + "'";
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int a = rs.getInt(1);
                id3 = a + 1;
                System.out.println(id3);
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        String id = Integer.toString(id3);
        textID3.setText(id);
        idIntegrated.setText(boxID1.getSelectedItem().toString() + "-" + boxID2.getSelectedItem().toString() + "-" + id);
    }

    void set_kosong() {
//        boxID1.addItem("ID #1");
//        boxID2.addItem("ID #2");
        boxID1.setSelectedItem("ID #1");
        boxID2.setSelectedItem("ID #2");
        idIntegrated.setText(" ");
        textID3.setText(" ");
        textName.setText("");
        t_hp.setText("(0)");
        textMail.setText("");
        country.setSelectedItem("Indonesia");
        province.setSelectedItem("Province");
        city.setSelectedItem("City / District");
        customTextfield6.setText("");
        t_hp_pic.setText("");
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
        dateChooser2 = new com.raven.datechooser.DateChooser();
        dateChooser3 = new com.raven.datechooser.DateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
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
        t_hp_pic = new CustomResource.CustomTextfield();
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
        stgl = new CustomResource.CustomTextfield();
        etgl = new CustomResource.CustomTextfield();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        MyTable2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        MyTable = new javax.swing.JTable();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(textDateRegister);

        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(stgl);

        dateChooser3.setDateFormat("yyyy-MM-dd");
        dateChooser3.setTextRefernce(etgl);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        idIntegrated.setEnabled(false);
        idIntegrated.setLabelText("ID Integrated");
        idIntegrated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idIntegratedActionPerformed(evt);
            }
        });

        boxID1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID #1", "MT", "VD", "EQ", "TR", "TO", "CO", "OE", "OS", "OC", "AI", "QI", "SC", "CS", "OI" }));
        boxID1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        boxID1.setName(""); // NOI18N
        boxID1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                boxID1PopupMenuWillBecomeVisible(evt);
            }
        });
        boxID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxID1ActionPerformed(evt);
            }
        });

        boxID2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID #2", "10", "20", "30", "40", "50", "60", "70", "80", "90", "A0" }));
        boxID2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        boxID2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                boxID2PopupMenuWillBecomeVisible(evt);
            }
        });
        boxID2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxID2ActionPerformed(evt);
            }
        });

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

        customTextfield6.setLabelText("PIC Name");
        customTextfield6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customTextfield6ActionPerformed(evt);
            }
        });

        t_hp_pic.setLabelText("PIC Mobile No");
        t_hp_pic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_hp_picActionPerformed(evt);
            }
        });
        t_hp_pic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_hp_picKeyTyped(evt);
            }
        });

        customTextfield8.setLabelText("PIC Email");
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
        boxTax.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                boxTaxPopupMenuWillBecomeVisible(evt);
            }
        });

        boxPPH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PPh23 (%)", "0.44%", "1.20%", "1.80%", "1.00%", "2.65%", "3.00%", "4.00%", "5.00%", "6.00%", "10.00%", "15.00%", "20.00%", "25.00%", "30.00%" }));
        boxPPH.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        boxPPH.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                boxPPHPopupMenuWillBecomeVisible(evt);
            }
        });

        jLabel1.setText("Address");

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

        comboBoxSuggestion8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Price", "Very High", "High", "Moderate", "Low", "Not Applicable" }));
        comboBoxSuggestion8.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                comboBoxSuggestion8PopupMenuWillBecomeVisible(evt);
            }
        });

        comboBoxSuggestion9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cordination", "Exellent", "Good", "Normal", "Poor", "Worst", "Not Applicable" }));
        comboBoxSuggestion9.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                comboBoxSuggestion9PopupMenuWillBecomeVisible(evt);
            }
        });

        comboBoxSuggestion10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Delivery", "Exellent", "Good", "Normal", "Poor", "Worst", "Not Applicable" }));
        comboBoxSuggestion10.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                comboBoxSuggestion10PopupMenuWillBecomeVisible(evt);
            }
        });

        comboBoxSuggestion11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quality", "Exellent", "Good", "Normal", "Poor", "Worst", "Not Applicable" }));
        comboBoxSuggestion11.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                comboBoxSuggestion11PopupMenuWillBecomeVisible(evt);
            }
        });
        comboBoxSuggestion11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSuggestion11ActionPerformed(evt);
            }
        });

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

        jButton4.setText("Close");
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

        boxTax1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Search Category", "ID", "Nama", "Kota", " " }));
        boxTax1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        boxTax1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                boxTax1PopupMenuWillBecomeVisible(evt);
            }
        });
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

        jButton5.setText("Short");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        MyTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        MyTable2.setAutoResizeMode(0);
        MyTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MyTable2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MyTable2MousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(MyTable2);
        if (MyTable2.getColumnModel().getColumnCount() > 0) {
            MyTable2.getColumnModel().getColumn(0).setResizable(false);
            MyTable2.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 115));

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
        MyTable.setAutoResizeMode(0);
        MyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MyTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(MyTable);
        if (MyTable.getColumnModel().getColumnCount() > 0) {
            MyTable.getColumnModel().getColumn(0).setResizable(false);
            MyTable.getColumnModel().getColumn(1).setResizable(false);
            MyTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 560, 115));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idIntegrated, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_hp, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customTextfield6, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_hp_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDateRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(textID3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(textMail, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(customTextfield8, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(textNPWP, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(province, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(258, 258, 258)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textRT, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textRW, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(textPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(boxPPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(comboBoxSuggestion8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(comboBoxSuggestion9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(comboBoxSuggestion10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(comboBoxSuggestion11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(customTextfield14, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(boxTax1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(stgl, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(etgl, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jButton5))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(idIntegrated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(boxID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(boxID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(t_hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(customTextfield6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(t_hp_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textDateRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(boxTax, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textID3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customTextfield8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNPWP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(province, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textRT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textRW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(boxPPH, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxSuggestion8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSuggestion9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSuggestion10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxSuggestion11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(customTextfield14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(boxTax1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton5)))
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton6)
                    .addComponent(jButton4)))
        );

        jScrollPane3.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
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
                t_hp_pic.setText(rs.getString("pic2"));
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
//                boxID1.setSelectedItem("ID #1");
//                boxID2.setSelectedItem("ID #2");
                idIntegrated.setText(rs.getString("partner_id"));
                textID3.setText("");
                jButton2.setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PreparedStatement stmt = null;
        try {
            String fa = textAddress.getText() + " " + "RT/" + textRT.getText() + "RW/" + textRW.getText() + " " + city.getSelectedItem().toString() + " " + province.getSelectedItem().toString() + " " + "(" + textPostcode.getText() + ")";
            String sql = "INSERT INTO biz_partner (partner_id, partner_id1, partner_id2, partner_id3, name, no_hp, email, country, province, city, rt, rw, postcode, address, register_date, tax_payer, npwp_no, pph,pic1,pic2,pic3,price,cordination,delivery,quality,remark,fulladd) VALUES (?,?,?,?,?,?,?,?,?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
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
            stmt.setString(20, t_hp_pic.getText());
            stmt.setString(21, customTextfield8.getText());
            stmt.setString(22, comboBoxSuggestion8.getSelectedItem().toString());
            stmt.setString(23, comboBoxSuggestion9.getSelectedItem().toString());
            stmt.setString(24, comboBoxSuggestion10.getSelectedItem().toString());
            stmt.setString(25, comboBoxSuggestion11.getSelectedItem().toString());
            stmt.setString(26, customTextfield14.getText());
            stmt.setString(27, fa);
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
            city.removeAllItems();
            ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM cities WHERE state_name ='" + province.getSelectedItem().toString() + "'");
            while (myRess.next()) {

                city.addItem(myRess.getString("name"));
//                idIntegrated.setText("" + boxID1.getSelectedItem() + "-" + boxID2.getSelectedItem() + "-" + id + "");
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
            myModel1.removeRow(0);
        }
        if (mySearch != null) {
            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM biz_partner WHERE " + b + " LIKE '%" + mySearch + "%'");
                while (rs.next()) {
                    String add = rs.getString("address") + " RT/RW " + rs.getString("rt") + "/" + rs.getString("rw");
                    String[] data = {
                        rs.getString("biz_id"),
                        rs.getString("partner_id"),
                        rs.getString("register_date"),
                        rs.getString("name"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("country"),
                        rs.getString("province"),
                        rs.getString("city"),
                        add,
                        rs.getString("postcode"),
                        rs.getString("tax_payer"),
                        rs.getString("npwp_no"),
                        rs.getString("pph"),
                        rs.getString("pic1"),
                        rs.getString("pic2"),
                        rs.getString("pic3"),
                        rs.getString("price"),
                        rs.getString("cordination"),
                        rs.getString("delivery"),
                        rs.getString("quality"),
                        rs.getString("remark"),};
                    String[] data1 = {data[0], data[1], data[3], data[8]};
                    myModel.insertRow(0, data);
                    myModel1.insertRow(0, data1);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        } else {
            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("select*from biz_partner");
                while (rs.next()) {
                    String add = rs.getString("address") + " RT/RW " + rs.getString("rt") + "/" + rs.getString("rw");
                    String[] data = {
                        rs.getString("biz_id"),
                        rs.getString("partner_id"),
                        rs.getString("register_date"),
                        rs.getString("name"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("country"),
                        rs.getString("province"),
                        rs.getString("city"),
                        add,
                        rs.getString("postcode"),
                        rs.getString("tax_payer"),
                        rs.getString("npwp_no"),
                        rs.getString("pph"),
                        rs.getString("pic1"),
                        rs.getString("pic2"),
                        rs.getString("pic3"),
                        rs.getString("price"),
                        rs.getString("cordination"),
                        rs.getString("delivery"),
                        rs.getString("quality"),
                        rs.getString("remark"),};
                    String[] data1 = {data[0], data[1], data[3], data[8]};
                    myModel.insertRow(0, data);
                    myModel1.insertRow(0, data1);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        }        // TODO add your handling code here:
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
            myModel1.removeRow(0);
        }
        if (mySearch != null) {
            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM biz_partner WHERE " + b + " LIKE '%" + mySearch + "%'");
                while (rs.next()) {
                    String add = rs.getString("address") + " RT/RW " + rs.getString("rt") + "/" + rs.getString("rw");
                    String[] data = {
                        rs.getString("biz_id"),
                        rs.getString("partner_id"),
                        rs.getString("register_date"),
                        rs.getString("name"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("country"),
                        rs.getString("province"),
                        rs.getString("city"),
                        add,
                        rs.getString("postcode"),
                        rs.getString("tax_payer"),
                        rs.getString("npwp_no"),
                        rs.getString("pph"),
                        rs.getString("pic1"),
                        rs.getString("pic2"),
                        rs.getString("pic3"),
                        rs.getString("price"),
                        rs.getString("cordination"),
                        rs.getString("delivery"),
                        rs.getString("quality"),
                        rs.getString("remark"),};
                    String[] data1 = {data[0], data[1], data[3], data[8]};
                    myModel.insertRow(0, data);
                    myModel1.insertRow(0, data1);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        } else {
            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("select*from biz_partner");
                while (rs.next()) {
                    String add = rs.getString("address") + " RT/RW " + rs.getString("rt") + "/" + rs.getString("rw");
                    String[] data = {
                        rs.getString("biz_id"),
                        rs.getString("partner_id"),
                        rs.getString("register_date"),
                        rs.getString("name"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("country"),
                        rs.getString("province"),
                        rs.getString("city"),
                        add,
                        rs.getString("postcode"),
                        rs.getString("tax_payer"),
                        rs.getString("npwp_no"),
                        rs.getString("pph"),
                        rs.getString("pic1"),
                        rs.getString("pic2"),
                        rs.getString("pic3"),
                        rs.getString("price"),
                        rs.getString("cordination"),
                        rs.getString("delivery"),
                        rs.getString("quality"),
                        rs.getString("remark"),};
                    String[] data1 = {data[0], data[1], data[3], data[8]};
                    myModel.insertRow(0, data);
                    myModel1.insertRow(0, data1);
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
            myModel1.removeRow(0);
        }
        if (mySearch != null) {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM biz_partner WHERE " + b + " LIKE '%" + mySearch + "%'");
                while (rs.next()) {
                    String add = rs.getString("address") + " RT/RW " + rs.getString("rt") + "/" + rs.getString("rw");

                    String[] data = {
                        rs.getString("biz_id"),
                        rs.getString("partner_id"),
                        rs.getString("register_date"),
                        rs.getString("name"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("country"),
                        rs.getString("province"),
                        rs.getString("city"),
                        add,
                        rs.getString("postcode"),
                        rs.getString("tax_payer"),
                        rs.getString("npwp_no"),
                        rs.getString("pph"),
                        rs.getString("pic1"),
                        rs.getString("pic2"),
                        rs.getString("pic3"),
                        rs.getString("price"),
                        rs.getString("cordination"),
                        rs.getString("delivery"),
                        rs.getString("quality"),
                        rs.getString("remark"),};
                    String[] data1 = {data[0], data[1], data[3], data[8]};
                    myModel.insertRow(0, data);
                    myModel1.insertRow(0, data1);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "data gagal tampil");
            }
        } else {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("select*from biz_partner");
                while (rs.next()) {
                    String add = rs.getString("address") + " RT/RW " + rs.getString("rt") + "/" + rs.getString("rw");

                    String[] data = {
                        rs.getString("biz_id"),
                        rs.getString("partner_id"),
                        rs.getString("register_date"),
                        rs.getString("name"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("country"),
                        rs.getString("province"),
                        rs.getString("city"),
                        add,
                        rs.getString("postcode"),
                        rs.getString("tax_payer"),
                        rs.getString("npwp_no"),
                        rs.getString("pph"),
                        rs.getString("pic1"),
                        rs.getString("pic2"),
                        rs.getString("pic3"),
                        rs.getString("price"),
                        rs.getString("cordination"),
                        rs.getString("delivery"),
                        rs.getString("quality"),
                        rs.getString("remark"),};
                    String[] data1 = {data[0], data[1], data[3], data[8]};
                    myModel.insertRow(0, data);
                    myModel1.insertRow(0, data1);
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
            jButton2.setVisible(true);
            set_kosong();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton2.setVisible(true);
        set_kosong();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int respon = JOptionPane.showConfirmDialog(null, "Are you done and want to save teh data and exit ?", "Option", JOptionPane.YES_NO_OPTION);
        if (respon == 0) {
            try {
                Statement stm = koneksi.createStatement();
                String sql = "update biz_partner set name='" + textName.getText() + "',no_hp ='" + t_hp.getText() + "',"
                        + "email='" + textMail.getText() + "',country='" + country.getSelectedItem().toString() + "',"
                        + "province='" + province.getSelectedItem().toString() + "',city='" + city.getSelectedItem().toString() + "',"
                        + "rt='" + textRT.getText() + "',rw='" + textRW.getText() + "',"
                        + "postcode='" + textPostcode.getText() + "',address='" + textAddress.getText() + "',"
                        + "register_date='" + textDateRegister.getText() + "',tax_payer='" + boxTax.getSelectedItem().toString() + "',"
                        + "npwp_no='" + textNPWP.getText() + "',pph='" + boxPPH.getSelectedItem().toString() + "',"
                        + "pic1='" + customTextfield6.getText() + "',pic2='" + t_hp_pic.getText() + "',"
                        + "pic3='" + customTextfield8.getText() + "',price='" + comboBoxSuggestion8.getSelectedItem().toString() + "',"
                        + "cordination='" + comboBoxSuggestion9.getSelectedItem().toString() + "',delivery='" + comboBoxSuggestion10.getSelectedItem().toString() + "',"
                        + "quality='" + comboBoxSuggestion11.getSelectedItem().toString() + "',remark='" + customTextfield14.getText() + "' where biz_id='" + id_biz + "'";
                stm.executeUpdate(sql);
                set_kosong();
                jButton2.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void t_hp_picActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_hp_picActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_hp_picActionPerformed

    private void idIntegratedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idIntegratedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idIntegratedActionPerformed

    private void boxTaxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_boxTaxPopupMenuWillBecomeVisible
boxTax.removeItem("Tax Payer");
// TODO add your handling code here:
    }//GEN-LAST:event_boxTaxPopupMenuWillBecomeVisible

    private void boxPPHPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_boxPPHPopupMenuWillBecomeVisible
        boxPPH.removeItem("PPh23 (%)"); // TODO add your handling code here:
    }//GEN-LAST:event_boxPPHPopupMenuWillBecomeVisible

    private void comboBoxSuggestion8PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboBoxSuggestion8PopupMenuWillBecomeVisible
        comboBoxSuggestion8.removeItem("Price");  // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSuggestion8PopupMenuWillBecomeVisible

    private void comboBoxSuggestion9PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboBoxSuggestion9PopupMenuWillBecomeVisible
        comboBoxSuggestion9.removeItem("Cordination");         // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSuggestion9PopupMenuWillBecomeVisible

    private void comboBoxSuggestion10PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboBoxSuggestion10PopupMenuWillBecomeVisible
        comboBoxSuggestion10.removeItem("Delivery");         // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSuggestion10PopupMenuWillBecomeVisible

    private void comboBoxSuggestion11PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboBoxSuggestion11PopupMenuWillBecomeVisible
        comboBoxSuggestion11.removeItem("Quality");         // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSuggestion11PopupMenuWillBecomeVisible

    private void boxTax1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_boxTax1PopupMenuWillBecomeVisible
        boxTax1.removeItem("Search Category");    // TODO add your handling code here:
    }//GEN-LAST:event_boxTax1PopupMenuWillBecomeVisible

    private void boxID1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_boxID1PopupMenuWillBecomeVisible
        boxID1.removeItem("ID #1");          // TODO add your handling code here:
    }//GEN-LAST:event_boxID1PopupMenuWillBecomeVisible

    private void boxID2PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_boxID2PopupMenuWillBecomeVisible
        boxID2.removeItem("ID #2");      // TODO add your handling code here:
    }//GEN-LAST:event_boxID2PopupMenuWillBecomeVisible

    private void boxID2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxID2ActionPerformed
id_employee();
//       try {
//            String id = Integer.toString(id3);
//            ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM cities WHERE state_name ='" + province.getSelectedItem().toString() + "'");
//            while (myRess.next()) {
//                idIntegrated.setText("" + boxID1.getSelectedItem() + "-" + boxID2.getSelectedItem() + "-" + id + "");
//            }
//        } catch (SQLException ex) {
//        }        // TODO add your handling code here:
    }//GEN-LAST:event_boxID2ActionPerformed

    private void boxID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxID1ActionPerformed
        id_employee();        // TODO add your handling code here:
    }//GEN-LAST:event_boxID1ActionPerformed

    private void MyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyTableMouseClicked
        int row = MyTable.getSelectedRow();
        MyTable2.setRowSelectionInterval(row, row);
        String a = ((String) MyTable.getValueAt(row, 0));
        id_biz = a;
        System.out.println(a);
        try {
            Statement stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from biz_partner where biz_id = " + a + "");
            while (rs.next()) {
                customTextfield6.setText(rs.getString("pic1"));
                t_hp_pic.setText(rs.getString("pic2"));
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
//                boxID1.setSelectedItem("ID #1");
//                boxID2.setSelectedItem("ID #2");
                idIntegrated.setText(rs.getString("partner_id"));
                textID3.setText("");
                jButton2.setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_MyTableMouseClicked

    private void t_hp_picKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_hp_picKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        String a;
        String b = "-";
        if (t_hp_pic.getText().length() < 3) {
            t_hp_pic.setText("(0)");
        } else if (t_hp_pic.getText().length() == 6) {
            t_hp_pic.setText(t_hp_pic.getText() + "-");
        } else if (t_hp_pic.getText().length() == 7) {
            StringBuffer sb = new StringBuffer(t_hp_pic.getText());
            sb.setLength(6);
            t_hp_pic.setText("" + sb);
        } else if (t_hp_pic.getText().length() == 11) {
            t_hp_pic.setText(t_hp_pic.getText() + "-");
        } else if (t_hp_pic.getText().length() == 12) {
            StringBuffer sb = new StringBuffer(t_hp_pic.getText());
            sb.setLength(11);
            t_hp_pic.setText("" + sb);
        } else if (t_hp_pic.getText().length() == 17) {
            t_hp_pic.setText(t_hp_pic.getText());
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_t_hp_picKeyTyped

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
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
            myModel1.removeRow(0);
        }
        if (mySearch != null) {

            try {
                stm = koneksi.createStatement();
                rs = stm.executeQuery("SELECT * FROM biz_partner WHERE " + b + " LIKE '%" + mySearch + "%' AND register_date BETWEEN '" + stgl.getText() + "' AND '" + etgl.getText() + "' ");
                while (rs.next()) {
                    String add = rs.getString("address") + " RT/RW " + rs.getString("rt") + "/" + rs.getString("rw");

                    String[] data = {
                        rs.getString("biz_id"),
                        rs.getString("partner_id"),
                        rs.getString("register_date"),
                        rs.getString("name"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("country"),
                        rs.getString("province"),
                        rs.getString("city"),
                        add,
                        rs.getString("postcode"),
                        rs.getString("tax_payer"),
                        rs.getString("npwp_no"),
                        rs.getString("pph"),
                        rs.getString("pic1"),
                        rs.getString("pic2"),
                        rs.getString("pic3"),
                        rs.getString("price"),
                        rs.getString("cordination"),
                        rs.getString("delivery"),
                        rs.getString("quality"),
                        rs.getString("remark"),};
                    String[] data1 = {data[0], data[1], data[3], data[8]};
                    myModel.insertRow(0, data);
                    myModel1.insertRow(0, data1);

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
    }//GEN-LAST:event_jButton5ActionPerformed

    private void MyTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyTable2MouseClicked
        int row = MyTable2.getSelectedRow();
        MyTable.setRowSelectionInterval(row, row);
        String a = ((String) MyTable2.getValueAt(row, 0));
        id_biz = a;
        System.out.println(a);

        try {
            Statement stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from biz_partner where biz_id = " + a + "");
            while (rs.next()) {
                customTextfield6.setText(rs.getString("pic1"));
                t_hp_pic.setText(rs.getString("pic2"));
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
//                boxID1.setSelectedItem("ID #1");
//                boxID2.setSelectedItem("ID #2");
                idIntegrated.setText(rs.getString("partner_id"));
                textID3.setText("");
                jButton2.setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_MyTable2MouseClicked

    private void comboBoxSuggestion11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSuggestion11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSuggestion11ActionPerformed

    private void MyTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyTable2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MyTable2MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MyTable;
    private javax.swing.JTable MyTable2;
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
    private CustomResource.CustomTextfield customTextfield8;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private com.raven.datechooser.DateChooser dateChooser3;
    private CustomResource.CustomTextfield etgl;
    private CustomResource.CustomTextfield idIntegrated;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private CustomResource.ComboBoxSuggestion province;
    private CustomResource.CustomTextfield stgl;
    private CustomResource.CustomTextfield t_hp;
    private CustomResource.CustomTextfield t_hp_pic;
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
