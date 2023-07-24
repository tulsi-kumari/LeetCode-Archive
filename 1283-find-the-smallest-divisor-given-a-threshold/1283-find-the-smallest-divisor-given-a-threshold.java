class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int s=1;
        int e=nums[nums.length-1]+1;
        int ans=e;
        while(s<=e){
            int mid=s+(e-s)/2;
            int sum=calc(mid,nums);
            if(sum<threshold){
              ans=Math.min(mid,ans);
                e=mid-1;
            }else if(sum>threshold){
                s=mid+1;
            }else{
                ans=Math.min(mid,ans);
                e=mid-1;
            }
        }
        return ans;
    }
    public int calc(int mid,int[] nums){
      int ans=0;
        for(int num:nums){
            int curr=num/mid;
            if(num%mid!=0){
                curr++;
            }
            ans+=curr;
        }
        return ans;
    }
}