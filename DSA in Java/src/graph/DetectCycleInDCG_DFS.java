package graph;

public class DetectCycleInDCG_DFS{

    public static boolean dfs(int src,int[][] graph,int[] vis,int[] pathVis){

        vis[src] = 1;
        pathVis[src] = 1;

        for(int i=0;i<graph[src].length;i++) {
            int node = graph[src][i];
            if (vis[node] == 1 && pathVis[node] == 1) {
                return true;
            }
            if (vis[node] == 0) {
                if(dfs(node, graph, vis, pathVis)==true) return true;
            }


        }


        pathVis[src] = 0;
        return false;
    }


    public static void main(String[] args) {
        int[][] graph={{1},{2},{3,6},{4},
                {5},{},{4},{1,8},{9},{7}
        };
        int v = graph.length;

        int[] vis =new int[v];
        int[] pathVis =new int[v];
        for(int i=0;i<v;i++){
            vis[i] = 0;
            pathVis[i] =0;
        }

        for(int i=0;i<v;i++){
            if(vis[i] == 0){
                if(dfs(i,graph,vis,pathVis)==true){
                    System.out.println(true);
                    break;
                };
            }
        }
    }
}
