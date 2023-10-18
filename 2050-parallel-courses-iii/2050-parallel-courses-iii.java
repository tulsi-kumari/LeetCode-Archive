class Solution {
    Integer[] dp;
    int max;
    public int minimumTime(int n, int[][] relations, int[] time) {
        dp=new Integer[n];
        max=Integer.MIN_VALUE;
        int[] indegree=new int[n];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge:relations)
        {
            adj.get(edge[0]-1).add(edge[1]-1);
            indegree[edge[1]-1]++;
        }
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                max=Math.max(max,dfs(i,adj,time));
            }
        }
        return max;
        
    }
    public int dfs(int i,ArrayList<ArrayList<Integer>> adj,int[] time)
    {
        if(dp[i]!=null)
        {
            return dp[i];
        }
        int t=time[i];
        int currmax=Integer.MIN_VALUE;
        for(int nbrs:adj.get(i))
        {
            currmax=Math.max(currmax,dfs(nbrs,adj,time));
        }
        if(currmax==Integer.MIN_VALUE)
        {
            return dp[i]= t;
        }
        return dp[i]= t+currmax;
    }
}