package com.gui;

import static com.data.DataClass.DEBUG_MODE;
/**
 * MADE IN ITALY
 * @author simone
 */
public class InfoDisplayer extends Thread {
	
	private long millisecondi = System.currentTimeMillis();
	
	@Override
	public void run() {
		while (true) {
			try {
				InfoDisplayer.sleep(500);
				if ((System.currentTimeMillis() - millisecondi) > 3000) {
					FormPrincipale.setMessage("Ready");
				}
			}
			catch (Exception e) {
				System.out.println("errore nel thread InfoDisplayer");
				e.printStackTrace();
			}
		}
	}
	
	public void putMessage(String message) {
		if (DEBUG_MODE)
			System.out.println("Message: " + message);
		try {
			FormPrincipale.setMessage(message);
		}
		catch (Exception e ) {
			e.printStackTrace();
		}
		millisecondi = System.currentTimeMillis();
	}
}