class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        boolean[] prev=new boolean[n];
        prev[src]=true;
        boolean[] curr=new boolean[n];
        dist[src]=0;
        for(int i=0;i<=k;i++){
            int[] temp=Arrays.copyOf(dist,n);
            for(int[] edge:flights){
                int u=edge[0];
                int v=edge[1];
                int wt=edge[2];
                if(dist[u]!=Integer.MAX_VALUE){
                   temp[v]=Math.min(temp[v],dist[u]+wt);
                }
            }
            dist=temp;
            System.out.println(Arrays.toString(dist));
            
        }
        
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}