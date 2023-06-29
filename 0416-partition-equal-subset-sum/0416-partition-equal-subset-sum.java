class Solution {
    public boolean canPartition(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        Boolean[][] dp=new Boolean[sum+1][nums.length+1];
        
        if(sum%2!=0){
            return false;
        }
        return canMakeSubset(sum/2,nums,0,0,dp);
    }
    public boolean canMakeSubset(int sum,int[] nums,int curr,int i,Boolean[][] dp){
        if(curr>sum){
            return false;
        }
        if(curr==sum){
            return true;
        }
        if(i>=nums.length){
            return false;
        }
        if(dp[curr][i]!=null){
            return dp[curr][i];
        }
        return dp[curr][i]=(canMakeSubset(sum,nums,curr+nums[i],i+1,dp)
    ||canMakeSubset(sum,nums,curr,i+1,dp));
    }   
}