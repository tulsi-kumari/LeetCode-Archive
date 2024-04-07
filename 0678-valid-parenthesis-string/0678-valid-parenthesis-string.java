class Solution {
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        dp=new Boolean[s.length()+1][s.length()+1];
         return solve(0,s,0);
    }
    public boolean solve(int i,String s,int cnt)
    {
        if(i>=s.length()) return cnt==0;
        if(dp[i][cnt]!=null) return dp[i][cnt];
        char ch=s.charAt(i);
        if(ch=='*')
        {
            boolean isValid=false;
            isValid|=solve(i+1,s,cnt);
            isValid|=solve(i+1,s,cnt+1);
            if(cnt>0)
            {
                isValid|=solve(i+1,s,cnt-1);
            }
            return dp[i][cnt]=isValid;
            
        }else if(ch=='(' )
        {
            return dp[i][cnt]= solve(i+1,s,cnt+1);
            
        }else if(cnt>0)
        {
            return dp[i][cnt]= solve(i+1,s,cnt-1);
        }
        return dp[i][cnt]= false;
    }
}