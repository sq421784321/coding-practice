class Solution {
    /*
        Method 1: use HashMap to store previous sum results
        
        To check the continuous subarra whose sum equals to K, just check whether (sum - k) existing in the map.
        To update, just store the current sum to map.
    */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
            
        return ans;
    }
}