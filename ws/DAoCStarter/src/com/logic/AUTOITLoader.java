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
public class AUTOITLoader {
	
	public AUTOITLoader() {
		InputStream in = getClass().getResourceAsStream(RES_STARTER_EXE);
		try {
			new File(TEMPORARY_DIR + File.separator + STARTER_EXE).delete();
			File fileDest = new File(TEMPORARY_DIR + File.separator + STARTER_EXE);
			OutputStream out = new FileOutputStream(fileDest, true);
			byte[] buff = new byte[1024];
			int len;
			while ((len = in.read(buff)) > 0) {
				out.write(buff, 0, len);
			}
			in.close();
			out.close();
			System.out.println("file starter.exe copiato correttamente");
		}
		catch(Exception e) {
			System.out.println("errore nel copiare il file starter.exe");
		}
	}
}
