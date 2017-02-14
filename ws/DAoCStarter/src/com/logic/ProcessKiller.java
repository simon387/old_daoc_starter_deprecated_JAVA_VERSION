package com.logic;

import java.util.ArrayList;
import static com.data.DataClass.*;
/**
 * MADE IN ITALY
 * @author Simone
 */
public class ProcessKiller extends Thread {
	
	@Override
	public void run() {
			try {
				while (TaskManager.isProcessRunning(CAMELOT_EXE)) {
					TaskManager.killProcess(CAMELOT_EXE);
				}
				while (TaskManager.isProcessRunning(LOGIN_DLL)) {
					TaskManager.killProcess(LOGIN_DLL);
				}
				while (TaskManager.isProcessRunning(CAMELOT_BIN)) {
					TaskManager.killProcess(CAMELOT_BIN);
				}
				ArrayList<Integer> a = TaskManager.processList(GAME_DLL);
				for (int i = 0; i < a.size(); i++) {
					TaskManager.killProcess(a.get(i));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
}
