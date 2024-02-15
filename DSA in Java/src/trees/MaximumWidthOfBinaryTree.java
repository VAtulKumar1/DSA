package trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class Pair{

        TreeNode node;
        int index;

        Pair(TreeNode _node,int _index){
            index = _index;
            node = _node;

        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
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

    public static void main(String[] args) {

        TreeNode root=new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(widthOfBinaryTree(root));


    }
}
