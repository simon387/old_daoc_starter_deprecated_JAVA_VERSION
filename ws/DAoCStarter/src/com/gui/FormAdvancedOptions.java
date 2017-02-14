package com.gui;

import com.logic.DAoCStarter;
import java.awt.Toolkit;
import static com.data.DataClass.ICON;
/**
 * MADE IN ITALY
 * @author simone
 */
public class FormAdvancedOptions extends javax.swing.JFrame {

	public FormAdvancedOptions() {
		initComponents();
		String [] array = DAoCStarter.refreshAdvancedOption();
		jComboBox1.setSelectedItem(array[0]);
		setCombos();
		jComboBox2.setSelectedItem(array[1]);
		jComboBox3.setSelectedItem(array[2]);
		jComboBox4.setSelectedItem(array[3]);
		jComboBox5.setSelectedItem(array[4]);
		jComboBox6.setSelectedItem(array[5]);
		jComboBox7.setSelectedItem(array[6]);
		jComboBox8.setSelectedItem(array[7]);
		jComboBox9.setSelectedItem(array[8]);
		jComboBox10.setSelectedItem(array[9]);
		jComboBox11.setSelectedItem(array[10]);
		jComboBox12.setSelectedItem(array[11]);
		jComboBox13.setSelectedItem(array[12]);
		jComboBox14.setSelectedItem(array[13]);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICON)));
	}

    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      jComboBox1 = new javax.swing.JComboBox();
      jLabel2 = new javax.swing.JLabel();
      jComboBox8 = new javax.swing.JComboBox();
      jLabel3 = new javax.swing.JLabel();
      jComboBox2 = new javax.swing.JComboBox();
      jLabel4 = new javax.swing.JLabel();
      jComboBox9 = new javax.swing.JComboBox();
      jLabel5 = new javax.swing.JLabel();
      jComboBox3 = new javax.swing.JComboBox();
      jLabel6 = new javax.swing.JLabel();
      jComboBox10 = new javax.swing.JComboBox();
      jLabel7 = new javax.swing.JLabel();
      jComboBox4 = new javax.swing.JComboBox();
      jLabel8 = new javax.swing.JLabel();
      jComboBox11 = new javax.swing.JComboBox();
      jLabel9 = new javax.swing.JLabel();
      jComboBox5 = new javax.swing.JComboBox();
      jLabel10 = new javax.swing.JLabel();
      jComboBox12 = new javax.swing.JComboBox();
      jLabel11 = new javax.swing.JLabel();
      jComboBox6 = new javax.swing.JComboBox();
      jLabel12 = new javax.swing.JLabel();
      jComboBox13 = new javax.swing.JComboBox();
      jLabel13 = new javax.swing.JLabel();
      jComboBox7 = new javax.swing.JComboBox();
      jLabel14 = new javax.swing.JLabel();
      jComboBox14 = new javax.swing.JComboBox();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Advanced Options");
      setResizable(false);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowClosing(java.awt.event.WindowEvent evt) {
            formWindowClosing(evt);
         }
      });

      jLabel1.setText("general audio");

      jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "on", "off" }));
      jComboBox1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox1ActionPerformed(evt);
         }
      });

      jLabel2.setText("dynamic shadows");

      jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "on", "low", "high" }));
      jComboBox8.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox8ActionPerformed(evt);
         }
      });

      jLabel3.setText("ambient music volume");

      jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "full", "9", "8", "7", "6", "5", "4", "3", "2", "1", "off" }));
      jComboBox2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox2ActionPerformed(evt);
         }
      });

      jLabel4.setText("water");

      jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "classic", "SI", "reflective" }));
      jComboBox9.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox9ActionPerformed(evt);
         }
      });

      jLabel5.setText("ambient sound volume");

      jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "full", "9", "8", "7", "6", "5", "4", "3", "2", "1", "off" }));
      jComboBox3.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox3ActionPerformed(evt);
         }
      });

      jLabel6.setText("reflection quality");

      jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "low", "medium", "high" }));
      jComboBox10.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox10ActionPerformed(evt);
         }
      });

      jLabel7.setText("music volume");

      jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "full", "9", "8", "7", "6", "5", "4", "3", "2", "1", "off" }));
      jComboBox4.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox4ActionPerformed(evt);
         }
      });

      jLabel8.setText("reflection update");

      jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "often", "occasional", "seldom" }));
      jComboBox11.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox11ActionPerformed(evt);
         }
      });

      jLabel9.setText("sound volume");

      jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "full", "9", "8", "7", "6", "5", "4", "3", "2", "1", "off" }));
      jComboBox5.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox5ActionPerformed(evt);
         }
      });

      jLabel10.setText("atlantis terrain");

      jComboBox12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "on", "off" }));
      jComboBox12.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox12ActionPerformed(evt);
         }
      });

      jLabel11.setText("sleep mode");

      jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "background", "never", "minimized" }));
      jComboBox6.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox6ActionPerformed(evt);
         }
      });

      jLabel12.setText("atlantis tree");

      jComboBox13.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "on", "off" }));
      jComboBox13.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox13ActionPerformed(evt);
         }
      });

      jLabel13.setText("shadow figures");

      jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none", "all figures", "self only", "near 5 figures", "near 10 figures" }));
      jComboBox7.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox7ActionPerformed(evt);
         }
      });

      jLabel14.setText("character version");

      jComboBox14.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "classic", "catacombs" }));
      jComboBox14.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox14ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel1)
               .addComponent(jLabel3)
               .addComponent(jLabel5)
               .addComponent(jLabel7)
               .addComponent(jLabel9)
               .addComponent(jLabel13)
               .addComponent(jLabel11))
            .addGap(31, 31, 31)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jComboBox5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel14)
                  .addGap(33, 33, 33)
                  .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel12)
                  .addGap(33, 33, 33)
                  .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel10)
                  .addGap(33, 33, 33)
                  .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel8)
                  .addGap(33, 33, 33)
                  .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel6)
                  .addGap(33, 33, 33)
                  .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel4)
                  .addGap(33, 33, 33)
                  .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel2)
                  .addGap(33, 33, 33)
                  .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel1)
               .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel2))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel3)
               .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel4))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel5)
               .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel6))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel7)
               .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel8))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel9)
               .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel10))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel11)
               .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel12))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel13)
               .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel14))
            .addGap(0, 0, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		 this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

	 private void setCombos() {
		 if (jComboBox1.getSelectedItem().toString().equals("on")) {
				jComboBox2.setEnabled(true);
				jComboBox3.setEnabled(true);
				jComboBox4.setEnabled(true);
				jComboBox5.setEnabled(true);
			}
			else {
				jComboBox2.setEnabled(false);
				jComboBox3.setEnabled(false);
				jComboBox4.setEnabled(false);
				jComboBox5.setEnabled(false);
			}
	 }
	 
   private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
		if (evt.getModifiers() > 0) {
			setCombos();
			DAoCStarter.optionChanged(1, jComboBox1.getSelectedItem().toString());
		}
   }//GEN-LAST:event_jComboBox1ActionPerformed

   private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
      DAoCStarter.optionChanged(2, jComboBox2.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox2ActionPerformed

   private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
      DAoCStarter.optionChanged(3, jComboBox3.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox3ActionPerformed

   private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
      DAoCStarter.optionChanged(4, jComboBox4.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox4ActionPerformed

   private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
      DAoCStarter.optionChanged(5, jComboBox5.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox5ActionPerformed

   private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
      DAoCStarter.optionChanged(6, jComboBox6.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox6ActionPerformed

   private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
      DAoCStarter.optionChanged(7, jComboBox7.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox7ActionPerformed

   private void jComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox8ActionPerformed
      DAoCStarter.optionChanged(8, jComboBox8.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox8ActionPerformed

   private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
      DAoCStarter.optionChanged(9, jComboBox9.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox9ActionPerformed

   private void jComboBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox10ActionPerformed
      DAoCStarter.optionChanged(10, jComboBox10.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox10ActionPerformed

   private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11ActionPerformed
      DAoCStarter.optionChanged(11, jComboBox11.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox11ActionPerformed

   private void jComboBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox12ActionPerformed
      DAoCStarter.optionChanged(12, jComboBox12.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox12ActionPerformed

   private void jComboBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox13ActionPerformed
      DAoCStarter.optionChanged(13, jComboBox13.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox13ActionPerformed

   private void jComboBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox14ActionPerformed
      DAoCStarter.optionChanged(14, jComboBox14.getSelectedItem().toString());
   }//GEN-LAST:event_jComboBox14ActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JComboBox jComboBox1;
   private javax.swing.JComboBox jComboBox10;
   private javax.swing.JComboBox jComboBox11;
   private javax.swing.JComboBox jComboBox12;
   private javax.swing.JComboBox jComboBox13;
   private javax.swing.JComboBox jComboBox14;
   private javax.swing.JComboBox jComboBox2;
   private javax.swing.JComboBox jComboBox3;
   private javax.swing.JComboBox jComboBox4;
   private javax.swing.JComboBox jComboBox5;
   private javax.swing.JComboBox jComboBox6;
   private javax.swing.JComboBox jComboBox7;
   private javax.swing.JComboBox jComboBox8;
   private javax.swing.JComboBox jComboBox9;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel10;
   private javax.swing.JLabel jLabel11;
   private javax.swing.JLabel jLabel12;
   private javax.swing.JLabel jLabel13;
   private javax.swing.JLabel jLabel14;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JLabel jLabel9;
   private javax.swing.JPanel jPanel1;
   // End of variables declaration//GEN-END:variables
}
