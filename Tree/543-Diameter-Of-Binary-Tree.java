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
		Method 1: Bottom Up Recursion.
		
		Recursion: return the length of current node. 
	*/
	
	public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[]{1};
        helper(root, ans);
        return ans[0] - 1;
    }
    
    private int helper(TreeNode node, int[] ans) {
        if (node == null) return 0;
        
        int left = helper(node.left, ans);
        int right = helper(node.right, ans);
        
        ans[0] = Math.max(ans[0], 1 + left + right);
        
        return 1 + Math.max(left, right);
    }
}