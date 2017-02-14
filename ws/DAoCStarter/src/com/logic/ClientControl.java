package com.logic;

import com.data.DataClass;
import com.gui.FormPrincipale;
import java.util.ArrayList;
import static com.data.DataClass.GAME_DLL;
import com.gui.FormKill;
/**
 * MADE IN ITALY
 * @author Simone
 */
public class ClientControl extends Thread {
	
	@Override
	public void run() {
		while (true) {
			try {
				ClientControl.sleep(500);
				
				
				for (Client client:DataClass.clientSet) {
					if (!TaskManager.isProcessRunning(client.PID)) {
						DataClass.clientSet.remove(client);
						FormKill.listRefrescher();
					}
				}
				
				ArrayList<Integer> list = TaskManager.processList(GAME_DLL);
				for (int i = 0; i < list.size(); i++) {
					Client client = new Client(list.get(i), null, null);
					DataClass.clientSet.add(client);
					FormKill.listRefrescher();
	
				}
				if (TaskManager.isProcessRunning(GAME_DLL)) {
					FormPrincipale.enableKill(true);
				}
				else {
					FormPrincipale.enableKill(false);
				}
				
			}
			catch(Exception e) {
				System.out.println("errore nel thread di controllo");
				e.printStackTrace();
			}
		}
	}
}
