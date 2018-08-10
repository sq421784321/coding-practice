class Solution {
	/*
		Method 1 : Iterative
		
		1. matrix multiplication:
		
		|x1, x2|  *  |y1, y2, y3|	=	|x1y1 + x2z1, x1y2 + x2z2, x1y3 + x2z3|
				     |z1, z2, z3|       
		
		
		2. for 循环交换律
		
		for i = 0 ~ n - 1
			for j = 0 ~ m - 1
				for k = 0 ~ s - 1
					ans[i][j] += A[i][k] * B[k][j]

		等价于
		
		for i = 0 ~ n - 1
			for k = 0 ~ s - 1
				for j = 0 ~ m - 1
					ans[i][j] += A[i][k] * B[k][j]
		
		
		
		
	*/
	
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = B[0].length;
        
        int[][] ans = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < m; j++) {
                        ans[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        
        return ans;
    }
}