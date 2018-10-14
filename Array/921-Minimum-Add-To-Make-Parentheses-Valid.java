class Solution {
	/*
		Method 1: Iterative.
		
		Count the number of unpaired left parentheses and right parentheses.
	*/
	
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) return 0;
        int open = 0;
        int close = 0;
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (cur == '(') {
                open += 1;
            } else {
                if (open == 0) {
                    close += 1;
                } else {
                    open -= 1;
                }
            }
        }
        
        return open + close;
    }
}