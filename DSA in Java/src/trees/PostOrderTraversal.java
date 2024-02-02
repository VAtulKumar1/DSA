package trees;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int _data){
            this.data = _data;
        }
    }

    public static void postOrderTraversal(Node root, List<Integer> list){
        if(root == null){
            return;
        }

        postOrderTraversal(root.left,list);
        postOrderTraversal(root.right,list);
        list.add(root.data);
    }


    public static void main(String[] args) {
        Node root=new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(6);
        root.left.right = new Node(11);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(12);
        root.right.left = new Node(4);
        root.right.left.left = new Node(13);
        root.right.right= new Node(5);
        List<Integer> res = new ArrayList<>();
        postOrderTraversal(root,res);
        for(int val: res){
            System.out.print(val+" ");
        }

    }
}
