class Solution {
    public int numDecodings(String s) {
		// dp[i] : number of ways to decode s[i, n - 1]
		// dp[i] = {dp[i + 1]} + {dp[i + 2]};
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        
        for (int i = s.length() - 1; i >= 0; i--) {
			// Condition 1: choose only one char
            char next = s.charAt(i);
            if (next != '0') {
                dp[i] += dp[i + 1];
            }
			
			// Condition 2: choose two chars
            if (i + 1 < s.length()) {
                char nextNext = s.charAt(i + 1);
                int num = (next - '0') * 10 + (nextNext - '0');
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        
        return dp[0];
        // return helper(s, 0);
    }
    
	// Method 1 : DFS
	// LeetCode Runtime: 554ms. Very very very slow...
    private int helper(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        
        if (index == s.length() - 1) {
            if (s.charAt(index) == '0') {
                return 0;
            } else {
                return 1;
            }
        }
        
        char cur = s.charAt(index);
        int one = 0;
        if (cur != '0') {
            one = helper(s, index + 1);
        }
        
        char next = s.charAt(index + 1);
        int two = 0;
        int num = (cur - '0') * 10 + (next - '0');
        if (num >= 10 && num <= 26) {
            two = helper(s, index + 2);
        }
        
        return one + two;
    }
}
