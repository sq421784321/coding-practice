class Solution {
	/*
		Method 1: Sort + Three tuple
		
		Determine the largest one, then two pointers to find the other two.
	*/
	
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int l = 2; l < nums.length; l++) {
            int i = 0, j = l - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[l]) {
                    ans += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return ans;
    }
}