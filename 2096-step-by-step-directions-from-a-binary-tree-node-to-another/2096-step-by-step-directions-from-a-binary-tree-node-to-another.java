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
    private TreeNode getLCA(TreeNode root, int start, int dest) {
        if(root == null || root.val == start || root.val == dest) {
            return root;
        }
        TreeNode leftLCA = getLCA(root.left, start, dest);
        TreeNode rightLCA = getLCA(root.right, start, dest);

        if(leftLCA != null && rightLCA != null) return root;

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    private boolean traverse(TreeNode root, StringBuilder path, int val) {
        if(root == null) return false;
        if(root.val == val) return true;

        //Left Subtree
        path.append('L');
        if(traverse(root.left, path, val)) return true;
        path.deleteCharAt(path.length() - 1);           //BackTrack is left not found

        //Right SSUbtree
        path.append('R');
        if(traverse(root.right, path, val)) return true;
        path.deleteCharAt(path.length() - 1);

        //Not Found
        return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = getLCA(root, startValue, destValue);

        StringBuilder lca_to_start = new StringBuilder();
        StringBuilder lca_to_dest = new StringBuilder();

        traverse(lca, lca_to_start, startValue);
        traverse(lca, lca_to_dest, destValue);

        for(int i=0 ; i < lca_to_start.length(); i++) {
            lca_to_start.setCharAt(i, 'U');
        }

        return lca_to_start.toString() + lca_to_dest.toString();
    }
}