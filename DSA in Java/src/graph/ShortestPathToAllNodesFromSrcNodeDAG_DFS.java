package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathToAllNodesFromSrcNodeDAG_DFS {

    static class Pair{
        int node;
        int weight;
        Pair(int _node,int _weight){
            node = _node;
            weight = _weight;
        }
    }
    public static void dfs(int src,List<List<Pair>> graph,int[] vis,Stack<Integer> st){
        vis[src]=1;
        for(int i=0;i<graph.get(src).size();i++){
            if(vis[graph.get(src).get(i).node]==0){
                dfs(graph.get(src).get(i).node,graph,vis,st);
            }
        }
        st.add(src);
    }

    public static void main(String[] args) {
        int v=7;
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Pair(1,2));
        graph.get(1).add(new Pair(3,1));
        graph.get(2).add(new Pair(3,3));
        graph.get(4).add(new Pair(0,3));
        graph.get(4).add(new Pair(2,1));
        graph.get(5).add(new Pair(4,1));
        graph.get(6).add(new Pair(4,2));
        graph.get(6).add(new Pair(5,3));


        int[] vis=new int[v];
        Arrays.fill(vis,0);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++){
            if(vis[i] == 0){
                dfs(i,graph,vis,st);
            }
        }

        int[] dist=new int[v];
        Arrays.fill(dist, (int) 1e9);
        dist[2]=0;

        while(!st.isEmpty()){
            int node = st.pop();
            int disNode = dist[node];
            for(int j=0;j<graph.get(node).size();j++){
                int node1 = graph.get(node).get(j).node;
                int weight = graph.get(node).get(j).weight;



                if(weight+disNode<dist[node1]){
                    dist[node1] = weight+disNode;
                }
            }

        }
        for(int i=0;i<v;i++){
            if(dist[i]==1e9) dist[i]=-1;
        }

        for(int i=0;i<v;i++){
            System.out.print(dist[i]+" ");
        }




    }
}
