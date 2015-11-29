package interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class InterfacesController {
	private static InterfacesController instance = null;
	
	private List<PanelActionToLoad> listaInterfaces=new ArrayList<PanelActionToLoad>();

	private JFrame frame = null;
	private int selectedInterface=-1;

	protected InterfacesController() {}

	public static InterfacesController getInstance() {
		if (instance == null) {
			instance = new InterfacesController();
		}
		return instance;
	}
	
	public void addInterface(PanelActionToLoad panel){
		listaInterfaces.add(panel);
	}
	
	public void setInterface(int index) throws Exception{
		if(frame==null) throw new Exception("Frame is null");
		if(index<0 || index>=listaInterfaces.size()) throw new Exception("Index out of Range");
		if(selectedInterface>=0){
			((JPanel)listaInterfaces.get(selectedInterface)).setVisible(false);
		}
		frame.getContentPane().removeAll();
		((JPanel)listaInterfaces.get(index)).setVisible(true);
		listaInterfaces.get(index).myLoad();
		frame.getContentPane().add((JPanel)listaInterfaces.get(index));
		selectedInterface=index;
	}

	public void setFrame(JFrame frame) {
		this.frame =frame;		
	}

}
