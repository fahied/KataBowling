/**
 * 
 */
package app;

import controller.ScoreCalculator;

/**
 * @author Muhammad Fahied
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		ScoreCalculator calculator = new ScoreCalculator();
		
		//Test 1 : 
		String test1 = "XXXXXXXXXXXX";
		System.out.println(calculator.scoreFromString(test1));
		
		
		//Test 2 : 
		String test2 = "9-9-9-9-9-9-9-9-9-9-";
		System.out.println(calculator.scoreFromString(test2));
		
		
		
		//Test 3 : 
		String test3 =  "5/5/5/5/5/5/5/5/5/5/5";
		System.out.println(calculator.scoreFromString(test3));
		
		
		//Test 4 : 
		String test4 =  "/";
		System.out.println(calculator.scoreFromString(test4));

	}

}
