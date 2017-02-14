package com.logic;

import java.io.File;
/**
 * MADE IN ITALY
 * @author simone
 */
public class Patcher extends Thread{
	
	public static String path = null;
	
	@Override
	public void run() {
		try {
			Runtime.getRuntime().exec(path, null, new File(path.substring(0, path.length() - 11)));
		}
			catch (Exception e) {
		}
	}
}
