// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

// Return all such possible sentences.

// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].

// A solution is ["cats and dog", "cat sand dog"].

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> helper(String s, List<String> wordDict, Map<String, List<String>> map) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        
        List<String> cur = new ArrayList<>();
        if(s.length() == 0) {
            cur.add("");
            return cur;
        }
        
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                List<String> sublist = helper(s.substring(word.length()), wordDict, map);
                
                for(String sub : sublist) {
                    cur.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        
        map.put(s, cur);
        return cur;
    }
}
