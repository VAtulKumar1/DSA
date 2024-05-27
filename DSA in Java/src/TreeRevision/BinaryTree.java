package TreeRevision;

public class BinaryTree {
    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(6);
        node.right = new Node(8);
        node.right.left = new Node(10);
        node.right.right = new Node(11);


    }
}
