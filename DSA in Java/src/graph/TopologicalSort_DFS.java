package graph;

import java.util.Stack;

public class TopologicalSort_DFS {
    public static void dfs(int node,int[][] graph,int[] vis,Stack<Integer> st){
        vis[node] = 1;
        for(int i=0;i<graph[node].length;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,st);
            }
        }
        st.add(node);
    }

    public static void main(String[] args) {

        int[][] graph={{1},{0}};
        int v=2;
        int[] vis= new int [v];
        for(int i=0;i<v;i++){
            vis[i] = 0;
        }
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++){
            if(vis[i] == 0){
                dfs(i,graph,vis,st);
            }
        }
        int[] res =new int[v];
        for(int i=0;i<v;i++){
            res[i] = st.pop();
        }
        for(int i=0;i<v;i++){
            System.out.println(res[i]);
        }
    }
}
