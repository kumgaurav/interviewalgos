/**
 * 
 */
package medium;

/**
 * @author gkumargaur
 *
 */
public class BinaryGap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println("Solution -> "+solution(1610612737));
		System.out.println("Solution -> "+solution(32));
	}
	
	public static int solution(int N) {
        int ans = 0;
        String bstr = Integer.toBinaryString(N);
        System.out.println("bstr -> "+bstr);
        String[] bgArr = bstr.split("1");
        int len = bgArr.length;
        char lastChar = bstr.charAt(bstr.length()-1);
        System.out.println("len -> "+len+", lastChar -> "+lastChar);
        int i = 0;
        if(len >= 2){
            for(String bg: bgArr){
                System.out.println("bg["+i+"] -> "+bg + ", "+bg.trim().length());
                if(i+1 == len && bg.trim().length() > 0 && lastChar != '1'){
                    break;
                } 
                if(bg.length()>ans)
                    ans = bg.length();
                i++;
                   
            }
        }
        return ans;
    }
	
	public int solution2(int N) {
        // write your code in Java SE 8
        
        int max_gap = 0;
        int current_gap =0;
        boolean counting = false; 
        
        // Using the "concept of bit manipulation" and "& operation"
        
        while( N !=0 ){
        
            if(counting == false){    // for the first "1"   
                if( (N&1) == 1){      // note: cannot use n&1 withoug "()"
                    counting = true;  // start to count
                }
            }
            else{                    // counting = true
                if( (N&1) ==0){      // note: cannot use n&1 withoug "()"
                    current_gap ++;  
                }
                else{ // N & 1 == 1
                    max_gap = Math.max(max_gap, current_gap);
                    current_gap = 0; // reset
                }
            }
            
            N = N >> 1; // shift by one (right side) 
                        // note: cannot just write "N >> 1"
        }
        
        return max_gap;
    }

}
