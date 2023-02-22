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
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;


public class EmployeeResignation extends MasterForm {
    Statement stm;
    ResultSet rs;
    ResultSet rsf;
    Connection koneksi;
    int id;
    public EmployeeResignation() {
        initComponents();
        MyWindow();
        openDB();
        
        jScrollPane6.getVerticalScrollBar().setUnitIncrement(16);
        myRole();
        textDesc.setEditable(false);
        idTeamPred.setVisible(false);
        idTeamRecd.setVisible(false);
        idTeamRevd.setVisible(false);
        idTeamMGR.setVisible(false);
        idHRRevd.setVisible(false);
        idHRMGR.setVisible(false);
        idPresiden.setVisible(false);
        labelID.setVisible(false);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee_resignation inner join employee on employee_resignation.karyawan_id = employee.karyawan_id where ktp = '"+EmployeeSession.getKTPResign()+"'");
            if (rs.next()) {
                labelID.setText(rs.getString(2));
                labelDiscipline.setText(rs.getString(25));
                labelName.setText(rs.getString(16));
                labelPosition.setText(rs.getString(25));
                labelKTP.setText(rs.getString(15));
                labelNameSign.setText(rs.getString(16));
                labelDateSign.setText("Submited on "+rs.getString(12));
                textDesc.setText(rs.getString(10));
                datesign.setText(rs.getString(11));
                
                idTeamPred.setText(rs.getString(3));
                idTeamRecd.setText(rs.getString(4));
                idTeamRevd.setText(rs.getString(5));
                idTeamMGR.setText(rs.getString(6));
                idHRRevd.setText(rs.getString(7));
                idHRMGR.setText(rs.getString(8));
                idPresiden.setText(rs.getString(9));
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
                if (idTeamMGR != null) {
                    signTeamMGR.setText(null);
                    try {
                            Statement stmt41 = conn.createStatement();
                            ResultSet rs41 = stmt41.executeQuery("select * from employee where karyawan_id = '"+idTeamMGR.getText()+"'");
                            if (rs41.next()) {
                                labelNameTeamMGR.setText(rs41.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt4 = conn.createStatement();
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
                if (idHRMGR != null) {
                    signHRMGR.setText(null);
                    try {
                            Statement stmt61 = conn.createStatement();
                            ResultSet rs61 = stmt61.executeQuery("select * from employee where karyawan_id = '"+idHRMGR.getText()+"'");
                            if (rs61.next()) {
                                labelNameHRMGR.setText(rs61.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt6 = conn.createStatement();
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
                if (idPresiden != null) {
                    signPresident.setText(null);
                    try {
                            Statement stmt71 = conn.createStatement();
                            ResultSet rs71 = stmt71.executeQuery("select * from employee where karyawan_id = '"+idPresiden.getText()+"'");
                            if (rs71.next()) {
                                labelNamePresident.setText(rs71.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt7 = conn.createStatement();
                        ResultSet rs7 = stmt7.executeQuery("select * from signature where karyawan_id = '"+idPresiden.getText()+"'");
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

        date = new com.raven.datechooser.DateChooser();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelKTP = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDesc = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        labelDateSign = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        labelNameSign = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        labelDiscipline = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelPosition = new javax.swing.JLabel();
        labelNamePresident = new javax.swing.JLabel();
        signPresident = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        signHRRevd = new javax.swing.JLabel();
        labelNameHRRevd = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        signHRMGR = new javax.swing.JLabel();
        labelNameHRMGR = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        signTeamMGR = new javax.swing.JLabel();
        labelNameTeamMGR = new javax.swing.JLabel();
        labelNameTeamRevd = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        signTeamRevd = new javax.swing.JLabel();
        labelNameTeamRecd = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        signTeamRecd = new javax.swing.JLabel();
        labelNameTeamPred = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        signTeamPred = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        idTeamPred = new javax.swing.JLabel();
        idTeamRecd = new javax.swing.JLabel();
        idTeamRevd = new javax.swing.JLabel();
        idTeamMGR = new javax.swing.JLabel();
        idHRRevd = new javax.swing.JLabel();
        idHRMGR = new javax.swing.JLabel();
        idPresiden = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        datesign = new javax.swing.JLabel();
        labelID = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("EMPLOYEE – RESIGNATION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText(":");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 20, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("A. INFORMATION OF EMPLOYEE TO RESIGN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        labelKTP.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelKTP.setText("NO KTP");
        jPanel1.add(labelKTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 260, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setText("Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setText("Position");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel7.setText("KTP No.");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("B. DESCRIPTION");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel9.setText(":");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 20, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel10.setText(":");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 20, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel11.setText(":");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 20, -1));

        textDesc.setColumns(20);
        textDesc.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        textDesc.setRows(5);
        jScrollPane1.setViewportView(textDesc);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 870, 170));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel12.setText("disadvantage to the company, I faithfully hand over all matters related to the duties performed during the company’s employment of me in detail, and to the date");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 700, 940, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel14.setText("I apply for resignation for the reasons described above, and to ensure that no disruption to the company's work occurs due to my resignation and that there is no ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 680, 940, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel15.setText("of resignation. We pledge to abide by confidentiality so that no disadvantages to the company occur for 3 years.");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 720, -1, -1));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 980, 210, 30));

        labelDateSign.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelDateSign.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDateSign.setText("DD-MMM-YYYY");
        jPanel1.add(labelDateSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 760, 210, 20));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 1080, 130, 30));

        labelNameSign.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelNameSign.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameSign.setText("APPLICANT :  ");
        jPanel1.add(labelNameSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 880, 210, 20));
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 1130, 40, 20));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("SIGNATURE");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 780, 210, 20));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel24.setText("Discipline");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

        labelDiscipline.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelDiscipline.setText("Discipline");
        jPanel1.add(labelDiscipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 260, -1));

        labelName.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelName.setText("Nama");
        jPanel1.add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 260, -1));

        labelPosition.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelPosition.setText("Position");
        jPanel1.add(labelPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 260, -1));

        labelNamePresident.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelNamePresident.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNamePresident.setText("Name");
        labelNamePresident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNamePresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, 150, 20));

        signPresident.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signPresident.setText("Signature");
        signPresident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signPresident.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signPresidentMouseClicked(evt);
            }
        });
        jPanel1.add(signPresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 130, 150, 90));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("President");
        jLabel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 110, 150, 20));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Rev'd");
        jLabel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 120, 20));

        signHRRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signHRRevd.setText("Signature");
        signHRRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signHRRevd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signHRRevdMouseClicked(evt);
            }
        });
        jPanel1.add(signHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 120, 90));

        labelNameHRRevd.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelNameHRRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameHRRevd.setText("Name");
        labelNameHRRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, 120, 20));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("MGR");
        jLabel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 120, 20));

        signHRMGR.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        signHRMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signHRMGR.setText("Signature");
        signHRMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signHRMGR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signHRMGRMouseClicked(evt);
            }
        });
        jPanel1.add(signHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 120, 90));

        labelNameHRMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameHRMGR.setText("Name");
        labelNameHRMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, 120, 20));

        jLabel30.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("MGR");
        jLabel30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 120, 20));

        signTeamMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamMGR.setText("Signature");
        signTeamMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamMGR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamMGRMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 120, 90));

        labelNameTeamMGR.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelNameTeamMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamMGR.setText("Name");
        labelNameTeamMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 120, 20));

        labelNameTeamRevd.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelNameTeamRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamRevd.setText("Name");
        labelNameTeamRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 120, 20));

        jLabel34.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Rev'd");
        jLabel34.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 120, 20));

        signTeamRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamRevd.setText("Signature");
        signTeamRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamRevd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamRevdMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 120, 90));

        labelNameTeamRecd.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelNameTeamRecd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamRecd.setText("Name");
        labelNameTeamRecd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 120, 20));

        jLabel37.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Rec'd");
        jLabel37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 120, 20));

        signTeamRecd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamRecd.setText("Signature");
        signTeamRecd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamRecd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamRecdMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 120, 90));

        labelNameTeamPred.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelNameTeamPred.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamPred.setText("Name");
        labelNameTeamPred.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 120, 20));

        jLabel40.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Pre'd");
        jLabel40.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 120, 20));

        signTeamPred.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamPred.setText("Signatute");
        signTeamPred.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamPred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamPredMouseClicked(evt);
            }
        });
        jPanel1.add(signTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 120, 90));

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("HR TEAM");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, 250, -1));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("TEAM");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 510, -1));

        SaveButton.setBackground(new java.awt.Color(0, 51, 255));
        SaveButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        SaveButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveButton.setText("Simpan / Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 950, 170, 40));

        idTeamPred.setText("q");
        jPanel1.add(idTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 90, 20));

        idTeamRecd.setText("w");
        jPanel1.add(idTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 90, 20));

        idTeamRevd.setText("e");
        jPanel1.add(idTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 90, 20));

        idTeamMGR.setText("r4");
        jPanel1.add(idTeamMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 90, 20));

        idHRRevd.setText("3");
        jPanel1.add(idHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 90, 20));

        idHRMGR.setText("e");
        jPanel1.add(idHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 240, 80, 20));
        jPanel1.add(idPresiden, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 240, 90, 20));

        jLabel13.setText("Date to Resign :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 640, -1, -1));

        datesign.setText("jLabel32");
        jPanel1.add(datesign, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 640, -1, -1));

        labelID.setText("labelID");
        jPanel1.add(labelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        jScrollPane6.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

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
                    idPresiden.setText(MySession.get_karyawanID());
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_signPresidentMouseClicked

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
                    idHRMGR.setText(MySession.get_karyawanID());
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Maaf, Hanya HR Team yang dapat menandatangani bagian ini \nSorry, Only HR Team can sign this part");
        }
    }//GEN-LAST:event_signHRMGRMouseClicked

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
                    idTeamMGR.setText(MySession.get_karyawanID());
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Maaf, Hanya Tim yang dapat menandatangani bagian ini \nSorry, Only Team can sign this part");
        }
    }//GEN-LAST:event_signTeamMGRMouseClicked

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

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
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
        if (idPresiden.getText() == null) {
            idPresiden.setText("0");
        }
        
        Connection myConn = null;
        PreparedStatement myStmt = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            String sql = "UPDATE employee_resignation SET team_pred=?, team_recd=?, team_revd=?, team_mgr=?, hr_revd=?, hr_mgr=?, president=? WHERE karyawan_id=?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, idTeamPred.getText());
            myStmt.setString(2, idTeamRecd.getText());
            myStmt.setString(3, idTeamRevd.getText());
            myStmt.setString(4, idTeamMGR.getText());
            myStmt.setString(5, idHRRevd.getText());
            myStmt.setString(6, idHRMGR.getText());
            myStmt.setString(7, idPresiden.getText());
            myStmt.setString(8, labelID.getText());
            myStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil menyimpan Data \nSucceed saving data");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan Data \nFailed saving data");
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
        
//            Connection myConn;
//        try {
//            myConn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
//            myConn.createStatement().executeUpdate("update employee_resignation set team_pred='"+idTeamPred.getText()+"',team_recd ='"+idTeamRecd.getText()+"',team_revd='"+idTeamRevd.getText()+"',team_mgr='"+idTeamMGR.getText()+"',hr_revd='"+idHRRevd.getText()+"',hr_mgr='"+idHRMGR.getText()+"',president='"+idPresiden.getText()+"' where karyawan_id ='"+labelID+"'");
//                    
////            stm = koneksi.createStatement();
////                String sql = "update employee_resignation set team_pred='"+idTeamPred.getText()+"',team_recd ='"+idTeamRecd.getText()+"',"
////                    + "team_revd='"+idTeamRevd.getText()+"',team_mgr='"+idTeamMGR.getText()+"',"
////                    + "hr_revd='"+idHRRevd.getText()+"',hr_mgr='"+idHRMGR.getText()+"',"
////                    + "president='"+idPresiden.getText()+"' where karyawan_id ='"+labelID+"'";
//
////            stm.executeUpdate(sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }        
    }//GEN-LAST:event_SaveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SaveButton;
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JLabel datesign;
    private javax.swing.JLabel idHRMGR;
    private javax.swing.JLabel idHRRevd;
    private javax.swing.JLabel idPresiden;
    private javax.swing.JLabel idTeamMGR;
    private javax.swing.JLabel idTeamPred;
    private javax.swing.JLabel idTeamRecd;
    private javax.swing.JLabel idTeamRevd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelDateSign;
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
    private javax.swing.JLabel signHRMGR;
    private javax.swing.JLabel signHRRevd;
    private javax.swing.JLabel signPresident;
    private javax.swing.JLabel signTeamMGR;
    private javax.swing.JLabel signTeamPred;
    private javax.swing.JLabel signTeamRecd;
    private javax.swing.JLabel signTeamRevd;
    private javax.swing.JTextArea textDesc;
    // End of variables declaration//GEN-END:variables
    private void MyWindow(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height-45);
        this.setPreferredSize(new Dimension(screen.width, screen.height-100));
        
//        int x = (screen.width/2) - (this.getSize().width/2);
//        int y = (screen.height/2) - (this.getSize().height/2);
//        this.setPreferredSize(x,y);
    }
    
    private void index(){
        
        
    }
    
    private void myRole(){
        if("1".equals(MySession.get_Role())){
            
        }else if("2".equals(MySession.get_Role())){
            labelNamePresident.setVisible(false);
            signPresident.setVisible(false);
            jLabel19.setVisible(false);
            
        }else if("3".equals(MySession.get_Role())){
            jLabel21.setVisible(false);
            signHRRevd.setVisible(false);
            labelNameHRRevd.setVisible(false);
            
            jLabel27.setVisible(false);
            signHRMGR.setVisible(false);
            labelNameHRMGR.setVisible(false);
            jLabel42.setVisible(false);
            
            labelNamePresident.setVisible(false);
            signPresident.setVisible(false);
            jLabel19.setVisible(false);
        }
    }
    
    @Override
    public void formrefresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
