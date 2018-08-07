class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos1 = -1;
        int pos2 = -1;
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            if (cur.equals(word1)) {
                pos1 = i;
                if (pos2 != -1) {
                    ans = Math.min(ans, pos1 - pos2);
                }
            } else if (cur.equals(word2)) {
                pos2 = i;
                if (pos1 != -1) {
                    ans = Math.min(ans, pos2 - pos1);
                }
            }
        }
        
        return ans;
    }
}