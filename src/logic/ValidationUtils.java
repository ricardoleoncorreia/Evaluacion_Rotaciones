package logic;

import java.util.Scanner;

public class ValidationUtils {

	private ValidationUtils(){}
	
	public static boolean isValidLine(String line){
		//Checking that input is not empty or full of blank spaces
		if (line.equals("") || line.replaceAll(" ", "").equals("")){
			return false;
		}
		//Checking if each character in line is an integer
		Scanner scanner = new Scanner(line);
		while (scanner.hasNext()){
			try{
				Integer.parseInt(scanner.next());
			}catch (NumberFormatException nfe){
				//If false, return false as validation result and close the scanner
				System.out.println("NumberFormatException");
				scanner.close();
				return false;
			}
		}
		//Successful validation, close the scanner and return true
		scanner.close();
		return true;
	}
	
	public static boolean isSecondLineValid(String secondLine){
		
		return true;
	}
	
}
