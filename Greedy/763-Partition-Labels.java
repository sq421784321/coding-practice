class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        
		// Record the last occurrence of each char
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int curEnd = 0;
        
        for (int right = 0; right < S.length(); right++) {
            int occ = map[S.charAt(right) - 'a'];
            curEnd = Math.max(occ, curEnd);
			
			// When right meets curEnd, we find a parition which is from [left, right]
            if (right == curEnd) {
                ans.add(right - left + 1);
                left = right + 1;
            }
        }
        return ans;
    }
}