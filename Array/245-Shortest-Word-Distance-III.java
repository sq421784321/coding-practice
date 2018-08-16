class Solution {
	/*
		Method 1 : Iterative
		
		Every time update the smaller index if two words are same.
	*/
	
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int ans = words.length;
        int pos1 = -1;
        int pos2 = -1;
        
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            
            if (cur.equals(word1)) {
                if (word1.equals(word2)) {
                    if (pos1 < pos2) {
                        pos1 = i;
                    } else {
                        pos2 = i;
                    }
                } else {
                    pos1 = i;
                }
            } else if (cur.equals(word2)) {
                if (word1.equals(word2)) {
                    if (pos1 < pos2) {
                        pos1 = i;
                    } else {
                        pos2 = i;
                    }
                } else {
                    pos2 = i;
                }
            }
            if (pos1 != -1 && pos2 != -1) {
                ans = Math.min(ans, Math.abs(pos2 - pos1));
            }
        }
        return ans;
    }
}