package com.booking_futsal.model;

import java.awt.Component;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author Kelompok 3
 */

// Class untuk Render format jam HH:mm --> dipanggil di FormPemesanan.java 
// pada method addHours() baris 414
public class DateFormattedListCellRenderer extends DefaultListCellRenderer {

    private DateFormat format;

    public DateFormattedListCellRenderer(DateFormat format) {
        this.format = format;
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof Date) {
            value = format.format((Date) value);
        }
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    }

}
