package com.booking_futsal.model.pemesanan;


/**
 *
 * @author Kelompok 3
 */
// Class Model Data ModelPemesanan -> hanya diwariskan
public abstract class ModelPemesanan {

    private String kodeBooking;
    private String kodeLapang;
    private String tanggalPemesanan;
    private String waktuPemesanan;
    private String waktuAwal;
    private String waktuAkhir;
    private int durasi;
    private String namaPemesan;
    private String namaTeam;
    private String noHandphone;
    private int hargaLapang;
    private int downPayment;

    public ModelPemesanan(String kodeBooking, String kodeLapang,
            String tanggalPemesanan, String waktuAwal, String waktuAkhir, int durasi, String namaPemesan,
            String namaTeam, String noHandphone, int hargaLapang, int downPayment) {

        this.kodeBooking = kodeBooking;
        this.kodeLapang = kodeLapang;
        this.tanggalPemesanan = tanggalPemesanan;
        this.waktuAwal = waktuAwal;
        this.waktuAkhir = waktuAkhir;
        this.durasi = durasi;
        this.namaPemesan = namaPemesan;
        this.namaTeam = namaTeam;
        this.noHandphone = noHandphone;
        this.hargaLapang = hargaLapang;
        this.downPayment = downPayment;

    }

    public ModelPemesanan(String kodeBooking, String kodeLapang,
            String tanggalPemesanan, String waktuPemesanan, int durasi, String namaPemesan,
            String namaTeam, String noHandphone, int hargaLapang, int downPayment) {

        this.kodeBooking = kodeBooking;
        this.kodeLapang = kodeLapang;
        this.tanggalPemesanan = tanggalPemesanan;
        this.waktuPemesanan = waktuPemesanan;
        this.durasi = durasi;
        this.namaPemesan = namaPemesan;
        this.namaTeam = namaTeam;
        this.noHandphone = noHandphone;
        this.hargaLapang = hargaLapang;
        this.downPayment = downPayment;
    }

    public abstract int getTotalBayar();

    public abstract int getSisaBayar();

    public String getKodeBooking() {
        return kodeBooking;
    }

    public String getKodeLapang() {
        return kodeLapang;
    }

    public String getTanggalPemesanan() {
        return tanggalPemesanan;
    }

    public void setWaktuPemesanan(String waktuPemesanan) {
        this.waktuPemesanan = waktuPemesanan;
    }

    public String getWaktuPemesanan() {
        return waktuPemesanan;
    }

    public String getWaktuAwal() {
        return waktuAwal;
    }

    public String getWaktuAkhir() {
        return waktuAkhir;
    }

    public int getDurasi() {
        return durasi;
    }

    public String getNamaPemesan() {
        return namaPemesan;
    }

    public String getNamaTeam() {
        return namaTeam;
    }

    public String getNoHandphone() {
        return noHandphone;
    }

    public int getHargaLapang() {
        return hargaLapang;
    }

    public int getDownPayment() {
        return downPayment;
    }

}
