class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int neighbors = getNeighbors(i, j, n, m, grid);
                    ans += 4 - neighbors;
                }
            }
        }
        
        return ans;
    }
    
    private int getNeighbors(int row, int col, int n, int m, int[][] grid) {
        int count = 0;
        if (row - 1 >= 0 && grid[row - 1][col] == 1) count += 1;
        if (col - 1 >= 0 && grid[row][col - 1] == 1) count += 1;
        if (row + 1 < n && grid[row + 1][col] == 1) count += 1;
        if (col + 1 < m && grid[row][col + 1] == 1) count += 1;
        return count;
    }
}