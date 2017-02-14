package com.gui;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * MADE IN ITALY
 * @author Simone
 */
public class IconMouseListener extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		Frame frame = SplashScreen.formPrincipale;
		if (frame.isVisible()) {
			frame.setVisible(false);
		}
        else {
			frame.setVisible(true);
			frame.setState(0);
		}
  }
}
