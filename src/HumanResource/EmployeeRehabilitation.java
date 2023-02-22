/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import CustomResource.EmployeeSession;
import CustomResource.MySession;
import Main.MasterForm;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class EmployeeRehabilitation extends MasterForm {

    /**
     * Creates new form AplicationRehabilitation
     */
    public EmployeeRehabilitation() {
        initComponents();
        MyWindow();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        idTeamPred.setVisible(false);
        idTeamRecd.setVisible(false);
        idTeamRevd.setVisible(false);
        idTeamMgr.setVisible(false);
        idHRRevd.setVisible(false);
        idHRMgr.setVisible(false);
        idPresident.setVisible(false);
        labelID.setVisible(false);
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee_rehabilitation inner join employee on employee_rehabilitation.karyawan_id = employee.karyawan_id where ktp = '"+EmployeeSession.getKTPRehab()+"'");
            if (rs.next()) {
                labelID.setText(rs.getString(2));
                labelDiscipline.setText(rs.getString(28));
                labelName.setText(rs.getString(19));
                labelPosition.setText(rs.getString(28));
                labelKTP.setText(rs.getString(18));
                labelHP.setText(rs.getString(25));
                dateJoin.setText(rs.getString(10));
                dateLeave.setText(rs.getString(11));
                dateRehab.setText(rs.getString(12));
                stateRehab.setText(rs.getString(13));
                documentRehab.setText(rs.getString(14));
                
                idTeamPred.setText(rs.getString(3));
                idTeamRecd.setText(rs.getString(4));
                idTeamRevd.setText(rs.getString(5));
                idTeamMgr.setText(rs.getString(6));
                idHRRevd.setText(rs.getString(7));
                idHRMgr.setText(rs.getString(8));
                idPresident.setText(rs.getString(9));
                if (idTeamPred != null) {
                    signTeamPred.setText(null);
                    try {
                            Statement stmt11 = conn.createStatement();
                            ResultSet rs11 = stmt11.executeQuery("select * from employee where karyawan_id = '"+idTeamPred.getText()+"'");
                            if (rs11.next()) {
                                labelNameTeamPred.setText(rs11.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt1 = conn.createStatement();
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
                            Statement stmt21 = conn.createStatement();
                            ResultSet rs21 = stmt21.executeQuery("select * from employee where karyawan_id = '"+idTeamRecd.getText()+"'");
                            if (rs21.next()) {
                                labelNameTeamRecd.setText(rs21.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt2 = conn.createStatement();
                        ResultSet rs2 = stmt2.executeQuery("select * from signature where karyawan_id = '"+idTeamRecd.getText()+"'");
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
                if (idTeamRevd != null) {
                    signTeamRevd.setText(null);
                    try {
                            Statement stmt31 = conn.createStatement();
                            ResultSet rs31 = stmt31.executeQuery("select * from employee where karyawan_id = '"+idTeamRevd.getText()+"'");
                            if (rs31.next()) {
                                labelNameTeamRevd.setText(rs31.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt3 = conn.createStatement();
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
                if (idTeamMgr != null) {
                    signTeamMGR.setText(null);
                        try {
                            Statement stmt41 = conn.createStatement();
                            ResultSet rs41 = stmt41.executeQuery("select * from employee where karyawan_id = '"+idTeamMgr.getText()+"'");
                            if (rs41.next()) {
                                labelNameTeamMGR.setText(rs41.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt4 = conn.createStatement();
                        ResultSet rs4 = stmt4.executeQuery("select * from signature where karyawan_id = '"+idTeamMgr.getText()+"'");
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
                            Statement stmt51 = conn.createStatement();
                            ResultSet rs51 = stmt51.executeQuery("select * from employee where karyawan_id = '"+idHRRevd.getText()+"'");
                            if (rs51.next()) {
                                labelNameHRRevd.setText(rs51.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt5 = conn.createStatement();
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
                if (idHRMgr != null) {
                    signHRMGR.setText(null);
                    try {
                            Statement stmt61 = conn.createStatement();
                            ResultSet rs61 = stmt61.executeQuery("select * from employee where karyawan_id = '"+idHRMgr.getText()+"'");
                            if (rs61.next()) {
                                labelNameHRMGR.setText(rs61.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt6 = conn.createStatement();
                        ResultSet rs6 = stmt6.executeQuery("select * from signature where karyawan_id = '"+idHRMgr.getText()+"'");
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
                            Statement stmt71 = conn.createStatement();
                            ResultSet rs71 = stmt71.executeQuery("select * from employee where karyawan_id = '"+idPresident.getText()+"'");
                            if (rs71.next()) {
                                labelNamePresident.setText(rs71.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt7 = conn.createStatement();
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
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        dateChooser3 = new com.raven.datechooser.DateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelDiscipline = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelPosition = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labelKTP = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelHP = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        stateRehab = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        documentRehab = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        signTeamPred = new javax.swing.JLabel();
        labelNameTeamPred = new javax.swing.JLabel();
        labelNameTeamRecd = new javax.swing.JLabel();
        signTeamRecd = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        signTeamRevd = new javax.swing.JLabel();
        labelNameTeamRevd = new javax.swing.JLabel();
        labelNameTeamMGR = new javax.swing.JLabel();
        signTeamMGR = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        signHRRevd = new javax.swing.JLabel();
        labelNameHRRevd = new javax.swing.JLabel();
        signHRMGR = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        labelNameHRMGR = new javax.swing.JLabel();
        labelNamePresident = new javax.swing.JLabel();
        signPresident = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        idTeamPred = new javax.swing.JLabel();
        idTeamRecd = new javax.swing.JLabel();
        idTeamRevd = new javax.swing.JLabel();
        idTeamMgr = new javax.swing.JLabel();
        idHRRevd = new javax.swing.JLabel();
        idHRMgr = new javax.swing.JLabel();
        idPresident = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        dateRehab = new CustomResource.CustomTextfield();
        dateJoin = new CustomResource.CustomTextfield();
        dateLeave = new CustomResource.CustomTextfield();
        labelID = new javax.swing.JLabel();

        dateChooser1.setForeground(new java.awt.Color(51, 51, 255));
        dateChooser1.setTextRefernce(dateJoin);

        dateChooser2.setForeground(new java.awt.Color(51, 51, 255));
        dateChooser2.setTextRefernce(dateLeave);

        dateChooser3.setForeground(new java.awt.Color(51, 51, 255));
        dateChooser3.setTextRefernce(dateRehab);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Employee - REHABILITATION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        labelDiscipline.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelDiscipline.setText("...");
        jPanel1.add(labelDiscipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setText("Discipline");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setText("Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, -1, -1));

        labelName.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelName.setText("...");
        jPanel1.add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel8.setText("Position");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        labelPosition.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelPosition.setText("...");
        jPanel1.add(labelPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel10.setText("KTP No.");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, -1));

        labelKTP.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelKTP.setText("...");
        jPanel1.add(labelKTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("A. EMPLOYEE INFORMATION");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        labelHP.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelHP.setText("...");
        jPanel1.add(labelHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 880, 80, 20));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setText("TEAM");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("HR TEAM");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("B. STEATMENT OF REHABILITATION REASON");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, -1, -1));

        stateRehab.setColumns(20);
        stateRehab.setRows(5);
        jScrollPane5.setViewportView(stateRehab);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 524, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("C. SUPPORTING DOCUMENTS FOR REHABILITATION");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, -1, -1));

        documentRehab.setColumns(20);
        documentRehab.setRows(5);
        jScrollPane6.setViewportView(documentRehab);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 610, 524, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel20.setText("As above, I would like to return to work from a leave of absence, so please review and approve me to work.");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 710, -1, -1));

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Simpan / Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 770, 170, 50));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel21.setText("Mobile No.");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, -1, -1));

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Pre'd");
        jLabel40.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 120, 20));

        signTeamPred.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamPred.setText("Signatute");
        signTeamPred.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamPred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamPredMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 120, 90));

        labelNameTeamPred.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamPred.setText("Name");
        labelNameTeamPred.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 120, 20));

        labelNameTeamRecd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamRecd.setText("Name");
        labelNameTeamRecd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 120, 20));

        signTeamRecd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamRecd.setText("Signature");
        signTeamRecd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamRecd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamRecdMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 120, 90));

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Rec'd");
        jLabel37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 120, 20));

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Rev'd");
        jLabel35.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 120, 20));

        signTeamRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamRevd.setText("Signature");
        signTeamRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamRevd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamRevdMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, 90));

        labelNameTeamRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamRevd.setText("Name");
        labelNameTeamRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 120, 20));

        labelNameTeamMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamMGR.setText("Name");
        labelNameTeamMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 120, 20));

        signTeamMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamMGR.setText("Signature");
        signTeamMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamMGR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamMGRMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 120, 90));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("MGR");
        jLabel30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 120, 20));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Rev'd");
        jLabel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 120, 20));

        signHRRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signHRRevd.setText("Signature");
        signHRRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signHRRevd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signHRRevdMouseClicked(evt);
            }
        });
        jPanel1.add(signHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 120, 90));

        labelNameHRRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameHRRevd.setText("Name");
        labelNameHRRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 120, 20));

        signHRMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signHRMGR.setText("Signature");
        signHRMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signHRMGR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signHRMGRMouseClicked(evt);
            }
        });
        jPanel1.add(signHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, 120, 90));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("MGR");
        jLabel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 120, 20));

        labelNameHRMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameHRMGR.setText("Name");
        labelNameHRMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 220, 120, 20));

        labelNamePresident.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNamePresident.setText("Name");
        labelNamePresident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNamePresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 220, 140, 20));

        signPresident.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signPresident.setText("Signature");
        signPresident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signPresident.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signPresidentMouseClicked(evt);
            }
        });
        jPanel1.add(signPresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 130, 140, 90));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("President");
        jLabel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 110, 140, 20));

        idTeamPred.setText("jLabel4");
        jPanel1.add(idTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        idTeamRecd.setText("jLabel4");
        jPanel1.add(idTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, -1));

        idTeamRevd.setText("jLabel4");
        jPanel1.add(idTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, -1, -1));

        idTeamMgr.setText("jLabel4");
        jPanel1.add(idTeamMgr, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, -1, -1));

        idHRRevd.setText("jLabel4");
        jPanel1.add(idHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, -1, -1));

        idHRMgr.setText("jLabel4");
        jPanel1.add(idHRMgr, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, -1, -1));

        idPresident.setText("jLabel4");
        jPanel1.add(idPresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 240, -1, -1));

        jLabel39.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel39.setText(":");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 10, -1));

        jLabel41.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel41.setText(":");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 10, -1));

        jLabel42.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel42.setText(":");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 10, -1));

        jLabel43.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel43.setText(":");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 10, -1));

        jLabel44.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel44.setText(":");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 10, -1));

        dateRehab.setLabelText("Date - Rehabilitation");
        jPanel1.add(dateRehab, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 200, -1));

        dateJoin.setLabelText("Date -  Initial Join");
        jPanel1.add(dateJoin, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 200, -1));

        dateLeave.setLabelText("Date - Leave of Absence");
        dateLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateLeaveActionPerformed(evt);
            }
        });
        jPanel1.add(dateLeave, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 200, -1));

        labelID.setText("jLabel2");
        jPanel1.add(labelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void signTeamPredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signTeamPredMouseClicked
        if ("3".equals(MySession.get_Role())) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
                Statement stmt = conn.createStatement();
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
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
                Statement stmt = conn.createStatement();
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
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
                Statement stmt = conn.createStatement();
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
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from signature where karyawan_id = '"+MySession.get_karyawanID()+"'");

                if (rs.next()) {
                    byte[] imageData = rs.getBytes("scan");
                    ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                    BufferedImage bImage = ImageIO.read(bis);
                    ImageIcon Myicon = new ImageIcon(bImage);
                    Image imageResize = Myicon.getImage().getScaledInstance(135, 90, Image.SCALE_SMOOTH);
                    signTeamMGR.setIcon(new ImageIcon(imageResize));
                    labelNameTeamMGR.setText(MySession.get_nama());
                    idTeamMgr.setText(MySession.get_karyawanID());
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
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
                Statement stmt = conn.createStatement();
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
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from signature where karyawan_id = '"+MySession.get_karyawanID()+"'");

                if (rs.next()) {
                    byte[] imageData = rs.getBytes("scan");
                    ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                    BufferedImage bImage = ImageIO.read(bis);
                    ImageIcon Myicon = new ImageIcon(bImage);
                    Image imageResize = Myicon.getImage().getScaledInstance(135, 90, Image.SCALE_SMOOTH);
                    signHRMGR.setIcon(new ImageIcon(imageResize));
                    labelNameHRMGR.setText(MySession.get_nama());
                    idHRMgr.setText(MySession.get_karyawanID());
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
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
                Statement stmt = conn.createStatement();
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

    private void dateLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateLeaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateLeaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (idTeamPred.getText() == null) {
            idTeamPred.setText("0");
        }
        if (idTeamRecd.getText() == null) {
            idTeamRecd.setText("0");
        }
        if (idTeamRevd.getText() == null) {
            idTeamRevd.setText("0");
        }
        if (idTeamMgr.getText() == null) {
            idTeamMgr.setText("0");
        }
        if (idHRRevd.getText() == null) {
            idHRRevd.setText("0");
        }
        if (idHRMgr.getText() == null) {
            idHRMgr.setText("0");
        }
        if (idPresident.getText() == null) {
            idPresident.setText("1");
        }
        
        Connection myConn = null;
        PreparedStatement myStmt = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            String sql = "UPDATE employee_rehabilitation SET team_pred=?, team_recd=?, team_revd=?, team_mgr=?, hr_revd=?, hr_mgr=?, president=? WHERE karyawan_id=?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, idTeamPred.getText());
            myStmt.setString(2, idTeamRecd.getText());
            myStmt.setString(3, idTeamRevd.getText());
            myStmt.setString(4, idTeamMgr.getText());
            myStmt.setString(5, idHRRevd.getText());
            myStmt.setString(6, idHRMgr.getText());
            myStmt.setString(7, idPresident.getText());
            myStmt.setString(8, labelID.getText());
            myStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan data \n Succeed saving data");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan data \n Failed saving data");
        } finally {
            try {
                if (myStmt != null) {
                    myStmt.close();
                }
                if (myConn != null) {
                    myConn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private com.raven.datechooser.DateChooser dateChooser3;
    private CustomResource.CustomTextfield dateJoin;
    private CustomResource.CustomTextfield dateLeave;
    private CustomResource.CustomTextfield dateRehab;
    private javax.swing.JTextArea documentRehab;
    private javax.swing.JLabel idHRMgr;
    private javax.swing.JLabel idHRRevd;
    private javax.swing.JLabel idPresident;
    private javax.swing.JLabel idTeamMgr;
    private javax.swing.JLabel idTeamPred;
    private javax.swing.JLabel idTeamRecd;
    private javax.swing.JLabel idTeamRevd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelDiscipline;
    private javax.swing.JLabel labelHP;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelKTP;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelNameHRMGR;
    private javax.swing.JLabel labelNameHRRevd;
    private javax.swing.JLabel labelNamePresident;
    private javax.swing.JLabel labelNameTeamMGR;
    private javax.swing.JLabel labelNameTeamPred;
    private javax.swing.JLabel labelNameTeamRecd;
    private javax.swing.JLabel labelNameTeamRevd;
    private javax.swing.JLabel labelPosition;
    private javax.swing.JLabel signHRMGR;
    private javax.swing.JLabel signHRRevd;
    private javax.swing.JLabel signPresident;
    private javax.swing.JLabel signTeamMGR;
    private javax.swing.JLabel signTeamPred;
    private javax.swing.JLabel signTeamRecd;
    private javax.swing.JLabel signTeamRevd;
    private javax.swing.JTextArea stateRehab;
    // End of variables declaration//GEN-END:variables
    private void MyWindow(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height-45);
        this.setPreferredSize(new Dimension(screen.width, screen.height-100));
        
//        int x = (screen.width/2) - (this.getSize().width/2);
//        int y = (screen.height/2) - (this.getSize().height/2);
//        this.setPreferredSize(x,y);
    }

    @Override
    public void formrefresh() {
    }
}
