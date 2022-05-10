package com.booking_futsal.view;

import com.booking_futsal.model.pemesanan.InputPemesanan;
import com.formdev.flatlaf.IntelliJTheme;

/**
 *
 * @author Kelompok 3
 */
// Class Frame utama 
public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();

        // implementasi method addInputListener pada FormPemesanan.java
        formPemesanan.addInputListener((InputPemesanan inputPemesanan) -> {
            // data pemesanan modelController diambil berdasarkan object inputPemesanan pada FormPemesanan.java
            modelController.addDataPemesanan(inputPemesanan); 
            
            tabelPemesanan.updateFieldTabel(); // Update Data tabel jika data pemesanan baru ditambahkan
        });

        // mengatur data pemesanan yang diambil dari modelController
        tabelPemesanan.setDataList(modelController.getDataPemesanan());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modelController = new com.booking_futsal.controller.ModelController();
        formPemesanan = new com.booking_futsal.model.FormPemesanan();
        tabelPemesanan = new com.booking_futsal.view.TabelPemesanan();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Frame - YST Futsal");
        getContentPane().add(formPemesanan, java.awt.BorderLayout.NORTH);
        getContentPane().add(tabelPemesanan, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        /* Mac Native Theme */
        try {
            IntelliJTheme.setup(MainFrame.class.getResourceAsStream("/mac-native-dark.theme.json")); // dark
//            IntelliJTheme.setup(MainFrame.class.getResourceAsStream("/mac-native-light.theme.json")); // light
        } catch (Exception e) {
        }

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.booking_futsal.model.FormPemesanan formPemesanan;
    private com.booking_futsal.controller.ModelController modelController;
    private com.booking_futsal.view.TabelPemesanan tabelPemesanan;
    // End of variables declaration//GEN-END:variables
}
