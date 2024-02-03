package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterartivePreorderUsingStack {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static void preOrderStack(Stack<Node> st, List<Integer> res){
        while(!st.isEmpty()){
            Node node = st.pop();
            res.add(node.data);
            if(node.right !=null) st.add(node.right);
            if(node.left !=null) st.add(node.left);

        }
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Stack<Node> st = new Stack<>();
        st.add(root);
        List<Integer> res = new ArrayList<>();
        preOrderStack(st,res);
        System.out.println(res);
    }
}
