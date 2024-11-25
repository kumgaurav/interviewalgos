package dynamic_connectivity;

import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class ImprovedThreeSums {
    public static int count(int nums[]) {
        int n = nums.length;
        int count = 0;
        if (nums.length<1)
            throw new IllegalArgumentException("Input array must have at least one element.");
        Arrays.sort(nums);
        System.out.println("Sorted Array : "+ Arrays.toString(nums));
        if (containsDuplicate(nums))
            throw new IllegalArgumentException("Input array contains duplicate elements.");
        for (int i = 0 ; i < n; i++) {
            if(nums[i] == 0)
                continue;
            for (int j = i + 1; j < n; j++) {
                int target = nums[i] + nums[j];
                int idx = binarySearch(nums, -target);
                if (idx >= 0 && idx != i && idx != j) {
                    count++;
                    System.out.println(String.format("Triplet found: %d, %d, %d", nums[i], nums[j], nums[idx]));
                    break;
                }
            }
        }
        return count;
    }

    private static boolean containsDuplicate(int []nums){
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {30, -40, -20, -10, 40, 0, 10, 5};

        int result = count(nums);
        System.out.println("Number of triplets with sum 0: " + result);
    }
}
