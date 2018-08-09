class Solution {
	/*
		Method 1: Iterative
		
		Maintain a local sum to keep track of the sum of the current window and 
		a global sum to keep track of the largest sum.
	*/
	
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int cur = 0;
        
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (i == k - 1) {
                sum = cur;
            } else if (i >= k) {
                cur -= nums[i - k];
                sum = Math.max(sum, cur);
            }
        }
        
        
        return 1.0 * sum / k;
    }
}