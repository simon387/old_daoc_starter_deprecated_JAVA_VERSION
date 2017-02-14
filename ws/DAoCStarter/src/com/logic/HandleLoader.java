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
public class HandleLoader {
	
	public HandleLoader() {
		InputStream in = getClass().getResourceAsStream(RES_HANDLE_EXE);
		try {
			new File(TEMPORARY_DIR + File.separator + HANDLE_EXE).delete();
			File fileDest = new File(TEMPORARY_DIR + File.separator + HANDLE_EXE);
			try (OutputStream out = new FileOutputStream(fileDest, true)) {
				byte[] buff = new byte[1024];
				int len;
				while ((len = in.read(buff)) > 0) {
					out.write(buff, 0, len);
				}
				in.close();
			}
			System.out.println("file handle.exe copiato correttamente");
		}
		catch(Exception e) {
			System.out.println("errore nel copiare il file handle.exe");
			e.printStackTrace();
		}
	}
}
