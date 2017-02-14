package com.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import static com.data.DataClass.*;
/**
 * MADE IN ITALY
 * @author simone
 */
public class IRCLoader {
	
	public IRCLoader() {
		InputStream in = getClass().getResourceAsStream(RES_WIRC_JAR);
		try {
			new File(TEMPORARY_DIR + File.separator + WIRC_JAR).delete();
			File fileDest = new File(TEMPORARY_DIR + File.separator + WIRC_JAR);
			try (OutputStream out = new FileOutputStream(fileDest, true)) {
				byte[] buff = new byte[1024];
				int len;
				while ((len = in.read(buff)) > 0) {
					out.write(buff, 0, len);
				}
				in.close();
			}
			System.out.println("file wIRC_JAR copiato correttamente");
		}
		catch(Exception e) {
			System.out.println("errore nel copiare il file wIRC_JAR");
		}
	}
}
