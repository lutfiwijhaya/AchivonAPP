/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import CustomResource.MySession;
import CustomResource.koneksi;
import Main.MasterForm;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import jnafilechooser.api.JnaFileChooser;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author hi
 */
public class EmployeeEvaluation extends MasterForm {
    Connection koneksi;
    public EmployeeEvaluation() {
        initComponents();
        MyWindow();
        openDB();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        labelID.setVisible(false);
        idHRRevd.setVisible(false);
        idHRMGR.setVisible(false);
        idPresiden.setVisible(false);
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

        groupCoordination = new javax.swing.ButtonGroup();
        groupCommunication = new javax.swing.ButtonGroup();
        groupReporting = new javax.swing.ButtonGroup();
        groupLeadership = new javax.swing.ButtonGroup();
        groupKnowledge = new javax.swing.ButtonGroup();
        groupProfesional = new javax.swing.ButtonGroup();
        groupPlaning = new javax.swing.ButtonGroup();
        groupSchedule = new javax.swing.ButtonGroup();
        groupPerformance = new javax.swing.ButtonGroup();
        groupPersonality = new javax.swing.ButtonGroup();
        jScrollPane1 = new scroolbarWin11.ScrollPaneWin11();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane5 = new scroolbarWin11.ScrollPaneWin11();
        areaResult = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        directorSenor = new CustomResource.CustomTextfield();
        disciplineText = new CustomResource.CustomTextfield();
        nameText = new CustomResource.CustomTextfield();
        positionText = new CustomResource.CustomTextfield();
        workText = new CustomResource.CustomTextfield();
        subordinateTeam = new CustomResource.CustomTextfield();
        superiorTeam = new CustomResource.CustomTextfield();
        managerTeam = new CustomResource.CustomTextfield();
        managerDiscipline = new CustomResource.CustomTextfield();
        director = new CustomResource.CustomTextfield();
        jLabel27 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        signHRRevd = new javax.swing.JLabel();
        labelNameHRRevd = new javax.swing.JLabel();
        idHRRevd = new javax.swing.JLabel();
        idHRMGR = new javax.swing.JLabel();
        labelNameHRMGR = new javax.swing.JLabel();
        signHRMGR = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        signPresident = new javax.swing.JLabel();
        labelNamePresident = new javax.swing.JLabel();
        idPresiden = new javax.swing.JLabel();
        labelID = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        coordinationS = new CustomResource.RadioButtonCustom();
        coordinationD = new CustomResource.RadioButtonCustom();
        jLabel4 = new javax.swing.JLabel();
        coordinationA = new CustomResource.RadioButtonCustom();
        coordinationB = new CustomResource.RadioButtonCustom();
        coordinationC = new CustomResource.RadioButtonCustom();
        jLabel5 = new javax.swing.JLabel();
        communicationS = new CustomResource.RadioButtonCustom();
        communicationA = new CustomResource.RadioButtonCustom();
        communicationB = new CustomResource.RadioButtonCustom();
        communicationC = new CustomResource.RadioButtonCustom();
        communicationD = new CustomResource.RadioButtonCustom();
        jLabel6 = new javax.swing.JLabel();
        reportingS = new CustomResource.RadioButtonCustom();
        reportingA = new CustomResource.RadioButtonCustom();
        reportingB = new CustomResource.RadioButtonCustom();
        reportingC = new CustomResource.RadioButtonCustom();
        reportingD = new CustomResource.RadioButtonCustom();
        jLabel7 = new javax.swing.JLabel();
        leadershipS = new CustomResource.RadioButtonCustom();
        leadershipA = new CustomResource.RadioButtonCustom();
        leadershipB = new CustomResource.RadioButtonCustom();
        leadershipC = new CustomResource.RadioButtonCustom();
        leadershipD = new CustomResource.RadioButtonCustom();
        jLabel8 = new javax.swing.JLabel();
        knowledgeS = new CustomResource.RadioButtonCustom();
        knowledgeA = new CustomResource.RadioButtonCustom();
        knowledgeB = new CustomResource.RadioButtonCustom();
        knowledgeC = new CustomResource.RadioButtonCustom();
        knowledgeD = new CustomResource.RadioButtonCustom();
        scheduleD = new CustomResource.RadioButtonCustom();
        scheduleC = new CustomResource.RadioButtonCustom();
        scheduleB = new CustomResource.RadioButtonCustom();
        planningD = new CustomResource.RadioButtonCustom();
        profesionalD = new CustomResource.RadioButtonCustom();
        profesionalC = new CustomResource.RadioButtonCustom();
        planningC = new CustomResource.RadioButtonCustom();
        planningB = new CustomResource.RadioButtonCustom();
        profesionalB = new CustomResource.RadioButtonCustom();
        profesionalA = new CustomResource.RadioButtonCustom();
        planningA = new CustomResource.RadioButtonCustom();
        scheduleA = new CustomResource.RadioButtonCustom();
        scheduleS = new CustomResource.RadioButtonCustom();
        planningS = new CustomResource.RadioButtonCustom();
        profesionalS = new CustomResource.RadioButtonCustom();
        performanceS = new CustomResource.RadioButtonCustom();
        personalityS = new CustomResource.RadioButtonCustom();
        personalityA = new CustomResource.RadioButtonCustom();
        performanceA = new CustomResource.RadioButtonCustom();
        performanceB = new CustomResource.RadioButtonCustom();
        personalityB = new CustomResource.RadioButtonCustom();
        personalityC = new CustomResource.RadioButtonCustom();
        performanceC = new CustomResource.RadioButtonCustom();
        performanceD = new CustomResource.RadioButtonCustom();
        personalityD = new CustomResource.RadioButtonCustom();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        saveExcell = new javax.swing.JButton();
        jScrollPane6 = new scroolbarWin11.ScrollPaneWin11();
        judgement1 = new javax.swing.JTextArea();
        jScrollPane7 = new scroolbarWin11.ScrollPaneWin11();
        judgement2 = new javax.swing.JTextArea();
        jScrollPane8 = new scroolbarWin11.ScrollPaneWin11();
        judgement3 = new javax.swing.JTextArea();
        jScrollPane9 = new scroolbarWin11.ScrollPaneWin11();
        judgement4 = new javax.swing.JTextArea();
        jScrollPane10 = new scroolbarWin11.ScrollPaneWin11();
        judgement5 = new javax.swing.JTextArea();
        jScrollPane11 = new scroolbarWin11.ScrollPaneWin11();
        judgement6 = new javax.swing.JTextArea();
        jScrollPane12 = new scroolbarWin11.ScrollPaneWin11();
        judgement7 = new javax.swing.JTextArea();
        jScrollPane13 = new scroolbarWin11.ScrollPaneWin11();
        judgement8 = new javax.swing.JTextArea();
        jScrollPane14 = new scroolbarWin11.ScrollPaneWin11();
        judgement9 = new javax.swing.JTextArea();
        jScrollPane15 = new scroolbarWin11.ScrollPaneWin11();
        judgement10 = new javax.swing.JTextArea();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EMPLOYEE EVALUATION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 280, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("B. NAME OF EVALUATORS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("A. EMPLOYEE INFORMATION");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, -1, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("C. EVALUATION RESULTS BY EACH EVALUATOR");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 650, -1, -1));
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 1580, 230, 20));

        areaResult.setColumns(20);
        areaResult.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        areaResult.setRows(5);
        jScrollPane5.setViewportView(areaResult);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 1270, 660, 120));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel26.setText("Overall Result and Opinion and Explanation");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 1250, -1, -1));

        directorSenor.setLabelText("Senor Director");
        jPanel1.add(directorSenor, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 570, 280, -1));

        disciplineText.setLabelText("Discipline");
        jPanel1.add(disciplineText, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 270, -1));

        nameText.setLabelText("Nama / Name");
        jPanel1.add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 270, -1));

        positionText.setLabelText("Posisi /Position");
        jPanel1.add(positionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 280, -1));

        workText.setLabelText("Lokasi Kerja / Work Location");
        jPanel1.add(workText, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 280, -1));

        subordinateTeam.setLabelText("Team Subordinator");
        jPanel1.add(subordinateTeam, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 280, -1));

        superiorTeam.setLabelText("Team Superior");
        jPanel1.add(superiorTeam, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, 280, -1));

        managerTeam.setLabelText("Team Manager");
        jPanel1.add(managerTeam, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 570, 280, -1));

        managerDiscipline.setLabelText("Discipline Manager");
        jPanel1.add(managerDiscipline, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 280, -1));

        director.setLabelText("Director");
        jPanel1.add(director, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 520, 280, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setText("HR TEAM");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, -1, -1));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Rev'd");
        jLabel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 120, 20));

        signHRRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signHRRevd.setText("Signature");
        signHRRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signHRRevd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signHRRevdMouseClicked(evt);
            }
        });
        jPanel1.add(signHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 120, 90));

        labelNameHRRevd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameHRRevd.setText("Name");
        labelNameHRRevd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 120, 20));

        idHRRevd.setText("jLabel4");
        jPanel1.add(idHRRevd, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, -1, -1));

        idHRMGR.setText("jLabel4");
        jPanel1.add(idHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 240, -1, -1));

        labelNameHRMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNameHRMGR.setText("Name");
        labelNameHRMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNameHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, 120, 20));

        signHRMGR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signHRMGR.setText("Signature");
        signHRMGR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signHRMGR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signHRMGRMouseClicked(evt);
            }
        });
        jPanel1.add(signHRMGR, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, 120, 90));

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("MGR");
        jLabel28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, 120, 20));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("President");
        jLabel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 110, 120, 20));

        signPresident.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signPresident.setText("Signature");
        signPresident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        signPresident.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signPresidentMouseClicked(evt);
            }
        });
        jPanel1.add(signPresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 130, 120, 90));

        labelNamePresident.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNamePresident.setText("Name");
        labelNamePresident.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(labelNamePresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 220, 120, 20));

        idPresiden.setText("jLabel4");
        jPanel1.add(idPresiden, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 240, -1, -1));

        labelID.setText("asd");
        jPanel1.add(labelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, -1, -1));

        saveButton.setBackground(new java.awt.Color(51, 51, 255));
        saveButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Simpan / Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 1410, 170, 40));

        groupCoordination.add(coordinationS);
        coordinationS.setText("S");
        coordinationS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coordinationSActionPerformed(evt);
            }
        });
        jPanel1.add(coordinationS, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 690, -1, -1));

        groupCoordination.add(coordinationD);
        coordinationD.setText("D");
        jPanel1.add(coordinationD, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 690, -1, -1));

        jLabel4.setText("1. Coordianation");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 690, -1, -1));

        groupCoordination.add(coordinationA);
        coordinationA.setText("A");
        jPanel1.add(coordinationA, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 690, -1, -1));

        groupCoordination.add(coordinationB);
        coordinationB.setText("B");
        jPanel1.add(coordinationB, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 690, -1, -1));

        groupCoordination.add(coordinationC);
        coordinationC.setText("C");
        jPanel1.add(coordinationC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 690, -1, -1));

        jLabel5.setText("2. Communication");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 800, -1, -1));

        groupCommunication.add(communicationS);
        communicationS.setText("S");
        communicationS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                communicationSActionPerformed(evt);
            }
        });
        jPanel1.add(communicationS, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 800, -1, -1));

        groupCommunication.add(communicationA);
        communicationA.setText("A");
        jPanel1.add(communicationA, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 800, -1, -1));

        groupCommunication.add(communicationB);
        communicationB.setText("B");
        jPanel1.add(communicationB, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 800, -1, -1));

        groupCommunication.add(communicationC);
        communicationC.setText("C");
        jPanel1.add(communicationC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 800, -1, -1));

        groupCommunication.add(communicationD);
        communicationD.setText("D");
        jPanel1.add(communicationD, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 800, -1, -1));

        jLabel6.setText("3. Reporting");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 910, -1, -1));

        groupReporting.add(reportingS);
        reportingS.setText("S");
        reportingS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportingSActionPerformed(evt);
            }
        });
        jPanel1.add(reportingS, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 910, -1, -1));

        groupReporting.add(reportingA);
        reportingA.setText("A");
        jPanel1.add(reportingA, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 910, -1, -1));

        groupReporting.add(reportingB);
        reportingB.setText("B");
        jPanel1.add(reportingB, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 910, -1, -1));

        groupReporting.add(reportingC);
        reportingC.setText("C");
        jPanel1.add(reportingC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 910, -1, -1));

        groupReporting.add(reportingD);
        reportingD.setText("D");
        jPanel1.add(reportingD, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 910, -1, -1));

        jLabel7.setText("4. Leadership");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 1020, -1, -1));

        groupLeadership.add(leadershipS);
        leadershipS.setText("S");
        leadershipS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leadershipSActionPerformed(evt);
            }
        });
        jPanel1.add(leadershipS, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1020, -1, -1));

        groupLeadership.add(leadershipA);
        leadershipA.setText("A");
        jPanel1.add(leadershipA, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 1020, -1, -1));

        groupLeadership.add(leadershipB);
        leadershipB.setText("B");
        jPanel1.add(leadershipB, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 1020, -1, -1));

        groupLeadership.add(leadershipC);
        leadershipC.setText("C");
        jPanel1.add(leadershipC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 1020, -1, -1));

        groupLeadership.add(leadershipD);
        leadershipD.setText("D");
        jPanel1.add(leadershipD, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 1020, -1, -1));

        jLabel8.setText("5. Knowledge");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 1130, -1, -1));

        groupKnowledge.add(knowledgeS);
        knowledgeS.setText("S");
        knowledgeS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knowledgeSActionPerformed(evt);
            }
        });
        jPanel1.add(knowledgeS, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1130, -1, -1));

        groupKnowledge.add(knowledgeA);
        knowledgeA.setText("A");
        jPanel1.add(knowledgeA, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 1130, -1, -1));

        groupKnowledge.add(knowledgeB);
        knowledgeB.setText("B");
        jPanel1.add(knowledgeB, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 1130, -1, -1));

        groupKnowledge.add(knowledgeC);
        knowledgeC.setText("C");
        jPanel1.add(knowledgeC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 1130, -1, -1));

        groupKnowledge.add(knowledgeD);
        knowledgeD.setText("D");
        jPanel1.add(knowledgeD, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 1130, -1, -1));

        groupSchedule.add(scheduleD);
        scheduleD.setText("D");
        jPanel1.add(scheduleD, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 910, -1, -1));

        groupSchedule.add(scheduleC);
        scheduleC.setText("C");
        jPanel1.add(scheduleC, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 910, -1, -1));

        groupSchedule.add(scheduleB);
        scheduleB.setText("B");
        jPanel1.add(scheduleB, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 910, -1, -1));

        groupPlaning.add(planningD);
        planningD.setText("D");
        jPanel1.add(planningD, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 800, -1, -1));

        groupProfesional.add(profesionalD);
        profesionalD.setText("D");
        jPanel1.add(profesionalD, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 690, -1, -1));

        groupProfesional.add(profesionalC);
        profesionalC.setText("C");
        jPanel1.add(profesionalC, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 690, -1, -1));

        groupPlaning.add(planningC);
        planningC.setText("C");
        jPanel1.add(planningC, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 800, -1, -1));

        groupPlaning.add(planningB);
        planningB.setText("B");
        jPanel1.add(planningB, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 800, -1, -1));

        groupProfesional.add(profesionalB);
        profesionalB.setText("B");
        jPanel1.add(profesionalB, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 690, -1, -1));

        groupProfesional.add(profesionalA);
        profesionalA.setText("A");
        jPanel1.add(profesionalA, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 690, -1, -1));

        groupPlaning.add(planningA);
        planningA.setText("A");
        jPanel1.add(planningA, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 800, -1, -1));

        groupSchedule.add(scheduleA);
        scheduleA.setText("A");
        jPanel1.add(scheduleA, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 910, -1, -1));

        groupSchedule.add(scheduleS);
        scheduleS.setText("S");
        scheduleS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleSActionPerformed(evt);
            }
        });
        jPanel1.add(scheduleS, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 910, -1, -1));

        groupPlaning.add(planningS);
        planningS.setText("S");
        planningS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planningSActionPerformed(evt);
            }
        });
        jPanel1.add(planningS, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 800, -1, -1));

        groupProfesional.add(profesionalS);
        profesionalS.setText("S");
        profesionalS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profesionalSActionPerformed(evt);
            }
        });
        jPanel1.add(profesionalS, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 690, -1, -1));

        groupPerformance.add(performanceS);
        performanceS.setText("S");
        performanceS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performanceSActionPerformed(evt);
            }
        });
        jPanel1.add(performanceS, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 1020, -1, -1));

        groupPersonality.add(personalityS);
        personalityS.setText("S");
        personalityS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalitySActionPerformed(evt);
            }
        });
        jPanel1.add(personalityS, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 1130, -1, -1));

        groupPersonality.add(personalityA);
        personalityA.setText("A");
        jPanel1.add(personalityA, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 1130, -1, -1));

        groupPerformance.add(performanceA);
        performanceA.setText("A");
        jPanel1.add(performanceA, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 1020, -1, -1));

        groupPerformance.add(performanceB);
        performanceB.setText("B");
        jPanel1.add(performanceB, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1020, -1, -1));

        groupPersonality.add(personalityB);
        personalityB.setText("B");
        jPanel1.add(personalityB, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1130, -1, -1));

        groupPersonality.add(personalityC);
        personalityC.setText("C");
        jPanel1.add(personalityC, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 1130, -1, -1));

        groupPerformance.add(performanceC);
        performanceC.setText("C");
        jPanel1.add(performanceC, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 1020, -1, -1));

        groupPerformance.add(performanceD);
        performanceD.setText("D");
        jPanel1.add(performanceD, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 1020, -1, -1));

        groupPersonality.add(personalityD);
        personalityD.setText("D");
        jPanel1.add(personalityD, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 1130, -1, -1));

        jLabel9.setText("10. Personality");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 1130, -1, -1));

        jLabel10.setText("9. Performance");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 1020, -1, -1));

        jLabel12.setText("8. Schedule Keeping");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 910, -1, -1));

        jLabel13.setText("7. Planning Capability");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 800, -1, -1));

        jLabel14.setText("6. Professional");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 690, -1, -1));

        saveExcell.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        saveExcell.setForeground(new java.awt.Color(51, 51, 255));
        saveExcell.setText("Save as Excel");
        saveExcell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveExcellActionPerformed(evt);
            }
        });
        jPanel1.add(saveExcell, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 1410, 170, 40));

        judgement1.setColumns(20);
        judgement1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        judgement1.setRows(5);
        jScrollPane6.setViewportView(judgement1);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 720, 290, 60));

        judgement2.setColumns(20);
        judgement2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        judgement2.setRows(5);
        jScrollPane7.setViewportView(judgement2);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 830, 290, 60));

        judgement3.setColumns(20);
        judgement3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        judgement3.setRows(5);
        jScrollPane8.setViewportView(judgement3);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 940, 290, 60));

        judgement4.setColumns(20);
        judgement4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        judgement4.setRows(5);
        jScrollPane9.setViewportView(judgement4);

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 1050, 290, 60));

        judgement5.setColumns(20);
        judgement5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        judgement5.setRows(5);
        jScrollPane10.setViewportView(judgement5);

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 1160, 290, 60));

        judgement6.setColumns(20);
        judgement6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        judgement6.setRows(5);
        jScrollPane11.setViewportView(judgement6);

        jPanel1.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 720, 300, 60));

        judgement7.setColumns(20);
        judgement7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        judgement7.setRows(5);
        jScrollPane12.setViewportView(judgement7);

        jPanel1.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 830, 300, 60));

        judgement8.setColumns(20);
        judgement8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        judgement8.setRows(5);
        jScrollPane13.setViewportView(judgement8);

        jPanel1.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 940, 300, 60));

        judgement9.setColumns(20);
        judgement9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        judgement9.setRows(5);
        jScrollPane14.setViewportView(judgement9);

        jPanel1.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 1050, 300, 60));

        judgement10.setColumns(20);
        judgement10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        judgement10.setRows(5);
        jScrollPane15.setViewportView(judgement10);

        jPanel1.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 1160, 300, 60));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1164, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

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
                    idPresiden.setText(MySession.get_karyawanID());
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_signPresidentMouseClicked

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        
        if (idHRRevd.getText() == null) {
            idHRRevd.setText("0");
        }
        if (idHRMGR.getText() == null) {
            idHRMGR.setText("0");
        }
        if (idPresiden.getText() == null) {
            idPresiden.setText("0");
        }
        PreparedStatement myStmt = null;
        try {
            String sql = "UPDATE employee_clearance SET hr_revd=?, hr_mgr=?, president=? WHERE karyawan_id=?";
            myStmt = koneksi.prepareStatement(sql);
            
            myStmt.setString(1, idHRRevd.getText());
            myStmt.setString(2, idHRMGR.getText());
            myStmt.setString(3, idPresiden.getText());
            myStmt.setString(4, labelID.getText());
            myStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan data \n Succeed saving data");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan data \n Failed saving data");
        } finally {
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void coordinationSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coordinationSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coordinationSActionPerformed

    private void communicationSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_communicationSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_communicationSActionPerformed

    private void reportingSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportingSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportingSActionPerformed

    private void leadershipSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leadershipSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leadershipSActionPerformed

    private void knowledgeSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knowledgeSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_knowledgeSActionPerformed

    private void scheduleSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scheduleSActionPerformed

    private void planningSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planningSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_planningSActionPerformed

    private void profesionalSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profesionalSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profesionalSActionPerformed

    private void performanceSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performanceSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_performanceSActionPerformed

    private void personalitySActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalitySActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personalitySActionPerformed

    private void saveExcellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveExcellActionPerformed
        tracer();
    }//GEN-LAST:event_saveExcellActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaResult;
    private CustomResource.RadioButtonCustom communicationA;
    private CustomResource.RadioButtonCustom communicationB;
    private CustomResource.RadioButtonCustom communicationC;
    private CustomResource.RadioButtonCustom communicationD;
    private CustomResource.RadioButtonCustom communicationS;
    private CustomResource.RadioButtonCustom coordinationA;
    private CustomResource.RadioButtonCustom coordinationB;
    private CustomResource.RadioButtonCustom coordinationC;
    private CustomResource.RadioButtonCustom coordinationD;
    private CustomResource.RadioButtonCustom coordinationS;
    private CustomResource.CustomTextfield director;
    private CustomResource.CustomTextfield directorSenor;
    private CustomResource.CustomTextfield disciplineText;
    private javax.swing.ButtonGroup groupCommunication;
    private javax.swing.ButtonGroup groupCoordination;
    private javax.swing.ButtonGroup groupKnowledge;
    private javax.swing.ButtonGroup groupLeadership;
    private javax.swing.ButtonGroup groupPerformance;
    private javax.swing.ButtonGroup groupPersonality;
    private javax.swing.ButtonGroup groupPlaning;
    private javax.swing.ButtonGroup groupProfesional;
    private javax.swing.ButtonGroup groupReporting;
    private javax.swing.ButtonGroup groupSchedule;
    private javax.swing.JLabel idHRMGR;
    private javax.swing.JLabel idHRRevd;
    private javax.swing.JLabel idPresiden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea judgement1;
    private javax.swing.JTextArea judgement10;
    private javax.swing.JTextArea judgement2;
    private javax.swing.JTextArea judgement3;
    private javax.swing.JTextArea judgement4;
    private javax.swing.JTextArea judgement5;
    private javax.swing.JTextArea judgement6;
    private javax.swing.JTextArea judgement7;
    private javax.swing.JTextArea judgement8;
    private javax.swing.JTextArea judgement9;
    private CustomResource.RadioButtonCustom knowledgeA;
    private CustomResource.RadioButtonCustom knowledgeB;
    private CustomResource.RadioButtonCustom knowledgeC;
    private CustomResource.RadioButtonCustom knowledgeD;
    private CustomResource.RadioButtonCustom knowledgeS;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelNameHRMGR;
    private javax.swing.JLabel labelNameHRRevd;
    private javax.swing.JLabel labelNamePresident;
    private CustomResource.RadioButtonCustom leadershipA;
    private CustomResource.RadioButtonCustom leadershipB;
    private CustomResource.RadioButtonCustom leadershipC;
    private CustomResource.RadioButtonCustom leadershipD;
    private CustomResource.RadioButtonCustom leadershipS;
    private CustomResource.CustomTextfield managerDiscipline;
    private CustomResource.CustomTextfield managerTeam;
    private CustomResource.CustomTextfield nameText;
    private CustomResource.RadioButtonCustom performanceA;
    private CustomResource.RadioButtonCustom performanceB;
    private CustomResource.RadioButtonCustom performanceC;
    private CustomResource.RadioButtonCustom performanceD;
    private CustomResource.RadioButtonCustom performanceS;
    private CustomResource.RadioButtonCustom personalityA;
    private CustomResource.RadioButtonCustom personalityB;
    private CustomResource.RadioButtonCustom personalityC;
    private CustomResource.RadioButtonCustom personalityD;
    private CustomResource.RadioButtonCustom personalityS;
    private CustomResource.RadioButtonCustom planningA;
    private CustomResource.RadioButtonCustom planningB;
    private CustomResource.RadioButtonCustom planningC;
    private CustomResource.RadioButtonCustom planningD;
    private CustomResource.RadioButtonCustom planningS;
    private CustomResource.CustomTextfield positionText;
    private CustomResource.RadioButtonCustom profesionalA;
    private CustomResource.RadioButtonCustom profesionalB;
    private CustomResource.RadioButtonCustom profesionalC;
    private CustomResource.RadioButtonCustom profesionalD;
    private CustomResource.RadioButtonCustom profesionalS;
    private CustomResource.RadioButtonCustom reportingA;
    private CustomResource.RadioButtonCustom reportingB;
    private CustomResource.RadioButtonCustom reportingC;
    private CustomResource.RadioButtonCustom reportingD;
    private CustomResource.RadioButtonCustom reportingS;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton saveExcell;
    private CustomResource.RadioButtonCustom scheduleA;
    private CustomResource.RadioButtonCustom scheduleB;
    private CustomResource.RadioButtonCustom scheduleC;
    private CustomResource.RadioButtonCustom scheduleD;
    private CustomResource.RadioButtonCustom scheduleS;
    private javax.swing.JLabel signHRMGR;
    private javax.swing.JLabel signHRRevd;
    private javax.swing.JLabel signPresident;
    private CustomResource.CustomTextfield subordinateTeam;
    private CustomResource.CustomTextfield superiorTeam;
    private CustomResource.CustomTextfield workText;
    // End of variables declaration//GEN-END:variables

    private void MyWindow(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height - 45);
        this.setPreferredSize(screen);
    }
    
    private void tracer(){
        String templateFilePath = "src/Doc/Employee Evaluation.xlsx";

        coordinationS.setActionCommand("S");
        coordinationA.setActionCommand("A");
        coordinationB.setActionCommand("B");
        coordinationC.setActionCommand("C");
        coordinationD.setActionCommand("D");
        
        communicationS.setActionCommand("S");
        communicationA.setActionCommand("A");
        communicationB.setActionCommand("B");
        communicationC.setActionCommand("C");
        communicationD.setActionCommand("D");
        
        reportingS.setActionCommand("S");
        reportingA.setActionCommand("A");
        reportingB.setActionCommand("B");
        reportingC.setActionCommand("C");
        reportingD.setActionCommand("D");
        
        leadershipS.setActionCommand("S");
        leadershipA.setActionCommand("A");
        leadershipB.setActionCommand("B");
        leadershipC.setActionCommand("C");
        leadershipD.setActionCommand("D");
        
        knowledgeS.setActionCommand("S");
        knowledgeA.setActionCommand("A");
        knowledgeB.setActionCommand("B");
        knowledgeC.setActionCommand("C");
        knowledgeD.setActionCommand("D");
        
        profesionalS.setActionCommand("S");
        profesionalA.setActionCommand("A");
        profesionalB.setActionCommand("B");
        profesionalC.setActionCommand("C");
        profesionalD.setActionCommand("D");
        
        planningS.setActionCommand("S");
        planningA.setActionCommand("A");
        planningB.setActionCommand("B");
        planningC.setActionCommand("C");
        planningD.setActionCommand("D");
        
        scheduleS.setActionCommand("S");
        scheduleA.setActionCommand("A");
        scheduleB.setActionCommand("B");
        scheduleC.setActionCommand("C");
        scheduleD.setActionCommand("D");
        
        performanceS.setActionCommand("S");
        performanceA.setActionCommand("A");
        performanceB.setActionCommand("B");
        performanceC.setActionCommand("C");
        performanceD.setActionCommand("D");
        
        personalityS.setActionCommand("S");
        personalityA.setActionCommand("A");
        personalityB.setActionCommand("B");
        personalityC.setActionCommand("C");
        personalityD.setActionCommand("D");
        
        String Coordination = groupCoordination.getSelection().getActionCommand();
        String Communication = groupCommunication.getSelection().getActionCommand();
        String Reporting = groupReporting.getSelection().getActionCommand();
        String Leadership = groupLeadership.getSelection().getActionCommand();
        String Knowledge = groupKnowledge.getSelection().getActionCommand();
        String Professional = groupProfesional.getSelection().getActionCommand();
        String Planning = groupPlaning.getSelection().getActionCommand();
        String Schedule = groupSchedule.getSelection().getActionCommand();
        String Performance = groupPerformance.getSelection().getActionCommand();
        String Personality = groupPersonality.getSelection().getActionCommand();
        
        String name = nameText.getText();
        String discipline = disciplineText.getText();
        String position = positionText.getText();
        String work = workText.getText();
        String teamSubordinate = subordinateTeam.getText();
        String teamSuperior = superiorTeam.getText();
        String teamManager = managerTeam.getText();
        String disciplineManager = managerDiscipline.getText();
        String Director = director.getText();
        String senorDirector = directorSenor.getText();

        try {
            FileInputStream templateFile = new FileInputStream(templateFilePath);
            Workbook workbook = new XSSFWorkbook(templateFile);
            
            Sheet sheet = workbook.getSheet("Sheet1");
            
            sheet.getRow(10).getCell(2).setCellValue(discipline);
            sheet.getRow(11).getCell(2).setCellValue(name);
            sheet.getRow(10).getCell(7).setCellValue(position);
            sheet.getRow(11).getCell(7).setCellValue(work);
            
            sheet.getRow(14).getCell(2).setCellValue(teamSubordinate);
            sheet.getRow(15).getCell(2).setCellValue(teamSuperior);
            sheet.getRow(16).getCell(2).setCellValue(teamManager);
            sheet.getRow(14).getCell(8).setCellValue(disciplineManager);
            sheet.getRow(15).getCell(8).setCellValue(Director);
            sheet.getRow(16).getCell(8).setCellValue(senorDirector);
            
            switch (Coordination) {
                case "S":
                    sheet.getRow(21).getCell(2).setCellValue("✓");
                    break;
                case "A":
                    sheet.getRow(21).getCell(3).setCellValue("✓");
                    break;
                case "B":
                    sheet.getRow(21).getCell(4).setCellValue("✓");
                    break;
                case "C":
                    sheet.getRow(21).getCell(5).setCellValue("✓");
                    break;
                case "D":
                    sheet.getRow(21).getCell(6).setCellValue("✓");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Sorry, Something went wrong");
                    break;
            }
            sheet.getRow(21).getCell(7).setCellValue(judgement1.getText());

            switch (Communication) {
                case "S":
                    sheet.getRow(23).getCell(2).setCellValue("✓");
                    break;
                case "A":
                    sheet.getRow(23).getCell(3).setCellValue("✓");
                    break;
                case "B":
                    sheet.getRow(23).getCell(4).setCellValue("✓");
                    break;
                case "C":
                    sheet.getRow(23).getCell(5).setCellValue("✓");
                    break;
                case "D":
                    sheet.getRow(23).getCell(6).setCellValue("✓");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Sorry, Something went wrong");
                    break;
            }
            sheet.getRow(23).getCell(7).setCellValue(judgement2.getText());

            switch (Reporting) {
                case "S":
                    sheet.getRow(25).getCell(2).setCellValue("✓");
                    break;
                case "A":
                    sheet.getRow(25).getCell(3).setCellValue("✓");
                    break;
                case "B":
                    sheet.getRow(25).getCell(4).setCellValue("✓");
                    break;
                case "C":
                    sheet.getRow(25).getCell(5).setCellValue("✓");
                    break;
                case "D":
                    sheet.getRow(25).getCell(6).setCellValue("✓");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Sorry, Something went wrong");
                    break;
            }
            sheet.getRow(25).getCell(7).setCellValue(judgement3.getText());

            switch (Leadership) {
                case "S":
                    sheet.getRow(27).getCell(2).setCellValue("✓");
                    break;
                case "A":
                    sheet.getRow(27).getCell(3).setCellValue("✓");
                    break;
                case "B":
                    sheet.getRow(27).getCell(4).setCellValue("✓");
                    break;
                case "C":
                    sheet.getRow(27).getCell(5).setCellValue("✓");
                    break;
                case "D":
                    sheet.getRow(27).getCell(6).setCellValue("✓");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Sorry, Something went wrong");
                    break;
            }
            sheet.getRow(27).getCell(7).setCellValue(judgement4.getText());

            switch (Knowledge) {
                case "S":
                    sheet.getRow(29).getCell(2).setCellValue("✓");
                    break;
                case "A":
                    sheet.getRow(29).getCell(3).setCellValue("✓");
                    break;
                case "B":
                    sheet.getRow(29).getCell(4).setCellValue("✓");
                    break;
                case "C":
                    sheet.getRow(29).getCell(5).setCellValue("✓");
                    break;
                case "D":
                    sheet.getRow(29).getCell(6).setCellValue("✓");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Sorry, Something went wrong");
                    break;
            }
            sheet.getRow(29).getCell(7).setCellValue(judgement5.getText());

            switch (Professional) {
                case "S":
                    sheet.getRow(31).getCell(2).setCellValue("✓");
                    break;
                case "A":
                    sheet.getRow(31).getCell(3).setCellValue("✓");
                    break;
                case "B":
                    sheet.getRow(31).getCell(4).setCellValue("✓");
                    break;
                case "C":
                    sheet.getRow(31).getCell(5).setCellValue("✓");
                    break;
                case "D":
                    sheet.getRow(31).getCell(6).setCellValue("✓");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Sorry, Something went wrong");
                    break;
            }
            sheet.getRow(31).getCell(7).setCellValue(judgement6.getText());

            switch (Planning) {
                case "S":
                    sheet.getRow(33).getCell(2).setCellValue("✓");
                    break;
                case "A":
                    sheet.getRow(33).getCell(3).setCellValue("✓");
                    break;
                case "B":
                    sheet.getRow(33).getCell(4).setCellValue("✓");
                    break;
                case "C":
                    sheet.getRow(33).getCell(5).setCellValue("✓");
                    break;
                case "D":
                    sheet.getRow(33).getCell(6).setCellValue("✓");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Sorry, Something went wrong");
                    break;
            }
            sheet.getRow(33).getCell(7).setCellValue(judgement7.getText());

            switch (Schedule) {
                case "S":
                    sheet.getRow(35).getCell(2).setCellValue("✓");
                    break;
                case "A":
                    sheet.getRow(35).getCell(3).setCellValue("✓");
                    break;
                case "B":
                    sheet.getRow(35).getCell(4).setCellValue("✓");
                    break;
                case "C":
                    sheet.getRow(35).getCell(5).setCellValue("✓");
                    break;
                case "D":
                    sheet.getRow(35).getCell(6).setCellValue("✓");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Sorry, Something went wrong");
                    break;
            }
            sheet.getRow(35).getCell(7).setCellValue(judgement8.getText());

            switch (Performance) {
                case "S":
                    sheet.getRow(37).getCell(2).setCellValue("✓");
                    break;
                case "A":
                    sheet.getRow(37).getCell(3).setCellValue("✓");
                    break;
                case "B":
                    sheet.getRow(37).getCell(4).setCellValue("✓");
                    break;
                case "C":
                    sheet.getRow(37).getCell(5).setCellValue("✓");
                    break;
                case "D":
                    sheet.getRow(37).getCell(6).setCellValue("✓");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Sorry, Something went wrong");
                    break;
            }
            sheet.getRow(37).getCell(7).setCellValue(judgement9.getText());

            switch (Personality) {
                case "S":
                    sheet.getRow(39).getCell(2).setCellValue("✓");
                    break;
                case "A":
                    sheet.getRow(39).getCell(3).setCellValue("✓");
                    break;
                case "B":
                    sheet.getRow(39).getCell(4).setCellValue("✓");
                    break;
                case "C":
                    sheet.getRow(39).getCell(5).setCellValue("✓");
                    break;
                case "D":
                    sheet.getRow(39).getCell(6).setCellValue("✓");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Sorry, Something went wrong");
                    break;
            }
            sheet.getRow(39).getCell(7).setCellValue(judgement10.getText());
            
            sheet.getRow(43).getCell(0).setCellValue(areaResult.getText());
            
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

                System.out.println("Data berhasil dimasukkan ke dalam template Excel.");
                System.out.println("File output: " + outputFilePath);
            } else {
                System.out.println("Batal menyimpan file output.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void formrefresh() {
    }
    
}
