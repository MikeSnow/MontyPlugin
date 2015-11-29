package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AltaPanel extends JPanel implements PanelActionToLoad{

	private static final long serialVersionUID = 1L;
	private JButton botonAlta = new JButton("Alta de Usuario");
	private JTextField textUser = new JTextField();
	private JPasswordField passwordUser = new JPasswordField();
	private JPasswordField passwordUserConfirm = new JPasswordField();
	private JLabel lblValidateBiometria =new JLabel("Validación RFID");
	private JLabel lblValidateMagnetic =new JLabel("Validación Biométrica");
	
	public AltaPanel() {
		
		lblValidateMagnetic.setForeground(Color.RED);
		lblValidateBiometria.setForeground(Color.RED);
		
		textUser.setPreferredSize(new Dimension(100, 20));
		passwordUser.setPreferredSize(new Dimension(100, 20));
		passwordUserConfirm.setPreferredSize(new Dimension(100, 20));
		
		botonAlta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Validación de formulario
				
			}
		});
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets= new Insets(5, 5, 5, 5);
		gbc.anchor= GridBagConstraints.LINE_END;
		gbc.fill= GridBagConstraints.BOTH;
		
		gbc.gridx=0;
		gbc.gridy=0;
		add(new JLabel("Nombre de Usuario"),gbc);
		gbc.gridy=1;
		add(new JLabel("Pass de Usuario"),gbc);
		gbc.gridy=2;
		add(new JLabel("Repite pass de Usuario"),gbc);

		gbc.anchor= GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		gbc.gridy=3;
		add(lblValidateMagnetic,gbc);
		gbc.gridy=4;
		add(lblValidateBiometria,gbc);
		
		gbc.gridwidth = 1;
		gbc.anchor= GridBagConstraints.LINE_START;
		gbc.gridx=1;
		gbc.gridy=0;
		add(textUser,gbc);
		gbc.gridy=1;
		add(passwordUser,gbc);
		gbc.gridy=2;
		add(passwordUserConfirm,gbc);
		
		gbc.gridy=5;
		add(botonAlta,gbc);
		
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		addMouseListener(new MouseListener() {			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					InterfacesController.getInstance().setInterface(0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	@Override
	public void myLoad() {
		// TODO Auto-generated method stub
		
	}
}
