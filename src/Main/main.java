/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import CustomResource.MySession;
import CustomResource.UndoRedo;
import CustomResource.koneksi;
import TestResource.inputexel;
import TestResource.tambah;
import Employee.EmployeeProfilePanel;
import HumanResource.EmployeeConfirmation;
import Employee.ChangePassword;
import HumanResource.AddJobVacancy;
import HumanResource.AllocationAnnouncement;
import HumanResource.AplicationRehabilitation;
import HumanResource.ApplicationResignation;
import HumanResource.CandidateProfile;
import HumanResource.CandidateList;
import HumanResource.CandidateApplication;
import HumanResource.CandidateApplicationAcademic;
import HumanResource.CandidateApplicationCareer;
import HumanResource.CandidateApplicationCertificates;
import HumanResource.CandidateApplicationFamily;
import HumanResource.CandidateApplicationIntroduction;
import HumanResource.CandidateApplicationPersonal;
import HumanResource.CandidateApplicationSKCK;
import HumanResource.CandidateApplicationedit;
import HumanResource.ConfirmationHandingOverTakingOver;
import HumanResource.DisciplnaryResolution;
import HumanResource.EmployeeClearanceStatus;
import HumanResource.EmployeeEvaluation;
import HumanResource.LeaveOfAbsense;
import HumanResource.NotificationToNewEmployee;
import HumanResource.RequestEmployeeAllocation;
import HumanResource.SummaryStatusCandidatEmployee;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author lutfi
 */
public class main extends javax.swing.JFrame {
    Statement stm;
    ResultSet rs;
    ResultSet rsf;
    Connection koneksi;
    
    private static main main;
    private final UndoRedo<MasterForm> forms = new UndoRedo<>();
    
    public final static main getMain(){
        return main;
    }

    
    public void showForm(MasterForm form){
        forms.add(form);
        bodyPanel.removeAll();
        bodyPanel.add(form);
        bodyPanel.revalidate();
        bodyPanel.repaint();
        checkButton();

    }
    public void undo(){
        bodyPanel.removeAll();
        bodyPanel.add(forms.undo());
        bodyPanel.revalidate();
        bodyPanel.repaint();
        checkButton();
    }
    public void redo(){
        bodyPanel.removeAll();
        bodyPanel.add(forms.redo());
        bodyPanel.revalidate();
        bodyPanel.repaint();
        checkButton();
    }
    public void refresh(){
        MasterForm form = forms.getCurrent();
        if (form != null) {
            form.formrefresh();
        }
    }
    
    public main() {
        super("Operation System");
        initComponents();
        
        MyWindow();
        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource(".//Pictures//Logo.png"));
        this.setIconImage(logo.getImage());
        showForm(new MainPanel());
        String nama_log = CustomResource.MySession.get_nama();
        freshframe();
        this.refresh();
        openDB();
        if (nama_log == null) {
            HumanResourceSystem.setEnabled(true);
            POSystem.setEnabled(false);
            WarehouseSystem.setEnabled(false);
            AcountingSystem.setEnabled(false);
            myProfile.setVisible(false);
            SMLogout.setVisible(false);
            ToolBar.setVisible(true);
        } else {
//            buttonLogin.setVisible(false);
//            jLabel3.setVisible(false);
//            jLabel2.setVisible(false);
//            jLabel4.setVisible(false);
//            myProfile.setText(nama_log);
            ToolBar.add(Box.createHorizontalGlue());
            ToolBar.add(myProfile);
           
//            ToolBar.
//            jLabel2.setVisible(false);
//            jLabel3.setVisible(false);
//            jLabel4.setVisible(false);
//            jLabel5.setVisible(false);
//            buttonLogin.setVisible(false);
//            buttonLogin1.setVisible(false);
        }
   
    jPanel1.setVisible(false);
    bodyPanel.setVisible(false);
    }
    
    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }
    public void freshframe(){
        this.revalidate();
        this.repaint();
    }
    private void checkButton(){
        undoBar.setEnabled(forms.isUndoAble());
        redoBar.setEnabled(forms.isRedoAble());
    }
    inputexel inputxl = new inputexel();
    tambah tambah = new tambah();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        bodyPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonLogin1 = new javax.swing.JButton();
        t_ktp_edit = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        ToolBar = new javax.swing.JMenuBar();
        homeBar = new javax.swing.JMenu();
        undoBar = new javax.swing.JMenu();
        redoBar = new javax.swing.JMenu();
        HumanResourceSystem = new javax.swing.JMenu();
        candidateApplication = new javax.swing.JMenu();
        candidateList = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        applicationForm = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        employingConfirmation = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        NotificationtoNewEmployee = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        EmployeeStatus = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        Checklist = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        AllocationAnouncement = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        RequestEmployeeAllocation = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        ApplicationLeaveofAbsence = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        ApplicationRehabilitation = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        ApplicationResignation = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        EmployeeClearanceStatus = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        ConfirmationHandoverTakeover = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        DiciplinaryRevolution = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        EmployeeEvaluation = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        AddJobVacancy = new javax.swing.JMenuItem();
        POSystem = new javax.swing.JMenu();
        WarehouseSystem = new javax.swing.JMenu();
        AcountingSystem = new javax.swing.JMenu();
        myProfile = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        SMLogout = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bodyPanel.setBackground(new java.awt.Color(204, 0, 204));
        bodyPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Logo4.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Welcome to");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Welcome to");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("dimana saja");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("anywhere");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setText(" untuk melanjutkan");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel9.setText("to continue");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel11.setText("click");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setText("Klik");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("PT. Achivon Prestasi Abadi");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel13.setText("Welcome to");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Harap klik login terlebih dahulu");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("(please click Login below)");

        buttonLogin.setBackground(new java.awt.Color(0, 51, 255));
        buttonLogin.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("Login");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("ingin bekerja dengan kami?");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("(Please click if you want to join and register your data)");

        buttonLogin1.setBackground(new java.awt.Color(255, 0, 0));
        buttonLogin1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        buttonLogin1.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin1.setText("Register");
        buttonLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogin1ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Edit Data Candidate");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(buttonLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(t_ktp_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_ktp_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        homeBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/IconHome.png"))); // NOI18N
        homeBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBarMouseClicked(evt);
            }
        });
        homeBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBarActionPerformed(evt);
            }
        });
        ToolBar.add(homeBar);

        undoBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/undo.png"))); // NOI18N
        undoBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                undoBarMouseClicked(evt);
            }
        });
        undoBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoBarActionPerformed(evt);
            }
        });
        ToolBar.add(undoBar);

        redoBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/redo.png"))); // NOI18N
        redoBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                redoBarMouseClicked(evt);
            }
        });
        redoBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoBarActionPerformed(evt);
            }
        });
        ToolBar.add(redoBar);

        HumanResourceSystem.setText("Human Resource System  |");
        HumanResourceSystem.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        HumanResourceSystem.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                HumanResourceSystemMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        HumanResourceSystem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HumanResourceSystemMouseClicked(evt);
            }
        });

        candidateApplication.setText("Candidate Application");
        candidateApplication.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        candidateList.setText("Candidate List");
        candidateList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                candidateListActionPerformed(evt);
            }
        });
        candidateApplication.add(candidateList);
        candidateApplication.add(jSeparator15);

        applicationForm.setText("Application Form");
        applicationForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applicationFormActionPerformed(evt);
            }
        });
        candidateApplication.add(applicationForm);
        candidateApplication.add(jSeparator16);

        jMenuItem4.setText("jMenuItem4");
        jMenuItem4.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuItem4MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        candidateApplication.add(jMenuItem4);

        HumanResourceSystem.add(candidateApplication);
        HumanResourceSystem.add(jSeparator1);

        employingConfirmation.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        employingConfirmation.setText("Employing Confirmation");
        employingConfirmation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employingConfirmationActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(employingConfirmation);
        HumanResourceSystem.add(jSeparator2);

        NotificationtoNewEmployee.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        NotificationtoNewEmployee.setText("Notification to New Employee");
        NotificationtoNewEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificationtoNewEmployeeActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(NotificationtoNewEmployee);
        HumanResourceSystem.add(jSeparator3);

        EmployeeStatus.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        EmployeeStatus.setText("Employee Status");
        EmployeeStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeStatusActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(EmployeeStatus);
        HumanResourceSystem.add(jSeparator4);

        Checklist.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Checklist.setText("Checklist");
        Checklist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChecklistActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(Checklist);
        HumanResourceSystem.add(jSeparator5);

        AllocationAnouncement.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        AllocationAnouncement.setText("Allocation Anouncement");
        AllocationAnouncement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllocationAnouncementActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(AllocationAnouncement);
        HumanResourceSystem.add(jSeparator6);

        RequestEmployeeAllocation.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        RequestEmployeeAllocation.setText("Request - Employee Allocation ");
        RequestEmployeeAllocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestEmployeeAllocationActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(RequestEmployeeAllocation);
        HumanResourceSystem.add(jSeparator7);

        ApplicationLeaveofAbsence.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        ApplicationLeaveofAbsence.setText("Application - Leave of Absence");
        ApplicationLeaveofAbsence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplicationLeaveofAbsenceActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(ApplicationLeaveofAbsence);
        HumanResourceSystem.add(jSeparator8);

        ApplicationRehabilitation.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        ApplicationRehabilitation.setText("Application - Rehabilitation");
        ApplicationRehabilitation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplicationRehabilitationActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(ApplicationRehabilitation);
        HumanResourceSystem.add(jSeparator9);

        ApplicationResignation.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        ApplicationResignation.setText("Application - Resignation");
        ApplicationResignation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplicationResignationActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(ApplicationResignation);
        HumanResourceSystem.add(jSeparator10);

        EmployeeClearanceStatus.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        EmployeeClearanceStatus.setText("Employee Clearance Status");
        EmployeeClearanceStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeClearanceStatusActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(EmployeeClearanceStatus);
        HumanResourceSystem.add(jSeparator11);

        ConfirmationHandoverTakeover.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        ConfirmationHandoverTakeover.setText("Confirmation - Handover & Takeover");
        ConfirmationHandoverTakeover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmationHandoverTakeoverActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(ConfirmationHandoverTakeover);
        HumanResourceSystem.add(jSeparator12);

        DiciplinaryRevolution.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        DiciplinaryRevolution.setText("Diciplinary Revolution");
        DiciplinaryRevolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiciplinaryRevolutionActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(DiciplinaryRevolution);
        HumanResourceSystem.add(jSeparator13);

        EmployeeEvaluation.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        EmployeeEvaluation.setText("Employee Evaluation");
        EmployeeEvaluation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeEvaluationActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(EmployeeEvaluation);
        HumanResourceSystem.add(jSeparator14);

        AddJobVacancy.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        AddJobVacancy.setText("Add Job Vacancy");
        AddJobVacancy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddJobVacancyActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(AddJobVacancy);

        ToolBar.add(HumanResourceSystem);

        POSystem.setText("PO System  |");
        POSystem.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        ToolBar.add(POSystem);

        WarehouseSystem.setText("Warehouse System  |");
        WarehouseSystem.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        ToolBar.add(WarehouseSystem);

        AcountingSystem.setText("Accounting System  |");
        AcountingSystem.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        ToolBar.add(AcountingSystem);

        myProfile.setText("Profile");
        myProfile.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem1.setText("Profile");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        myProfile.add(jMenuItem1);
        myProfile.add(jSeparator17);

        jMenuItem2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem2.setText("Change Password");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        myProfile.add(jMenuItem2);
        myProfile.add(jSeparator18);

        SMLogout.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        SMLogout.setForeground(new java.awt.Color(255, 0, 0));
        SMLogout.setText("Logout");
        SMLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SMLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMLogoutActionPerformed(evt);
            }
        });
        myProfile.add(SMLogout);
        myProfile.add(jSeparator19);

        ToolBar.add(myProfile);

        setJMenuBar(ToolBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(79, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(131, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBarMouseClicked
        showForm(new MainPanel());
//new main().setVisible(true);
    }//GEN-LAST:event_homeBarMouseClicked

    private void homeBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBarActionPerformed
//
    }//GEN-LAST:event_homeBarActionPerformed

    private void candidateListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_candidateListActionPerformed
        showForm(new CandidateList());
    }//GEN-LAST:event_candidateListActionPerformed

    private void applicationFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applicationFormActionPerformed
        showForm(new CandidateApplicationPersonal());
    }//GEN-LAST:event_applicationFormActionPerformed

    private void employingConfirmationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employingConfirmationActionPerformed
        showForm(new EmployeeConfirmation());
    }//GEN-LAST:event_employingConfirmationActionPerformed

    private void EmployeeStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeStatusActionPerformed
        showForm(new SummaryStatusCandidatEmployee());
    }//GEN-LAST:event_EmployeeStatusActionPerformed

    private void HumanResourceSystemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HumanResourceSystemMouseClicked
        //masukdata_karyawan.setVisible(true);
    }//GEN-LAST:event_HumanResourceSystemMouseClicked

    private void SMLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMLogoutActionPerformed
        myLogout();
    }//GEN-LAST:event_SMLogoutActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        showForm(new ChangePassword());
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        showForm(new EmployeeProfilePanel());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void AllocationAnouncementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllocationAnouncementActionPerformed
        showForm(new AllocationAnnouncement());
    }//GEN-LAST:event_AllocationAnouncementActionPerformed

    private void NotificationtoNewEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificationtoNewEmployeeActionPerformed
        showForm(new NotificationToNewEmployee());
    }//GEN-LAST:event_NotificationtoNewEmployeeActionPerformed

    private void ChecklistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChecklistActionPerformed
//        ceklis
    }//GEN-LAST:event_ChecklistActionPerformed

    private void RequestEmployeeAllocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestEmployeeAllocationActionPerformed
        showForm(new RequestEmployeeAllocation());
    }//GEN-LAST:event_RequestEmployeeAllocationActionPerformed

    private void ApplicationLeaveofAbsenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplicationLeaveofAbsenceActionPerformed
        showForm(new LeaveOfAbsense());
    }//GEN-LAST:event_ApplicationLeaveofAbsenceActionPerformed

    private void ApplicationRehabilitationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplicationRehabilitationActionPerformed
        showForm(new AplicationRehabilitation());
    }//GEN-LAST:event_ApplicationRehabilitationActionPerformed

    private void ApplicationResignationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplicationResignationActionPerformed
        showForm(new ApplicationResignation());
    }//GEN-LAST:event_ApplicationResignationActionPerformed

    private void EmployeeClearanceStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeClearanceStatusActionPerformed
        showForm(new EmployeeClearanceStatus());
    }//GEN-LAST:event_EmployeeClearanceStatusActionPerformed

    private void ConfirmationHandoverTakeoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmationHandoverTakeoverActionPerformed
        showForm(new ConfirmationHandingOverTakingOver());
    }//GEN-LAST:event_ConfirmationHandoverTakeoverActionPerformed

    private void DiciplinaryRevolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiciplinaryRevolutionActionPerformed
        showForm(new DisciplnaryResolution());
    }//GEN-LAST:event_DiciplinaryRevolutionActionPerformed

    private void EmployeeEvaluationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeEvaluationActionPerformed
        showForm(new EmployeeEvaluation());
    }//GEN-LAST:event_EmployeeEvaluationActionPerformed

    private void AddJobVacancyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddJobVacancyActionPerformed
        showForm(new AddJobVacancy());
    }//GEN-LAST:event_AddJobVacancyActionPerformed

    private void redoBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoBarActionPerformed
//        redo();
    }//GEN-LAST:event_redoBarActionPerformed

    private void undoBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoBarActionPerformed
//        undo();
    }//GEN-LAST:event_undoBarActionPerformed

    private void undoBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_undoBarMouseClicked
        undo();
    }//GEN-LAST:event_undoBarMouseClicked

    private void redoBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redoBarMouseClicked
        redo();
    }//GEN-LAST:event_redoBarMouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem4MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuItem4MenuKeyPressed

    }//GEN-LAST:event_jMenuItem4MenuKeyPressed

    private void HumanResourceSystemMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_HumanResourceSystemMenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_HumanResourceSystemMenuKeyPressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
 String nama_lg = CustomResource.MySession.get_nama();
        myProfile.setText(nama_lg);
        myProfile.setVisible(true);
       jPanel1.setVisible(false);
       bodyPanel.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
jPanel1.setVisible(true);
jPanel2.setVisible(false);
        new LoginFrame().setVisible(true);
        main.getMain().setVisible(false);
        Main.main.getMain().showForm(new NewJPanel());
        main.getMain().dispose();
        //        main.getMain().dispose();
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void buttonLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogin1ActionPerformed
        jPanel2.setVisible(false);
        bodyPanel.setVisible(true);
        Main.main.getMain().showForm(new CandidateApplication());
    }//GEN-LAST:event_buttonLogin1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
   
 try {
            Statement stm = koneksi.createStatement();
          
            rs = stm.executeQuery("select*from cd_employee where KTP like '%" + t_ktp_edit.getText() + "%'");
             while (rs.next()) {
               
                  
                 MySession.set_cd_ktp( rs.getString("id_employee"));
                
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(MySession.get_cd_ktp());
        jPanel2.setVisible(false);
                 bodyPanel.setVisible(true);;
         Main.main.getMain().showForm(new CandidateApplicationedit());
// TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 main = new main();
                main.setVisible(true);
                
//                new main().setVisible(true);
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AcountingSystem;
    private javax.swing.JMenuItem AddJobVacancy;
    private javax.swing.JMenuItem AllocationAnouncement;
    private javax.swing.JMenuItem ApplicationLeaveofAbsence;
    private javax.swing.JMenuItem ApplicationRehabilitation;
    private javax.swing.JMenuItem ApplicationResignation;
    private javax.swing.JMenuItem Checklist;
    private javax.swing.JMenuItem ConfirmationHandoverTakeover;
    private javax.swing.JMenuItem DiciplinaryRevolution;
    private javax.swing.JMenuItem EmployeeClearanceStatus;
    private javax.swing.JMenuItem EmployeeEvaluation;
    private javax.swing.JMenuItem EmployeeStatus;
    private javax.swing.JMenu HumanResourceSystem;
    private javax.swing.JMenuItem NotificationtoNewEmployee;
    private javax.swing.JMenu POSystem;
    private javax.swing.JMenuItem RequestEmployeeAllocation;
    private javax.swing.JMenuItem SMLogout;
    private javax.swing.JMenuBar ToolBar;
    private javax.swing.JMenu WarehouseSystem;
    private javax.swing.JMenuItem applicationForm;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonLogin1;
    private javax.swing.JMenu candidateApplication;
    private javax.swing.JMenuItem candidateList;
    private javax.swing.JMenuItem employingConfirmation;
    private javax.swing.JMenu homeBar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JMenu myProfile;
    private javax.swing.JMenu redoBar;
    private javax.swing.JTextField t_ktp_edit;
    private javax.swing.JMenu undoBar;
    // End of variables declaration//GEN-END:variables
 private void myLogout() {
       CustomResource.MySession.set_ktp("");
        CustomResource.MySession.set_nama("");
        new Main.LoginFrame().setVisible(true);
        this.dispose(); 
    }
    
    private void MyWindow(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height - 45);
        bodyPanel.setPreferredSize(screen);
//        MainPanel.setPreferredSize(screen);
//        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = (screen.width/2) - (this.getSize().width/2);
//        int y = (screen.height/2) - (this.getSize().height/2);
//        this.setLocation(x,y);
    }
}


