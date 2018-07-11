Class Solution {
    public int change(int amount, int[] coins) {
    	// dp[i][j] : the number of unique combinations to make up to i by using only the first j types of coin 
	int[][] dp = new int[coins.length + 1][amount + 1];
	dp[0][0] = 1;		            
	for (int i = 1; i <= coins.length; i++) {
		dp[i][0] = 1;
		for (int j = 0; j <= amount; j++) { 
			dp[i][j] = dp[i-1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
		}
	}
													        
	return dp[coins.length][amount];
    }
															        
// dp[1] = 1 = 1
// dp[2] = 1+1/2 = 2
// dp[3] = 1+1+1/1+2 = 2
// dp[4] = 1+1+1+1/1+1+2/2+2 = 3
// dp[5] = 5/1+1+1+1+1/1+1+1+2/1+2+2 = 4
}
