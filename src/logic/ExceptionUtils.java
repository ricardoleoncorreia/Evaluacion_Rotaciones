package logic;

public class ExceptionUtils {

	/*This exception was created to handle the 1 <= n <= 100.000 condition
	 *For this exercise, only no-argument constructor is needed 
	 */
	public class NConditionException extends Exception{
		
		private static final long serialVersionUID = 1L;

		public NConditionException() { 
			super(); 
		}
	}
	
	/*This exception was created to handle the 1 <= d <= n condition
	 * For this exercise, only no-argument constructor is needed
	 */
	public class DConditionException extends Exception{
		
		private static final long serialVersionUID = 1L;

		public DConditionException() { 
			super(); 
		}
	}
	
	/*This exception was created to handle the 1 <= ai <= 1.000.000 condition
	 * For this exercise, only no-argument constructor is needed
	 */
	public class AiConditionException extends Exception{
		
		private static final long serialVersionUID = 1L;

		public AiConditionException() { 
			super(); 
		}
	}
	
}
