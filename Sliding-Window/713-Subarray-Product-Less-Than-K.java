class Solution {
    /*
        Method 1: Sliding Window.
        
        For each index 'right', locate the smallest index 'left' which makes a valid range.
        Then ('right' - 'left' + 1) are the number of newly found intervals.
    */
    
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int ans = 0;
        int left = 0;
        int cur = 1;
        
        for (int right = 0; right < nums.length; right++) {
            cur *= nums[right];
            
            while (left <= right && cur >= k) {
                cur /= nums[left];
                left++;
            }
            
            ans += right - left + 1;
        }
        
        return ans;
    }
}