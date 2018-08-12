class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> ans = new ArrayList<>();
        
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");
        
        for (String word: wordsA) {
            mapA.put(word, mapA.getOrDefault(word, 0) + 1);
        }
        
        for (String word: wordsB) {
            mapB.put(word, mapB.getOrDefault(word, 0) + 1);
        }
        
        for (String word: mapA.keySet()) {
            if (word.length() > 0 && mapA.get(word) == 1 && !mapB.containsKey(word)) {
                ans.add(word);
            }
        }
        
        for (String word: mapB.keySet()) {
            if(word.length() > 0 && mapB.get(word) == 1 && !mapA.containsKey(word)) {
                ans.add(word);
            }
        }
        
        
        String[] array = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            array[i] = ans.get(i);
        }
        
        return array;
    }
}