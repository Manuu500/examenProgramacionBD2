package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import controller.ControladorInquilino;
import controller.ControladorLocalidad;
import controller.ControladorVivienda;
import model.Inquilino;
import model.Localidad;
import model.Vivienda;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PanelAlquiler extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	JComboBox comboBox;
	JComboBox comboBox_1;
	JCheckBox chckbxNewCheckBox; 

	/**
	 * Create the panel.
	 */
	public PanelAlquiler() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Modificacion de alquileres");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Localidad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		comboBox = new JComboBox();
		cargarLocalidadesEnJCombo();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					comboBox_1.removeAllItems();
					cargarViviendasEnJComboID1();
				}
				if(comboBox.getSelectedIndex() == 1) {
					comboBox_1.removeAllItems();
					cargarViviendasEnJComboID2();
				}
			}
		});
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Vivienda");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 2;
		gbc_lblNewLabel_1_1.gridy = 3;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_1.getSelectedIndex() == 0 && comboBox.getSelectedIndex() == 0) {
					encuentraInquilino();
				}
				if(comboBox_1.getSelectedIndex() == 1 && comboBox.getSelectedIndex() == 0) {	
					encuentraInquilino2();
				}
				
				if(comboBox_1.getSelectedIndex() == 0 && comboBox.getSelectedIndex() == 1) {
					encuentraInquilino3();
				}
				if(comboBox_1.getSelectedIndex() == 1 && comboBox.getSelectedIndex() == 1) {
					encuentraInquilino4();
				}
			}
		});
		
		
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 4;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 3;
		add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Datos del inquilino");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Id:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 5;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("DNI");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1.gridx = 2;
		gbc_lblNewLabel_3_1.gridy = 6;
		add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 6;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3_2 = new JLabel("Nombre completo");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3_2 = new GridBagConstraints();
		gbc_lblNewLabel_3_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_2.gridx = 2;
		gbc_lblNewLabel_3_2.gridy = 7;
		add(lblNewLabel_3_2, gbc_lblNewLabel_3_2);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 4;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 7;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3_3 = new JLabel("Fecha inicio");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3_3 = new GridBagConstraints();
		gbc_lblNewLabel_3_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_3.gridx = 2;
		gbc_lblNewLabel_3_3.gridy = 8;
		add(lblNewLabel_3_3, gbc_lblNewLabel_3_3);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 4;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 8;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		chckbxNewCheckBox = new JCheckBox("Alquiler en activo");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected() == true) {
					textField_4.setEnabled(false);
					textField_4.setText(null);
				}
				else {
					textField_4.setEnabled(true);				
				}
			}
		});
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 3;
		gbc_chckbxNewCheckBox.gridy = 9;
		add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Fecha de fin");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1_1.gridx = 2;
		gbc_lblNewLabel_3_1_1.gridy = 10;
		add(lblNewLabel_3_1_1, gbc_lblNewLabel_3_1_1);
		
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 4;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 10;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Cuota mensual");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_3_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1_2.gridx = 2;
		gbc_lblNewLabel_3_1_2.gridy = 11;
		add(lblNewLabel_3_1_2, gbc_lblNewLabel_3_1_2);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 4;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 11;
		add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("Total mensual(IVA incluido)");
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_3_1_3.gridwidth = 2;
		gbc_lblNewLabel_3_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1_3.gridx = 1;
		gbc_lblNewLabel_3_1_3.gridy = 12;
		add(lblNewLabel_3_1_3, gbc_lblNewLabel_3_1_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hacer despues");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 12;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modificar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 13;
		add(btnNewButton, gbc_btnNewButton);

		
		cargarViviendasEnJComboID1();
	}

	
	/**
	 * 
	 */
	private void cargarLocalidadesEnJCombo() {
		List<Localidad> lista = ControladorLocalidad.encuentraTodos();
		for (Localidad listas : lista) {
			this.comboBox.addItem(listas);
		}
	}
	
	

	/**
	 * 
	 */
	private void cargarViviendasEnJComboID1() {
		List<Vivienda> lista = ControladorVivienda.encuentraTodosID1();
		for (Vivienda listas : lista) {
			this.comboBox_1.addItem(listas);
		}
	}
	
	
	/**
	 * 
	 */
	private void cargarViviendasEnJComboID2() {
		List<Vivienda> lista = ControladorVivienda.encuentraTodosID2();
		for (Vivienda listas : lista) {
			this.comboBox_1.addItem(listas);
		}
	}
	
	
	/**
	 * @return 
	 * 
	 */
	public void encuentraInquilino() {
		Inquilino c = ControladorInquilino.encuentraPrimerRegistro();
		if(c != null) {
			
			this.textField.setText(" " + c.getId());
			this.textField_1.setText((c.getDni()));
			this.textField_2.setText(c.getNombreCompleto());
			this.textField_3.setText(c.getFechaInicioAlquiler());
			this.textField_4.setText(c.getFechaFinAlquiler());
			this.textField_5.setText("" + c.getCuotaMensual());
			
			if(chckbxNewCheckBox.isSelected() == true) {
				textField_4.setText(null);
			}
			else {
				textField_4.setText(c.getFechaFinAlquiler());
			}
		}
	}
	
	
	/**
	 * @return 
	 * 
	 */
	public void encuentraInquilino2() {
		Inquilino c = ControladorInquilino.encuentraPrimerRegistro2();
		if(c != null) {
			this.textField.setText(" " + c.getId());
			this.textField_1.setText((c.getDni()));
			this.textField_2.setText(c.getNombreCompleto());
			this.textField_3.setText(c.getFechaInicioAlquiler());
			this.textField_4.setText(c.getFechaFinAlquiler());
			this.textField_5.setText("" + c.getCuotaMensual());
			
			if(chckbxNewCheckBox.isSelected() == true) {
				textField_4.setText(null);
			}
			else {
				textField_4.setText(c.getFechaFinAlquiler());
			}
		}
	}
	
	
	/**
	 * @return 
	 * 
	 */
	public void encuentraInquilino3() {
		Inquilino c = ControladorInquilino.encuentraPrimerRegistro3();
		if(c != null) {
			this.textField.setText(" " + c.getId());
			this.textField_1.setText((c.getDni()));
			this.textField_2.setText(c.getNombreCompleto());
			this.textField_3.setText(c.getFechaInicioAlquiler());
			this.textField_4.setText(c.getFechaFinAlquiler());
			this.textField_5.setText("" + c.getCuotaMensual());
			
			if(chckbxNewCheckBox.isSelected() == true) {
				textField_4.setText(null);
			}
			else {
				textField_4.setText(c.getFechaFinAlquiler());
			}
		}
	}
	
	
	/**
	 * @return 
	 * 
	 */
	public void encuentraInquilino4() {
		Inquilino c = ControladorInquilino.encuentraPrimerRegistro4();
		if(c != null) {
			this.textField.setText(" " + c.getId());
			this.textField_1.setText((c.getDni()));
			this.textField_2.setText(c.getNombreCompleto());
			this.textField_3.setText(c.getFechaInicioAlquiler());
			this.textField_4.setText(c.getFechaFinAlquiler());
			this.textField_5.setText("" + c.getCuotaMensual());
			
			if(chckbxNewCheckBox.isSelected() == true) {
				textField_4.setText(null);
			}
			else {
				textField_4.setText(c.getFechaFinAlquiler());
			}
		}
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void modificar() throws SQLException {
		Inquilino c = new Inquilino();
		
		c.setId(Integer.parseInt(this.textField.getText().trim()));
		c.setDni(this.textField_1.getText());
		c.setNombreCompleto(this.textField_2.getText());
		c.setFechaInicioAlquiler(this.textField_3.getText());
		c.setFechaFinAlquiler(this.textField_4.getText());
		c.setCuotaMensual(Float.parseFloat(textField_5.getText()));
		
		int rowsAffected = ControladorInquilino.modificar(c);
		if (rowsAffected == 1) {
			JOptionPane.showConfirmDialog(null, "Guardado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "Algo ha fallado");
		}
	}
	
}
