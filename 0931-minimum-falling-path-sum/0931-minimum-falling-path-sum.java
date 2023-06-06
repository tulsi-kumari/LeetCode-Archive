class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return matrix[0][0];
        }
        int[][] dp=new int[n][n];
        
        for(int i=0;i<n;i++){
            dp[n-1][i]=matrix[n-1][i];
        }
        
        int min=Integer.MAX_VALUE;
        
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0&&j==n-1){
                    dp[i][j]=matrix[i][j]+dp[i+1][j];
                }else if(j==0 ){
                  dp[i][j]=matrix[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);
                }else if(j==n-1){
                    dp[i][j]=matrix[i][j]+Math.min(dp[i+1][j],dp[i+1][j-1]);
                }else{
                    int x=Math.min(dp[i+1][j],dp[i+1][j+1]);
                    x=Math.min(x,dp[i+1][j-1]);
                    dp[i][j]=matrix[i][j]+x;
                }
                
                if(i==0){
                 min=Math.min(min,dp[i][j]);
                }
                
            }
        }
        
        return min;
    }
}