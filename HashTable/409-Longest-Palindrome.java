class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int[] dict = new int[52];
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur - 'a' >= 0 && cur - 'a' <= 25) {
                dict[cur - 'a']++;
            } else if (cur - 'A' >= 0 && cur - 'A' <= 25) {
                dict[cur - 'A' + 26]++;
            }
        }
        
        int ans = 0;
        boolean addOne = false;
        for (int i = 0; i < dict.length; i++) {
            if (dict[i] % 2 == 0) {
                ans += dict[i];
            } else if (dict[i] > 0) {
                ans += dict[i] - 1;
                addOne = true;
            }
        }
        
        return addOne ? ans + 1 : ans;
    }
}