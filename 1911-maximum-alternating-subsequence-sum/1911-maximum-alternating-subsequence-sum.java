class Solution {
    public long maxAlternatingSum(int[] nums) {
        Long[] curr=new Long[2];
        Long[] next=new Long[2];
        next[0]=0L;
        next[1]=0L;
        // Long[][] dp=new Long[nums.length+1][2];
        // dp[nums.length][0]=0L;
        // dp[nums.length][1]=1L;
        for(int i=nums.length-1;i>=0;i--){
            curr[0]=Math.max(-nums[i]+next[1],next[0]);
            curr[1]=Math.max(nums[i]+next[0],next[1]);
            next=curr;
            curr=new Long[2];
        }
        return Math.max(next[0],next[1]);
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