package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderUsingStack {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static void inOrderStack(List<Integer> res,Node root){
        Stack<Node> st = new Stack<>();
        Node node = root;


        while(true){
            if(node!=null){
                st.add(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()) break;
                Node currNode = st.pop();
                res.add(currNode.data);
                node = currNode.right;
            }
        }
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        List<Integer> res = new ArrayList<>();
        inOrderStack(res,root);

        System.out.println(res);


    }
}
