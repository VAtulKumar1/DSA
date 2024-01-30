package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgorithmsBFS {


    public static void main(String[] args) {
        int[][] graph={{},{4},{1},{2},{0}, {0,3}};
        int v=6;
        int[] indegree=new int[v];
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                indegree[graph[i][j]]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            res.add(node);
            q.poll();
            for(int i=0;i<graph[node].length;i++){
                int currNode = graph[node][i];
                indegree[currNode]--;
                if(indegree[currNode]==0){
                    q.add(currNode);
                }
            }
        }

        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }

    }
}
