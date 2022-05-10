package com.booking_futsal.model;

import com.booking_futsal.model.pemesanan.InputPemesanan;
import com.booking_futsal.model.pemesanan.ModelPemesanan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Kelompok 3
 */
// Class Form untuk menginput data Pemesanan
public class FormPemesanan extends javax.swing.JPanel {

    private final Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat sdf;
    private InputListener inputListener;

    private final String[] months = {"Januari", "Februari", "Maret", "April",
        "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    private final int[] lapang = {01, 02, 03, 04, 05};
    private final int hargaLapang = 150_000;
    private int currentYear, currentMonth, currentDate, selectedYear, selectedMonth, selectedDate, dayOfTheMonth;
    private String inputVerifier;

    public FormPemesanan() {
        initComponents();
        initOtherComponents(); // Inisialisasi other components
        initEventButtons(); // Inisialisasi event button booking dan hapus
    }

    private void initOtherComponents() {

        // Menampilkan harga lapang ketika dijalankan
        lblHargaLapang.setText(String.format("Rp. %d/jam", hargaLapang));

        // Menambah item pada combo box lapangan
        for (int index : lapang) {
            comboKodeLapang.addItem(String.format("Lapang %d", index));
        }

        getCurrentTime(); // Mendapatkan waktu saat ini

        addYears(); // Menambahkan item pada combo box tahun
        addMonths(); // Menambahkan item pada combo box bulan
        addDates(currentYear, currentMonth, currentDate); // Menambahkan item pada combo box tanggal
        addHours(comboStart); // Menambahkan item pada combo box waktu awal pemesanan
        addHours(comboEnd); // Menambahkan item pada combo box waktu akhir pemesanan

        // Action Listener utk Combo Box Tahun dan Bulan
        ActionListener actionCombo = (ActionEvent e) -> {
            if (e.getSource() == comboTahun) {
                if (comboTahun.getSelectedItem() == null) {
                    comboTahun.setSelectedItem(String.valueOf(currentYear));
                }
                selectedYear = Integer.parseInt((String) comboTahun.getSelectedItem());
            }

            if (e.getSource() == comboBulan) {
                selectedMonth = comboBulan.getSelectedIndex();
            }
            addDates(selectedYear, selectedMonth, currentDate); // Tambah/update tanggal berdasarkan pilihan tahun dan bulan
        };

        // Menambahkan eventCombo ke dalam comboBox
        comboTahun.addActionListener(actionCombo);
        comboBulan.addActionListener(actionCombo);
    }

    private void initEventButtons() {

        ActionListener actionButton = (ActionEvent e) -> {
            if (e.getSource() == btnBooking) {
                try {
                    booking(); // Menyimpan data pemesanan dan menampilkannya ke dalam tabel
                } catch (ParseException ex) {
                    System.err.println(ex);
                }
            } else { // btn Hapus
                refreshFields(); // Mengosongkan fields
            }
        };

        btnBooking.addActionListener(actionButton);
        btnHapus.addActionListener(actionButton);
    }

    private void booking() throws ParseException {

        selectedYear = Integer.parseInt((String) comboTahun.getSelectedItem());
        selectedMonth = comboBulan.getSelectedIndex();
        selectedDate = Integer.parseInt((String) comboTanggal.getSelectedItem());

        inputVerifier = "";
        verifikasiInput(); // Verifikasi fields

        if (inputVerifier.equals("")) {

            String kodeBooking = tfKodeBooking.getText();
            String kodeLapang = (String) comboKodeLapang.getSelectedItem();

            calendar.set(selectedYear, selectedMonth, selectedDate);
            sdf = new SimpleDateFormat("dd/MM/yy");
            String tanggalPemesanan = sdf.format(calendar.getTime());

            // Durasi pemesanan/sewa (jam): untuk mendapatkan sisa yg harus dibayar pemesan
            sdf = new SimpleDateFormat("HH:mm:ss");
            int durasi = getDuration((String.valueOf(sdf.format(comboStart.getSelectedItem()))),
                    String.valueOf(sdf.format(comboEnd.getSelectedItem())));

            // Waktu pemesanan ex: 08:00 s/d 09:00
            sdf = new SimpleDateFormat("HH:mm");
            String waktuAwal = sdf.format(comboStart.getSelectedItem());
            String waktuAkhir = sdf.format(comboEnd.getSelectedItem());
//            String waktuPemesanan = String.valueOf(sdf.format(comboStart.getSelectedItem()) + " s/d " + sdf.format(comboEnd.getSelectedItem()));
            String namaPemesan = tfNamaPemesan.getText();
            String namaTeam = tfTeam.getText();
            String noHandphone = tfNoHandphone.getText();
            int dp = Integer.parseInt(tfUangMuka.getText());

            // Menambahkan model pemesanan input ke dalam object
            ModelPemesanan inputPemesanan = new com.booking_futsal.model.pemesanan.InputPemesanan(kodeBooking, kodeLapang, tanggalPemesanan,
                    waktuAwal, waktuAkhir, durasi, namaPemesan, namaTeam, noHandphone, hargaLapang, dp);

            // Jika inputListener tidak null, tambahkan object pemesanan
            if (inputListener != null) {
                inputListener.addInputPerformed((InputPemesanan) inputPemesanan);
            }

        } else {
            // Menampilkan warning message jika String inputVerifier tidadk kosong
            JOptionPane.showInternalMessageDialog(null, inputVerifier,
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void addInputListener(InputListener inputListener) { // Method ini akan dipanggil di MainFrame
        this.inputListener = inputListener;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfKodeBooking = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboKodeLapang = new javax.swing.JComboBox<>();
        lblHargaLapang = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboTanggal = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboBulan = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboTahun = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        comboStart = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboEnd = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfNamaPemesan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfTeam = new javax.swing.JTextField();
        tfNoHandphone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfUangMuka = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        btnBooking = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(203, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("YST Futsal");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kode Booking :");

        tfKodeBooking.setToolTipText("");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Lapangan :");

        lblHargaLapang.setText("Harga Lapang");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tanggal Pemesanan :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("/");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel4.setText("/");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Waktu Pemesanan (Jam) :");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel5.setText("s/d");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Nama Pemesan :");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Nama Team :");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("No. Handphone");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Uang Muka :");

        btnHapus.setText("Hapus");
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnBooking.setText("Booking");
        btnBooking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(comboTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(3, 3, 3)
                                    .addComponent(jLabel3)
                                    .addGap(3, 3, 3)
                                    .addComponent(comboBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(3, 3, 3)
                                    .addComponent(jLabel4)
                                    .addGap(3, 3, 3)
                                    .addComponent(comboTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(comboStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(3, 3, 3)
                                    .addComponent(jLabel5)
                                    .addGap(3, 3, 3)
                                    .addComponent(comboEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboKodeLapang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfKodeBooking, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(195, 195, 195)
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tfNamaPemesan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(lblHargaLapang)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel10))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(187, 187, 187)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfUangMuka, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tfNoHandphone)
                                                    .addComponent(tfTeam, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfKodeBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tfNamaPemesan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboKodeLapang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHargaLapang)
                    .addComponent(jLabel6)
                    .addComponent(tfTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tfNoHandphone, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboStart, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(comboEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tfUangMuka, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /* Methods Date & Time */
    private void getCurrentTime() {
        calendar.setTime(new Date());
        currentYear = calendar.get(Calendar.YEAR);
        currentMonth = calendar.get(Calendar.MONTH);
        currentDate = calendar.get(Calendar.DATE);
    }

    private void addYears() {
        for (int years = currentYear; years <= 2030; years++) {
            comboTahun.addItem(String.valueOf(years));
        }
    }

    private void addMonths() {
        for (String month : months) {
            comboBulan.addItem(month);
        }
        comboBulan.setSelectedIndex(currentMonth);
    }

    private void addDates(int selectedYear, int selectedMonth, int currentDate) {

        // Mengatur tahun dan bulan yang dipilih untuk 
        // mendapatkan tanggal di setiap tahun dan bulan tersebut
        calendar.set(selectedYear, selectedMonth, currentDate);

        // Mencari tanggal akhir di bulan dan tahun yang dipilih
        int lastDay = calendar.getActualMaximum(Calendar.DATE);
        dayOfTheMonth = 1;
        comboTanggal.removeAllItems(); // hapus seluruh item, sebelum ditambah tanggal baru

        while (dayOfTheMonth <= lastDay) {
            comboTanggal.addItem(String.valueOf(dayOfTheMonth));
            dayOfTheMonth++;
        }

        getCurrentTime(); // Dapatkan waktu saat ini

        // Menampilkan tanggal saat aplikasi dijalankan
        if (comboTahun.getSelectedItem().equals(String.valueOf(currentYear))
                && comboBulan.getSelectedIndex() == currentMonth) {
            comboTanggal.setSelectedItem(String.valueOf(currentDate));
        } else {
            comboTanggal.setSelectedItem(String.valueOf(1)); // Jika tahun & bulan lain, setTanggal = 1
        }
    }

    private void addHours(JComboBox comboBox) {

        selectedYear = Integer.parseInt((String) comboTahun.getSelectedItem());
        selectedMonth = comboBulan.getSelectedIndex();
        selectedDate = Integer.parseInt((String) comboTanggal.getSelectedItem());

        calendar.set(selectedYear, selectedMonth, selectedDate, 8, 0);
        if (comboBox == comboEnd) {
            calendar.add(Calendar.HOUR_OF_DAY, 1);
        }
        sdf = new SimpleDateFormat("HH:mm");

        Calendar endTime = Calendar.getInstance();
        endTime.set(selectedYear, selectedMonth, selectedDate, 23, 0);

        do {
            comboBox.addItem(calendar.getTime());
            calendar.add(Calendar.MINUTE, 60); // Tambah 60 menit, jika jam saat ini kurang dari 23.00
        } while (calendar.getTime().before(endTime.getTime()));

        comboBox.setRenderer(new DateFormattedListCellRenderer(sdf));
    }

    private int getDuration(String startTime, String endTime) throws ParseException {
        sdf = new SimpleDateFormat("HH:mm:ss");

        Date time1 = sdf.parse(startTime);
        Date time2 = sdf.parse(endTime);

        // Menghitung perbedaan waktu jam dan menit
        long diffInMs = Math.abs(time2.getTime() - time1.getTime()); // perbedaan milidetik
        long diffInHours = (diffInMs / (60 * 60 * 1000)) % 24; // perbedaan jam
//        long diffInMinutes = (diffInMs / (60 * 1000)) % 60; // perbedaan menit
//        long diffInSeconds = (diffInMs / 1000) % 60; // perbedaan detik 

        return (int) diffInHours; // Mengembalikan perbedaan jam (waktu pemesanan) yang dipilih
    }
    // Akhir Methods Date & Time

    private void verifikasiInput() throws ParseException {
        sdf = new SimpleDateFormat("HH:mm:ss");

        String startTime = String.valueOf(sdf.format(comboStart.getSelectedItem())); // waktu awal
        String endTime = String.valueOf(sdf.format(comboEnd.getSelectedItem())); // waktu akhir

        Date time1 = sdf.parse(startTime);
        Date time2 = sdf.parse(endTime);

        // Jika waktu pemesanan akhir lebih kecil/awal dari waktu pemesanan awal
        int totalBayar = hargaLapang * getDuration(startTime, endTime);

        if (!tfUangMuka.getText().equals("")) {
            int dp = Integer.parseInt(tfUangMuka.getText());
            if (dp < ((totalBayar * 20) / 100)) {
                inputVerifier = "Nominal DP yang dimasukkan kurang dari 20% Total Harga Pemesanan.\n"
                        + "Pastikan DP yang dimasukkan sudah benar!";
            } else if (dp > totalBayar) {
                inputVerifier = "Nominal DP yang dimasukkan melebihi harga pemesanan.\n"
                        + "Pastikan DP yang dimasukkan sudah benar!";
            }
        }

        if (tfKodeBooking.getText().equals("")
                || time2.before(time1) || time2.equals(time1) || tfNamaPemesan.getText().equals("")
                || tfTeam.getText().equals("") || tfNoHandphone.getText().equals("")
                || tfUangMuka.getText().equals("")) {

            inputVerifier = "Ada Data yang masih kosong atau salah.\n"
                    + "Pastikan semua fields sudah terisi dengan benar!";
        }

    }

    private void refreshFields() {
        getCurrentTime();
        tfKodeBooking.setText("");
        comboKodeLapang.setSelectedIndex(0);
        comboTanggal.setSelectedItem(String.valueOf(currentDate));
        comboBulan.setSelectedIndex(currentMonth);
        comboTahun.setSelectedItem(String.valueOf(currentYear));
        comboStart.setSelectedIndex(0);
        comboEnd.setSelectedIndex(0);
        tfNamaPemesan.setText("");
        tfTeam.setText("");
        tfNoHandphone.setText("");
        tfUangMuka.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBooking;
    private javax.swing.JButton btnHapus;
    private javax.swing.JComboBox<String> comboBulan;
    private javax.swing.JComboBox<String> comboEnd;
    private javax.swing.JComboBox<String> comboKodeLapang;
    private javax.swing.JComboBox<String> comboStart;
    private javax.swing.JComboBox<String> comboTahun;
    private javax.swing.JComboBox<String> comboTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHargaLapang;
    private javax.swing.JTextField tfKodeBooking;
    private javax.swing.JTextField tfNamaPemesan;
    private javax.swing.JTextField tfNoHandphone;
    private javax.swing.JTextField tfTeam;
    private javax.swing.JTextField tfUangMuka;
    // End of variables declaration//GEN-END:variables
}
