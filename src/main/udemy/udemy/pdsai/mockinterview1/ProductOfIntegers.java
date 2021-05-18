/**
 * Problem
Given a list of integers, write a function that will return a list, in which for each index the element will be the product of all the integers except for the element at that index

For example, an input of [1,2,3,4] would return [24,12,8,6] by performing [2×3×4,1×3×4,1×2×4,1×2×3]

Requirements
You can not use division in your answer! Meaning you can't simply multiply all the numbers and then divide by eahc element for each index!

Try to do this on a white board or with paper/pencil.
 */
package udemy.pdsai.mockinterview1;

import java.util.Arrays;

/**
 * @author gkumargaur
 *
 */
public class ProductOfIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int []input = {1,2,3,4};
		System.out.println("input ->"+Arrays.toString(input));
		int [] result = productOfInt(input); 
		//System.out.println("result ->"+Arrays.toString(result));
		int []input1 = {5};
		result = productOfInt(input1); 
		//System.out.println("result ->"+Arrays.toString(result));
		result = productOfIntV2(input); 
		System.out.println("result ->"+Arrays.toString(result));
	}

	private static int[] productOfInt(int[] input) {
		int len = input.length;
		int [] result = new int[len];
		for(int i=0;i<len;i++) {
			int res=1;
			for(int j=0;j<len;j++) {
				if (i!=j) {
					res = res*input[j];
				}
			}
			result[i]=res;
		}
		return result;
	}
	
	private static int[] productOfIntV2(int[] input) {
		int len = input.length;
		int [] result = new int[len];
		int res=1;
		for(int i=0;i<len;i++) {
			result[i] = res;
			res = res * input[i];
		}
		System.out.println("pr1 ->"+Arrays.toString(result));
		res=1;
		for(int j=len-1;j>=0;j--) {
			System.out.println("res ->"+res+", result[j]->"+result[j]+", input[j]-> "+input[j]);
			result[j] = result[j]*res;
			res = res * input[j];
		}
		System.out.println("pr2 ->"+Arrays.toString(result));
		return result;
	}

}
