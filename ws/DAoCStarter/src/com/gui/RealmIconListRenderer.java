package com.gui;

import com.data.Toon;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import static com.data.DataClass.*;
/**
 * MADE IN ITALY
 * @author Simone
 */
public class RealmIconListRenderer extends DefaultListCellRenderer {
	
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, 
													boolean isSelected, boolean cellHasFocus) {
		
		// Get the renderer component from parent class
		JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		// Get icon to use for the list item value
		if (value instanceof Toon) {
			Toon toon = (Toon)value;
			switch (toon.getRealm()) {
				case 1:
					label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ALB_ICON))));
					break;
				case 2:
					label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(MID_ICON))));
					break;
				default:
					label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(HIB_ICON))));
			}
		}
		return label;
	}
}