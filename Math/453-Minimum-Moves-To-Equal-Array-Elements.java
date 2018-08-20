class Solution {
	/*
		Method 1: Math
		
		Increment n - 1 elements by 1 equals to decrement 1 from one single number. 
	*/
	
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        
        for (int num : nums) {
            min = Math.min(min, num);
        }
        
        for (int num : nums) {
            ans += num - min;
        }
        
        return ans;
    }
}