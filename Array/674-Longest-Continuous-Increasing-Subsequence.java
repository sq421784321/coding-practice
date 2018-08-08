class Solution {
	/*
		Method 1: Iterative
		
	*/
	
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int cur = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                cur++;
            } else {
                cur = 1;
            }
            ans = Math.max(ans, cur);
        }
        
        return ans;
    }
}