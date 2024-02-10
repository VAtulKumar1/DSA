/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Pair{
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode _node,int _row,int _col){
            node = _node;
            row = _row;
            col = _col;

        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0,0));
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.peek().node;
                int row = q.peek().row;
                int col = q.peek().col;
                q.poll();
                if(!map.containsKey(row)) {
                    map.put(row,new TreeMap<>());
                }
                if(!map.get(row).containsKey(col)){
                    map.get(row).put(col,new PriorityQueue<>());
                }
                map.get(row).get(col).offer(node.val);


                if(node.left!=null)
                    q.add(new Pair(node.left,row-1,col+1));
                if(node.right!=null)
                    q.add(new Pair(node.right,row+1,col+1));

            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> tmap:map.values()){
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq:tmap.values()){
                while(!pq.isEmpty()){
                    res.get(res.size()-1).add(pq.poll());
                }
            }
        }


        return res;
    }
}