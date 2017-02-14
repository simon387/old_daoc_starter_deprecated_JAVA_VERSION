package com.data;

import com.logic.Client;
import com.logic.OsCheck;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
/**
 * MADE IN ITALY
 * @author simone
 */
public class DataClass {
	//private DataClass () {
	//}
	public static final String TITLE = "DAoCStarter 4.0 ALPHA";
	private static final String RES_FOLDER = "/com/resources/";
	public static final String USER_DIR = System.getenv("APPDATA") + 
										File.separator + 
										"Electronic Arts" + 
										File.separator + "Dark Age of Camelot" +
										File.separator + "LotM";
	public static final String SCREEN_DIR = File.separator + "Electronic Arts" +
										File.separator +"Dark Age of Camelot";
	public static final String CAMELOT_EXE = "camelot.exe";
	public static final String LOGIN_DLL = "login.dll";
	public static final String VENTRILO_EXE = "Ventrilo.exe";
	public static final String CAMELOT_BIN = "camelot.bin";
	public static final String TS3CLIENT_WIN32_EXE = "ts3client_win32.exe";
	public static final String TS3CLIENT_WIN64_EXE = "ts3client_win64.exe";
	public static final String TEMPORARY_DIR = System.getProperty("java.io.tmpdir");
	public static final String HANDLE_EXE = "handle.exe";
	public static final String GAME_DLL = "game.dll";
	public static final String MUTEX = "BaseNamedObjects\\DAoC";
	public static final String LOKI_EXP = "REG DELETE HKEY_CLASSES_ROOT\\LOKI.Document /v Priority /f";
	public static final String STARTER_EXE = "starter.exe";
	public static final String DOLLOADER_EXE = "dolloader.exe";
	public static final String WIRC_JAR = "wIRC_03.31.2009_alpha.jar";
	public static final String ICON = RES_FOLDER + "i.png";
	public static final String ALB_ICON = RES_FOLDER + "alb.png";
	public static final String MID_ICON = RES_FOLDER + "mid.png";
	public static final String HIB_ICON = RES_FOLDER + "hib.png";
	public static final String RES_STARTER_EXE = RES_FOLDER + STARTER_EXE;
	public static final String RES_DOLLOADER_EXE = RES_FOLDER + DOLLOADER_EXE;
	public static final String RES_HANDLE_EXE = RES_FOLDER + HANDLE_EXE;
	public static final String RES_WIRC_JAR = RES_FOLDER + WIRC_JAR;
	public static final String TASKLIST = "tasklist /fo csv /nh";
	public static final String KILL_NAME = "taskkill /IM ";
	public static final String KILL_PID = "taskkill /IM ";
	public static final String TLIST_TARGET = "tasklist /FI \"IMAGENAME eq ?\" /FO csv /NH";
	public static final String BOOTSCREEN_JPG = "bootscreen.jpg";
	public static final String RES_BOOTSCREEN = RES_FOLDER + BOOTSCREEN_JPG;
	public static final String TS3S_EXE = "ts3s.exe";
	public static final String RES_TS3S_EXE = RES_FOLDER + TS3S_EXE;
	public static final String READY_MSG = "Ready";
	public static final String NOTEPAD_EXE = "Notepad.exe";
	public static final boolean ISWIN = OsCheck.isWin();
	public static final boolean DEBUG_MODE = false;
	public static Set<Client> clientSet = new HashSet<>();
}