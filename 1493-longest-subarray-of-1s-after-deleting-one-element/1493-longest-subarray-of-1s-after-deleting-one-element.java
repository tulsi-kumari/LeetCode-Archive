class Solution {
    public int longestSubarray(int[] nums) {
        boolean mark=true;
        for(int num:nums){
            if(num==0){
                mark=false;
            }
        }
        if(mark){
            return nums.length-1;
        }
        int max=0;
        int j=0;
        int prev=-1;
        while(j<nums.length){
            boolean flag=false;
            int sum=0;
            while(j<nums.length){
                if(nums[j]==0 && flag==false){
                    flag=true;
                    prev=j;
                    j++;
                }else if(nums[j]==1){
                    sum++;
                    j++;
                }else{
                    max=Math.max(max,sum);
                    break;
                }
                max=Math.max(max,sum);
            }
            if(j==nums.length){
                break;
            }else{
                j=prev+1;
            }
        }
        return max;
    }
}