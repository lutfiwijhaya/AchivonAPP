/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package HumanResource;

import Main.MasterForm;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author hi
 */
public class AllocationAnnouncement extends MasterForm {

    /**
     * Creates new form AllocationAnnouncement
     */
    public AllocationAnnouncement() {
        initComponents();
        
        MyWindow();
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
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Dicipline", "Position", "Description Allocation", "Initial Join Date", "Alocation Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 804, 221));

        jButton2.setText("Back / Kembali");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 190, 40));

        jButton3.setText("Send / Kirim");
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, 190, 40));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Allocation Announcement");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 320, 40));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 280, 20));

        jLabel1.setText("Search");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, 20));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
