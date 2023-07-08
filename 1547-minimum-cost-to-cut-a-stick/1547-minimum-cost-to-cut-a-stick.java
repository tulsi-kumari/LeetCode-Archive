class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        Integer[][] dp=new Integer[cuts.length+1][cuts.length+1];
        return solve(0,cuts.length-1,cuts,0,n,dp);
    }
    public int solve(int s,int e,int[] cuts,int lo,int hi,Integer[][] dp){
        if(s>e){
            return 0;
        }
        if(lo>hi){
            return 0;
        }
        if(dp[s][e]!=null){
            return dp[s][e];
        }
       
        int min=Integer.MAX_VALUE;
        for(int i=s;i<=e;i++){
            int net=hi-lo+solve(s,i-1,cuts,lo,cuts[i],dp)+solve(i+1,e,cuts,cuts[i],hi,dp);
            min=Math.min(min,net);
            
        }
        return dp[s][e]= min;
        
    }
}