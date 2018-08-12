class Solution {
	/*
		Method 1: DFS
		
		First, build the graph using Adjacency List.
		Then, create an array to keep track of the group number of each node.
		Last, do a dfs to each node to validate the partiton rules.
	*/
	
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
        
        for (int i = 0; i < N; i++) {
            if (array[i] == 0) {
                if (!dfs(array, i, 1, graph)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean dfs(int[] array, int index, int group, List<List<Integer>> graph) {
        if (array[index] == group) {
            return true;
        }
        
        if (array[index] != 0 && array[index] != group) {
            return false;
        }
        
        array[index] = group;
        List<Integer> dislikes = graph.get(index);
        for (int d : dislikes) {
            if (group == 1) {
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