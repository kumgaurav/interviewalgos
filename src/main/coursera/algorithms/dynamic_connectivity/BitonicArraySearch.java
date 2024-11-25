package dynamic_connectivity;

public class BitonicArraySearch {
    private static boolean containsDuplicate(int []nums){
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static int findPeak(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }



    private static int binarySearch(int[] nums, int left, int right, int target) {
        if(nums[left] == target)
            return left;
        else if(nums[right] == target)
            return right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        if(containsDuplicate(nums))
            throw new IllegalArgumentException("Input array contains duplicate elements.");
        int peakIndex = findPeak(nums);
        if (target == nums[peakIndex]) {
            return peakIndex;
        }

        int leftIndex = binarySearch(nums, 0, peakIndex - 1, target);
        if (leftIndex != -1) {
            return leftIndex;
        }

        int rightIndex = binarySearch(nums, peakIndex + 1, nums.length - 1, target);
        return rightIndex;
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 9, 8, 7, 6, 5};
        int targetNumber = search(nums, 5);
        if(targetNumber != -1) {
            System.out.println("Target number " + 5 + " found at index " + targetNumber);
        } else {
            System.out.println("Target number " + 5 + " not found in the array");

        }
    }
}
