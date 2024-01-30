package graph;

public class CycleUG_DFS {

    public static boolean dfs(int src,int[][] graph,int[] vis,int parentNode){
        for(int i=0; i<graph[src].length;i++){
            int node = graph[src][i];
            if(parentNode!=node && vis[node]==1){
                return true;
            }
            if(vis[node]==0){
                vis[node] = 1;
                dfs(node,graph,vis,src);

            }
        }

        return false;
    }


    public static void main(String[] args){

        int[][] graph={
                {2, 3},
                {2},
                {1},
                {0}
        };
        int V = graph.length;
        int[] vis=new int[V];
        for(int i=0;i<V;i++){
            vis[i] = 0;
        }
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                boolean res = dfs(i,graph,vis,-1);
                if(res){
                    System.out.println("true");
                }else{
                    System.out.println(false);
                }

            }
        }

    }
}
