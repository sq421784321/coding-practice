class Solution {
	/*
		Method 1: Bi-directional BFS
		
		Maintain Two Sets, when these two sets have overlap, then we find the shortest distance.
	*/
	
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>();
        int step = 2;
        
        beginSet.add(beginWord);
        
        for (String word : wordList) {
            if (endWord.equals(word)) {
                endSet.add(endWord);
            }
            wordSet.add(word);
        }
        
        if (endSet.size() == 0) {
            return 0;
        }
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (endSet.size() < beginSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            
            Set<String> nextSet = new HashSet<>();
            for (String cur : beginSet) {
                char[] charArray = cur.toCharArray();
                
                for (int i = 0; i < charArray.length; i++) {
                    char old = charArray[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (old != j) {
                            charArray[i] = j;
                            String next = new String(charArray);
                            
                            if (endSet.contains(next)) {
                                return step;
                            }
                            
                            if (wordSet.contains(next)) {
                                nextSet.add(next);
                                wordSet.remove(next);
                            }
                        }
                    }
                    charArray[i] = old;
                }
            }
            
            beginSet = nextSet;
            step++;
        }
        
        return 0;
    }
}