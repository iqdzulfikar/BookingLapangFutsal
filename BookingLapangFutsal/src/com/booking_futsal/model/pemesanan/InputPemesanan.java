package com.booking_futsal.model.pemesanan;

/**
 *
 * @author Kelompok 3
 */
// Kelas untuk menampung inputan data Pemesanan
public class InputPemesanan extends ModelPemesanan {

    public InputPemesanan(String kodeBooking, String kodeLapang,
            String tanggalPemesanan, String WaktuAwal, String waktuAkhir, int durasi, String namaPemesan,
            String namaTeam, String noHandphone, int hargaLapang, int downPayment) {

        super(kodeBooking, kodeLapang, tanggalPemesanan, WaktuAwal, waktuAkhir, durasi,
                namaPemesan, namaTeam, noHandphone, hargaLapang, downPayment);

        setWaktuPemesanan(WaktuAwal + " s/d " + waktuAkhir);

    }

    @Override
    public int getTotalBayar() {
        return 0;
    }

    @Override
    public int getSisaBayar() {
        return 0;
    }

}
