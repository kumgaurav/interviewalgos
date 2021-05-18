/**
 * 
 */
package udemy.pdsai.mockinterview2;

/**
 * @author gkumargaur
 *
 */
public class NearestSquareRootInteger {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("squareroot -> "+squarerootV2(16));
	}
	
	public static int squareroot(int num) throws Exception {
		if (num<0) throw new Exception("incorrect input");
		if(num==1) return 1;
		int stop = num/2+1;
		int i=2;
		for(;i<stop;i++) {
			if(Math.pow(i,2) == num) return i;
			else if(Math.pow(i, 2) > num) return i-1;
			
		}
		return i;
	}
	
	
	public static int squarerootV2(int num) throws Exception {
		if (num<0) throw new Exception("incorrect input");
		if(num==1) return 1;
		int high = (num/2)+1;
		int low=0;
		int square =0;
		while(low+1<high) {
			int mid =low+(high-low)/2;
			//System.out.println(mid);
			square = mid*mid;
			if( square == num) return mid;
			else if(square < num) low = mid;
			else high = mid;
		}
		return low;
	}

}
