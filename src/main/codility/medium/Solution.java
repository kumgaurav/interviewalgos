/**
 * 
 */
package medium;

import java.util.Arrays;

/**
 * @author gkumargaur
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int []A = {-1, 1, 2, 3};
		solution(A);
	}

	public static int solution(int[] A) {
		// write your code in Java SE 8
		int ans = 1;
		// System.out.println("this is a debug message");
		Arrays.sort(A);
		int len = A.length - 1;
		int lastElement = A[len];
		// System.out.println("lastElement -> "+lastElement);
		for (int i = 0; i < lastElement; i++) {
			if (ans != A[i] && A[i] > 0) {
				break;
			}
			System.out.println("-> "+A[i] + ", "+ans);
			if (ans == A[i] && i + 1 < len && ans == A[i + 1]) {
				continue;
			}
			if (A[i] > 0) {
				ans++;
			}
			System.out.println("=> "+A[i] + ", "+ans);
		}
		if(ans == lastElement) {
			ans++;
		}
		System.out.println("ans -> " + ans);
		return ans;
	}

}
