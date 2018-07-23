class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int n = rooms.length;
        int m = rooms[0].length;
        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    //bfs(i, j, n, m, rooms);
                    queue.offerLast(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        bfs(n, m, queue, visited, rooms);
    }
    
    private void bfs(int n, int m, Deque<int[]> queue, boolean[][] visited, int[][] rooms) {
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] cur = queue.pollFirst();
                for (int i = 0; i < dirs.length; i++) {
                    int nextRow = cur[0] + dirs[i][0];
                    int nextCol = cur[1] + dirs[i][1];
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !visited[nextRow][nextCol] && rooms[nextRow][nextCol] > 0) {
                        visited[nextRow][nextCol] = true;
                        queue.offerLast(new int[] {nextRow, nextCol});
                    }
                }
                rooms[cur[0]][cur[1]] = step;
            }
            step++;
        }
    }
}