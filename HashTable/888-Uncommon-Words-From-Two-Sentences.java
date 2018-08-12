class Solution {
	/*
		Method 1: HashTable
		
		Iterate through all words in A and B, construct freq map
		Put those non-empty words of 1 freq into final list.
	*/
    public String[] uncommonFromSentences(String A, String B) {
        List<String> ans = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");
        
        for (String word: wordsA) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for (String word: wordsB) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for (String word: map.keySet()) {
            if (word.length() > 0 && map.get(word) == 1) {
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