class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle.size()==0){
            return 0;
        }
        if(triangle.get(0).size()==0){
            return 0;
        }
        int[][] dp=new int[triangle.size()+1][triangle.size()+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return triangle.get(0).get(0)+ help(triangle,1,0,dp);
    }
    public int help(List<List<Integer>> triangle,int i,int j,int[][] dp){
        if(i==triangle.size()||j==triangle.get(i).size()){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        return dp[i][j]= Math.min(triangle.get(i).get(j)+help(triangle,i+1,j,dp),
                        triangle.get(i).get(j+1)+help(triangle,i+1,j+1,dp));
    }
}