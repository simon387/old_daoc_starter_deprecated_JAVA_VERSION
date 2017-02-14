package com.logic;

import com.data.Account;
import com.data.AccountJpaController;
import com.data.Classi;
import com.data.ClassiJpaController;
import com.data.Servers;
import com.data.ServersJpaController;
import com.data.Settings;
import com.data.SettingsJpaController;
import com.data.Toon;
import com.data.ToonJpaController;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import org.ini4j.Wini;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import javax.swing.ListModel;
import javax.swing.filechooser.FileFilter;
import org.ini4j.Config;
import static com.data.DataClass.*;
import static com.gui.FormPrincipale.infoDisplayer;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
/**
 * MADE IN ITALY
 * @author simone
 * 
 * killare tutto prima del lauuncher
 */
public class DAoCStarter {
	private static EntityManagerFactory  emf;
	private static SettingsJpaController sjp;
	private static AccountJpaController  ajp;
	private static ToonJpaController     tjp;
	private static ServersJpaController  rjp;
	private static ClassiJpaController   cjp;
	private static Settings settings;
	private static File userdd;
	//private static WiniWithCheck ini;
	private static Wini ini;
	private static Process pNotepad = null;
	private static int audio = 10;
	
	public static void initialize() {
		initializeDBConnection();  // inizializzo la connessione con il database
		//readSettings();            // leggo i settings dal db, inizializzo userdd e ini
		setupSettings();
		if (ISWIN) new ClientControl().start();
	}

	public static void start(String resolution, boolean isFullscreen, Toon toon, Account account, Component component) {
		try {
			//if (ISWIN) {
				audio = ini.get("sound", "item1", Integer.class);
				ini.put("sound", "item1", "10");
				ini.store();
				setResolution(resolution);
				setWindowed(isFullscreen);
			//}
			
			if (settings.getOfficialpath() == null & (account == null || account.getType() == 0)) {//no acc o off
				if (!pathSetter(component, true)) return;
			}
			if (settings.getShardpath()    == null & (account != null && account.getType() == 1)) {//shard
				if (!pathSetter(component, false)) return;
			}

			mutantCleaner();
			
			if (account == null) {
				infoDisplayer.putMessage("Nothing selected");
				String path = settings.getOfficialpath();
				path = path.substring(0, path.length() - 11);
				Process process  = Runtime.getRuntime().exec(path + LOGIN_DLL, null, new File(path));
				return;
			}
			
			if (account.getType() == 1 && toon != null) {
				infoDisplayer.putMessage("Shard mode activated");
				String dest = settings.getShardpath().substring(0, settings.getShardpath().length() - 11);
				DolloaderLoader dolloaderLoader = new DolloaderLoader(dest);
				String s = settings.getShardpath();
				s = "\"" + s.substring(0, s.length() - 11) + GAME_DLL + "\"";
				/*System.out.println(
						  dest + File.separator + DOLLOADER_EXE + " " +
						  s + " " +
						  toon.getIp() +  " " +
						  toon.getPort() + " " +
						  toon.getRealm() +  " " +
						  account.getName() +  " " +
						  account.getPassword());*/
				
				ProcessBuilder pb = new ProcessBuilder(
						  dest + File.separator + DOLLOADER_EXE,
						  s,
						  toon.getIp(),
						  String.valueOf(toon.getPort()),
						  String.valueOf(toon.getRealm()),
						  account.getName(),
						  account.getPassword());
				pb.start();
				return;
			}
			
			if ((toon == null) && account.getType() == 0) {
				infoDisplayer.putMessage("Official mode activated");
				ini.put("quick", "setentry", 0);
				ini.store();
				runClient(account, null);
				return;
			}
			
			if ((toon != null) && account.getType() == 0) {
				infoDisplayer.putMessage("Official mode activated");
				String nomeToon = toon.getNome();
				String nomeServer = toon.getServer();
				String stringIP = toon.getIp();
				int    intPorta = toon.getPort();
				int    intReame = toon.getRealm();
				int    serverID = toon.getServerid();
				String string = nomeToon   + ", " +
								nomeServer + ", " +
								stringIP   + ", " +
								intPorta   + ", " +
								intReame   + ", " + 
								serverID;
				//System.out.println(string);
				ini.put("quick", "setentry", 1);
				ini.put("quick", "entry0", string);
				ini.store();
				runClient(account, toon);
			}
			
		}
		catch (Exception e) {
			infoDisplayer.putMessage("Error on starting");
			e.printStackTrace();
		}
		
	}
	
	private static void runClient(Account account, Toon toon) {
		try {
			ClientRunner clientRunner = new ClientRunner(account, toon,
					  settings.getOfficialpath().substring(0,
					  settings.getOfficialpath().length() - 11));
			clientRunner.start();
			if (toon instanceof Toon) {
				settings.setLastchar(toon.getId());
			}
		}
		catch (Exception e) {
			infoDisplayer.putMessage("Error on running client");
			e.printStackTrace();
		}
	}
	
	public static void riportaAudio() {//e gestore quit on start
		try {
			ini.put("sound", "item1", audio);
			ini.store();	
			if (settings.getQuitonstart() == 1) 	stoQuittando(null);
		}
		catch (Exception e) {
			infoDisplayer.putMessage("Error on riportaAudio()");
			e.printStackTrace();
		}
	}
	
	public static void patch(Component component) {
		try {
			if (settings.getOfficialpath() == null)
				if (!pathSetter(component, true))
					return;
			Patcher.path = settings.getOfficialpath();
			new Patcher().start();
		}
		catch (Exception e) {
			infoDisplayer.putMessage("Error on patch procedure");
			e.printStackTrace();
		}
	}
	
	public static Object getLastToon() {
		try {
			int integer = settings.getLastchar();
			if ( integer > 0) {
				if (tjp.findToon(integer) instanceof Toon)
					return tjp.findToon(integer);
			}
				
		}
		catch (Exception e) {
			//infoDisplayer.putMessage("Error on getLastToon()");
			System.out.println("error on getLastToon()");
			//e.printStackTrace();
			return "No Thank You";
		}
		return "No Thank You";
	}
	
	public static Object getLastAccount() {
		Account account;
		try {
			int integer = settings.getLastchar();
			if (integer > 0) {
				if (tjp.findToon(integer) instanceof Toon) {
					account = ajp.findAccount(tjp.findToon(integer).getAccount());
					return account;
				}
			}
				
		}
		catch (Exception e) {
			//infoDisplayer.putMessage("Error on getLastAccount()");
			System.out.println("Error on getLastAccount()");
			//e.printStackTrace();
			return "No Account Selected";
		}
		return "No Account Selected";
	}
	
	public static void mutantCleaner() {
		try {
			new HandleLoader();
			ArrayList<Integer> arrayList = TaskManager.processList(GAME_DLL);
			if (!arrayList.isEmpty()) {
				Process process;
				String line, line2;
				StringTokenizer hex;
				for (int i = 0; i < arrayList.size(); i++) {
					process = Runtime.getRuntime().exec(
							  TEMPORARY_DIR + File.separator + HANDLE_EXE + " -a -p " + arrayList.get(i));
					BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
					while ((line = reader.readLine()) != null) {
						if (line.contains(MUTEX)) {
							//System.out.println(line);
							line = line.replace(" ", "");
							hex = new StringTokenizer(line, ":");
							Process p = Runtime.getRuntime().exec(
									  TEMPORARY_DIR + File.separator + HANDLE_EXE + 
									  " -c " + hex.nextToken() + " -y -p " + 
									  arrayList.get(i));
							BufferedReader reader2 = new BufferedReader(
									  new InputStreamReader(p.getInputStream()));
							while ((line2 = reader2.readLine()) != null) {
								//System.out.println(line2);
							}
							//System.out.println("mutante morto");
						}
					}
				}
			}
			else {
				infoDisplayer.putMessage("No clients running");
			}
		}
		catch(Exception e) {
			infoDisplayer.putMessage("Error on killing mutants");
			e.printStackTrace();
		}
	}
	
	public static void clearMemory() {
		if (ISWIN) new ProcessKiller().start();
	}

	public static void stoQuittando(Point point) {
		try {
			if (point != null) {
				settings.setCoo1(point.x);
				settings.setCoo2(point.y);
				sjp.edit(settings);
			}
			try {
				if (pNotepad != null)
					pNotepad.destroy();
			}
			catch (Exception e) {
				infoDisplayer.putMessage("Error on killing notepad.exe");
				e.printStackTrace();
			}
		}
		catch(Exception e) {
			infoDisplayer.putMessage("DB wirte point error");
			e.printStackTrace();
		}
		System.exit(0);
    }

	public static boolean pathSetter(Component component, boolean isOfficial) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.removeChoosableFileFilter(jfc.getFileFilter());
		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File file) {
				if (file.getName().equals(CAMELOT_EXE) || file.isDirectory())
					return true;
				else
					return false;
			}
			@Override
			public String getDescription() {
				return CAMELOT_EXE;
			}
		};
		jfc.setFileFilter(fileFilter);
		if (isOfficial)
			jfc.setDialogTitle("Select camelot.exe for official servers");
		else
			jfc.setDialogTitle("Select camelot.exe for shard servers");
		if( jfc.showOpenDialog(component) == JFileChooser.APPROVE_OPTION ) {//if (!jfc.getSelectedFile().getAbsolutePath().equals("")) {
			try {
				if (isOfficial)
					settings.setOfficialpath(jfc.getSelectedFile().getAbsolutePath());
				else
					settings.setShardpath(jfc.getSelectedFile().getAbsolutePath());
				sjp.edit(settings);
				return true;
			}
			catch (Exception e) {
				infoDisplayer.putMessage("DB error");
				e.printStackTrace();
				return false;
			}
		}
		else {
			return false;
		}
	}

	public static boolean editVentPath(Component component) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.removeChoosableFileFilter(jfc.getFileFilter());
		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File file) {
				if (file.getName().equals(VENTRILO_EXE) || file.isDirectory())
					return true;
				else
					return false;
			}
			@Override
			public String getDescription() {
				return VENTRILO_EXE;
			}
		};
		jfc.setFileFilter(fileFilter);
		jfc.setDialogTitle("Select ventrilo.exe");
		if( jfc.showOpenDialog(component) == JFileChooser.APPROVE_OPTION ) {//if (!jfc.getSelectedFile().getAbsolutePath().equals("")) {
			try {
				settings.setVentpath(jfc.getSelectedFile().getAbsolutePath());
				sjp.edit(settings);
				return true;
			}
			catch (Exception e) {
				infoDisplayer.putMessage("DB error");
				e.printStackTrace();
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean editTS3Path(Component component) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.removeChoosableFileFilter(jfc.getFileFilter());
		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File file) {
				if (file.getName().equals(TS3CLIENT_WIN32_EXE) ||
					 file.getName().equals(TS3CLIENT_WIN64_EXE) ||
					 file.isDirectory())
					return true;
				else
					return false;
			}
			@Override
			public String getDescription() {
				return TS3CLIENT_WIN32_EXE + ", " + TS3CLIENT_WIN64_EXE;
			}
		};
		jfc.setFileFilter(fileFilter);
		jfc.setDialogTitle("Select the TS3client.exe");
		if( jfc.showOpenDialog(component) == JFileChooser.APPROVE_OPTION ) {//if (!jfc.getSelectedFile().getAbsolutePath().equals("")) {
			try {
				settings.setTs3path(jfc.getSelectedFile().getAbsolutePath());
				sjp.edit(settings);
				return true;
			}
			catch (Exception e) {
				infoDisplayer.putMessage("DB error");
				e.printStackTrace();
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static void startVent(Component component) {
		try {
			if (settings.getVentpath() == null)
				editVentPath(component);
			if (settings.getVentpath() != null) {
				String string = settings.getVentpath();
				Runtime.getRuntime().exec(string, null, new File(string.substring(0, string.length() - 12)));
			}
		}
		catch (Exception e) {
			infoDisplayer.putMessage("Error on Vent start");
			e.printStackTrace();
		}
	}
	
	public static void startTS3(Component component) {
		try {
			if (settings.getTs3path() == null)
				editTS3Path(component);
			if (settings.getTs3path() != null) {
				TS3Runner tS3Runner = new TS3Runner(settings.getTs3path());
				tS3Runner.start();
			}
		}
		catch (Exception e) {
			infoDisplayer.putMessage("Error on TS3 start");
			e.printStackTrace();
		}
	}
	
	public static Point getPosition() {
		Point point = new Point(0, 0);
		try {
			 point.x = settings.getCoo1();
			 point.y = settings.getCoo2();
		}
		catch(Exception e) {
			return point;
			//infoDisplayer.putMessage("DB error");
			//e.printStackTrace();
		}
		return point;
    }
	
	public static Toon getToon(int id) {
		Toon toon = null;
		try {
			toon = tjp.findToon(id);
		}
		catch (Exception e) {
			infoDisplayer.putMessage("DB error");
			e.printStackTrace();
		}
		return toon;
	}
	
	public static void addToon(String nome, int account, Servers server, String realm,
										String classe, String resolution, boolean isSelected) {
		try {
			int intRealm = 1;
			int intIsSelected = 0;
			if (isSelected) intIsSelected = 1;
			switch (realm) {
				case "Albion":		intRealm = 1;	break;
				case "Hibernia":	intRealm = 3;	break;
				case "Midgard":	intRealm = 2;	break;
			}
			Toon toon = new Toon();
			toon.setNome(nome);
			toon.setServer(server.getNome());
			toon.setIp(server.getIndirizzo());
			toon.setPort(server.getPorta());
			toon.setRealm(intRealm);
			toon.setServerid(server.getSid());
			toon.setAccount(account);
			toon.setClasse(classe);
			toon.setResolution(resolution);
			toon.setWindowed(intIsSelected);
			tjp.create(toon);
		}
		catch(Exception e) {
			infoDisplayer.putMessage("DB error");
			e.printStackTrace();
		}
	}
	
	public static DefaultComboBoxModel getServers() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		try {
			for (int i = 0; i < rjp.getServersCount(); i++) {
				model.addElement(rjp.findServers(i));
			}
		}
		catch(Exception e) {
			infoDisplayer.putMessage("DB error");
			e.printStackTrace();
		}
		return model;
	}
	
	public static Servers getServer(String string) {
		Servers servers = null;
		try {
			switch(string) {
				case "Ywain1" :	servers = rjp.findServers(0);	break;
				case "Ywain2" :	servers = rjp.findServers(1);	break;
				case "Ywain3" :	servers = rjp.findServers(2);	break;
				case "Ywain4" :	servers = rjp.findServers(3);	break;
				case "Ywain5" :	servers = rjp.findServers(4);	break;
				case "Ywain6" :	servers = rjp.findServers(5);	break;
				case "Ywain7" :	servers = rjp.findServers(6);	break;
				case "Ywain8" :	servers = rjp.findServers(7);	break;
				case "Ywain9" :	servers = rjp.findServers(8);	break;
				case "Ywain10":	servers = rjp.findServers(9);	break;
				default :			servers = rjp.findServers(10);
			}
		}
		catch (Exception e) {
			infoDisplayer.putMessage("DB error");
			e.printStackTrace();
		}
		finally {
			return servers;
		}
	}
	
	public static void editToon(Toon toon) {
		try {
			tjp.edit(toon);
		}
		catch (Exception e) {
			infoDisplayer.putMessage("DB error");
			e.printStackTrace();
		}
	}
	
	public static String [] refreshAdvancedOption() {
		String [] array = new String[14];
		try {
			if (settings.getVolume() == 1)
				array[0] = "on";
			else
				array[0] = "off";
			int temp = Integer.parseInt(ini.get("sound","item4", String.class));
			switch (temp) {
				case 0:		array[1] = "full";								break;
				case 10:		array[1] = "off";									break;
				default:		array[1] = Integer.toString(10 - temp);
			}
			temp = Integer.parseInt(ini.get("sound","item3", String.class));
			switch (temp) {
				case 0:		array[2] = "full";								break;
				case 10:		array[2] = "off";									break;
				default:		array[2] = Integer.toString(10 - temp);
			}
			temp = Integer.parseInt(ini.get("sound","item2", String.class));
			switch (temp) {
				case 0:	array[3] = "full";break;
				case 10:	array[3] = "off";	break;
				default:	array[3] = Integer.toString(10 - temp);
			}
			temp = Integer.parseInt(ini.get("sound","item1", String.class));
			switch (temp) {
				case 0:	array[4] = "full";	break;
				case 10:	array[4] = "off";	break;
				default:	array[4] = Integer.toString(10 - temp);
			}
			temp = Integer.parseInt(ini.get("performance", "item7", String.class));
			switch (temp) {
				case 1:	array[5] =  "background";	break;
				case 2:	array[5] = "never";	break;
				case 0:	array[5] = "minimized";
			}
			temp = Integer.parseInt(ini.get("shadows", "item2", String.class));
			switch (temp) {
				case 4:	array[6] = "none";	break;
				case 0:	array[6] = "all figures";	break;
				case 1:	array[6] = "self only";	break;
				case 2:	array[6] = "near 5 figures";	break;
				case 3:	array[6] = "near 10 figures";
			}
			temp = Integer.parseInt(ini.get("shadows", "item1", String.class));
			switch (temp) {
				case 0:	array[7] = "on";	break;
				case 2:	array[7] = "low";	break;
				case 1:	array[7] = "high";
			}
			temp = Integer.parseInt(ini.get("water", "item1", String.class));
			switch (temp) {
				case 2:	array[8] = "SI";	break;
				case 1:	array[8] = "classic";	break;
				case 0:	array[8] = "reflective";
			}
			temp = Integer.parseInt(ini.get("water", "item3", String.class));
			switch (temp) {
				case 2:	array[9] = "low";	break;
				case 1:	array[9] = "medium";	break;
				case 0:	array[9] = "high";
			}
			temp = Integer.parseInt(ini.get("water", "item2", String.class));
			switch (temp) {
				case 0:	array[10] = "often";	break;
				case 1:	array[10] = "occasional";	break;
				case 2:	array[10] = "seldom";
			}
			temp = Integer.parseInt(ini.get("atlantis_internal", "item2", String.class));
			switch (temp) {
				case 0:	array[11] = "on";	break;
				case 1:	array[11] = "off";
			}
			temp = Integer.parseInt(ini.get("atlantis_internal", "item1", String.class));
			switch (temp) {
				case 0:	array[12] = "on";	break;	
				case 1:	array[12] = "off";
			}
			temp = Integer.parseInt(ini.get("character_version", "9-0", String.class));
			switch (temp) {
				case 0:	array[13] = "classic";	break;
				case 1:	array[13] = "catacombs";
			}
		}
		catch(Exception e) {
			infoDisplayer.putMessage("DB error");
			e.printStackTrace();
		}
		finally {
			return array;
		}
	 }
	
	public static void optionChanged(int flag, String value) {
		try {
			switch (flag) {
				case 1:
					if (value.equals("on")) {
						settings.setVolume(1);
						ini.put("sound", "item1", settings.getZsounditem1());
						ini.put("sound", "item2", settings.getZsounditem2());
						ini.put("sound", "item3", settings.getZsounditem3());
						ini.put("sound", "item4", settings.getZsounditem4());
					}
					else {
						settings.setVolume(0);
						settings.setZsounditem1(Integer.parseInt(ini.get("sound", "item1", String.class)));
						settings.setZsounditem2(Integer.parseInt(ini.get("sound", "item2", String.class)));
						settings.setZsounditem3(Integer.parseInt(ini.get("sound", "item3", String.class)));
						settings.setZsounditem4(Integer.parseInt(ini.get("sound", "item4", String.class)));
						ini.put("sound", "item1", 10);
						ini.put("sound", "item2", 10);
						ini.put("sound", "item3", 10);
						ini.put("sound", "item4", 10);
					}
					break;
				case 2:
					switch (value) {
						case "full":	ini.put("sound", "item4", 0);	break;
						case "off":	ini.put("sound", "item4", 10);		break;
						default:	ini.put("sound", "item4", -1 * (Integer.parseInt(value) - 10));
					}
					break;
				case 3:
					switch (value) {
						case "full":	ini.put("sound", "item3", 0);	break;
						case "off":	ini.put("sound", "item3", 10);	break;
						default:	ini.put("sound", "item3", -1 * (Integer.parseInt(value) - 10));
					}
					break;
				case 4:
					switch (value) {
						case "full":ini.put("sound", "item2", 0);	break;
						case "off":	ini.put("sound", "item2", 10);		break;
						default :	ini.put("sound", "item2", -1 * (Integer.parseInt(value) - 10));
					}
					break;
				case 5:
					switch (value) {
						case "full":	ini.put("sound", "item1", 0);	break;
						case "off":	ini.put("sound", "item1", 10);	break;
						default :ini.put("sound", "item1", -1 * (Integer.parseInt(value) - 10));
					}
					break;
				case 6:
					switch (value) {
						case "background":	ini.put("performance", "item7", 1);	break;
						case "minimized":	ini.put("performance", "item7", 0);	break;
						case "never":	ini.put("performance", "item7", 2);
					}
					break;
				case 7:
					switch (value) {
						case "none":	ini.put("shadows", "item2", 4);	break;
						case "all figures":	ini.put("shadows", "item2", 0);	break;
						case "self only":	ini.put("shadows", "item2", 1);	break;
						case "near 5 figures":	ini.put("shadows", "item2", 2);	break;
						case "near 10 figures":	ini.put("shadows", "item2", 3);
					}
					break;
				case 8:
					switch (value) {
						case "on":	ini.put("shadows", "item1", 0);	break;
						case "high":	ini.put("shadows", "item1", 1);	break;
						case "low":	ini.put("shadows", "item1", 2);
					}
					break;
				case 9:
					switch (value) {
						case "classic":ini.put("water", "item1", 1);	break;
						case "SI":	ini.put("water", "item1", 2);	break;
						case "reflective":	ini.put("water", "item1", 0);
					}
					break;
				case 10://low medium high
					switch (value) {
						case "low":	ini.put("water", "item3", 2);	break;
						case "medium":	ini.put("water", "item3", 1);	break;
						case "high":	ini.put("water", "item3", 0);
					}
					break;
				case 11://often occasional seldom
					switch (value) {
						case "often":ini.put("water", "item2", 0);break;
						case "occasional":ini.put("water", "item2", 1);break;
						case "seldom":ini.put("water", "item2", 2);
					}
					break;
				case 12://on off //terrain
					if (value.equals("on"))
						ini.put("atlantis_internal", "item2", 0);
					else 
						ini.put("atlantis_internal", "item2", 1);
					break;
				case 13://on off //tree
					if (value.equals("on")) 
						ini.put("atlantis_internal", "item1", 0);
					else 
						ini.put("atlantis_internal", "item1", 1);
					break;
				case 14://classic catacombs
					int temp = 1;
					if (value.equals("classic"))
						temp = 0;
					ini.put("character_version", "500-0", temp);
					for (int i = 0; i < 20; i++) {
						ini.put("character_version", i + "-0", temp);
						ini.put("character_version", i + "-1", temp);
					}
					break;
				default :
					infoDisplayer.putMessage("internal case error");
			}
			ini.store();
			sjp.edit(settings);
		}
		catch(Exception e ) {
			infoDisplayer.putMessage("DB error");
			e.printStackTrace();
			try {
				sjp.edit(settings);
			}
			catch(Exception x) {
				infoDisplayer.putMessage("DB error");
				e.printStackTrace();
			}
		}
	}

	public static void backUp(File screensh, File settings) {
		try {
			JFileChooser fr = new JFileChooser();
			FileSystemView fw = fr.getFileSystemView();
			File src = new File(fw.getDefaultDirectory() + SCREEN_DIR);
			if (!src.exists())
				infoDisplayer.putMessage("File not found!");
			copyFolder(src, screensh);
			src = new File(USER_DIR);
			if (!src.exists())
				infoDisplayer.putMessage("File not found!");
			copyFolder(src, settings);
		}
		catch(Exception e) {
			infoDisplayer.putMessage("Back up error");
			e.printStackTrace();
		}
	}
	
	public static void openUDD() {
		try {
			try {
				pNotepad.destroy();
			}
			catch (Exception e) {}
			pNotepad = new ProcessBuilder(NOTEPAD_EXE, userdd.toString()).start();
		}
		catch (Exception e) {
			infoDisplayer.putMessage("Error on user.dat");
			e.printStackTrace();
		}
	}
	
	public static boolean isOnTop() {
		boolean isOnTop = false;
		try {
			if (settings.getOntop() == 1)	isOnTop = true;
		}
		catch (Exception e) {
			System.out.println("DB error");
			//infoDisplayer.putMessage("DB error");
			//e.printStackTrace();
			return false;
		}
		return isOnTop;
    }

	public static void setOnTop(boolean selected) {
		try {
			 if (selected)
				settings.setOntop(1);
			 else
				settings.setOntop(0);
			 sjp.edit(settings);
		}
		catch (Exception e) {
			infoDisplayer.putMessage("DB error");
			e.printStackTrace();
		}
	}
	
	public static void openSD() {
		try {
			Desktop.getDesktop().open(new File(USER_DIR));
		}
		catch (Exception e) {
			infoDisplayer.putMessage("user_dir error");
			e.printStackTrace();
		}
	}
	
	public static void openSS() {
		try {
			JFileChooser fr = new JFileChooser();
			FileSystemView fw = fr.getFileSystemView();
			String string = fw.getDefaultDirectory() + SCREEN_DIR;
			Desktop.getDesktop().open(new File(string));
		}
		catch (Exception e) {
			infoDisplayer.putMessage("System error");
			e.printStackTrace();
		}
	}

	public static void setResolution(String string) {
		if (ISWIN) {
			try {
				StringTokenizer st = new StringTokenizer(string, " ");
				ini.put("main", "screen_width", st.nextToken());
				ini.put("main", "screen_height", st.nextToken());
				ini.store();
			} catch (Exception e) {
				infoDisplayer.putMessage("user.dat error");
				e.printStackTrace();
			}
		}
	}

	public static void setWindowed(boolean setted) {
		if (ISWIN) {
			try {
				if (setted) 
					 ini.put("main", "windowed", 0);
				else 
					ini.put("main", "windowed", 1);
				ini.store();
			}
			catch (Exception e) {
				 infoDisplayer.putMessage("user.dat error");
				 e.printStackTrace();
			}
		}
	}

	private static void initializeDBConnection() {
		try {
			 emf = Persistence.createEntityManagerFactory("DAoCStarterPU");
			 sjp = new SettingsJpaController(emf);
			 ajp = new AccountJpaController(emf);
			 cjp = new ClassiJpaController(emf);
			 rjp = new ServersJpaController(emf);
			 tjp = new ToonJpaController(emf);
		} catch (Exception e) {
			infoDisplayer.putMessage("Error on DB connession");
			e.printStackTrace();
		}
	}

	public static DefaultComboBoxModel getSupportedResolutions() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		DisplayMode[] dm = gs[0].getDisplayModes();
		ArrayList<String> al = new ArrayList();
		String string;
		for (int i = 0; i < dm.length; i++) {
			string = dm[i].getWidth() + " " + dm[i].getHeight();
			if ((!al.contains(string)) && (string.length() > 7))
				al.add(string);
		}
		al.add("800 600");
		Collections.sort(al);
		for (int i = 0; i < al.size(); i++) 
			 model.addElement(al.get(i));
		return model;
	}

	private static void createSettings() {
		try {
			System.out.println("creo i settings...");
			settings = new Settings();
			settings.setId(1);
			creaClassi();
			creaServers();
			sjp.create(settings);
			System.out.println("... completato!");
		}
		catch (Exception e) {
			System.out.println("errore in creaISettings");
			e.printStackTrace();
		}
	}
	
	private static void setupSettings () {
		try {
			settings = sjp.findSettings(1);
			settings.getId();
		}
		catch (Exception e) {System.out.println("setting non trovati, li creo");
			createSettings();
		}
		try {
			settings.setUddpath(System.getenv("APPDATA") + File.separator + 
									  "Electronic Arts" + File.separator + "Dark Age of Camelot" + 
								      File.separator + "LotM" + File.separator + "user.dat");
			sjp.edit(settings);
			userdd = new File(settings.getUddpath());
		}
		catch (Exception e) {
			System.out.println("Error #100");
			e.printStackTrace();
		}
		try {
			if (ISWIN) {
				ini = new Wini(userdd);
				//ini = new WiniWithCheck(userdd);
				Config c = ini.getConfig();
				c.setStrictOperator(true);
				ini.setConfig(c);
			}
		}
		catch (Exception e) {
			System.out.println("Error #101");
			e.printStackTrace();
		}
	}

	public static String getGameResolution() {
		String sw = null, sh = null;
		if (ISWIN) {
			try {
				sw = ini.get("main", "screen_width", String.class);
				if (sw == null || sw.equals("")) {
					sw = "800";
				}
				sh = ini.get("main", "screen_height", String.class);
				if (sh == null || sw.equals("")) {
					sh = "600";
				}
			}
			catch (Exception e) {
				//infoDisplayer.putMessage("user.dat error");
				e.printStackTrace();
			}
		}
		return sw + " " + sh;
	}

	public static boolean getFullScreenStatus() {
		String windowed = "0";
		if (ISWIN) {
			try {
				windowed = ini.get("main", "windowed", String.class);
			}
			catch (Exception e) {
				//infoDisplayer.putMessage("user.dat error");
				System.out.println("user.dat error");
				e.printStackTrace();
			}
		}
		
		if (windowed.equals("0")) {
			 return true;
		}
		return false;
	}

	public static DefaultComboBoxModel getAccountsBoxModel(boolean returnsNoAcc) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		List<Account> listAccount = ajp.findAccountEntities();
		if (returnsNoAcc)
			 model.addElement("No Account Selected");
		for (int i = 0; i < ajp.getAccountCount(); i++) {
			 model.addElement(listAccount.get(i));
		}
		return model;
	}

	public static DefaultComboBoxModel getCharsBoxModel(boolean addThanks) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		List<Toon> listToon = tjp.findToonEntities();
		if (addThanks) model.addElement("No Thank You");
		for (int i = 0; i < tjp.getToonCount(); i++) {
			    model.addElement(listToon.get(i));
		}
		return model;
    }

	public static DefaultListModel getAccountsListModel() {
		DefaultListModel model = new DefaultListModel();
		List<Account> listAccount = ajp.findAccountEntities();
		for (int i = 0; i < ajp.getAccountCount(); i++) {
			 model.addElement(listAccount.get(i));
		}
		return model;
   }

	public static void addAccount(String nome, String password, int type) {
		Account account = new Account();
		account.setName(nome);
		account.setPassword(password);
		account.setType(type);
		try {
			 ajp.create(account);
		} catch (Exception e) {
			 infoDisplayer.putMessage("DB error");
			 e.printStackTrace();
		}
   }

	public static DefaultListModel getToonListModel()  {
		DefaultListModel model = new DefaultListModel();
		List<Toon> toonList = tjp.findToonEntities();
		try {
			for (int i = 0; i < tjp.getToonCount(); i++) {
				if (toonList.get(i) instanceof Toon)
					model.addElement(toonList.get(i));
			}
		}
		catch(Exception e) {
			infoDisplayer.putMessage("DB error");
			e.printStackTrace();
		}
		return model;
	}
	
	public static void deleteAccount(Account account) {
		try {
			List<Toon> list = tjp.findToonEntities();
			for (int i = 0; i < tjp.getToonCount(); i++) {
				if (list.get(i).getAccount() == account.getId()) {
					infoDisplayer.putMessage("Cant delete an account with toons in");
					return;
				}
			}
			ajp.destroy(account.getId());
		}
		catch (Exception e) {
			infoDisplayer.putMessage("DB error");
			e.printStackTrace();
		}
    }

	public static void deleteToon(Toon toon) {
		try {
			 tjp.destroy(toon.getId());
		}
		catch (Exception e) {
			 infoDisplayer.putMessage("DB error");
			 e.printStackTrace();
		}
	}
	
	public static void editAccount(Account account) {
		try {
			ajp.edit(account);
		}
		catch (Exception e) {
			infoDisplayer.putMessage("DB error");
		}
    }
    
	public static DefaultComboBoxModel getClassComboBoxModel(Object object) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		try {
			 List<Classi> listClassi = cjp.findClassiEntities();
			 for (int i = 0; i < cjp.getClassiCount(); i++) {
				if (listClassi.get(i).getReame().equals(object.toString()))
					 model.addElement(listClassi.get(i));
			 }
		}
		catch(Exception e) {
			 infoDisplayer.putMessage("DB error");
			 e.printStackTrace();
		}
		return model;
	}

	private static void creaServers() {
		//infoDisplayer.putMessage("Creating default servers");
		System.out.println("Creating default servers");
		try {
			rjp.create(new Servers(0, "Ywain1", "107.23.173.143", 10622, 41));
			rjp.create(new Servers(1, "Ywain2", "107.23.173.143", 10622, 49));
			rjp.create(new Servers(2, "Ywain3", "107.23.173.143", 10622, 50));
			rjp.create(new Servers(3, "Ywain4", "107.23.173.143", 10622, 51));
			rjp.create(new Servers(4, "Ywain5", "107.23.173.143", 10622, 52));
			rjp.create(new Servers(5, "Ywain6", "107.23.173.143", 10622, 53));
			rjp.create(new Servers(6, "Ywain7", "107.23.173.143", 10622, 54));
			rjp.create(new Servers(7, "Ywain8", "107.23.173.143", 10622, 55));
			rjp.create(new Servers(8, "Ywain9", "107.23.173.143", 10622, 56));
			rjp.create(new Servers(9, "Ywain10", "107.23.173.143", 10622, 57));
			rjp.create(new Servers(10, "Custom", "127.0.0.1", 0, 0));
		}
		catch (Exception e) {
			infoDisplayer.putMessage("DB error");
			e.printStackTrace();
		}
	}
	
	private static void creaClassi() {
		// <editor-fold defaultstate="collapsed" desc="TL;DR">
		try {
			cjp.create(new Classi(0, "Albion", "Armsman"));
			cjp.create(new Classi(1, "Albion", "Cabalist"));
			cjp.create(new Classi(2, "Albion", "Cleric"));
			cjp.create(new Classi(3, "Albion", "Friar"));
			cjp.create(new Classi(4, "Albion", "Heretic"));
			cjp.create(new Classi(5, "Albion", "Infiltrator"));
			cjp.create(new Classi(6, "Albion", "Mauler (Alb)"));
			cjp.create(new Classi(7, "Albion", "Mercenary"));
			cjp.create(new Classi(8, "Albion", "Minstrel"));
			cjp.create(new Classi(9, "Albion", "Necromancer"));
			cjp.create(new Classi(10, "Albion", "Paladin"));
			cjp.create(new Classi(11, "Albion", "Reaver"));
			cjp.create(new Classi(12, "Albion", "Scout"));
			cjp.create(new Classi(13, "Albion", "Sorcerer"));
			cjp.create(new Classi(14, "Albion", "Theurg"));
			cjp.create(new Classi(15, "Albion", "Wizard"));
			cjp.create(new Classi(16, "Hibernia", "Animist"));
			cjp.create(new Classi(17, "Hibernia", "Bainshee"));
			cjp.create(new Classi(18, "Hibernia", "Bard"));
			cjp.create(new Classi(19, "Hibernia", "Blademaster"));
			cjp.create(new Classi(20, "Hibernia", "Champion"));
			cjp.create(new Classi(21, "Hibernia", "Druid"));
			cjp.create(new Classi(22, "Hibernia", "Eldritch"));
			cjp.create(new Classi(23, "Hibernia", "Emchanter"));
			cjp.create(new Classi(24, "Hibernia", "Hero"));
			cjp.create(new Classi(25, "Hibernia", "Mauler (Hib)"));
			cjp.create(new Classi(26, "Hibernia", "Mentalist"));
			cjp.create(new Classi(27, "Hibernia", "Nightshade"));
			cjp.create(new Classi(28, "Hibernia", "Ranger"));
			cjp.create(new Classi(29, "Hibernia", "Valewalker"));
			cjp.create(new Classi(30, "Hibernia", "Vampiir"));
			cjp.create(new Classi(31, "Hibernia", "Warden"));
			cjp.create(new Classi(32, "Midgard", "Berserker"));
			cjp.create(new Classi(33, "Midgard", "Bonedancer"));
			cjp.create(new Classi(34, "Midgard", "Healer"));
			cjp.create(new Classi(35, "Midgard", "Hunter"));
			cjp.create(new Classi(36, "Midgard", "Mauler (Mid)"));
			cjp.create(new Classi(37, "Midgard", "Runemaster"));
			cjp.create(new Classi(38, "Midgard", "Savage"));
			cjp.create(new Classi(39, "Midgard", "Shadowblade"));
			cjp.create(new Classi(40, "Midgard", "Shaman"));
			cjp.create(new Classi(41, "Midgard", "Skald"));
			cjp.create(new Classi(42, "Midgard", "Spiritmaster"));
			cjp.create(new Classi(43, "Midgard", "Thane"));
			cjp.create(new Classi(44, "Midgard", "Valkyrie"));
			cjp.create(new Classi(45, "Midgard", "Warlock"));
			cjp.create(new Classi(46, "Midgard", "Warrior"));
		}
		catch(Exception e) {
			infoDisplayer.putMessage("DB error");
			e.printStackTrace();
		}// </editor-fold>
	}
	
	public static boolean getQOS() {
		try {
			if (settings.getQuitonstart() == 1)
				return true;
			else
				return false;
		}
		catch (Exception e) {
			//infoDisplayer.putMessage("DB error");
			System.out.println("DB error");
			//e.printStackTrace();
			return false;
		}
	}
	
	public static boolean getOSS() {
		try {
			if (settings.getStartup() == 1)
				return true;
			else
				return false;
		}
		catch (Exception e) {
			System.out.println("DB error");
			//infoDisplayer.putMessage("DB error");
			//e.printStackTrace();
			return false;
		}
	}
	
	public static void setQOS(boolean selected) {
		try {
			 if (selected) 
				settings.setQuitonstart(1);
			 else 
				settings.setQuitonstart(0);
			 sjp.edit(settings);
		}
		catch (Exception e) {
			 infoDisplayer.putMessage("DB error");
			 e.printStackTrace();
		}
	}
	
	public static void setOSS(boolean selected) {
		try {
			if (selected)
				settings.setStartup(1);
			else
				settings.setStartup(0);
			sjp.edit(settings);
		}
		catch (Exception e) {
			infoDisplayer.putMessage("DB error");
			e.printStackTrace();
		}
	}
	
	private static void copyFolder(File src, File dest) {
		if(src.isDirectory()){//if directory not exists, create it
			if(!dest.exists()){
				dest.mkdir();
				//System.out.println("Directory copied from "  + src + "  to " + dest);
			}//list all the directory contents
			String files[] = src.list();
			for (String file : files) {//construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				copyFolder(srcFile, destFile);//recursive copy
			}
		}
		else {//if file, then copy it
			try {OutputStream out;
				try (InputStream in = new FileInputStream(src)) {
					out = new FileOutputStream(dest);
					byte[] buffer = new byte[1024];
					int length;
					while ((length = in.read(buffer)) > 0)
						out.write(buffer, 0, length);
				}
				out.close();
				//System.out.println("File copied from " + src + " to " + dest);
			} 
			catch (Exception e ) {
				infoDisplayer.putMessage("File System error");
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteLoki() {
		try {
			Process process = Runtime.getRuntime().exec(LOKI_EXP);
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((line = reader.readLine()) != null) {
				System.out.println("test" + line);
				if (line.contains("0")) throw new Exception("non va bene");
			}
		}
		catch (Exception e) {
			infoDisplayer.putMessage("Admin priv. error");
			e.printStackTrace();
		}
	}
	
	public static void IRCStart() {
		try {
			IRCLoader ircLoader = new IRCLoader();
			Runtime.getRuntime().exec("java -jar " + TEMPORARY_DIR + File.separator + WIRC_JAR);
		}
		catch (Exception e) {
			infoDisplayer.putMessage("error on starting IRC");
			e.printStackTrace();
		}
	}
	
	public static void IRCHelp() {
		try {
			openWebpage(new URL("http://www.ircbeginner.com/ircinfo/ircc-commands.html").toURI());
		}
		catch (MalformedURLException | URISyntaxException e) {
			infoDisplayer.putMessage("error on IRCHelp()");
			e.printStackTrace();
		}
	}
	
	private static void openWebpage(URI uri) {
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(uri);
			}
			catch (Exception e) {
				infoDisplayer.putMessage("can't find a browser");
				e.printStackTrace();
			}
		}
	}
	
	public static void killClient() {
		try {
			if (clientSet.iterator().hasNext())
				TaskManager.killProcess(clientSet.iterator().next().PID);
		}
		catch (Exception e) {
			infoDisplayer.putMessage("Thread killClient error");
			e.printStackTrace();
		}
	}
	
	public static ListModel getClientModel() {
		DefaultListModel model = new DefaultListModel();
		Object objects[] = clientSet.toArray();
		for (int i = 0; i < objects.length; i++)
			model.addElement(objects[i]);
		return model;
	}
}