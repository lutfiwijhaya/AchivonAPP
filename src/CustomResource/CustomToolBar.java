/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomResource;

import javax.swing.*;

public class CustomToolBar extends JToolBar {
    public CustomToolBar() {
        super();
        add(new JButton("Button 1"));
        add(new JButton("Button 2"));
        add(new JButton("Button 3"));
    }

    @Override
    public java.awt.Dimension getPreferredSize() {
        return new java.awt.Dimension(200, 30);
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Customize the appearance of the toolbar here
    }
}
