class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        
        if(obstacleGrid[n-1][m-1]==1){
            return 0;
        }
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        
        if(n==1||m==1){
            if(n==1){
                for(int i=0;i<m;i++){
                    if(obstacleGrid[0][i]==1){
                        return 0;
                    }
                }
                return 1;
            }else{
                for(int i=0;i<n;i++){
                    if(obstacleGrid[i][0]==1){
                        return 0;
                    }
                }
                return 1;
            }
        }
        
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=-1;}
        }}
        
        for(int i=0;i<n;i++){
            if(obstacleGrid[i][0]==1){
                dp[i][0]=-1;
                i=n;
            }else{dp[i][0]=1;}
        }
        
        for(int i=0;i<m;i++){
            if(obstacleGrid[0][i]==1){
                dp[0][i]=-1;
                i=m;
            }else{dp[0][i]=1;}
            
            
        }
        
        
        for(int[] arr:dp){
            System.out.println(Arrays.toString(arr));
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                
                if(dp[i][j]!=-1){
                 
                if(dp[i-1][j]==-1&&dp[i][j-1]==-1){
                    dp[i][j]=0;
                }else if(dp[i-1][j]!=-1&&dp[i][j-1]!=-1){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }else if(dp[i][j-1]==-1){
                     dp[i][j]=dp[i-1][j];
                }else if(dp[i-1][j]==-1){
                     dp[i][j]=dp[i][j-1];
                }else{
                    dp[i][j]=0;
                }
                }
            }}
        
        for(int[] arr:dp){
            System.out.println(Arrays.toString(arr));
        }
        
        return dp[n-1][m-1];
        
    }
}