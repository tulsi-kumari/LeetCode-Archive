class Solution {
    public long maxAlternatingSum(int[] nums) {
        Long[][] dp=new Long[nums.length+1][2];
        dp[nums.length][0]=0L;
        dp[nums.length][1]=1L;
        for(int i=nums.length-1;i>=0;i--){
            dp[i][0]=Math.max(-nums[i]+dp[i+1][1],dp[i+1][0]);
            dp[i][1]=Math.max(nums[i]+dp[i+1][0],dp[i+1][1]);
        }
        return Math.max(dp[0][0],dp[0][1]);
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