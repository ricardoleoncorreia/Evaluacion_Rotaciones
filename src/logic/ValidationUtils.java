package logic;

import java.util.Scanner;

import logic.ExceptionUtils.*;

public class ValidationUtils {

	/*This method checks is an input line is valid
	 * @param line: line to check 
	 */
	public static void isValidLine(String line){
		//Checking that input is not empty or full of blank spaces
		if (line.equals("") || line.replaceAll(" ", "").equals("")){
			throw new IllegalArgumentException();
		}
		/*Checking if each element in line is an integer
		 * When a NumberFormatException appears, IllegalArgumentException will handle it
		 */
		Scanner scanner = new Scanner(line);
		while (scanner.hasNext()){
			Integer.parseInt(scanner.next());
		}
		//Close the scanner and return true
		scanner.close();
		
	}
	
	/*This method checks for first line input requirements
	 * @param n: length of the array
	 * @param d: number of rotations
	 */
	public static void checkRequirements(int n, int d) throws nConditionException, dConditionException{
		if (n < 1 || n > 100000){
			throw new ExceptionUtils().new nConditionException();
		}
		if (d < 1 || d > n){
			throw new ExceptionUtils().new dConditionException();
		}
	}
	
	/*This method checks for second line input requirements
	 * @param array: array to rotate 
	 */
	public static void checkRequirements(int[] array) throws aiConditionException{
		for (int element : array){
			if (element < 1 || element > 1000000){
				throw new ExceptionUtils().new aiConditionException();
			}
		}
	}
	
}
