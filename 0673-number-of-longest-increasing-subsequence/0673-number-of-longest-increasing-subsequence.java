class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] lisupto=new int[n];
        int[] count=new int[n];
        int lis=1;
        int maxIdx=0;
        for(int i=0;i<n;i++){
            lisupto[i]=1;
                count[i]=1;
            for(int j=i-1;j>=0;j--){
                
                if(nums[j]<nums[i]){
                    if(lisupto[j]+1>lisupto[i]){
                        lisupto[i]=lisupto[j]+1;
                        count[i]=count[j];
                    }else if(lisupto[j]+1==lisupto[i]){
                        count[i]+=count[j];
                    }
                }
               // System.out.println(i+" "+j);
            }
            if(lis<lisupto[i]){
                lis=lisupto[i];
                maxIdx=i;
            }
        }
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(lisupto));
        int ans=0;
        for(int i=0;i<n;i++){
            if(lisupto[i]==lis){
                ans+=count[i];
            }
        }
        return ans;
        
        
    }
    
}