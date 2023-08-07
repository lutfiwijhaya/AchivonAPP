/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import CustomResource.ColumnGroup;
import CustomResource.GroupableTableHeader;
import CustomResource.MySession;
import CustomResource.koneksi;
import Main.MasterForm;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import jnafilechooser.api.JnaFileChooser;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author hi
 */
public class EmployeeClearanceStatus extends MasterForm{
    Connection koneksi;
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
    String myDate = formatter.format(date);
    public EmployeeClearanceStatus() {
        initComponents();
        MyWindow();
        openDB();
        
        jScrollPane5.setWheelScrollingEnabled(false);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        
        DefaultTableModel dm = (DefaultTableModel) jTable5.getModel();
        
        dm.setDataVector(new Object[][]{
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""},
                    {"","","","","","","","",""}},
                    new Object[]
                    {"item", "qty", "status", "item", "qty", "status", "item", "qty", "status"});
//        jTable5 = new JTable(dm) {
//            @Override
//            protected JTableHeader createDefaultTableHeader() {
//                return new GroupableTableHeader(columnModel);
//            }
//        };
        TableColumnModel cm = jTable5.getColumnModel();
        ColumnGroup g_name = new ColumnGroup("General Item");
        g_name.add(cm.getColumn(0));
        g_name.add(cm.getColumn(1));
        g_name.add(cm.getColumn(2));
        
        ColumnGroup g_lang = new ColumnGroup("Safety & Quality \nRelated Items");
        g_lang.add(cm.getColumn(3));
        g_lang.add(cm.getColumn(4));
        g_lang.add(cm.getColumn(5));
        
        ColumnGroup g_other = new ColumnGroup("Tools & Consumables \nRelated Items");
        g_other.add(cm.getColumn(6));
        g_other.add(cm.getColumn(7));
        g_other.add(cm.getColumn(8));
//        g_lang.add(g_other);

        GroupableTableHeader header = new GroupableTableHeader(cm);
        header.addColumnGroup(g_name);
        header.addColumnGroup(g_lang);
        header.addColumnGroup(g_other);
        jTable5.setTableHeader(header);
        
        labelDiscipline.setText(MySession.get_JobPosition());
        labelName.setText(MySession.get_nama());
        labelPosition.setText(MySession.get_JobPosition());
        labelKTP.setText(MySession.get_ktp());
        labelNameSign.setText(MySession.get_nama());
        labelHP.setText(MySession.get_mobileNumber());
        labelDateSign.setText(formatter.format(date));
        
        jLabel16.setVisible(false);
        jLabel25.setVisible(false);
        jLabel26.setVisible(false);
        jLabel28.setVisible(false);
        
        jLabel31.setVisible(false);
        jLabel32.setVisible(false);
        
        jLabel4.setVisible(false);
        sendButton.setVisible(true);
        int mycount = dm.getRowCount();
        for (int i = 0; i < mycount; i++) {
            dm.removeRow(0);
        }
            try {
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery("select * from employee_clearance where karyawan_id = '"+MySession.get_karyawanID()+"'");
                if (rs.next()) {
                    sendButton.setVisible(false);
//                    SaveButton.setVisible(false);
                    jLabel16.setText(rs.getString(3));
                    jLabel25.setText(rs.getString(4));
                    jLabel26.setText(rs.getString(5));
                    jLabel28.setText(rs.getString(6));
                    jLabel31.setText(rs.getString(8));
                    jLabel32.setText(rs.getString(7));
                    jLabel4.setText(rs.getString(9));
                    
//                    DefaultTableModel dm = (DefaultTableModel) jTable5.getModel();
                    try{
                    Statement stmt0 = koneksi.createStatement();
                    ResultSet rs0 = stmt0.executeQuery("select * from employee_clearance_table where karyawan_id = '"+MySession.get_karyawanID()+"' order by clearance_table_id desc");
                        while (rs0.next()) {
                            String[] data = {
                                rs0.getString(3), 
                                rs0.getString(4), 
                                rs0.getString(5), 
                                rs0.getString(6), 
                                rs0.getString(7), 
                                rs0.getString(8), 
                                rs0.getString(9), 
                                rs0.getString(10), 
                                rs0.getString(11)
                            };
                            dm.insertRow(0, data);
                        }
                    }catch(SQLException myEX){
                        System.err.println("Error executing SQL query: " + myEX.getMessage());
                    }
                    if (jLabel16 != null) {
                    signTeamPred.setText(null);
                    try {
                            Statement stmt11 = koneksi.createStatement();
                            ResultSet rs11 = stmt11.executeQuery("select * from employee where karyawan_id = '"+jLabel16.getText()+"'");
                            if (rs11.next()) {
                                labelNameTeamPred.setText(rs11.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt1 = koneksi.createStatement();
                        ResultSet rs1 = stmt1.executeQuery("select * from signature where karyawan_id = '"+jLabel16.getText()+"'");
                        if (rs1.next()) {
                            byte[] imageData = rs1.getBytes("scan");
                            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                            BufferedImage bImage = ImageIO.read(bis);
                            ImageIcon Myicon = new ImageIcon(bImage);
                            signTeamPred.addComponentListener(new ComponentAdapter() {
                                @Override
                                public void componentResized(ComponentEvent e) {
                                    int width = signTeamPred.getWidth();
                                    int height = signTeamPred.getHeight();
                                    Image imageResize = Myicon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                                    signTeamPred.setIcon(new ImageIcon(imageResize));
                                }
                            });
                        }else{

                        }
                    } catch (Exception e) {
                    }
                }
                if (jLabel25 != null) {
                    signTeamRecd.setText(null);
                    try {
                            Statement stmt21 = koneksi.createStatement();
                            ResultSet rs21 = stmt21.executeQuery("select * from employee where karyawan_id = '"+jLabel25.getText()+"'");
                            if (rs21.next()) {
                                labelNameTeamRecd.setText(rs21.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt2 = koneksi.createStatement();
                        ResultSet rs2 = stmt2.executeQuery("select * from signature where karyawan_id = '"+jLabel25.getText()+"'");
                        if (rs2.next()) {
                            byte[] imageData = rs2.getBytes("scan");
                            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                            BufferedImage bImage = ImageIO.read(bis);
                            ImageIcon Myicon = new ImageIcon(bImage);
                            signTeamRecd.addComponentListener(new ComponentAdapter() {
                                @Override
                                public void componentResized(ComponentEvent e) {
                                    int width = signTeamRecd.getWidth();
                                    int height = signTeamRecd.getHeight();
                                    Image imageResize = Myicon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                                    signTeamRecd.setIcon(new ImageIcon(imageResize));
                                }
                            });
                        }else{
                            
                        }
                    } catch (Exception e) {
                    }
                }
                if (jLabel26 != null) {
                    signTeamRevd.setText(null);
                    try {
                            Statement stmt31 = koneksi.createStatement();
                            ResultSet rs31 = stmt31.executeQuery("select * from employee where karyawan_id = '"+jLabel26.getText()+"'");
                            if (rs31.next()) {
                                labelNameTeamRevd.setText(rs31.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt3 = koneksi.createStatement();
                        ResultSet rs3 = stmt3.executeQuery("select * from signature where karyawan_id = '"+jLabel26.getText()+"'");
                        if (rs3.next()) {
                            byte[] imageData = rs3.getBytes("scan");
                            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                            BufferedImage bImage = ImageIO.read(bis);
                            ImageIcon Myicon = new ImageIcon(bImage);
                            signTeamRevd.addComponentListener(new ComponentAdapter() {
                                @Override
                                public void componentResized(ComponentEvent e) {
                                    int width = signTeamRevd.getWidth();
                                    int height = signTeamRevd.getHeight();
                                    Image imageResize = Myicon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                                    signTeamRevd.setIcon(new ImageIcon(imageResize));
                                }
                            });
                        }else{
                            
                        }
                    } catch (Exception e) {
                    }
                }
                if (jLabel28 != null) {
                    signTeamMGR.setText(null);
                    try {
                            Statement stmt41 = koneksi.createStatement();
                            ResultSet rs41 = stmt41.executeQuery("select * from employee where karyawan_id = '"+jLabel28.getText()+"'");
                            if (rs41.next()) {
                                labelNameTeamMGR.setText(rs41.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt4 = koneksi.createStatement();
                        ResultSet rs4 = stmt4.executeQuery("select * from signature where karyawan_id = '"+jLabel28.getText()+"'");
                        if (rs4.next()) {
                            byte[] imageData = rs4.getBytes("scan");
                            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                            BufferedImage bImage = ImageIO.read(bis);
                            ImageIcon Myicon = new ImageIcon(bImage);
                            signTeamMGR.addComponentListener(new ComponentAdapter() {
                            @Override
                            public void componentResized(ComponentEvent e) {
                                int width = signTeamMGR.getWidth();
                                int height = signTeamMGR.getHeight();
                                Image imageResize = Myicon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                                signTeamMGR.setIcon(new ImageIcon(imageResize));
                            }
                        });
                        }else{
                            
                        }
                    } catch (Exception e) {
                    }
                }
                if (jLabel31 != null) {
                    signHRRevd.setText(null);
                    try {
                            Statement stmt51 = koneksi.createStatement();
                            ResultSet rs51 = stmt51.executeQuery("select * from employee where karyawan_id = '"+jLabel29.getText()+"'");
                            if (rs51.next()) {
                                labelNameHRRevd.setText(rs51.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt5 = koneksi.createStatement();
                        ResultSet rs5 = stmt5.executeQuery("select * from signature where karyawan_id = '"+jLabel31.getText()+"'");
                        if (rs5.next()) {
                            byte[] imageData = rs5.getBytes("scan");
                            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                            BufferedImage bImage = ImageIO.read(bis);
                            ImageIcon Myicon = new ImageIcon(bImage);
                            signHRRevd.addComponentListener(new ComponentAdapter() {
                                @Override
                                public void componentResized(ComponentEvent e) {
                                    int width = signHRRevd.getWidth();
                                    int height = signHRRevd.getHeight();
                                    Image imageResize = Myicon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                                    signHRRevd.setIcon(new ImageIcon(imageResize));
                                }
                            });
                        }else{
                            
                        }
                    } catch (Exception e) {
                    }
                }
                if (jLabel32 != null) {
                    signHRMGR.setText(null);
                    try {
                            Statement stmt61 = koneksi.createStatement();
                            ResultSet rs61 = stmt61.executeQuery("select * from employee where karyawan_id = '"+jLabel32.getText()+"'");
                            if (rs61.next()) {
                                labelNameHRMGR.setText(rs61.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt6 = koneksi.createStatement();
                        ResultSet rs6 = stmt6.executeQuery("select * from signature where karyawan_id = '"+jLabel31.getText()+"'");
                        if (rs6.next()) {
                            byte[] imageData = rs6.getBytes("scan");
                            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                            BufferedImage bImage = ImageIO.read(bis);
                            ImageIcon Myicon = new ImageIcon(bImage);
                            signHRMGR.addComponentListener(new ComponentAdapter() {
                                @Override
                                public void componentResized(ComponentEvent e) {
                                    int width = signHRMGR.getWidth();
                                    int height = signHRMGR.getHeight();
                                    Image imageResize = Myicon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                                    signHRMGR.setIcon(new ImageIcon(imageResize));
                                }
                            });
                        }else{
                            
                        }
                    } catch (Exception e) {
                    }
                }
                if (jLabel4 != null) {
                    signPresident.setText(null);
                    try {
                            Statement stmt71 = koneksi.createStatement();
                            ResultSet rs71 = stmt71.executeQuery("select * from employee where karyawan_id = '"+jLabel4.getText()+"'");
                            if (rs71.next()) {
                                labelNamePresident.setText(rs71.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt7 = koneksi.createStatement();
                        ResultSet rs7 = stmt7.executeQuery("select * from signature where karyawan_id = '"+jLabel4.getText()+"'");
                        if (rs7.next()) {
                            byte[] imageData = rs7.getBytes("scan");
                            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                            BufferedImage bImage = ImageIO.read(bis);
                            ImageIcon Myicon = new ImageIcon(bImage);
                            signPresident.addComponentListener(new ComponentAdapter() {
                                @Override
                                public void componentResized(ComponentEvent e) {
                                    int width = signPresident.getWidth();
                                    int height = signPresident.getHeight();
                                    Image imageResize = Myicon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                                    signPresident.setIcon(new ImageIcon(imageResize));
                                }
                            });
                        }else{

                        }
                    } catch (Exception e) {
                    }
                }
            
                }else{
                    labelNamePresident.setVisible(false);
                    signPresident.setVisible(false);
                    jLabel35.setVisible(false);

                    jLabel29.setVisible(false);
                    signHRRevd.setVisible(false);
                    labelNameHRRevd.setVisible(false);

                    jLabel33.setVisible(false);
                    signHRMGR.setVisible(false);
                    labelNameHRMGR.setVisible(false);
                    jLabel42.setVisible(false);

                    jLabel43.setVisible(false);
                    jLabel30.setVisible(false);
                    signTeamMGR.setVisible(false);
                    labelNameTeamMGR.setVisible(false);

                    jLabel34.setVisible(false);
                    signTeamRevd.setVisible(false);
                    labelNameTeamRevd.setVisible(false);

                    jLabel37.setVisible(false);
                    signTeamRecd.setVisible(false);
                    labelNameTeamRecd.setVisible(false);

                    jLabel40.setVisible(false);
                    signTeamPred.setVisible(false);
                    labelNameTeamPred.setVisible(false);
                    
//                    SaveButton.setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    private void openDB() {
        try {

            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new scroolbarWin11.ScrollPaneWin11();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane5 = new scroolbarWin11.ScrollPaneWin11();
        jTable5 = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        signTeamPred = new javax.swing.JLabel();
        labelNameTeamPred = new javax.swing.JLabel();
        signTeamRecd = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        labelNameTeamRecd = new javax.swing.JLabel();
        labelNameTeamRevd = new javax.swing.JLabel();
        signTeamRevd = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        labelNameTeamMGR = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        signTeamMGR = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        signHRRevd = new javax.swing.JLabel();
        labelNameHRRevd = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        labelNameHRMGR = new javax.swing.JLabel();
        signHRMGR = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelNamePresident = new javax.swing.JLabel();
        signPresident = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelDiscipline = new javax.swing.JLabel();
        labelNameSign = new javax.swing.JLabel();
        labelPosition = new javax.swing.JLabel();
        labelKTP = new javax.swing.JLabel();
        labelHP = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelDateSign = new javax.swing.JLabel();
        sendButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("EMPLOYEE CLEARANCE STATUS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, 20));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel11.setText("A. EMPLOYEE INFORMATION");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel12.setText("B. STATUS OF CLEARANCE");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, -1, 20));

        jLabel17.setText("I, mentioned above, return the following items received from the company in my name to the company (including the status ");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 850, -1, 20));

        jLabel18.setText("of the returned items when returning, it is impossible to transfer the items to another employee before the actual return,");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 870, -1, 20));

        jLabel19.setText(" and it is not possible to hand over to another employee). I pledge that I will take full responsibility for any disadvantages,");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 890, -1, 20));

        jLabel20.setText(" and that I will not raise any objection to the payments made in consideration of any payment such as salary, etc. ");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 910, -1, 20));
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 1260, 60, 20));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel22.setText("Name  : ");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 1070, -1, 20));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel24.setText("Date    :");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 1090, -1, 20));

        sendButton.setBackground(new java.awt.Color(51, 51, 255));
        sendButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sendButton.setForeground(new java.awt.Color(255, 255, 255));
        sendButton.setText("Kirim / Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        jPanel1.add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 1190, 170, 40));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel27.setText("Signature");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 970, -1, 20));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable5.setAutoscrolls(false);
        jScrollPane5.setViewportView(jTable5);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 670, 360));

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Pre'd");
        jLabel40.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 120, 20));

        signTeamPred.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamPred.setText("Signatute");
        signTeamPred.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamPred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamPredMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 120, 90));

        labelNameTeamPred.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamPred.setText("Name");
        labelNameTeamPred.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 120, 20));

        signTeamRecd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamRecd.setText("Signature");
        signTeamRecd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamRecd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamRecdMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 120, 90));

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Rec'd");
        jLabel37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 120, 20));

        labelNameTeamRecd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamRecd.setText("Name");
        labelNameTeamRecd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 120, 20));

        labelNameTeamRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamRevd.setText("Name");
        labelNameTeamRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 120, 20));

        signTeamRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamRevd.setText("Signature");
        signTeamRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamRevd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamRevdMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 120, 90));

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Rev'd");
        jLabel34.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 120, 20));

        jLabel26.setText("jLabel4");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, -1, -1));

        jLabel25.setText("jLabel4");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, -1));

        jLabel16.setText("jLabel4");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        labelNameTeamMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamMGR.setText("Name");
        labelNameTeamMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 120, 20));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("MGR");
        jLabel30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 120, 20));

        signTeamMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamMGR.setText("Signature");
        signTeamMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamMGR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamMGRMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 120, 90));

        jLabel28.setText("jLabel4");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, -1, -1));

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Rev'd");
        jLabel29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 120, 20));

        signHRRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signHRRevd.setText("Signature");
        signHRRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signHRRevd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signHRRevdMouseClicked(evt);
            }
        });
        jPanel1.add(signHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 120, 90));

        labelNameHRRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameHRRevd.setText("Name");
        labelNameHRRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, 120, 20));

        jLabel31.setText("jLabel4");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, -1, -1));

        jLabel32.setText("jLabel4");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 230, -1, -1));

        labelNameHRMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameHRMGR.setText("Name");
        labelNameHRMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, 120, 20));

        signHRMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signHRMGR.setText("Signature");
        signHRMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signHRMGR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signHRMGRMouseClicked(evt);
            }
        });
        jPanel1.add(signHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, 120, 90));

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("MGR");
        jLabel33.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 120, 20));

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("HR TEAM");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, 250, -1));

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 230, -1, -1));

        labelNamePresident.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNamePresident.setText("Name");
        labelNamePresident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNamePresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 210, 120, 20));

        signPresident.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signPresident.setText("Signature");
        signPresident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signPresident.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signPresidentMouseClicked(evt);
            }
        });
        jPanel1.add(signPresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 120, 120, 90));

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("President");
        jLabel35.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 100, 120, 20));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("TEAM");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 510, 20));

        jLabel1.setText("No. HP");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));

        jLabel3.setText("Discipline");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));

        jLabel5.setText("Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

        jLabel6.setText("Position");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        jLabel7.setText("No. KTP");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        jLabel8.setText(":");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 10, -1));

        jLabel9.setText(":");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 10, -1));

        jLabel10.setText(":");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 10, -1));

        jLabel13.setText(":");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 10, -1));

        jLabel14.setText(":");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 10, -1));

        labelDiscipline.setText("Discipline");
        jPanel1.add(labelDiscipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, -1, -1));

        labelNameSign.setText("Name");
        jPanel1.add(labelNameSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 1070, -1, 20));

        labelPosition.setText("Position");
        jPanel1.add(labelPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, -1));

        labelKTP.setText("No. KTP");
        jPanel1.add(labelKTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        labelHP.setText("No. HP");
        jPanel1.add(labelHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));

        labelName.setText("Name");
        jPanel1.add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));

        labelDateSign.setText("Name");
        jPanel1.add(labelDateSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 1090, -1, 20));

        sendButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sendButton1.setForeground(new java.awt.Color(51, 51, 255));
        sendButton1.setText("Save as Excel");
        sendButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(sendButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 1140, 170, 40));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void signTeamPredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signTeamPredMouseClicked
        if ("3".equals(MySession.get_Role())) {
            try {
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery("select * from signature where karyawan_id = '"+MySession.get_karyawanID()+"'");

                if (rs.next()) {
                    byte[] imageData = rs.getBytes("scan");
                    ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                    BufferedImage bImage = ImageIO.read(bis);
                    ImageIcon Myicon = new ImageIcon(bImage);
                    Image imageResize = Myicon.getImage().getScaledInstance(135, 90, Image.SCALE_SMOOTH);
                    signTeamPred.setIcon(new ImageIcon(imageResize));
                    labelNameTeamPred.setText(MySession.get_nama());
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Maaf, Hanya Tim yang dapat menandatangani bagian ini \nSorry, Only Team can sign this part");
        }
    }//GEN-LAST:event_signTeamPredMouseClicked

    private void signTeamRecdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signTeamRecdMouseClicked
        if ("3".equals(MySession.get_Role())) {
            try {
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery("select * from signature where karyawan_id = '"+MySession.get_karyawanID()+"'");

                if (rs.next()) {
                    byte[] imageData = rs.getBytes("scan");
                    ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                    BufferedImage bImage = ImageIO.read(bis);
                    ImageIcon Myicon = new ImageIcon(bImage);
                    Image imageResize = Myicon.getImage().getScaledInstance(135, 90, Image.SCALE_SMOOTH);
                    signTeamRecd.setIcon(new ImageIcon(imageResize));
                    labelNameTeamRecd.setText(MySession.get_nama());
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Maaf, Hanya Tim yang dapat menandatangani bagian ini \nSorry, Only Team can sign this part");
        }
    }//GEN-LAST:event_signTeamRecdMouseClicked

    private void signTeamRevdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signTeamRevdMouseClicked
        if ("3".equals(MySession.get_Role())) {
            try {
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery("select * from signature where karyawan_id = '"+MySession.get_karyawanID()+"'");

                if (rs.next()) {
                    byte[] imageData = rs.getBytes("scan");
                    ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                    BufferedImage bImage = ImageIO.read(bis);
                    ImageIcon Myicon = new ImageIcon(bImage);
                    Image imageResize = Myicon.getImage().getScaledInstance(135, 90, Image.SCALE_SMOOTH);
                    signTeamRevd.setIcon(new ImageIcon(imageResize));
                    labelNameTeamRevd.setText(MySession.get_nama());
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Maaf, Hanya Tim yang dapat menandatangani bagian ini \nSorry, Only Team can sign this part");
        }
    }//GEN-LAST:event_signTeamRevdMouseClicked

    private void signTeamMGRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signTeamMGRMouseClicked
        if ("3".equals(MySession.get_Role())) {
            try {
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery("select * from signature where karyawan_id = '"+MySession.get_karyawanID()+"'");

                if (rs.next()) {
                    byte[] imageData = rs.getBytes("scan");
                    ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                    BufferedImage bImage = ImageIO.read(bis);
                    ImageIcon Myicon = new ImageIcon(bImage);
                    Image imageResize = Myicon.getImage().getScaledInstance(135, 90, Image.SCALE_SMOOTH);
                    signTeamMGR.setIcon(new ImageIcon(imageResize));
                    labelNameTeamMGR.setText(MySession.get_nama());
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Maaf, Hanya Tim yang dapat menandatangani bagian ini \nSorry, Only Team can sign this part");
        }
    }//GEN-LAST:event_signTeamMGRMouseClicked

    private void signHRRevdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signHRRevdMouseClicked
        if ("2".equals(MySession.get_Role())) {
            try {
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery("select * from signature where karyawan_id = '"+MySession.get_karyawanID()+"'");

                if (rs.next()) {
                    byte[] imageData = rs.getBytes("scan");
                    ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                    BufferedImage bImage = ImageIO.read(bis);
                    ImageIcon Myicon = new ImageIcon(bImage);
                    Image imageResize = Myicon.getImage().getScaledInstance(135, 90, Image.SCALE_SMOOTH);
                    signHRRevd.setIcon(new ImageIcon(imageResize));
                    labelNameHRRevd.setText(MySession.get_nama());
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Maaf, Hanya HR Team yang dapat menandatangani bagian ini \nSorry, Only HR Team can sign this part");
        }
    }//GEN-LAST:event_signHRRevdMouseClicked

    private void signHRMGRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signHRMGRMouseClicked
        if ("2".equals(MySession.get_Role())) {
            try {
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery("select * from signature where karyawan_id = '"+MySession.get_karyawanID()+"'");

                if (rs.next()) {
                    byte[] imageData = rs.getBytes("scan");
                    ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                    BufferedImage bImage = ImageIO.read(bis);
                    ImageIcon Myicon = new ImageIcon(bImage);
                    Image imageResize = Myicon.getImage().getScaledInstance(135, 90, Image.SCALE_SMOOTH);
                    signHRMGR.setIcon(new ImageIcon(imageResize));
                    labelNameHRMGR.setText(MySession.get_nama());
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Maaf, Hanya HR Team yang dapat menandatangani bagian ini \nSorry, Only HR Team can sign this part");
        }
    }//GEN-LAST:event_signHRMGRMouseClicked

    private void signPresidentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signPresidentMouseClicked
        if ("1".equals(MySession.get_Role())) {
            try {
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery("select * from signature where karyawan_id = '"+MySession.get_karyawanID()+"'");

                if (rs.next()) {
                    byte[] imageData = rs.getBytes("scan");
                    ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                    BufferedImage bImage = ImageIO.read(bis);
                    ImageIcon Myicon = new ImageIcon(bImage);
                    Image imageResize = Myicon.getImage().getScaledInstance(135, 90, Image.SCALE_SMOOTH);
                    signPresident.setIcon(new ImageIcon(imageResize));
                    labelNamePresident.setText(MySession.get_nama());
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_signPresidentMouseClicked

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        String sql = "INSERT INTO employee_clearance (karyawan_id, team_pred, team_recd, team_revd, team_mgr, hr_revd, hr_mgr, president, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pstmt = koneksi.prepareStatement(sql);
            pstmt.setString(1, MySession.get_karyawanID());
            pstmt.setString(2, "0");
            pstmt.setString(3, "0");
            pstmt.setString(4, "0");
            pstmt.setString(5, "0");
            pstmt.setString(6, "0");
            pstmt.setString(7, "0");
            pstmt.setString(8, "0");
            pstmt.setString(9, myDate);
            pstmt.executeUpdate();
            int jtabelrows = jTable5.getRowCount();
            for (int i = 0; i <= jtabelrows - 1; i++) {
                if (jTable5.getValueAt(i, 0) == null || jTable5.getValueAt(i, 0).toString().isEmpty()) {
                    continue;
                } else {
                    String general_item = jTable5.getValueAt(i, 0).toString();
                    String general_qty = jTable5.getValueAt(i, 1) != null ? jTable5.getValueAt(i, 1).toString() : "";
                    String general_status = jTable5.getValueAt(i, 2) != null ? jTable5.getValueAt(i, 1).toString() : "";
                    String safety_item = jTable5.getValueAt(i, 3).toString();
                    String safety_qty = jTable5.getValueAt(i, 4) != null ? jTable5.getValueAt(i, 1).toString() : "";
                    String safety_status = jTable5.getValueAt(i, 5) != null ? jTable5.getValueAt(i, 1).toString() : "";
                    String tools_item = jTable5.getValueAt(i, 6).toString();
                    String tools_qty = jTable5.getValueAt(i, 7) != null ? jTable5.getValueAt(i, 1).toString() : "";
                    String tools_status = jTable5.getValueAt(i, 8) != null ? jTable5.getValueAt(i, 1).toString() : "";

                    String sql1 = "INSERT INTO employee_clearance_table (karyawan_id, general_item, general_qty, general_status, safety_item, safety_qty, safety_status, tools_item, tools_qty, tools_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    pstmt1 = koneksi.prepareStatement(sql1);
                    pstmt1.setString(1, MySession.get_karyawanID());
                    pstmt1.setString(2, general_item);
                    pstmt1.setString(3, general_qty);
                    pstmt1.setString(4, general_status);
                    pstmt1.setString(5, safety_item);
                    pstmt1.setString(6, safety_qty);
                    pstmt1.setString(7, safety_status);
                    pstmt1.setString(8, tools_item);
                    pstmt1.setString(9, tools_qty);
                    pstmt1.setString(10, tools_status);
                    pstmt1.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(null, "Data berhasil dikirim \nData sent successfully");
            labelNamePresident.setVisible(true);
            signPresident.setVisible(true);
            jLabel35.setVisible(true);

            jLabel29.setVisible(true);
            signHRRevd.setVisible(true);
            labelNameHRRevd.setVisible(true);

            jLabel33.setVisible(true);
            signHRMGR.setVisible(true);
            labelNameHRMGR.setVisible(true);
            jLabel42.setVisible(true);

            jLabel43.setVisible(true);
            jLabel30.setVisible(true);
            signTeamMGR.setVisible(true);
            labelNameTeamMGR.setVisible(true);

            jLabel34.setVisible(true);
            signTeamRevd.setVisible(true);
            labelNameTeamRevd.setVisible(true);

            jLabel37.setVisible(true);
            signTeamRecd.setVisible(true);
            labelNameTeamRecd.setVisible(true);

            jLabel40.setVisible(true);
            signTeamPred.setVisible(true);
            labelNameTeamPred.setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal dikirim \nData failed to send");
            e.printStackTrace();
        } finally {
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void sendButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButton1ActionPerformed
        tracer();
    }//GEN-LAST:event_sendButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable5;
    private javax.swing.JLabel labelDateSign;
    private javax.swing.JLabel labelDiscipline;
    private javax.swing.JLabel labelHP;
    private javax.swing.JLabel labelKTP;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelNameHRMGR;
    private javax.swing.JLabel labelNameHRRevd;
    private javax.swing.JLabel labelNamePresident;
    private javax.swing.JLabel labelNameSign;
    private javax.swing.JLabel labelNameTeamMGR;
    private javax.swing.JLabel labelNameTeamPred;
    private javax.swing.JLabel labelNameTeamRecd;
    private javax.swing.JLabel labelNameTeamRevd;
    private javax.swing.JLabel labelPosition;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton sendButton1;
    private javax.swing.JLabel signHRMGR;
    private javax.swing.JLabel signHRRevd;
    private javax.swing.JLabel signPresident;
    private javax.swing.JLabel signTeamMGR;
    private javax.swing.JLabel signTeamPred;
    private javax.swing.JLabel signTeamRecd;
    private javax.swing.JLabel signTeamRevd;
    // End of variables declaration//GEN-END:variables

    private void MyWindow(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height-45);
        this.setPreferredSize(new Dimension(screen.width, screen.height-100));
    }
    
    private void tracer(){
        String templateFilePath = "src/Doc/Employment Clearance Status.xlsx";
        
        try {
            FileInputStream templateFile = new FileInputStream(templateFilePath);
            Workbook workbook = new XSSFWorkbook(templateFile);
            
            Sheet sheet = workbook.getSheet("Sheet1");
            
            ImageIcon iconPresident = (ImageIcon) signPresident.getIcon();
            ImageIcon iconHRMGR = (ImageIcon) signHRMGR.getIcon();
            ImageIcon iconHRRevd = (ImageIcon) signHRRevd.getIcon();
            ImageIcon iconTeamMGR = (ImageIcon) signTeamMGR.getIcon();
            ImageIcon iconTeamRevd = (ImageIcon) signTeamRevd.getIcon();
            ImageIcon iconTeamRecd = (ImageIcon) signTeamRecd.getIcon();
            ImageIcon iconTeamPred = (ImageIcon) signTeamPred.getIcon();
            
            if (iconPresident == null) {
                sheet.getRow(3).getCell(13).setCellValue("");
            }else{
                Image image = iconPresident.getImage();
                BufferedImage bufferedImage = new BufferedImage(
                    image.getWidth(null),
                    image.getHeight(null),
                    BufferedImage.TYPE_INT_ARGB
                );
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(image, 0, 0, null);
                g2d.dispose();

                int pictureIdx = workbook.addPicture(bufferedImageToByteArray(bufferedImage), Workbook.PICTURE_TYPE_PNG);
                CreationHelper helper = workbook.getCreationHelper();
                Drawing drawing = sheet.createDrawingPatriarch();
                ClientAnchor anchor = helper.createClientAnchor();
                anchor.setCol1(13);
                anchor.setRow1(3);
                Picture picture = drawing.createPicture(anchor, pictureIdx);
                picture.resize(1.0, 1.0);
                sheet.getRow(6).getCell(13).setCellValue(labelNamePresident.getText().trim().toString());
            }
            if (iconHRMGR == null) {
                sheet.getRow(3).getCell(10).setCellValue("");
            }else{
                Image image = iconHRMGR.getImage();
                BufferedImage bufferedImage = new BufferedImage(
                    image.getWidth(null),
                    image.getHeight(null),
                    BufferedImage.TYPE_INT_ARGB
                );
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(image, 0, 0, null);
                g2d.dispose();

                int pictureIdx = workbook.addPicture(bufferedImageToByteArray(bufferedImage), Workbook.PICTURE_TYPE_PNG);
                CreationHelper helper = workbook.getCreationHelper();
                Drawing drawing = sheet.createDrawingPatriarch();
                ClientAnchor anchor = helper.createClientAnchor();
                anchor.setCol1(10);
                anchor.setRow1(3);
                Picture picture = drawing.createPicture(anchor, pictureIdx);
                picture.resize(1.0, 1.0);
                sheet.getRow(6).getCell(10).setCellValue(labelNameHRMGR.getText().trim());
            }
            
            if (iconHRRevd == null) {
                sheet.getRow(3).getCell(8).setCellValue("");
            }else{
                Image image = iconHRRevd.getImage();
                BufferedImage bufferedImage = new BufferedImage(
                    image.getWidth(null),
                    image.getHeight(null),
                    BufferedImage.TYPE_INT_ARGB
                );
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(image, 0, 0, null);
                g2d.dispose();

                int pictureIdx = workbook.addPicture(bufferedImageToByteArray(bufferedImage), Workbook.PICTURE_TYPE_PNG);
                CreationHelper helper = workbook.getCreationHelper();
                Drawing drawing = sheet.createDrawingPatriarch();
                ClientAnchor anchor = helper.createClientAnchor();
                anchor.setCol1(8);
                anchor.setRow1(3);
                Picture picture = drawing.createPicture(anchor, pictureIdx);
                picture.resize(1.0, 1.0);
                sheet.getRow(6).getCell(8).setCellValue(labelNameHRRevd.getText().trim());
            }
            
            if (iconTeamMGR == null) {
                sheet.getRow(3).getCell(4).setCellValue("");
            }else{
                Image image = iconTeamMGR.getImage();
                BufferedImage bufferedImage = new BufferedImage(
                    image.getWidth(null),
                    image.getHeight(null),
                    BufferedImage.TYPE_INT_ARGB
                );
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(image, 0, 0, null);
                g2d.dispose();

                int pictureIdx = workbook.addPicture(bufferedImageToByteArray(bufferedImage), Workbook.PICTURE_TYPE_PNG);
                CreationHelper helper = workbook.getCreationHelper();
                Drawing drawing = sheet.createDrawingPatriarch();
                ClientAnchor anchor = helper.createClientAnchor();
                anchor.setCol1(4);
                anchor.setRow1(3);
                Picture picture = drawing.createPicture(anchor, pictureIdx);
                picture.resize(1.0, 1.0);
                sheet.getRow(6).getCell(4).setCellValue(labelNameTeamMGR.getText().trim());
            }
            
            if (iconTeamRevd == null) {
                sheet.getRow(3).getCell(3).setCellValue("");
            }else{
                Image image = iconTeamRevd.getImage();
                BufferedImage bufferedImage = new BufferedImage(
                    image.getWidth(null),
                    image.getHeight(null),
                    BufferedImage.TYPE_INT_ARGB
                );
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(image, 0, 0, null);
                g2d.dispose();

                int pictureIdx = workbook.addPicture(bufferedImageToByteArray(bufferedImage), Workbook.PICTURE_TYPE_PNG);
                CreationHelper helper = workbook.getCreationHelper();
                Drawing drawing = sheet.createDrawingPatriarch();
                ClientAnchor anchor = helper.createClientAnchor();
                anchor.setCol1(3);
                anchor.setRow1(3);
                Picture picture = drawing.createPicture(anchor, pictureIdx);
                picture.resize(1.0, 1.0);
                sheet.getRow(6).getCell(3).setCellValue(labelNameTeamRevd.getText().trim());
            }
            
            if (iconTeamRecd == null) {
                sheet.getRow(3).getCell(2).setCellValue("");
            }else{
                Image image = iconTeamRevd.getImage();
                BufferedImage bufferedImage = new BufferedImage(
                    image.getWidth(null),
                    image.getHeight(null),
                    BufferedImage.TYPE_INT_ARGB
                );
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(image, 0, 0, null);
                g2d.dispose();

                int pictureIdx = workbook.addPicture(bufferedImageToByteArray(bufferedImage), Workbook.PICTURE_TYPE_PNG);
                CreationHelper helper = workbook.getCreationHelper();
                Drawing drawing = sheet.createDrawingPatriarch();
                ClientAnchor anchor = helper.createClientAnchor();
                anchor.setCol1(2);
                anchor.setRow1(3);
                Picture picture = drawing.createPicture(anchor, pictureIdx);
                picture.resize(1.0, 1.0);
                sheet.getRow(6).getCell(2).setCellValue(labelNameTeamRecd.getText().trim());
            }
            
            if (iconTeamPred == null) {
                sheet.getRow(3).getCell(1).setCellValue("");
            }else{
                Image image = iconTeamRevd.getImage();
                BufferedImage bufferedImage = new BufferedImage(
                    image.getWidth(null),
                    image.getHeight(null),
                    BufferedImage.TYPE_INT_ARGB
                );
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(image, 0, 0, null);
                g2d.dispose();

                int pictureIdx = workbook.addPicture(bufferedImageToByteArray(bufferedImage), Workbook.PICTURE_TYPE_PNG);
                CreationHelper helper = workbook.getCreationHelper();
                Drawing drawing = sheet.createDrawingPatriarch();
                ClientAnchor anchor = helper.createClientAnchor();
                anchor.setCol1(1);
                anchor.setRow1(3);
                Picture picture = drawing.createPicture(anchor, pictureIdx);
                picture.resize(1.0, 1.0);
                sheet.getRow(6).getCell(1).setCellValue(labelNameTeamPred.getText().trim());
            }
            
            sheet.getRow(9).getCell(2).setCellValue(labelDiscipline.getText());
            sheet.getRow(10).getCell(2).setCellValue(labelName.getText().trim());
            sheet.getRow(9).getCell(10).setCellValue(labelPosition.getText());
            sheet.getRow(10).getCell(10).setCellValue(labelKTP.getText());
            sheet.getRow(11).getCell(10).setCellValue(labelHP.getText());
            
            sheet.getRow(43).getCell(9).setCellValue(labelDateSign.getText());
            sheet.getRow(47).getCell(9).setCellValue(labelNameSign.getText());
            
            DefaultTableModel model5 = (DefaultTableModel) jTable5.getModel();
            int rowCount5 = model5.getRowCount();
            for (int i = 0; i < rowCount5; i++) {
                String description = (String) model5.getValueAt(i, 0);
                String description1 = (String) model5.getValueAt(i, 1);
                String description2 = (String) model5.getValueAt(i, 2);
                String description3 = (String) model5.getValueAt(i, 3);
                String description4 = (String) model5.getValueAt(i, 4);
                String description5 = (String) model5.getValueAt(i, 5);
                String description6 = (String) model5.getValueAt(i, 6);
                String description7 = (String) model5.getValueAt(i, 7);
                String description8 = (String) model5.getValueAt(i, 8);
                
                sheet.getRow(17+i).getCell(0).setCellValue(i+1);
                sheet.getRow(17+i).getCell(1).setCellValue(description);
                sheet.getRow(17+i).getCell(2).setCellValue(description1);
                sheet.getRow(17+i).getCell(3).setCellValue(description2);
                sheet.getRow(17+i).getCell(4).setCellValue(description3);
                sheet.getRow(17+i).getCell(6).setCellValue(description4);
                sheet.getRow(17+i).getCell(8).setCellValue(description5);
                sheet.getRow(17+i).getCell(10).setCellValue(description6);
                sheet.getRow(17+i).getCell(14).setCellValue(description7);
                sheet.getRow(17+i).getCell(15).setCellValue(description8);
            }
            
            templateFile.close();

            JnaFileChooser fileChooser = new JnaFileChooser();
            fileChooser.setTitle("Simpan File Output");
            fileChooser.addFilter("Excel Files", "xlsx");
            boolean userSelection = fileChooser.showSaveDialog(null);

            if (userSelection) {
                File outputFile = fileChooser.getSelectedFile();
                String outputFilePath = outputFile.getAbsolutePath();
                if (!outputFilePath.toLowerCase().endsWith(".xlsx")) {
                    outputFilePath += ".xlsx";
                    outputFile = new File(outputFilePath);
                }
                int count = 1;
                while (outputFile.exists()) {
                    String newFileName = outputFile.getName().replaceFirst("[.][^.]+$", "") + "(" + count + ")"
                            + outputFile.getName().substring(outputFile.getName().lastIndexOf("."));
                    String parentDirectory = outputFile.getParent();
                    outputFilePath = parentDirectory + File.separator + newFileName;
                    outputFile = new File(outputFilePath);
                    count++;
                }

                FileOutputStream outputFileStream = new FileOutputStream(outputFile);
                workbook.write(outputFileStream);
                workbook.close();
                outputFileStream.close();
                JOptionPane.showMessageDialog(this, "Berhasil Menyimpan File\nSuccess Saving File");
            } else {
                JOptionPane.showMessageDialog(this, "Maaf Terjadi Kesalahan Gagal Menyimpan File\nSorry, an error occurred Failed to Saving File");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private byte[] bufferedImageToByteArray(BufferedImage image) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void formrefresh() {
    }
}
