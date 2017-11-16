package logic;

public class ExceptionUtils {

	/*This exception was created to handle the 1 <= n <= 100.000 condition
	 *For this exercise, only no-argument constructor is needed 
	 */
	public class nConditionException extends Exception{
		
		private static final long serialVersionUID = 1L;

		public nConditionException() { 
			super(); 
		}
	}
	
	/*This exception was created to handle the 1 <= d <= n condition
	 * For this exercise, only no-argument constructor is needed
	 */
	public class dConditionException extends Exception{
		
		private static final long serialVersionUID = 1L;

		public dConditionException() { 
			super(); 
		}
	}
	
	/*This exception was created to handle the 1 <= ai <= 1.000.000 condition
	 * For this exercise, only no-argument constructor is needed
	 */
	public class aiConditionException extends Exception{
		
		private static final long serialVersionUID = 1L;

		public aiConditionException() { 
			super(); 
		}
	}
	
}
