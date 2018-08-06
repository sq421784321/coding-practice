class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;
        int m = nums[0].length;
        
        // Check the availability
        if (r * c != n * m) return nums;
        
        int[][] ans = new int[r][c];
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = nums[count / m][count % m];
                count++;
            }
        }
        return ans;
    }
}