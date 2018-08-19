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
		
		Recursion: return root node of the binary tree based on given input array and its range.
		
		For each recursion:
			1. Create a new TreeNode 'node' with value of pre[preLeft]
			2. find leftChildIndex in post array
			3. node.left = recursion(preArray, preLeft + 1, newPreRight, postLeft, newPostRight)
			4. node.right = recursion(preArray, newPreRight + 1, preRight, newPostRight + 1, postRight)
	*/
	
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        
        return helper(pre, 0, pre.length - 1, 0, post.length - 1, map);
    }
    
    private TreeNode helper(int[] pre, int preLeft, int preRight, int postLeft, int postRight, Map<Integer, Integer> map) {
        if (preLeft > preRight) {
            return null;
        } else if (preLeft == preRight) {
            TreeNode node = new TreeNode(pre[preLeft]);
            return node;
        }
        
        TreeNode node = new TreeNode(pre[preLeft]);
        
        int leftChildIndex = map.get(pre[preLeft + 1]);
        node.left = helper(pre, preLeft + 1, preLeft + 1 + (leftChildIndex - postLeft), postLeft, leftChildIndex, map);
        node.right = helper(pre, preLeft + 1 + (leftChildIndex - postLeft) + 1, preRight, leftChildIndex + 1, postRight, map);
        return node;
    }
    
    
}