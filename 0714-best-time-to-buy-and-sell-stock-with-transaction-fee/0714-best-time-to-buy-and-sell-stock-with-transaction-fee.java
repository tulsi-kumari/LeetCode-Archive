class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[] fwd=new int[2];
        int[] curr=new int[2];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    curr[buy]= Math.max(-prices[i]-fee+fwd[0],fwd[1]);
                 }else{
                    curr[buy]=Math.max(prices[i]+fwd[1],fwd[0]);
                }
        
            }
            fwd=curr;
        }
        return fwd[1];
//         int[][] dp=new int[n+1][2];
//         for(int i=n-1;i>=0;i--){
//             for(int buy=0;buy<=1;buy++){
//                 if(buy==1){
//                     dp[i][buy]= Math.max(-prices[i]-fee+dp[i+1][0],dp[i+1][1]);
//                  }else{
//                     dp[i][buy]=Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
//                 }
        
//             }
//         }
//         return dp[0][1];
        
    }
//     public int help(int[] prices, int fee,int idx,int buy,int[][] dp){
//      if(idx==prices.length){
//          return 0;
//      }
//     if(dp[idx][buy]!=-1){
//         return dp[idx][buy];
//     }
//     if(buy==1){
//         return dp[idx][buy]= Math.max(-prices[idx]-fee+help(prices,fee,idx+1,0,dp),
//                         0+help(prices,fee,idx+1,1,dp));
//     }
        
//         return dp[idx][buy]=Math.max(+prices[idx]+help(prices,fee,idx+1,1,dp),
//                         0+help(prices,fee,idx+1,0,dp));
    
//     }
   
}