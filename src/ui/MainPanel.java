package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel mLabelLine1, mLabelLine2, mLabelExample1, mLabelExample2, mLabelResultText, mLabelResultArray;
	private JTextField mTextFieldLine1, mTextFieldLine2;
	private JButton mExecute, mReset;
	
	private static final String LINE_1_LABEL = "Inserte la línea 1: ";
	private static final String LINE_2_LABEL = "Inserte la línea 2: ";
	private static final String EXAMPLE_1_LABEL = "Ej: 7 3";
	private static final String EXAMPLE_2_LABEL = "Ej: 25 1 36 958 45 101 5987";
	private static final String RESULT_LABEL = "Resultado de su operación";
	private static final String EXECUTE_BUTTON = "Ejecutar";
	private static final String RESET_BUTTON = "Reiniciar";
	

	public MainPanel(){
		setLayout(new BorderLayout());
		
		//Prepare all swing components
		mLabelLine1 = new JLabel(LINE_1_LABEL);
		mLabelLine2 = new JLabel(LINE_2_LABEL);
		mLabelExample1 = new JLabel(EXAMPLE_1_LABEL);
		mLabelExample2 = new JLabel(EXAMPLE_2_LABEL);
		mLabelResultText = new JLabel(RESULT_LABEL);
		mLabelResultArray = new JLabel();
		mTextFieldLine1 = new JTextField();
		mTextFieldLine2 = new JTextField();
		mExecute = new JButton(EXECUTE_BUTTON);
		mReset = new JButton(RESET_BUTTON);
		
		//Prepare northPanel
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 3));
		northPanel.add(mLabelLine1);
		northPanel.add(mTextFieldLine1);
		northPanel.add(mLabelExample1);
		northPanel.add(mLabelLine2);
		northPanel.add(mTextFieldLine2);
		northPanel.add(mLabelExample2);
		add(northPanel, BorderLayout.NORTH);
		
		//Prepare center panel
		JPanel centerPanel = new JPanel();
		centerPanel.add(mExecute);
		add(centerPanel, BorderLayout.CENTER);
		
		//Prepare south panel
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 3));
		southPanel.add(mLabelResultText);
		southPanel.add(mLabelResultArray);
		JPanel resetPanel = new JPanel(); 
		resetPanel.add(mReset);
		southPanel.add(resetPanel);
		add(southPanel, BorderLayout.SOUTH);
	}
	
}
