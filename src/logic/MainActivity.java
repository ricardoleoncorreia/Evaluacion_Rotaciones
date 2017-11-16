package logic;

import java.util.ArrayList;
import java.util.Scanner;

import logic.ExceptionUtils.*;

public class MainActivity {

	private static final String INPUT_FIRST_LINE = "Ingrese la primera línea:";
	private static final String INPUT_SECOND_LINE = "Ingrese la segunda línea:";
	private static final String EMPTY_LINE_MESSAGE = "La línea debe contener únicamente números enteros";
	private static final String INDEX_OUT_OF_BOUNDS_MESSAGE = "La longitud seleccionada (n) no coincide con la longitud de la matriz en la segunda línea";
	private static final String N_CONDITION_MESSAGE = "El valor del primer número (n) debe estar entre 1 y 100.000";
	private static final String D_CONDITION_MESSAGE = "El valor del segundo número (d) debe estar entre 1 y n";
	private static final String AI_CONDITION_MESSAGE = "Cada elemento de la matriz debe estar entre 1 y 1.000.000";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println(INPUT_FIRST_LINE);
			String firstLine = in.nextLine();
			//Checking first input
			ValidationUtils.isValidLine(firstLine);
			//Checking requirements for first line
			ArrayList<Integer> firstLineArray = convertToArray(firstLine);
			int n = firstLineArray.get(0);
			int d = firstLineArray.get(1);
			ValidationUtils.checkRequirements(n, d);
			System.out.println(INPUT_SECOND_LINE);
			String secondLine = in.nextLine();
			//Checking second input
			ValidationUtils.isValidLine(secondLine);
			ArrayList<Integer> array = convertToArray(secondLine);
			ValidationUtils.checkRequirements(array);
			//Rotating operation
			for (int i = 0; i < d; i++){
				array.add(array.get(0));
				array.remove(0);
			}
			//String Builder to show result
			StringBuilder sb = new StringBuilder();
			for (int a : array)
			{
			    sb.append(a);
			    sb.append(" ");
			}
			System.out.println(sb.toString());
		}catch (IllegalArgumentException e){
			//If a line is empty, show
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
	private static ArrayList<Integer> convertToArray(String input){
		ArrayList<Integer> array = new ArrayList<Integer>();
		Scanner in = new Scanner(input);
		//in.useDelimiter("[^0-9]+");
		while (in.hasNextInt()){
			array.add(in.nextInt());
		}
		in.close();
		return array;
	}

}
