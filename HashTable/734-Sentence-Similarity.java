class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        // 1. Similarity relation is not transitive
        // 2. similarity is symmetric
        // 3. a word is always similar with itself
        // 4. same number of words
        if (words1 == null && words2 == null) {
            return true;
        } else if ((words1 == null || words2 == null) || (words1.length != words2.length)) {    // rule 4
            return false;
        } else {
            Map<String, HashSet<String>> map = getMap(pairs);
            for (int i = 0; i < words1.length; i++) {
                String w1 = words1[i];
                String w2 = words2[i];
                
                if (w1.equals(w2) || (map.containsKey(w1) && map.get(w1).contains(w2))) {        // rule 3
                    continue;
                }
                return false;
            }
            return true;
        }
    }
    
    private Map<String, HashSet<String>> getMap(String[][] pairs) {
        Map<String, HashSet<String>> map = new HashMap<>();
        for (String[] pair: pairs) {
            String w1 = pair[0];
            String w2 = pair[1];

            HashSet<String> set = map.get(w1);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(w2);
            map.put(w1, set);

            set = map.get(w2);          // rule 2
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(w1);
            map.put(w2, set);
        }
        return map;
    }
}