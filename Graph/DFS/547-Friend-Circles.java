class Solution {
    /* 
		Method 2: DFS
		
		DFS to mark all the friends in the same group.
	*/
    public int findCircleNum(int[][] M) {
        
        boolean[] visited = new boolean[M.length];
        int ans = 0;
        
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                ans += 1;
            }
        }
        
        return ans;
    }
    
    
    private void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
    
    
    // Method 1: Union-Find
    /*  
    public int findCircleNum(int[][] M) {
        int n = M.length;
        
        int[] array = new int[n];
        Arrays.fill(array, -1);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    
                    int headOne = find(array, i);
                    int headTwo = find(array, j);
                    
                    group(array, headOne, i, headTwo, j);
                }
            }
        }
        
        // int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            
            int head = find(array, i);
            set.add(head);
        }
        
        return set.size();
    }
    
    private int find(int[] array, int i) {
        if (array[i] == -1) return i;
        return find(array, array[i]);
    }
    
    private void group(int[] array, int headOne, int i, int headTwo, int j) {
        if (headOne != headTwo) {
            array[headOne] = headTwo;
        }
    }
    */
}