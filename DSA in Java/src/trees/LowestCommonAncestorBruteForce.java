package trees;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorBruteForce {


    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static boolean findPath(TreeNode root,TreeNode target,List<TreeNode> res){
        if(root==null) return  false;
        res.add(root);
        if(root.val==target.val) return true;
        if(findPath(root.left,target,res)||findPath(root.right,target,res)) return true;
        res.remove(res.size()-1);

        return false;




    }
    public static  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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



    public static void main(String args[]){
        TreeNode root=new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode res = lowestCommonAncestor(root,p,q);
        System.out.println(res.val);

    }

}
