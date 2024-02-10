package trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class PathToAllNodes {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void Paths(TreeNode root, List<String> res, String path){
        if(root.left==null && root.right ==null){
            res.add(path+root.val);
            return;
        }
        if(root.left!=null)Paths(root.left,res,path+root.val+"->");
        if(root.right!=null) Paths(root.right,res,path+root.val+"->");

    }


    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right= new TreeNode(5);
        root.right = new TreeNode(3);
        List<String> res = new ArrayList<>();
        Paths(root,res,"");
        System.out.println(res);
    }

}
