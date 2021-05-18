/**
 * This is a new problem we haven't seen directly before! Many times this question is asked in the form of functions e.g. your given a function random_7() and you have to take it as an input and create random_5()

The key to solving this problem is to make sure you focus on the requirement that the final distribution of the rolls be uniform, also you were not given any requirements on Time and Space, so the solution is actually very simple, just keep re-rolling if you get a number greater than 5!

We can code this out:
 */
package udemy.pdsai.mockinterview2;

import java.util.Random;

/**
 * @author gkumargaur
 *
 */
public class RollDice1 {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		convert7to5();

	}
	
	private static int convert7to5() {
		int roll =7;
		while(roll >5) {
			roll = getDice7();
			System.out.println("dice7() produced a roll of "+roll);
		}
		System.out.println("Your final returned roll is below:"+roll);
		return roll;
	}
	
	private static int getDice7() {
		return getRandomNumberInRange(1, 7);
	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
