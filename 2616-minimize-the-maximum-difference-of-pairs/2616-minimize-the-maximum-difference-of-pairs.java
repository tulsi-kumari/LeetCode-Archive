class Solution {
    public int minimizeMax(int[] nums, int p) {
       Arrays.sort(nums);
        if(p==0)
        {
            return 0;
        }
        int ans=0;
       int[] diff=new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++)
        {
            diff[i]=Math.abs(nums[i]-nums[i+1]);
        }
        int s=Arrays.stream(diff).min().getAsInt();
        int e=Arrays.stream(diff).max().getAsInt();
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            int count=0;
            for(int i=0;i<diff.length;i++){
                if(diff[i]<=mid)
                {
                    count++;
                    i++;
                }
            }
            System.out.println(s+" "+e+" "+mid+" "+count);
            if(count<p)
            {
               s=mid+1; 
            }else{
              ans=mid;
                e=mid-1;
            }
        }
        //System.out.println(Arrays.toString(diff));
        //HashMap<String,Integer> dp=new HashMap<>();
        //return solve(0,p,diff,dp);
        return ans;
    }
    public int solve(int i,int p,int[] diff,HashMap<String,Integer> dp)
    {
        if(i>=diff.length && p!=0)
        {
            return Integer.MAX_VALUE;
        }
        if(i>=diff.length)
        {
            return 0;
        }
        if(p==0)
        {
            return 0;
        }
        String key=i+"#"+p;
        if(dp.containsKey(key))
        {
            return dp.get(key);
        }
        int take=Math.max(diff[i],solve(i+2,p-1,diff,dp));
        int  nottake=solve(i+1,p,diff,dp);
        //System.out.println(take+" "+nottake+" "+i);
        int ans= Math.min(take,nottake);
        dp.put(key,ans);
        return dp.get(key);
    }
}