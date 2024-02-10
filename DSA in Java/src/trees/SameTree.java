package trees;

public class SameTree {


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


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if((p==null && q!=null)
        ||(p!=null && q==null)) return false;
        if(p.val!=q.val ) return false;
        boolean l=isSameTree(p.left,q.left);
        boolean r=isSameTree(p.right,q.right);
        if(l==false || r==false) return false;
        return true;
    }


    public static void main(String[] args) {
        TreeNode p=new TreeNode(1);
        p.left = new TreeNode(2);
        TreeNode q=new TreeNode(1);
        q.right = new TreeNode(2);
        System.out.println(isSameTree(p,q));
    }

}
