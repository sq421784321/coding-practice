class Solution {
	/*
		Method 1: Iterative + Set.
	*/
	
    private final String[] map = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> visited = new HashSet<>();
        
        for (String word: words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(map[c - 'a']);
            }
            visited.add(sb.toString());
        }
        
        return visited.size();
    }
}