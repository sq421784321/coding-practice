class Solution {
	
	/*
				4	3	2	2
		step1	4	3	2	-2
		step2	4	3	-2	-2
		step3	4	-3	-2	-2
		step4	4	-3!	-2	-2	find the duplicate one
	*/
	
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
			// Negate the val of relative index
            if (nums[num - 1] < 0) {
                ans[0] = num;
            } else {
                nums[num - 1] *= -1;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[1] = i + 1;
                break;
            }
        }
        return ans;
    }
}