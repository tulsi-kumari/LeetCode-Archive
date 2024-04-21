class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        boolean[] visited=new boolean[n];
        visited[source]=true;
        while(!q.isEmpty())
        {
            int poll=q.poll();
            List<Integer> nbr=adj.get(poll);
            for(int i=0;i<nbr.size();i++)
            {
                if(!visited[nbr.get(i)])
                {
                    visited[nbr.get(i)]=true;
                    q.offer(nbr.get(i));
                }
            }
        }
        
        return visited[destination];
    }
}