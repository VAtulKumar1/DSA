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

    
    public int checkHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        int lh = checkHeight(node.left);
        int rh = checkHeight(node.right);
        if(lh==-1 || rh == -1) return -1;
        if(Math.abs(lh-rh)>1) return -1;

        return 1+Math.max(lh,rh);
    }
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root)==-1?false:true;
       

    }
}