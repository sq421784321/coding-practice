class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            helper(lower, upper, ans);
            return ans;
        }
        
        // Handle the left boundary
        if (nums[0] > lower) {
            int left = lower;
            int right = nums[0] - 1;
            helper(left, right, ans);
        }
        
        // Handle the middle part
        for (int i = 1; i < nums.length; i++) {
			// Skip duplicates
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i - 1] + 1 != nums[i]) {
                int left = nums[i - 1] + 1;
                int right = nums[i] - 1;
                helper(left, right, ans);
            }
        }
        
        // Handle the right boundary
        if (nums[nums.length - 1] < upper) {
            int left = nums[nums.length - 1] + 1;
            int right = upper;
            helper(left, right, ans);
        }
        
        return ans;
    }
    
    private void helper(int left, int right, List<String> ans) {
        if (left == right) {
            ans.add(left + "");
        } else if (left < right) {
            ans.add(left + "->" + right);
        } 
    }
}