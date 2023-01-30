/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author USER
 */
public class celleditor extends DefaultCellEditor {

    public celleditor() {
        super(new JCheckBox());
    }

    

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
       panelbutton action = new panelbutton();
       action.setBackground(table.getSelectionBackground());
       return action;
    }
    
    
}
