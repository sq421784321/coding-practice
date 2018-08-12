class Solution {
	/*
		Method 1: DFS
		
		Using DFS to find longest pah.
	*/
	
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int ans = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[nums[i]]) {
                ans = Math.max(ans, dfs(nums, i, visited));
            }
        }
        
        return ans;
    }
    
    private int dfs(int[] nums, int cur, boolean[] visited) {
        if (visited[cur]) {
            return 0;
        }
        
        visited[cur] = true;
        int depth = dfs(nums, nums[cur], visited);
        
        return 1 + depth;
    }
}