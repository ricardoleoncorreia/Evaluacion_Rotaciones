package logic;

public class ExceptionUtils {

	/**
	 * This exception was created to handle n condition
	 * For this exercise, only no-argument constructor is needed 
	 */
	public class NConditionException extends Exception{
		
		private static final long serialVersionUID = 1L;

		public NConditionException() { 
			super(); 
		}
	}
	
	/**
	 * This exception was created to handle d condition
	 * For this exercise, only no-argument constructor is needed
	 */
	public class DConditionException extends Exception{
		
		private static final long serialVersionUID = 1L;

		public DConditionException() { 
			super(); 
		}
	}
	
	/**
	 * This exception was created to handle ai condition
	 * For this exercise, only no-argument constructor is needed
	 */
	public class AiConditionException extends Exception{
		
		private static final long serialVersionUID = 1L;

		public AiConditionException() { 
			super(); 
		}
	}
	
	/**
	 * This exception was created to alert when the first line is shorter or longer than expected
	 * For this exercise, only no-argument constructor is needed
	 */
	public class FirstLineLengthException extends Exception{
		
		private static final long serialVersionUID = 1L;

		public FirstLineLengthException() { 
			super(); 
		}
	}
	
	/**
	 * This exception was created to alert when the second line is shorter or longer than expected
	 * For this exercise, only no-argument constructor is needed
	 */
	public class SecondLineLengthException extends Exception{
		
		private static final long serialVersionUID = 1L;

		public SecondLineLengthException() { 
			super(); 
		}
	}
	
}
