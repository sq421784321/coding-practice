class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> graph = buildGraph(richer, quiet.length);
        
        int[] ans = new int[quiet.length];
        Arrays.fill(ans, -1);
        
        for (int i = 0; i < quiet.length; i++) {
            cal(graph, i, quiet, ans);
        }
        
        return ans;
    }
    
    private int cal(List<List<Integer>> graph, int i, int[] quiet, int[] ans) {
        if (ans[i] != -1) {
            return ans[i];
        }
        
        ans[i] = i;
        List<Integer> larger = graph.get(i);
        
        for (int large : larger) {
            int next = cal(graph, large, quiet, ans);
            if (quiet[ans[i]] >= quiet[next]) {
                ans[i] = next;
            }
        }
        return ans[i];
    }
    
    private List<List<Integer>> buildGraph(int[][] richer, int n) {
        // small : list of large
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < richer.length; i++) {
            int high = richer[i][0];
            int low = richer[i][1];
            graph.get(low).add(high);
        }
        return graph;
    }
}