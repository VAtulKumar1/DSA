package TreeRevision;

import java.util.*;

public class ZigZagTraversal {

    public static List<List<Integer>> traversal(Node root,
                                                List<List<Integer>> res){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int flag = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i =0;i<size;i++){

                Node node = q.poll();
                level.add(node.key);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            if(flag ==0) {
                res.add(level);
                flag = 1;
            }
            else{
                Collections.reverse(level);
                res.add(level);
                flag = 0;
            }



        }

        return res;
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(6);
        node.right = new Node(8);
        node.right.left = new Node(10);
        node.right.right = new Node(11);
        List<List<Integer>> res = new ArrayList<>();
        traversal(node,res);
        System.out.println(res);
    }
}
