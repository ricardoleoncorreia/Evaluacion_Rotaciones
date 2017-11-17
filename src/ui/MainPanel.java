package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel mLabelLine1, mLabelLine2, mLabelExample1, mLabelExample2, mLabelResultText, mLabelResultArray;
	private JTextField mTextFieldLine1, mTextFieldLine2;
	private JButton mExecute, mReset;
	private JPanel southPanel, centerPanel;
	
	private static final String LINE_1_LABEL = "Inserte la línea 1:    ";
	private static final String LINE_2_LABEL = "Inserte la línea 2:    ";
	private static final String EXAMPLE_1_LABEL = "   Ej: 7 3";
	private static final String EXAMPLE_2_LABEL = "   Ej: 25 1 36 958 45 101 5987   ";
	private static final String RESULT_LABEL = "   Resultado:   ";
	private static final String EXECUTE_BUTTON = "Ejecutar";
	private static final String RESET_BUTTON = "Reiniciar";
	

	public MainPanel(){
		
		setLayout(new BorderLayout());
		
		//Prepare all swing components
		prepareSwingComponents();
		
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
		centerPanel = new JPanel();
		mExecute.addActionListener(new ActionListener(){
			//Define execute button action
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String firstLine = mTextFieldLine1.getText().toString();
				String SecondLine = mTextFieldLine2.getText().toString();
				southPanel.setVisible(true);
				centerPanel.setVisible(false);
			}	
		});
		centerPanel.add(mExecute);
		add(centerPanel, BorderLayout.CENTER);
		
		//Prepare south panel
		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 3));
		southPanel.add(mLabelResultText);
		southPanel.add(mLabelResultArray);
		JPanel resetPanel = new JPanel(); 
		mReset.addActionListener(new ActionListener(){
			//Define reset button action
			@Override
			public void actionPerformed(ActionEvent e) {
				mTextFieldLine1.setText("");
				mTextFieldLine2.setText("");
				southPanel.setVisible(false);
				centerPanel.setVisible(true);
			}
		});
		resetPanel.add(mReset);
		southPanel.add(resetPanel);
		southPanel.setVisible(false);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	private void prepareSwingComponents(){
		mLabelLine1 = new JLabel(LINE_1_LABEL, SwingConstants.RIGHT);
		mLabelLine2 = new JLabel(LINE_2_LABEL, SwingConstants.RIGHT);
		mLabelExample1 = new JLabel(EXAMPLE_1_LABEL);
		mLabelExample2 = new JLabel(EXAMPLE_2_LABEL);
		mLabelResultText = new JLabel(RESULT_LABEL, SwingConstants.RIGHT);
		mLabelResultArray = new JLabel("", SwingConstants.CENTER);
		mTextFieldLine1 = new JTextField();
		mTextFieldLine2 = new JTextField();
		mExecute = new JButton(EXECUTE_BUTTON);
		mReset = new JButton(RESET_BUTTON);
	}
	
}
