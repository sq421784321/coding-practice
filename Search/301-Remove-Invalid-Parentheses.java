class Solution {
	// Method 1: DFS
    public List<String> removeInvalidParentheses(String s) {
        int leftToRemove = 0, rightToRemove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftToRemove += 1;
            } else if (s.charAt(i) == ')') {
                if (leftToRemove == 0) {
                    rightToRemove += 1;
                } else {
                    leftToRemove -= 1;
                }
            }
        }
        
        Set<String> ans = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        dfs(s, 0, leftToRemove, rightToRemove, 0, sb, ans);
        
        return new ArrayList<String>(ans);
    }
    
    private void dfs(String s, int curIndex, int leftToRemove, int rightToRemove, int valid, StringBuilder sb, Set<String> ans) {
        if (leftToRemove < 0 || rightToRemove < 0 || valid < 0) {
            return;
        }
        
        if (curIndex == s.length()) {
            if (leftToRemove == 0 && rightToRemove == 0 && valid == 0) {
                ans.add(sb.toString());
            }
            return;
        }
        
        
        char c = s.charAt(curIndex);
        int length = sb.length();
        
        if (c == '(') {
            dfs(s, curIndex + 1, leftToRemove - 1, rightToRemove, valid, sb, ans);  // not use '('
            dfs(s, curIndex + 1, leftToRemove, rightToRemove, valid + 1, sb.append(c), ans); // use '('
        } else if (c == ')') {
            dfs(s, curIndex + 1, leftToRemove, rightToRemove - 1, valid, sb, ans);  // not use ')'
            dfs(s, curIndex + 1, leftToRemove, rightToRemove, valid - 1, sb.append(c), ans); // use ')'
        } else {
            dfs(s, curIndex + 1, leftToRemove, rightToRemove, valid, sb.append(c), ans); // use letters
        }
        
        sb.setLength(length);
    }

	
//	  Method 2: BFS
//    public List<String> removeInvalidParentheses(String s) {
//         List<String> ans = new ArrayList<>();
        
//         Set<String> visited = new HashSet<>();
//         Deque<String> queue = new LinkedList<>();
        
//         queue.add(s);
//         visited.add(s);
        
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             int ansSize = ans.size();
            
//             while (size-- > 0) {
//                 String cur = queue.pollFirst();
//                 if (isValid(cur)) {
//                     ans.add(cur);
//                 } else {
//                     for (int i = 0; i < cur.length(); i++) {
//                         if (cur.charAt(i) == '(' || cur.charAt(i) == ')') {
//                             String next = cur.substring(0, i) + cur.substring(i + 1);
                            
//                             if (!visited.contains(next)) {
//                                 queue.add(next);
//                                 visited.add(next);
//                             }
//                         }   
//                     }
//                 }
//             }
            
//             if (ans.size() > ansSize) {
//                 break;
//             }
//         }
        
//         return ans;
//     }
    
//     private boolean isValid(String s) {
//         int count = 0;
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') count++;
//             if (s.charAt(i) == ')') count--;
//             if (count < 0) return false;
//         }
//         return count == 0;
//     }
}