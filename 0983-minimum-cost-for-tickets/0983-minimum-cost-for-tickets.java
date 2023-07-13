class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Integer[] dp=new Integer[days.length];
        return solve(0,costs,days,dp);
    }
    public int solve(int i,int[] costs,int[] days,Integer[] dp){
        
        
        if(i>=days.length){
          return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        
        
        int f=costs[0]+solve(i+1,costs,days,dp);
        
        
        
        int j=i+1;
        while(j<days.length && days[j]<days[i]+7){
            j++;
        }
        int s=costs[1]+solve(j,costs,days,dp);
        
        
        
        j=i+1;
        while(j<days.length && days[j]<days[i]+30){
           j++;
        }
        int t=costs[2]+solve(j,costs,days,dp);
        
        
        return dp[i]=Math.min(f,Math.min(s,t));
    }
}