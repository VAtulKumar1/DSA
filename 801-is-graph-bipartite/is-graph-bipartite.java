class Solution {


    public boolean dfs(int src,int[][] graph,int[] vis,int color){
        vis[src] = color;
        for(int i=0;i<graph[src].length;i++){
            int node=graph[src][i];
            if(vis[node]==-1){
                if(dfs(node,graph,vis,1-color)==false) return false;
            }
            else if(vis[node] == color){
                return false;
            }

        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
         
        int v = graph.length;
        int[] vis =new int[v];
        for(int i=0;i<v;i++){
            vis[i] = -1;
        }
        for(int i=0;i<v;i++){
            if(vis[i] == -1){
                boolean res=dfs(i,graph,vis,0);
                if(res==false){
                    return false;                
                }
                
            }
        }

        return true;
    }
}