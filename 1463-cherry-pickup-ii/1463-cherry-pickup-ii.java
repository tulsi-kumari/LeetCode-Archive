class Solution {
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
        
        int cols=grid[0].length;
        int rows=grid.length;
        dp=new Integer[rows+1][cols+1][cols+1];
        return solve(0,0,cols-1,cols,rows,grid);
    }
    public int solve(int r,int c0,int c1,int m,int n,int[][] grid)
    {
        if(r==n-1){
            if(c0==c1) return grid[r][c0];
            else return grid[r][c0]+grid[r][c1];
        }
        if(dp[r][c0][c1]!=null) return dp[r][c0][c1];
        int ans=0;
        if(c0==c1) ans= grid[r][c0];
        else ans= grid[r][c0]+grid[r][c1];
        int[] moves={-1,0,1};
        int max=0;
        for(int k=0;k<3;k++)
        {
            int newc0=c0+moves[k];
            for(int l=0;l<3;l++)
            {
                int newc1=c1+moves[l];
                if(newc0<0||newc1<0||newc0>=m||newc1>=m)
                {
                    continue;
                }
                max=Math.max(max,solve(r+1,newc0,newc1,m,n,grid));
            }
        }
        return  dp[r][c0][c1]= ans+max;
            
    }
}