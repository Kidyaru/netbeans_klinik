/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.koneksi;

/**
 *
 * @author rafli
 */
public class FormDokter extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormDokter.class.getName());
    private Connection Conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    // Asumsi method kosong() belum dideklarasikan tapi dipanggil di constructor
    protected void kosong(){
        tdr.setText("");
        tdr.setEnabled(true);
        tndr.setText("");
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        cSpl.setSelectedIndex(0);
        cPoli.setSelectedIndex(0);
    }
    
    public FormDokter() {
        initComponents();
        kosong();
        aktif();
        datatable();
        setResizable(false);
        setLocationRelativeTo(null);
        listpoliklinik();
        listspesialis();
//        this.setExtendedState(FormDokter.MAXIMIZED_BOTH);
    }
    
    protected void aktif(){
        tdr.setEnabled(true);
        tndr.setEnabled(true);
    }
    
    protected void listpoliklinik(){
        cPoli.removeAllItems();
        cPoli.addItem("Pilih Poliklinik");
        String sql = "SELECT * FROM poliklinik";
        try {
            java.sql.Statement stat = Conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String b = hasil.getString("nama_poliklinik");
                cPoli.addItem(b);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    protected void listspesialis(){
        cSpl.removeAllItems(); // Diperbaiki: Menggunakan JComboBox cSpl, bukan pnl (JPanel)
        cSpl.addItem("Pilih Spesialis");
        String sql = "SELECT * FROM spesialis";
        try {
            java.sql.Statement stat = Conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String b = hasil.getString("nama_spl");
                cSpl.addItem(b);
            }
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, "Data not found \n" + e);
        }
    }
    
    protected void datatable(){
        Object[] Baris = {"ID Dokter ","Nama Dokter","Spesialis","POLIKLINIK"};
        tabmode = new DefaultTableModel(null, Baris);
        tabeldokter.setModel(tabmode);
        
        String sql = "SELECT * FROM view_detail_dokter"; // Diperbaiki: ditambah '*'
        try {
            java.sql.Statement stat = Conn.createStatement(); // Diperbaiki: Steatment -> Statement
            ResultSet hasil = stat.executeQuery(sql); // Diperbaiki: Menggunakan stat
            while(hasil.next()){
                String a = hasil.getString("id_dokter");
                String b = hasil.getString("nama_dokter");
                String c = hasil.getString("nama_spl");
                String d = hasil.getString("nama_poliklinik");
                
                String[] data = {a, b, c, d};
                tabmode.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat tabel: " + e);
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl = new javax.swing.JPanel();
        tdr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tndr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cSpl = new javax.swing.JComboBox<>();
        cPoli = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lkdsp = new javax.swing.JLabel();
        lkdpoli = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tcari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeldokter = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Dokter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        pnl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel2.setText("Kode Dokter");

        jLabel3.setText("Nama Dokter");

        jLabel4.setText("Spesialis");

        cSpl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cSpl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cSplItemStateChanged(evt);
            }
        });
        cSpl.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cSplPropertyChange(evt);
            }
        });

        cPoli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cPoli.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cPoliItemStateChanged(evt);
            }
        });
        cPoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPoliActionPerformed(evt);
            }
        });

        jLabel5.setText("Poliklinik");

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(23, 23, 23)
                        .addComponent(btnUpdate)
                        .addGap(28, 28, 28)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose))
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tndr)
                            .addComponent(tdr, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cSpl, 0, 371, Short.MAX_VALUE)
                            .addComponent(cPoli, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lkdsp)
                            .addComponent(lkdpoli))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tdr, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tndr, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cSpl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lkdsp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cPoli, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lkdpoli))
                .addGap(18, 18, 18)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Dokter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel6.setText("Cari Dokter");

        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tabeldokter.setModel(new javax.swing.table.DefaultTableModel(
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
        tabeldokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeldokterMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeldokter);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(tcari, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCari)))
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("FORM DOKTER KLINIK SAWIT ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(298, 298, 298))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String sql = "INSERT INTO dokter VALUES (?,?,?,?) ";
        try{
            PreparedStatement stat = Conn.prepareStatement(sql);
            stat.setString(1, tdr.getText());
            stat.setString(2, tndr.getText());
            stat.setString(3, lkdsp.getText());
            stat.setString(4, lkdpoli.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Dokter Berhasil Disimpan");
            kosong();
            tdr.requestFocus();
            datatable();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data Dokter Gagal Disimpan " + e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int hapus = JOptionPane.showConfirmDialog(null, "Anda yakin akan Menghapus Data Poliklinik ini?", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if(hapus==0){
            String sql ="DELETE FROM poliklinik where id_poliklinik='"+tdr.getText()+"'";
            try {
                PreparedStatement stat = Conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Poliklinik Berhasil Dihapus");
                kosong();
                tdr.requestFocus();
                datatable();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Poliklinik Gagal Dihapus " +e);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
        String sql = "UPDATE dokter set nama_dokter=?, spesialis=?, poliklinik=? WHERE id_dokter=?";
        PreparedStatement stat = Conn.prepareStatement(sql);
        stat.setString(1, tndr.getText());
        stat.setString(2, lkdsp.getText());
        stat.setString(3, lkdpoli.getText());
        stat.setString(4, tdr.getText());

        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Dokter Berhasil Diperbarui");
        kosong();
        tdr.requestFocus();
        datatable();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Dokter Gagal Diperbarui");
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.kosong();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
    
    }//GEN-LAST:event_jPanel2MouseClicked

    private void tabeldokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeldokterMouseClicked
        int bar = tabeldokter.getSelectedRow();
        String a = tabmode.getValueAt(bar,0).toString();
        String b = tabmode.getValueAt(bar,1).toString();
        String c = tabmode.getValueAt(bar,2).toString();
        String d = tabmode.getValueAt(bar,3).toString();

        tdr.setText(a);
        tndr.setText(b);
        tdr.setEnabled(false);
        cSpl.setSelectedItem(c);
        cPoli.setSelectedItem(d);
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tabeldokterMouseClicked

    private void cPoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cPoliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cPoliActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
    Object[] Baris = {"ID DOKTER", "NAMA DOKTER", "SPESIALIS", "POLIKLINIK"};
    tabmode = new DefaultTableModel(null, Baris);
    tabeldokter.setModel(tabmode);
    
    String sql = "SELECT * FROM view_detail_dokter WHERE id_dokter LIKE '%" + tcari.getText() + "%' OR nama_dokter LIKE '%" + tcari.getText() + "%'";
    
    try {
        java.sql.Statement stat = Conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String a = hasil.getString("id_dokter");
            String b = hasil.getString("nama_dokter");
            String c = hasil.getString("nama_spl");        
            String d = hasil.getString("nama_poliklinik");  
            
            String[] data = {a, b, c, d};
            tabmode.addRow(data);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Pencarian Gagal: " + e);
    }  
    }//GEN-LAST:event_btnCariActionPerformed

    private void cSplPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cSplPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cSplPropertyChange

    private void cSplItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cSplItemStateChanged
                                               // TODO add your handling code here:
       if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
        
        if (cSpl.getSelectedItem().toString().equals("Pilih Spesialis")) {
            lkdsp.setText("");
            return;
        }

        String sql = "SELECT * FROM spesialis WHERE nama_spl = '" + cSpl.getSelectedItem() + "'";
        try {
            java.sql.Statement stat = Conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
                lkdsp.setText(hasil.getString("id_spl"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan \n" + ex);
        }
    }
    }//GEN-LAST:event_cSplItemStateChanged

    private void cPoliItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cPoliItemStateChanged
    if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
        
       
        if (cPoli.getSelectedItem().toString().equals("Pilih Poliklinik")) {
            lkdpoli.setText("");
            return;
        }

        String sql = "SELECT * FROM poliklinik WHERE nama_poliklinik = '" + cPoli.getSelectedItem() + "'";
        try {
            java.sql.Statement stat = Conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
                lkdpoli.setText(hasil.getString("id_poliklinik"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan \n" + ex);
        }
    }    // TODO add your handling code here:
    }//GEN-LAST:event_cPoliItemStateChanged

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
            java.util.logging.Logger.getLogger(FormDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDokter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cPoli;
    private javax.swing.JComboBox<String> cSpl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lkdpoli;
    private javax.swing.JLabel lkdsp;
    private javax.swing.JPanel pnl;
    private javax.swing.JTable tabeldokter;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tdr;
    private javax.swing.JTextField tndr;
    // End of variables declaration//GEN-END:variables
}
