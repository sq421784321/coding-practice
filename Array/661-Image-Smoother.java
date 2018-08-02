class Solution {
    private int[][] dirs = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {0, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
    
    public int[][] imageSmoother(int[][] M) {
        int n = M.length;
        int m = M[0].length;
        
        int[][] ans = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = cal(i, j, n, m, M);
                ans[i][j] = count;
            }
        }
        
        return ans;
    }
    
    private int cal(int row, int col, int n, int m, int[][] matrix) {
        int count = 0;
        int sum = 0;
        
        for (int i = 0; i < dirs.length; i++) {
            int neiRow = row + dirs[i][0];
            int neiCol = col + dirs[i][1];
            
            if (neiRow < 0 || neiRow >= n || neiCol < 0 || neiCol >= m) continue;
            
            sum += matrix[neiRow][neiCol];
            count += 1;
        }
        return sum / count;
    }
}