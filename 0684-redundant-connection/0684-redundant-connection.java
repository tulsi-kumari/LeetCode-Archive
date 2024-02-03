class Solution {
    int[] par;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        rank=new int[edges.length];
        par=new int[edges.length];
        for(int i=0;i<edges.length;i++)
        {
            rank[i]=1;
            par[i]=i;
        }
        for(int[] edge:edges)
        {
            int u=edge[0]-1;
            int v=edge[1]-1;
            
            if(findpar(u)==findpar(v))
            {
                return edge;
            }else
            {
                union(u,v);
            }
        }
        return new int[]{0,0};
    }
    public int findpar(int v)
    {
        if(par[v]==v) return v;
        par[v]=findpar(par[v]);
        return par[v];
    }
    
    public void union(int u,int v)
    {
        int paru=findpar(u);
        int parv=findpar(v);
        if(rank[paru]==rank[parv])
        {
            par[paru]=parv;
            rank[parv]++;
        }else if(rank[paru]<rank[parv])
        {
            par[paru]=parv;
        }else
        {
            par[parv]=paru;
        }
    }
}