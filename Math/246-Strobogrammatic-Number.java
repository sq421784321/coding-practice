class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return false;
        
        int left = 0, right = num.length() - 1;
        
        while (left < right) {
            if (num.charAt(left) == '6' && num.charAt(right) == '9' ||
               num.charAt(left) == '9' && num.charAt(right) == '6' ||
               num.charAt(left) == '8' && num.charAt(right) == '8' ||
               num.charAt(left) == '0' && num.charAt(right) == '0' || 
               num.charAt(left) == '1' && num.charAt(right) == '1') {
                left++;
                right--;
                continue;
            }
            return false;
        }
        
        // odd length
        if (left == right) {
            if (num.charAt(left) == '0' || num.charAt(left) == '1' || num.charAt(left) == '8') {
                return true;
            }
            return false;
        }
        
        return true;
    }
    
}

/*
    6 == 9
    9 == 6
    8 == 8
    0 == 0
	1 == 1

*/