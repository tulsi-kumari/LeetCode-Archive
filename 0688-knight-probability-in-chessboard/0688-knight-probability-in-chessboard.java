class Solution {
    public double knightProbability(int n, int k, int row, int col) {
        double[][] prev=new double[n][n];
        double[][] curr=new double[n][n];
        
        prev[row][col]=1.0;
        while(k-->0){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(prev[i][j]!=0){
                        if(isValid(i+2,j-1,n)){
                            curr[i+2][j-1]+=prev[i][j]/8.0;
                        }
                        if(isValid(i+2,j+1,n)){
                            curr[i+2][j+1]+=prev[i][j]/8.0;
                        }
                        if(isValid(i+1,j-2,n)){
                            curr[i+1][j-2]+=prev[i][j]/8.0;
                        }
                        if(isValid(i+1,j+2,n)){
                            curr[i+1][j+2]+=prev[i][j]/8.0;
                        }
                        if(isValid(i-2,j+1,n)){
                            curr[i-2][j+1]+=prev[i][j]/8.0;
                        }
                        if(isValid(i-2,j-1,n)){
                            curr[i-2][j-1]+=prev[i][j]/8.0;
                        }
                        if(isValid(i-1,j+2,n)){
                            curr[i-1][j+2]+=prev[i][j]/8.0;
                        }
                        if(isValid(i-1,j-2,n)){
                            curr[i-1][j-2]+=prev[i][j]/8.0;
                        }
                    }
                }
            }
            prev=curr;
            curr=new double[n][n];
        }
        double ans=0.0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               ans+=prev[i][j]; 
            }
        }
        return ans;
    }
    public boolean isValid(int i,int j,int n){
        if(i<0||j<0||i>=n||j>=n){
            return false;
        }
        return true;
    }
}