/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rs = new ArrayList<>();
        int n = matrix.length;
        if(n == 0) {
            return rs;
        }
        int m = matrix[0].length;
        if(m == 0) {
            return rs;
        }
        
        int left = 0, right = m - 1, up = 0, bottom = n - 1;
        
        while(left < right && up < bottom) {
            for(int i = left; i <= right; i++) {
                rs.add(matrix[up][i]);
            }
            for(int i = up + 1; i <= bottom - 1; i++) {
                rs.add(matrix[i][right]);
            }
            for(int i = right; i >= left; i--) {
                rs.add(matrix[bottom][i]);
            }
            for(int i = bottom - 1; i >= up + 1; i--) {
                rs.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            bottom--;
        }
        
        // base case 1 : nothing left
        if(left > right || up > bottom) {
            return rs;
        }
        
        // base case 2: one column left
        if(left == right) {
            for(int i = up; i <= bottom; i++) {
                rs.add(matrix[i][left]);
            }
        } else {
            // base case 3 : one row left;
            for(int i = left; i <= right; i++) {
                rs.add(matrix[up][i]);
            }
        }
        return rs;
    }
}
