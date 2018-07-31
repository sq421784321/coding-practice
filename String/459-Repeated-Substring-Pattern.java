class Solution {
    // Method 1: normal check
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = n / 2; i > 0; i--) {
            if (n % i == 0) {
                StringBuilder sb = new StringBuilder();
                String sub = s.substring(0, i);
                int count = n / i;
                while (count-- > 0) {
                    sb.append(sub);
                }
                
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // Method 2
    /*
        public boolean repeatedSubstringPattern(String s) {
            
            String ss = s + s;
            ss = ss.substring(1, ss.length() - 1);
            
            return ss.indexOf(s) >= 0;
        }
    */
}