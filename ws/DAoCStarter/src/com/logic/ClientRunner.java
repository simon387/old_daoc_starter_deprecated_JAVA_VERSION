package com.logic;

import com.data.Account;
import static com.data.DataClass.*;
import com.data.Toon;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * MADE IN ITALY
 * @author simone
 */
public class ClientRunner extends Thread {
	
	private Account account;
	private Toon toon;
	private String wdir;
	
	public ClientRunner(Account account, Toon toon, String wdir) {
		this.account = account;
		this.toon    = toon;
		this.wdir    = wdir;
	}
	
	@Override
	public void run() {
		try {
			if (toon == null) {
				toon = new Toon();
				toon.setNome(null);
			}
			String mode = (toon instanceof Toon) ? "1":"0";
			int PID = 0;
			String path = wdir + LOGIN_DLL;
			String nomeAccount = account.getName();
			String passAccount = account.getPassword();
			new AUTOITLoader();
			ProcessBuilder pb = new ProcessBuilder(
				TEMPORARY_DIR + File.separator + STARTER_EXE,
				wdir,
				path,
				nomeAccount,
				passAccount,
				mode
			);
			Process process = pb.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println("line: " + line);
				if (isNumeric(line)) {
					PID = Integer.parseInt(line);
					Client client = new Client(PID, account.getName(), toon.getNome());
					clientSet.add(client);
					System.out.println("questo ramo di codice non è rotto!");
				}
				System.out.println(line);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		DAoCStarter.riportaAudio();
	}
	
	private static boolean isNumeric(String str) {  
		try {  
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe) {  
			return false;  
		}  
		return true;  
	}
}
