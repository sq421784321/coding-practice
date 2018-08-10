class Solution {
	/*
		Method 1: Iterative
		
	*/
	
    public int pivotIndex(int[] nums) {
        int right = 0;
        for (int num : nums) {
            right += num;
        }
        
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            
            right -= nums[i];
            if (i > 0) {
                left += nums[i - 1];
            }
            
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}