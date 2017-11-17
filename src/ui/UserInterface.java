package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * This class is the responsible for creating the UI
 * @author Ricardo Le�n
 */
public class UserInterface {

	public static void main(String[] args) {

		//Create the main frame
		MainFrame mainFrame = new MainFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

}

/**
 * This class sets MainFrame
 */
class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private static final String FRAME_TITLE = "Rotaci�n a la izquierda";

	public MainFrame(){
		
		//Get Screen Size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize().getSize();
		int height = (int) screenSize.getHeight();
		int width = (int) screenSize.getWidth();

		//Add title, bounds, add MainPanel and pack the frame
		setTitle(FRAME_TITLE);
		setBounds(width/4, height/4, width/2, height/4);
		add(new MainPanel());
		pack();
	}
	
}