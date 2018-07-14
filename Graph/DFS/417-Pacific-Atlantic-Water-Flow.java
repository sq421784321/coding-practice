class Solution {
    private int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<int[]>();
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean[][] canTouchPacific = new boolean[n][m];
        boolean[][] canTouchAtlantic = new boolean[n][m];
        List<int[]> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            dfs(matrix, canTouchPacific, i, 0, Integer.MIN_VALUE);
            dfs(matrix, canTouchAtlantic, i, m - 1, Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < m; i++) {
            dfs(matrix, canTouchPacific, 0, i, Integer.MIN_VALUE);
            dfs(matrix, canTouchAtlantic, n - 1, i, Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canTouchPacific[i][j] && canTouchAtlantic[i][j]) {
                    ans.add(new int[]{i, j});
                }
            }
        }
        
        return ans;
    }
    
    private void dfs(int[][] matrix, boolean[][] sea, int row, int col, int prevHeight) {
        if (row < 0 || row >= sea.length || col < 0 || col >= sea[0].length || sea[row][col] || matrix[row][col] < prevHeight) {
            return;
        }
        sea[row][col] = true;        
        for (int i = 0; i < dirs.length; i++) {
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];
            dfs(matrix, sea, newRow, newCol, matrix[row][col]);
        }
    }
}