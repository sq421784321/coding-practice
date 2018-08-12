class Solution {
	/*
		Method 1 : Iterative
		
		Odd step length: going right then going down
		Even step length: going left then going up
	*/
	
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        int step = 1;
        int index = 0;
        
        ans[index] = new int[] { r0, c0 };
        index++;
        
        while (index < R * C) {
            int sign = (step % 2 == 1 ? 1 : -1);
            // go right or left
            for (int i = 1; i <= step; i++) {
                int r1 = r0;
                int c1 = c0 + sign * i;
                if (r1 >= 0 && r1 < R && c1 >= 0 && c1 < C) {
                    ans[index] = new int[] { r1, c1};
                    index++;
                }
            }
            c0 += sign * step;
            // go down or up
            for (int i = 1; i <= step; i++) {
                int r1 = r0 + sign * i;
                int c1 = c0;
                if (r1 >= 0 && r1 < R && c1 >= 0 && c1 < C) {
                    ans[index] = new int[] { r1, c1};
                    index++;
                }
            }
            r0 += sign * step;
            step++;
        }
        
        return ans;
    }
}