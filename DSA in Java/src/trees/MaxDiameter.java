package trees;

public class MaxDiameter {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static int maxDiameter = 0;
    public static int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int lh = maxDepth(node.left);
        int rh = maxDepth(node.right);
        if(maxDiameter<(lh+rh)) maxDiameter = lh+rh;
        return 1+Math.max(lh,rh);

    }
    public static int diameterOfBinaryTree(TreeNode root) {

        maxDepth(root);
        return maxDiameter;

    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));

    }
}
