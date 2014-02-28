/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import model.Roll;

/**
 * @author Muhammad Fahied
 *
 */
public class ScoreCalculator {

	
	/**
	 *  Score from String
	 *
	 *  @param resultString 
	 *
	 *  @return <#return value description#>
	 */
	public int scoreFromString(String resultString)
	{
		// get list of rolls from the resultString
		List<Roll>rolls = rollsFromString(resultString);
		
		int totalScroe = 0;
		int bonus = 0;
		
		for (int index = 0; index < rolls.size(); index++) {
	        Roll roll = rolls.get(index);
	        
	        // total score
	        totalScroe += roll.score;

	        // bonus score
	        if (roll.frame < 10) {
	            if (roll.isStrike()) {
	                Roll next = rolls.get(index + 1);
	                Roll next2 = rolls.get(index + 2);
	                bonus += next.score + next2.score;
	            }
	            else if (roll.isSpare()) {
	                Roll next = rolls.get(index + 1);
	                bonus += next.score;
	            }
	        }
	    }
		
		return totalScroe+bonus;
	}
	
	
	public List<Roll> rollsFromString(String resultString)
	{
		
		List<Roll>rolls = new ArrayList<>();
		int frame = 1;
		boolean isFirstRoll = true;
		
		
		for (int index = 0; index < resultString.length(); index++) {
	        Roll roll = new Roll();

	        // roll property
	        roll.value = resultString.substring(index, index+1);
	        roll.frame = frame;
	        roll.isFirstRoll = isFirstRoll;

	        if (roll.isStrike()) {
	            roll.score = 10;
	        }
	        else if (roll.isSpare()) {
	        	//need more modifications
	            Roll prev = rolls.get(rolls.size() -1 );
	            roll.score = 10 - prev.score;
	        }
	        else if (roll.isMissed()){
	        		 roll.score = 0;
	        }
	        else
	            roll.score =Integer.parseInt(roll.value);
	        
	        // add to array
	        rolls.add(roll);

	        // next roll property
	        if (!isFirstRoll ||roll.isStrike() || roll.isSpare()) {
	            isFirstRoll = true;
	            frame++;
	        }
	        else {
	            isFirstRoll = false;
	        }
	    }
		return rolls;
	}

}


/*
 * 
 * 
 * - (NSArray *)rollsFromString:(NSString *)string
{
    NSMutableArray *rolls = [NSMutableArray array];
    NSInteger frame = 1;
    BOOL isFirstRoll = YES;
    
    for (NSInteger index = 0; index < [string length]; index++) {
        Roll *roll = [[Roll alloc] init];

        // roll property
        roll.string = [string substringWithRange:NSMakeRange(index, 1)];
        roll.frame = frame;
        roll.isFirstRoll = isFirstRoll;

        if ([roll isStrike]) {
            roll.score = 10;
        }
        else if ([roll isSpare]) {
            Roll *prev = [rolls lastObject];
            roll.score = 10 - prev.score;
        }
        else {
            roll.score = [roll.string integerValue];

        }
        
        // add to array
        [rolls addObject:roll];

        // next roll property
        if (!isFirstRoll || [roll isStrike] || [roll isSpare]) {
            isFirstRoll = YES;
            frame++;
        }
        else {
            isFirstRoll = NO;
        }
    }

    return rolls;
}

 * 
 * */
 