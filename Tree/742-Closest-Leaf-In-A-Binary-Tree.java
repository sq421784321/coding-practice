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
    class TNodewithP {
        int val;
        TNodewithP left, right, parent;
        TNodewithP(int x) { val = x; }
    }
    
    TNodewithP s = null;
    
	// BFS to find nearest leaf node.
    public int findClosestLeaf(TreeNode root, int k) {
        TNodewithP newRoot = build(root, null, k);
        
        Deque<TNodewithP> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offerLast(s);
        visited.add(s.val);
        
        while (!queue.isEmpty()) {
            TNodewithP cur = queue.pollFirst();
            if (cur.left == null && cur.right == null) {
                return cur.val;
            }
            if (cur.left != null && !visited.contains(cur.left.val)) {
                visited.add(cur.left.val);
                queue.offerLast(cur.left);
            }
            if (cur.right != null && !visited.contains(cur.right.val)) {
                visited.add(cur.right.val);
                queue.offerLast(cur.right);
            }
            if (cur.parent != null && !visited.contains(cur.parent.val)) {
                visited.add(cur.parent.val);
                queue.offerLast(cur.parent);
            }
        }
        return -1;
    }
    
	// Copy TreeNode to TNodewithP adding parent node
    private TNodewithP build(TreeNode node, TNodewithP prev, int k) {
        if (node == null) {
            return null;
        }        
        
        TNodewithP curr = new TNodewithP(node.val);
        curr.parent = prev;
        
        if (node.val == k) {
            s = curr;
        }
        
        curr.left = build(node.left, curr, k);
        curr.right = build(node.right, curr, k);
        return curr;
    }
}