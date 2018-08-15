class Solution {
    /*
        Method 1: DFS
        
        Filter out all the invalid 'O's, then flip all the remaining 'O's
    */
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        int n = board.length;
        int m = board[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        // Filter out all '0's starting from the first row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                dfs(0, j, n, m, board, visited);
            }
        }
        
        // Filter out all '0's starting from the last row
        for (int j = 0; j < m; j++) {
            if (board[n - 1][j] == 'O' && !visited[n - 1][j]) {
                dfs(n - 1, j, n, m, board, visited);
            }
        }
        
        // Filter out all '0's starting from the first column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0, n, m, board, visited);
            }
        }
        
        // Filter out all '0's starting from the last column
        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 'O' && !visited[i][m - 1]) {
                dfs(i, m - 1, n, m, board, visited);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(int row, int col, int n, int m, char[][] board, boolean[][] visited) {
        if (row < 0 || row >= n || col < 0 || col >= m || visited[row][col] || board[row][col] != 'O') {
            return;
        }
        
        visited[row][col] = true;
        board[row][col] = '1';
        
        dfs(row + 1, col, n, m, board, visited);
        dfs(row - 1, col, n, m, board, visited);
        dfs(row, col + 1, n, m, board, visited);
        dfs(row, col - 1, n, m, board, visited);
    }
}

