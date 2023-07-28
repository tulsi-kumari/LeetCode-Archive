class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int bestScore1=helper(nums,0,nums.length-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(bestScore1>=(sum-bestScore1)){
            return true;
        }
        return false;
    }
    static int helper(int[] arr,int i,int j){
        if(i>j){
            return 0;
        }
        int front=arr[i]+Math.min(helper(arr,i+2,j),helper(arr,i+1,j-1));
        int back=arr[j]+Math.min(helper(arr,i+1,j-1),helper(arr,i,j-2));
        return Math.max(front,back);
    }
}