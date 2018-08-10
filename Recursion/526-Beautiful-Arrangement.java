class Solution {
    /*
		Method 1: try all possibilities at each index.
		
		Time: 95ms
    */
    
//     public int countArrangement(int N) {
//         int[] ans = new int[1];
//         boolean[] visited = new boolean[N + 1];
//         helper(1, N, visited, ans);
//         return ans[0];
//     }
    
//     private void helper(int cur, int n, boolean[] visited, int[] ans) {
//         if (cur == n + 1) ans[0]++;
        
//         for (int i = 1; i <= n; i++) {
//             if ((cur % i == 0 || i % cur == 0) && !visited[i]) {
//                 visited[i] = true;
//                 helper(cur + 1, n, visited, ans);
//                 visited[i] = false;
//             }
//         }
//     }
    
	/*
		Method 2: generate all permutation which satisfy the rules.
		
		Time: 35ms
	*/
    public int countArrangement(int N) {
        int[] array = new int[N];
        
        for (int i = 0; i < N; i++) {
            array[i] = i + 1;
        }
        
        int[] ans = new int[1];
        helper(array, 0, ans);
        
        return ans[0];
    }
    
    private void helper(int[] array, int index, int[] ans) {
        if (index == array.length) {
            ans[0]++;
            return;
        }
        
        for (int i = index; i < array.length; i++) {
            if (((index + 1) % array[i] == 0) || (array[i] % (index + 1) == 0)) {
                swap(array, index, i);
                helper(array, index + 1, ans);
                swap(array, index, i);
            }
        }
    }
    
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}