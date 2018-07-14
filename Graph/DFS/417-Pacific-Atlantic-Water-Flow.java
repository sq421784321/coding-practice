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


/* Method2 BFS
class Solution {
    private int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<int[]>();
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean[][] canTouchPacific = new boolean[n][m];
        boolean[][] canTouchAtlantic = new boolean[n][m];
        List<int[]> ans = new ArrayList<>();
        
        Deque<int[]> pQueue = new LinkedList<>();
        Deque<int[]> aQueue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            pQueue.offer(new int[] {i, 0});
            aQueue.offer(new int[] {i, m - 1});
            canTouchPacific[i][0] = true;
            canTouchAtlantic[i][m - 1] = true;
        }
        
        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[] {0, i});
            aQueue.offer(new int[] {n - 1, i});
            canTouchPacific[0][i] = true;
            canTouchAtlantic[n - 1][i] = true;
        }
        
        bfs(matrix, pQueue, canTouchPacific);
        bfs(matrix, aQueue, canTouchAtlantic);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canTouchPacific[i][j] && canTouchAtlantic[i][j]) {
                    ans.add(new int[]{i, j});
                }
            }
        }
        
        return ans;
    }
    
    private void bfs(int[][] matrix, Deque<int[]> q, boolean[][] visited) {
        int n = matrix.length, m = matrix[0].length;
        
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int row = cur[0];
            int col = cur[1];
            visited[row][col] = true;
            
            for (int i = 0; i < dirs.length; i++) {
                int newRow = row + dirs[i][0];
                int newCol = col + dirs[i][1];
                
                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m || visited[newRow][newCol] || matrix[newRow][newCol] < matrix[row][col]) {
                    continue;
                }
                
                q.offer(new int[] {newRow, newCol});
            }
        }
    }
}

*/