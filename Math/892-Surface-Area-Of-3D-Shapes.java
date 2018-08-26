class Solution {
	/*
		Method 1 : Iterative.
		
		Add the number of total surface of cur point (i, j),
		remove the overlapped surface of four surrounding points.
	*/
	
    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans += cal(grid, i, j, grid.length, grid[0].length);
            }
        }
        return ans;
    }
    
    private int cal(int[][] grid, int i, int j, int n, int m) {
        int ans = grid[i][j] > 0 ? grid[i][j] * 4 + 2 : 0;
        
        if (i > 0) {
            ans -= Math.min(grid[i][j], grid[i - 1][j]);
        }
        if (i + 1 < n) {
            ans -= Math.min(grid[i][j], grid[i + 1][j]);
        }
        if (j > 0) {
            ans -= Math.min(grid[i][j], grid[i][j - 1]);
        }
        if (j + 1 < m) {
            ans -= Math.min(grid[i][j], grid[i][j + 1]);
        }
        
        return ans;
    }
}