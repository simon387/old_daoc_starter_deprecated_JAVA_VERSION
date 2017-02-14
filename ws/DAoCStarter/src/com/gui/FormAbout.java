package com.gui;

import java.awt.Toolkit;
import static com.data.DataClass.ICON;
/**
 * MADE IN ITALY
 * @author simone
 */
public class FormAbout extends javax.swing.JFrame {

	public FormAbout() {
		initComponents();
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICON)));
	}

	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();

      setAlwaysOnTop(true);
      setUndecorated(true);
      setResizable(false);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowClosing(java.awt.event.WindowEvent evt) {
            formWindowClosing(evt);
         }
      });

      jLabel1.setText("<html><pre>\nCreated by Simon387\n\nTesters and ideas: C@stro, hawk'~, Madcastah, Vindicare, Ferdi\n\nHandle.exe Copyright (C) 1997-2012 Mark Russinovich\nDOLLoader - DOL Project\nVentrilo© Flagship Industries, Inc. All right reserved\nTeamSpeak© TeamSpeak Systems GmbH. All rights reserved\nDark Age of Camelot, Copyright (C) 2001-13 Mythic Entertainment, Inc\nWIRC GNU General Public License v3\n</pre></html>"); // NOI18N
      jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel1MouseClicked(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addContainerGap())
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
            .addContainerGap())
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

   private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		this.setVisible(false);
   }//GEN-LAST:event_formWindowClosing

   private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
		this.setVisible(false);
   }//GEN-LAST:event_jLabel1MouseClicked

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel jLabel1;
   private javax.swing.JPanel jPanel1;
   // End of variables declaration//GEN-END:variables
}
