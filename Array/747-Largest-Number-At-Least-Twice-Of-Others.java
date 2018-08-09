class Solution {
	/*
		Method 1: Iterative
		
		Maintain two indexes to keep the largest one and the second largest one.
	*/
	
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;
        
        int largestIndex = -1;
        int secIndex = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (largestIndex == -1 || nums[i] > nums[largestIndex]) {
                secIndex = largestIndex;
                largestIndex = i;
            } else if (secIndex == -1 || nums[i] > nums[secIndex]) {
                secIndex = i;
            }
        }
        
        return nums[largestIndex] >= 2 * nums[secIndex] ? largestIndex : -1;
    }
}