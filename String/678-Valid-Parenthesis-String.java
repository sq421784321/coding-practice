class Solution {
    /*
        Method 1: Greedy.
		
		For each '*', we can make it to be '(', '', or ')'. Total three cases.
		What we need here is merely the balance, which is the remaining open left brackets.
		Plus, whenever we meet a '*', we could possibly transform it to '(', '', or ')', so we will have a range of possible number of open left brackets.
		Just keep track of that, and check whether the lower bound can be 0 eventually.
    */
    
    public boolean checkValidString(String s) {
        // Range [lo, hi] represents the range of possible open left brackets so far
        int lo = 0;
        int hi = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if (cur == '(') {
                lo += 1;
            } else {
                lo -= 1;        // for '*' and ')', we just calculate the minimum of lo
            }
            
            if (cur == ')') {
                hi -= 1;        
            } else {
                hi += 1;        // for '*' and '(', we just calculate the maximum of hi
            }
            
            if (hi < 0) return false;
            lo = Math.max(lo, 0);
        }
        
        return lo == 0;
    }
}