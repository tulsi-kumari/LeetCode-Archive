class Solution {
    Integer[][] dp;
    public int rob(int[] nums) {
        dp=new Integer[nums.length+1][2];
       return solve(0,nums,0); 
    }
    public int solve(int i,int[] nums,int prev)
    {
        if(i>=nums.length)
        {
            return 0;
        }
        if(dp[i][prev]!=null)
        {
            return dp[i][prev];
        }
        if(prev==0)
        {
            return dp[i][prev]=Math.max(nums[i]+solve(i+1,nums,1),solve(i+1,nums,0));
        }
        return dp[i][prev]=solve(i+1,nums,0);
    }
}