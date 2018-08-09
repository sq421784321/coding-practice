class Solution {
	/*
		Method 1: DP.
		
		Maintain two arrays to keep track of relative lis and count. 
	*/
	
    public int findNumberOfLIS(int[] nums) {
        int[] count = new int[nums.length];
        int[] lis = new int[nums.length];
        
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            lis[i] = 1;
            count[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lis[j] + 1 > lis[i]) {
                        lis[i] = lis[j] + 1;	// update lis[i] to the longest one.
                        count[i] = count[j];	// update count[i] respectively.
                    } else if (lis[j] + 1 == lis[i]) {
                        count[i] += count[j];	// should be count[j] because index j will bring count[j] sequences to lis[i]
                    }
                }
            }
            max = Math.max(max, lis[i]);
        }
        
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lis[i] == max) {
                ans += count[i];
            }
        }
        
        return ans;
    }
}