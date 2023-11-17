class Solution {
    public int minPairSum(int[] nums) {
        int max=Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length/2;i++)
        {
            max=Math.max(max,nums[i]+nums[nums.length-1-i]);
        }
        return max;
    }
}