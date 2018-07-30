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
    public String tree2str(TreeNode t) {
		// Method 1: DFS bottom-up
		
		/*
		if (t == null) return "";
		
		if (t.left == null && t.right == null) return t.val + "";
        
		String left = tree2str(t.left);
		String right = tree2str(t.right);

		if (left.length() == 0 && right.length() == 0) {
			return t.val + "";
		} else if (left.length() == 0 && right.length() != 0) {
			return t.val + "(" + left + ")" + "(" + right + ")";
		} else if (left.length() != 0 && right.length() == 0) {
			return t.val + "(" + left + ")";
		} else {
			return t.val + "(" + left + ")" + "(" + right + ")";
		}
		
		// line 22 - 30 can be replaced with :
		// right = right.length() == 0 ? right : "(" + right + ")";
		// left = right.length() == 0 && left.length() == 0 ? left : "(" + left + ")";
		// return t.val + left + right;
		*/
        
		// Method 2 : BFS level traversal
        if (t == null) return "";
        
        Deque<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        stack.offerLast(t);
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekLast();
            if (!visited.contains(cur)) {
                sb.append("(" + cur.val);
                visited.add(cur);
                if (cur.left == null && cur.right != null) {
                    sb.append("()");
                }
                if (cur.right != null) {
                    stack.offerLast(cur.right);
                }
                if (cur.left != null) {
                    stack.offerLast(cur.left);
                }
            } else {
                sb.append(")");
                stack.pollLast();
            }
        }
        
        return sb.substring(1, sb.length() - 1);
    }
}