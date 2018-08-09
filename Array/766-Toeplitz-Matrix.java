class Solution {
	/*
		Method 1: Iterative
		
		Loop through matrix and compare m[i][j] with m[i - 1][j - 1].
	*/
	
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = matrix[i][j];
                if (i - 1 >= 0 && j - 1 >= 0 && matrix[i - 1][j - 1] != cur) {
                    return false;
                }
            }
        }
        
        return true;
    }
}