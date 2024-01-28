class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            indegree[i]=0;
        }
        for(int i=0;i<numCourses;i++){
            List<Integer> padosi=graph.get(i);
            for(int val:padosi){
                indegree[val]++;
            }

        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] count=new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count[index++]=node;
            List<Integer> children=graph.get(node);
            for(int i=0;i<children.size();i++){
                indegree[children.get(i)]--;
                if(indegree[children.get(i)]==0){
                    q.add(children.get(i));
                }
            }

        }
        if(index!=numCourses){
            return new int[]{};
        }
        return count;
    }
}