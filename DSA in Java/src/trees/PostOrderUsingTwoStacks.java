package trees;

import java.util.Stack;

public class PostOrderUsingTwoStacks {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static void postOrder(Node root,Stack<Integer> res){
        Node node = root;
        Stack<Node> st= new Stack<>();
        st.add(node);

        while(!st.isEmpty()){
            Node currNode = st.pop();
            res.add(currNode.data);
            if(currNode.left != null){
                st.add(currNode.left);
            }
            if(currNode.right!=null){
                st.add(currNode.right);
            }
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);
        root.right.left.right.right = new Node(8);
        Stack<Integer> res = new Stack<>();
        postOrder(root,res);
        while(!res.isEmpty()){
            System.out.print(res.pop()+" ");
        }

    }
}
