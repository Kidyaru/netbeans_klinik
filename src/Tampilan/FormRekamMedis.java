/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import Koneksi.koneksi;

/**
 *
 * @author rafli
 */
public class FormRekamMedis extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormRekamMedis.class.getName());
    private Connection Conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    public String tanggalperiksa;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String kddokter, nmdokter, nmspesialis, nmpoli, kdpasien, nmpasien,goldar;
    
    public FormRekamMedis() {
        initComponents();
        aktif(); 
        kosong();
        setResizable(true);
        setLocationRelativeTo(null);
//        this.setExtendedState(frmDokter.MAXIMIZED_BOTH);
        datatable();
        nomorReg(); 
        jDate_periksa.setDateFormatString("yyyy-MM-dd");
    }
    
    
public void itemTerpilihPasien(){
    tidPasien.setText(kdpasien);      
    tnamaPasien.setText(nmpasien);   
    tGoldar.setText(goldar);         
}

public void itemTerpilihDokter(){
    tidDokter.setText(kddokter);
    tnamaDokter.setText(nmdokter);
    tSpesialis.setText(nmspesialis);
    tPoli.setText(nmpoli);
}
    
public void tanggal(){
    if(jDate_periksa.getDate() != null){
        String pattern = "YYYY-MM-dd";
        SimpleDateFormat formattgl = new SimpleDateFormat(pattern);
        tanggalperiksa = String.valueOf(formattgl.format(jDate_periksa.getDate()));
    }
}
    
public void tanggal_periksa(){
    String sql ="SELECT * FROM rekam_medis where no_reg ='"+no_reg+"'";
    try {
        java.sql.Statement stat = Conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while(hasil.next()){
        jDate_periksa.setDate(hasil.getDate("tgl_periksa"));
        }
        
    } catch (SQLException e) {
    }
}

protected void datatable(){
    Object[] Baris={"No.","NO. REGISTRASI","TANGGAL PERIKSA","ID PASIEN","NAMA PASIEN",
    "GOLONGAN DARAH","TINGGI BADAN","BERAT BADAN","DIAGNOSA","ID DOKTER","NAMA DOKTER",
    "SPESIALIS","POLIKLINIK"};
    tabmode = new DefaultTableModel(null, Baris);
    tabelrekam.setModel(tabmode);
    String sql ="SELECT * FROM v_rekam_medis ORDER BY tgl_periksa DESC";
    try{
        java.sql.Statement stat = Conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        int no = 1;
        while(hasil.next()){
            String a = hasil.getString("no_reg");
            String b = hasil.getString("tgl_periksa");
            String c = hasil.getString("id"); 
            String d = hasil.getString("nama");
            String e = hasil.getString("goldar");
            String f = hasil.getString("tb");
            String g = hasil.getString("bb");
            String h = hasil.getString("diagnosa");
            String id_dok = hasil.getString("id_dokter"); 
            String i = hasil.getString("nama_dokter");
            String j = hasil.getString("nama_spl");
            String k = hasil.getString("nama_poliklinik");

           
            Object[] data={no,a,b,c,d,e,f,g,h,id_dok,i,j,k};
            tabmode.addRow(data);
            no++;
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Gagal Memuat Data" +e);
    }
}

protected void aktif(){
    no_reg.setText("");
    jDate_periksa.setDate(null);
    tidPasien.setText("");
    tidPasien.setEnabled(false);
    tnamaPasien.setText("");
    tnamaPasien.setEnabled(false);
    tGoldar.setText("");
    tGoldar.setEnabled(false);
    tTinggi.setText("");
    tGoldar.setEnabled(false);
    tBerat.setText("");
    tDiagnosa.setText("");

    tidDokter.setText("");
    tidDokter.setEnabled(false);
    tnamaDokter.setText("");
    tnamaDokter.setEnabled(false);
    tSpesialis.setText("");
    tSpesialis.setEnabled(false);
    tPoli.setText("");
    tPoli.setEnabled(false);
    no_reg.requestFocus();
}

protected void kosong(){
    no_reg.setText("");
    jDate_periksa.setDate(null);
    tidPasien.setText("");
    tnamaPasien.setText("");
    tnamaPasien.setEnabled(false);
    tGoldar.setText("");
    tGoldar.setEnabled(false);
    tTinggi.setText("");
    tBerat.setText("");
    tDiagnosa.setText("");

    tidDokter.setText("");
    tidDokter.setEnabled(false);
    tnamaDokter.setText("");
    tnamaDokter.setEnabled(false);
    tSpesialis.setText("");
    tSpesialis.setEnabled(false);
    tPoli.setText("");
    tPoli.setEnabled(false);
    btnSave.setEnabled(true);
    datatable();
    nomorReg();
}

public void nomorReg(){
    Date sekarang = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    String tanggalHariIni = sdf.format(sekarang);
    try {
        java.sql.Statement stat = Conn.createStatement();
        String sql = "SELECT no_reg FROM rekam_medis WHERE no_reg LIKE '%"
                + tanggalHariIni + "' ORDER BY no_reg DESC LIMIT 1";
        ResultSet hasil = stat.executeQuery(sql);

        if (hasil.next()) {
            String lastNo = hasil.getString("no_reg");
            String substringUrut = lastNo.substring(0, 4);
            int urutanBerikutnya = Integer.parseInt(substringUrut) + 1;
            String nomorUrutFormatted = String.format("%04d", urutanBerikutnya);
            no_reg.setText(nomorUrutFormatted + tanggalHariIni);
        } else {
            no_reg.setText("0001" + tanggalHariIni);
        }

    } catch (NumberFormatException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal membuat nomor otomatis: "
                + e.getMessage());
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

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        no_reg = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDate_periksa = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tidPasien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tnamaPasien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tGoldar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tTinggi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tBerat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDiagnosa = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnCariPasien = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tidDokter = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tnamaDokter = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tSpesialis = new javax.swing.JTextField();
        tPoli = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnCariDokter = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        tCariRek = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelrekam = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("No. Pendaftaran");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tanggal Periksa");

        jDate_periksa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDate_periksaPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(no_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jDate_periksa, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDate_periksa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(no_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setText("REKAM MEDIS KLINIK SAWIT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FORM PASIEN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Id Pasien");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nama Pasien");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Gol darah");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tinggi Badan");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Berat Badan");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Diagnosa");

        tDiagnosa.setColumns(20);
        tDiagnosa.setRows(5);
        jScrollPane1.setViewportView(tDiagnosa);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Kg");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("cm");

        btnCariPasien.setText(" Cari Pasien");
        btnCariPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPasienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tidPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCariPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(tBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel10))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(tTinggi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel11))
                        .addComponent(tGoldar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tnamaPasien)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tidPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tnamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tGoldar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tTinggi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(240, 240, 240))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FORM PASIEN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Id Dokter");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Nama Dokter");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Spesialis");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Poliklinik");

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
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

        btnCariDokter.setText(" Cari Dokter");
        btnCariDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariDokterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tPoli)
                    .addComponent(tSpesialis)
                    .addComponent(tnamaDokter)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tidDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCariDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 93, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tidDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tnamaDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tSpesialis, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tPoli, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LIST REKAM MEDIS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Cari Data");

        tCariRek.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCariRekKeyPressed(evt);
            }
        });

        tabelrekam.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelrekam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelrekamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelrekam);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(tCariRek, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tCariRek, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    String sql = "INSERT INTO rekam_medis VALUES (?,?,?,?,?,?,?)";
    try {
        PreparedStatement stat = Conn.prepareStatement(sql);
        stat.setString(1, no_reg.getText());
        stat.setString(2, tanggalperiksa);
        stat.setString(3, tidDokter.getText());
        stat.setString(4, tidPasien.getText());
        stat.setInt(5, Integer.parseInt(tTinggi.getText()));
        stat.setInt(6, Integer.parseInt(tBerat.getText()));
        stat.setString(7, tDiagnosa.getText());

        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Rekam Medis Berhasil Disimpan");
        kosong();
        no_reg.requestFocus();
        datatable();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data Rekam Medis Gagal Disimpan \n" + e);
    }        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jDate_periksaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDate_periksaPropertyChange
        if (jDate_periksa.getDate() !=null ){
            tanggalperiksa = format.format(jDate_periksa.getDate());
        }
    }//GEN-LAST:event_jDate_periksaPropertyChange

    private void tabelrekamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelrekamMouseClicked
    int bar = tabelrekam.getSelectedRow();
    String a = tabmode.getValueAt(bar, 0).toString();
    String b = tabmode.getValueAt(bar, 1).toString();
    String c = tabmode.getValueAt(bar, 2).toString();
    String d = tabmode.getValueAt(bar, 3).toString();
    String e = tabmode.getValueAt(bar, 4).toString();
    String f = tabmode.getValueAt(bar, 5).toString();
    String g = tabmode.getValueAt(bar, 6).toString();
    String h = tabmode.getValueAt(bar, 7).toString();
    String i = tabmode.getValueAt(bar, 8).toString();
    String idDok = tabmode.getValueAt(bar, 9).toString();
    String j = tabmode.getValueAt(bar, 10).toString();
    String k = tabmode.getValueAt(bar, 11).toString();
    String l = tabmode.getValueAt(bar, 12).toString();

    no_reg.setText(b);
    try {
        Date dateSelected = format.parse(c);
        jDate_periksa.setDate(dateSelected);
    } catch (Exception e2) {
        System.out.println("Gagal memuat tanggal ke form: " + e2.getMessage());
    }

    tidPasien.setText(d);
    tnamaPasien.setText(e);
    tGoldar.setText(f);
    tTinggi.setText(g);
    tBerat.setText(h);
    tDiagnosa.setText(i);
    tidDokter.setText(idDok);
    tnamaDokter.setText(j);
    tSpesialis.setText(k);
    tPoli.setText(l);

    btnSave.setEnabled(false);
    }//GEN-LAST:event_tabelrekamMouseClicked

    private void tCariRekKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariRekKeyPressed
    Object[] Baris={"NO. REGISTRASI","TANGGAL PERIKSA","ID PASIEN","NAMA PASIEN",
    "GOLONGAN DARAH","TINGGI BADAN","BERAT BADAN","DIAGNOSA","NAMA DOKTER",
    "SPESIALIS","POLIKLINIK"};
    tabmode = new DefaultTableModel(null, Baris);
    String sql = "SELECT * FROM v_rekam_medis where nama LIKE "
            + "'%"+tCariRek.getText()+"%' OR id LIKE '%"+tCariRek.getText()+"%' "
            + "OR nama_dokter LIKE '%"+tCariRek.getText()+"%'";
    try {
        java.sql.Statement stat = Conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while(hasil.next()){
    String a = hasil.getString("no_reg");
    String b = hasil.getString("tgl_periksa");
    String c = hasil.getString("id");
    String d = hasil.getString("nama");
    String e = hasil.getString("goldar");
    String f = hasil.getString("tb");
    String g = hasil.getString("bb");
    String h = hasil.getString("diagnosa");
    String i = hasil.getString("nama_dokter");
    String j = hasil.getString("nama_spl");
    String k = hasil.getString("nama_poliklinik");

    String[] data={a,b,c,d,e,f,g,h,i,j,k};
        tabmode.addRow(data);
        }
        tabelrekam.setModel(tabmode);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal memuat data"+e);
    }      
    }//GEN-LAST:event_tCariRekKeyPressed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
    dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnCariPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPasienActionPerformed
    popupPasien ppPasien = new popupPasien();
    ppPasien.pasien =this;
    ppPasien.setVisible (true);// TODO add your handling code here:
    }//GEN-LAST:event_btnCariPasienActionPerformed

    private void btnCariDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariDokterActionPerformed
    popupDokter ppDokter = new popupDokter();
    ppDokter.dok =this;
    ppDokter.setVisible (true);
    }//GEN-LAST:event_btnCariDokterActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
    this.kosong();        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(FormRekamMedis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRekamMedis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRekamMedis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRekamMedis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRekamMedis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariDokter;
    private javax.swing.JButton btnCariPasien;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private com.toedter.calendar.JDateChooser jDate_periksa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField no_reg;
    private javax.swing.JTextField tBerat;
    private javax.swing.JTextField tCariRek;
    private javax.swing.JTextArea tDiagnosa;
    private javax.swing.JTextField tGoldar;
    private javax.swing.JTextField tPoli;
    private javax.swing.JTextField tSpesialis;
    private javax.swing.JTextField tTinggi;
    private javax.swing.JTable tabelrekam;
    private javax.swing.JTextField tidDokter;
    private javax.swing.JTextField tidPasien;
    private javax.swing.JTextField tnamaDokter;
    private javax.swing.JTextField tnamaPasien;
    // End of variables declaration//GEN-END:variables
}
