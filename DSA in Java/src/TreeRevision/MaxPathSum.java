package TreeRevision;

public class MaxPathSum {

    public static int sum(Node root){
        if(root == null) return 0;
        int ls = sum(root.left);
        int rs = sum(root.right);
        return root.key+Math.max(ls,rs);
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(50);
        node.right = new Node(8);
        node.right.left = new Node(10);
        node.right.right = new Node(11);
        System.out.println(sum(node));
    }
}
