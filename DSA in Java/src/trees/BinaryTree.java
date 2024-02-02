package trees;

public class BinaryTree {

    static class Node {
        int data; // value of the node
        Node left; // reference to the left child
        Node right; // refernce to the right child

        public Node(int _data){
            this.data= _data;

        }
    }

    public static void main(String[] args) {
        Node root=new Node(5);
        root.left = new Node(6);
        root.right = new Node(7);
        root.right.left = new Node(9);

    }
}
