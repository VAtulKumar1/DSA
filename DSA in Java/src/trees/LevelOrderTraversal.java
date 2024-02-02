package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;

        }
    }

    public static void levelOrderTraversal(Queue<Node> q,List<List<Integer>> res){
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<level;i++){
                Node node = q.poll();
                subList.add(node.data);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(subList);
        }

    }


    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(6);
        root.left.right = new Node(11);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(12);
        root.right.left = new Node(4);
        root.right.left.left = new Node(13);
        root.right.right= new Node(5);

        Queue<Node> q= new LinkedList<>();
        q.add(root);
        List<List<Integer>> res = new ArrayList<>();

        levelOrderTraversal(q,res);

        System.out.println(res);
    }


}
