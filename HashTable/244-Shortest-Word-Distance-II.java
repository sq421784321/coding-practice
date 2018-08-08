class WordDistance {
    private Map<String, List<Integer>> pos;
    
    public WordDistance(String[] words) {
        pos = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            List<Integer> indexes = pos.get(cur);
            if (indexes == null) {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            pos.put(cur, indexes);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> indexW1 = pos.get(word1);
        List<Integer> indexW2 = pos.get(word2);
        int i = 0, j = 0;
        int ans = Integer.MAX_VALUE;

        while (i < indexW1.size() && j < indexW2.size()) {
            int index1 = indexW1.get(i);
            int index2 = indexW2.get(j);
            if (index1 < index2) {
                ans = Math.min(ans, index2 - index1);
                i++;
            } else {
                ans = Math.min(ans, index1 - index2);
                j++;
            }
        }
        return ans;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */