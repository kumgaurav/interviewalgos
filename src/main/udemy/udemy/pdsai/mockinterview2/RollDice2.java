/**
 Question
Given a dice which rolls from 1 to 5, simulate a uniform 7 sided dice!

Requirements¶
You MUST do this on pen and paper or on a whiteboard. No actual coding is allowed until you've come up with a solution by hand!
 */
package udemy.pdsai.mockinterview2;

import java.util.Random;

/**
 * @author gkumargaur
 *
 */
public class RollDice2 {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("convert5to7 -> "+convert5to7());

	}
	
	private static int convert5to7() {
		while(true) {
			int roll_1 =getDice5();
			int roll_2 =getDice5();
			//# Convert the combination to the range 1 to 25
	        int num = ( (roll_1-1) * 5 ) +  ( roll_2 ) ;
	       System.out.println("The converted range number was: "+num); 
	        if (num > 21) {
	            //# re-roll if we are out of range
	            continue;
	        }
	        return (num %7) + 1;
		}
	}
	
	private static int getDice5() {
		return getRandomNumberInRange(1, 5);
	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
