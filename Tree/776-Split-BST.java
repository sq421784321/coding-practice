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
    // Method 1: iterative
    // use stack to store the path of root-to-leaf from root to V
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] ans = new TreeNode[2];
        
        Deque<TreeNode> stack = new LinkedList<>();
        
        while (root != null) {
            stack.offerLast(root);
            if (root.val > V) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pollLast();
            if (cur.val > V) {
                cur.left = ans[1];
                ans[1] = cur;
            } else {
                cur.right = ans[0];
                ans[0] = cur;
            }
        }
        
        return ans;
    }
    
    
    // Method 2: recursion
    /*
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) return new TreeNode[2];
        
        if (root.val == V) {
            TreeNode small = root;
            TreeNode large = root.right;
            root.right = null;
            return new TreeNode[] {small, large};
        } else if (root.val < V) {
            TreeNode small = root;
            TreeNode[] right = splitBST(root.right, V);
            small.right = null;
            if (right[0] != null) {
                small.right = right[0];
            }
            return new TreeNode[] {small, right[1]}; 
        } else {
            TreeNode[] left = splitBST(root.left, V);
            TreeNode large = root;
            large.left = null;
            if (left[1] != null) {
                large.left = left[1];
            }
            return new TreeNode[] {left[0], large};
        }
    }
    */
     
}