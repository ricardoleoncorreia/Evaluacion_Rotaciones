package logic;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity {

	private static final String INPUT_FIRST_LINE = "Ingrese la primera línea:";
	private static final String INPUT_SECOND_LINE = "Ingrese la primera línea:";
	
	public static void main(String[] args) {
		System.out.println(INPUT_FIRST_LINE);
		Scanner in = new Scanner(System.in);
		String firstLine = in.nextLine();
		//Checking first input
		if (ValidationUtils.isValidLine(firstLine)){
			System.out.println(INPUT_SECOND_LINE);
			String secondLine = in.nextLine();
			//Checking second input
			if (ValidationUtils.isValidLine(secondLine)){
				//Convert inputs in arrays
				ArrayList<Integer> arrayFirstLine = convertToArray(firstLine);
				ArrayList<Integer> array = convertToArray(secondLine);
				//Getting number of operations
				int d = arrayFirstLine.get(1);
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
			}else{
				System.out.println("Error en la fila 2");
			}			
		}else{
			System.out.println("Error en la fila 1");
		}
		in.close();
		
	}
	
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
