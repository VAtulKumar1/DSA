package TreeRevision;

public class BalancedBinaryTree {

    public static int height(Node root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return 1+Math.max(lh,rh);
    }

    public static boolean isBalanced(Node root){
        if(root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        System.out.println("lh "+lh);
        System.out.println("rh "+rh);

        return Math.abs(lh-rh)<=1;
    }


    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(6);
        node.right = new Node(8);
        node.right.left = new Node(10);
        node.right.right = new Node(11);
        node.right.right.right = new Node(11);
        System.out.println(isBalanced(node));
    }
}
