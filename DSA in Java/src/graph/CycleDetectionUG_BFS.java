package graph;

import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionUG_BFS {
    public static class Pair{
        int node;
        int parentNode;
        Pair(int _node,int _parentNode){
            node = _node;
            parentNode = _parentNode;
        }
    }
    public static boolean bfs(int src,int[][]graph,int[] vis){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,-1));
        vis[src] = 1;
        int count = 0;
        while(!q.isEmpty()){
            int node = q.peek().node;
            int parentNode = q.peek().parentNode;
            q.poll();

            for(int i =0;i<graph[node].length;i++){
                int currNode = graph[node][i];
                if(parentNode!=currNode && vis[currNode] == 1){
                    System.out.println(count);
                    return true;
                }
                if(vis[currNode]==0){
                    q.add(new Pair(currNode,node));
                    vis[currNode]= 1;
                }

            }
            count++;
        }





        return false;
    }


    public static void main(String[] args){
        int[][] graph={
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };

        int V = graph.length;
        int[] vis=new int[V];
        for(int i=0;i<V;i++){
            vis[i] = 0;
        }
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                boolean res = bfs(i,graph,vis);
                if(res==true){
                    System.out.println("true");
                }
            }
        }
    }
}
