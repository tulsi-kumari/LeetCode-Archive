class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        dp[s1.length()][s2.length()]=0;
        for(int i=s1.length()-1;i>=0;i--){
            dp[i][s2.length()]=s1.charAt(i)+dp[i+1][s2.length()];
        }
        for(int j=s2.length()-1;j>=0;j--){
            dp[s1.length()][j]=s2.charAt(j)+dp[s1.length()][j+1];
        }
        for(int i=s1.length()-1;i>=0;i--){
            for(int j=s2.length()-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=dp[i+1][j+1];
                }else{
                    dp[i][j]=Math.min(s1.charAt(i)+dp[i+1][j],s2.charAt(j)+dp[i][j+1]);
                }
            }
        }
        
        return dp[0][0];
    }
}