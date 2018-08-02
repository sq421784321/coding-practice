class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();		// Result list	
        List<Integer> tmp = new ArrayList<>();		// Temporary list        
        helper(S, 0, tmp, ans);
        return ans;
    }
    
    private void helper(String str, int start, List<Integer> tmp, List<Integer> ans) {
        if (start == str.length()) {
            if (tmp.size() >= 3) {
                for (int num : tmp) {
                    ans.add(num);
                }
            }
            return;
        }
		
        // We just need to store one fib seq
		// Once we found the first answer, we just prune all the recusion path.
        if (!ans.isEmpty()) return;
        
        for (int i = 1; i <= Math.min(start + 10, str.length() - start); i++) {
            String cur = str.substring(start, start + i);
			
			// Avoid leading zero except zero itself.
            if (cur.charAt(0) == '0' && cur.length() > 1) {
                continue;
            }
            
			// Avoid number larger than Integer.MAX
            long curVal = Long.valueOf(cur);
            if (curVal > Integer.MAX_VALUE) {
                return;
            }
            
			// Try all the posibilities of the first two numbers
            if (tmp.size() <= 1) {
                tmp.add((int)curVal);
                helper(str, start + i, tmp, ans);
				// Backtrack to try all posibilities
                tmp.remove(tmp.size() - 1);
            }
            
			// Only number meet the fib requirements would be considered.
            if (tmp.size() >= 2) {
                if (tmp.get(tmp.size() - 1) + tmp.get(tmp.size() - 2) == curVal) {
                    tmp.add((int)curVal);
                    helper(str, start + i, tmp, ans);
                    tmp.remove(tmp.size() - 1);
                } else if (tmp.get(tmp.size() - 1) + tmp.get(tmp.size() - 2) < curVal) {	// Once larger, no need to check this level anymore.
                    return;
                }
            }
        }
    }
}