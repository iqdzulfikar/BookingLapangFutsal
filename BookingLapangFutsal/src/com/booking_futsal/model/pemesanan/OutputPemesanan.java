package com.booking_futsal.model.pemesanan;

/**
 *
 * @author Kelompok 3
 */
// Kelas untuk menampung input pemesanan dan menampilkannya di tabel pemesanan
public class OutputPemesanan extends ModelPemesanan {

    private final int no;
    private static int count = 1;
    private int totalBayar;
    private int sisaBayar;

    public OutputPemesanan(String kodeBooking, String kodeLapang,
            String tanggalPemesanan, String waktuPemesanan, int durasi, String namaPemesan,
            String namaTeam, String noHandphone, int hargaLapang, int downPayment) {

        super(kodeBooking, kodeLapang, tanggalPemesanan, waktuPemesanan, durasi,
                namaPemesan, namaTeam, noHandphone, hargaLapang, downPayment);

        no = count;
        count++;

    }

    public int getNo() {
        return no;
    }

    @Override
    public int getTotalBayar() {        
        totalBayar = getHargaLapang() * getDurasi();
        return totalBayar;
    }

    @Override
    public int getSisaBayar() {
        sisaBayar = totalBayar - getDownPayment();
        if (sisaBayar < 0) {
            sisaBayar = 0;
        }
        return sisaBayar;
    }

}
