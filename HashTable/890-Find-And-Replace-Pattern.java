class Solution {
	/*
		Method 1: Iterative.
		
	*/
	
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word: words) {
            helper(word, pattern, ans);
        }
        return ans;
    }
    
    private void helper(String word, String pattern, List<String> ans) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> visited = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            Character des = map.get(pattern.charAt(i));         
            if (des == null) {
                if (visited.contains(word.charAt(i))) {
                    return;
                }
                map.put(pattern.charAt(i), word.charAt(i));
                visited.add(word.charAt(i));
            } else if (word.charAt(i) != des) {
                return;
            }
        }        
        ans.add(word);
    }
}