package graph;

import java.util.*;

public class DikstraShortestPathBFS {
    static class Pair{
        int dist;
        int node;
        Pair(int _dist,int _node){
            dist = _dist;
            node = _node;
        }
    }

    public static void main(String[] args) {
        int v=6;
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair(4,1));
        graph.get(0).add(new Pair(4,2));
        graph.get(1).add(new Pair(4,0));
        graph.get(1).add(new Pair(2,2));
        graph.get(2).add(new Pair(4,0));
        graph.get(2).add(new Pair(2,1));
        graph.get(2).add(new Pair(3,3));
        graph.get(2).add(new Pair(6,5));
        graph.get(2).add(new Pair(1,4));
        graph.get(3).add(new Pair(2,5));
        graph.get(3).add(new Pair(3,2));
        graph.get(4).add(new Pair(3,5));
        graph.get(4).add(new Pair(1,2));
        graph.get(5).add(new Pair(6,2));
        graph.get(5).add(new Pair(2,3));
        graph.get(5).add(new Pair(3,4));




        int[] dist =new int[v];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;
        PriorityQueue<Pair> q=new PriorityQueue<>((x,y)->x.dist-y.dist);
        q.add(new Pair(0,0));

        while(!q.isEmpty()){
            int node = q.peek().node;
            int w = q.peek().dist;
            q.poll();

            for(int i=0;i<graph.get(node).size();i++){
                int currNode=graph.get(node).get(i).node;
                int currW = graph.get(node).get(i).dist;
                if(currW+w<dist[currNode]){
                    dist[currNode] = currW+w;
                    q.add(new Pair(currW+w,currNode));
                }


            }
        }

        for(int i=0;i<v;i++){
            System.out.print(dist[i]+" ");
        }


    }
}
