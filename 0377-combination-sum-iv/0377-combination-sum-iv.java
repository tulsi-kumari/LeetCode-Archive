class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[][] dp=new int[nums.length][target];
        for(int[] i:dp)Arrays.fill(i,-1);
        return f(0,nums,target,0,dp);
    }
    int f(int i,int[] nums,int target,int sum,int[][] dp){
        if(sum==target)return 1;
        if(i>=nums.length || sum>target)return 0;
        if(dp[i][sum]!=-1)return dp[i][sum];
        return dp[i][sum]=f(0,nums,target,sum+nums[i],dp)+f(i+1,nums,target,sum,dp);
    }
}