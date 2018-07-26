class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            List<Integer> row = forest.get(i);
            for (int j = 0; j < row.size(); j++) {
                int val = row.get(j);
                if (val > 1) {
                    trees.add(new int[] {i, j, val});
                }
            }
        }
        
        Collections.sort(trees, (int[] a, int[] b) -> (a[2] - b[2]));
        
        int sr = 0, sc = 0;
        int ans = 0;
        for (int[] tree: trees) {
            int dist = getDistance(sr, sc, tree[0], tree[1], forest);
            //System.out.println(dist);
            if (dist == -1) return -1;
            ans += dist;
            sr = tree[0];
            sc = tree[1];
        }
        
        return ans;
    }
    
    // BFS to find shortest path
    private int getDistance(int sr, int sc, int dr, int dc, List<List<Integer>> forest) {
        if (sr == dr && sc == dc) {
            return 0;
        }
        
        int n = forest.size();
        int m = forest.get(0).size();
        
        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.offerLast(new int[] {sr, sc});
        visited[sr][sc] = true;
        
        int step = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.pollFirst();
                
                for (int i = 0; i < dirs.length; i++) {
                    int nextRow = cur[0] + dirs[i][0];
                    int nextCol = cur[1] + dirs[i][1];
                    
                    if (nextRow == dr && nextCol == dc) {
                        return step;
                    }
                    
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !visited[nextRow][nextCol] && forest.get(nextRow).get(nextCol) > 0) {
                        
                        visited[nextRow][nextCol] = true;
                        queue.offerLast(new int[] {nextRow, nextCol});
                    }
                }
            }
            step++;
        }
        
        return -1;
    }
}