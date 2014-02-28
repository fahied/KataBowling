/**
 * 
 */
package model;

/**
 * @author Muhammad Fahied
 *
 */
public class Roll {
	
	public String value;
	public int score;
	public int frame;
	public boolean isFirstRoll;
	
	
	public boolean isStrike() 
	{
		return this.value.equalsIgnoreCase("X");
	}
	
	public boolean isSpare()
	{
		return this.value.equalsIgnoreCase("/");
	}
	
	public boolean isMissed()
	{
		return this.value.equalsIgnoreCase("-");
	}

}
