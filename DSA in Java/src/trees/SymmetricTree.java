package trees;

public class SymmetricTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private static boolean check(TreeNode l,TreeNode r){
        if(l==null || r==null){
            return l==r;
        }
        boolean ls=check(l.left,r.right);
        if(l.val!=r.val) return false;
        boolean rs=check(l.right,r.left);
        return ls&rs;
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return check(root.left,root.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        System.out.println(isSymmetric(root));


    }
}
