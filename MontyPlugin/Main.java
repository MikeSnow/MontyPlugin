import java.awt.GraphicsEnvironment;
import java.awt.Point;

import interfaces.AltaPanel;
import interfaces.ComentarioPanel;
import interfaces.InterfacesController;
import interfaces.IntroPanel;
import interfaces.PagoPanel;

import javax.swing.JFrame;


public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		JFrame frame= new JFrame("MontyPlugin");
		
		/**
		 * TODO 
		 * 1. Llama al panel de Login usr/pass
		 * 2. Si la validación es correcta pasamos al IntroPanel
		 */
		
		InterfacesController iController = InterfacesController.getInstance();
		
		IntroPanel introPanel = new IntroPanel();
		ComentarioPanel comentarioPanel = new ComentarioPanel();
		PagoPanel pagoPanel = new PagoPanel();
		AltaPanel altaPanel = new AltaPanel();
		
		iController.setFrame(frame);
		
		iController.addInterface(introPanel); // id 0
		iController.addInterface(comentarioPanel); //id 1
		iController.addInterface(pagoPanel); // id 2
		iController.addInterface(altaPanel); // id 3
		
		iController.setInterface(0);
		
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int windowWidth = 400;
		int windowHeight = 300;
		// set position and size
		frame.setBounds(center.x - windowWidth/2, center.y - windowHeight/2, windowWidth, windowHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
