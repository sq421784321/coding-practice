class Solution {
	/*
		Method 1: Iterative.
		The final answer consists of three parts:
		1. the area when looking from the top: number of (num[cells] > 0)
		2. the area when looking from the front: sum of largest numbers of each row
		3. the area when looking from the side:  sum of largest numbers of each column
	*/
	
    public int projectionArea(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, grid[i][j]);
                if (grid[i][j] > 0) {
                    ans += 1;
                }
            }
            ans += max;
        }
        
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            ans += max;
        }
        
        return ans;
    }
}