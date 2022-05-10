package com.booking_futsal.model;

import com.booking_futsal.model.pemesanan.OutputPemesanan;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kelompok 3
 */

// Class Tabel Model untuk Model TabelPemesanan.java
public class TabelModelCustom extends AbstractTableModel {

    private List<OutputPemesanan> listPemesanan = new ArrayList<>();
    private final String[] columnNames = {"NO.", "BOOKING", "LAPANG",
        "TANGGAL", "JAM", "DURASI", "PEMESAN", "TEAM", "PHONE",
        "HARGA", "DP", "SISA BAYAR"};

    public TabelModelCustom() {

    }

    public void setDataList(List<OutputPemesanan> dataPemesanan) {
        this.listPemesanan = dataPemesanan;
    }

    // jumlah baris
    @Override
    public int getRowCount() {
        return listPemesanan.size();
    }

    // jumlah column
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    // Nama column = array string columnNames
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    // Mendapatkan nilai setiap fields yang diambil langsung dari object pemesanan
    @Override
    public Object getValueAt(int row, int column) {

        OutputPemesanan output = listPemesanan.get(row);
        
        switch (column) {
            case 0:
                return output.getNo();
            case 1:
                return output.getKodeBooking();
            case 2:
                return output.getKodeLapang();
            case 3:
                return output.getTanggalPemesanan();
            case 4:
                return output.getWaktuPemesanan();
            case 5:
                return output.getDurasi() + " Jam";
            case 6:
                return output.getNamaPemesan();
            case 7:
                return output.getNamaTeam();
            case 8:
                return output.getNoHandphone();
            case 9:
                return output.getTotalBayar();
            case 10:
                return output.getDownPayment();
            case 11:
                return output.getSisaBayar();
        }

        return null;
    }

}
