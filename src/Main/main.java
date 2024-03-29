/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.sql.DriverManager;
import CustomResource.MySession;
import CustomResource.UndoRedo;
import CustomResource.koneksi;
import DocumentControl.dc_form_letter;
import DocumentControl.dc_form_transmittal;
import DocumentControl.dc_incoming;
import DocumentControl.dc_incoming_transmittal;
import DocumentControl.dc_list_transmittal;
import DocumentControl.dc_outgoing;
import DocumentControl.dc_outgoing_transmittal;
import TestResource.inputexel;
import TestResource.tambah;
import Employee.EmployeeProfilePanel;
import HumanResource.EmployeeConfirmation;
import Employee.ChangePassword;
import HumanResource.AddJobVacancy;
import HumanResource.AllocationAnnouncement;
import HumanResource.AplicationRehabilitation;
import HumanResource.ApplicationResignation;
import HumanResource.CandidateList;
import HumanResource.CandidateApplication;
import HumanResource.CandidateApplicationedit;
import HumanResource.Checklist;
import HumanResource.ClearanceList;
import HumanResource.ConfirmationHandingOverTakingOver;
import HumanResource.ConfirmationHandoverandTakeoverList;
import HumanResource.DisciplnaryResolution;
import HumanResource.EmployeeClearanceStatus;
import HumanResource.EmployeeEvaluation;
import HumanResource.LeaveOfAbsenceList;
import HumanResource.LeaveOfAbsense;
import HumanResource.NotificationToNewEmployee;
import HumanResource.RehabilitationList;
import HumanResource.RequestAllocationList;
import HumanResource.RequestEmployeeAllocation;
import HumanResource.ResignationList;
import HumanResource.SummaryStatusCandidatEmployee;
import MonthlyProgress.AddProgress;
import MonthlyProgress.MonthlyProgress;
import ProcurementSystem.AddMaterialList;
import ProcurementSystem.BizPointment;
import ProcurementSystem.RequestedList;
import ProcurementSystem.Warehouse;
import ProcurementSystem.po;
import ProcurementSystem.po_form_po;
import ProcurementSystem.po_form_sq;
import ProcurementSystem.po_list;
import ProcurementSystem.po_list_mr;
import ProcurementSystem.po_list_po;
import ProcurementSystem.po_material_request;
import ProcurementSystem.po_list_request_material;
import ProcurementSystem.po_list_rfq;
import ProcurementSystem.po_list_sq;
import ProcurementSystem.po_rfq;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import scroolbarWin11.ScrollBarWin11UI;
//import javax.swing.UIDefaults;

public class main extends javax.swing.JFrame {

    private static main main;
    private final UndoRedo<MasterForm> forms = new UndoRedo<>();

    public final static main getMain() {
        return main;
    }

    public void showForm(MasterForm form) {
        forms.add(form);
        bodyPanel.removeAll();
        bodyPanel.add(form);
        bodyPanel.revalidate();
        bodyPanel.repaint();
        checkButton();
    }

    public void undo() {
        bodyPanel.removeAll();
        bodyPanel.add(forms.undo());
        bodyPanel.revalidate();
        bodyPanel.repaint();
        checkButton();
    }

    public void redo() {
        bodyPanel.removeAll();
        bodyPanel.add(forms.redo());
        bodyPanel.revalidate();
        bodyPanel.repaint();
        checkButton();
    }

    public void refresh() {
        MasterForm form = forms.getCurrent();
        if (form != null) {
            form.formrefresh();
        }
    }

    public String nama_log = CustomResource.MySession.get_nama();
    Statement stm;
    ResultSet rs;
    ResultSet rsf;
    Connection koneksi;

    public main() {
        super("PT Achivon Prestasi Abadi's Operation System");
        initComponents();
        openDB();
//        setUserRole();
        bg();
        NotificationtoNewEmployee.setVisible(false);
        jSeparator4.setVisible(false);

        ImageIcon logo = new ImageIcon("C:\\Program Files (x86)\\AchivonAPP\\Logo.png");
        this.setIconImage(logo.getImage());

    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);

        if (visible) {
            myFunction();
        } else {
//            myFunction();
        }
    }

    private void checkButton() {
        undoBar.setEnabled(forms.isUndoAble());
        redoBar.setEnabled(forms.isRedoAble());
    }

    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }

    private void bg() {
        String crudimage = "C:\\Program Files (x86)\\AchivonAPP\\rm347-porpla-01.jpg";
        ImageIcon imageicon = new ImageIcon(crudimage);
        JLabel label = new JLabel(imageicon);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Image imageResize = imageicon.getImage().getScaledInstance(screen.width, screen.height, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(imageResize));
        label.setBounds(0, 0, screen.width, screen.height);
        jPanel2.add(label);
    }
    inputexel inputxl = new inputexel();
    tambah tambah = new tambah();
    
    

    /**
     *
     *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bodyPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonLogin1 = new javax.swing.JButton();
        customTextfield1 = new CustomResource.CustomTextfield();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonLogin2 = new javax.swing.JButton();
        jSeparator29 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        ToolBar = new javax.swing.JMenuBar();
        homeBar = new javax.swing.JMenu();
        undoBar = new javax.swing.JMenu();
        redoBar = new javax.swing.JMenu();
        HumanResourceSystem = new javax.swing.JMenu();
        CandidateList = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        employingConfirmation = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        NotificationtoNewEmployee = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        EmployeeStatus = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        Checklist = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        AllocationAnouncement = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        RequestEmployeeAllocation = new javax.swing.JMenu();
        requestedEmployeeAllocationList = new javax.swing.JMenuItem();
        jSeparator26 = new javax.swing.JPopupMenu.Separator();
        requestAllocation = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        AplicationLeaveOfAbsence = new javax.swing.JMenu();
        employeeLeaveofAbsenceList = new javax.swing.JMenuItem();
        jSeparator25 = new javax.swing.JPopupMenu.Separator();
        requestLeaveofAbsence = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        ApplicationRehabilitation = new javax.swing.JMenu();
        employeeRehabilitationList = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        requestRehabilitation = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        ApplicationResignation = new javax.swing.JMenu();
        employeeResignationList = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        requestResignation = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        EmployeeClearanceStatus = new javax.swing.JMenu();
        clearanceEmployeeList = new javax.swing.JMenuItem();
        jSeparator27 = new javax.swing.JPopupMenu.Separator();
        clearanceStatus = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        ConfirmationHandoverTakeover = new javax.swing.JMenu();
        employeeHandoverTakeover = new javax.swing.JMenuItem();
        jSeparator28 = new javax.swing.JPopupMenu.Separator();
        requestHandoverTakeover = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        DiciplinaryRevolution = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        EmployeeEvaluation = new javax.swing.JMenuItem();
        jSeparator24 = new javax.swing.JPopupMenu.Separator();
        AddJobVacancy = new javax.swing.JMenuItem();
        jSeparator30 = new javax.swing.JPopupMenu.Separator();
        ProcurementSystem = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        WarehouseSystem = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jSeparator31 = new javax.swing.JPopupMenu.Separator();
        jSeparator32 = new javax.swing.JPopupMenu.Separator();
        AcountingSystem = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        AcountingSystem1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        myProfile = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        SMLogout = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bodyPanel.setBackground(new java.awt.Color(204, 0, 204));
        bodyPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Welcome to PT. Achivon Prestasi Abadi");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Harap klik login terlebih dahulu");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("(please click Login below)");

        buttonLogin.setBackground(new java.awt.Color(0, 51, 255));
        buttonLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("Login");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("silahkan klik jika ingin bergabung dan daftarkan data anda");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("(Please click if you want to join and register your data)");

        buttonLogin1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonLogin1.setForeground(new java.awt.Color(51, 51, 255));
        buttonLogin1.setText("Register");
        buttonLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogin1ActionPerformed(evt);
            }
        });

        customTextfield1.setLabelText("Maukan No. KTP / Input No. KTP ");
        customTextfield1.setOpaque(true);
        customTextfield1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customTextfield1KeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Masukan No KTP anda jika ingin mengubah data anda yang sebelumnya lalu klik \"Edit\"");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("(input your KTP number if you want to edit your previous data and then click \"Edit\")");

        buttonLogin2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonLogin2.setForeground(new java.awt.Color(51, 51, 255));
        buttonLogin2.setText("Edit");
        buttonLogin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogin2ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Untuk Non Karywan (For Applicant)");
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(customTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator29, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(buttonLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLogin1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(customTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonLogin2)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        ToolBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        CandidateList.setText("Candidate List");
        CandidateList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CandidateListActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(CandidateList);
        HumanResourceSystem.add(jSeparator2);

        employingConfirmation.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        employingConfirmation.setText("Employing Confirmation");
        employingConfirmation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employingConfirmationActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(employingConfirmation);
        HumanResourceSystem.add(jSeparator3);

        NotificationtoNewEmployee.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NotificationtoNewEmployee.setText("Notification to New Employee");
        NotificationtoNewEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificationtoNewEmployeeActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(NotificationtoNewEmployee);
        HumanResourceSystem.add(jSeparator4);

        EmployeeStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        EmployeeStatus.setText("Employee Status");
        EmployeeStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeStatusActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(EmployeeStatus);
        HumanResourceSystem.add(jSeparator5);

        Checklist.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Checklist.setText("Checklist");
        Checklist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChecklistActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(Checklist);
        HumanResourceSystem.add(jSeparator6);

        AllocationAnouncement.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        AllocationAnouncement.setText("Allocation Anouncement");
        AllocationAnouncement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllocationAnouncementActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(AllocationAnouncement);
        HumanResourceSystem.add(jSeparator7);

        RequestEmployeeAllocation.setText("Request - Employee Allocation ");
        RequestEmployeeAllocation.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        requestedEmployeeAllocationList.setText("Requested Employee Allocation List");
        requestedEmployeeAllocationList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestedEmployeeAllocationListActionPerformed(evt);
            }
        });
        RequestEmployeeAllocation.add(requestedEmployeeAllocationList);
        RequestEmployeeAllocation.add(jSeparator26);

        requestAllocation.setText("Request Allocation");
        requestAllocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestAllocationActionPerformed(evt);
            }
        });
        RequestEmployeeAllocation.add(requestAllocation);

        HumanResourceSystem.add(RequestEmployeeAllocation);
        HumanResourceSystem.add(jSeparator8);

        AplicationLeaveOfAbsence.setText("Application - Leave of Absence");
        AplicationLeaveOfAbsence.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        employeeLeaveofAbsenceList.setText("Employee Leave of Absence List");
        employeeLeaveofAbsenceList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeLeaveofAbsenceListActionPerformed(evt);
            }
        });
        AplicationLeaveOfAbsence.add(employeeLeaveofAbsenceList);
        AplicationLeaveOfAbsence.add(jSeparator25);

        requestLeaveofAbsence.setText("Request Leave of Absence");
        requestLeaveofAbsence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestLeaveofAbsenceActionPerformed(evt);
            }
        });
        AplicationLeaveOfAbsence.add(requestLeaveofAbsence);

        HumanResourceSystem.add(AplicationLeaveOfAbsence);
        HumanResourceSystem.add(jSeparator9);

        ApplicationRehabilitation.setText("Application - Rehabilitation");
        ApplicationRehabilitation.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        employeeRehabilitationList.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        employeeRehabilitationList.setText("Employee Rehabilitation List");
        employeeRehabilitationList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeRehabilitationListActionPerformed(evt);
            }
        });
        ApplicationRehabilitation.add(employeeRehabilitationList);
        ApplicationRehabilitation.add(jSeparator22);

        requestRehabilitation.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        requestRehabilitation.setText("Request Rehabilitation");
        requestRehabilitation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestRehabilitationActionPerformed(evt);
            }
        });
        ApplicationRehabilitation.add(requestRehabilitation);
        ApplicationRehabilitation.add(jSeparator23);

        HumanResourceSystem.add(ApplicationRehabilitation);
        HumanResourceSystem.add(jSeparator10);

        ApplicationResignation.setText("Application - Resignation");
        ApplicationResignation.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ApplicationResignation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplicationResignationActionPerformed(evt);
            }
        });

        employeeResignationList.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        employeeResignationList.setText("Employee Resignation List");
        employeeResignationList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeResignationListActionPerformed(evt);
            }
        });
        ApplicationResignation.add(employeeResignationList);
        ApplicationResignation.add(jSeparator20);

        requestResignation.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        requestResignation.setText("Request Resignation");
        requestResignation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestResignationActionPerformed(evt);
            }
        });
        ApplicationResignation.add(requestResignation);
        ApplicationResignation.add(jSeparator21);

        HumanResourceSystem.add(ApplicationResignation);
        HumanResourceSystem.add(jSeparator11);

        EmployeeClearanceStatus.setText("Employee Clearance Status");
        EmployeeClearanceStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        clearanceEmployeeList.setText("Clearance Employee List");
        clearanceEmployeeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearanceEmployeeListActionPerformed(evt);
            }
        });
        EmployeeClearanceStatus.add(clearanceEmployeeList);
        EmployeeClearanceStatus.add(jSeparator27);

        clearanceStatus.setText("Clearance Status");
        clearanceStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearanceStatusActionPerformed(evt);
            }
        });
        EmployeeClearanceStatus.add(clearanceStatus);

        HumanResourceSystem.add(EmployeeClearanceStatus);
        HumanResourceSystem.add(jSeparator12);

        ConfirmationHandoverTakeover.setText("Confirmation - Handover & Takeover");
        ConfirmationHandoverTakeover.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        employeeHandoverTakeover.setText("Employee Handover & Takeover List");
        employeeHandoverTakeover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeHandoverTakeoverActionPerformed(evt);
            }
        });
        ConfirmationHandoverTakeover.add(employeeHandoverTakeover);
        ConfirmationHandoverTakeover.add(jSeparator28);

        requestHandoverTakeover.setText("Request Handover & Takeover");
        requestHandoverTakeover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestHandoverTakeoverActionPerformed(evt);
            }
        });
        ConfirmationHandoverTakeover.add(requestHandoverTakeover);

        HumanResourceSystem.add(ConfirmationHandoverTakeover);
        HumanResourceSystem.add(jSeparator13);

        DiciplinaryRevolution.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        DiciplinaryRevolution.setText("Diciplinary Resolution");
        DiciplinaryRevolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiciplinaryRevolutionActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(DiciplinaryRevolution);
        HumanResourceSystem.add(jSeparator14);

        EmployeeEvaluation.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        EmployeeEvaluation.setText("Employee Evaluation");
        EmployeeEvaluation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeEvaluationActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(EmployeeEvaluation);
        HumanResourceSystem.add(jSeparator24);

        AddJobVacancy.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        AddJobVacancy.setText("Add Job Vacancy");
        AddJobVacancy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddJobVacancyActionPerformed(evt);
            }
        });
        HumanResourceSystem.add(AddJobVacancy);
        HumanResourceSystem.add(jSeparator30);

        ToolBar.add(HumanResourceSystem);

        ProcurementSystem.setText("Procurement System |");
        ProcurementSystem.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jMenuItem16.setText("Biz Partner");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        ProcurementSystem.add(jMenuItem16);
        ProcurementSystem.add(jSeparator16);

        jMenu1.setText("Procurement System");

        jMenuItem19.setText("List Items Request");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem19);

        jMenuItem26.setText("Form RFQ");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem26);

        jMenuItem22.setText("List RFQ");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem22);

        jMenuItem21.setText("Form Sales Quatation (SQ)");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem21);

        jMenuItem23.setText("List Sales Quatation (SQ)");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem23);

        jMenuItem27.setText("Form PO");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem27);

        jMenuItem29.setText("List PO");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem29);

        ProcurementSystem.add(jMenu1);
        ProcurementSystem.add(jSeparator15);

        jMenu2.setText("Request For Material");

        jMenuItem18.setText("Form Material Request");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem18);

        jMenuItem20.setText("Add Material List");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem20);

        ProcurementSystem.add(jMenu2);

        ToolBar.add(ProcurementSystem);

        WarehouseSystem.setText("Warehouse System  |");
        WarehouseSystem.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        WarehouseSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WarehouseSystemActionPerformed(evt);
            }
        });

        jMenuItem17.setText("Warehouse");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        WarehouseSystem.add(jMenuItem17);
        WarehouseSystem.add(jSeparator31);
        WarehouseSystem.add(jSeparator32);

        ToolBar.add(WarehouseSystem);

        AcountingSystem.setText("Accounting System  |");
        AcountingSystem.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        ToolBar.add(AcountingSystem);

        jMenu3.setText("Monthly Progress |");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem24.setText("Add Plan");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem24);

        jMenuItem25.setText("Add Progress");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem25);

        ToolBar.add(jMenu3);

        AcountingSystem1.setText("Document Control  |");
        AcountingSystem1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jMenu4.setText("Corresponden Tracking");

        jMenuItem28.setText("Outgoing");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem28);

        jMenuItem30.setText("Outgoing Transmittal");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem30);

        jMenuItem31.setText("Incoming");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem31);

        jMenuItem32.setText("Incoming Transmittal");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem32);

        AcountingSystem1.add(jMenu4);

        jMenu5.setText("Transmittal");

        jMenuItem33.setText("Form Transmittal");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem33);

        jMenuItem34.setText("List Transmittal");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem34);

        AcountingSystem1.add(jMenu5);

        jMenuItem35.setText("Form Letter");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        AcountingSystem1.add(jMenuItem35);

        ToolBar.add(AcountingSystem1);

        myProfile.setText("Profile");
        myProfile.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        myProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myProfileMouseClicked(evt);
            }
        });
        myProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myProfileActionPerformed(evt);
            }
        });

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
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBarMouseClicked
        showForm(new MainPanel());
        //new main().setVisible(true);
    }//GEN-LAST:event_homeBarMouseClicked

    private void homeBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBarActionPerformed

    }//GEN-LAST:event_homeBarActionPerformed

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
        showForm(new Checklist());
    }//GEN-LAST:event_ChecklistActionPerformed

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

    private void HumanResourceSystemMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_HumanResourceSystemMenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_HumanResourceSystemMenuKeyPressed

    private void myProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myProfileActionPerformed
//        TODO add your handling code here:
    }//GEN-LAST:event_myProfileActionPerformed

    private void myProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myProfileMouseClicked
        String nama_lg = CustomResource.MySession.get_nama();
    }//GEN-LAST:event_myProfileMouseClicked

    private void ApplicationResignationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplicationResignationActionPerformed
//        
    }//GEN-LAST:event_ApplicationResignationActionPerformed

    private void employeeResignationListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeResignationListActionPerformed
        showForm(new ResignationList());
    }//GEN-LAST:event_employeeResignationListActionPerformed

    private void requestResignationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestResignationActionPerformed
        showForm(new ApplicationResignation());
    }//GEN-LAST:event_requestResignationActionPerformed

    private void employeeRehabilitationListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeRehabilitationListActionPerformed
        showForm(new RehabilitationList());
    }//GEN-LAST:event_employeeRehabilitationListActionPerformed

    private void requestRehabilitationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestRehabilitationActionPerformed
        showForm(new AplicationRehabilitation());
    }//GEN-LAST:event_requestRehabilitationActionPerformed

    private void employeeLeaveofAbsenceListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeLeaveofAbsenceListActionPerformed
        showForm(new LeaveOfAbsenceList());
    }//GEN-LAST:event_employeeLeaveofAbsenceListActionPerformed

    private void requestLeaveofAbsenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestLeaveofAbsenceActionPerformed
        showForm(new LeaveOfAbsense());
    }//GEN-LAST:event_requestLeaveofAbsenceActionPerformed

    private void requestedEmployeeAllocationListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestedEmployeeAllocationListActionPerformed
        showForm(new RequestAllocationList());
    }//GEN-LAST:event_requestedEmployeeAllocationListActionPerformed

    private void requestAllocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestAllocationActionPerformed
        showForm(new RequestEmployeeAllocation());
    }//GEN-LAST:event_requestAllocationActionPerformed

    private void clearanceEmployeeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearanceEmployeeListActionPerformed
        showForm(new ClearanceList());
    }//GEN-LAST:event_clearanceEmployeeListActionPerformed

    private void clearanceStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearanceStatusActionPerformed
        showForm(new EmployeeClearanceStatus());
    }//GEN-LAST:event_clearanceStatusActionPerformed

    private void employeeHandoverTakeoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeHandoverTakeoverActionPerformed
        showForm(new ConfirmationHandoverandTakeoverList());
    }//GEN-LAST:event_employeeHandoverTakeoverActionPerformed

    private void requestHandoverTakeoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestHandoverTakeoverActionPerformed
        showForm(new ConfirmationHandingOverTakingOver());
    }//GEN-LAST:event_requestHandoverTakeoverActionPerformed

    private void buttonLogin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogin2ActionPerformed
        try {
            Statement stm = koneksi.createStatement();
            rs = stm.executeQuery("select*from cd_employee where KTP = " + customTextfield1.getText() + "");
            while (rs.next()) {
                MySession.set_cd_ktp(rs.getString("id_employee"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ID card number not found");

        }
        Main.main.getMain().showForm(new CandidateApplicationedit());
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cd_foto where id_employee ='" + MySession.get_cd_ktp() + "'"); // assuming the image is stored in the 'images' table with an ID of 1

            if (rs.next()) {
                byte[] imageData = rs.getBytes("foto");
                ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                BufferedImage bImage = ImageIO.read(bis);
                ImageIcon Myicon = new ImageIcon(bImage);
                Image imageResize = Myicon.getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH);
                CandidateApplicationedit.labelfoto.setIcon(new ImageIcon(imageResize));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        customTextfield1.setText("");
        jPanel2.setVisible(false);
        bodyPanel.setVisible(true);
    }//GEN-LAST:event_buttonLogin2ActionPerformed

    private void customTextfield1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customTextfield1KeyTyped
        if (customTextfield1.getText().length() > 15) {
            JOptionPane.showMessageDialog(null, "Maximal 16 digit Angka  \n Maximal 16 digit number");
            evt.consume();
        }
    }//GEN-LAST:event_customTextfield1KeyTyped

    private void buttonLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogin1ActionPerformed
        jPanel2.setVisible(false);
        bodyPanel.setVisible(true);
        Main.main.getMain().showForm(new CandidateApplication());
    }//GEN-LAST:event_buttonLogin1ActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        new LoginFrame().setVisible(true);
        main.getMain().setVisible(false);
        //        main.getMain().dispose();
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void CandidateListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CandidateListActionPerformed
        showForm(new CandidateList());
    }//GEN-LAST:event_CandidateListActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        showForm(new BizPointment());
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void WarehouseSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WarehouseSystemActionPerformed
        showForm(new Warehouse());        // TODO add your handling code here:
    }//GEN-LAST:event_WarehouseSystemActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        showForm(new Warehouse());         // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        showForm(new AddMaterialList());          // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        showForm(new po_material_request());    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        showForm(new MonthlyProgress());        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        showForm(new AddProgress());          // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
    showForm(new po_rfq());      // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
      showForm(new po_list_rfq());  // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
     showForm(new po_form_sq());    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
      showForm(new po_list_sq());  // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
     showForm(new po_form_po());   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
     showForm(new po_list_po());   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
      showForm(new po_list_mr());    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
     showForm(new dc_outgoing());   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
     showForm(new dc_outgoing_transmittal());    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
       showForm(new dc_incoming());  // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
       showForm(new dc_incoming_transmittal());  // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
      showForm(new dc_form_transmittal());  // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
      showForm(new dc_list_transmittal());  // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
       showForm(new dc_form_letter());  // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem35ActionPerformed

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        UIDefaults myUI = UIManager.getDefaults();
        myUI.put("ScroolBarUI", ScrollBarWin11UI.class.getCanonicalName());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                main = new main();
                main.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu AcountingSystem;
    public static javax.swing.JMenu AcountingSystem1;
    private javax.swing.JMenuItem AddJobVacancy;
    private javax.swing.JMenuItem AllocationAnouncement;
    private javax.swing.JMenu AplicationLeaveOfAbsence;
    private javax.swing.JMenu ApplicationRehabilitation;
    private javax.swing.JMenu ApplicationResignation;
    private javax.swing.JMenuItem CandidateList;
    private javax.swing.JMenuItem Checklist;
    private javax.swing.JMenu ConfirmationHandoverTakeover;
    private javax.swing.JMenuItem DiciplinaryRevolution;
    private javax.swing.JMenu EmployeeClearanceStatus;
    private javax.swing.JMenuItem EmployeeEvaluation;
    private javax.swing.JMenuItem EmployeeStatus;
    public static javax.swing.JMenu HumanResourceSystem;
    private javax.swing.JMenuItem NotificationtoNewEmployee;
    public static javax.swing.JMenu ProcurementSystem;
    private javax.swing.JMenu RequestEmployeeAllocation;
    public static javax.swing.JMenuItem SMLogout;
    public static javax.swing.JMenuBar ToolBar;
    public static javax.swing.JMenu WarehouseSystem;
    public static javax.swing.JPanel bodyPanel;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonLogin1;
    private javax.swing.JButton buttonLogin2;
    private javax.swing.JMenuItem clearanceEmployeeList;
    private javax.swing.JMenuItem clearanceStatus;
    private CustomResource.CustomTextfield customTextfield1;
    private javax.swing.JMenuItem employeeHandoverTakeover;
    private javax.swing.JMenuItem employeeLeaveofAbsenceList;
    private javax.swing.JMenuItem employeeRehabilitationList;
    private javax.swing.JMenuItem employeeResignationList;
    private javax.swing.JMenuItem employingConfirmation;
    public static javax.swing.JMenu homeBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    public static javax.swing.JPanel jPanel2;
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
    private javax.swing.JPopupMenu.Separator jSeparator20;
    private javax.swing.JPopupMenu.Separator jSeparator21;
    private javax.swing.JPopupMenu.Separator jSeparator22;
    private javax.swing.JPopupMenu.Separator jSeparator23;
    private javax.swing.JPopupMenu.Separator jSeparator24;
    private javax.swing.JPopupMenu.Separator jSeparator25;
    private javax.swing.JPopupMenu.Separator jSeparator26;
    private javax.swing.JPopupMenu.Separator jSeparator27;
    private javax.swing.JPopupMenu.Separator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator30;
    private javax.swing.JPopupMenu.Separator jSeparator31;
    private javax.swing.JPopupMenu.Separator jSeparator32;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    public static javax.swing.JMenu myProfile;
    public static javax.swing.JMenu redoBar;
    private javax.swing.JMenuItem requestAllocation;
    private javax.swing.JMenuItem requestHandoverTakeover;
    private javax.swing.JMenuItem requestLeaveofAbsence;
    private javax.swing.JMenuItem requestRehabilitation;
    private javax.swing.JMenuItem requestResignation;
    private javax.swing.JMenuItem requestedEmployeeAllocationList;
    public static javax.swing.JMenu undoBar;
    // End of variables declaration//GEN-END:variables
    private void myLogout() {
        MySession.set_ID(null);
        MySession.set_karyawanID(null);
        MySession.set_ktp(null);
        MySession.set_nama(null);
        MySession.set_birthPlace(null);
        MySession.set_Birthday(null);
        MySession.set_sex(null);
        MySession.set_marital(null);
        MySession.set_email(null);
        MySession.set_mobileNumber(null);
        MySession.set_BPJS(null);
        MySession.set_NPWP(null);
        MySession.set_JobPosition(null);
        MySession.set_Sallary(null);
        MySession.set_Role(null);
        MySession.set_cd_ktp(null);
        new LoginFrame().setVisible(true);
        System.out.println("role "+ MySession.get_Role());
        main.jPanel2.setVisible(true);
        main.getMain().setVisible(false);
    }

    private void MyWindow() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height - 45);
        bodyPanel.setPreferredSize(screen);
    }

    private void MyWindow1() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width - 500, screen.height - 150);
        this.setPreferredSize(new Dimension(screen.width - 200, screen.height - 100));

        int x = (screen.width / 2) - (this.getSize().width / 2);
        int y = (screen.height / 2) - (this.getSize().height / 2);
        this.setLocation(x, y);
    }

    private void myFunction() {
        if (MySession.get_nama() == null) {
            MyWindow1();
            bodyPanel.setVisible(false);
            HumanResourceSystem.setEnabled(false);
            ProcurementSystem.setEnabled(false);
            WarehouseSystem.setEnabled(false);
            AcountingSystem.setEnabled(false);
            myProfile.setVisible(false);
            SMLogout.setVisible(false);
            ToolBar.setVisible(false);
            homeBar.setVisible(false);
            undoBar.setVisible(false);
            redoBar.setVisible(false);

        } else {
            MyWindow();
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            bodyPanel.setVisible(true);
            HumanResourceSystem.setEnabled(true);
            ProcurementSystem.setEnabled(true);
            WarehouseSystem.setEnabled(true);
            AcountingSystem.setEnabled(true);
            myProfile.setVisible(true);
            SMLogout.setVisible(true);
            ToolBar.setVisible(true);
            homeBar.setVisible(true);
            undoBar.setVisible(true);
            redoBar.setVisible(true);
            jPanel2.setVisible(false);
            showForm(new MainPanel());

            ToolBar.add(Box.createHorizontalGlue());
            ToolBar.add(myProfile);
            myProfile.setText(MySession.get_nama());
            if ("1".equals(MySession.get_Role())) {
                CandidateList.setVisible(true);
                jSeparator2.setVisible(true);
                employingConfirmation.setVisible(true);
                jSeparator3.setVisible(true);
                NotificationtoNewEmployee.setVisible(true);
                jSeparator4.setVisible(true);
                EmployeeStatus.setVisible(true);
                jSeparator5.setVisible(true);
                Checklist.setVisible(true);
                jSeparator6.setVisible(true);
                AllocationAnouncement.setVisible(true);
                jSeparator7.setVisible(true);
                requestedEmployeeAllocationList.setVisible(true);
                employeeLeaveofAbsenceList.setVisible(true);
                employeeRehabilitationList.setVisible(true);
                employeeResignationList.setVisible(true);
                clearanceEmployeeList.setVisible(true);
                employeeHandoverTakeover.setVisible(true);
                jSeparator13.setVisible(true);
                DiciplinaryRevolution.setVisible(true);
                jSeparator14.setVisible(true);
                EmployeeEvaluation.setVisible(true);
                jSeparator24.setVisible(true);
                AddJobVacancy.setVisible(true);
                jSeparator30.setVisible(true);

                jSeparator28.setVisible(true);
                jSeparator27.setVisible(true);
                jSeparator26.setVisible(true);
                jSeparator25.setVisible(true);
                jSeparator22.setVisible(true);
                jSeparator20.setVisible(true);
            }else if("2".equals(MySession.get_Role())){
                CandidateList.setVisible(true);
                jSeparator2.setVisible(true);
                employingConfirmation.setVisible(true);
                jSeparator3.setVisible(true);
                NotificationtoNewEmployee.setVisible(true);
                jSeparator4.setVisible(true);
                EmployeeStatus.setVisible(true);
                jSeparator5.setVisible(true);
                Checklist.setVisible(true);
                jSeparator6.setVisible(true);
                AllocationAnouncement.setVisible(true);
                jSeparator7.setVisible(true);
                requestedEmployeeAllocationList.setVisible(true);
                employeeLeaveofAbsenceList.setVisible(true);
                employeeRehabilitationList.setVisible(true);
                employeeResignationList.setVisible(true);
                clearanceEmployeeList.setVisible(true);
                employeeHandoverTakeover.setVisible(true);
                jSeparator13.setVisible(true);
                DiciplinaryRevolution.setVisible(true);
                jSeparator14.setVisible(true);
                EmployeeEvaluation.setVisible(true);
                jSeparator24.setVisible(true);
                AddJobVacancy.setVisible(true);
                jSeparator30.setVisible(true);

                jSeparator28.setVisible(true);
                jSeparator27.setVisible(true);
                jSeparator26.setVisible(true);
                jSeparator25.setVisible(true);
                jSeparator22.setVisible(true);
                jSeparator20.setVisible(true);
            }else if ("3".equals(MySession.get_Role())) {
                CandidateList.setVisible(false);
                jSeparator2.setVisible(false);
                employingConfirmation.setVisible(false);
                jSeparator3.setVisible(false);
                NotificationtoNewEmployee.setVisible(false);
                jSeparator4.setVisible(false);
                EmployeeStatus.setVisible(false);
                jSeparator5.setVisible(false);
                Checklist.setVisible(false);
                jSeparator6.setVisible(false);
                AllocationAnouncement.setVisible(false);
                jSeparator7.setVisible(false);
                requestedEmployeeAllocationList.setVisible(false);
                employeeLeaveofAbsenceList.setVisible(false);
                employeeRehabilitationList.setVisible(false);
                employeeResignationList.setVisible(false);
                clearanceEmployeeList.setVisible(false);
                employeeHandoverTakeover.setVisible(false);
                jSeparator13.setVisible(false);
                DiciplinaryRevolution.setVisible(false);
                jSeparator14.setVisible(false);
                EmployeeEvaluation.setVisible(false);
                jSeparator24.setVisible(false);
                AddJobVacancy.setVisible(false);
                jSeparator30.setVisible(false);

                jSeparator28.setVisible(false);
                jSeparator27.setVisible(false);
                jSeparator26.setVisible(false);
                jSeparator25.setVisible(false);
                jSeparator22.setVisible(false);
                jSeparator20.setVisible(false);
            }
        }
    }
}
