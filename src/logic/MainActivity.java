package logic;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import logic.ExceptionUtils.*;
import ui.MainPanel;

public class MainActivity {

	/*private static final String INPUT_FIRST_LINE = "Ingrese la primera línea:";
	private static final String INPUT_SECOND_LINE = "Ingrese la segunda línea:";*/
	private static final String EMPTY_LINE_MESSAGE = "Ambas líneas deben contener únicamente números enteros";
	private static final String N_CONDITION_MESSAGE = "El valor del primer número (n) debe estar entre 1 y 100.000";
	private static final String D_CONDITION_MESSAGE = "El valor del segundo número (d) debe estar entre 1 y n";
	private static final String AI_CONDITION_MESSAGE = "Cada elemento de la matriz debe estar entre 1 y 1.000.000";
	private static final String FIRST_LINE_LENGTH_MESSAGE = "La primera línea debe tener exactamente dos números enteros";
	private static final String SECOND_LINE_LENGTH_MESSAGE_1 = "La segunda línea debe tener exactamente ";
	private static final String SECOND_LINE_LENGTH_MESSAGE_2 = " números enteros";
	
	private static final String ALERT_TITLE = "Revisar las líneas ingresadas";
	
	private static final int FIRST_LINE = 1;
	private static final int SECOND_LINE = 2;
	
	private static int n = 0;
	private static int d = 0;
	
	public static void executeActivity(String firstLine, String secondLine) {
		//Scanner in = new Scanner(System.in);
		try{
			/*System.out.println(INPUT_FIRST_LINE);
			String firstLine = in.nextLine();*/
			//Checking first input
			ValidationUtils.isValidLine(firstLine);
			//Checking requirements for first line
			ArrayList<Integer> firstLineArray = convertToArray(firstLine, FIRST_LINE);
			n = firstLineArray.get(0);
			d = firstLineArray.get(1);
			ValidationUtils.checkRequirements(n, d, firstLineArray.size());
			/*System.out.println(INPUT_SECOND_LINE);
			String secondLine = in.nextLine();*/
			//Checking second input
			ValidationUtils.isValidLine(secondLine);
			ArrayList<Integer> array = convertToArray(secondLine, SECOND_LINE);
			ValidationUtils.checkRequirements(n, array);
			//Rotating operation
			rotateArray(array, d);
			//String Builder to show result
			showResult(array);
		} catch (IllegalArgumentException e){
			//If a line is empty, show message
			JOptionPane.showMessageDialog(null, EMPTY_LINE_MESSAGE, ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
			//System.out.println(EMPTY_LINE_MESSAGE);
		} catch (NConditionException e){
			//If n condition is not satisfied, show message
			JOptionPane.showMessageDialog(null, N_CONDITION_MESSAGE, ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
			//System.out.println(N_CONDITION_MESSAGE);
		} catch (DConditionException e){
			//If d condition is not satisfied, show message
			JOptionPane.showMessageDialog(null, D_CONDITION_MESSAGE, ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
			//System.out.println(D_CONDITION_MESSAGE);
		} catch (AiConditionException e){
			//If ai condition is not satisfied, show message
			JOptionPane.showMessageDialog(null, AI_CONDITION_MESSAGE, ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
			//System.out.println(AI_CONDITION_MESSAGE);
		} catch (FirstLineLengthException e) {
			//If first line length is not the right one, show message
			JOptionPane.showMessageDialog(null, FIRST_LINE_LENGTH_MESSAGE, ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
			//System.out.println(FIRST_LINE_LENGTH_MESSAGE);
		} catch (SecondLineLengthException e) {
			//If second line length is not the right one, show message
			JOptionPane.showMessageDialog(null, SECOND_LINE_LENGTH_MESSAGE_1 + n + SECOND_LINE_LENGTH_MESSAGE_2, ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
			//System.out.println(SECOND_LINE_LENGTH_MESSAGE_1 + n + SECOND_LINE_LENGTH_MESSAGE_2);
		}/* finally {
			//Before program finishes, close Scanner
			in.close();
		}*/
	}

	// This method helps to convert the line into an array
	private static ArrayList<Integer> convertToArray(String input, int lineNumber) 
			throws FirstLineLengthException, SecondLineLengthException{
		//Get the array
		ArrayList<Integer> array = new ArrayList<Integer>();
		Scanner in = new Scanner(input);
		while (in.hasNextInt()){
			array.add(in.nextInt());
		}
		in.close();
		//Check the array
		if (lineNumber == FIRST_LINE){
			if (array.size() != 2){
				throw new ExceptionUtils().new FirstLineLengthException();
			}
		} else {
			if (array.size() != n){
				throw new ExceptionUtils().new SecondLineLengthException(); 
			}
		}
		return array;
	}
	
	//This method rotates the array
	private static void rotateArray(ArrayList<Integer> array, int numberOfRotations){
		for (int i = 0; i < numberOfRotations; i++){
			array.add(array.get(0));
			array.remove(0);
		}
	}

	//This method builds and shows the result for client
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
