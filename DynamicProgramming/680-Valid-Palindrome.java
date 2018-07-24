class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i + 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        System.out.println(dp[0][s.length() - 1]);
        return dp[0][s.length() - 1] <= 2;
    }
    
//     public boolean validPalindrome(String s) {
//         if (s == null || s.length() == 0) return true;
//         int left = 0, right = s.length() - 1;
//         int count = 0;
        
//         while(left < right) {
//             if (s.charAt(left) != s.charAt(right)) {
//                 if (count == 0) {
//                     return isPalindrome(left + 1, right, s) || isPalindrome(left, right - 1, s);
//                 } else {
//                     return false;
//                 }
//             }
//             left++;
//             right--;
//         }
//         return true;
//     }
    
//     private boolean isPalindrome(int l, int r, String s) {
//         while (l < r) {
//             if (s.charAt(l) != s.charAt(r)) return false;
//             l++;
//             r--;
//         }
//         return true;
//     }
}