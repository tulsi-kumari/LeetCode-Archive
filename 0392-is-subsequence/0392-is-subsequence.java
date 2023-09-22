class Solution {
    Boolean[][] dp;
    public boolean isSubsequence(String s, String t) {
        dp=new Boolean[s.length()+1][t.length()+1];
        return solve(0,0,s,t);
    }
    public boolean solve(int i,int j,String s,String t)
    {
        if(i>=s.length())
        {
            return true;
        }
        if(j>=t.length())
        {
            return false;
        }
        if(dp[i][j]!=null)
        {
            return dp[i][j];
        }
        boolean ret=false;
        if(s.charAt(i)==t.charAt(j))
        {
            ret=solve(i+1,j+1,s,t);
        }else
        {
            ret=solve(i,j+1,s,t);
        }
        
        return dp[i][j]=ret;
    }
}