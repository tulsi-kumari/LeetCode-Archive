class Solution {
    public void sortColors(int[] nums) {
        int i=0;
        int k=nums.length-1;
        int m=0;
        while(m<nums.length&&m<=k){
            if(nums[m]==0){
               int temp=nums[i];
               nums[i]=nums[m];
               nums[m]=temp;
               
               i++;
               m++;
            }else if(nums[m]==1){
               m++;
            }else{
               int temp=nums[k];
               nums[k]=nums[m];
               nums[m]=temp;
               k--;
            }
        }
    }
}