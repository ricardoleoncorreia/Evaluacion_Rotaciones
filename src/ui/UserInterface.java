package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class UserInterface {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

}

class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public MainFrame(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize().getSize();
		int height = (int) screenSize.getHeight();
		int width = (int) screenSize.getWidth();
		setTitle("Rotacion a la izquierda");
		setBounds(width/4, height/4, width/2, height/4);
		add(new MainPanel());
		pack();
	}
	
}