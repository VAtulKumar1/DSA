package TreeRevision;

public class DFS {

    public static void preOrderTraversal(Node root){
        if(root==null) return;

        System.out.print(root.key+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void postOrder(Node root){
        if(root ==  null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.key+" ");
    }

    public static void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.key+" ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(6);
        node.right = new Node(8);
        node.right.left = new Node(10);
        node.right.right = new Node(11);

        preOrderTraversal(node);
        System.out.println();
        postOrder(node);
        System.out.println();
        inOrder(node);
    }
}
