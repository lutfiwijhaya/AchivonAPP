/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import CustomResource.EmployeeSession;
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
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
 * @author USER
 */
public class EmployeeConfirmationHandingOverTakingOver extends MasterForm {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    public EmployeeConfirmationHandingOverTakingOver() {
        initComponents();
        MyWindow();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        openDB();
        ((DefaultTableCellRenderer)jTable4.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);
        labelID.setVisible(false);
        SendButton.setVisible(true);
//        SaveButton.setVisible(false);
        idTeamPred.setVisible(false);
        idTeamRecd.setVisible(false);
        idTeamRevd.setVisible(false);
        idTeamMGR.setVisible(false);
                   
        idHRRevd.setVisible(false);
        idHRMGR.setVisible(false);
                    
        idPresident.setVisible(false);
        
        try {
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM employee_handover inner join employee on employee_handover.karyawan_id = employee.karyawan_id where ktp = '"+EmployeeSession.getKTPHandover()+"'");
                if (rs.next()) {
                    labelID.setText(rs.getString(2));
                    labelDiscipline.setText(rs.getString(25));
                    labelName.setText(rs.getString(15));
                    labelPosition.setText(rs.getString(25));
                    labelKTP.setText(rs.getString(14));
//                    labelHP.setText(MySession.get_mobileNumber());
                    SendButton.setVisible(true);
                    idTeamPred.setText(rs.getString(3));
                    idTeamRecd.setText(rs.getString(4));
                    idTeamRevd.setText(rs.getString(5));
                    idTeamMGR.setText(rs.getString(6));
                    idHRRevd.setText(rs.getString(7));
                    idHRMGR.setText(rs.getString(8));
                    idPresident.setText(rs.getString(9));
                    expec_date.setText(rs.getString(11));
                    
                    DefaultTableModel dataModel = (DefaultTableModel) jTable4.getModel();
                    Statement stmt0 = koneksi.createStatement();
                    ResultSet rs0 = stmt0.executeQuery("select * from employee_handover_table where karyawan_id = '"+labelID.getText()+"' order by handover_table_id desc");
                        while (rs0.next()) {
                            String[] data = {
                                rs0.getString(3), 
                                rs0.getString(4), 
                                rs0.getString(5), 
                                rs0.getString(6)
                            };
                            dataModel.insertRow(0, data);
                        }
                    if (idTeamPred != null) {
                        signTeamPred.setText(null);
                        try {
                            Statement stmt11 = koneksi.createStatement();
                            ResultSet rs11 = stmt11.executeQuery("select * from employee where karyawan_id = '"+idTeamPred.getText()+"'");
                            if (rs11.next()) {
                                labelNameTeamPred.setText(rs11.getString(4));
                            }
                        } catch (Exception e) {
                        }
                        try {
                            Statement stmt1 = koneksi.createStatement();
                            ResultSet rs1 = stmt1.executeQuery("select * from signature where karyawan_id = '"+idTeamPred.getText()+"'");
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
                    if (idTeamRecd != null) {
                        signTeamRecd.setText(null);
                        try {
                            Statement stmt21 = koneksi.createStatement();
                            ResultSet rs21 = stmt21.executeQuery("select * from employee where karyawan_id = '"+idTeamRecd.getText()+"'");
                            if (rs21.next()) {
                                labelNameTeamRecd.setText(rs21.getString(4));
                            }
                        } catch (Exception e) {
                        }
                        try {
                            Statement stmt2 = koneksi.createStatement();
                            ResultSet rs2 = stmt2.executeQuery("select * from signature where karyawan_id = '"+idTeamRecd.getText()+"'");
                            if (rs2.next()) {
                                byte[] imageData = rs2.getBytes("scan");
                                ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                                BufferedImage bImage = ImageIO.read(bis);
                                ImageIcon Myicon = new ImageIcon(bImage);signTeamRecd.addComponentListener(new ComponentAdapter() {
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
                    if (idTeamRevd != null) {
                        signTeamRevd.setText(null);
                        try {
                            Statement stmt31 = koneksi.createStatement();
                            ResultSet rs31 = stmt31.executeQuery("select * from employee where karyawan_id = '"+idTeamRevd.getText()+"'");
                            if (rs31.next()) {
                                labelNameTeamRevd.setText(rs31.getString(4));
                            }
                        } catch (Exception e) {
                        }
                        try {
                            Statement stmt3 = koneksi.createStatement();
                            ResultSet rs3 = stmt3.executeQuery("select * from signature where karyawan_id = '"+idTeamRevd.getText()+"'");
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
                    if (idTeamMGR != null) {
                        signTeamMGR.setText(null);
                        try {
                            Statement stmt41 = koneksi.createStatement();
                            ResultSet rs41 = stmt41.executeQuery("select * from employee where karyawan_id = '"+idTeamMGR.getText()+"'");
                            if (rs41.next()) {
                                labelNameTeamMGR.setText(rs41.getString(4));
                            }
                        } catch (Exception e) {
                        }
                        try {
                            Statement stmt4 = koneksi.createStatement();
                            ResultSet rs4 = stmt4.executeQuery("select * from signature where karyawan_id = '"+idTeamMGR.getText()+"'");
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
                    if (idHRRevd != null) {
                        signHRRevd.setText(null);
                        try {
                            Statement stmt51 = koneksi.createStatement();
                            ResultSet rs51 = stmt51.executeQuery("select * from employee where karyawan_id = '"+idHRRevd.getText()+"'");
                            if (rs51.next()) {
                                labelNameHRRevd.setText(rs51.getString(4));
                            }
                        } catch (Exception e) {
                        }
                        try {
                            Statement stmt5 = koneksi.createStatement();
                            ResultSet rs5 = stmt5.executeQuery("select * from signature where karyawan_id = '"+idHRRevd.getText()+"'");
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
                    if (idHRMGR != null) {
                        signHRMGR.setText(null);
                        try {
                            Statement stmt61 = koneksi.createStatement();
                            ResultSet rs61 = stmt61.executeQuery("select * from employee where karyawan_id = '"+idHRMGR.getText()+"'");
                            if (rs61.next()) {
                                labelNameHRMGR.setText(rs61.getString(4));
                            }
                        } catch (Exception e) {
                        }
                        try {
                            Statement stmt6 = koneksi.createStatement();
                            ResultSet rs6 = stmt6.executeQuery("select * from signature where karyawan_id = '"+idHRMGR.getText()+"'");
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
                    if (idPresident != null) {
                        signPresident.setText(null);
                        try {
                            Statement stmt71 = koneksi.createStatement();
                            ResultSet rs71 = stmt71.executeQuery("select * from employee where karyawan_id = '"+idPresident.getText()+"'");
                            if (rs71.next()) {
                                labelNamePresident.setText(rs71.getString(4));
                            }
                        } catch (Exception e) {
                        }
                        try {
                            Statement stmt7 = koneksi.createStatement();
                            ResultSet rs7 = stmt7.executeQuery("select * from signature where karyawan_id = '"+idPresident.getText()+"'");
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
                    jLabel23.setVisible(false);

                    jLabel22.setVisible(false);
                    signHRRevd.setVisible(false);
                    labelNameHRRevd.setVisible(false);

                    jLabel27.setVisible(false);
                    signHRMGR.setVisible(false);
                    labelNameHRMGR.setVisible(false);
                    jLabel26.setVisible(false);

                    jLabel25.setVisible(false);
                    jLabel30.setVisible(false);
                    signTeamMGR.setVisible(false);
                    labelNameTeamMGR.setVisible(false);

                    jLabel35.setVisible(false);
                    signTeamRevd.setVisible(false);
                    labelNameTeamRevd.setVisible(false);

                    jLabel37.setVisible(false);
                    signTeamRecd.setVisible(false);
                    labelNameTeamRecd.setVisible(false);

                    jLabel40.setVisible(false);
                    signTeamPred.setVisible(false);
                    labelNameTeamPred.setVisible(false);
                    
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new scroolbarWin11.ScrollPaneWin11();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labelKTP = new javax.swing.JLabel();
        labelPosition = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelDiscipline = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        expec_date = new javax.swing.JLabel();
        labelNameSign = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane6 = new scroolbarWin11.ScrollPaneWin11();
        jTable4 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        signTeamPred = new javax.swing.JLabel();
        labelNameTeamPred = new javax.swing.JLabel();
        labelNameTeamRecd = new javax.swing.JLabel();
        idTeamRecd = new javax.swing.JLabel();
        signTeamRecd = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        signTeamRevd = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        labelNameTeamRevd = new javax.swing.JLabel();
        idTeamRevd = new javax.swing.JLabel();
        idTeamMGR = new javax.swing.JLabel();
        labelNameTeamMGR = new javax.swing.JLabel();
        signTeamMGR = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        signHRRevd = new javax.swing.JLabel();
        labelNameHRRevd = new javax.swing.JLabel();
        idHRRevd = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        signHRMGR = new javax.swing.JLabel();
        idHRMGR = new javax.swing.JLabel();
        labelNameHRMGR = new javax.swing.JLabel();
        idPresident = new javax.swing.JLabel();
        labelNamePresident = new javax.swing.JLabel();
        signPresident = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        idTeamPred = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        SendButton = new javax.swing.JButton();
        labelID = new javax.swing.JLabel();
        sendButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONFIRMATION - HANDING OVER & TAKING OVER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 510, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("A. EMPLOYEE INFORMATION");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setText("Discipline");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setText("Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel8.setText("Position");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel10.setText("KTP No.");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, -1, -1));

        labelKTP.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelKTP.setText("...");
        jPanel1.add(labelKTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, -1, -1));

        labelPosition.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelPosition.setText("...");
        jPanel1.add(labelPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, -1, -1));

        labelName.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelName.setText("...");
        jPanel1.add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, -1));

        labelDiscipline.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelDiscipline.setText("...");
        jPanel1.add(labelDiscipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel12.setText("Expected Date - Resignation");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, -1, -1));

        expec_date.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        expec_date.setText("...");
        jPanel1.add(expec_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, -1, -1));

        labelNameSign.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelNameSign.setText("...");
        jPanel1.add(labelNameSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 420, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 1030, 80, 20));

        jTable4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Job Description", "Employee Name Taking Over", "Date & Signature", "Details Attachment"
            }
        ));
        jTable4.setRowHeight(60);
        jTable4.setShowHorizontalLines(true);
        jTable4.setShowVerticalLines(true);
        jScrollPane6.setViewportView(jTable4);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 818, 211));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("B. REPORT & DESCRIPTION - HANDING OVER AND TAKING OVER");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel16.setText("As describe above, I confirm that i have been faithfully completed handing over of all matters related to the duties performed ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 770, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel17.setText("during the company's employment of me in detail to the employee and/or the employees. and please review and approve it.");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 800, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel18.setText("Signature :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, -1, -1));

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Pre'd");
        jLabel40.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 120, 20));

        signTeamPred.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamPred.setText("Signatute");
        signTeamPred.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamPred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamPredMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 120, 90));

        labelNameTeamPred.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamPred.setText("Name");
        labelNameTeamPred.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 120, 20));

        labelNameTeamRecd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamRecd.setText("Name");
        labelNameTeamRecd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 120, 20));

        idTeamRecd.setText("jLabel4");
        jPanel1.add(idTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        signTeamRecd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamRecd.setText("Signature");
        signTeamRecd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamRecd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamRecdMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 120, 90));

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Rec'd");
        jLabel37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 120, 20));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setText("TEAM");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        signTeamRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamRevd.setText("Signature");
        signTeamRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamRevd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamRevdMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 120, 90));

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Rev'd");
        jLabel35.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 120, 20));

        labelNameTeamRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamRevd.setText("Name");
        labelNameTeamRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 120, 20));

        idTeamRevd.setText("jLabel4");
        jPanel1.add(idTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        idTeamMGR.setText("jLabel4");
        jPanel1.add(idTeamMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, -1, -1));

        labelNameTeamMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamMGR.setText("Name");
        labelNameTeamMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 120, 20));

        signTeamMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamMGR.setText("Signature");
        signTeamMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamMGR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamMGRMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 120, 90));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("MGR");
        jLabel30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 120, 20));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Rev'd");
        jLabel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 120, 20));

        signHRRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signHRRevd.setText("Signature");
        signHRRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signHRRevd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signHRRevdMouseClicked(evt);
            }
        });
        jPanel1.add(signHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 120, 90));

        labelNameHRRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameHRRevd.setText("Name");
        labelNameHRRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 120, 20));

        idHRRevd.setText("jLabel4");
        jPanel1.add(idHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, -1, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("HR TEAM");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, -1, -1));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("MGR");
        jLabel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 130, 120, 20));

        signHRMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signHRMGR.setText("Signature");
        signHRMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signHRMGR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signHRMGRMouseClicked(evt);
            }
        });
        jPanel1.add(signHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 120, 90));

        idHRMGR.setText("jLabel4");
        jPanel1.add(idHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, -1, -1));

        labelNameHRMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameHRMGR.setText("Name");
        labelNameHRMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 240, 120, 20));

        idPresident.setText("jLabel4");
        jPanel1.add(idPresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 260, -1, -1));

        labelNamePresident.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNamePresident.setText("Name");
        labelNamePresident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNamePresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 240, 120, 20));

        signPresident.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signPresident.setText("Signature");
        signPresident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signPresident.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signPresidentMouseClicked(evt);
            }
        });
        jPanel1.add(signPresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 150, 120, 90));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("President");
        jLabel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 130, 120, 20));

        idTeamPred.setText("jLabel4");
        jPanel1.add(idTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel9.setText(":");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 10, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setText(":");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 10, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel11.setText(":");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 10, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel14.setText(":");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 10, -1));

        SendButton.setBackground(new java.awt.Color(51, 51, 255));
        SendButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SendButton.setForeground(new java.awt.Color(255, 255, 255));
        SendButton.setText("Simpan / Save");
        SendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });
        jPanel1.add(SendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 880, 170, 40));

        labelID.setText("jLabel2");
        jPanel1.add(labelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, -1));

        sendButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sendButton1.setForeground(new java.awt.Color(51, 51, 255));
        sendButton1.setText("Save as Excel");
        sendButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(sendButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 830, 170, 40));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1117, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
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
                    idTeamPred.setText(MySession.get_karyawanID());
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
                    idTeamRecd.setText(MySession.get_karyawanID());
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
                    idTeamRevd.setText(MySession.get_karyawanID());
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
                    idTeamMGR.setText(MySession.get_karyawanID());
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
                    idHRRevd.setText(MySession.get_karyawanID());
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
                    idHRMGR.setText(MySession.get_karyawanID());
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
                    idPresident.setText(MySession.get_karyawanID());
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_signPresidentMouseClicked

    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendButtonActionPerformed
        if (idTeamPred.getText() == null) {
            idTeamPred.setText("0");
        }
        if (idTeamRecd.getText() == null) {
            idTeamRecd.setText("0");
        }
        if (idTeamRevd.getText() == null) {
            idTeamRevd.setText("0");
        }
        if (idTeamMGR.getText() == null) {
            idTeamMGR.setText("0");
        }
        if (idHRRevd.getText() == null) {
            idHRRevd.setText("0");
        }
        if (idHRMGR.getText() == null) {
            idHRMGR.setText("0");
        }
        if (idPresident.getText() == null) {
            idPresident.setText("0");
        }
        
        PreparedStatement myStmt = null;
        try {
            String sql = "UPDATE employee_handover SET team_pred=?, team_recd=?, team_revd=?, team_mgr=?, hr_revd=?, hr_mgr=?, president=? WHERE karyawan_id=?";
            myStmt = koneksi.prepareStatement(sql);
            myStmt.setString(1, idTeamPred.getText());
            myStmt.setString(2, idTeamRecd.getText());
            myStmt.setString(3, idTeamRevd.getText());
            myStmt.setString(4, idTeamMGR.getText());
            myStmt.setString(5, idHRRevd.getText());
            myStmt.setString(6, idHRMGR.getText());
            myStmt.setString(7, idPresident.getText());
            myStmt.setString(8, labelID.getText());
            myStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan data \n Succeed saving data");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan data \n Failed saving data");
        }
    }//GEN-LAST:event_SendButtonActionPerformed

    private void sendButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButton1ActionPerformed
        tracer();
    }//GEN-LAST:event_sendButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SendButton;
    private javax.swing.JLabel expec_date;
    private javax.swing.JLabel idHRMGR;
    private javax.swing.JLabel idHRRevd;
    private javax.swing.JLabel idPresident;
    private javax.swing.JLabel idTeamMGR;
    private javax.swing.JLabel idTeamPred;
    private javax.swing.JLabel idTeamRecd;
    private javax.swing.JLabel idTeamRevd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel labelDiscipline;
    private javax.swing.JLabel labelID;
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
        this.setSize(screen.width, screen.height - 45);
        this.setPreferredSize(screen);
    }
    
    private void tracer(){
        String templateFilePath = "src/Doc/Employment Handing Over and Taking Over.xlsx";
        
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
                sheet.getRow(3).getCell(5).setCellValue("");
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
                anchor.setCol1(5);
                anchor.setRow1(3);
                Picture picture = drawing.createPicture(anchor, pictureIdx);
                picture.resize(1.0, 1.0);
                sheet.getRow(6).getCell(5).setCellValue(labelNameTeamMGR.getText().trim());
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
            sheet.getRow(11).getCell(2).setCellValue(labelPosition.getText());
            sheet.getRow(12).getCell(2).setCellValue(labelKTP.getText());
            
            sheet.getRow(11).getCell(11).setCellValue(expec_date.getText());
            
            DefaultTableModel model4 = (DefaultTableModel) jTable4.getModel();
            int rowCount4 = model4.getRowCount();
            for (int i = 0; i < rowCount4; i++) {
                String description = (String) model4.getValueAt(i, 0);
                String description1 = (String) model4.getValueAt(i, 1);
                String description2 = (String) model4.getValueAt(i, 2);
                String description3 = (String) model4.getValueAt(i, 3);
                
                sheet.getRow(17+i).getCell(0).setCellValue(description);
                sheet.getRow(17+i).getCell(1).setCellValue(description1);
                sheet.getRow(17+i).getCell(2).setCellValue(description2);
                sheet.getRow(17+i).getCell(3).setCellValue(description3);
            }
            
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate2 = sdf2.format(new Date());
            
            sheet.getRow(30).getCell(9).setCellValue("Submitted on "+formattedDate2);
            sheet.getRow(34).getCell(9).setCellValue(labelName.getText());
            
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
