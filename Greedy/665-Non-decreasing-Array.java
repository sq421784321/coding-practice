class Solution {
	/*
		Method 1: Greedy
		
		Once find a decreasing pair, first to replace the nums[i - 1] with nums[i] if available (because nums[i - 1] > nums[i])
		otherwise, replace nums[i] with nums[i - 1]
	*/
	
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        
        return count <= 1;
    }
}