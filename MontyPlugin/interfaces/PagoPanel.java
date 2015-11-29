package interfaces;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PagoPanel extends JPanel implements PanelActionToLoad {
	/**
	 * 
	 */
	JLabel lbl = new JLabel("Has entrado en la zona Critica");
	
	private static final long serialVersionUID = 1L;

	public PagoPanel() {
		lbl.setVisible(false);
		lbl.setForeground(Color.YELLOW);
		
		setBorder(BorderFactory.createLineBorder(Color.RED));
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
					lbl.setVisible(false);
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
		String s = null;
		
        try {
//        	/home/juanruiz/repositorios/MontyPlugin
//        	String[] cmd = {"/bin/bash","-c","echo \"123456\"| gksudo python /home/juanruiz/repositorios/MontyPlugin/Reconocimiento.py"};
//        	String[] cmd = {"/bin/bash","-c","sudo -S python /home/juanruiz/repositorios/MontyPlugin/Reconocimiento.py"};
        	Process p = Runtime.getRuntime().exec("gksudo python Reconocimiento.py");
//        	Process p = Runtime.getRuntime().exec(cmd);
        	
            BufferedReader stdInput = new BufferedReader(new
                 InputStreamReader(p.getInputStream()));
 
            BufferedReader stdError = new BufferedReader(new
                 InputStreamReader(p.getErrorStream()));
 
            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
             
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                if(!lbl.isVisible()){
                	lbl.setVisible(true);
                }
            	System.out.println(s);
            }
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
        }

	}
}
