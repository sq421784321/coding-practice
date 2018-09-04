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
    /*
        Method 1: Recursion
    */
    
//     public TreeNode increasingBST(TreeNode root) {
//         TreeNode[] newRoot = new TreeNode[1];
//         TreeNode[] result = new TreeNode[1];
        
//         helper(root, newRoot, result);
        
//         return result[0];
//     }
    
//     private void helper(TreeNode oldRoot, TreeNode[] newRoot, TreeNode[] result) {
//         if (oldRoot == null) return;
        
//         helper(oldRoot.left, newRoot, result);
        
//         if (newRoot[0] == null) {
//             newRoot[0] = new TreeNode(oldRoot.val);
//             result[0] = newRoot[0];
//         } else {
//             newRoot[0].right = new TreeNode(oldRoot.val);
//             newRoot[0] = newRoot[0].right;
//         }
        
//         helper(oldRoot.right, newRoot, result);
//     }
    
    /*
        Method 2 : Iterative.
    */
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newRoot = null;
        TreeNode ans = newRoot;
        
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            // Inorder Traversal
            if (cur != null) {
                stack.offerLast(cur);
                cur = cur.left;
            } else {
                cur = stack.pollLast();
                if (newRoot == null) {
                    newRoot = new TreeNode(cur.val);
                    ans = newRoot;
                } else {
                    newRoot.right = new TreeNode(cur.val);
                    newRoot = newRoot.right;
                }
                cur = cur.right;
            }
        }
        
        return ans;
    }
}