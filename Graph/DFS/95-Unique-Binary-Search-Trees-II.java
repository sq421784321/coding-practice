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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int min, int max) {
        if (min > max) {
            TreeNode node = null;
            return Arrays.asList(node);
        }
        
        List<TreeNode> ans = new ArrayList<>();
        
        for (int i = min; i <= max; i++) {
            List<TreeNode> left = helper(min, i - 1);
            List<TreeNode> right = helper(i + 1, max);

            for (TreeNode l : left) {
                for (TreeNode r : right) {

                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;

                    ans.add(node);
                }
            }
                
        }
        
        return ans;
    }
}