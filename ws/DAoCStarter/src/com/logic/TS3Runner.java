package com.logic;

import static com.data.DataClass.*;
import java.io.File;

/**
 * MADE IN ITALY
 * @author simone
 */
public class TS3Runner extends Thread {
	
	private String path;
	
	public TS3Runner(String path) {
		this.path = path;
	}
	
	@Override
	public void run() {
		try {
			new AUTOITLoader2();
			ProcessBuilder pb = new ProcessBuilder(
				TEMPORARY_DIR + File.separator + TS3S_EXE, path
			);
			pb.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
