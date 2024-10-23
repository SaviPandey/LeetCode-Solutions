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
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        while (!q.isEmpty()) {
            List<TreeNode> levelNodes = new ArrayList<>();
            int nextLevelSum = 0;

            for (int size = q.size(); size > 0; size--) {
                TreeNode curr = q.poll();
                levelNodes.add(curr);
                if (curr.left != null) {
                    q.offer(curr.left);
                    nextLevelSum += curr.left.val;
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                    nextLevelSum += curr.right.val;
                }
            }
            for (TreeNode node : levelNodes) {
                int sum = nextLevelSum;
                if (node.left != null) {
                    sum -= node.left.val;
                }
                if (node.right != null) {
                    sum -= node.right.val;
                }
                if (node.left != null) {
                    node.left.val = sum;
                }
                if (node.right != null) {
                    node.right.val = sum;
                }
            }
        }
        return root;
    }
}