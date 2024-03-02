class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int negptr=-1;
        int posptr=0;
        int i=0;
        while(i<n && nums[i]<0)
        {
            posptr++;
            i++;
        }
        negptr=posptr-1;
        int j=0;
        while(negptr>=0 && posptr<n)
        {
            if(Math.abs(nums[negptr])<nums[posptr])
            {
                ans[j++]=nums[negptr]*nums[negptr];
                negptr--;
            }else
            {
                ans[j++]=nums[posptr]*nums[posptr];
                posptr++;
            }
        }
        while(negptr>=0)
        {
                ans[j++]=nums[negptr]*nums[negptr];
                negptr--;
        }
        while(posptr<n)
        {
                ans[j++]=nums[posptr]*nums[posptr];
                posptr++;
        }
        return ans;
        
    }
}