package com.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

/**
 * MADE IN ITALY
 * @author Simone
 */
public class FormPrincipaleWindowStateListener implements WindowStateListener {
	
	@Override
	public void	windowStateChanged(WindowEvent windowEvent) {
		if (windowEvent.getOldState() == 0 && windowEvent.getNewState() == 1)
			SplashScreen.formPrincipale.setVisible(false);
	}
}
