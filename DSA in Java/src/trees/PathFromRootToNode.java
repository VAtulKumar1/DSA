package trees;

import java.util.ArrayList;
import java.util.List;

public class PathFromRootToNode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static boolean path(TreeNode root, List<Integer> res,int[] target){
        if(root==null) return false;
        res.add(root.val);
        if(root.val == target[0]) return true;
        if(path(root.left,res,target)||path(root.right,res,target)) return true;
        res.remove(res.size()-1);


        return false;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.left.right.right.left = new TreeNode(8);
        List<Integer> res = new ArrayList<>();
        int[] target={8};
        path(root,res,target);
        System.out.println(res);

    }
}
