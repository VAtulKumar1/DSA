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
    class Pair{

        TreeNode node;
        int index;

        Pair(TreeNode _node,int _index){
            index = _index;
            node = _node;

        }
    }
    public int widthOfBinaryTree(TreeNode root) {

         if(root==null) return 0;
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(root,1));
        int maxWidth = 0;
        while(!q.isEmpty()){
            int size=q.size();
            int startIndex = q.peek().index;
            int endIndex = 0;
            for(int i=0;i<size;i++){
                TreeNode node = q.peek().node;
                int index = q.peek().index;
                q.poll();

                if(node.left!=null) q.add(new Pair(node.left,2*index));
                if(node.right!=null) q.add(new Pair(node.right,2*index+1));
                if(i==size-1){
                    endIndex = index;
                }
            }
            maxWidth = Math.max(maxWidth,endIndex-startIndex+1);
        }

        return maxWidth;

        
    }
}