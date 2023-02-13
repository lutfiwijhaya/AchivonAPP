/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomResource;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class MultiLineHeaderRender extends JTableHeader implements TableCellRenderer {
    public MultiLineHeaderRender() {
        setDefaultRenderer(new DefaultTableCellRenderer());
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
        return getDefaultRenderer().getTableCellRendererComponent(table, value,
            isSelected, hasFocus, row, column);
    }
    
//    JTable table = new JTable();
//    table.getTableHeader().setDefaultRenderer(new MultiLineHeaderRenderer());

}
