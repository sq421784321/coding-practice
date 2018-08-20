class Solution {
//	   Method 1: DP

//     public String longestPalindrome(String s) {
//         boolean[][] dp = new boolean[s.length()][s.length()];
//         // dp[i][i]       = true, for i = 0 to n - 1
//         // dp[i][j]       if dp[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)  ||
//         //                   i + 1 == j && s.charAt(i) == s.charAt(j)
//         int startIndex = 0;
//         int endIndex = 0;
        
//         for (int i = s.length() - 1; i >= 0; i--) {
//             for (int j = i; j < s.length(); j++) {
//                 if (j == i) {
//                     dp[i][j] = true;
//                 } else if (s.charAt(i) == s.charAt(j) && (i + 1 == j || dp[i + 1][j - 1])) {
//                     dp[i][j] = true;
//                 }
//                 if (dp[i][j] && j - i >= endIndex - startIndex) {
//                     startIndex = i;
//                     endIndex = j;
//                 }
//             }
//         }
//         return s.substring(startIndex, endIndex + 1);
//     }

	/*
		Method 2 : Iterative.
		
		For each index, treat it and its next as the middle of the palindrome string respectively.
	*/
	
    public String longestPalindrome(String s) {
        
        int startIndex = 0;
        int curLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            int oddLength = getLength(i, i, s);
            int evenLength = getLength(i, i  + 1, s);
            
            int tempMax = Math.max(oddLength, evenLength);
            if (tempMax > curLength) {
                startIndex = i - (tempMax - 1) / 2;
                curLength = tempMax;
            }
        }
        
        return s.substring(startIndex, startIndex + curLength);
    }
    
    private int getLength(int left, int right, String s) {
        int length = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                if (left == right) {
                    length += 1;
                } else {
                    length += 2;
                }
            } else {
                break;
            }
            left--;
            right++;
        }
        return length;
    }
}