package logic;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import logic.ExceptionUtils.*;
import ui.MainPanel;

/**
 * This class contains all the code to solve the problem
 * @author Rick
 *
 */
public class MainActivity {

	//Error messages
	private static final String EMPTY_LINE_MESSAGE = "Ambas líneas deben contener únicamente números enteros separados por espacios";
	private static final String N_CONDITION_MESSAGE = "El valor del primer número de la primera línea (n) debe estar entre 1 y 100.000";
	private static final String D_CONDITION_MESSAGE = "El valor del segundo número de la primera línea (d) debe estar entre 1 y ";
	private static final String AI_CONDITION_MESSAGE = "Cada elemento de la matriz de la segunda línea debe estar entre 1 y 1.000.000";
	private static final String FIRST_LINE_LENGTH_MESSAGE = "La primera línea debe tener exactamente dos números enteros separados por un espacio";
	private static final String SECOND_LINE_LENGTH_MESSAGE_1 = "La segunda línea debe tener exactamente ";
	private static final String SECOND_LINE_LENGTH_MESSAGE_2 = " números enteros separados por espacios";
	
	private static final String ALERT_TITLE = "Revisar las líneas ingresadas";
	
	private static int n = 0;
	private static int d = 0;
	
	/**
	 * Executes all the code
	 * @param firstLine Input first line
	 * @param secondLine Input second line
	 */
	public static void executeActivity(String firstLine, String secondLine) {
		try{
			
			//Checking first input
			ArrayList<Integer> firstLineArray = ValidationUtils.isValidLine(firstLine, ValidationUtils.FIRST_LINE, n);
			
			//Checking requirements for first line
			n = firstLineArray.get(0);
			d = firstLineArray.get(1);
			ValidationUtils.checkRequirements(n, d);
			
			//Checking second input
			ArrayList<Integer> array = ValidationUtils.isValidLine(secondLine, ValidationUtils.SECOND_LINE, n);
			ValidationUtils.checkRequirements(array);
			
			//Rotating operation
			rotateArray(array, d);
			
			//String Builder to show result
			showResult(array);
			
		} catch (IllegalArgumentException e){
			
			//If a line is empty, show message
			JOptionPane.showMessageDialog(null, EMPTY_LINE_MESSAGE, ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
			
		} catch (NConditionException e){
			
			//If n condition is not satisfied, show message
			JOptionPane.showMessageDialog(null, N_CONDITION_MESSAGE, ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
			
		} catch (DConditionException e){
			
			//If d condition is not satisfied, show message
			JOptionPane.showMessageDialog(null, D_CONDITION_MESSAGE + n, ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
			
		} catch (AiConditionException e){
			
			//If ai condition is not satisfied, show message
			JOptionPane.showMessageDialog(null, AI_CONDITION_MESSAGE, ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
			
		} catch (FirstLineLengthException e) {
			
			//If first line length is not the right one, show message
			JOptionPane.showMessageDialog(null, FIRST_LINE_LENGTH_MESSAGE, ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
			
		} catch (SecondLineLengthException e) {
			
			//If second line length is not the right one, show message
			JOptionPane.showMessageDialog(null, SECOND_LINE_LENGTH_MESSAGE_1 + n + SECOND_LINE_LENGTH_MESSAGE_2, ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
			
		}
	}

	/**
	 * This method rotates the array
	 * @param array Array to rotate
	 * @param numberOfRotations Number of rotations
	 */
	private static void rotateArray(ArrayList<Integer> array, int numberOfRotations){
		
		for (int i = 0; i < numberOfRotations; i++){
			array.add(array.get(0));
			array.remove(0);
		}
		
	}

	/**
	 * This method builds and shows the result for client
	 * @param array Array to show as a result of the process
	 */
	private static void showResult(ArrayList<Integer> array) {
		
		StringBuilder sb = new StringBuilder();
		for (int a : array)
		{
		    sb.append(a);
		    sb.append(" ");
		}
		MainPanel.setResultToUI(sb.toString());
		
	}
	
}
