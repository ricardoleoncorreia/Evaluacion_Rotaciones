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
	 * Constant that indicates we are working with first line
	 */
	public static final int FIRST_LINE = 1;
	
	/**
	 * Constant that indicates we are working with second line
	 */
	public static final int SECOND_LINE = 2;
	
	/**
	 * Private constructor to prevents another developer instantiate this class
	 */
	private ValidationUtils(){}
	
	/**
	 * This method checks is an input line is valid
	 * @param line Line to check
	 * @param lineNumber Number of the line it is working with 
	 * @param n Number of elements for second line
	 * @return Integer arrayList
	 * @throws FirstLineLengthException Throws exception when the number of integers in first line is not 2
	 * @throws SecondLineLengthException Throws exception when the number of integers in second line is not n
	 */
	public static ArrayList<Integer> checkLine(String line, int lineNumber, int n) throws FirstLineLengthException, SecondLineLengthException {

		//Checking that input is not empty or full of blank spaces
		checkIfEmpty(line);
		
		/* Checking if each element in line is an integer
		 * When a NumberFormatException appears, IllegalArgumentException will handle it
		 * If input is as required, builds the array
		 * Finally, close scanner
		 */
		ArrayList<Integer> array = new ArrayList<Integer>();
		Scanner scanner = new Scanner(line);
		while (scanner.hasNext()){
			array.add(Integer.parseInt(scanner.next()));
		}
		scanner.close();
		
		//Check the array
		checkIfRequiredLegth(lineNumber, array, n);
		
		return array;
	}
	
	//Checks if the array has the right length
	private static void checkIfRequiredLegth(int lineNumber, ArrayList<Integer> array, int n) throws FirstLineLengthException, SecondLineLengthException {
		if (lineNumber == FIRST_LINE){
			if (array.size() != 2){
				throw new ExceptionUtils().new FirstLineLengthException();
			}
		} else {
			if (array.size() != n){
				throw new ExceptionUtils().new SecondLineLengthException(); 
			}
		}
	}

	//Checks if empty line was provided
	private static void checkIfEmpty(String line) {
		if (line.equals("") || line.replaceAll(" ", "").equals("")){
			throw new IllegalArgumentException();
		}
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
