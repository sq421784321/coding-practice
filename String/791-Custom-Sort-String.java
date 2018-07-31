class Solution {
    public String customSortString(String S, String T) {
        int[] counts = new int[26];
        for (int i = 0; i < T.length(); i++) {
            counts[T.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            while (counts[cur - 'a']-- > 0) {
                sb.append(cur);
            }
        }
        
        for (int i = 0; i < counts.length; i++) {
            while(counts[i]-- > 0) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }
}