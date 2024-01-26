class Solution {
    int mod=1000000007;
    Integer[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new Integer[m+1][n+1][maxMove+1];
        return dfs(startRow,startColumn,maxMove,m,n);
    }
    public int dfs(int r,int c,int maxmove,int m,int n)
    {
        
        if(r<0 || r>=m || c<0 || c>=n) return 1;
        
        if(maxmove==0) return 0;
        
        if(dp[r][c][maxmove]!=null) return dp[r][c][maxmove];
        int ans=0;
        ans=(ans+dfs(r+1,c,maxmove-1,m,n))%mod;
        ans=(ans+dfs(r,c+1,maxmove-1,m,n))%mod;
        ans=(ans+dfs(r-1,c,maxmove-1,m,n))%mod;
        ans=(ans+dfs(r,c-1,maxmove-1,m,n))%mod;
        
        return dp[r][c][maxmove]= ans%mod;
    }
    
}