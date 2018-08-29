class Solution {
	/*
		Method 1 : Recursion
		
		Do recursion based on index
		For each index, we have two choices:
			1. append the current num to list
			2. do nothing.
	*/
	
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        helper(nums, 0, cur, ans);
		
        return ans;
    }
    
    private void helper(int[] nums, int index, List<Integer> cur, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        // Choice 1: don't append current num
        helper(nums, index + 1, cur, ans);
        
		// Choice 2: append current num
        cur.add(nums[index]);
        helper(nums, index + 1, cur, ans);
		// backtrack
        cur.remove(cur.size() - 1);
    }
}