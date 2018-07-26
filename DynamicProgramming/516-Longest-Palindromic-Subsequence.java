class Solution {
    public int longestPalindromeSubseq(String s) {
        // dp[i][j]: longest palindrome within s[i, j]
        // dp[i][j] = dp[i + 1][j - 1], if i < a <= b < j && s[i] == s[j]
        //            max(dp[i + 1][j], dp[i][j - 1]), otherwise
        // base case: dp[i][i] = 1
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i + 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}