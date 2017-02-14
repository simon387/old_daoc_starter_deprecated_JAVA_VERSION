/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import static com.data.DataClass.*;
/**
 *
 * @author simone
 */
public class DolloaderLoader {
	
	public DolloaderLoader(String dest) {
		System.out.println("cartella di destinazione: " + dest);
		InputStream in = getClass().getResourceAsStream(RES_DOLLOADER_EXE);
		try {
			//System.out.println(in.available());
			//File f2 = new File(file + "\\handle.exe");
			//File fileDest = new File(TEMPORARY_DIR + File.separator + DOLLOADER_EXE);
			new File(dest + File.separator + DOLLOADER_EXE).delete();
			File fileDest = new File(dest + File.separator + DOLLOADER_EXE);
			try (OutputStream out = new FileOutputStream(fileDest, true)) {
				byte[] buff = new byte[1024];
				int len;
				while ((len = in.read(buff)) > 0) {
					out.write(buff, 0, len);
				}
				in.close();
			}
			System.out.println("file dolloader.exe copiato correttamente");
		}
		catch(Exception e) {
			System.out.println("errore nel copiare il file dolloader.exe");
		}
	}
}
