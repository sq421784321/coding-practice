/*
There is a new alien language which uses the latin alphabet. 
However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, 
where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Example 2:
Given the following words in dictionary,

[
  "z",
  "x"
]
The correct order is: "zx".

Example 3:
Given the following words in dictionary,

[
  "z",
  "x",
  "z"
]
The order is invalid, so return "".

Note:
You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
*/


class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, Set<Character>> map = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        
        for(String s : words) {
            for(char c : s.toCharArray()) {
                indegree.put(c, 0);
            }
        }
        
        for(int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            for(int j = 0; j < Math.min(next.length(), cur.length()); j++) {
                char cur_c = cur.charAt(j);
                char next_c = next.charAt(j);
                if(cur_c != next_c) {
                    Set<Character> set = new HashSet<>();
                    if(map.containsKey(cur_c)) {
                        set = map.get(cur_c);
                    }
                    if(!set.contains(next_c)) {
                        set.add(next_c);
                        map.put(cur_c, set);
                        indegree.put(next_c, indegree.get(next_c) + 1);
                    }
                    break;
                }
            }
        }
        
        
        Deque<Character> queue = new LinkedList<>();
        for(char c : indegree.keySet()) {
            if(indegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        StringBuilder rs = new StringBuilder();
        
        while(!queue.isEmpty()) {
            char c = queue.poll();
            rs.append(c);
            if(map.containsKey(c)) {
                for(char c2 : map.get(c)) {
                    indegree.put(c2, indegree.get(c2) - 1);
                    if(indegree.get(c2) == 0) {
                        queue.offer(c2);
                    }
                }
            }
        }
        
        if(rs.length() != indegree.size()) {
            return "";
        }
        return rs.toString();
    }
}
