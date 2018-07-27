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
    class MyNode {
        int val;
        MyNode left, right, parent;
        public MyNode(int x) {
            val = x;
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<>();
        
		// Rebuild a binary tree with the parent property
        MyNode[] array = new MyNode[] {null};
        MyNode myNode = rebuild(root, null, target, array);
        // New Target Node
		MyNode targetNode = array[0];
        
		// Start from New Target Node, do BFS
		// Stop at distance K
        Deque<MyNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offerLast(targetNode);
        visited.add(targetNode.val);
        
        while (K-- > 0) {
            int size = queue.size();
            while (size-- > 0) {
                MyNode cur = queue.pollFirst();
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
        }
        
		// Remaining Nodes in queue are all distance K from New Target Node
        while (!queue.isEmpty()) {
            ans.add(queue.pollFirst().val);
        }
        
        return ans;
    }
    
    private MyNode rebuild(TreeNode node, MyNode parent, TreeNode target, MyNode[] array) {
        if (node == null) return null;
        
        MyNode myNode = new MyNode(node.val);
        myNode.left = rebuild(node.left, myNode, target, array);
        myNode.right = rebuild(node.right, myNode, target, array);
        myNode.parent = parent;
        
        if (target.val == node.val) {
            array[0] = myNode;
        }
        
        return myNode;
    }
}