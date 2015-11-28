package interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class InterfacesController {
	private static InterfacesController instance = null;
	
	private List<JPanel> listaInterfaces=new ArrayList<JPanel>();

	private JFrame frame = null;
	private int selectedInterface=-1;

	protected InterfacesController() {}

	public static InterfacesController getInstance() {
		if (instance == null) {
			instance = new InterfacesController();
		}
		return instance;
	}
	
	public void addInterface(JPanel panel){
		listaInterfaces.add(panel);
	}
	
	public void setInterface(int index) throws Exception{
		if(frame==null) throw new Exception("Frame is null");
		if(index<0 || index>=listaInterfaces.size()) throw new Exception("Index out of Range");
		if(selectedInterface>=0){
			listaInterfaces.get(selectedInterface).setVisible(false);
		}
		frame.getContentPane().removeAll();
		listaInterfaces.get(index).setVisible(true);
		frame.getContentPane().add(listaInterfaces.get(index));
		selectedInterface=index;
	}

	public void setFrame(JFrame frame) {
		this.frame =frame;		
	}

}
