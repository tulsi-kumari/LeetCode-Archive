class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target>nums[nums.length-1]){
            return nums.length;
        }
        return binCeilSearch(nums,target,0,nums.length-1);
    }
    public int binCeilSearch(int[] nums, int target,int s,int e){
        if(s>e){
            return s;
        }
        int mid=s+(e-s)/2;
        if(nums[mid]<target){
           return binCeilSearch(nums,target,mid+1,e);
        }else if(nums[mid]>target){
           return  binCeilSearch(nums,target,s,mid-1);
        }else{
            return mid;
        }
    }
}