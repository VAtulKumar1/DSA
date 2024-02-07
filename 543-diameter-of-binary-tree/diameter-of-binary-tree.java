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
    int maxDiameter = 0;
    public int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int lh = maxDepth(node.left);
        int rh = maxDepth(node.right);
        int diameter = lh+rh;
        if(maxDiameter<diameter) maxDiameter = diameter;
        return 1+Math.max(lh,rh);

    }
    public int diameterOfBinaryTree(TreeNode root) {
       
        maxDepth(root);
        return maxDiameter;
        
    }
}