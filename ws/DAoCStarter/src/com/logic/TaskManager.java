package com.logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import static com.data.DataClass.*;
/**
 * MADE IN ITALY
 * @author Simone
 */
public class TaskManager {
	
	public static boolean isProcessRunning(int PID) {
		try {
			Process p = Runtime.getRuntime().exec(TASKLIST);
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			StringTokenizer st = null;
			while ((line = reader.readLine()) != null) {
				line = line.replace("\"", "");
				st = new StringTokenizer(line, ",");
				if (st.hasMoreElements()) {
					st.nextToken();
					if (st.hasMoreElements())
						if (Integer.parseInt(st.nextToken()) == PID)
							return true;
				}
			}
			
		}
		catch(Exception e) {
			System.err.println("errore in isProcessRunning");
		}
		return false;
	}
	
	public static boolean isProcessRunning(String serviceName) {
		try {
			Process p = Runtime.getRuntime().exec(TASKLIST);
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(serviceName)) {
					return true;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public static void killProcess(String serviceName) {
		try {
			Runtime.getRuntime().exec(KILL_NAME + serviceName + " /F");
		}
		catch (Exception e) {
			
		}
	}
	
	public static void killProcess(int PID) {
		try {
			Runtime.getRuntime().exec(KILL_PID + PID + " /F");
		}
		catch (Exception e) {
			
		}
	}
	
	/*
	 * ritorna un'ArrayList di PID dei processi con il nome serviceName
	 */
	public static ArrayList<Integer> processList(String serviceName) {
		/*
		 * C:\Documents and Settings\TS_BOT>tasklist /FI "IMAGENAME eq svchost.exe" /FO csv /NH
			"svchost.exe","896","Console","0","4.724 K"
			"svchost.exe","972","Console","0","4.084 K"
			"svchost.exe","1080","Console","0","20.824 K"
			"svchost.exe","1100","Console","0","3.836 K"
			"svchost.exe","1160","Console","0","4.280 K"
		 */
		ArrayList<Integer> list = new ArrayList();
		try {
			Process process = Runtime.getRuntime().exec(TLIST_TARGET.replace("?", serviceName));
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			StringTokenizer st;
			while ((line = reader.readLine()) != null) {
				line = line.replace("\"", "");
				st = new StringTokenizer(line, ",");
				if (st.hasMoreElements()) {
					st.nextToken();
					if (st.hasMoreElements())
						list.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
