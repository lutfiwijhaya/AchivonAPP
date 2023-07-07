/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomResource;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class GroupableTableHeaderRenderer implements TableCellRenderer {
    private final DefaultTableCellRenderer renderer;
    
    public GroupableTableHeaderRenderer() {
        renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        JComponent component = (JComponent) renderer.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);
        
        TableColumnModel columnModel = table.getColumnModel();
        if (column > 0) {
            TableColumn currentColumn = columnModel.getColumn(column);
            TableColumn previousColumn = columnModel.getColumn(column - 1);
            String currentValue = value.toString();
            String previousValue = previousColumn.getHeaderValue().toString();
            
            if (!currentValue.equals(previousValue)) {
                component.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            }
        }
        
        return component;
    }
}

