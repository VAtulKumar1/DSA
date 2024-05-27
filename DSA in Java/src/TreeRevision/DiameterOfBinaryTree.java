package TreeRevision;

public class DiameterOfBinaryTree {

    public static int diameter(Node root,int[] dia){

        if(root == null) return 0;
        int lh = diameter(root.left,dia);
        int rh = diameter(root.right,dia);
        dia[0] = Math.max(dia[0],1+lh+rh);

        return 1+Math.max(lh,rh);
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(6);
        node.right = new Node(8);
        node.right.left = new Node(10);
        node.right.right = new Node(11);
        node.right.right.right = new Node(11);
        node.right.right.right.right = new Node(11);
        int[] dia = {0};
        diameter(node,dia);
        System.out.println(dia[0]);
    }
}
