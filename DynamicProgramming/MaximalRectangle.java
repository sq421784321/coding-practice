/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
*/

// left[i], right[i] represents the boundaries of the rectangle which contains the current point with height of value height[i]
// area = height[i] * (right[i] - left[i])



class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int n = matrix.length;
        if(n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if(m == 0) {
            return 0;
        }
        
        int[] left = new int[m];
        int[] right = new int[m];
        int[] height = new int[m];
        
        for(int i = 0; i < m; i++) {
            right[i] = m; 
        }
        
        int global_max = 0;
        for(int i = 0; i < n; i++) {
            
            int cur_left = 0, cur_right = m;
            
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            
            
            for(int j = m - 1; j >= 0; j--) {
                if(matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = m;
                    cur_right = j;
                } 
            }
            
            
            for(int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
                global_max = Math.max(global_max, height[j] * (right[j] - left[j]));
            }
            
        }
        
        return global_max;
    }
}
