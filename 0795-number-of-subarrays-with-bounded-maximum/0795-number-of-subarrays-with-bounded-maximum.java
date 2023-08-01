class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int s=0;
        int e=0;
        int ans=0;
        int prev=0;
        while(e<nums.length){
           
            if(nums[e]>right){
                s=e+1;
                prev=0;
            }else if(nums[e]<left){
                ans+=prev;
            }else{
                prev=e-s+1;
                ans+=prev;
            }
            
            e++;
            //System.out.println(ans+" "+s+" "+e);
             
            
        }
        return ans;
    }
}