/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import Main.MasterForm;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author USER
 */
public class DisciplnaryResolution extends MasterForm {

    /**
     * Creates new form DisciplnaryResolution
     */
    public DisciplnaryResolution() {
        initComponents();
        MyWindow();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        
        ((DefaultTableCellRenderer)jTable1.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("DISCIPLINARY REVOLUTION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, -1));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, 122, 103));

        jTable2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Disciplinary Employee ", null, null, null},
                {"Resolution Result ", null, null, null},
                {"Reasons of Disciplinary ", null, null, null}
            },
            new String [] {
                "Disciplinary Employee ", "Name", "Discipline", "Position"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 670, 90));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("DD-MMM-YYYY");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 1010, 280, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PT. ACHIVON PRESTASI ABADI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, 260, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setText("Chairman");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 580, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setText("Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 810, 150, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel8.setText("Signature");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 580, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel9.setText("Commissioner");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 790, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel10.setText("Commissioner");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 600, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel11.setText("Commissioner");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 660, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel12.setText("Commissioner");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 720, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Name");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, 170, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel14.setText("Name");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 620, 160, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel15.setText("Name");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 680, 160, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel16.setText("Name");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 740, 150, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel17.setText("Signature");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 570, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("THE HUMAN RESOURCES COMMITTEE");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, 270, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
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
