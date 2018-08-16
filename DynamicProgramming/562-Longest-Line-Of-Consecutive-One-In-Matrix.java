class Solution {
	/*
		Method 1 : DP
		
		size: dp[n][m][4]
		
		induction rule:	
				if M[i][j] == 1:
						dp[i][j][0] = dp[i][j - 1][0] + 1, if j > 0     		 // horizontal
									= 1, if j == 0
						dp[i][j][1] = dp[i - 1][j][1] + 1, if i > 0	    		 // vertical
									= 1, if i == 0
						dp[i][j][2] = dp[i - 1][j - 1][2], if i > 0 && j > 0     // diagonal
									= 1, else
						dp[i][j][3] = dp[i - 1][j + 1][3], if i > 0 && j < m - 1 // anti-diagonal
									= 1, else
		
		Then we could convert 3D to 2D
	*/
	
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        
        int[][] dp = new int[M[0].length][4];
        int ans = 0;
        
        for (int i = 0; i < M.length; i++) {
            int oldDiag = 0;
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    // horizontal
                    if (j > 0) {
                        dp[j][0] = dp[j - 1][0] + 1;
                    } else {
                        dp[j][0] = 1;
                    }
                    ans = Math.max(ans, dp[j][0]);
                    
                    // vertical
                    if (i > 0) {
                        dp[j][1] = dp[j][1] + 1;
                    } else {
                        dp[j][1] = 1;
                    }
                    ans = Math.max(ans, dp[j][1]);
                    
                    // diagonal
                    int prev = dp[j][2];
                    if (i > 0 && j > 0) {
                        dp[j][2] = oldDiag + 1;
                    } else {
                        dp[j][2] = 1;
                    }
                    ans = Math.max(ans, dp[j][2]);
                    oldDiag = prev;
                    
                    // anti-diagonal
                    if (i > 0 && j < M[0].length - 1) {
                        dp[j][3] = dp[j + 1][3] + 1;
                    } else {
                        dp[j][3] = 1;
                    }
                    ans = Math.max(ans, dp[j][3]);
                } else {
                    oldDiag = dp[j][2];
                    dp[j][0] = 0;
                    dp[j][1] = 0;
                    dp[j][2] = 0;
                    dp[j][3] = 0;
                }
            }
        }
        
        return ans;
    }
}                               
                                
/*         
    Test case:
    
    0   1   1   0          
    0   1   1   0         
    0   0   0   1           
*/