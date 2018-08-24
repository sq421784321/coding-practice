class Solution {
	/*
		Method 1: Sliding Window.
		
		Keep two pointers pointing to the latest indexes of two distinct chars within the current window.
		
		Time Complexity: O(N)
		Spcae Complexity: O(1)
	*/
	
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int ans = 0;
        int pos1 = -1;
        int pos2 = -1;
        int left = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (pos1 != -1 && pos2 != -1 && cur != s.charAt(pos1) && cur != s.charAt(pos2)) {
                if (pos1 < pos2) {
                    left = pos1 + 1;
                    pos1 = i;
                } else {
                    left = pos2 + 1;
                    pos2 = i;
                }
            } else {
                if (pos1 == -1 || s.charAt(pos1) == cur) {
                    pos1 = i;
                } else if (pos2 == -1 || s.charAt(pos2) == cur) {
                    pos2 = i;
                }
            }
            ans = Math.max(ans, i - left + 1);
        }
        
        return ans;
    }
}