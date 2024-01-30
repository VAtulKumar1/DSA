package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteUG_BFS {



    public static boolean bfs(int src,int[][] graph,int[] vis){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        vis[src] = 1;
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            int color = vis[node];
            for(int i=0;i<graph[node].length;i++){
                int currNode = graph[node][i];
                if(color == vis[currNode]){
                    return false;
                }
                if(vis[currNode] == 0){
                    q.add(currNode);
                    if(color == 1){
                        vis[currNode] = 2;
                    }
                    else{
                        vis[currNode] = 1;
                    }

                }
            }
        }




        return true;
    }



    public static void main(String[] args){

        int[][] graph={
                {1,3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        int v = graph.length;
        int[] vis =new int[v];
        for(int i=0;i<v;i++){
            vis[i] = 0;
        }
        for(int i=0;i<v;i++){
            if(vis[i] == 0){
                boolean res=bfs(i,graph,vis);
                System.out.println(res);
            }
        }


    }
}
