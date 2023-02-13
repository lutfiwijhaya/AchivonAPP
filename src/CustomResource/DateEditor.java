/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomResource;

import java.awt.Component;
import java.util.Date;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import com.toedter.calendar.JDateChooser;

public class DateEditor extends AbstractCellEditor implements TableCellEditor {
    private JDateChooser dateChooser = new JDateChooser();

    @Override
    public Object getCellEditorValue() {
        return dateChooser.getDate();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        dateChooser.setDate((Date)value);
        return dateChooser;
    }
    
    
//    JTable table = new JTable();
//    table.getColumnModel().getColumn(columnIndex).setCellEditor(new DateEditor());

}

