class Solution {
	/*
		Method 1: Binary Search.
		
		Create a new array, put each element into its right position in ascending order.
	*/
	
    public int lengthOfLIS(int[] nums) {
        int[] pos = new int[nums.length + 1];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len == 0) {
                pos[len] = nums[i];
                len++;
                continue;
            }
            
            // find the smallest larger in pos
            int index = find(pos, 0, len - 1, nums[i]);
            if (index == len) {
                pos[index] = nums[i];
                len++;
            } else {
                pos[index] = nums[i];
            }
        }
        
        return len;
    }
    
    // Find smallest larger element using Binary Search
    private int find(int[] pos, int l, int r, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (pos[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        if (pos[l] >= target) {
            return l;
        } else {
            return l + 1;
        }
    }
}