class Solution {
	/*
		Very similar to Q.163
		
		Note: write a helper func to handle range string.
	*/
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        
        int left = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                helper(left, nums[i - 1], ans);
                left = nums[i];
            }
        }
        
        helper(left, nums[nums.length - 1], ans);
        
        return ans;
    }
    
    private void helper(int left, int right, List<String> ans) {
        if (left == right) {
            ans.add(left + "");
        } else {
            ans.add(left + "->" + right);
        }
    }
}