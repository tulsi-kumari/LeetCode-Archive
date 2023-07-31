class Solution {
    public int splitArray(int[] nums, int k) 
    {
        int s=Arrays.stream(nums).max().getAsInt();
        int e=Arrays.stream(nums).sum();
        int ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            int div=calc(mid,nums);
            System.out.println(s+" "+e+" "+ mid+" "+div);
            if(div>k){
                s=mid+1;
            }else{
                ans=mid;
                e=mid-1;
            }
            
        }
        return ans;
    }
    public int calc(int max,int[] nums){
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>max){
              count++;
                sum=nums[i];
            }
        }
        count++;
        return count;
    }
}