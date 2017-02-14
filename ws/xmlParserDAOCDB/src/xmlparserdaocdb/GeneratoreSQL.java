package xmlparserdaocdb;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Simone
 */
public class GeneratoreSQL {
	
	private static Item item = null;
	
	public static void main(String[]args) {
		//stampo la testata
		//System.out.println("ogg_id,nome,slot,realm,lvl,effect1,amount1,effect2,amount2,effect3,amount3,effect4,amount4,effect5,amount5,effect6,amount6,effect7,amount7,effect8,amount8,effect9,amount9,effect10,amount10,imbue,use1,use2,note");
		String root = "c:\\z";
		File d = new File(root);
		//System.out.println("Verifico se la directory esiste: " + d.exists() );
		String a[] = d.list(); //creo un array di stringhe e lo riempio con la lista dei files presenti nella directory
		//System.out.println("stampo la lista dei files contenuti nella directory:");
		for (int i = 0; i < a.length; i++) {
			//System.out.println(root + File.separator + a[i]);
			try {
				estrapola(root + File.separator + a[i], false, i);
			}
			catch (Exception e) {
				estrapola(root + File.separator + a[i], true, i);
			}
		}
	}
	
	private static void estrapola(String filename, boolean isNew, int id) {
		//filename = "c:\\z\\Astral_Belt_of_Positive_Energy_6211_belt.xml";
		XmlParserDAOCDB ddp = new XmlParserDAOCDB();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			File xmlFile = new File(filename);
			Document document = builder.parse(xmlFile);
			item = new Item(id);
			ddp.printNodeInfo(document, item, isNew);
			item.chiudiOggetto();
			System.out.println(item.toString());
		} catch (SAXException sxe) {
			Exception  x = sxe;
			if (sxe.getException() != null)
				x = sxe.getException();
			x.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
