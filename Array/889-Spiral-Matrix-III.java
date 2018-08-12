class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        
        int step = 1;
        int index = 0;
        int count = 0;
        
        ans[index] = new int[] { r0, c0 };
        index++;
        
        while (index < R * C) {
            if (step % 2 == 1) {
                // go right
                for (int i = 1; i <= step; i++) {
                    int r1 = r0;
                    int c1 = c0 + i;
                    if (r1 >= 0 && r1 < R && c1 >= 0 && c1 < C) {
                        ans[index] = new int[] { r1, c1};
                        index++;
                    }
                }
                c0 += step;
                // go down
                for (int i = 1; i <= step; i++) {
                    int r1 = r0 + i;
                    int c1 = c0;
                    if (r1 >= 0 && r1 < R && c1 >= 0 && c1 < C) {
                        ans[index] = new int[] { r1, c1};
                        index++;
                    }
                }
                r0 += step;
            } else {
                // go left
                for (int i = 1; i <= step; i++) {
                    int r1 = r0;
                    int c1 = c0 - i;
                    if (r1 >= 0 && r1 < R && c1 >= 0 && c1 < C) {
                        ans[index] = new int[] { r1, c1};
                        index++;
                    }
                }
                c0 -= step;
                // go up
                for (int i = 1; i <= step; i++) {
                    int r1 = r0 - i;
                    int c1 = c0;
                    if (r1 >= 0 && r1 < R && c1 >= 0 && c1 < C) {
                        ans[index] = new int[] { r1, c1};
                        index++;
                    }
                }
                r0 -= step;
            }
            step++;
        }
        
        return ans;
    }
}

//[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]

