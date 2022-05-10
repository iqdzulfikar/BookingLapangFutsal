package com.booking_futsal.model;

import com.booking_futsal.model.pemesanan.OutputPemesanan;
import java.util.ArrayList;

/**
 *
 * @author Kelompok 3
 */
public class DatabaseTemp {

    private ArrayList<OutputPemesanan> dataPemesanan;

    public DatabaseTemp() {
        this.dataPemesanan = new ArrayList<>();
    }

    public ArrayList<OutputPemesanan> getDataPemesanan() {
        return dataPemesanan;
    }

    public void addDataPemesanan(OutputPemesanan pemesanan) {
        dataPemesanan.add(pemesanan);
    }

}
