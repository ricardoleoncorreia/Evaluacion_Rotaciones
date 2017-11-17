package logic;

import java.util.ArrayList;
import java.util.Scanner;

import logic.ExceptionUtils.*;

/**
 * This class provides helpful methods for MainActivity validation processes
 * like line validation and requirements checkers
 */
public class ValidationUtils {

	/**
	 * This method checks is an input line is valid
	 * @param line Line to check
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
	
	/**
	 * This method checks for first line input requirements
	 * @param n Length of the array
	 * @param d Number of rotations
	 * @throws NConditionException n condition was not satisfied 
	 * @throws DConditionException d condition was not satisfied
	 */
	public static void checkRequirements(int n, int d)	throws NConditionException, DConditionException{

		//Checks 1 <= n <= 100.000 condition
		if (n < 1 || n > 100000){
			throw new ExceptionUtils().new NConditionException();
		}
		
		//Checks 1 <= d <= n condition
		if (d < 1 || d > n){
			throw new ExceptionUtils().new DConditionException();
		}
	}
	
	/**
	 * This method checks for second line input requirements
	 * @param array Array to rotate
	 * @throws AiConditionException ai condition was not satisfied
	 */
	public static void checkRequirements(ArrayList<Integer> array) throws AiConditionException{
		
		//Check 1 <= ai <= 1.000.000 condition
		for (int element : array){
			if (element < 1 || element > 1000000){
				throw new ExceptionUtils().new AiConditionException();
			}
		}
	}
	
}
