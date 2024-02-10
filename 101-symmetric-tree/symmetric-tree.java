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
    private  boolean check(TreeNode l,TreeNode r){
        if(l==null || r==null){
            return l==r;
        }
        boolean ls=check(l.left,r.right);
        if(l.val!=r.val) return false;
        boolean rs=check(l.right,r.left);
        return ls&rs;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return check(root.left,root.right);
    }
}