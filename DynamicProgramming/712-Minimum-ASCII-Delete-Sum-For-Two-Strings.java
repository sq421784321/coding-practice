class Solution {
	/*
		Method 1: DP.
		
		Intuition: current result could be based on previous results.
		
		dp[i][j]: min ASCII delete sum to make s1[0, i - 1] and s2[0, j - 1] equal.
		
		Time Complexity: O(n * m)
		Space Complexity: O(n * m) ===> can be improved to min(len(s1), len(s2)) using roller array
	*/
	
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        
        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char one = s1.charAt(i - 1);
                char two = s2.charAt(j - 1);
                
                dp[i][j] = Integer.MAX_VALUE;
                
                if (one == two) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + one + two);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + one);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + two);
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
}