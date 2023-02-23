/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import CustomResource.koneksi;
import Main.MasterForm;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hi
 */
public class EmployeeEvaluation extends MasterForm {
    Connection koneksi;
    public EmployeeEvaluation() {
        initComponents();
        MyWindow();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        
        ((DefaultTableCellRenderer)jTable1.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);
        
        ((DefaultTableCellRenderer)jTable2.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        model2.addRow(new Object[]{"1. Coordination", getSubTableDataEvaluation(),""});
        model2.addRow(new Object[]{"2. Communication", getSubTableDataEvaluation(), ""});
        model2.addRow(new Object[]{"3. Reporting", getSubTableDataEvaluation(), ""});
        model2.addRow(new Object[]{"4. Leadership", getSubTableDataEvaluation(), ""});
        model2.addRow(new Object[]{"5. Knowledge", getSubTableDataEvaluation(), ""});
        model2.addRow(new Object[]{"6. Professional", getSubTableDataEvaluation(), ""});
        model2.addRow(new Object[]{"7. Planning Capability", getSubTableDataEvaluation(), ""});
        model2.addRow(new Object[]{"8. Schedule Keeping", getSubTableDataEvaluation(), ""});
        model2.addRow(new Object[]{"9. Performance", getSubTableDataEvaluation(), ""});
        model2.addRow(new Object[]{"10. Personality", getSubTableDataEvaluation(), ""});
        jTable2.autoRowHeight(jTable2);
        
        ((DefaultTableCellRenderer)jTable3.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);
    }
    private DefaultTableModel getSubTableDataEvaluation() {
        DefaultTableModel data = new DefaultTableModel();
        data.setColumnCount(5);
        data.addRow(new Object[]{new CustomResource.Header("S",50), new CustomResource.Header("A", 50), new CustomResource.Header("B", 50), new CustomResource.Header("C", 50), new CustomResource.Header("D", 50)});
        data.addRow(new Object[]{"S", "", "", "", ""});
//        data.addColumn(new Object[]{"a", "", "", "", ""});
//        data.addRow(new Object[]{1, "Vital", "$ 70", getSubTableData1()});
//        data.addRow(new Object[]{1, "Fanta", "$ 20", getSubTableData1()});
//        data.addRow(new Object[]{1, "Coca", getSubTableData1(), getSubTableData1()});
        return data;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        customTextfield1 = new CustomResource.CustomTextfield();
        customTextfield2 = new CustomResource.CustomTextfield();
        customTextfield3 = new CustomResource.CustomTextfield();
        customTextfield4 = new CustomResource.CustomTextfield();
        customTextfield5 = new CustomResource.CustomTextfield();
        customTextfield6 = new CustomResource.CustomTextfield();
        customTextfield7 = new CustomResource.CustomTextfield();
        customTextfield8 = new CustomResource.CustomTextfield();
        customTextfield9 = new CustomResource.CustomTextfield();
        customTextfield10 = new CustomResource.CustomTextfield();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new CustomResource.TableCustom();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Rev'd", "MGR"
            }
        ));
        jTable3.setRowHeight(70);
        jTable3.setShowHorizontalLines(true);
        jTable3.setShowVerticalLines(true);
        jScrollPane4.setViewportView(jTable3);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 215, 103));

        jTable1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "President"
            }
        ));
        jTable1.setRowHeight(70);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, 110, 103));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EMPLOYEE EVALUATION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 280, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("B. NAME OF EVALUATORS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("A. EMPLOYEE INFORMATION");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, -1, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("C. EVALUATION RESULTS BY EACH EVALUATOR");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 640, -1, -1));
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 1190, 230, 20));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 950, 660, 120));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel26.setText("Overall Result and Opinion and Explanation");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 930, -1, -1));

        customTextfield1.setLabelText("Senor Director");
        jPanel1.add(customTextfield1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 570, 280, -1));

        customTextfield2.setLabelText("Discipline");
        jPanel1.add(customTextfield2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 270, -1));

        customTextfield3.setLabelText("Nama / Name");
        jPanel1.add(customTextfield3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 270, -1));

        customTextfield4.setLabelText("Posisi /Position");
        jPanel1.add(customTextfield4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 280, -1));

        customTextfield5.setLabelText("Lokasi Kerja / Work Location");
        jPanel1.add(customTextfield5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 280, -1));

        customTextfield6.setLabelText("Team Subordinator");
        jPanel1.add(customTextfield6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 280, -1));

        customTextfield7.setLabelText("Team Superior");
        jPanel1.add(customTextfield7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, 280, -1));

        customTextfield8.setLabelText("Team Manager");
        jPanel1.add(customTextfield8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 570, 280, -1));

        customTextfield9.setLabelText("Discipline Manager");
        jPanel1.add(customTextfield9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 280, -1));

        customTextfield10.setLabelText("Director");
        jPanel1.add(customTextfield10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 520, 280, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Factor", "Evaluation", "Basis for Judgement"
            }
        ));
        jScrollPane6.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 660, 660, 260));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1164, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomResource.CustomTextfield customTextfield1;
    private CustomResource.CustomTextfield customTextfield10;
    private CustomResource.CustomTextfield customTextfield2;
    private CustomResource.CustomTextfield customTextfield3;
    private CustomResource.CustomTextfield customTextfield4;
    private CustomResource.CustomTextfield customTextfield5;
    private CustomResource.CustomTextfield customTextfield6;
    private CustomResource.CustomTextfield customTextfield7;
    private CustomResource.CustomTextfield customTextfield8;
    private CustomResource.CustomTextfield customTextfield9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private CustomResource.TableCustom jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void MyWindow(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height - 45);
        this.setPreferredSize(screen);
//        MainPanel.setPreferredSize(screen);
//        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = (screen.width/2) - (this.getSize().width/2);
//        int y = (screen.height/2) - (this.getSize().height/2);
//        this.setLocation(x,y);
    }

    @Override
    public void formrefresh() {
    }
    
}
