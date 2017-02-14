package com.logic;

import java.io.File;
import java.io.IOException;
import org.ini4j.Wini;
import static com.data.DataClass.ISWIN;
import org.ini4j.Config;

/**
 * MADE IN ITALY
 * @author simone
 */
public class WiniWithCheck extends Wini{
	
	WiniWithCheck(File file) throws IOException {
		super(file);
	}
	
	public String put(String s1, String s2, int i1) {
		if (ISWIN) {
			return super.put(s2, s2, i1);
		}
		else {
			return null;
		}
	}
	
	public void put(String s1, String s2, String s3) {
		if (ISWIN) {
			 super.put(s1, s1, s3);
		}
		
	}
	
	public void store() {
		if (ISWIN) {
			try {
				super.store();
			}
			catch (Exception e) {
				
			}
		}
	}
	
	public <T extends Object> T get(Object sectionName, Object optionName, Class<T> clazz) {
		if (ISWIN)
			return super.get(sectionName, optionName, clazz);
		else
			return null;
	}
	
	public Config getConfig() {
		if (ISWIN)
			return super.getConfig();
		else
			return null;
	}
	
	public void setConfig(Config config) {
		if (ISWIN)
			super.setConfig(config);
	}
}
