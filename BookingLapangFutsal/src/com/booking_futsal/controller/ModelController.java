package com.booking_futsal.controller;

import com.booking_futsal.model.DatabaseTemp;
import com.booking_futsal.model.pemesanan.InputPemesanan;
import com.booking_futsal.model.pemesanan.ModelPemesanan;
import com.booking_futsal.model.pemesanan.OutputPemesanan;
import java.util.List;

/**
 * 
 * @author Kelompok 3
 */

// class Controller untuk menampung object InputPemesanan pada FormPemesanan
// dan menambahkannya ke dalam database temporary
public class ModelController {

    private DatabaseTemp dbTemp = new DatabaseTemp();

    public List<OutputPemesanan> getDataPemesanan() { // dipanggil di MainFrame.java baris 26
        return dbTemp.getDataPemesanan();
    }

    public void addDataPemesanan(InputPemesanan input) { // dipanggil di MainFrame.java baris 20
        ModelPemesanan output = new OutputPemesanan(input.getKodeBooking(), input.getKodeLapang(),
                input.getTanggalPemesanan(), input.getWaktuPemesanan(), input.getDurasi(), input.getNamaPemesan(),
                input.getNamaTeam(), input.getNoHandphone(), input.getHargaLapang(), input.getDownPayment());
        
        dbTemp.addDataPemesanan((OutputPemesanan) output);
    }

}
