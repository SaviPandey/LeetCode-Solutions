/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        solve(res, root);
        return res;
    }
    private void solve(List<Integer> res, TreeNode root) {
        if(root == null) return;

        //Treverse left Node
        solve(res, root.left);

        //Add Parent Node
        res.add(root.val);

        //Traverse Right Node
        solve(res, root.right);
    }
}