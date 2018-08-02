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
    // Traps:
    // 1: when sum is odd (no matter positive or negetive), return false
    // 2: delete exactly one edge. So when sum is 0, and one branch returns 0, need to check the presence of edge.
    
    private boolean ans = false;
    
    public boolean checkEqualTree(TreeNode root) {
        int sum = getSum(root);
        if (Math.abs(sum) % 2 == 1) return false;
        
        helper(root, sum);
        return ans;
    }
    
    private int helper(TreeNode node, int sum) {
        if (node == null) return 0;
        if (ans) return 0;
        
        int left = helper(node.left, sum);
        int right = helper(node.right, sum);
        
        if (node.left != null && left == sum / 2) {
            ans = true;
        } else if (node.right != null && right == sum / 2) {
            ans = true;
        }
        
        return node.val + left + right;
    }
    
    private int getSum(TreeNode node) {
        if (node == null) return 0;
        int left = getSum(node.left);
        int right = getSum(node.right);
        return node.val + left + right;
    }
}