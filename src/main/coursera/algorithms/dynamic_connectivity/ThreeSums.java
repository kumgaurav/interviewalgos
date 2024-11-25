package dynamic_connectivity;

public class ThreeSums {
    public static int count(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {30, -40, -20, -10, 40, 0, 10, 5};
        int result = count(nums);
        System.out.println("Number of triplets with sum 0: " + result);
    }
}
