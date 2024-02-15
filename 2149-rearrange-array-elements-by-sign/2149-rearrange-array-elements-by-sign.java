class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos=0;
        int neg=0;
        int[] ans=new int[nums.length];
        int idx=0;
        while(idx<nums.length)
        {
            while(pos<nums.length && nums[pos]<0)
            {
                pos++;
            }
            if(pos<nums.length) ans[idx++]=nums[pos++];
            while(neg<nums.length && nums[neg]>=0)
            {
                neg++;
            }
            if(neg<nums.length) ans[idx++]=nums[neg++];
        }
        return ans;
    }
}