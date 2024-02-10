package trees;

import java.util.*;

public class TopViewBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left=null;
        TreeNode right=null;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair{
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode _node,int _row,int _col){
            node = _node;
            row = _row;
            col = _col;

        }
    }



    public static List<Integer> topView(TreeNode root){
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(root,0,0));
        TreeMap<Integer,TreeMap<Integer,Stack<Integer>>> map=new TreeMap<>();
        int level =0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.peek().node;
                int row = q.peek().row;
                int col = q.peek().col;
                q.poll();
                if(!map.containsKey(col)) {
                   map.put(col,new TreeMap<>());
                }
                if(!map.get(col).containsKey(row))
                    map.get(col).put(row,new Stack<>());
                map.get(col).get(row).add(node.val);

                if(node.left!=null)
                    q.add(new Pair(node.left,row-1,col+1));
                if(node.right!=null)
                    q.add(new Pair(node.right,row+1,col+1));

            }
        }

        List<Integer> res = new ArrayList<>();
        for(TreeMap<Integer,Stack<Integer>> key:map.values()){
            for(Integer k:key.keySet()){
                Stack<Integer> s=key.get(k);
                if(k==level-1){

                    while(!s.isEmpty()){
                        res.add(s.pop());
                    }
                }else{
                    res.add(s.pop());
                }
            }

        }

        return res;


    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(11);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(16);
        System.out.println(topView(root));
    }

}
