/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ProcurementSystem;

import HumanResource.*;
import CustomResource.CandidateSession;
import CustomResource.MySession;
import CustomResource.koneksi;
import static ProcurementSystem.choose_sq_list.AngkaKeHuruf.konversiKeHuruf;

import ProcurementSystem.po;
import ProcurementSystem.po_rfq;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author USER
 */
public class choose_sq_list extends javax.swing.JFrame {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    String role;

    /**
     * Creates new form Employe_list
     */
    public choose_sq_list() {
        initComponents();
        MyWindow1();
        openDB();
        table();
        tampil();
      
    }

    private void searchTable(String searchValue) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);

        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchValue);
        sorter.setRowFilter(rowFilter);
    }

    private void table() {
        DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();
        dataModel2.addRow(new Object[]{});
        //mendapatkan model kolom pada JTable
        TableColumnModel columnModel = jTable1.getColumnModel();
        //mendapatkan TableColumn pada indeks kolom yang ingin disembunyikan
        TableColumn column = columnModel.getColumn(0);
        TableColumn column1 = columnModel.getColumn(1);
        //menyembunyikan kolom dengan mengatur lebar kolom menjadi 0
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
        column1.setMinWidth(80);
        column1.setMaxWidth(80);
        column1.setWidth(80);
        column1.setPreferredWidth(80);
        //mengakses nilai pada kolom yang disembunyikan
        int rowIndex = 0; //indeks baris
        Object value = jTable1.getValueAt(rowIndex, 0);
        int rowCount = dataModel2.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            dataModel2.removeRow(i);
        }

    }

    private void tampil() {
        DefaultTableModel myModel = (DefaultTableModel) jTable1.getModel();
        myModel.addRow(new Object[]{});
        //mendapatkan model kolom pada JTable
        TableColumnModel columnModel = jTable1.getColumnModel();
        //mendapatkan TableColumn pada indeks kolom yang ingin disembunyikan
        TableColumn column = columnModel.getColumn(0);
        TableColumn column1 = columnModel.getColumn(1);
        //menyembunyikan kolom dengan mengatur lebar kolom menjadi 0
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
        column1.setMinWidth(80);
        column1.setMaxWidth(80);
        column1.setWidth(80);
        column1.setPreferredWidth(80);
        //mengakses nilai pada kolom yang disembunyikan
        int rowIndex = 0; //indeks baris
        Object value = jTable1.getValueAt(rowIndex, 0);
        int rowCount = myModel.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            myModel.removeRow(i);
        }
        try {
            stm = koneksi.createStatement();
            rs = stm.executeQuery("SELECT * FROM po_sq INNER JOIN po_rfq on po_sq.rfq_id = po_rfq.id INNER JOIN biz_partner on po_rfq.biz_id = biz_partner.biz_id where po_sq.status = '1'");
            while (rs.next()) {

                double total1 = Double.parseDouble(rs.getString("po_sq.total1"));
                double ppn = Double.parseDouble(rs.getString("po_sq.ppn"));
                double total2 = Double.parseDouble(rs.getString("po_sq.total2"));
                NumberFormat format = new DecimalFormat("#,###");
                String s_total1 = format.format(total1);
                String s_ppn = format.format(ppn);
                String s_total2 = format.format(total2);
                String[] data = {
                    rs.getString("po_sq.id"),
                    "SQ-" + rs.getString("po_sq.id"),
                    rs.getString("po_sq.date"),
                    rs.getString("biz_partner.name"),
                    rs.getString("po_sq.delivery_date"),
                    rs.getString("po_sq.payment"),
                    "Rp. " + s_total1,
                    "Rp. " + s_ppn,
                    "Rp. " + s_total2};
                myModel.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "data gagal tampil");
        }
    }

    private void MyWindow1() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width / 2) - (this.getSize().width / 2);
        int y = (screen.height / 2) - (this.getSize().height / 2);
        this.setLocation(x, y);
    }

    private void openDB() {
        try {
            koneksi kon = new koneksi();
            koneksi = kon.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf, Tidak terhubung database");
        }
    }

private void angkaKeHurufActionPerformed() {
    long angka = 234234;
    String hasilKonversi = AngkaKeHuruf.konversiKeHuruf(angka);
    // Tampilkan hasil konversi dalam JOptionPane
      JOptionPane.showMessageDialog(this, hasilKonversi, "Hasil Konversi", JOptionPane.INFORMATION_MESSAGE);
  
}

public class AngkaKeHuruf {
    private static final String[] angkaSatuan = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    };

    private static final String[] angkaBelasan = {
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] angkaPuluhan = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] angkaRatusan = {
        "", "One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred", "Six Hundred", "Seven Hundred", "Eight Hundred", "Nine Hundred"
    };

    private static final String[] angkaRibuan = {
        "", "One Thousand", "Two Thousand", "Three Thousand", "Four Thousand", "Five Thousand", "Six Thousand", "Seven Thousand", "Eight Thousand", "Nine Thousand"
    };
   
    

    public static String konversiKeHuruf(long angka) {
        // Perubahan tipe data pada parameter dan variabel lokal
        if (angka < 10) {
            return angkaSatuan[(int) angka];
        } else if (angka < 20) {
            return angkaBelasan[(int) (angka - 10)];
        } else if (angka < 100) {
            return angkaPuluhan[(int) (angka / 10)] + " " + angkaSatuan[(int) (angka % 10)];
        } else if (angka < 1000) {
            return angkaRatusan[(int) (angka / 100)] + " " + konversiKeHuruf(angka % 100);
        } else if (angka < 10000) {
            return angkaRibuan[(int) (angka / 1000)] + " " + konversiKeHuruf(angka % 1000);
        } else if (angka < 1000000) {
            return konversiKeHuruf(angka / 1000) + " Thousand" + " " + konversiKeHuruf(angka % 1000);
        } else if (angka < 1000000000) {
            return konversiKeHuruf(angka / 1000000) + " Million" + " " + konversiKeHuruf(angka % 1000000);
        } else if (angka < 1000000000000L ) {
            return konversiKeHuruf(angka / 1000000000L) + " Billion" + " " + konversiKeHuruf(angka % 1000000000L);
        }
        else {
            return "Number too large";
        }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        t_search = new CustomResource.CustomTextfield();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("SQ List");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 240, 40));

        jButton1.setText("Tambah/Add Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, -1));

        jButton2.setText("Batal/Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        t_search.setLabelText("Cari / Search");
        t_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_searchActionPerformed(evt);
            }
        });
        t_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_searchKeyTyped(evt);
            }
        });
        jPanel1.add(t_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 240, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "SQ ID", "Date SQ", "Supplier", "Deliv Estimate", "Payment Condition", "Amount (ex VAT 11%)", "VAT 11%", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 600, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please Mark SQ First !!!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            DefaultTableModel dataModel2 = (DefaultTableModel) jTable1.getModel();

            CustomResource.SessionAny.set_id_po(dataModel2.getValueAt(jTable1.getSelectedRow(), 0).toString());

            Main.main.getMain().showForm(new po_form_po());
            this.dispose();

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void t_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_searchKeyTyped

//      
    }//GEN-LAST:event_t_searchKeyTyped

    private void t_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_searchKeyReleased
        String searchValue = t_search.getText();
        searchTable(searchValue);


    }//GEN-LAST:event_t_searchKeyReleased

    private void t_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_searchActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(choose_sq_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(choose_sq_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(choose_sq_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(choose_sq_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new choose_sq_list().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private CustomResource.CustomTextfield t_search;
    // End of variables declaration//GEN-END:variables
}
