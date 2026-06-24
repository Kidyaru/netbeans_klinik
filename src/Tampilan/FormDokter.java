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
    String kdSpesialis, nmSpesialis, kdPoliklinik, nmPolikiklinik;
    
    // Asumsi method kosong() belum dideklarasikan tapi dipanggil di constructor
    protected void kosong(){
         tdr.setText("");
        tdr.setEnabled(true);
        tndr.setText("");
        tkdSpl.setText("");
        tkdSpl.setEnabled(false);
        tnmSpl.setText("");
        tnmSpl.setEnabled(false);
        tkdPoli.setText("");
        tkdPoli.setEnabled(false);
        tnmPoli.setText("");
        tnmPoli.setEnabled(false);
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        datatable();
        KodeDokter();
       tnmSpl.setEnabled(true);
        
    }
    
    public FormDokter() {
        initComponents();
        kosong();
        aktif();
        datatable();
        setResizable(false);
        setLocationRelativeTo(null);
        KodeDokter();
        datatable();
        
//        this.setExtendedState(FormDokter.MAXIMIZED_BOTH);
    }
    
    protected void aktif(){
       tdr.setEnabled(true);
       tndr.setEnabled(true);
       tkdSpl.setEnabled(false);
       tnmSpl.setEnabled(false);
       tkdPoli.setEnabled(false);
       tnmPoli.setEnabled(false);
    }
    
    public void KodeDokter() {
    try {
            java.sql.Statement stat = Conn.createStatement();
            String sql = "SELECT id_dokter FROM dokter ORDER BY id_dokter "
                    + "DESC LIMIT 1";
            ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
                String lastId = hasil.getString("id_dokter");
                String nomorAngka = lastId.substring(2);
                int angkaBerikutnya = Integer.parseInt(nomorAngka) + 1;

                String angkaFormatted = String.format("%03d", angkaBerikutnya);
                tdr.setText("DR" + angkaFormatted);
            } else {
                tdr.setText("DR001");
            }
        } catch (NumberFormatException | SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Gagal membuat kode "
                    + "dokter otomatis: " + e.getMessage());
        }
    }
    
    protected void datatable(){
        Object[] Baris ={"ID DOKTER","NAMA DOKTER","KODE SPESIALIS","SPESIALIS",
            "KODE POLIKLINIK","POLIKLINIK"};
        tabmode = new DefaultTableModel(null,Baris);
        tabeldokter.setModel(tabmode);

        String sql = "SELECT * FROM view_detail_dokter";
        try {
            java.sql.Statement stat= Conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String a = hasil.getString("id_dokter");
                String b = hasil.getString("nama_dokter");
                String c = hasil.getString("spesialis");
                String d = hasil.getString("nama_spl");
                String e = hasil.getString("poliklinik");
                String f = hasil.getString("nama_poliklinik");

                String[] data ={a,b,c,d,e,f};
                tabmode.addRow(data);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data tabel: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void itemTerpilihSpesialis(){
        popupSpesialis ppSpesiaslis = new popupSpesialis();
        ppSpesiaslis.Spl=this;
        tkdSpl.setText(kdSpesialis);
        tnmSpl.setText(nmSpesialis);
    }

    public void itemTerpilihPoliklinik(){
        popupPoli ppPoli = new popupPoli();
        ppPoli.poli=this;
        tkdPoli.setText(kdPoliklinik);
        tnmPoli.setText(nmPolikiklinik);
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnl = new javax.swing.JPanel();
        tdr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tnmSpl = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        tkdSpl = new javax.swing.JTextField();
        btn_ppSpl = new javax.swing.JButton();
        tndr = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tkdPoli = new javax.swing.JTextField();
        btn_ppPoli = new javax.swing.JButton();
        tnmPoli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tCaridokter = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeldokter = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        pnl.setBackground(new java.awt.Color(153, 153, 255));
        pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Dokter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        pnl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        tdr.setBackground(new java.awt.Color(218, 218, 255));
        tdr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdrActionPerformed(evt);
            }
        });

        jLabel2.setText("Kode Dokter");

        tnmSpl.setBackground(new java.awt.Color(218, 218, 255));
        tnmSpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnmSplActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Dokter");

        jLabel4.setText("Kode Spesialis");

        jLabel5.setText("Nama Spesialis");

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

        tkdSpl.setBackground(new java.awt.Color(218, 218, 255));

        btn_ppSpl.setText("Pilih Spesialis");
        btn_ppSpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ppSplActionPerformed(evt);
            }
        });

        tndr.setBackground(new java.awt.Color(218, 218, 255));

        jLabel7.setText("Kode Poliklinik");

        tkdPoli.setBackground(new java.awt.Color(218, 218, 255));
        tkdPoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkdPoliActionPerformed(evt);
            }
        });

        btn_ppPoli.setText("Pilih Poliklinik");
        btn_ppPoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ppPoliActionPerformed(evt);
            }
        });

        tnmPoli.setBackground(new java.awt.Color(218, 218, 255));
        tnmPoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnmPoliActionPerformed(evt);
            }
        });

        jLabel8.setText("Nama Poliklinik");

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(11, 11, 11)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLayout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear)
                                .addGap(18, 18, 18)
                                .addComponent(btnClose))
                            .addGroup(pnlLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlLayout.createSequentialGroup()
                                        .addComponent(tkdSpl, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_ppSpl))
                                    .addComponent(tnmSpl, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tdr, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlLayout.createSequentialGroup()
                                        .addComponent(tkdPoli, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_ppPoli))
                                    .addComponent(tnmPoli, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tndr, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addComponent(tdr, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tndr, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tkdSpl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ppSpl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tnmSpl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tkdPoli, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btn_ppPoli, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tnmPoli, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Dokter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        tCaridokter.setBackground(new java.awt.Color(218, 218, 255));

        jLabel6.setText("Cari Dokter");

        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tabeldokter.setBackground(new java.awt.Color(218, 218, 255));
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(tCaridokter)
                        .addGap(18, 18, 18)
                        .addComponent(btnCari)))
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCaridokter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("FORM DOKTER KLINIK SAWIT ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(363, 363, 363))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
    
    }//GEN-LAST:event_jPanel2MouseClicked

    private void tabeldokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeldokterMouseClicked
       int bar = tabeldokter.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();

        tdr.setText(a);
        tdr.setEnabled(false);
        tndr.setText(b);
        tkdSpl.setText(c);
        tnmSpl.setText(d);
        tkdPoli.setText(e);
        tnmPoli.setText(f);
        
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tabeldokterMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
    Object[] Baris = {"ID DOKTER","NAMA DOKTER","SPESIALIS","POLIKLINIK"};
    tabmode = new DefaultTableModel(null, Baris);
    String sql = "SELECT * FROM view_detail_dokter where nama_dokter LIKE '%"+tCaridokter.getText()+"%' "
            + "OR id_dokter LIKE '%"+tCaridokter.getText()+"%'";
    try {
        java.sql.Statement stat = Conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while(hasil.next()){
            String a = hasil.getString("id_dokter");
            String b = hasil.getString("nama_dokter");
            String c = hasil.getString("nama_spl");
            String d = hasil.getString("nama_poliklinik");

            String[] data ={a,b,c,d};
            tabmode.addRow(data);
        }
        tabeldokter.setModel(tabmode);
    } catch (Exception e) {
    }
    }//GEN-LAST:event_btnCariActionPerformed

    private void tnmPoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnmPoliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnmPoliActionPerformed

    private void btn_ppPoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ppPoliActionPerformed
        popupPoli ppPoli = new popupPoli();
        ppPoli.poli= this;
        ppPoli.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ppPoliActionPerformed

    private void tkdPoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkdPoliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkdPoliActionPerformed

    private void btn_ppSplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ppSplActionPerformed
        popupSpesialis ppSpesialis = new popupSpesialis();
        ppSpesialis.Spl= this;
        ppSpesialis.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btn_ppSplActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.kosong();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int hapus = JOptionPane.showConfirmDialog(null, "Anda yakin akan Menghapus Data Dokter ini?", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if(hapus==0){
            String sql ="DELETE FROM dokter where id_dokter='"+tdr.getText()+"'";
            try {
                PreparedStatement stat = Conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data dokter Berhasil Dihapus");
                kosong();
                tdr.requestFocus();
                datatable();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data dokter Gagal Dihapus " +e);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String sql = "UPDATE dokter set nama_dokter=?, spesialis=?, poliklinik=? WHERE id_dokter=?";
            PreparedStatement stat = Conn.prepareStatement(sql);
            stat.setString(1, tndr.getText());
            stat.setString(2, tkdSpl.getText());
            stat.setString(3, tkdPoli.getText());
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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String sql = "INSERT INTO dokter values (?,?,?,?)";
        try {
            PreparedStatement stat = Conn.prepareStatement(sql);
            stat.setString(1, tdr.getText());
            stat.setString(2, tndr.getText());
            stat.setString(3, tkdSpl.getText());
            stat.setString(4, tkdPoli.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Dokter Berhasil Disimpan");
            kosong();
            tdr.requestFocus();
            datatable();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Dokter Gagal Disimpan");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tnmSplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnmSplActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnmSplActionPerformed

    private void tdrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tdrActionPerformed

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
    private javax.swing.JButton btn_ppPoli;
    private javax.swing.JButton btn_ppSpl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl;
    private javax.swing.JTextField tCaridokter;
    private javax.swing.JTable tabeldokter;
    private javax.swing.JTextField tdr;
    private javax.swing.JTextField tkdPoli;
    private javax.swing.JTextField tkdSpl;
    private javax.swing.JTextField tndr;
    private javax.swing.JTextField tnmPoli;
    private javax.swing.JTextField tnmSpl;
    // End of variables declaration//GEN-END:variables
}
