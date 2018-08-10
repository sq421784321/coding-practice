class Solution {
	/*
		Method 1: DP
		
		dp[i][j] : maximum length of repeated subarray between A[0, i] and B[0, j]
		
		dp[i][j] = dp[i - 1][j - 1] + 1				if A[i] == B[j]
		
		dp[i][j] = 1								if A[i] == B[j] && (i == 0 || j == 0)
	*/
	
    public int findLength(int[] A, int[] B) {    
        int[][] dp = new int[A.length][B.length];
        int max = 0;
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                
                if (A[i] == B[j]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max;
    }
}