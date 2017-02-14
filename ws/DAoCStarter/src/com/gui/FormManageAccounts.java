package com.gui;

import com.data.Account;
import com.logic.DAoCStarter;
import java.awt.Font;
import java.awt.Toolkit;
import static com.data.DataClass.ICON;
import static com.gui.FormPrincipale.infoDisplayer;
import javax.swing.JComponent;
/**
 * MADE IN ITALY
 * @author simone
 */
public class FormManageAccounts extends javax.swing.JFrame {

	private int accountID = 0;
	
	public FormManageAccounts() {
		initComponents();
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICON)));
		TextPrompt tp1 = new TextPrompt("Account Name", jTextField_ID);
		//tp7.setForeground( Color.RED );
		tp1.changeAlpha(0.5f);
		tp1.changeStyle(+Font.ITALIC);//Font.BOLD
		TextPrompt tp2 = new TextPrompt("Password", jTextField_password);
		//tp7.setForeground( Color.RED );
		tp2.changeAlpha(0.5f);
		tp2.changeStyle(+Font.ITALIC);//Font.BOLD
	}

	public void refresh() {
		jList_accounts.setModel(DAoCStarter.getAccountsListModel());
		SplashScreen.formPrincipale.refreshAccount();
	}
	
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      jTextField_ID = new javax.swing.JTextField();
      jTextField_password = new javax.swing.JTextField();
      jButton_new = new javax.swing.JButton();
      jButton_delete = new javax.swing.JButton();
      jCheckBox_serverMode = new javax.swing.JCheckBox();
      jButton_save = new javax.swing.JButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      jList_accounts = new javax.swing.JList();

      setTitle("Accounts Database Editor");
      setName("frame_manageAccounts"); // NOI18N
      setResizable(false);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowClosing(java.awt.event.WindowEvent evt) {
            formWindowClosing(evt);
         }
      });

      jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

      jTextField_ID.setToolTipText("Account's name");
      jTextField_ID.setInputVerifier(new Verifier());
      jTextField_ID.setName(""); // NOI18N
      jTextField_ID.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jTextField_IDMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jTextField_IDMouseEntered(evt);
         }
      });

      jTextField_password.setToolTipText("Account's password");
      jTextField_password.setInputVerifier(new Verifier());
      jTextField_password.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jTextField_passwordMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jTextField_passwordMouseEntered(evt);
         }
      });

      jButton_new.setText("Add new account");
      jButton_new.setToolTipText("Add a new account");
      jButton_new.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jButton_newMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButton_newMouseEntered(evt);
         }
      });
      jButton_new.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton_newActionPerformed(evt);
         }
      });

      jButton_delete.setText("Delete account");
      jButton_delete.setToolTipText("Delete selected account");
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

      jCheckBox_serverMode.setSelected(true);
      jCheckBox_serverMode.setText("Official Server");
      jCheckBox_serverMode.setToolTipText("Server's type");
      jCheckBox_serverMode.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jCheckBox_serverModeMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jCheckBox_serverModeMouseEntered(evt);
         }
      });

      jButton_save.setText("Save changes");
      jButton_save.setToolTipText("Save current account data");
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

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jTextField_ID)
                     .addComponent(jTextField_password)
                     .addComponent(jButton_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(jButton_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(jButton_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                  .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jCheckBox_serverMode)
                  .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
      );

      jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton_delete, jButton_new, jButton_save});

      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(12, 12, 12)
            .addComponent(jTextField_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(4, 4, 4)
            .addComponent(jCheckBox_serverMode)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton_save)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton_new)
            .addGap(9, 9, 9)
            .addComponent(jButton_delete)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton_delete, jButton_new});

      jList_accounts.setModel(DAoCStarter.getAccountsListModel());
      jList_accounts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      jList_accounts.setToolTipText("List of accounts");
      jList_accounts.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jList_accountsMouseExited(evt);
         }
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jList_accountsMouseEntered(evt);
         }
      });
      jList_accounts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
         public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            jList_accountsValueChanged(evt);
         }
      });
      jScrollPane1.setViewportView(jList_accounts);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1)
            .addContainerGap())
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

    private void jList_accountsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_accountsValueChanged
		JComponent c = (JComponent) evt.getSource();
		if (c.getVerifyInputWhenFocusTarget())
			c.requestFocusInWindow();
		@SuppressWarnings("UnusedAssignment")
		Account account = null;
		try {
			Object o = jList_accounts.getSelectedValue();
			if (o instanceof Account) {
				account = (Account) jList_accounts.getSelectedValue();
				accountID = account.getId();
				jTextField_ID.setText(account.getName());
				jTextField_password.setText(account.getPassword());
				if (account.getType() == 0) {
					jCheckBox_serverMode.setSelected(true);
				} else {
					jCheckBox_serverMode.setSelected(false);
				}
			}
		}
		catch (Exception e) {
			System.out.println("errore nel click account nella lista");
			e.printStackTrace();
		}
    }//GEN-LAST:event_jList_accountsValueChanged

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
		JComponent c = (JComponent) evt.getSource();
		if (c.getVerifyInputWhenFocusTarget()) {
			c.requestFocusInWindow();
			if (!c.hasFocus()) {
					return;
				}
		}
		Object object = jList_accounts.getSelectedValue();
		if (object instanceof Account) {
			 Account account = (Account) jList_accounts.getSelectedValue();
			 DAoCStarter.deleteAccount(account);
			 jList_accounts.setModel(DAoCStarter.getAccountsListModel());
			 refresh();
			 jTextField_ID.setText(null);
			 jTextField_password.setText(null);
		}
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jButton_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_newActionPerformed
		JComponent c = (JComponent) evt.getSource();
		if (c.getVerifyInputWhenFocusTarget()) {
			c.requestFocusInWindow();
			if (!c.hasFocus())
				return;
		}
		String nome = jTextField_ID.getText();
		String password = jTextField_password.getText();
		if (!nome.equals("") && (!password.equals(""))) {
			 int type = 1;
			 if (jCheckBox_serverMode.isSelected()) {
				type = 0;
			 }
			 DAoCStarter.addAccount(nome, password, type);
			 infoDisplayer.putMessage("New account added");
			 refresh();
			 jTextField_ID.setText(null);
			 jTextField_password.setText(null);
		}
    }//GEN-LAST:event_jButton_newActionPerformed

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
		JComponent c = (JComponent) evt.getSource();
		if (c.getVerifyInputWhenFocusTarget()) {
			c.requestFocusInWindow();
			if (!c.hasFocus())
				return;
		}
		
		String nome = jTextField_ID.getText();
		String password = jTextField_password.getText();
		if (!nome.equals("") && (!password.equals(""))) {
			int type = 1;
			if (jCheckBox_serverMode.isSelected()) {
				type = 0;
			}
			DAoCStarter.editAccount(new Account(accountID, nome, password, type));
			jList_accounts.setModel(DAoCStarter.getAccountsListModel());
			refresh();
			infoDisplayer.putMessage("Account edited");
			jTextField_ID.setText(null);
			jTextField_password.setText(null);
		}
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		this.setVisible(false);
		infoDisplayer.putMessage("Manage Account closed");
    }//GEN-LAST:event_formWindowClosing

   private void jList_accountsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_accountsMouseEntered
		infoDisplayer.putMessage("List of currents accounts");
   }//GEN-LAST:event_jList_accountsMouseEntered

   private void jList_accountsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_accountsMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jList_accountsMouseExited

   private void jTextField_IDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_IDMouseEntered
		infoDisplayer.putMessage("Account name");
   }//GEN-LAST:event_jTextField_IDMouseEntered

   private void jTextField_IDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_IDMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jTextField_IDMouseExited

   private void jTextField_passwordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_passwordMouseEntered
		infoDisplayer.putMessage("Account password");
   }//GEN-LAST:event_jTextField_passwordMouseEntered

   private void jTextField_passwordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_passwordMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jTextField_passwordMouseExited

   private void jCheckBox_serverModeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_serverModeMouseEntered
		infoDisplayer.putMessage("Server mode flag");
   }//GEN-LAST:event_jCheckBox_serverModeMouseEntered

   private void jCheckBox_serverModeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_serverModeMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jCheckBox_serverModeMouseExited

   private void jButton_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_saveMouseEntered
		infoDisplayer.putMessage("Save current changes");
   }//GEN-LAST:event_jButton_saveMouseEntered

   private void jButton_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_saveMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jButton_saveMouseExited

   private void jButton_newMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_newMouseEntered
		infoDisplayer.putMessage("Add new account");
   }//GEN-LAST:event_jButton_newMouseEntered

   private void jButton_newMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_newMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jButton_newMouseExited

   private void jButton_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_deleteMouseEntered
		infoDisplayer.putMessage("Delete selected account");
   }//GEN-LAST:event_jButton_deleteMouseEntered

   private void jButton_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_deleteMouseExited
		infoDisplayer.putMessage("Ready");
   }//GEN-LAST:event_jButton_deleteMouseExited

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButton_delete;
   private javax.swing.JButton jButton_new;
   private javax.swing.JButton jButton_save;
   private javax.swing.JCheckBox jCheckBox_serverMode;
   private javax.swing.JList jList_accounts;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTextField jTextField_ID;
   private javax.swing.JTextField jTextField_password;
   // End of variables declaration//GEN-END:variables
}
