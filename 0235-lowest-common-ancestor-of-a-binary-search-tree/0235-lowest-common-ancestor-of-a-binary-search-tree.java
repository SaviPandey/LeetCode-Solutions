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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // there is only three cases

// 1st one is that if both p & q are smaller than the root then call the left subtree
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
	// 2nd if both p & q are greter than the root then call the right subtree
        else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
	// 3rd is that we get our answer that is root :)
        else{
            return root;
        }
    }
}