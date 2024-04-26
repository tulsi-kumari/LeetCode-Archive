class Solution {
    Integer[][] dp;
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new Integer[n+1][m+1];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
        {
            min=Math.min(min,grid[0][i]+solve(1,i,grid,m,n));
        }
        return min;
    }
    public int solve(int row,int prevcol,int[][] grid,int m,int n)
    {
        if(row>=n)
        {
            return 0;
        }
        if(dp[row][prevcol]!=null) return dp[row][prevcol];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
        {
            if(i!=prevcol)
            {
                min=Math.min(min,grid[row][i]+solve(row+1,i,grid,m,n));
            }
        }
        return dp[row][prevcol]= min;
    }
}