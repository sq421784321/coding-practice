class Solution {
	/*
		Method 1: Iterative.
		
		Set 4 flags to keep track of different states.
	*/
	
    public boolean isNumber(String s) {
        s = s.trim();
        
        boolean numberSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        boolean endWithE = false;
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                numberSeen = true;
                endWithE = false;
            } else if (cur == '.') {
                if (dotSeen || eSeen) return false;
                dotSeen = true;
            } else if (cur == 'e' || cur == 'E') {
                if (eSeen || !numberSeen) return false;
                endWithE = true;
                eSeen = true;
            } else if (cur == '+' || cur == '-') {
                if (i != 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) return false;
            } else {
                return false;
            }
        }
        
        return !endWithE && numberSeen;
    }
}


// valid
// -1.
// +1.
// 2e+6
// 005047e+6

// invalid
// +++
// 1e
// e10