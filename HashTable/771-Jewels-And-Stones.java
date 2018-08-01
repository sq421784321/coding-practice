class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] map = new boolean[52];
        for (int i = 0; i < J.length(); i++) {
            char cur = J.charAt(i);
            if (cur >= 'a' && cur <= 'z') {
                map[cur - 'a'] = true;
            } else if (cur >= 'A' && cur <= 'Z') {
                map[cur - 'A' + 26] = true;
            }
        }
        
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (cur >= 'a' && cur <= 'z' && map[cur - 'a']) {
                count++;
            } else if (cur >= 'A' && cur <= 'Z' && map[cur - 'A' + 26]) {
                count++;
            }
        }
        
        return count;
    }
}