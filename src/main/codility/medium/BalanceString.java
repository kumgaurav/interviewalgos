/**
 * 
 */
package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * @author gkumargaur
 *
 */
public class BalanceString {

	public int balancedStringSplit(String s) {
		int len = s.length();
		int balance = 0;
		Stack<Character> stk = new Stack<>();
		List<Character> allowedChars = new ArrayList<Character>(Arrays.asList('L','R'));
		if( (len <= 1 && len >= 1000) || (len %2 != 0))
			return -1;
        char arr[] = s.toCharArray();
        char firstChar = arr[0];
        System.out.println("stk.size() "+stk.size());
        for(char ch:arr) {
        	if(!allowedChars.contains(ch)) {
        		return -1;
        	}
        	if(stk.isEmpty()) {
        		stk.push(ch);
        		balance ++;
        	}else {
        		if(ch == stk.peek()) {
        			stk.push(ch);
        		}else {
        			Character res = stk.pop();
        			if(res == null) {
        				return -1;
        			}
        		}
        	}
        	/*if (ch == firstChar) {
        		balance ++;
        	}else if(balance == 0) {
        		balance ++;
        	} else {
        		balance --;
        	}*/
        	System.out.println(balance);
        }
        System.out.println("stk.size() "+stk.size());
        return balance;
    }
    
    public static void main(String args[]){
    	BalanceString bs = new BalanceString();
        String s = "RLRRLLRLRL";
        s = "RLLLLRRRLR";
        s = "LLLLRRRR";
        s = "RLRRRLLRLL";
        int res = bs.balancedStringSplit(s);
        System.out.println("Res -> "+res);
    }
    
    
    //preffred solution
    public int balancedStringSplitPreffered(String s) {
        
        int count = 0;
        int z = s.charAt(0)=='L' ? 1 : -1;
        
        for(int i=1; i<s.length(); ++i){
            z += s.charAt(i)=='L' ? 1 : -1;
            
            if(z==0)
                count++;
        }
        
        return count;
    }

}
