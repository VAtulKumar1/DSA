package trees;

import java.util.*;

public class AllTheNodesAtDistnaceKFromTarget {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode tr=null;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.peek();
                if(node.val==target.val) tr=node;
                q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    map.put(node.left, node);
                }
                if (node.right != null) {
                    q.add(node.right);
                    map.put(node.right, node);
                }
            }
        }



        Queue<TreeNode> q1 = new LinkedList<>();
        q.add(tr);
        int level = 0;
        List<Integer> vis=new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                vis.add(node.val);
                if(level == k && node.val!=target.val){
                    res.add(node.val);
                }
                if (node.left != null && !vis.contains(node.left.val)) q.add(node.left);
                if (node.right != null && !vis.contains(node.right.val)) q.add(node.right);
                if (map.containsKey(node) && !vis.contains(map.get(node).val)) {
                    q.add(map.get(node));
                }
            }
            if(level==k) return res;

            level++;

        }


        return res;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);

        TreeNode target=new TreeNode(0);

        System.out.println(distanceK(root,target,3));

    }
}
