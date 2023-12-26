class Solution {
    static int mod=1000000007;
    Integer[][] dp;
    public int numRollsToTarget(int n, int k, int target) {
        dp=new Integer[n+1][target+1];
       return solve(n,k,target);
    }
    public int solve(int n,int k,int target)
    {
        if(target==0 && n==0)
        {
            return 1;
        }
        if (target < n || n * k < target) {
            return 0;
        }
        if(dp[n][target]!=null)
        {
            return dp[n][target];
        }
        int ans=0;
        for(int i=1;i<=k;i++)
        {
           if(target<i) break;
           
                ans=(ans+solve(n-1,k,target-i)%mod)%mod;
           
        }
        return dp[n][target]=ans;
    }
}