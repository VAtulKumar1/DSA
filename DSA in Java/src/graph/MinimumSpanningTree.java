package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// A tree which has N nodes and N-1 egdes and every node is reachable from every other node.
// maintain mst array , vis and sum
// mark node visited while poping
// if its not visited update in mst , update sum
public class MinimumSpanningTree {

    static  class Pair{
        int w;
        int u;
        Pair(int w,int u){
            this.u=u;
            this.w=w;
        }
    }
    public static int primsAlgo(List<List<Pair>> graph,int[] vis,int v){
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)-> x.w-y.w);
        pq.add(new Pair(0,0));
        int sum =0;

        while(!pq.isEmpty()){
            int node = pq.peek().u;
            int w = pq.peek().w;
            pq.poll();
            if(vis[node] == 0){
                sum +=w;
                vis[node] = 1;
                for(int i=0;i<graph.get(node).size();i++){
                    int currNode = graph.get(node).get(i).u;
                    int wt = graph.get(node).get(i).w;
                    if(vis[currNode]==0){
                        pq.add(new Pair(wt,currNode));
                    }

                }

            }

        }






        return sum;
    }

    public static void main(String[] args) {
        int v=6;
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair(2,1));
        graph.get(0).add(new Pair(1,2));
        graph.get(1).add(new Pair(2,0));
        graph.get(1).add(new Pair(1,2));
        graph.get(2).add(new Pair(1,0));
        graph.get(2).add(new Pair(1,1));
        graph.get(2).add(new Pair(2,4));
        graph.get(2).add(new Pair(2,3));
        graph.get(3).add(new Pair(2,2));
        graph.get(3).add(new Pair(1,4));
        graph.get(4).add(new Pair(1,3));
        graph.get(4).add(new Pair(2,2));
        int[] vis=new int[v];
        Arrays.fill(vis,0);
        int res = primsAlgo(graph,vis,v);
        System.out.println(res);
    }
}
