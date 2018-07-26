class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd
            count += helper(i, i, s);
            // even
            count += helper(i, i + 1, s);
        }
        return count;
    }
    
    private int helper(int l, int r, String s) {
        int count = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                return count;
            }
            l--;
            r++;
            count += 1;
        }
        return count;
    }
}