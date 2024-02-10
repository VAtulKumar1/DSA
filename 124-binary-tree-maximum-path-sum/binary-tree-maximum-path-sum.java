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
    public int calculateSum(TreeNode node,int[] maxSum){
        if(node == null){
            return 0;
        }
        int ls = Math.max(0,calculateSum(node.left,maxSum));
        int rs =  Math.max(0,calculateSum(node.right,maxSum));
        
        maxSum[0] = Math.max(maxSum[0],ls+rs+node.val);
        return Math.max(node.val,node.val+Math.max(ls,rs));
    }
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        Arrays.fill(res,Integer.MIN_VALUE);
        calculateSum(root,res);
        return res[0];
       
    }
}