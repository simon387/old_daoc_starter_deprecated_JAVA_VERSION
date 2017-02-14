package com.gui;

import com.logic.DAoCStarter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import static com.data.DataClass.*;

public class SplashScreen {
	
	public static FormPrincipale formPrincipale = null;
	private TrayIcon trayIcon = null;
	private JFrame dialog;
	private JProgressBar progress;

	protected void initUI() throws MalformedURLException {
		showSplashScreen();
		SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
			@Override
			protected Void doInBackground() throws Exception {
				for (int i = 0; i < 100; i++) {
					Thread.sleep(9);// Simulate loading
					publish(i);// Notify progress
				}
				return null;
			}
			@Override
			protected void process(List<Integer> chunks) {
				progress.setValue(chunks.get(chunks.size() - 1));
			}
			@Override
			protected void done() {
				try {
					showFrame();
				}
				catch(Exception e) {
				}
				hideSplashScreen();
			}
		};
		worker.execute();
	}

	protected void hideSplashScreen() {
		dialog.setVisible(false);
		dialog.dispose();
	}

	protected void showSplashScreen() throws MalformedURLException {
		dialog = new JFrame();//JDialog((Frame) null);
		//dialog.setModal(false);
		dialog.setUndecorated(true);
		dialog.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICON)));
		InputStream in = getClass().getResourceAsStream(RES_BOOTSCREEN);
		try {
			File fileDest = new File(TEMPORARY_DIR + File.separator + BOOTSCREEN_JPG);
			try (OutputStream out = new FileOutputStream(fileDest, true)) {
				byte[] buff = new byte[1024];
				int len;
				while ((len = in.read(buff)) > 0)
					out.write(buff, 0, len);
				in.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Icon icon = new ImageIcon(TEMPORARY_DIR + File.separator + BOOTSCREEN_JPG);//JLabel background = new JLabel(new ImageIcon(new URL("http://blogs.dirteam.com/photos/sanderberkouwer/images/2157/original.aspx")));
		JLabel background = new JLabel();
		background.setIcon(icon); 
		background.setLayout(new BorderLayout());
		dialog.add(background);
		JLabel text = new JLabel("Loading " + TITLE);
		text.setForeground(Color.WHITE);
		text.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));
		background.add(text);
		progress = new JProgressBar();
		background.add(progress, BorderLayout.SOUTH);
		dialog.setAlwaysOnTop(true);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
	
	public void showFrame() {
		try {
			DAoCStarter.initialize();
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			 java.util.logging.Logger.getLogger(FormPrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (Exception e) {e.printStackTrace();}
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			@SuppressWarnings({"null", "ConstantConditions"})
			public void run() {
				try {
					formPrincipale = new FormPrincipale();
					try {
						formPrincipale.setLocation(DAoCStarter.getPosition());
						formPrincipale.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICON)));
					}
					catch(Exception e) {
						System.out.println("no position found");
					}
					
					if (ISWIN) {
						
					}
				}
				catch (Exception e) {
					System.out.println("errore nella gestione dell immagine icona");
					e.printStackTrace();
					System.exit(0);
				}
				try {
					SystemTray systemTray = null;
					if(SystemTray.isSupported()) {
						systemTray = SystemTray.getSystemTray();
						//System.out.println("è supportata la tray icon");
					}
					Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICON));
					trayIcon = new TrayIcon(image, "DAoC Starter");
					int trayIconWidth = new TrayIcon(image).getSize().width;
					trayIcon = new TrayIcon(image.getScaledInstance(trayIconWidth, -1, Image.SCALE_SMOOTH));
					systemTray.add(trayIcon);
					trayIcon.addMouseListener(new IconMouseListener());
				}	
				catch (Exception e) {
					System.out.println("errore nella gestione della tray icon");
					//usato come lock single application istance ahah!
					System.exit(0);
					e.printStackTrace();
				}
				formPrincipale.pack();
				formPrincipale.setVisible(true);
			 }
		});
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					try {
						new SplashScreen().initUI();
					}
					catch (MalformedURLException e) {
						e.printStackTrace();
					}
				}
			});
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}