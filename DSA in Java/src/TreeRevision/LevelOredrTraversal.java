package TreeRevision;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOredrTraversal {

    public static void bfs(Node root){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.key+"->");
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }

        }
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        bfs(root);
    }
}
