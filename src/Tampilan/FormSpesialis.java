/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan;
import Koneksi.koneksi;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author rafli
 */
public class FormSpesialis extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormSpesialis.class.getName());
    private Connection Conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    // Asumsi method kosong() belum dideklarasikan tapi dipanggil di constructor
    
    public FormSpesialis() {
        this.initComponents();
        this.dataTable();
        this.setResizable(false);
        this.setLocationRelativeTo((Component)null);
        this.aktif();
  //        this.setExtendedState(FormPasien.MAXIMIZED_BOTH);
    }
    
    protected void aktif() {
      this.tIdSpesialis.setEnabled(true);
      this.tNamaSpesialis.setEnabled(true);
      this.tIdSpesialis.requestFocus();
   }
    
    protected void kosong() {
      this.tIdSpesialis.setText("");
      this.tNamaSpesialis.setText("");
      this.tCari.setText("");
   }
    
    protected void dataTable() {
      Object[] Baris = new Object[]{"No. Spesialis", "NAMA SPESIALIS"};
      this.tabmode = new DefaultTableModel((Object[][])null, Baris);
      this.tTabel.setModel(this.tabmode);
      String sql = "SELECT * FROM Spesialis";

      try {
         Statement stat = this.Conn.createStatement();
         ResultSet hasil = stat.executeQuery(sql);

         while(hasil.next()) {
            String a = hasil.getString("id_spl");
            String b = hasil.getString("nama_spl");
            String[] data = new String[]{a, b};
            this.tabmode.addRow(data);
         }
      } catch (Exception var11) {
      }

   }
    
   
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group1 = new javax.swing.ButtonGroup();
        backgroundPnl = new javax.swing.JPanel();
        pnl = new javax.swing.JPanel();
        tIdSpesialis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tNamaSpesialis = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lkdsp = new javax.swing.JLabel();
        lkdpoli = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tCari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Spesialis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        pnl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        tIdSpesialis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdSpesialisActionPerformed(evt);
            }
        });

        jLabel2.setText("ID Spesialis");

        jLabel3.setText("Nama Spesialis");

        btnSave.setBackground(new java.awt.Color(218, 218, 255));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(218, 218, 255));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(218, 218, 255));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(218, 218, 255));
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(218, 218, 255));
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
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(58, 58, 58)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tNamaSpesialis)
                    .addComponent(tIdSpesialis, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lkdpoli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lkdsp)
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear)
                .addGap(22, 22, 22)
                .addComponent(btnClose)
                .addGap(50, 50, 50))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lkdsp)
                        .addGap(35, 35, 35)
                        .addComponent(lkdpoli))
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tIdSpesialis, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNamaSpesialis, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(54, 54, 54)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Pasien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel6.setText("Cari Spesialis");

        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tTabel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(tCari)
                        .addGap(18, 18, 18)
                        .addComponent(btnCari)))
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("FORM SPESIALIS KLINIK SAWIT");

        javax.swing.GroupLayout backgroundPnlLayout = new javax.swing.GroupLayout(backgroundPnl);
        backgroundPnl.setLayout(backgroundPnlLayout);
        backgroundPnlLayout.setHorizontalGroup(
            backgroundPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPnlLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(backgroundPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundPnlLayout.createSequentialGroup()
                    .addGap(393, 393, 393)
                    .addComponent(jLabel1)
                    .addContainerGap(340, Short.MAX_VALUE)))
        );
        backgroundPnlLayout.setVerticalGroup(
            backgroundPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPnlLayout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(backgroundPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(backgroundPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundPnlLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(537, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

    }//GEN-LAST:event_jPanel2MouseClicked

    private void tTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tTabelMouseClicked
        int bar = this.tTabel.getSelectedRow();
        String id = this.tabmode.getValueAt(bar, 0).toString();
        String nama = this.tabmode.getValueAt(bar, 1).toString();
        this.tIdSpesialis.setText(id);
        this.tNamaSpesialis.setText(nama);
    }//GEN-LAST:event_tTabelMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        Object[] Baris = new Object[]{"No. Spesialis", "NAMA SPESIALIS"};
        this.tabmode = new DefaultTableModel((Object[][])null, Baris);
        this.tTabel.setModel(this.tabmode);
        String sql = "SELECT * FROM spesialis WHERE id_spl LIKE '%" + this.tCari.getText() + "%' OR nama_spl LIKE '%" + this.tCari.getText() + "%'";

        try {
            Statement stat = this.Conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);

            while(hasil.next()) {
                String a = hasil.getString("id_spl");
                String b = hasil.getString("nama_spl");
                String[] data = new String[]{a, b};
                this.tabmode.addRow(data);
            }

            if (this.tabmode.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan");
                this.dataTable();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Pencarian Gagal: " + e);
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.kosong();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int ok = JOptionPane.showConfirmDialog(this, "Hapus data ini?", "Konfirmasi Hapus", 0);
        if (ok == 0) {
            String sql = "DELETE FROM spesialis WHERE id_spl ='" + this.tIdSpesialis.getText() + "'";

            try {
                PreparedStatement stat = this.Conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog((Component)null, "Data Berhasil Dihapus");
                this.kosong();
                this.dataTable();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog((Component)null, "Data Gagal Dihapus: " + e);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String sql = "UPDATE spesialis SET nama_spl=? WHERE id_spl=?";
        try {
            PreparedStatement stat = this.Conn.prepareStatement(sql);
            stat.setString(1, this.tNamaSpesialis.getText());
            stat.setString(2, this.tIdSpesialis.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            this.kosong();
            this.dataTable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data Gagal Diubah: " + e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String sql = "INSERT INTO spesialis (id_spl, nama_spl) VALUES (?,?)";
        try {
            PreparedStatement stat = this.Conn.prepareStatement(sql);
            stat.setString(1, this.tIdSpesialis.getText());
            stat.setString(2, this.tNamaSpesialis.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
            this.kosong();
            this.dataTable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data Gagal Disimpan: " + e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tIdSpesialisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdSpesialisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIdSpesialisActionPerformed

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
            java.util.logging.Logger.getLogger(FormSpesialis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSpesialis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSpesialis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSpesialis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSpesialis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPnl;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup group1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lkdpoli;
    private javax.swing.JLabel lkdsp;
    private javax.swing.JPanel pnl;
    private javax.swing.JTextField tCari;
    private javax.swing.JTextField tIdSpesialis;
    private javax.swing.JTextField tNamaSpesialis;
    private javax.swing.JTable tTabel;
    // End of variables declaration//GEN-END:variables
}
