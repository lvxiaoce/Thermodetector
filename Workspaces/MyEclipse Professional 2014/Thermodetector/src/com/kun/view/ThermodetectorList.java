package com.kun.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ThermodetectorList extends JPanel {
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public ThermodetectorList() {
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("list页面");
		lblNewLabel.setBounds(81, 85, 108, 94);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(199, 117, 108, 32);
		add(textField);
		textField.setColumns(10);
	}

}
