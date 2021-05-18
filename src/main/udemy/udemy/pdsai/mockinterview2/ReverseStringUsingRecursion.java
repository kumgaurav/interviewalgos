/**
 * 
 */
package udemy.pdsai.mockinterview2;

import java.util.Arrays;

/**
 * @author gkumargaur
 *
 */
public class ReverseStringUsingRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "professional";
		char arr[] = str.toCharArray();
		arr = reverse(arr,0);
		System.out.println(Arrays.toString(arr));
	}
	
	public static char[] reverse(char arr[], int n) {
		int len = arr.length;
		if(len<=1 || n<0) {
			return arr;
		}
		if(n>len/2) {
			return arr;
		}else {
			char temp = arr[n];
			arr[n]=arr[len-1-n];
			arr[len-1-n]=temp;
			reverse(arr, n+1);
		}
		return arr;
	}

}
