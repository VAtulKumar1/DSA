package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderStack {


    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;

        }
    }

    public static void postOrder(Node root, List<Integer> res){
        Stack<Node> st = new Stack<>();
        Node curr = root;
        Node temp = null;
        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.add(curr);
                curr = curr.left;

            }else{
                temp = st.peek().right;
                if(temp==null){
                    temp = st.peek();
                    res.add(temp.data);
                    st.pop();
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        res.add(temp.data);
                    }
                }
                else{
                    curr = temp;
                }
            }
        }

    }

    public static void main(String[] args){
        Node root= new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(5);
        root.left.left.right.right.right = new Node(6);
        root.right.left = new Node(8);
        List<Integer> res= new ArrayList<>();
        postOrder(root,res);
        System.out.print(res);

    }





}
