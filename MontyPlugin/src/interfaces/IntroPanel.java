package interfaces;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class IntroPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton botonComentar = new JButton("Comentar");
	JButton botonPago = new JButton("Pago");	
	JButton botonAgregarUser = new JButton("Agregar Usuario");
	
	public IntroPanel(){
		
		botonComentar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Llamada al panel de reconocimento RFID
				try {
					InterfacesController.getInstance().setInterface(1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		
		botonPago.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Llamada al panel de BioMetria
				try {
					InterfacesController.getInstance().setInterface(2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		botonAgregarUser.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Llamada al panel de Creación de usuarios
				try {
					InterfacesController.getInstance().setInterface(3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc= new GridBagConstraints();
		
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.insets = new Insets(5,5,5,5);
		
		gbc.gridx=0;
		gbc.gridy=0;		
		add(botonComentar, gbc);
		
		gbc.gridx=2;
		gbc.gridy=0;		
		add(botonPago, gbc);	
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=2;
		add(botonAgregarUser, gbc);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}
