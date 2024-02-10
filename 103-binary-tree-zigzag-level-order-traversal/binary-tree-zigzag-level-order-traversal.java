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
        int level;

        Pair(TreeNode _node, int _level){
            node = _node;
            level = _level;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> res =new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q= new LinkedList<>();
        if(root!=null){
            q.add(root);
        }
        int  level=0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> levelRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                levelRes.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);



            }

            if(!levelRes.isEmpty()){
                if(level==0) res.add(levelRes);
                else{
                    Collections.reverse(levelRes);
                    res.add(levelRes);
                }

            }

            level=level==0?1:0;


        }

        return res;
    }
}