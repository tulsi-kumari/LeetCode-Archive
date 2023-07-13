class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
      int[] indegree=new int[numCourses];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] t:pre){
            int u=t[1];
            int v=t[0];
            adj.get(u).add(v);
            indegree[v]++;
        }
    
        boolean[] visited=new boolean[numCourses];
        int totalVis=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
          if(indegree[i]==0){
              q.offer(i);
          }
        }
        
        if(q.size()==0){
            return false;
        }
        
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int x=q.poll();
                if(visited[x]) continue;
                visited[x]=true;
                totalVis++;
                ArrayList<Integer> arr=adj.get(x);
                for(int i=0;i<arr.size();i++){
                   indegree[arr.get(i)]--;
                    if(indegree[arr.get(i)]==0){
                        q.offer(arr.get(i));
                    }
                }
            }
        }
        if(totalVis==numCourses){
           return true;
        }
        return false;
    }
}