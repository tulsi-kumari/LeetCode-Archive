class Solution {
    
    public int minDistance(String word1, String word2) {
        Integer[][] dp=new Integer[word1.length()][word2.length()];
        return solve(0,0,word1,word2,dp);
    }
    public int solve(int i,int j,String str1,String str2,Integer[][] dp)
    {
        if(i>=str1.length() && j>=str2.length())
        {
            return 0;
        }
        if(i>=str1.length())
        {
            return str2.length()-j;
        }
        if(j>=str2.length())
        {
            return str1.length()-i;
        }
        if(dp[i][j]!=null)
        {
            return dp[i][j];
        }
        char ch1=str1.charAt(i);
        char ch2=str2.charAt(j);
        if(ch1==ch2)
        {
            return solve(i+1,j+1,str1,str2,dp);
        }
            int del=1+solve(i+1,j,str1,str2,dp);
            int ins=1+solve(i,j+1,str1,str2,dp);
            int rep=1+solve(i+1,j+1,str1,str2,dp);
            return dp[i][j]= Math.min(del,Math.min(ins,rep));
        
    }
}