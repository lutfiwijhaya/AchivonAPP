/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;


import CustomResource.MySession;
import CustomResource.koneksi;
import Main.MasterForm;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author hi
 */
public class RequestEmployeeAllocation extends MasterForm {
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
    String myDate = formatter.format(date);
    Connection koneksi;
    public RequestEmployeeAllocation() {
        initComponents();
        openDB();
        MyWindow();
        fresh();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        
        
        
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

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        statementEmployee = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        statementManager = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        labelDiscipline = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelPosition = new javax.swing.JLabel();
        textDescription = new CustomResource.CustomTextfield();
        labelWork = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        signPresident = new javax.swing.JLabel();
        labelNamePresident = new javax.swing.JLabel();
        idPresident = new javax.swing.JLabel();
        signHRMGR = new javax.swing.JLabel();
        labelNameHRMGR = new javax.swing.JLabel();
        idHRMGR = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        signHRRevd = new javax.swing.JLabel();
        idHRRevd = new javax.swing.JLabel();
        labelNameHRRevd = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        signTeamMGR = new javax.swing.JLabel();
        labelNameTeamMGR = new javax.swing.JLabel();
        idTeamMGR = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        signTeamRevd = new javax.swing.JLabel();
        labelNameTeamRevd = new javax.swing.JLabel();
        idTeamRevd = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        signTeamRecd = new javax.swing.JLabel();
        labelNameTeamRecd = new javax.swing.JLabel();
        idTeamRecd = new javax.swing.JLabel();
        idTeamPred = new javax.swing.JLabel();
        labelNameTeamPred = new javax.swing.JLabel();
        signTeamPred = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        t_tgl = new CustomResource.CustomTextfield();
        t_tgl1 = new CustomResource.CustomTextfield();

        dateChooser1.setForeground(new java.awt.Color(51, 51, 255));
        dateChooser1.setDateFormat("dd-MMM-yyyy");
        dateChooser1.setTextRefernce(t_tgl);

        dateChooser2.setForeground(new java.awt.Color(51, 51, 255));
        dateChooser2.setDateFormat("dd-MMM-yyyy");
        dateChooser2.setTextRefernce(t_tgl1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Summary for Company Allocation");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("REQUEST - EMPLOYEE ALLOCATION");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        jLabel3.setText("B1. Statement by Employee Allocated");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 540, 210, -1));

        jLabel4.setText(":");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, 10, -1));

        jLabel5.setText("Work Location");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, -1, -1));

        jLabel6.setText("Name");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, -1, -1));

        jLabel8.setText("Position");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, -1, -1));

        jLabel11.setText(":");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 10, -1));

        jLabel12.setText(":");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 10, -1));

        jLabel13.setText(":");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 280, 10, -1));

        jLabel14.setText("A. EMPLOYEE INFORMATION FOR ALLOCATION");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        statementEmployee.setColumns(20);
        statementEmployee.setRows(5);
        jScrollPane2.setViewportView(statementEmployee);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, 690, -1));

        jLabel15.setText("C. ADJUSTMENT DATE AGAINST ALLOCATION SCHEDULE       ");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 790, -1, -1));

        jLabel16.setText("Scheduling Details");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 820, -1, -1));

        statementManager.setColumns(20);
        statementManager.setRows(5);
        jScrollPane3.setViewportView(statementManager);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 680, 690, -1));

        jLabel17.setText("B. REASON STATEMENT");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, -1, -1));

        jLabel18.setText("B2. Statement by Team Manager");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 660, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Description", "Expected Time"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 840, 690, 210));

        jLabel19.setText("For the above reasons, we would like to adjust the allocation of the relevant personnel, so please review and approve this adjustment ");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 1070, -1, 30));
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1240, 110, 20));

        jLabel21.setText("of the allocation.");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 1100, -1, -1));

        jLabel22.setText("Discipline");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, -1));

        labelDiscipline.setText("Discipline");
        jPanel2.add(labelDiscipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 230, -1));

        labelName.setText("Discipline");
        jPanel2.add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 230, -1));

        labelPosition.setText("Discipline");
        jPanel2.add(labelPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, 230, -1));

        textDescription.setLabelText("Description Allocation     :");
        jPanel2.add(textDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 330, 40));

        labelWork.setText("Discipline");
        jPanel2.add(labelWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 230, -1));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("President");
        jLabel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 90, 120, 20));

        signPresident.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signPresident.setText("Signature");
        signPresident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signPresident.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signPresidentMouseClicked(evt);
            }
        });
        jPanel2.add(signPresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 110, 120, 90));

        labelNamePresident.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNamePresident.setText("Name");
        labelNamePresident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(labelNamePresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 200, 120, 20));

        idPresident.setText("jLabel4");
        jPanel2.add(idPresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 220, -1, -1));

        signHRMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signHRMGR.setText("Signature");
        signHRMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signHRMGR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signHRMGRMouseClicked(evt);
            }
        });
        jPanel2.add(signHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 120, 90));

        labelNameHRMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameHRMGR.setText("Name");
        labelNameHRMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(labelNameHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 200, 120, 20));

        idHRMGR.setText("jLabel4");
        jPanel2.add(idHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, -1, -1));

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("MGR");
        jLabel28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 120, 20));

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Rev'd");
        jLabel29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 120, 20));

        signHRRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signHRRevd.setText("Signature");
        signHRRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signHRRevd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signHRRevdMouseClicked(evt);
            }
        });
        jPanel2.add(signHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 120, 90));

        idHRRevd.setText("jLabel4");
        jPanel2.add(idHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, -1, -1));

        labelNameHRRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameHRRevd.setText("Name");
        labelNameHRRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(labelNameHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 120, 20));

        jLabel30.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel30.setText("HR TEAM");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, -1, -1));

        signTeamMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamMGR.setText("Signature");
        signTeamMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamMGR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamMGRMouseClicked(evt);
            }
        });
        jPanel2.add(signTeamMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 120, 90));

        labelNameTeamMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamMGR.setText("Name");
        labelNameTeamMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(labelNameTeamMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 120, 20));

        idTeamMGR.setText("jLabel4");
        jPanel2.add(idTeamMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, -1, -1));

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("MGR");
        jLabel33.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 120, 20));

        signTeamRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamRevd.setText("Signature");
        signTeamRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamRevd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamRevdMouseClicked(evt);
            }
        });
        jPanel2.add(signTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 120, 90));

        labelNameTeamRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamRevd.setText("Name");
        labelNameTeamRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(labelNameTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 120, 20));

        idTeamRevd.setText("jLabel4");
        jPanel2.add(idTeamRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Rev'd");
        jLabel35.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 120, 20));

        jLabel37.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel37.setText("TEAM");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Rec'd");
        jLabel39.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 120, 20));

        signTeamRecd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamRecd.setText("Signature");
        signTeamRecd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamRecd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamRecdMouseClicked(evt);
            }
        });
        jPanel2.add(signTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 120, 90));

        labelNameTeamRecd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamRecd.setText("Name");
        labelNameTeamRecd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(labelNameTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 120, 20));

        idTeamRecd.setText("jLabel4");
        jPanel2.add(idTeamRecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        idTeamPred.setText("jLabel4");
        jPanel2.add(idTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        labelNameTeamPred.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameTeamPred.setText("Name");
        labelNameTeamPred.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(labelNameTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 120, 20));

        signTeamPred.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signTeamPred.setText("Signatute");
        signTeamPred.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signTeamPred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signTeamPredMouseClicked(evt);
            }
        });
        jPanel2.add(signTeamPred, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 120, 90));

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Pre'd");
        jLabel42.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 120, 20));

        sendButton.setBackground(new java.awt.Color(51, 51, 255));
        sendButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sendButton.setForeground(new java.awt.Color(255, 255, 255));
        sendButton.setText("Kirim / Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        jPanel2.add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 1170, 170, 50));

        t_tgl.setLabelText("Required Allocation Date :");
        jPanel2.add(t_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 330, -1));

        t_tgl1.setLabelText("Required Allocation Date :");
        jPanel2.add(t_tgl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 790, 330, -1));

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1216, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        String sql = "INSERT INTO employee_allocation (karyawan_id, team_pred, team_recd, team_revd, team_mgr, hr_revd, hr_mgr, president, description, allocation_date, statement_employee, statement_manager, date_adjust, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            pstmt.setString(9, textDescription.getText());
            pstmt.setString(10, t_tgl.getText());
            pstmt.setString(11, statementEmployee.getText());
            pstmt.setString(12, statementManager.getText());
            pstmt.setString(13, t_tgl1.getText());
            pstmt.setString(14, myDate);
            pstmt.executeUpdate();
            int jtabelrows = jTable1.getRowCount();
            for (int i = 0; i <= jtabelrows - 1; i++) {
                if (jTable1.getValueAt(i, 0) == null || jTable1.getValueAt(i, 0).toString().isEmpty()) {
                    // Skip this row if the first column is null or empty
                    continue;
                } else {
                    String dtabel_des = jTable1.getValueAt(i, 0).toString();
                    String dtabel_time = jTable1.getValueAt(i, 1) != null ? jTable1.getValueAt(i, 1).toString() : "";

                    String sql1 = "INSERT INTO employee_allocation_table (karyawan_id, description, expected_time) VALUES (?, ?, ?)";
                    pstmt1 = koneksi.prepareStatement(sql1);
                    pstmt1.setString(1, MySession.get_karyawanID());
                    pstmt1.setString(2, dtabel_des);
                    pstmt1.setString(3, dtabel_time);
                    pstmt1.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(null, "Data berhasil dikirim \nData sent successfully");
            labelNamePresident.setVisible(true);
            signPresident.setVisible(true);
            jLabel27.setVisible(true);

            jLabel29.setVisible(true);
            signHRRevd.setVisible(true);
            labelNameHRRevd.setVisible(true);

            jLabel30.setVisible(true);
            signHRMGR.setVisible(true);
            labelNameHRMGR.setVisible(true);
            jLabel28.setVisible(true);

            jLabel37.setVisible(true);
            jLabel33.setVisible(true);
            signTeamMGR.setVisible(true);
            labelNameTeamMGR.setVisible(true);

            jLabel35.setVisible(true);
            signTeamRevd.setVisible(true);
            labelNameTeamRevd.setVisible(true);

            jLabel39.setVisible(true);
            signTeamRecd.setVisible(true);
            labelNameTeamRecd.setVisible(true);

            jLabel42.setVisible(true);
            signTeamPred.setVisible(true);
            labelNameTeamPred.setVisible(true);
            fresh();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal dikirim \nData failed to send");
            e.printStackTrace();
        } finally {
//            try {
//                if (koneksi != null) {
//                    koneksi.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
    }//GEN-LAST:event_sendButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JLabel idHRMGR;
    private javax.swing.JLabel idHRRevd;
    private javax.swing.JLabel idPresident;
    private javax.swing.JLabel idTeamMGR;
    private javax.swing.JLabel idTeamPred;
    private javax.swing.JLabel idTeamRecd;
    private javax.swing.JLabel idTeamRevd;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelDiscipline;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelNameHRMGR;
    private javax.swing.JLabel labelNameHRRevd;
    private javax.swing.JLabel labelNamePresident;
    private javax.swing.JLabel labelNameTeamMGR;
    private javax.swing.JLabel labelNameTeamPred;
    private javax.swing.JLabel labelNameTeamRecd;
    private javax.swing.JLabel labelNameTeamRevd;
    private javax.swing.JLabel labelPosition;
    private javax.swing.JLabel labelWork;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel signHRMGR;
    private javax.swing.JLabel signHRRevd;
    private javax.swing.JLabel signPresident;
    private javax.swing.JLabel signTeamMGR;
    private javax.swing.JLabel signTeamPred;
    private javax.swing.JLabel signTeamRecd;
    private javax.swing.JLabel signTeamRevd;
    private javax.swing.JTextArea statementEmployee;
    private javax.swing.JTextArea statementManager;
    private CustomResource.CustomTextfield t_tgl;
    private CustomResource.CustomTextfield t_tgl1;
    private CustomResource.CustomTextfield textDescription;
    // End of variables declaration//GEN-END:variables

    private void MyWindow(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height-45);
        this.setPreferredSize(new Dimension(screen.width, screen.height-100));
        
//        int x = (screen.width/2) - (this.getSize().width/2);
//        int y = (screen.height/2) - (this.getSize().height/2);
//        this.setPreferredSize(x,y);
    }
    
    private void fresh(){
        labelDiscipline.setText(MySession.get_JobPosition());
        labelName.setText(MySession.get_nama());
        labelPosition.setText(MySession.get_JobPosition());
        labelWork.setText(MySession.get_birthPlace());
        
        idTeamPred.setVisible(false);
        idTeamRecd.setVisible(false);
        idTeamRevd.setVisible(false);
        idTeamMGR.setVisible(false);
        idHRRevd.setVisible(false);
        idHRMGR.setVisible(false);
        idPresident.setVisible(false);
        try {
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee_allocation where karyawan_id = '"+MySession.get_karyawanID()+"'");
            if (rs.next()) {
                textDescription.setText(rs.getString(10));
                t_tgl.setText(rs.getString(11));
                statementEmployee.setText(rs.getString(12));
                statementManager.setText(rs.getString(13));
                t_tgl1.setText(rs.getString(14));
//                labelDateSign.setText(rs.getString(10));
                sendButton.setVisible(false);
                idTeamPred.setText(rs.getString(3));
                idTeamRecd.setText(rs.getString(4));
                idTeamRevd.setText(rs.getString(5));
                idTeamMGR.setText(rs.getString(6));
                idHRRevd.setText(rs.getString(7));
                idHRMGR.setText(rs.getString(8));
                idPresident.setText(rs.getString(9));
                DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
                try{
                    Statement stmt0 = koneksi.createStatement();
                    ResultSet rs0 = stmt0.executeQuery("select * from employee_allocation_table where karyawan_id = '"+MySession.get_karyawanID()+"' order by allocation_table_id desc");
                        while (rs0.next()) {
                            String[] data = {
                                rs0.getString("description"), 
                                rs0.getString("expected_time")
                            };
                            dataModel.insertRow(0, data);
                        }
                }catch(SQLException eq){
                }
                
                if (idTeamPred != null) {
                    signTeamPred.setText(null);
                    try {
                            Statement stmt11 = koneksi.createStatement();
                            ResultSet rs11 = stmt11.executeQuery("select * from employee where karyawan_id = '"+labelName.getText()+"'");
                            if (rs11.next()) {
                                labelNameTeamPred.setText(rs11.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt1 = koneksi.createStatement();
                        ResultSet rs1 = stmt1.executeQuery("select * from signature where karyawan_id = '"+labelName.getText()+"'");
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
                            ResultSet rs21 = stmt21.executeQuery("select * from employee where karyawan_id = '"+jLabel28.getText()+"'");
                            if (rs21.next()) {
                                labelNameTeamRecd.setText(rs21.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt2 = koneksi.createStatement();
                        ResultSet rs2 = stmt2.executeQuery("select * from signature where karyawan_id = '"+jLabel28.getText()+"'");
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
                            Statement stmt31 = koneksi.createStatement();
                            ResultSet rs31 = stmt31.executeQuery("select * from employee where karyawan_id = '"+jLabel29.getText()+"'");
                            if (rs31.next()) {
                                labelNameTeamRevd.setText(rs31.getString(4));
                            }
                        } catch (Exception e) {
                        }
                    try {
                        Statement stmt3 = koneksi.createStatement();
                        ResultSet rs3 = stmt3.executeQuery("select * from signature where karyawan_id = '"+jLabel29.getText()+"'");
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
                    jLabel27.setVisible(false);

                    jLabel29.setVisible(false);
                    signHRRevd.setVisible(false);
                    labelNameHRRevd.setVisible(false);

                    jLabel28.setVisible(false);
                    signHRMGR.setVisible(false);
                    labelNameHRMGR.setVisible(false);
                    jLabel30.setVisible(false);

                    jLabel37.setVisible(false);
                    jLabel33.setVisible(false);
                    signTeamMGR.setVisible(false);
                    labelNameTeamMGR.setVisible(false);

                    jLabel35.setVisible(false);
                    signTeamRevd.setVisible(false);
                    labelNameTeamRevd.setVisible(false);

                    jLabel39.setVisible(false);
                    signTeamRecd.setVisible(false);
                    labelNameTeamRecd.setVisible(false);

                    jLabel42.setVisible(false);
                    signTeamPred.setVisible(false);
                    labelNameTeamPred.setVisible(false);
                    
//                    sendButton.setVisible(false);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void formrefresh() {
    }
}
