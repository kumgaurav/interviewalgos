/**
 * 
 */
package intermediate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gkumargaur
 *
 */
public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int [] nums = {2, 7, 11, 15,7};
		int [] nums = {3,3};
		//int [] nums = {-1,-2,-3,-4,-5};
		int target = 9;
		target = 6;
		target = -8;
		TwoSum ts = new TwoSum();
		int[] res = ts.twoSum(nums, target);
		System.out.println(res[0]+", "+res[1]);
		System.out.println("====================");
		//res = ts.twoSum2(nums, target);
		System.out.println(res[0]+", "+res[1]);

	}
	
	public int[] twoSum(int[] nums, int target) {
        //assuming arrays are in sorted order
		//AtomicInteger index = new AtomicInteger();
		int index =0;
		int rem = 0;
		int indx1 = 0;
		int indx2 = 0;
		int[] res = new int[2];
		//List<Integer[]> targetindex = new ArrayList<>();
		List<Integer> keyFoundlst = new ArrayList<>();
        //List<Integer> numsLst = Arrays.stream(nums).boxed().collect(Collectors.toList());
        //System.out.println(numsLst);
        //Map<Integer, Integer> uniqueNumMap = numsLst.stream().collect(Collectors.toMap(Function.identity(), Function.identity()));
        //System.out.println(uniqueNumMap);
        //Map<Integer, Integer> uniqueNumMap = Arrays.stream(nums).boxed().collect(Collectors.toMap(Function.identity(), i -> index.getAndIncrement(), (e1, e2) -> e2, LinkedHashMap::new));
		Map<Integer, List<Integer>> uniqueNumMap = new LinkedHashMap<>();
		for(int num: nums) {
			if(uniqueNumMap.containsKey(num)) {
				List<Integer> indxLst = uniqueNumMap.get(num);
				indxLst.add(index);
			}else {
				List<Integer> indxLst = new ArrayList<Integer>();
				indxLst.add(index);
				uniqueNumMap.put(num, indxLst);
			}
			index ++;
		}
        System.out.println(uniqueNumMap);
        for(int key :uniqueNumMap.keySet()) {
        	System.out.println("key ->"+key);
        	rem = target - key;
        	//System.out.println("Rem ->"+rem);
        	if(uniqueNumMap.containsKey(rem) && !keyFoundlst.contains(key)) {
        		//targetindex.add(new Integer[] {uniqueNumMap.get(key), uniqueNumMap.get(rem)});
        		indx1 = uniqueNumMap.get(key).get(0);
        		System.out.println("keyVal ->"+uniqueNumMap.get(key));
        		System.out.println(uniqueNumMap.get(rem)+",  "+uniqueNumMap.get(rem).size());
        		indx2= uniqueNumMap.get(rem).size()>1 ? uniqueNumMap.get(rem).get(uniqueNumMap.get(rem).size()-1) : uniqueNumMap.get(rem).get(0);
        		System.out.println(indx1+", RemVal ->"+indx2);
        		keyFoundlst.add(key);
        		keyFoundlst.add(rem);
        		if(indx1 != indx2) {
        			res[0] = indx1;
        			res[1] = indx2;
        		}
        		System.out.println();
        	}
        }
        //targetindex.stream().collect(mapToInt(i -> Integer::intValue, j -> Integer::intValue).toArray());
        //System.out.println(targetindex);
        //System.out.println(res[0]+", "+res[1]);
        return res;
    }
	
	public int[] twoSum2(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}

}
