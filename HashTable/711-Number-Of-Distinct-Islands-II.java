class Solution {
    
    public int numDistinctIslands2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        Set<String> set = new HashSet<>();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    List<int[]> points = new ArrayList<>();     // store [row, col] pair
                    dfs(i, j, n, m, grid, points);              // dfs to find all connected points
                    
                    String hash = getHash(points, n + m);
                    set.add(hash);
                }
            }
        }
        return set.size();
    }
    
    // Hash Function:
    // For a point (x, y), there are 8 different ways which have the same shape
    // (x, y), (x, -y), (-x, y), (-x, -y)
    // (y, x), (y, -x), (-y, x), (-y, -x)
    // Thus, for a particular point list, we would have 8 potential different point lists with the same shape.
    
    // The process would be : we iterate through different point list,
    // for each point list, we first find min_x and min_y within it,
    // and then make all the points align to the top left corner, which means (x, y) -> (x - min_x, y - min_y)
    // during this process, we use another array to help us record the relative hash for each point based on x, y and seed.
    
    // After get the hash array, we then sort it in ascending order, and make it a string.
    // Then we store the min string among all 8 hash strings to be the final result hash.
    
    private String getHash(List<int[]> points, int seed) {
        String hash = "";
        int[] xm = new int[points.size()];
        int[] ym = new int[points.size()];
        int[] out = new int[points.size()];
        
        for (int c = 0; c < 8; c++) {
            
            for (int i = 0; i < points.size(); i++) {
                int y = points.get(i)[0];
                int x = points.get(i)[1];
                
                update(xm, ym, i, c, x, y);
            }
            
            int mx = xm[0], my = ym[0];
            for (int i = 1; i < xm.length; i++) {
                mx = Math.min(mx, xm[i]);
                my = Math.min(my, ym[i]);
            }
            
            for (int i = 0; i < points.size(); i++) {
                out[i] = (xm[i] - mx) * seed + (ym[i] - my);
            }
            
            Arrays.sort(out);
            String candidate = Arrays.toString(out);
            if (hash.compareTo(candidate) < 0) hash = candidate;
        }
        
        return hash;
    }
    
    private void update(int[] xm, int[] ym, int index, int c, int x, int y) {
        if (c == 0) {
            xm[index] = x;
            ym[index] = y;
        } else if (c == 1) {
            xm[index] = x;
            ym[index] = -y; 
        } else if (c == 2) {
            xm[index] = -x;
            ym[index] = y;
        } else if (c == 3) {
            xm[index] = -x;
            ym[index] = -y;
        } else if (c == 4) {
            xm[index] = y;
            ym[index] = x;
        } else if (c == 5) {
            xm[index] = y;
            ym[index] = -x;
        } else if (c == 6) {
            xm[index] = -y;
            ym[index] = x;
        } else {
            xm[index] = -y;
            ym[index] = -x;
        }
    }
    
    private void dfs(int row, int col, int n, int m, int[][] grid, List<int[]> points) {
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0) return;
        points.add(new int[] {row, col});
        grid[row][col] = 0;         // set 0 to avoid infinite loop
        dfs(row + 1, col, n, m, grid, points);
        dfs(row - 1, col, n, m, grid, points);
        dfs(row, col + 1, n, m, grid, points);
        dfs(row, col - 1, n, m, grid, points);
    }
}