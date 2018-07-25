class Solution {
    public int numTrees(int n) {
        // dp[i] : number of unique BST containing i nodes
        // dp[i] = dp[0] * dp[i - 1] + dp[1] * dp[i - 2] + ... + dp[i - 2] * dp[1] + dp[i - 1] * dp[0]
        
        // dp[5] = dp[0] * dp[4] + dp[1] * dp[3] + dp[2] * dp[2] + dp[3] * dp[1] + dp[4] * dp[0] 
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            
            for (int j = 0; j < i / 2; j++) {
                dp[i] += 2 * dp[j] * dp[i - 1 - j];
            }
            
            if (i % 2 == 1) {
                dp[i] += dp[i/2] * dp[i/2];
            }
        }
        
        return dp[n];
    }
}