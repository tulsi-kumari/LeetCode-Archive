class Solution {
    public int minOperations(int[] nums, int x) {
         int n=nums.length;
        // HashMap<String,Integer> dp=new HashMap<>();
        // int ans=solve(0,nums.length-1,nums,x,dp);
        // return ans==Integer.MAX_VALUE?-1:ans;
        int totalSum = Arrays.stream(nums).sum();
        int target = totalSum - x;
        if(target<0)
        {
            return -1;
        }
        if(target==0)
        {
            return n;
        }
        int ans=Integer.MAX_VALUE;
        int currsum=0;
        int left=0,right=0;
        while(right<n)
        {
            currsum+=nums[right];
            right++;
            while(currsum>target && left<n)
            {
              currsum-=nums[left];
                left++;
            }
            if(currsum==target)
            {
                ans=Math.min(ans,n-(right-left));
            }
        }
        return (ans==Integer.MAX_VALUE)?-1:ans;
        
    }

//         while (rightIndex < n) {
//             currentSum += nums[rightIndex];
//             rightIndex++;

//             while (currentSum > target && leftIndex < n) {
//                 currentSum -= nums[leftIndex];
//                 leftIndex++;
//             }

//             if (currentSum == target)
//                 minOperations = Math.min(minOperations, n - (rightIndex - leftIndex));
//         }

//         return (minOperations == Integer.MAX_VALUE) ? -1 : minOperations; // Return the minimum operations or -1 if not possible
    public static int solve(int s,int e,int[] nums,int x,HashMap<String,Integer> dp)
    {

        if(x==0)
        {
            return 0;
        }
        if(s>e)
        {
            if(x!=0)
            {
                return Integer.MAX_VALUE;
            }
            return 0;
        }
        String key=""+s+"#"+e;
        if(dp.containsKey(key))
        {
            return dp.get(key);
        }
        if(nums[s]<=x && nums[e]<=x)
        {
            int f=solve(s+1,e,nums,x-nums[s],dp);
            int l=solve(s,e-1,nums,x-nums[e],dp);
            if(f==Integer.MAX_VALUE&&l==Integer.MAX_VALUE)
            {
                dp.put(key,Integer.MAX_VALUE);
                return Integer.MAX_VALUE;
            }
            dp.put(key,1+Math.min(f,l));
            return dp.get(key); 
        }else if(nums[s]<=x)
        {
            int ret=solve(s+1,e,nums,x-nums[s],dp);
            dp.put(key,(ret==Integer.MAX_VALUE)?Integer.MAX_VALUE:ret+1);
            return dp.get(key); 
        }else if(nums[e]<=x)
        {
            int ret=solve(s,e-1,nums,x-nums[e],dp);
          dp.put(key,(ret==Integer.MAX_VALUE)?Integer.MAX_VALUE:ret+1);
            return dp.get(key); 
        }
        dp.put(key,Integer.MAX_VALUE);
        return dp.get(key); 
    }
}