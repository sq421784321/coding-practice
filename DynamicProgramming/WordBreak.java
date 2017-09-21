/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

// The intuition is to use dynamic programming to find whether dp(i) is true or false.
// dp(i) represents the result of s.substring[0, i).
// so, dp(i) = dp(j) && s.substring(0, j)
// Meanwhile, use the maxLen to prune those predictable results.

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>();
        int maxLen = 0;
        for(String word : wordDict) {
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = i; j >= Math.max(0, i - maxLen); j--) {
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}
