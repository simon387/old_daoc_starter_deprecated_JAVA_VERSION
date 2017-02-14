package com.gui;

import com.data.Account;
import com.data.DataClass;
import com.data.Toon;
import com.logic.DAoCStarter;
import java.io.File;
import javax.swing.JFileChooser;
import static com.data.DataClass.ISWIN;
import static com.data.DataClass.READY_MSG;
/**
 * MADE IN ITALY
 * @author simone celia
 */
public class FormPrincipale extends javax.swing.JFrame {

	private boolean block = false;
	private FormKill formKill;
	private FormManageAccounts formManageAccounts;
	private FormManageChars formManageChars;
	private FormAdvancedOptions formAdvancedOptions;
	private FormAbout formAbout;
	public static InfoDisplayer infoDisplayer;

	public FormPrincipale() {
		this.addWindowStateListener(new FormPrincipaleWindowStateListener());
		initComponents();
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				formKill = new FormKill();
			}
		});
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				formManageAccounts = new FormManageAccounts();
			}
		});
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				 formManageChars = new FormManageChars();
			}
		});
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (ISWIN) formAdvancedOptions = new FormAdvancedOptions();
			}
		});
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				formAbout = new FormAbout();
			}
		});
		startInfoDisplayer();
    }
	
	private static void startInfoDisplayer() {
		infoDisplayer = new InfoDisplayer();
		infoDisplayer.start();
	}

	public static void setMessage(String message) {
		jLabel_.setText(message);
	}
	
	public void refreshAccount() {
		jComboBox_account.setModel(DAoCStarter.getAccountsBoxModel(true));
		formManageChars.refresh();
	}
	 
	public void refreshChar() {
		jComboBox_toon.setModel(DAoCStarter.getCharsBoxModel(true));
	}
	 
	private boolean isAOT() {
		if (FormPrincipale.super.isAlwaysOnTop()) {
			 return true;
		}
		return false;
	}

	private boolean isQOS() {
		return DAoCStarter.getQOS();
	}
	
	private boolean isOSS() {
		return DAoCStarter.getOSS();
	}
	
	public static void enableKill(boolean enabled) {
		jButton_kill.setEnabled(enabled);
	}
	
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton_start = new javax.swing.JButton();
        jButton_kill = new javax.swing.JButton();
        jComboBox_resolution = new javax.swing.JComboBox();
        jCheckBox_fullscreen = new javax.swing.JCheckBox();
        jComboBox_toon = new javax.swing.JComboBox();
        jComboBox_account = new javax.swing.JComboBox();
        jLabel_ = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_settings = new javax.swing.JMenu();
        jMenu_settings_official = new javax.swing.JMenu();
        jMenuItem_official_edit_path = new javax.swing.JMenuItem();
        jMenuItem_official_patch = new javax.swing.JMenuItem();
        jMenu_settings_shard = new javax.swing.JMenu();
        jMenuItem_shard_edit_path = new javax.swing.JMenuItem();
        jMenuItem__settings_accounts_manager = new javax.swing.JMenuItem();
        jMenuItem_settings_toons_manager = new javax.swing.JMenuItem();
        jMenuItem_settings_advanced_options = new javax.swing.JMenuItem();
        jMenuItem_settings_change_udd = new javax.swing.JMenuItem();
        jCheckBoxMenuItem_settings_startup = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem_settings_quit_on_start = new javax.swing.JCheckBoxMenuItem();
        jMenu_view = new javax.swing.JMenu();
        jCheckBoxMenuItem_view_ontop = new javax.swing.JCheckBoxMenuItem();
        jMenu_tools = new javax.swing.JMenu();
        jMenuItem_tools_ss = new javax.swing.JMenuItem();
        jMenuItem_tools_open_settings = new javax.swing.JMenuItem();
        jMenuItem_tools_edit_udd = new javax.swing.JMenuItem();
        jMenuItem_tools_backup = new javax.swing.JMenuItem();
        jMenuItem_tools_loki = new javax.swing.JMenuItem();
        jMenuItem_tools_limiter = new javax.swing.JMenuItem();
        jMenuItem_tools_clear_memory = new javax.swing.JMenuItem();
        jMenu_vent = new javax.swing.JMenu();
        jMenuItem_vent_start = new javax.swing.JMenuItem();
        jMenuItem_vent_edit = new javax.swing.JMenuItem();
        jMenu_ts3 = new javax.swing.JMenu();
        jMenuItem_ts3_start = new javax.swing.JMenuItem();
        jMenuItem_ts3_edit = new javax.swing.JMenuItem();
        jMenu_irc = new javax.swing.JMenu();
        jMenuItem_irc_client = new javax.swing.JMenuItem();
        jMenuItem_irc_help = new javax.swing.JMenuItem();
        jMenu_info = new javax.swing.JMenu();
        jMenuItem_info_update = new javax.swing.JMenuItem();
        jMenuItem_info_about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(com.data.DataClass.TITLE);
        setAlwaysOnTop(DAoCStarter.isOnTop());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("qwe"); // NOI18N

        jButton_start.setText("Start");
        jButton_start.setToolTipText("Starts a DAoC's client");
        jButton_start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_startMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_startMouseExited(evt);
            }
        });
        jButton_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_startActionPerformed(evt);
            }
        });

        jButton_kill.setText("Kill client");
        jButton_kill.setToolTipText("Kill DAoC's clients");
        jButton_kill.setEnabled(false);
        jButton_kill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_killMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_killMouseExited(evt);
            }
        });
        jButton_kill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_killActionPerformed(evt);
            }
        });

        jComboBox_resolution.setModel(DAoCStarter.getSupportedResolutions());
        jComboBox_resolution.setSelectedItem(DAoCStarter.getGameResolution());
        jComboBox_resolution.setToolTipText("Game's resolution");
        jComboBox_resolution.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox_resolutionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBox_resolutionMouseExited(evt);
            }
        });
        jComboBox_resolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_resolutionActionPerformed(evt);
            }
        });

        jCheckBox_fullscreen.setSelected(DAoCStarter.getFullScreenStatus());
        jCheckBox_fullscreen.setText("Fullscreen");
        jCheckBox_fullscreen.setToolTipText("Fullscreen mode");
        jCheckBox_fullscreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCheckBox_fullscreenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCheckBox_fullscreenMouseExited(evt);
            }
        });
        jCheckBox_fullscreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_fullscreenActionPerformed(evt);
            }
        });

        jComboBox_toon.setModel(DAoCStarter.getCharsBoxModel(true));
        jComboBox_toon.setSelectedItem(DAoCStarter.getLastToon());
        jComboBox_toon.setToolTipText("Toon to play");
        jComboBox_toon.setRenderer(new RealmIconListRenderer());
        jComboBox_toon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox_toonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBox_toonMouseExited(evt);
            }
        });
        jComboBox_toon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_toonActionPerformed(evt);
            }
        });

        jComboBox_account.setModel(DAoCStarter.getAccountsBoxModel(true));
        jComboBox_account.setSelectedItem(DAoCStarter.getLastAccount());
        jComboBox_account.setToolTipText("Name of the account to play");
        jComboBox_account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBox_accountMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox_accountMouseEntered(evt);
            }
        });
        jComboBox_account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_accountActionPerformed(evt);
            }
        });

        jLabel_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_.setText("Welcome to DAoC Starter");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_start, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_resolution, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox_toon, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBox_fullscreen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_kill))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox_account, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_start)
                    .addComponent(jButton_kill)
                    .addComponent(jComboBox_resolution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_fullscreen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_toon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_))
        );

        jMenu_settings.setText("Settings");
        jMenu_settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu_settingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu_settingsMouseExited(evt);
            }
        });

        jMenu_settings_official.setText("Official server options");
        jMenu_settings_official.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu_settings_officialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu_settings_officialMouseExited(evt);
            }
        });

        jMenuItem_official_edit_path.setText("Edit client path");
        jMenuItem_official_edit_path.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_official_edit_pathMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_official_edit_pathMouseExited(evt);
            }
        });
        jMenuItem_official_edit_path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_official_edit_pathActionPerformed(evt);
            }
        });
        jMenu_settings_official.add(jMenuItem_official_edit_path);

        jMenuItem_official_patch.setText("Patch client");
        jMenuItem_official_patch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_official_patchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_official_patchMouseExited(evt);
            }
        });
        jMenuItem_official_patch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_official_patchActionPerformed(evt);
            }
        });
        jMenu_settings_official.add(jMenuItem_official_patch);

        jMenu_settings.add(jMenu_settings_official);

        jMenu_settings_shard.setText("Shard server options");
        jMenu_settings_shard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu_settings_shardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu_settings_shardMouseExited(evt);
            }
        });

        jMenuItem_shard_edit_path.setText("Edit client path");
        jMenuItem_shard_edit_path.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_shard_edit_pathMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_shard_edit_pathMouseExited(evt);
            }
        });
        jMenuItem_shard_edit_path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_shard_edit_pathActionPerformed(evt);
            }
        });
        jMenu_settings_shard.add(jMenuItem_shard_edit_path);

        jMenu_settings.add(jMenu_settings_shard);

        jMenuItem__settings_accounts_manager.setText("Manage accounts");
        jMenuItem__settings_accounts_manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem__settings_accounts_managerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem__settings_accounts_managerMouseExited(evt);
            }
        });
        jMenuItem__settings_accounts_manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem__settings_accounts_managerActionPerformed(evt);
            }
        });
        jMenu_settings.add(jMenuItem__settings_accounts_manager);

        jMenuItem_settings_toons_manager.setText("Manage chars");
        jMenuItem_settings_toons_manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_settings_toons_managerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_settings_toons_managerMouseExited(evt);
            }
        });
        jMenuItem_settings_toons_manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_settings_toons_managerActionPerformed(evt);
            }
        });
        jMenu_settings.add(jMenuItem_settings_toons_manager);

        jMenuItem_settings_advanced_options.setText("Advanced options");
        jMenuItem_settings_advanced_options.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_settings_advanced_optionsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_settings_advanced_optionsMouseExited(evt);
            }
        });
        jMenuItem_settings_advanced_options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_settings_advanced_optionsActionPerformed(evt);
            }
        });
        jMenu_settings.add(jMenuItem_settings_advanced_options);

        jMenuItem_settings_change_udd.setText("Change user.dat path");
        jMenuItem_settings_change_udd.setEnabled(false);
        jMenu_settings.add(jMenuItem_settings_change_udd);

        jCheckBoxMenuItem_settings_startup.setSelected(isOSS());
        jCheckBoxMenuItem_settings_startup.setText("Star DAoC Starter on system startup");
        jCheckBoxMenuItem_settings_startup.setEnabled(false);
        jCheckBoxMenuItem_settings_startup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem_settings_startupActionPerformed(evt);
            }
        });
        jMenu_settings.add(jCheckBoxMenuItem_settings_startup);

        jCheckBoxMenuItem_settings_quit_on_start.setSelected(isQOS());
        jCheckBoxMenuItem_settings_quit_on_start.setText("Quit on client start");
        jCheckBoxMenuItem_settings_quit_on_start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem_settings_quit_on_startMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem_settings_quit_on_startMouseExited(evt);
            }
        });
        jCheckBoxMenuItem_settings_quit_on_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem_settings_quit_on_startActionPerformed(evt);
            }
        });
        jMenu_settings.add(jCheckBoxMenuItem_settings_quit_on_start);

        jMenuBar1.add(jMenu_settings);

        jMenu_view.setText("View");
        jMenu_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu_viewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu_viewMouseExited(evt);
            }
        });

        jCheckBoxMenuItem_view_ontop.setSelected(isAOT());
        jCheckBoxMenuItem_view_ontop.setText("Always on top");
        jCheckBoxMenuItem_view_ontop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem_view_ontopMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem_view_ontopMouseExited(evt);
            }
        });
        jCheckBoxMenuItem_view_ontop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem_view_ontopActionPerformed(evt);
            }
        });
        jMenu_view.add(jCheckBoxMenuItem_view_ontop);

        jMenuBar1.add(jMenu_view);

        jMenu_tools.setText("Tools");
        jMenu_tools.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu_toolsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu_toolsMouseExited(evt);
            }
        });

        jMenuItem_tools_ss.setText("Show screenshots directory");
        jMenuItem_tools_ss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_ssMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_ssMouseExited(evt);
            }
        });
        jMenuItem_tools_ss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_tools_ssActionPerformed(evt);
            }
        });
        jMenu_tools.add(jMenuItem_tools_ss);

        jMenuItem_tools_open_settings.setText("Open user settings directory");
        jMenuItem_tools_open_settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_open_settingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_open_settingsMouseExited(evt);
            }
        });
        jMenuItem_tools_open_settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_tools_open_settingsActionPerformed(evt);
            }
        });
        jMenu_tools.add(jMenuItem_tools_open_settings);

        jMenuItem_tools_edit_udd.setText("Edit user.dat");
        jMenuItem_tools_edit_udd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_edit_uddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_edit_uddMouseExited(evt);
            }
        });
        jMenuItem_tools_edit_udd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_tools_edit_uddActionPerformed(evt);
            }
        });
        jMenu_tools.add(jMenuItem_tools_edit_udd);

        jMenuItem_tools_backup.setText("Back up settings and screenshots");
        jMenuItem_tools_backup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_backupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_backupMouseExited(evt);
            }
        });
        jMenuItem_tools_backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_tools_backupActionPerformed(evt);
            }
        });
        jMenu_tools.add(jMenuItem_tools_backup);

        jMenuItem_tools_loki.setText("Delete LOKI2 register keys");
        jMenuItem_tools_loki.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_lokiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_lokiMouseExited(evt);
            }
        });
        jMenuItem_tools_loki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_tools_lokiActionPerformed(evt);
            }
        });
        jMenu_tools.add(jMenuItem_tools_loki);

        jMenuItem_tools_limiter.setText("Remove clients limiter");
        jMenuItem_tools_limiter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_limiterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_limiterMouseExited(evt);
            }
        });
        jMenuItem_tools_limiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_tools_limiterActionPerformed(evt);
            }
        });
        jMenu_tools.add(jMenuItem_tools_limiter);

        jMenuItem_tools_clear_memory.setText("Kill all clients, death processes and free up memory");
        jMenuItem_tools_clear_memory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_clear_memoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_tools_clear_memoryMouseExited(evt);
            }
        });
        jMenuItem_tools_clear_memory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_tools_clear_memoryActionPerformed(evt);
            }
        });
        jMenu_tools.add(jMenuItem_tools_clear_memory);

        jMenuBar1.add(jMenu_tools);

        jMenu_vent.setText("Ventrilo");
        jMenu_vent.addMenuDragMouseListener(new javax.swing.event.MenuDragMouseListener() {
            public void menuDragMouseDragged(javax.swing.event.MenuDragMouseEvent evt) {
            }
            public void menuDragMouseEntered(javax.swing.event.MenuDragMouseEvent evt) {
                jMenu_ventMenuDragMouseEntered(evt);
            }
            public void menuDragMouseExited(javax.swing.event.MenuDragMouseEvent evt) {
                jMenu_ventMenuDragMouseExited(evt);
            }
            public void menuDragMouseReleased(javax.swing.event.MenuDragMouseEvent evt) {
            }
        });

        jMenuItem_vent_start.setText("Start");
        jMenuItem_vent_start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_vent_startMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_vent_startMouseExited(evt);
            }
        });
        jMenuItem_vent_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_vent_startActionPerformed(evt);
            }
        });
        jMenu_vent.add(jMenuItem_vent_start);

        jMenuItem_vent_edit.setText("Edit path");
        jMenuItem_vent_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_vent_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_vent_editMouseExited(evt);
            }
        });
        jMenuItem_vent_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_vent_editActionPerformed(evt);
            }
        });
        jMenu_vent.add(jMenuItem_vent_edit);

        jMenuBar1.add(jMenu_vent);

        jMenu_ts3.setText("TS3");
        jMenu_ts3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu_ts3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu_ts3MouseExited(evt);
            }
        });

        jMenuItem_ts3_start.setText("Start");
        jMenuItem_ts3_start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_ts3_startMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_ts3_startMouseExited(evt);
            }
        });
        jMenuItem_ts3_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ts3_startActionPerformed(evt);
            }
        });
        jMenu_ts3.add(jMenuItem_ts3_start);

        jMenuItem_ts3_edit.setText("Edit path");
        jMenuItem_ts3_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_ts3_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_ts3_editMouseExited(evt);
            }
        });
        jMenuItem_ts3_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ts3_editActionPerformed(evt);
            }
        });
        jMenu_ts3.add(jMenuItem_ts3_edit);

        jMenuBar1.add(jMenu_ts3);

        jMenu_irc.setText("IRC");
        jMenu_irc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu_ircMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu_ircMouseExited(evt);
            }
        });

        jMenuItem_irc_client.setText("IRC client");
        jMenuItem_irc_client.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_irc_clientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_irc_clientMouseExited(evt);
            }
        });
        jMenuItem_irc_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_irc_clientActionPerformed(evt);
            }
        });
        jMenu_irc.add(jMenuItem_irc_client);

        jMenuItem_irc_help.setText("IRC help");
        jMenuItem_irc_help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_irc_helpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_irc_helpMouseExited(evt);
            }
        });
        jMenuItem_irc_help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_irc_helpActionPerformed(evt);
            }
        });
        jMenu_irc.add(jMenuItem_irc_help);

        jMenuBar1.add(jMenu_irc);

        jMenu_info.setText("?");
        jMenu_info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu_infoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu_infoMouseExited(evt);
            }
        });

        jMenuItem_info_update.setText("Check for update");
        jMenuItem_info_update.setEnabled(false);
        jMenu_info.add(jMenuItem_info_update);

        jMenuItem_info_about.setText("About DAoC Starter");
        jMenuItem_info_about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem_info_aboutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuItem_info_aboutMouseExited(evt);
            }
        });
        jMenuItem_info_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_info_aboutActionPerformed(evt);
            }
        });
        jMenu_info.add(jMenuItem_info_about);

        jMenuBar1.add(jMenu_info);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void jMenuItem_settings_advanced_optionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_settings_advanced_optionsActionPerformed
		infoDisplayer.putMessage("Opening advanced options");
		formAdvancedOptions.setVisible(true);
   }//GEN-LAST:event_jMenuItem_settings_advanced_optionsActionPerformed

   private void jMenuItem__settings_accounts_managerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem__settings_accounts_managerActionPerformed
		infoDisplayer.putMessage("Opening manage accounts");
		formManageAccounts.setVisible(true);
   }//GEN-LAST:event_jMenuItem__settings_accounts_managerActionPerformed

   private void jMenuItem_settings_toons_managerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_settings_toons_managerActionPerformed
		infoDisplayer.putMessage("Opening manage toons");
		formManageChars.setVisible(true);
   }//GEN-LAST:event_jMenuItem_settings_toons_managerActionPerformed

    private void jMenuItem_tools_ssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_tools_ssActionPerformed
		infoDisplayer.putMessage("Opening screenshots dir");
		DAoCStarter.openSS();
    }//GEN-LAST:event_jMenuItem_tools_ssActionPerformed

    private void jMenuItem_tools_open_settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_tools_open_settingsActionPerformed
		infoDisplayer.putMessage("Opening settings dir");
		 DAoCStarter.openSD();
    }//GEN-LAST:event_jMenuItem_tools_open_settingsActionPerformed

    private void jMenuItem_tools_edit_uddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_tools_edit_uddActionPerformed
		infoDisplayer.putMessage("Editing user.dat");
		 DAoCStarter.openUDD();
    }//GEN-LAST:event_jMenuItem_tools_edit_uddActionPerformed

    private void jCheckBoxMenuItem_view_ontopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_view_ontopActionPerformed
		boolean selected = jCheckBoxMenuItem_view_ontop.isSelected();
		if (selected) {
			infoDisplayer.putMessage("Always on top = true");
			FormPrincipale.super.setAlwaysOnTop(true);
		} else {
			infoDisplayer.putMessage("Always on top = false");
			FormPrincipale.super.setAlwaysOnTop(false);
		}
		DAoCStarter.setOnTop(selected);
    }//GEN-LAST:event_jCheckBoxMenuItem_view_ontopActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		infoDisplayer.putMessage("Quitto sto quittando");
		DAoCStarter.stoQuittando(this.getLocation());
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem_tools_backupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_tools_backupActionPerformed
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setDialogTitle("Chose destination of the backup");
		if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION && 
				  fc.getSelectedFile().isDirectory()) {
			if (!fc.getSelectedFile().getAbsolutePath().equals("")) {
				DAoCStarter.backUp(new File(fc.getSelectedFile().getAbsolutePath() + "\\screensh"),
										 new File(fc.getSelectedFile().getAbsolutePath() + "\\settings"));
			}
		}
		infoDisplayer.putMessage("Done");
    }//GEN-LAST:event_jMenuItem_tools_backupActionPerformed

    private void jMenuItem_official_edit_pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_official_edit_pathActionPerformed
		DAoCStarter.pathSetter(this, true);
		infoDisplayer.putMessage("Done");
    }//GEN-LAST:event_jMenuItem_official_edit_pathActionPerformed

    private void jMenuItem_shard_edit_pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_shard_edit_pathActionPerformed
		DAoCStarter.pathSetter(this, false);
		infoDisplayer.putMessage("Done");
    }//GEN-LAST:event_jMenuItem_shard_edit_pathActionPerformed

    private void jMenuItem_official_patchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_official_patchActionPerformed
		infoDisplayer.putMessage("Attemp on atching game.dll"); 
		DAoCStarter.patch(this);
    }//GEN-LAST:event_jMenuItem_official_patchActionPerformed

   private void jCheckBoxMenuItem_settings_quit_on_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_settings_quit_on_startActionPerformed
		DAoCStarter.setQOS(jCheckBoxMenuItem_settings_quit_on_start.isSelected());
		infoDisplayer.putMessage("Ok");
   }//GEN-LAST:event_jCheckBoxMenuItem_settings_quit_on_startActionPerformed

   private void jCheckBoxMenuItem_settings_startupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_settings_startupActionPerformed
		DAoCStarter.setOSS(jCheckBoxMenuItem_settings_startup.isSelected());
   }//GEN-LAST:event_jCheckBoxMenuItem_settings_startupActionPerformed

   private void jMenuItem_vent_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_vent_editActionPerformed
		DAoCStarter.editVentPath(this);
		infoDisplayer.putMessage("Done");
   }//GEN-LAST:event_jMenuItem_vent_editActionPerformed

   private void jMenuItem_ts3_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ts3_editActionPerformed
		DAoCStarter.editTS3Path(this);
		infoDisplayer.putMessage("Done");
   }//GEN-LAST:event_jMenuItem_ts3_editActionPerformed

   private void jMenuItem_vent_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_vent_startActionPerformed
		infoDisplayer.putMessage("Starting Ventrilo");
		DAoCStarter.startVent(this);
		infoDisplayer.putMessage("Done");
   }//GEN-LAST:event_jMenuItem_vent_startActionPerformed

   private void jMenuItem_ts3_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ts3_startActionPerformed
		infoDisplayer.putMessage("Starting TS3");
		DAoCStarter.startTS3(this);
		infoDisplayer.putMessage("Done");
   }//GEN-LAST:event_jMenuItem_ts3_startActionPerformed

   private void jMenuItem_tools_clear_memoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_tools_clear_memoryActionPerformed
		DAoCStarter.clearMemory();
		infoDisplayer.putMessage("Memory cleared");
   }//GEN-LAST:event_jMenuItem_tools_clear_memoryActionPerformed

   private void jMenuItem_tools_limiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_tools_limiterActionPerformed
		DAoCStarter.mutantCleaner();
   }//GEN-LAST:event_jMenuItem_tools_limiterActionPerformed

   private void jMenuItem_tools_lokiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_tools_lokiActionPerformed
	DAoCStarter.deleteLoki();
   }//GEN-LAST:event_jMenuItem_tools_lokiActionPerformed

   private void jMenuItem_irc_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_irc_clientActionPerformed
		infoDisplayer.putMessage("Starting IRC client");
		DAoCStarter.IRCStart();
   }//GEN-LAST:event_jMenuItem_irc_clientActionPerformed

   private void jMenuItem_irc_helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_irc_helpActionPerformed
		infoDisplayer.putMessage("Learn it!");
		DAoCStarter.IRCHelp();
   }//GEN-LAST:event_jMenuItem_irc_helpActionPerformed

   private void jMenuItem_info_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_info_aboutActionPerformed
		infoDisplayer.putMessage("Ok");
		formAbout.setVisible(true);
   }//GEN-LAST:event_jMenuItem_info_aboutActionPerformed

    private void jMenuItem_info_aboutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_info_aboutMouseEntered
        infoDisplayer.putMessage("Display infos");
    }//GEN-LAST:event_jMenuItem_info_aboutMouseEntered

    private void jMenuItem_info_aboutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_info_aboutMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_info_aboutMouseExited

    private void jMenuItem_irc_clientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_irc_clientMouseEntered
		infoDisplayer.putMessage("Starts an IRC clients");
    }//GEN-LAST:event_jMenuItem_irc_clientMouseEntered

    private void jMenuItem_irc_clientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_irc_clientMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_irc_clientMouseExited

    private void jMenuItem_irc_helpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_irc_helpMouseEntered
		infoDisplayer.putMessage("Get info on IRC");
    }//GEN-LAST:event_jMenuItem_irc_helpMouseEntered

    private void jMenuItem_irc_helpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_irc_helpMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_irc_helpMouseExited

    private void jMenuItem_ts3_startMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_ts3_startMouseEntered
		infoDisplayer.putMessage("Starts a TS3's client");
    }//GEN-LAST:event_jMenuItem_ts3_startMouseEntered

    private void jMenuItem_ts3_startMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_ts3_startMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_ts3_startMouseExited

    private void jMenuItem_ts3_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_ts3_editMouseEntered
		infoDisplayer.putMessage("Set TS3's path");
    }//GEN-LAST:event_jMenuItem_ts3_editMouseEntered

    private void jMenuItem_ts3_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_ts3_editMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_ts3_editMouseExited

    private void jMenuItem_vent_startMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_vent_startMouseEntered
		infoDisplayer.putMessage("Starts a Ventrilo's client");
    }//GEN-LAST:event_jMenuItem_vent_startMouseEntered

    private void jMenuItem_vent_startMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_vent_startMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_vent_startMouseExited

    private void jMenuItem_vent_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_vent_editMouseEntered
		infoDisplayer.putMessage("Set TS3's path");
    }//GEN-LAST:event_jMenuItem_vent_editMouseEntered

    private void jMenuItem_vent_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_vent_editMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_vent_editMouseExited

    private void jMenuItem_tools_ssMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_ssMouseEntered
		infoDisplayer.putMessage("Show screenshots directory");
    }//GEN-LAST:event_jMenuItem_tools_ssMouseEntered

    private void jMenuItem_tools_ssMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_ssMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_tools_ssMouseExited

    private void jMenuItem_tools_open_settingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_open_settingsMouseEntered
		infoDisplayer.putMessage("Open user's settings dir");
    }//GEN-LAST:event_jMenuItem_tools_open_settingsMouseEntered

    private void jMenuItem_tools_open_settingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_open_settingsMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_tools_open_settingsMouseExited

    private void jMenuItem_tools_edit_uddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_edit_uddMouseEntered
		infoDisplayer.putMessage("Open user.dat");
    }//GEN-LAST:event_jMenuItem_tools_edit_uddMouseEntered

    private void jMenuItem_tools_edit_uddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_edit_uddMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_tools_edit_uddMouseExited

    private void jMenuItem_tools_backupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_backupMouseEntered
		infoDisplayer.putMessage("Start back up procedure");
    }//GEN-LAST:event_jMenuItem_tools_backupMouseEntered

    private void jMenuItem_tools_backupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_backupMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_tools_backupMouseExited

    private void jMenuItem_tools_lokiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_lokiMouseEntered
		infoDisplayer.putMessage("Clean windows register");
    }//GEN-LAST:event_jMenuItem_tools_lokiMouseEntered

    private void jMenuItem_tools_lokiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_lokiMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_tools_lokiMouseExited

    private void jMenuItem_tools_limiterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_limiterMouseEntered
		infoDisplayer.putMessage("Remove clients limiter");
    }//GEN-LAST:event_jMenuItem_tools_limiterMouseEntered

    private void jMenuItem_tools_limiterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_limiterMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_tools_limiterMouseExited

    private void jMenuItem_tools_clear_memoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_clear_memoryMouseEntered
		infoDisplayer.putMessage("Kill all clients");
    }//GEN-LAST:event_jMenuItem_tools_clear_memoryMouseEntered

    private void jMenuItem_tools_clear_memoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_tools_clear_memoryMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_tools_clear_memoryMouseExited

    private void jCheckBoxMenuItem_view_ontopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_view_ontopMouseEntered
		infoDisplayer.putMessage("Edit ontop attribute");
    }//GEN-LAST:event_jCheckBoxMenuItem_view_ontopMouseEntered

    private void jCheckBoxMenuItem_view_ontopMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_view_ontopMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jCheckBoxMenuItem_view_ontopMouseExited

    private void jMenu_infoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_infoMouseEntered
		infoDisplayer.putMessage("About menu");
    }//GEN-LAST:event_jMenu_infoMouseEntered

    private void jMenu_infoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_infoMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenu_infoMouseExited

    private void jMenu_ircMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_ircMouseExited
		infoDisplayer.putMessage("IRC menu");
    }//GEN-LAST:event_jMenu_ircMouseExited

    private void jMenu_ircMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_ircMouseEntered
        infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenu_ircMouseEntered

    private void jMenu_ts3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_ts3MouseEntered
		infoDisplayer.putMessage("TS3 menu");
    }//GEN-LAST:event_jMenu_ts3MouseEntered

    private void jMenu_ts3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_ts3MouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenu_ts3MouseExited

    private void jMenu_ventMenuDragMouseEntered(javax.swing.event.MenuDragMouseEvent evt) {//GEN-FIRST:event_jMenu_ventMenuDragMouseEntered
		infoDisplayer.putMessage("Ventrilo menu");
    }//GEN-LAST:event_jMenu_ventMenuDragMouseEntered

    private void jMenu_ventMenuDragMouseExited(javax.swing.event.MenuDragMouseEvent evt) {//GEN-FIRST:event_jMenu_ventMenuDragMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenu_ventMenuDragMouseExited

    private void jMenu_toolsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_toolsMouseEntered
		infoDisplayer.putMessage("Tools menu");
    }//GEN-LAST:event_jMenu_toolsMouseEntered

    private void jMenu_toolsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_toolsMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenu_toolsMouseExited

    private void jMenu_viewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_viewMouseEntered
		infoDisplayer.putMessage("View menu");
    }//GEN-LAST:event_jMenu_viewMouseEntered

    private void jMenu_viewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_viewMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenu_viewMouseExited

    private void jMenu_settingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_settingsMouseEntered
		infoDisplayer.putMessage("Settings menu");
    }//GEN-LAST:event_jMenu_settingsMouseEntered

    private void jMenu_settingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_settingsMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenu_settingsMouseExited

    private void jCheckBoxMenuItem_settings_quit_on_startMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_settings_quit_on_startMouseEntered
		infoDisplayer.putMessage("Quit on start option");
    }//GEN-LAST:event_jCheckBoxMenuItem_settings_quit_on_startMouseEntered

    private void jCheckBoxMenuItem_settings_quit_on_startMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_settings_quit_on_startMouseExited
        infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jCheckBoxMenuItem_settings_quit_on_startMouseExited

    private void jMenuItem_settings_advanced_optionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_settings_advanced_optionsMouseEntered
		infoDisplayer.putMessage("Open advanced options");
    }//GEN-LAST:event_jMenuItem_settings_advanced_optionsMouseEntered

    private void jMenuItem_settings_advanced_optionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_settings_advanced_optionsMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_settings_advanced_optionsMouseExited

    private void jMenuItem_settings_toons_managerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_settings_toons_managerMouseEntered
		infoDisplayer.putMessage("Open chars manager");
    }//GEN-LAST:event_jMenuItem_settings_toons_managerMouseEntered

    private void jMenuItem_settings_toons_managerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_settings_toons_managerMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_settings_toons_managerMouseExited

    private void jMenuItem__settings_accounts_managerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem__settings_accounts_managerMouseEntered
		infoDisplayer.putMessage("Open accounts manager");
    }//GEN-LAST:event_jMenuItem__settings_accounts_managerMouseEntered

    private void jMenuItem__settings_accounts_managerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem__settings_accounts_managerMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem__settings_accounts_managerMouseExited

    private void jMenu_settings_officialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_settings_officialMouseEntered
		infoDisplayer.putMessage("Official server options");
    }//GEN-LAST:event_jMenu_settings_officialMouseEntered

    private void jMenu_settings_officialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_settings_officialMouseExited
        infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenu_settings_officialMouseExited

    private void jMenu_settings_shardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_settings_shardMouseEntered
		infoDisplayer.putMessage("Shard server option");
    }//GEN-LAST:event_jMenu_settings_shardMouseEntered

    private void jMenu_settings_shardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_settings_shardMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenu_settings_shardMouseExited

    private void jMenuItem_official_edit_pathMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_official_edit_pathMouseEntered
		infoDisplayer.putMessage("edit path");
    }//GEN-LAST:event_jMenuItem_official_edit_pathMouseEntered

    private void jMenuItem_official_edit_pathMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_official_edit_pathMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_official_edit_pathMouseExited

    private void jMenuItem_official_patchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_official_patchMouseEntered
		infoDisplayer.putMessage("Patch official client");
    }//GEN-LAST:event_jMenuItem_official_patchMouseEntered

    private void jMenuItem_official_patchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_official_patchMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_official_patchMouseExited

    private void jMenuItem_shard_edit_pathMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_shard_edit_pathMouseEntered
		infoDisplayer.putMessage("edit path");
    }//GEN-LAST:event_jMenuItem_shard_edit_pathMouseEntered

    private void jMenuItem_shard_edit_pathMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem_shard_edit_pathMouseExited
		infoDisplayer.putMessage(READY_MSG);
    }//GEN-LAST:event_jMenuItem_shard_edit_pathMouseExited

   private void jComboBox_accountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_accountActionPerformed
      if (!block) {
         Object accountO = jComboBox_account.getSelectedItem();
         if (accountO instanceof Account) {
            Account account = (Account)accountO;
            for (int i = 0; i < jComboBox_toon.getItemCount(); i++) {
               if (jComboBox_toon.getItemAt(i) instanceof Toon) {
                  Toon toon = (Toon)jComboBox_toon.getItemAt(i);
                  if (toon.getAccount() == account.getId()) {
                     jComboBox_toon.setSelectedIndex(i);
                     return;
                  }
               }
            }
            jComboBox_toon.setSelectedIndex(0);
         }
         infoDisplayer.putMessage("Ok");
      }
   }//GEN-LAST:event_jComboBox_accountActionPerformed

   private void jComboBox_accountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_accountMouseExited
      infoDisplayer.putMessage(READY_MSG);
   }//GEN-LAST:event_jComboBox_accountMouseExited

   private void jComboBox_accountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_accountMouseEntered
      infoDisplayer.putMessage("Name of the account to play");
   }//GEN-LAST:event_jComboBox_accountMouseEntered

   private void jComboBox_toonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_toonActionPerformed
      Object object = jComboBox_toon.getSelectedItem();
      if (object instanceof Toon) {
         Toon toon = (Toon)object;
         for (int i = 0; i < jComboBox_resolution.getItemCount(); i++) {
            if (jComboBox_resolution.getItemAt(i).toString().equals(toon.getResolution())) {
               jComboBox_resolution.setSelectedIndex(i);
            }
         }
         if (toon.getWindowed() == 1) {
            jCheckBox_fullscreen.setSelected(true);
         }
         else {
            jCheckBox_fullscreen.setSelected(false);
         }
         block = true;
         for (int i = 0; i < jComboBox_account.getItemCount(); i++) {
            if (jComboBox_account.getItemAt(i) instanceof Account) {
               Account account = (Account)jComboBox_account.getItemAt(i);
               if (account.getId() == toon.getAccount()) {
                  jComboBox_account.setSelectedIndex(i);
               }
            }
         }
         block = false;
      }
      infoDisplayer.putMessage("Ok");
   }//GEN-LAST:event_jComboBox_toonActionPerformed

   private void jComboBox_toonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_toonMouseExited
      infoDisplayer.putMessage(READY_MSG);
   }//GEN-LAST:event_jComboBox_toonMouseExited

   private void jComboBox_toonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_toonMouseEntered
      infoDisplayer.putMessage("Toon to play");
   }//GEN-LAST:event_jComboBox_toonMouseEntered

   private void jCheckBox_fullscreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_fullscreenActionPerformed
      infoDisplayer.putMessage("Switching screen mode");
      DAoCStarter.setWindowed(jCheckBox_fullscreen.isSelected());
   }//GEN-LAST:event_jCheckBox_fullscreenActionPerformed

   private void jCheckBox_fullscreenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_fullscreenMouseExited
      infoDisplayer.putMessage(READY_MSG);
   }//GEN-LAST:event_jCheckBox_fullscreenMouseExited

   private void jCheckBox_fullscreenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_fullscreenMouseEntered
      infoDisplayer.putMessage("Fullscreen mode");
   }//GEN-LAST:event_jCheckBox_fullscreenMouseEntered

   private void jComboBox_resolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_resolutionActionPerformed
      infoDisplayer.putMessage("Setting game's resolution");
      DAoCStarter.setResolution(jComboBox_resolution.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox_resolutionActionPerformed

   private void jComboBox_resolutionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_resolutionMouseExited
      infoDisplayer.putMessage(READY_MSG);
   }//GEN-LAST:event_jComboBox_resolutionMouseExited

   private void jComboBox_resolutionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_resolutionMouseEntered
      infoDisplayer.putMessage("Game's resolution");
   }//GEN-LAST:event_jComboBox_resolutionMouseEntered

   private void jButton_killActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_killActionPerformed
      if (DataClass.clientSet.size() == 1) {
         infoDisplayer.putMessage("Killing the actual client");
         DAoCStarter.killClient();
      }
      else {
         infoDisplayer.putMessage("Opening kill window");
         formKill.setVisible(true);
      }
   }//GEN-LAST:event_jButton_killActionPerformed

   private void jButton_killMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_killMouseExited
      infoDisplayer.putMessage(READY_MSG);
   }//GEN-LAST:event_jButton_killMouseExited

   private void jButton_killMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_killMouseEntered
      infoDisplayer.putMessage("Kill DAoC's clients");
   }//GEN-LAST:event_jButton_killMouseEntered

   private void jButton_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_startActionPerformed
      infoDisplayer.putMessage("Starting...");
      jButton_start.setEnabled(false);
      String resolution = null;
      boolean isSelected = false;
      Toon toon = null;
      Account account = null;
      try {
         resolution = jComboBox_resolution.getSelectedItem().toString();
         if (jCheckBox_fullscreen.isSelected()) isSelected = true;
         if (jComboBox_toon.getSelectedItem() instanceof Toon)
         toon = (Toon)jComboBox_toon.getSelectedItem();
         if (jComboBox_account.getSelectedItem() instanceof Account)
         account = (Account)jComboBox_account.getSelectedItem();
      }
      catch (Exception e) {
         infoDisplayer.putMessage("Error on starting");
      }
      DAoCStarter.start(resolution, isSelected, toon, account, this);
      jButton_start.setEnabled(true);
   }//GEN-LAST:event_jButton_startActionPerformed

   private void jButton_startMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_startMouseExited
      infoDisplayer.putMessage(READY_MSG);
   }//GEN-LAST:event_jButton_startMouseExited

   private void jButton_startMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_startMouseEntered
      infoDisplayer.putMessage("Click to start a client");
   }//GEN-LAST:event_jButton_startMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButton_kill;
    private static javax.swing.JButton jButton_start;
    private static javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem_settings_quit_on_start;
    private static javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem_settings_startup;
    private static javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem_view_ontop;
    private static javax.swing.JCheckBox jCheckBox_fullscreen;
    private static javax.swing.JComboBox jComboBox_account;
    private static javax.swing.JComboBox jComboBox_resolution;
    private static javax.swing.JComboBox jComboBox_toon;
    private static javax.swing.JLabel jLabel_;
    private static javax.swing.JMenuBar jMenuBar1;
    private static javax.swing.JMenuItem jMenuItem__settings_accounts_manager;
    private static javax.swing.JMenuItem jMenuItem_info_about;
    private static javax.swing.JMenuItem jMenuItem_info_update;
    private static javax.swing.JMenuItem jMenuItem_irc_client;
    private static javax.swing.JMenuItem jMenuItem_irc_help;
    private static javax.swing.JMenuItem jMenuItem_official_edit_path;
    private static javax.swing.JMenuItem jMenuItem_official_patch;
    private static javax.swing.JMenuItem jMenuItem_settings_advanced_options;
    private static javax.swing.JMenuItem jMenuItem_settings_change_udd;
    private static javax.swing.JMenuItem jMenuItem_settings_toons_manager;
    private static javax.swing.JMenuItem jMenuItem_shard_edit_path;
    private static javax.swing.JMenuItem jMenuItem_tools_backup;
    private static javax.swing.JMenuItem jMenuItem_tools_clear_memory;
    private static javax.swing.JMenuItem jMenuItem_tools_edit_udd;
    private static javax.swing.JMenuItem jMenuItem_tools_limiter;
    private static javax.swing.JMenuItem jMenuItem_tools_loki;
    private static javax.swing.JMenuItem jMenuItem_tools_open_settings;
    private static javax.swing.JMenuItem jMenuItem_tools_ss;
    private static javax.swing.JMenuItem jMenuItem_ts3_edit;
    private static javax.swing.JMenuItem jMenuItem_ts3_start;
    private static javax.swing.JMenuItem jMenuItem_vent_edit;
    private static javax.swing.JMenuItem jMenuItem_vent_start;
    private static javax.swing.JMenu jMenu_info;
    private static javax.swing.JMenu jMenu_irc;
    private static javax.swing.JMenu jMenu_settings;
    private static javax.swing.JMenu jMenu_settings_official;
    private static javax.swing.JMenu jMenu_settings_shard;
    private static javax.swing.JMenu jMenu_tools;
    private static javax.swing.JMenu jMenu_ts3;
    private static javax.swing.JMenu jMenu_vent;
    private static javax.swing.JMenu jMenu_view;
    private static javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
