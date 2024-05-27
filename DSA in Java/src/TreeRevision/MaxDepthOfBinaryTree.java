package TreeRevision;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTree {
    public static int depthRecursive(Node root){
        if(root == null) return 0;
        int lh = depthRecursive(root.left);
        int rh = depthRecursive(root.right);
        return 1+Math.max(lh,rh);

    }

    public static int levelOrderDepth(Node root){
        if(root==null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int height = 0;
        while(!q.isEmpty()){
            int size = q.size();
            height++;
            for(int i=0;i<size;i++){
                Node node = q.poll();
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }



        }

        return height;

    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(6);
        node.right = new Node(8);
        node.right.left = new Node(10);
        node.right.right = new Node(11);
        System.out.println(depthRecursive(node));
        System.out.println(levelOrderDepth(node));
    }
}
