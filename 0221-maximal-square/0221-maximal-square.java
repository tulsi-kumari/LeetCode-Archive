class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        int max=0;
        
        for(int i=0;i<n;i++){
            dp[i][m-1]=matrix[i][m-1] -'0';
            max=Math.max(dp[i][m-1],max);
        }
        
        for(int j=0;j<m;j++){
            dp[n-1][j]=matrix[n-1][j]-'0';
            max=Math.max(dp[n-1][j],max);
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                if(matrix[i][j]!='0'){
                int x=Math.min(dp[i][j+1],dp[i+1][j]);
                x=Math.min(x,dp[i+1][j+1]);
                dp[i][j]=x+1;
                max=Math.max(dp[i][j],max);
                }
            }
        }
        for(int[] i:dp){
            System.out.println(Arrays.toString(i));
        }
        return max*max;
    }
}