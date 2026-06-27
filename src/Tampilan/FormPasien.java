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
public class FormPasien extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormPasien.class.getName());
    private Connection Conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    // Asumsi method kosong() belum dideklarasikan tapi dipanggil di constructor
    
    public FormPasien() {
        this.initComponents();
        this.dataTable();
        this.setResizable(false);
        this.setLocationRelativeTo((Component)null);
        this.group1.add(this.rjk1);
        this.group1.add(this.rjk2);
  //        this.setExtendedState(FormPasien.MAXIMIZED_BOTH);
    }
    
    protected void aktif() {
      this.tIdPasien.setEnabled(true);
      this.tNamaPasien.setEnabled(true);
      this.tAlm.setEnabled(true);
      this.tIdPasien.requestFocus();
   }
    
    protected void kosong() {
      this.tIdPasien.setText("");
      this.tNamaPasien.setText("");
      this.tAlm.setText("");
      this.rjk1.setSelected(true);
      this.tCari.setText("");
      this.cgd.setSelectedIndex(0);
   }
    
    protected void dataTable() {
      Object[] Baris = new Object[]{"No. Identitas", "NAMA PASIEN", "JENIS KELAMIN", "ALAMAT & KONTAK", "GOLONGAN DARAH"};
      this.tabmode = new DefaultTableModel((Object[][])null, Baris);
      this.tTabel.setModel(this.tabmode);
      String sql = "SELECT * FROM pasien";

      try {
         Statement stat = this.Conn.createStatement();
         ResultSet hasil = stat.executeQuery(sql);

         while(hasil.next()) {
            String a = hasil.getString("id");
            String b = hasil.getString("nama");
            String c = hasil.getString("jk");
            String d = hasil.getString("alamat");
            String e = hasil.getString("goldar");
            String[] data = new String[]{a, b, c, d, e};
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
        tIdPasien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tNamaPasien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lkdsp = new javax.swing.JLabel();
        lkdpoli = new javax.swing.JLabel();
        rjk1 = new javax.swing.JRadioButton();
        rjk2 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tAlm = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        cgd = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        tCari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Pasien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        pnl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        pnl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMouseClicked(evt);
            }
        });

        tIdPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdPasienActionPerformed(evt);
            }
        });

        jLabel2.setText("ID Pasien");

        jLabel3.setText("Nama Pasien");

        jLabel4.setText("Jenis Kelamin");

        jLabel5.setText("Alamat");

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

        group1.add(rjk1);
        rjk1.setText("Laki - Laki");

        group1.add(rjk2);
        rjk2.setText("Perempuan");

        tAlm.setColumns(20);
        tAlm.setRows(5);
        jScrollPane2.setViewportView(tAlm);

        jLabel7.setText("Golongan Darah");

        cgd.setBackground(new java.awt.Color(218, 218, 255));
        cgd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ">> GOLONGAN DARAH <<", "A", "B", "AB", "O" }));

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(34, 34, 34)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLayout.createSequentialGroup()
                                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tNamaPasien)
                                        .addComponent(tIdPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlLayout.createSequentialGroup()
                                        .addComponent(rjk1)
                                        .addGap(18, 18, 18)
                                        .addComponent(rjk2))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lkdpoli)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lkdsp))
                            .addComponent(cgd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(95, Short.MAX_VALUE))
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
                .addGap(42, 42, 42))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lkdsp)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(lkdpoli))
                            .addGroup(pnlLayout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jLabel5))))
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tIdPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(16, 16, 16)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rjk1)
                            .addComponent(rjk2)
                            .addComponent(jLabel4))
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cgd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Pasien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel6.setText("Cari Pasien");

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
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(tCari, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("FORM PASIEN KLINIK SAWIT ");

        javax.swing.GroupLayout backgroundPnlLayout = new javax.swing.GroupLayout(backgroundPnl);
        backgroundPnl.setLayout(backgroundPnlLayout);
        backgroundPnlLayout.setHorizontalGroup(
            backgroundPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPnlLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(backgroundPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundPnlLayout.createSequentialGroup()
                    .addGap(393, 393, 393)
                    .addComponent(jLabel1)
                    .addContainerGap(374, Short.MAX_VALUE)))
        );
        backgroundPnlLayout.setVerticalGroup(
            backgroundPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPnlLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(backgroundPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
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
            .addComponent(backgroundPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String sql = "INSERT INTO pasien (id, nama, jk, alamat, goldar) VALUES (?,?,?,?,?)";
        try {
           if (this.tIdPasien.getText().trim().isEmpty() || 
               this.tNamaPasien.getText().trim().isEmpty() || 
               this.tAlm.getText().trim().isEmpty() || 
               this.cgd.getSelectedIndex() == 0 || 
               (!this.rjk1.isSelected() && !this.rjk2.isSelected())) {

              JOptionPane.showMessageDialog(this, "Semua data harus diisi terlebih dahulu!");
              return;
           }

           PreparedStatement stat = this.Conn.prepareStatement(sql);
           stat.setString(1, this.tIdPasien.getText());
           stat.setString(2, this.tNamaPasien.getText());
           String jk = this.rjk1.isSelected() ? "Laki-Laki" : "Perempuan";
           stat.setString(3, jk);
           stat.setString(4, this.tAlm.getText());
           stat.setString(5, this.cgd.getSelectedItem().toString());
           stat.executeUpdate();
           JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
           this.kosong();
           this.dataTable();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(this, "Data Gagal Disimpan: " + e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int ok = JOptionPane.showConfirmDialog(this, "Hapus data ini?", "Konfirmasi Hapus", 0);
            if (ok == 0) {
         String sql = "DELETE FROM pasien WHERE id ='" + this.tIdPasien.getText() + "'";

         try {
            PreparedStatement stat = this.Conn.prepareStatement(sql);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            this.kosong();
            this.dataTable();
         } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data Gagal Dihapus: " + e);
         }
      }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
    String sql = "UPDATE pasien SET nama=?, jk=?, alamat=?, goldar=? WHERE id=?";
      try {
         if (this.tIdPasien.getText().trim().isEmpty() || 
             this.tNamaPasien.getText().trim().isEmpty() || 
             this.tAlm.getText().trim().isEmpty() || 
             this.cgd.getSelectedIndex() == 0 || 
             (!this.rjk1.isSelected() && !this.rjk2.isSelected())) {
             
            JOptionPane.showMessageDialog(this, "Semua data harus diisi terlebih dahulu!");
            return;
         }

         PreparedStatement stat = this.Conn.prepareStatement(sql);
         stat.setString(1, this.tNamaPasien.getText());
         String jk = this.rjk1.isSelected() ? "Laki-Laki" : "Perempuan";
         stat.setString(2, jk);
         stat.setString(3, this.tAlm.getText());
         stat.setString(4, this.cgd.getSelectedItem().toString());
         stat.setString(5, this.tIdPasien.getText());
         stat.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
         this.kosong();
         this.dataTable();
      } catch (SQLException e) {
         JOptionPane.showMessageDialog(this, "Data Gagal Diubah: " + e);
      }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.kosong();
        this.btnSave.setEnabled(true);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
    
    }//GEN-LAST:event_jPanel2MouseClicked

    private void tTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tTabelMouseClicked
        int bar = this.tTabel.getSelectedRow();
        String id = this.tabmode.getValueAt(bar, 0).toString();
        String nama = this.tabmode.getValueAt(bar, 1).toString();
        String jk = this.tabmode.getValueAt(bar, 2).toString();
        String alamat = this.tabmode.getValueAt(bar, 3).toString();
        String goldar = this.tabmode.getValueAt(bar, 4).toString();
        this.tIdPasien.setText(id);
        this.tNamaPasien.setText(nama);
        this.tAlm.setText(alamat);
        
        this.btnSave.setEnabled(false);
        
        if ("Laki-Laki".equals(jk)) {
           this.rjk1.setSelected(true);
        } else {
           this.rjk2.setSelected(true);
        }

        this.cgd.setSelectedItem(goldar);

    }//GEN-LAST:event_tTabelMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        Object[] Baris = new Object[]{"No. Identitas", "NAMA PASIEN", "JENIS KELAMIN", "ALAMAT & KONTAK", "GOLONGAN DARAH"};
        this.tabmode = new DefaultTableModel((Object[][])null, Baris);
        this.tTabel.setModel(this.tabmode);
        String sql = "SELECT * FROM pasien WHERE id LIKE '%" + this.tCari.getText() + "%' OR nama LIKE '%" + this.tCari.getText() + "%'";

        try {
           Statement stat = this.Conn.createStatement();
           ResultSet hasil = stat.executeQuery(sql);

           while(hasil.next()) {
              String a = hasil.getString("id");
              String b = hasil.getString("nama");
              String c = hasil.getString("jk");
              String d = hasil.getString("alamat");
              String e = hasil.getString("goldar");
              String[] data = new String[]{a, b, c, d, e};
              this.tabmode.addRow(data);
           }

           if (this.tabmode.getRowCount() == 0) {
              JOptionPane.showMessageDialog((Component)null, "Data tidak ditemukan");
              this.dataTable();
           }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog((Component)null, "Pencarian Gagal: " + e);
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void tIdPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIdPasienActionPerformed

    private void pnlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMouseClicked
   // TODO add your handling code here:
    }//GEN-LAST:event_pnlMouseClicked

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
            java.util.logging.Logger.getLogger(FormPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPasien().setVisible(true);
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
    private javax.swing.JComboBox<String> cgd;
    private javax.swing.ButtonGroup group1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lkdpoli;
    private javax.swing.JLabel lkdsp;
    private javax.swing.JPanel pnl;
    private javax.swing.JRadioButton rjk1;
    private javax.swing.JRadioButton rjk2;
    private javax.swing.JTextArea tAlm;
    private javax.swing.JTextField tCari;
    private javax.swing.JTextField tIdPasien;
    private javax.swing.JTextField tNamaPasien;
    private javax.swing.JTable tTabel;
    // End of variables declaration//GEN-END:variables
}
