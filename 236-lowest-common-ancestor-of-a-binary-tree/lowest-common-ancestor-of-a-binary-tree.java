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
    public boolean findPath(TreeNode root,TreeNode target,List<TreeNode> res){
        if(root==null) return  false;
        res.add(root);
        if(root.val==target.val) return true;
        if(findPath(root.left,target,res)||findPath(root.right,target,res)) return true;
        res.remove(res.size()-1);

        return false;




    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathTop = new ArrayList<>();
        TreeNode res = null;
        findPath(root,p,pathTop);
        List<TreeNode> pathToq = new ArrayList<>();
        findPath(root,q,pathToq);
        int n = Math.min(pathTop.size(),pathToq.size());
        int i=0;
        for (; i <n ; i++) {
            if(pathTop.get(i)!=pathToq.get(i))
            {
                res=pathTop.get(i-1);
                break;
            }

        }

        if(res==null){
            return pathTop.get(i-1);
        }

        return res;
    }
}