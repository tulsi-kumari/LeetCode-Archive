class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] road:roads)
        {
            int from=road[0];
            int to=road[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                int tmp = 0;
                if(adj.get(i).contains(j)) tmp--;
                tmp += adj.get(i).size() + adj.get(j).size();
                max = Math.max(tmp, max);
            }
        }
        return max;
    }
   
}