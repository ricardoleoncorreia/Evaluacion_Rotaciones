package logic;

import java.util.Scanner;

import logic.ExceptionUtils.*;

public class MainActivity {

	private static final String INPUT_FIRST_LINE = "Ingrese la primera l�nea:";
	private static final String INPUT_SECOND_LINE = "Ingrese la segunda l�nea:";
	private static final String EMPTY_LINE_MESSAGE = "La l�nea debe contener �nicamente n�meros enteros";
	private static final String INDEX_OUT_OF_BOUNDS_MESSAGE = "La primera l�nea debe tener dos n�meros enteros";
	private static final String N_CONDITION_MESSAGE = "El valor del primer n�mero (n) debe estar entre 1 y 100.000";
	private static final String D_CONDITION_MESSAGE = "El valor del segundo n�mero (d) debe estar entre 1 y n";
	private static final String AI_CONDITION_MESSAGE = "Cada elemento de la matriz debe estar entre 1 y 1.000.000";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println(INPUT_FIRST_LINE);
			String firstLine = in.nextLine();
			//Checking first input
			ValidationUtils.isValidLine(firstLine);
			//Checking requirements for first line
			int[] firstLineArray = convertToArray(firstLine, 2);
			int n = firstLineArray[0];
			int d = firstLineArray[1];
			ValidationUtils.checkRequirements(n, d);
			System.out.println(INPUT_SECOND_LINE);
			String secondLine = in.nextLine();
			//Checking second input
			ValidationUtils.isValidLine(secondLine);
			int[] array = convertToArray(secondLine, n);
			ValidationUtils.checkRequirements(array);
			//Rotating operation
			rotateArray(array, d);
			//String Builder to show result
			StringBuilder sb = new StringBuilder();
			for (int a : array)
			{
			    sb.append(a);
			    sb.append(" ");
			}
			System.out.println(sb.toString());
		}catch (IllegalArgumentException e){
			//If a line is empty, show message
			System.out.println(EMPTY_LINE_MESSAGE);
		}catch (IndexOutOfBoundsException e){
			//If a line is empty, show
			System.out.println(INDEX_OUT_OF_BOUNDS_MESSAGE);
		}catch (nConditionException e){
			//If a line is empty, show
			System.out.println(N_CONDITION_MESSAGE);
		}catch (dConditionException e){
			//If a line is empty, show
			System.out.println(D_CONDITION_MESSAGE);
		}catch (aiConditionException e){
			//If a line is empty, show
			System.out.println(AI_CONDITION_MESSAGE);
		}finally{
			//Before program finishes, close Scanner
			in.close();
		}
	}
	
	// This method helps to convert the line into an array
	private static int[] convertToArray(String input, int length){
		int[] array = new int[length];
		int i = 0;
		Scanner in = new Scanner(input);
		//in.useDelimiter("[^0-9]+");
		while (in.hasNextInt()){
			array[i] = in.nextInt();
			i++;
		}
		in.close();
		return array;
	}
	
	private static void rotateArray(int[] array, int numberOfRotations){
		int tempInt;
		int lastElement = array.length - 1;
		for (int i = 0; i < numberOfRotations; i++){
			//Save first element in a temporary variable and do rotation
			tempInt = array[0];
			//Switching elements positions
			for (int j = 0; j < lastElement; j++){
				array[j] = array[j+1];
			}
			//Changing last element
			array[lastElement] = tempInt;
		}
		
	}

}
