package graph;

// to find the shortest path where weights can be negative
// detect negative cycles
// run exactly n-1 iteration
//relax edge weights in n-1 iterations

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordDG {

    static class Pair{
        int src;
        int node;
        int wt;

        Pair(int _src,int _node,int _wt){
            src = _src;
            node = _node;
            wt = _wt;
        }

    }
    public static void main(String[] args) {
        int v =6;
        List<Pair> graph=new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new Pair(3,4,-2));
            graph.add(new Pair(3,2,6));
            graph.add(new Pair(2,4,3));
            graph.add(new Pair(5,3,1));
            graph.add(new Pair(1,2,-2));
            graph.add(new Pair(1,5,-3));
            graph.add(new Pair(0,1,5));
        }




        int[] dist=new int[v];
        Arrays.fill(dist,(int) 1e9);
        dist[0] = 0;

        for(int i=0;i<v-1;i++){
            for(Pair pair:graph){
                int src = pair.src;
                int node = pair.node;
                int wt = pair.wt;

                if(dist[src]!=1e9 && dist[src]+wt<dist[node]){
                    dist[node] = dist[src]+wt;
                }


            }
        }

        for(Pair pair:graph){
            int u=pair.src;
            int v1=pair.node;
            int wt=pair.wt;
            if(dist[u]!=1e9 && dist[u]+wt<dist[v1]){
                System.out.println(-1);
                break;
            }

        }

        System.out.println(Arrays.toString(dist));

    }
}
