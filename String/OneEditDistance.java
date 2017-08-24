// Given two strings S and T, determine if they are both one edit distance apart.

// One Edit Distance:
// Replace a char     s: abcd    
//                    t: abce

// Insert a char      s: abc
//                    t: abcd

// Delete a char      s: abcd
//                    t: abc

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        for(int i = 0; i < Math.min(n, m); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));       // replace
                } else if (s.length() < t.length()) {  
                    return s.substring(i).equals(t.substring(i + 1));           // s insert a char
                } else {
                    return s.substring(i + 1).equals(t.substring(i));           // s delete a char
                }
            }    
        }
        
        return Math.abs(n - m) == 1;
    }
}
