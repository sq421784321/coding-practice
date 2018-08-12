class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] d : dislikes) {
            int one = d[0] - 1;
            int two = d[1] - 1;
            graph.get(one).add(two);
            graph.get(two).add(one);
        }
        
        int[] array = new int[N];
        boolean[] visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            if (array[i] == 0) {
                if (!dfs(array, i, 1, graph)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean dfs(int[] array, int index, int cur, List<List<Integer>> graph) {
        if (array[index] == cur) {
            return true;
        }
        
        if (array[index] != 0 && array[index] != cur) {
            return false;
        }
        
        array[index] = cur;
        List<Integer> dislikes = graph.get(index);
        for (int d : dislikes) {
            if (cur == 1) {
                if (!dfs(array, d, 2, graph)) {
                    return false;
                }
            } else {
                if (!dfs(array, d, 1, graph)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}