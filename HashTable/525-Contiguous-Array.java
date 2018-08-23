class Solution {
	/*
		Method 1: HashTable
		
		HashTable to keep track of the cumulative sum, once we find the current sum is existing in hashmap, meaning we find one valid subarray.
		
		Time Complexity: O(N)
		Space Complexity: O(N)
	*/
	
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0 ? 1 : -1);
            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
				// Don't need to update index here, because we only need to store the smallest index into hashmap.
            } else {
                map.put(sum, i);
            }
        }
        
        return ans;
    }
}

