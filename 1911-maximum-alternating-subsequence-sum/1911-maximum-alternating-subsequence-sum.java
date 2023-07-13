class Solution {
    public long maxAlternatingSum(int[] nums) {
        Long[][] dp=new Long[nums.length][2];
        
        return solve(0,1,nums,dp);
    }
    public long solve(int i,int isEven,int[] nums,Long[][] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i][isEven]!=null){
            return dp[i][isEven];
        }
        if(isEven==1){
            long op1=nums[i]+solve(i+1,0,nums,dp);
            long op2=solve(i+1,1,nums,dp);
            return dp[i][isEven]=Math.max(op1,op2);
        }
        
        long op1=-nums[i]+solve(i+1,1,nums,dp);
        
        long op2=solve(i+1,0,nums,dp);
        return dp[i][isEven]= Math.max(op1,op2);
    }
}