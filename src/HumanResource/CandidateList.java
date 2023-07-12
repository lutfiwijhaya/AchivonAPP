
package HumanResource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import CustomResource.actiontable;
import CustomResource.callrender;
import CustomResource.celleditor;
import CustomResource.CandidateSession;
import CustomResource.MySession;
import CustomResource.koneksi;
import Main.MasterForm;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import scroolbarWin11.ScrollBarWin11UI;

/**
 *
 * @author hi
 */
public class CandidateList extends MasterForm {

    Statement stm;
    ResultSet rs;
    Connection koneksi;
    JasperReport jasperreport;
    JasperDesign jasperdesign;
    JasperPrint jasperprint;
    Map<String, Object> param = new HashMap<String, Object>();
    DefaultTableModel myModel;
    String id = null;

    public CandidateList() {
        
        initComponents();
        
        openDB();
        settable();
        id();
        myShow();
        MyWindow();
        remove();

//        CandidateSession.setCandidateID("");
        ((DefaultTableCellRenderer) MyTable.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }
    
    void id(){
        if(c_app.getSelectedItem().toString().equals("Belum Approve/Not Approved")){
            
             myModel.addRow(new Object[]{});
           //mendapatkan model kolom pada JTable
        TableColumnModel columnModel = MyTable.getColumnModel();
//mendapatkan TableColumn pada indeks kolom yang ingin disembunyikan
        TableColumn column = columnModel.getColumn(0);
//menyembunyikan kolom dengan mengatur lebar kolom menjadi 0
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
//mengakses nilai pada kolom yang disembunyikan
        int rowIndex = 0; //indeks baris
        Object value = MyTable.getValueAt(rowIndex, 0); 
        
         //mendapatkan model kolom pada JTable
        TableColumnModel columnModel1 = MyTable.getColumnModel();
//mendapatkan TableColumn pada indeks kolom yang ingin disembunyikan
        TableColumn column1 = columnModel1.getColumn(10);
        TableColumn column2 = columnModel1.getColumn(9);
//menyembunyikan kolom dengan mengatur lebar kolom menjadi 0
        column1.setMinWidth(column2.getMinWidth());
        column1.setMaxWidth(column2.getMaxWidth());
        column1.setWidth(column2.getWidth());
        column1.setPreferredWidth(245);
//mengakses nilai pada kolom yang disembunyikan
        int rowIndex1 = 0; //indeks baris
        Object value1 = MyTable.getValueAt(rowIndex1, 0); 
        
        } else if(c_app.getSelectedItem().toString().equals("Sudah Approve/Approved")){
            myModel.addRow(new Object[]{});
             
           //mendapatkan model kolom pada JTable
        TableColumnModel columnModel = MyTable.getColumnModel();
//mendapatkan TableColumn pada indeks kolom yang ingin disembunyikan
        TableColumn column = columnModel.getColumn(10);
//menyembunyikan kolom dengan mengatur lebar kolom menjadi 0
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
//mengakses nilai pada kolom yang disembunyikan
        int rowIndex = 0; //indeks baris
        Object value = MyTable.getValueAt(rowIndex, 0); 
        
        }
     
    
    }

    void settable() {
        String[] header = {"id", "KTP", "Nama / Name", "Tempat, Tanggal Lahir / Place, Birthday", "Jenis Kelamin / Gender", "Status Pernikahan / Marital Status", "Email", "No. Hp", "Posisi yang dilamar / Job Applying", "gaji / Sallary", "Action"};
        myModel = new DefaultTableModel(header, 1);
        MyTable.setModel(myModel);
        actiontable event = new actiontable() {
            @Override
            public void lihat(int row) {
                try {
                    CandidateSession.setCandidateID(myModel.getValueAt(MyTable.getSelectedRow(), 0).toString());
                    Main.main.getMain().showForm(new CandidateProfile());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                Main.main.getMain().showForm(new CandidateProfile());
                try {
                    Statement stmt = koneksi.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from cd_foto where id_employee ='" + CandidateSession.getCandidateID() + "'"); // assuming the image is stored in the 'images' table with an ID of 1

                    if (rs.next()) {
                        byte[] imageData = rs.getBytes("foto");
                        ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                        BufferedImage bImage = ImageIO.read(bis);
                        ImageIcon Myicon = new ImageIcon(bImage);
                        Image imageResize = Myicon.getImage().getScaledInstance(130, 140, Image.SCALE_SMOOTH);
                        CandidateProfile.labelfoto.setIcon(new ImageIcon(imageResize));
                    }
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void tambah(int row) {
                try {
                    CandidateSession.setCandidateID(myModel.getValueAt(MyTable.getSelectedRow(), 0).toString());
                    koneksi.createStatement().executeUpdate("UPDATE cd_employee SET `approval` = '1' WHERE id_employee = '" + CandidateSession.getCandidateID() + "'");
//            while (myRess.next()) {
//                JOptionPane.showMessageDialog(null, "Lamaran Berhasil diteruskan");
//            }
                    myShow();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
//                JOptionPane.showMessageDialog(null, "Lamaran gagal Diteruskan");

                }
            }

            @Override
            public void hapus(int row) {
                int respon = JOptionPane.showConfirmDialog(null, "Are You Sure Want To Reject ?", "Option", JOptionPane.YES_NO_OPTION);
                if (respon == 0) {
                    try {
                        CandidateSession.setCandidateID(myModel.getValueAt(MyTable.getSelectedRow(), 0).toString());
                        koneksi.createStatement().executeUpdate("UPDATE cd_employee SET `approval` = '10' WHERE id_employee = '" + CandidateSession.getCandidateID() + "'");
    //            while (myRess.next()) {
    //                JOptionPane.showMessageDialog(null, "Lamaran Berhasil diteruskan");
    //            }
                        myShow();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
    //                JOptionPane.showMessageDialog(null, "Lamaran gagal Diteruskan");
                    }

            } 
              
            }
        };
        MyTable.getColumnModel().getColumn(10).setCellRenderer(new callrender());
        MyTable.setDefaultEditor(Object.class, null);
        MyTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        MyTable.getColumnModel().getColumn(1).setPreferredWidth(130);
        MyTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        MyTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        MyTable.getColumnModel().getColumn(4).setPreferredWidth(70);
        MyTable.getColumnModel().getColumn(5).setPreferredWidth(60);
        MyTable.getColumnModel().getColumn(6).setPreferredWidth(170);
        MyTable.getColumnModel().getColumn(7).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(8).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(9).setPreferredWidth(100);
        MyTable.getColumnModel().getColumn(10).setPreferredWidth(245);
//        
//        MyTable.getColumnModel().removeColumn(MyTable.getColumnModel().getColumn(10));
//        
        MyTable.getColumnModel().getColumn(10).setCellEditor(new celleditor(event));
    }

    void remove() {

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

        jScrollPane2 = new scroolbarWin11.ScrollPaneWin11();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new scroolbarWin11.ScrollPaneWin11();
        MyTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        textSearch = new CustomResource.CustomTextfield();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        c_app = new CustomResource.ComboBoxSuggestion();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 585));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        MyTable.setAutoResizeMode(0);
        MyTable.setRowHeight(40);
        MyTable.setShowHorizontalLines(true);
        MyTable.setShowVerticalLines(true);
        MyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MyTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MyTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(MyTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 1170, 380));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Daftar kandidat / Candidate List");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 40));

        jSeparator1.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 1030, 20));

        textSearch.setLabelText("Cari / Search");
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });
        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSearchKeyTyped(evt);
            }
        });
        jPanel1.add(textSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 460, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Accept");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(51, 51, 255));
        jButton2.setText("Reject");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Reject or Accept marked");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 500, 280, 90));

        c_app.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Belum Approve/Not Approved", "Sudah Approve/Approved" }));
        c_app.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        c_app.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_appActionPerformed(evt);
            }
        });
        jPanel1.add(c_app, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 80, 190, 30));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyTableMouseClicked
//        try{
//            CandidateSession.setCandidateID(myModel.getValueAt(MyTable.getSelectedRow(), 0).toString());
//            Main.main.getMain().showForm(new CandidateProfile());    
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//        Main.main.getMain().showForm(new CandidateProfile());
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/achivonapp", "root", "");
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from cd_foto where id_employee ='"+CandidateSession.getCandidateID()+"'"); // assuming the image is stored in the 'images' table with an ID of 1
//
//            if (rs.next()) {
//                byte[] imageData = rs.getBytes("foto");
//                ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
//                BufferedImage bImage = ImageIO.read(bis);
//                ImageIcon Myicon = new ImageIcon(bImage);
//                Image imageResize = Myicon.getImage().getScaledInstance(130, 140, Image.SCALE_SMOOTH);
//                CandidateProfile.labelfoto.setIcon(new ImageIcon(imageResize));
//            }
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_MyTableMouseClicked

    private void textSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyTyped
        myShow();
    }//GEN-LAST:event_textSearchKeyTyped

    private void MyTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MyTableMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 int respon = JOptionPane.showConfirmDialog(null, "Are You Sure Want To Reject ?", "Option", JOptionPane.YES_NO_OPTION);
        if (respon == 0) {
            int[] selectedRows = MyTable.getSelectedRows();
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            try {
                koneksi.createStatement().executeUpdate("UPDATE cd_employee SET `approval` = '10' WHERE id_employee = '" + myModel.getValueAt(selectedRows[i], 0) + "'");
            } catch (SQLException ex) {
                Logger.getLogger(CandidateList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        myShow();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int[] selectedRows = MyTable.getSelectedRows();
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            try {
                koneksi.createStatement().executeUpdate("UPDATE cd_employee SET `approval` = '1' WHERE id_employee = '" + myModel.getValueAt(selectedRows[i], 0) + "'");
            } catch (SQLException ex) {
                Logger.getLogger(CandidateList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        myShow();     // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchActionPerformed

    private void c_appActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_appActionPerformed
myShow();        // TODO add your handling code here:
    }//GEN-LAST:event_c_appActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MyTable;
    private CustomResource.ComboBoxSuggestion c_app;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private CustomResource.CustomTextfield textSearch;
    // End of variables declaration//GEN-END:variables

    private void myShow() {
        id();
        
        String mySearch = textSearch.getText();
        int row = MyTable.getRowCount();
        for (int i = 0; i < row; i++) {
          myModel.removeRow(0);  
        }
        if(c_app.getSelectedItem().toString().equals("Belum Approve/Not Approved")){
        
        jPanel2.setVisible(true);
        if (mySearch != null) {
            try {
                ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM cd_employee WHERE approval = '0' AND Nama LIKE '%" + mySearch + "%'");
                while (myRess.next()) {
                    String myData[] = {myRess.getString(1), myRess.getString(3), myRess.getString(2), myRess.getString(7) + "," + myRess.getString(8),
                        myRess.getString(6), myRess.getString(9), myRess.getString(4),
                        myRess.getString(10), myRess.getString(12), myRess.getString(13)};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        } else {
            try {
                ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM cd_employee WHERE approval = '0'");
//                ResultSetMetaData rsmd = (ResultSetMetaData) myRess.getMetaData();
//                int numColumns = rsmd.getColumnCount();
//                for (int i = 1; i <= numColumns; i++) {
//                    myModel.addColumn(rsmd.getColumnName(i));
//                }

                while (myRess.next()) {
//                    Object[] mrow = new Object[numColumns];
//                    for (int i = 1; i <= numColumns; i++) {
//                        mrow[i - 1] = myRess.getObject(i);
//                    }
                    String myData[] = {myRess.getString(1), myRess.getString(3), myRess.getString(2), myRess.getString(7) + "," + myRess.getString(8),
                        myRess.getString(6), myRess.getString(9), myRess.getString(4),
                        myRess.getString(10), myRess.getString(12), myRess.getString(13)};
                    myModel.addRow(myData);
                }

            } catch (SQLException ex) {
            }
        }}else if ((c_app.getSelectedItem().toString().equals("Sudah Approve/Approved"))){
          
        jPanel2.setVisible(false);
            if (mySearch != null) {
            try {
                ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM cd_employee WHERE approval = '1' AND Nama LIKE '%" + mySearch + "%'");
                while (myRess.next()) {
                    String myData[] = {myRess.getString(1), myRess.getString(3), myRess.getString(2), myRess.getString(7) + "," + myRess.getString(8),
                        myRess.getString(6), myRess.getString(9), myRess.getString(4),
                        myRess.getString(10), myRess.getString(12), myRess.getString(13)};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        } else {
            try {
                ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM cd_employee WHERE approval = '1'");
//                ResultSetMetaData rsmd = (ResultSetMetaData) myRess.getMetaData();
//                int numColumns = rsmd.getColumnCount();
//                for (int i = 1; i <= numColumns; i++) {
//                    myModel.addColumn(rsmd.getColumnName(i));
//                }

                while (myRess.next()) {
//                    Object[] mrow = new Object[numColumns];
//                    for (int i = 1; i <= numColumns; i++) {
//                        mrow[i - 1] = myRess.getObject(i);
//                    }
                    String myData[] = {myRess.getString(1), myRess.getString(3), myRess.getString(2), myRess.getString(7) + "," + myRess.getString(8),
                        myRess.getString(6), myRess.getString(9), myRess.getString(4),
                        myRess.getString(10), myRess.getString(12), myRess.getString(13)};
                    myModel.addRow(myData);
                }

            } catch (SQLException ex) {
            }
        }
        
        }else if ((c_app.getSelectedItem().toString().equals("Sudah Approve/Approved"))){
           
        jPanel2.setVisible(false);
            if (mySearch != null) {
            try {
                ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM cd_employee WHERE approval = '2' AND Nama LIKE '%" + mySearch + "%'");
                while (myRess.next()) {
                    String myData[] = {myRess.getString(1), myRess.getString(3), myRess.getString(2), myRess.getString(7) + "," + myRess.getString(8),
                        myRess.getString(6), myRess.getString(9), myRess.getString(4),
                        myRess.getString(10), myRess.getString(12), myRess.getString(13)};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        } else {
            try {
                ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM cd_employee WHERE approval = '2'");
//                ResultSetMetaData rsmd = (ResultSetMetaData) myRess.getMetaData();
//                int numColumns = rsmd.getColumnCount();
//                for (int i = 1; i <= numColumns; i++) {
//                    myModel.addColumn(rsmd.getColumnName(i));
//                }

                while (myRess.next()) {
//                    Object[] mrow = new Object[numColumns];
//                    for (int i = 1; i <= numColumns; i++) {
//                        mrow[i - 1] = myRess.getObject(i);
//                    }
                    String myData[] = {myRess.getString(1), myRess.getString(3), myRess.getString(2), myRess.getString(7) + "," + myRess.getString(8),
                        myRess.getString(6), myRess.getString(9), myRess.getString(4),
                        myRess.getString(10), myRess.getString(12), myRess.getString(13)};
                    myModel.addRow(myData);
                }

            } catch (SQLException ex) {
            }
        }
        
        }else if ((c_app.getSelectedItem().toString().equals("Sudah Approve/Approved"))){
        
        jPanel2.setVisible(false);
            if (mySearch != null) {
            try {
                ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM cd_employee WHERE approval = '3' AND Nama LIKE '%" + mySearch + "%'");
                while (myRess.next()) {
                    String myData[] = {myRess.getString(1), myRess.getString(3), myRess.getString(2), myRess.getString(7) + "," + myRess.getString(8),
                        myRess.getString(6), myRess.getString(9), myRess.getString(4),
                        myRess.getString(10), myRess.getString(12), myRess.getString(13)};

                    myModel.addRow(myData);
                }
            } catch (SQLException ex) {
            }
        } else {
            try {
                ResultSet myRess = koneksi.createStatement().executeQuery("SELECT * FROM cd_employee WHERE approval = '3'");
//                ResultSetMetaData rsmd = (ResultSetMetaData) myRess.getMetaData();
//                int numColumns = rsmd.getColumnCount();
//                for (int i = 1; i <= numColumns; i++) {
//                    myModel.addColumn(rsmd.getColumnName(i));
//                }

                while (myRess.next()) {
//                    Object[] mrow = new Object[numColumns];
//                    for (int i = 1; i <= numColumns; i++) {
//                        mrow[i - 1] = myRess.getObject(i);
//                    }
                    String myData[] = {myRess.getString(1), myRess.getString(3), myRess.getString(2), myRess.getString(7) + "," + myRess.getString(8),
                        myRess.getString(6), myRess.getString(9), myRess.getString(4),
                        myRess.getString(10), myRess.getString(12), myRess.getString(13)};
                    myModel.addRow(myData);
                }

            } catch (SQLException ex) {
            }
        }
        
        }
    }

    private void MyWindow() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width, screen.height);
        this.setPreferredSize(new Dimension(screen.width, screen.height));
    }

    @Override
    public void formrefresh() {
    }
}
