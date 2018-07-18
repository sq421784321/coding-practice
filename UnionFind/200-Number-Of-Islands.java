class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        // initialize
        int[] array = new int[n*m];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        
        int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    int cur = i * m + j;
                    
                    union(cur, cur, array);
                    
                    for (int k = 0; k < dirs.length; k++) {
                        int neiRow = i + dirs[k][0];
                        int neiCol = j + dirs[k][1];
                        
                        if (neiRow >= 0 && neiRow < n && neiCol >= 0 && neiCol < m && grid[neiRow][neiCol] == '1') {
                            int nei = neiRow * m + neiCol;
                            union(cur, nei, array);
                        }
                    }
                }
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(array[i * m + j] + " ");
        //     }
        //     System.out.println();
        // }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != -1) {
                int head = find(i, array);
                set.add(head);
            }
        }
        return set.size();
    }
    
    private void union(int a, int b, int[] array) {
        int headA = find(a, array);
        int headB = find(b, array);
        
        if (headA != -1 && headB != -1) {
            array[headA] = headB;
        } else if (headA != -1 && headB == -1) {
            array[headA] = b;
        } else if (headA == -1 && headB != -1) {
            array[headB] = a;
        } else {
            array[a] = b;
        }
    }
    
    private int find(int num, int[] array) {
        if (array[num] == -1 || array[num] == num) return num;
        return find(array[num], array);
    }
}