class Solution {
    /*
        Method 1 : Iterative
    */
    
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) return 0;
        
        int left = 1, right = nums.length - 2;
        
        // Find initial left boundary
        while (left < nums.length && nums[left] >= nums[left - 1]) {
            left++;
        }
        
        // Find initial right boundary
        while (right >= 0 && nums[right] <= nums[right + 1]) {
            right--;
        }
        
        // Condition 1 : already sorted
        if (left == nums.length || right < 0) return 0;
        
        // Get min, max in A[left - 1, right + 1]
        int min = nums[left], max = nums[left];
        for (int i = left - 1; i <= right + 1; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        // Find final left boundary
        for (int i = 0; i < left; i++) {
            if (nums[i] > min) {
                left = i;
                break;
            }
        }
        
        // Find final right boundary
        for (int i = nums.length - 1; i > right; i--) {
            if (nums[i] < max) {
                right = i;
                break;
            }
        }
        
        return right - left + 1;
    }
}