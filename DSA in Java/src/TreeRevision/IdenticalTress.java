package TreeRevision;

public class IdenticalTress {

    public static boolean isIdentical(Node root1,Node root2){

        if(root1==null && root2 == null) return true;

        if(root1!=null && root2!=null){
            return root1.key == root2.key &&
                    isIdentical(root1.left,root2.left) &&
                    isIdentical(root1.right,root2.right);
        }

        return false;

    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(6);
        node.right = new Node(8);
        node.right.left = new Node(10);
        node.right.right = new Node(11);
        Node root = new Node(5);
        root.left = new Node(6);
        root.right = new Node(8);
        root.right.left = new Node(10);
        root.right.right = new Node(11);
        System.out.println(isIdentical(node,root));
    }
}
