class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {    // rule 4
            return false;
        } 
        Map<String, String> map = getMap(pairs);
        
        // Union/Find
        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];

            if (w1.equals(w2)) {        // rule 3
                continue;
            }
            String head1 = find(w1, map);
            String head2 = find(w2, map);

            if (head1 == null || head2 == null || !head1.equals(head2)) {
                return false;
            }
        }
        
        return true;
    }
    
    private String find(String w, Map<String, String> map) {
        if (!map.containsKey(w)) {
            return null;
        }
        if (map.get(w).equals(w)) return w;
        return find(map.get(w), map);
    }
    
    private void union(String w1, String w2, Map<String, String> map) {
        String head1 = find(w1, map);
        String head2 = find(w2, map);
        
        if (head1 == null && head2 == null) {
            map.put(w1, w1);
            map.put(w2, w1);
        } else if (head1 == null && head2 != null) {
            map.put(w1, head2);
        } else if (head1 != null && head2 == null) {
            map.put(w2, head1);
        } else {
            map.put(head1, head2);
        }
    }
    
    // Method: DFS 
    // private boolean helper(String s, String e, Map<String, HashSet<String>> map, HashSet<String> visited) {
    //     if (s.equals(e)) {
    //         return true;
    //     }
    //     if (!map.containsKey(s)) {
    //         return false;
    //     }
    //     visited.add(s);
    //     HashSet<String> neis = map.get(s);
    //     for (String nei : neis) {
    //         if (!visited.contains(nei) && helper(nei, e, map, visited)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    
    private Map<String, String> getMap(String[][] pairs) {
        Map<String, String> map = new HashMap<>();
        for (String[] pair: pairs) {
            String w1 = pair[0];
            String w2 = pair[1];
            union(w1, w2, map);
        }
        return map;
    }
}