package com.gui;

import com.data.Account;
import com.data.Classi;
import com.data.Servers;
import com.data.Toon;
import com.logic.DAoCStarter;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ComboBoxModel;
import static com.data.DataClass.ICON;
import static com.gui.FormPrincipale.infoDisplayer;
import javax.swing.JComponent;
/**
 * MADE IN ITALY
 * @author simone
 */
public class FormManageChars extends javax.swing.JFrame {

	private int charId = 0;

	public FormManageChars() {
		initComponents();
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICON)));
		TextPrompt tp1 = new TextPrompt("Character Name", jTextField_name);
		//tp7.setForeground( Color.RED );
		tp1.changeAlpha(0.5f);
		tp1.changeStyle(+Font.ITALIC);//Font.BOLDj
		TextPrompt tp2 = new TextPrompt("Server address", jTextField_serverAddress);
		tp2.changeAlpha(0.5f);
		tp2.changeStyle(+Font.ITALIC);
		TextPrompt tp3 = new TextPrompt("Port", jTextField_serverPort);
		tp3.changeAlpha(0.5f);
		tp3.changeStyle(+Font.ITALIC);
		TextPrompt tp4 = new TextPrompt("ID", jTextField_serverID);
		tp4.changeAlpha(0.5f);
		tp4.changeStyle(+Font.ITALIC);
		jComboBox_serverNameActionPerformed(null);
	}

	public void refresh() {
		jList_toons.setModel(DAoCStarter.getCharsBoxModel(false));
		jComboBox_account.setModel(DAoCStarter.getAccountsBoxModel(false));
		SplashScreen.formPrincipale.refreshChar();
	}
	
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      jScrollPane1 = new javax.swing.JScrollPane();
      jList_toons = new javax.swing.JList();
      jTextField_name = new javax.swing.JTextField();
      jComboBox_serverName = new javax.swing.JComboBox();
      jTextField_serverID = new javax.swing.JTextField();
      jTextField_serverAddress = new javax.swing.JTextField();
      jTextField_serverPort = new javax.swing.JTextField();
      jComboBox_realm = new javax.swing.JComboBox();
      jComboBox_class = new javax.swing.JComboBox();
      jComboBox_resolution = new javax.swing.JComboBox();
      jCheckBox_fullscreen = new javax.swing.JCheckBox();
      jComboBox_account = new javax.swing.JComboBox();
      jButton_save = new javax.swing.JButton();
      jButton_add = new javax.swing.JButton();
      jButton_delete = new javax.swing.JButton();

      setTitle("Characters Database Editor");
      setResizable(false);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowClosing(java.awt.event.WindowEvent evt) {
            formWindowClosing(evt);
         }
      });

      jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

      jList_toons.setModel(DAoCStarter.getToonListModel());
      jList_toons.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      jList_toons.setToolTipText("List of characters");
      jList_toons.setCellRenderer(new RealmIconListRenderer());
      jList_toons.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jList_toonsMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jList_toonsMouseEntered(evt);
         }
      });
      jList_toons.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
         public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            jList_toonsValueChanged(evt);
         }
      });
      jScrollPane1.setViewportView(jList_toons);

      jTextField_name.setToolTipText("Toon's name");
      jTextField_name.setInputVerifier(new Verifier());
      jTextField_name.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jTextField_nameMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jTextField_nameMouseEntered(evt);
         }
      });

      jComboBox_serverName.setModel(DAoCStarter.getServers());
      jComboBox_serverName.setToolTipText("Toon's server");
      jComboBox_serverName.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jComboBox_serverNameMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jComboBox_serverNameMouseEntered(evt);
         }
      });
      jComboBox_serverName.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox_serverNameActionPerformed(evt);
         }
      });

      jTextField_serverID.setToolTipText("Server's ID");
      jTextField_serverID.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jTextField_serverIDMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jTextField_serverIDMouseEntered(evt);
         }
      });

      jTextField_serverAddress.setToolTipText("Address of the server");
      jTextField_serverAddress.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jTextField_serverAddressMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jTextField_serverAddressMouseEntered(evt);
         }
      });

      jTextField_serverPort.setToolTipText("Server's port");
      jTextField_serverPort.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jTextField_serverPortMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jTextField_serverPortMouseEntered(evt);
         }
      });

      jComboBox_realm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Albion", "Hibernia", "Midgard" }));
      jComboBox_realm.setToolTipText("Toon's realm");
      jComboBox_realm.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jComboBox_realmMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jComboBox_realmMouseEntered(evt);
         }
      });
      jComboBox_realm.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox_realmActionPerformed(evt);
         }
      });

      jComboBox_class.setModel(DAoCStarter.getClassComboBoxModel(jComboBox_realm.getSelectedItem()));
      jComboBox_class.setToolTipText("Toon's class");
      jComboBox_class.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jComboBox_classMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jComboBox_classMouseEntered(evt);
         }
      });

      jComboBox_resolution.setModel(DAoCStarter.getSupportedResolutions());
      jComboBox_resolution.setSelectedItem(DAoCStarter.getGameResolution());
      jComboBox_resolution.setToolTipText("Preferred in game resolution");
      jComboBox_resolution.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jComboBox_resolutionMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jComboBox_resolutionMouseEntered(evt);
         }
      });

      jCheckBox_fullscreen.setSelected(true);
      jCheckBox_fullscreen.setText("FS");
      jCheckBox_fullscreen.setToolTipText("Start on fullscreen mode");
      jCheckBox_fullscreen.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jCheckBox_fullscreenMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jCheckBox_fullscreenMouseEntered(evt);
         }
      });

      jComboBox_account.setModel(DAoCStarter.getAccountsBoxModel(true));
      jComboBox_account.setToolTipText("Toon's account");
      jComboBox_account.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jComboBox_accountMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jComboBox_accountMouseEntered(evt);
         }
      });

      jButton_save.setText("Save changes");
      jButton_save.setToolTipText("Save changes");
      jButton_save.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jButton_saveMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButton_saveMouseEntered(evt);
         }
      });
      jButton_save.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_saveActionPerformed(evt);
         }
      });

      jButton_add.setText("Add new char");
      jButton_add.setToolTipText("Add a new toon");
      jButton_add.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jButton_addMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButton_addMouseEntered(evt);
         }
      });
      jButton_add.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_addActionPerformed(evt);
         }
      });

      jButton_delete.setText("Delete char");
      jButton_delete.setToolTipText("Delete selected char");
      jButton_delete.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jButton_deleteMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButton_deleteMouseEntered(evt);
         }
      });
      jButton_delete.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_deleteActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jButton_save)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton_add)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jButton_delete))
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                     .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(jComboBox_account, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jComboBox_serverName, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                        .addComponent(jComboBox_realm, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                           .addComponent(jComboBox_class, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                           .addComponent(jComboBox_resolution, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                           .addComponent(jCheckBox_fullscreen))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                           .addComponent(jTextField_serverAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                           .addComponent(jTextField_serverPort, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                           .addComponent(jTextField_serverID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton_add, jButton_delete, jButton_save});

      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jComboBox_account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(26, 26, 26)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jComboBox_serverName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jTextField_serverAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jTextField_serverPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jTextField_serverID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jComboBox_realm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jComboBox_class, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jComboBox_resolution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jCheckBox_fullscreen))
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButton_save)
               .addComponent(jButton_add)
               .addComponent(jButton_delete)))
         .addComponent(jScrollPane1)
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 11, Short.MAX_VALUE))
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

   private void jComboBox_realmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_realmActionPerformed
		jComboBox_class.setModel(DAoCStarter.getClassComboBoxModel(jComboBox_realm.getSelectedItem()));
   }//GEN-LAST:event_jComboBox_realmActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		this.setVisible(false);
		infoDisplayer.putMessage("Toon Manager closed");
    }//GEN-LAST:event_formWindowClosing

   private void jComboBox_serverNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_serverNameActionPerformed
		Servers servers;
		try {
		    if (jComboBox_serverName.getSelectedItem().toString().equals("Custom")) {
			Toon toon = DAoCStarter.getToon(charId);
			servers = new Servers(-1, "Custom", toon.getIp(), toon.getPort(), toon.getServerid());
			jTextField_serverAddress.setEditable(true);
			jTextField_serverPort.setEditable(true);
			jTextField_serverID.setEditable(true);
		    }
		    else {
			servers = DAoCStarter.getServer(jComboBox_serverName.getSelectedItem().toString());
			jTextField_serverAddress.setEditable(false);
			jTextField_serverPort.setEditable(false);
			jTextField_serverID.setEditable(false);
		    }
			jTextField_serverAddress.setText(servers.getIndirizzo());
			jTextField_serverPort.setText(Integer.toString(servers.getPorta()));
			jTextField_serverID.setText(Integer.toString(servers.getSid()));
		    }
		catch (Exception e) {
		    System.out.println("errore nel selezionare impostazioni del toon");
		}
		
   }//GEN-LAST:event_jComboBox_serverNameActionPerformed

   private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addActionPerformed
	   JComponent c = (JComponent) evt.getSource();
		if (c.getVerifyInputWhenFocusTarget()) {
			c.requestFocusInWindow();
		if (!c.hasFocus()) {
			return;
			}
		}
	   try {
			String nome = jTextField_name.getText();
			Object object = jComboBox_account.getSelectedItem();
			Account account;
			int accountID = -1;
			if (object instanceof Account) {
				account = (Account)object;
				accountID = account.getId();
			}
			Servers server = (Servers)jComboBox_serverName.getSelectedItem();
			if (server.getNome().equals("Custom")) {
				server.setIndirizzo(jTextField_serverAddress.getText());
				server.setPorta(Integer.parseInt(jTextField_serverPort.getText()));
				server.setSid(Integer.parseInt(jTextField_serverID.getText()));
			}
			String realm = jComboBox_realm.getSelectedItem().toString();
			String classe = jComboBox_class.getSelectedItem().toString();
			String resolution = jComboBox_resolution.getSelectedItem().toString();
			boolean isSelected = jCheckBox_fullscreen.isSelected();
			//check dei campi
			if (!nome.equals("") && !(accountID == -1)) {
				infoDisplayer.putMessage("Ok, toon added");
				DAoCStarter.addToon(nome, accountID, server, realm, classe, resolution, isSelected);
				jList_toons.setModel(DAoCStarter.getToonListModel());
				jTextField_name.setText(null);
				refresh();
			}
			else {
				infoDisplayer.putMessage("Cant add this toon, check parameters");
			}
	   }catch (Exception e) {e.printStackTrace();}
   }//GEN-LAST:event_jButton_addActionPerformed

   private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
		JComponent c = (JComponent) evt.getSource();
		if (c.getVerifyInputWhenFocusTarget()) {
			c.requestFocusInWindow();
		if (!c.hasFocus()) {
			return;
			}
		}
	   String nome = jTextField_name.getText();
		Object object = jComboBox_account.getSelectedItem();
		Account account;
		int accountID = -1;
		if (object instanceof Account) {
			account = (Account)object;
			accountID = account.getId();
		}
		Servers server = (Servers)jComboBox_serverName.getSelectedItem();
		
		if (server.getNome().equals("Custom")) {
			
			server.setIndirizzo(jTextField_serverAddress.getText());
			server.setPorta(Integer.parseInt(jTextField_serverPort.getText()));
			server.setSid(Integer.parseInt(jTextField_serverID.getText()));
		}
		String realm = jComboBox_realm.getSelectedItem().toString();
		String classe = jComboBox_class.getSelectedItem().toString();
		String resolution = jComboBox_resolution.getSelectedItem().toString();
		boolean isSelected = jCheckBox_fullscreen.isSelected();
		int isSelectedInt = 0;
		if (isSelected) {
			isSelectedInt = 1;
		}
		int realmInt;
		switch (realm) {
			case "Albion":
				realmInt = 1;
				break;
			case "Hibernia":
				realmInt =  3;
				break;
			default:
				realmInt = 2;
		}
		//check dei campi
		if (!nome.equals("") && !(accountID == -1)) {
			Toon toon = new Toon(charId, nome, server.getNome(),
					  server.getIndirizzo(), server.getPorta(), realmInt,
					  server.getSid(), accountID, classe, resolution, isSelectedInt);
			DAoCStarter.editToon(toon);
			jList_toons.setModel(DAoCStarter.getToonListModel());
			jTextField_name.setText(null);
			infoDisplayer.putMessage("Ok, edited");
			refresh();
		}
   }//GEN-LAST:event_jButton_saveActionPerformed

   private void jList_toonsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_toonsValueChanged
		JComponent c = (JComponent) evt.getSource();
		if (c.getVerifyInputWhenFocusTarget()) {
			c.requestFocusInWindow();
		if (!c.hasFocus()) {
			// return;
			}
		}
	   Toon toon;
		try {
			Object o = jList_toons.getSelectedValue();
			if (o instanceof Toon) {
				toon = (Toon) jList_toons.getSelectedValue();
				charId = toon.getId();
				jTextField_name.setText(toon.getNome());
				ComboBoxModel model = jComboBox_account.getModel();
				for (int i = 0; i < model.getSize(); i++) {
				//	if (model.getElementAt(i).toString().equals(toon.getAccount())) {
					if (model.getElementAt(i) instanceof Account) {
						Account account = (Account)model.getElementAt(i);
						if (account.getId() == toon.getAccount()) {
							jComboBox_account.setSelectedIndex(i);
						}
					}
				}
				model = jComboBox_serverName.getModel();
				for (int i = 0; i < model.getSize(); i++) {
					if (model.getElementAt(i).toString().equals(toon.getServer())) {
						jComboBox_serverName.setSelectedIndex(i);
					}
				}
				//gestire il custom
				switch (toon.getRealm()) {
					case 1:
						jComboBox_realm.setSelectedItem("Albion");
						break;
					case 2:
						jComboBox_realm.setSelectedItem("Midgard");
						break;
					default:
						jComboBox_realm.setSelectedItem("Hibernia");
				}
				jComboBox_class.setModel(DAoCStarter.getClassComboBoxModel(jComboBox_realm.getSelectedItem()));
				Classi classe = new Classi();
				classe.setClasse(toon.getClasse());
				for (int i = 0; i < jComboBox_class.getItemCount(); i++) {
					if (jComboBox_class.getItemAt(i).toString().equals(toon.getClasse())) {
						jComboBox_class.setSelectedIndex(i);
					} 
				}
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
			}
		}
		catch(Exception e) {
			infoDisplayer.putMessage("Unknow error");
			e.printStackTrace();
		}
   }//GEN-LAST:event_jList_toonsValueChanged

   private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
		JComponent c = (JComponent) evt.getSource();
		if (c.getVerifyInputWhenFocusTarget()) {
			c.requestFocusInWindow();
		if (!c.hasFocus()) {
			 return;
			}
		}
	   Object object = jList_toons.getSelectedValue();
		if (object instanceof Toon) {
			 Toon toon = (Toon) jList_toons.getSelectedValue();
			 DAoCStarter.deleteToon(toon);
			 infoDisplayer.putMessage("Toon deleted");
			 refresh();
			 jTextField_name.setText(null);
		}
   }//GEN-LAST:event_jButton_deleteActionPerformed

   private void jList_toonsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_toonsMouseEntered
		infoDisplayer.putMessage("List of currents toons");
   }//GEN-LAST:event_jList_toonsMouseEntered

   private void jList_toonsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_toonsMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jList_toonsMouseExited

   private void jTextField_nameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_nameMouseEntered
		infoDisplayer.putMessage("Character name");
   }//GEN-LAST:event_jTextField_nameMouseEntered

   private void jTextField_nameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_nameMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jTextField_nameMouseExited

   private void jComboBox_accountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_accountMouseEntered
		infoDisplayer.putMessage("Account name");
   }//GEN-LAST:event_jComboBox_accountMouseEntered

   private void jComboBox_accountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_accountMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jComboBox_accountMouseExited

   private void jComboBox_serverNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_serverNameMouseEntered
		infoDisplayer.putMessage("Server name");
   }//GEN-LAST:event_jComboBox_serverNameMouseEntered

   private void jComboBox_serverNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_serverNameMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jComboBox_serverNameMouseExited

   private void jTextField_serverAddressMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_serverAddressMouseEntered
		infoDisplayer.putMessage("Server address");
   }//GEN-LAST:event_jTextField_serverAddressMouseEntered

   private void jTextField_serverAddressMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_serverAddressMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jTextField_serverAddressMouseExited

   private void jTextField_serverPortMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_serverPortMouseEntered
		infoDisplayer.putMessage("Server port");
   }//GEN-LAST:event_jTextField_serverPortMouseEntered

   private void jTextField_serverPortMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_serverPortMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jTextField_serverPortMouseExited

   private void jTextField_serverIDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_serverIDMouseEntered
		infoDisplayer.putMessage("Server ID");
   }//GEN-LAST:event_jTextField_serverIDMouseEntered

   private void jTextField_serverIDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_serverIDMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jTextField_serverIDMouseExited

   private void jComboBox_realmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_realmMouseEntered
		infoDisplayer.putMessage("Realm");
   }//GEN-LAST:event_jComboBox_realmMouseEntered

   private void jComboBox_realmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_realmMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jComboBox_realmMouseExited

   private void jComboBox_classMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_classMouseEntered
		infoDisplayer.putMessage("Class");
   }//GEN-LAST:event_jComboBox_classMouseEntered

   private void jComboBox_classMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_classMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jComboBox_classMouseExited

   private void jComboBox_resolutionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_resolutionMouseEntered
		infoDisplayer.putMessage("Preferred resolution");
   }//GEN-LAST:event_jComboBox_resolutionMouseEntered

   private void jComboBox_resolutionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_resolutionMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jComboBox_resolutionMouseExited

   private void jCheckBox_fullscreenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_fullscreenMouseEntered
		infoDisplayer.putMessage("FullScreen flag");
   }//GEN-LAST:event_jCheckBox_fullscreenMouseEntered

   private void jCheckBox_fullscreenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_fullscreenMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jCheckBox_fullscreenMouseExited

   private void jButton_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_saveMouseEntered
		infoDisplayer.putMessage("Save current changes");
   }//GEN-LAST:event_jButton_saveMouseEntered

   private void jButton_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_saveMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jButton_saveMouseExited

   private void jButton_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addMouseEntered
		infoDisplayer.putMessage("Add new char");
   }//GEN-LAST:event_jButton_addMouseEntered

   private void jButton_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jButton_addMouseExited

   private void jButton_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_deleteMouseEntered
		infoDisplayer.putMessage("Delete selected char");
   }//GEN-LAST:event_jButton_deleteMouseEntered

   private void jButton_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_deleteMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jButton_deleteMouseExited

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButton_add;
   private javax.swing.JButton jButton_delete;
   private javax.swing.JButton jButton_save;
   private javax.swing.JCheckBox jCheckBox_fullscreen;
   private javax.swing.JComboBox jComboBox_account;
   private javax.swing.JComboBox jComboBox_class;
   private javax.swing.JComboBox jComboBox_realm;
   private javax.swing.JComboBox jComboBox_resolution;
   private javax.swing.JComboBox jComboBox_serverName;
   private javax.swing.JList jList_toons;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTextField jTextField_name;
   private javax.swing.JTextField jTextField_serverAddress;
   private javax.swing.JTextField jTextField_serverID;
   private javax.swing.JTextField jTextField_serverPort;
   // End of variables declaration//GEN-END:variables
}
