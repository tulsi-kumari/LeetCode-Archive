class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        long[] prefsum=new long[n];
        for(int i=0;i<n;i++)
        {
            if(i==0){
                prefsum[i]=0L;
            }else
            {
                prefsum[i]=prefsum[i-1]+(long)nums[i-1];
            }
        }
        for(int i=n-1;i>1;i--)
        {
            if((long)nums[i]<prefsum[i]) return prefsum[i]+(long)nums[i];
        }
        return -1;
    }
}