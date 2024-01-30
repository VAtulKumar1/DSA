package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUG_BFS {

    static class Pair{
        int node;
        int w;

        Pair(int _node,int _w){
            node = _node;
            w = _w;
        }
    }
    public static void main(String[] args) {
        int[][] graph={{1,3},{0,2,3},
                {1,6},{0,1,4},{3,5},
                {4,6},{2,5,7,8},{6,8},{7,6}
        };
        int v = 9;
        int[] dis=new int[v];
        Arrays.fill(dis, (int) 1e9);
        dis[0] = 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            int node = q.peek().node;
            int w = q.peek().w;
            q.poll();

            for(int i=0;i<graph[node].length;i++){
                int currNode = graph[node][i];
                int currW = dis[currNode];

                if(w+1<currW){
                    dis[currNode] = w+1;
                    q.add(new Pair(currNode,w+1));

                }
            }


        }

        for(int i=0;i<v;i++){
            if(dis[i]==1e9) dis[i] = -1;
        }

        for(int i=0;i<v;i++){
            System.out.print(dis[i]+" ");
        }


    }
}
