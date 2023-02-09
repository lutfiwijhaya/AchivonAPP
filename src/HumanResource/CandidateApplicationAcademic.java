/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import Employee.ChangePassword;
import Employee.EmployeeProfilePanel;
import Main.MasterForm;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author hi
 */
public class CandidateApplicationAcademic extends MasterForm {

    public CandidateApplicationAcademic() {
        initComponents();
        MyWindow();
        ((DefaultTableCellRenderer)jTable2.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customTextfield2 = new CustomResource.CustomTextfield();
        customTextfield4 = new CustomResource.CustomTextfield();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel71 = new javax.swing.JLabel();
        comboBoxSuggestion1 = new CustomResource.ComboBoxSuggestion();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        t_tgl = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customTextfield2.setLabelText("Nama Sekolah / School Name");
        add(customTextfield2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 280, -1));

        customTextfield4.setLabelText("Jurusan / Major");
        add(customTextfield4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 310, -1));

        jTable2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tanggal Lulus / Graduation Date", "Nama Sekolah / School Name", "Lokasi / Location", "Jurusan / Major"
            }
        ));
        jTable2.setCellSelectionEnabled(true);
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2.setShowHorizontalLines(true);
        jTable2.setShowVerticalLines(true);
        jTable2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable2InputMethodTextChanged(evt);
            }
        });
        jScrollPane20.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 840, 90));

        jSeparator25.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator25.setForeground(new java.awt.Color(255, 0, 0));
        add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 650, 20));

        jLabel71.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel71.setText("2. Riwayat Pendidikan / Academic");
        add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 30));

        comboBoxSuggestion1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        add(comboBoxSuggestion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, 210, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton1.setText("Hapus / Delete");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 110, 30));

        jButton2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton2.setText("Kembali / Back");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 110, 30));

        jButton3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton3.setText("Ubah / Edit");
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 110, 30));

        jButton4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton4.setText("Simpan / Save");
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 240, 110, 30));

        jButton5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton5.setText("Lanjut / Next");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 400, 110, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("Lokasi / Location");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, -1, 30));

        t_tgl.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        add(t_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 230, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Tanggal Kelulusan / Graduation Date");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 190, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable2InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2InputMethodTextChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Main.main.getMain().showForm(new CandidateApplicationFamily());
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.ComboBoxSuggestion comboBoxSuggestion1;
    private CustomResource.CustomTextfield customTextfield2;
    private CustomResource.CustomTextfield customTextfield4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JTable jTable2;
    private com.toedter.calendar.JDateChooser t_tgl;
    // End of variables declaration//GEN-END:variables
    private void MyWindow() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height - 45);
        this.setPreferredSize(new Dimension(screen.width, screen.height - 100));

//        int x = (screen.width/2) - (this.getSize().width/2);
//        int y = (screen.height/2) - (this.getSize().height/2);
//        this.setPreferredSize(x,y);
    }

    @Override
    public void formrefresh() {
    
    }
}
