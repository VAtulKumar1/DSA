package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllDFSInOnGO {

    static class Pair{
        Node node;
        int order;
        Pair(Node node,int order){
            this.node = node;
            this.order = order;
        }
    }

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static void dfsAllInOne(Node root,
                                   List<Integer> preOrder,
                                   List<Integer> inOrder,
                                   List<Integer> postOrder){

        Stack<Pair> st= new Stack<Pair>();
        st.add(new Pair(root,1));
        while(!st.isEmpty()){
            Node curr = st.peek().node;
            int order = st.peek().order;
            if(order == 1){
                preOrder.add(curr.data);
                st.peek().order++;
                if(curr.left!=null){
                    st.add(new Pair(curr.left,1));
                }
            }
            else if(order==2){
                inOrder.add(curr.data);
                st.peek().order++;
                if(curr.right!=null){
                    st.add(new Pair(curr.right,1));
                }
            }
            else{
                postOrder.add(st.pop().node.data);
            }
        }

    }

    public static void main(String[] args){
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(5);
        root.left.left=new Node(3);
        root.left.left.right=new Node(4);
        root.right.left=new Node(6);
        root.right.left.right=new Node(7);
        root.right.left.right.right=new Node(8);

        List<Integer> preOrder= new ArrayList<>();
        List<Integer> inOrder= new ArrayList<>();
        List<Integer> postOrder= new ArrayList<>();
        dfsAllInOne(root,preOrder,inOrder,postOrder);
        System.out.print(preOrder+" ");
        System.out.println();
        System.out.print(inOrder+" ");
        System.out.println();
        System.out.print(postOrder+" ");
        System.out.println();

    }
}
