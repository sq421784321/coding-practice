class Solution {
    /*
		Method 1: HashMap
		
		Maximum subsequence length = Max((length(num) + length(num + 1)) or (length(num) + length(num - 1)))
		
		Keep a map of number's frequency. 
	*/
	
	public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1)) {
                ans = Math.max(ans, map.get(num) + map.get(num + 1));
            }
            if (map.containsKey(num - 1)) {
                ans = Math.max(ans, map.get(num) + map.get(num - 1));
            }
        }
        return ans;
    }
}