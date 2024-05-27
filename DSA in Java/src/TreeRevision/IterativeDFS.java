package TreeRevision;

import java.util.Stack;

public class IterativeDFS {

    public static void preOredr(Node root){

        if(root == null) return;
        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            Node node = st.pop();
            System.out.print(node.key+"->");
            if(node.right != null){
                st.push(node.right);
            }
            if(node.left != null){
                st.push(node.left);
            }
        }
    }




    public static void  inOrder(Node root){
        if(root ==  null) return;

        Stack<Node> st = new Stack<>();
        st.push(root);
        Node temp = root;
        while(temp.left!=null){
            st.push(temp.left);
            temp = temp.left;
        }

        while(!st.isEmpty()){
            Node node = st.pop();
            System.out.print(node.key+"->");
            Node right = node.right;
            if(right!=null){
                st.push(right);
                while(right.left!=null){
                    st.push(right.left);
                    right = right.left;
                }

            }
        }



    }


    public static void postOrderUsingTwoStacks(Node root){
        if(root == null) return;

        Stack<Node> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        st1.push(root);

        while(!st1.isEmpty()){
            Node node = st1.pop();
            st2.push(node.key);
            if(node.left!=null){
                st1.push(node.left);

            }
            if(node.right!=null){
                st1.push(node.right);
            }
        }

       while(!st2.isEmpty()){
           System.out.print(st2.pop()+"->");
       }

    }


    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(6);
        node.right = new Node(8);
        node.right.left = new Node(10);
        node.right.right = new Node(11);

        preOredr(node);
        System.out.println();
        inOrder(node);
        System.out.println();
        postOrderUsingTwoStacks(node);
    }
}
