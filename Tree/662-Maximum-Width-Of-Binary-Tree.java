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
    
    //                0
    //            -1     0
    //          -3  -2 -1  0
    // cur          = x
    // leftChild    = x * 2 - 1
    // rightChild   = x * 2
    // width = (rightChild - leftChild) + 1
    
    public int widthOfBinaryTree(TreeNode root) {
        List<int[]> indexes = new ArrayList<>();
        helperRight(root, 0, 0, indexes);
        int ans = 1;
        for (int i = 0; i < indexes.size(); i++) {
            ans = Math.max(ans, indexes.get(i)[1] - indexes.get(i)[0] + 1);
        }
        return ans;
    }
    
    private void helperRight(TreeNode node, int depth, int cur, List<int[]> indexes) {
        if (node == null) return;
        if (indexes.size() == depth) {
            indexes.add(new int[] {cur, cur});
        } else if (indexes.size() > depth) {
            indexes.get(depth)[0] = Math.min(indexes.get(depth)[0], cur);
        }
        helperRight(node.right, depth + 1, cur * 2, indexes);
        helperRight(node.left, depth + 1, cur * 2 - 1, indexes);
    }
}