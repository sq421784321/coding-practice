/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        s = "(" + s + ")";
        Deque<TreeNode> stack = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) return stack.peekLast();
            char c = s.charAt(i);
            // "(" : push operation 
            // 1. get the integer, create a new TreeNode
            // 2. determine leftchild or rightchild
            // 3. push to the stack
            if (c == '(') {
                int num = 0;
                int sign = 1;
                
                int j = i + 1;
                if (s.charAt(j) == '-') {
                    j++;
                    sign = -1;
                }
                
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num *= 10;
                    num += s.charAt(j) - '0';
                    j++;
                }
                num *= sign;
                
                TreeNode node = new TreeNode(num);
                if (s.charAt(i + 1) == ')') {
                    node = null;
                }
                
                // Trick:
                // if s[i - 1] is a digit, means it's the leftchild
                // otherwise, rightchild
                if (!stack.isEmpty()) {
                    if (i - 1 >= 0 && Character.isDigit(s.charAt(i - 1))) {
                        stack.peekLast().left = node;
                    } else {
                        stack.peekLast().right = node;
                    }
                }
                stack.offerLast(node);
                i = j - 1;
            } else if (c == ')') {  // ")" : pop operation.
                stack.pollLast();
            }
        }
        return null;
    }
}
