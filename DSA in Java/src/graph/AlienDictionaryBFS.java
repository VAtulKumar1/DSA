package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionaryBFS {


    public static void main(String[] args) {
        int n = 5;
        int k = 4;
        String[] dict = {"baa","abcd","abca","cab","cad"};
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<k;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
           String s1=dict[i];
           String s2=dict[i+1];
           int len=Math.min(s1.length(),s2.length());
           for(int j=0;j<len;j++){
               if(s1.charAt(j)!=s2.charAt(j)){
                   graph.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                   break;
               }
           }
        }
        int[] indegree=new int[k];
        for(int i=0;i<graph.size();i++){
            List<Integer> childs= graph.get(i);
            for(int j=0;j<childs.size();j++){
                indegree[childs.get(j)]++;
            }

        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] res=new int[k];
        int ind=0;
        while(!q.isEmpty()){
            int node = q.poll();
            res[ind++]=node;
            List<Integer> childs=graph.get(node);
            for(int i=0;i<childs.size();i++){
                indegree[childs.get(i)]--;
                if(indegree[childs.get(i)]==0){
                    q.add(childs.get(i));
                }
            }
        }


        for(int i=0;i<k;i++){
            System.out.println((char)('a'+res[i]));
        }

    }
}
