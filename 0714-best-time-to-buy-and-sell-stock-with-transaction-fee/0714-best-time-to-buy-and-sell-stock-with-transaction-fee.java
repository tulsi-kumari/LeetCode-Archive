class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return help(prices,fee,0,1,dp);
        
    }
    public int help(int[] prices, int fee,int idx,int buy,int[][] dp){
     if(idx==prices.length){
         return 0;
     }
    if(dp[idx][buy]!=-1){
        return dp[idx][buy];
    }
    if(buy==1){
        return dp[idx][buy]= Math.max(-prices[idx]-fee+help(prices,fee,idx+1,0,dp),
                        0+help(prices,fee,idx+1,1,dp));
    }
        
        return dp[idx][buy]=Math.max(+prices[idx]+help(prices,fee,idx+1,1,dp),
                        0+help(prices,fee,idx+1,0,dp));
    
    }
   
}