class Solution {
    int mod=1000000007;
    Integer[][][] dp;
    public int checkRecord(int n) {
        dp=new Integer[n+1][3][4];
        return solve(n,0,0);
    }
    public int solve(int n,int tot_abs,int cons_late)
    {
        if(tot_abs>=2 || cons_late>=3) return 0;
        
        if(n==0) return 1;
        
        if(dp[n][tot_abs][cons_late]!=null) return dp[n][tot_abs][cons_late];
        int cnt=0;
        cnt=(cnt%mod+solve(n-1,tot_abs,0)%mod)%mod;//p
        cnt=(cnt%mod+solve(n-1,tot_abs+1,0)%mod)%mod;//a
        cnt=(cnt%mod+solve(n-1,tot_abs,cons_late+1)%mod)%mod;//l
            return dp[n][tot_abs][cons_late]= cnt%mod; 
    }
}