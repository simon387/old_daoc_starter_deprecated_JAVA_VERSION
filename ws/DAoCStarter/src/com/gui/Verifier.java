package com.gui;

import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.UIManager;

class Verifier extends InputVerifier {

	public Verifier() {
	}

	@Override
	public boolean verify(JComponent input) {
    
		JTextField textField = (JTextField) input;               
	
		if (textField.getText().length() > 3 &&
			textField.getText().length() < 30 &&
			!containsWhiteSpace(textField.getText()) //&&
			//!textField.getText().matches("^.*[^a-zA-Z0-9 ].*$")
				) {
			input.setBackground( UIManager.getColor( "TextField.background" ) );    
			return true;
		}
		else {
			input.setBackground( Color.red );    
			return false;      
		}
	}
  
	private static boolean containsWhiteSpace(final String testCode){
		if (testCode != null){
			for(int i = 0; i < testCode.length(); i++){
				if(Character.isWhitespace(testCode.charAt(i))){
					return true;
				}
			}
		}
		return false;
	}
}