class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int n = matrix.length;
        
        int offset = 0;
        
        while (offset < n / 2) {
            
            for (int i = offset; i < n - 1 - offset; i++) {
                int tmp = matrix[n - 1 - i][offset];
                
                matrix[n - 1 - i][offset] = matrix[n - 1 - offset][n - 1 - i];
                matrix[n - 1 - offset][n - 1 - i] = matrix[i][n - 1 - offset];
                matrix[i][n - 1 - offset] = matrix[offset][i];
                matrix[offset][i] = tmp;
            }
            
            offset++;
        }
    }
}