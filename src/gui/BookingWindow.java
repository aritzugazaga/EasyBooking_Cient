package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextField;

import DTO.VueloDTO;
import controller.BookingController;

public class BookingWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private DefaultListModel<String> listmodel;


	public BookingWindow() {
		initialize();
	}

	@SuppressWarnings("unused")
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 135, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(135, 0, 299, 261);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Buscar Vuelo");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 102, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aeropuerto Origen");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 43, 102, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Aeropuerto Destino");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 99, 115, 14);
		panel.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(10, 68, 102, 20);
		panel.add(textField);
		textField.setColumns(10);
		String aeropuertoOrigen = textField.getText();
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 124, 102, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		String aeropuertoDestino = textField_1.getText();
		
		listmodel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listmodel);
		panel_1.add(list);
		listmodel = (DefaultListModel<String>) list.getModel();
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aeropuertoOrigen = textField.getText();
				String aeropuertoDestino = textField_1.getText();
				List<VueloDTO> listaVuelo = BookingController.getInstance().buscarVuelos(aeropuertoOrigen, aeropuertoDestino);
				for(VueloDTO l : listaVuelo) 
					listmodel.addElement(l.toString());
			}
		});
		btnNewButton.setBounds(10, 171, 102, 23);
		panel.add(btnNewButton);
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
