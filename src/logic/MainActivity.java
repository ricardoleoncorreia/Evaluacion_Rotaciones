package logic;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity {

	private static final String INPUT_LINE = "Ingrese la primera línea:";
	
	public static void main(String[] args) {
		System.out.println(INPUT_LINE);
		Scanner in = new Scanner(System.in);
		String firstLine = in.nextLine();
		//Checking first input
		if (ValidationUtils.isFirstLineValid(firstLine)){
			String secondLine = in.nextLine();
			//Checking second input
			if (ValidationUtils.isSecondLineValid(secondLine)){
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
				
			}			
		}else{
			
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
