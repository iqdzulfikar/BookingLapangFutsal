package com.booking_futsal.view;

import com.booking_futsal.model.pemesanan.OutputPemesanan;
import java.util.List;

/**
 *
 * @author Kelompok 3
 */
public class TabelPemesanan extends javax.swing.JPanel {

    public TabelPemesanan() {
        initComponents();
        tabelView.setModel(tabelModelCustom); // model tabel -> object dari class TabelModelCustom.java
    }

    
    public void setDataList(List<OutputPemesanan> dataPemesanan) {
        tabelModelCustom.setDataList(dataPemesanan);
    }

    // Update fields jika data baru ditambahkan/ data pada model tabel berubah
    public void updateFieldTabel() {
        tabelModelCustom.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabelModelCustom = new com.booking_futsal.model.TabelModelCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelView = new javax.swing.JTable();

        setBackground(new java.awt.Color(203, 204, 255));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 402));

        tabelView.setBackground(new java.awt.Color(255, 255, 255));
        tabelView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelView.setGridColor(new java.awt.Color(203, 204, 255));
        tabelView.setShowGrid(true);
        tabelView.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(tabelView);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private com.booking_futsal.model.TabelModelCustom tabelModelCustom;
    private javax.swing.JTable tabelView;
    // End of variables declaration//GEN-END:variables
}
