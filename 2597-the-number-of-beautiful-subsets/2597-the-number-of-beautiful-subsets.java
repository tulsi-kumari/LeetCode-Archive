class Solution {
    HashMap<Integer,Integer> map;
    int ans;
        
    public int beautifulSubsets(int[] nums, int k) {
        ans=0;
        map=new HashMap<>();
        Arrays.sort(nums);
        solve(nums,k,0);
        return ans-1;
    }
    public void solve(int[] nums,int k,int idx)
    {
        if(idx==nums.length){
            ans++;
            return;
        }
        solve(nums,k,idx+1);
        if(!map.containsKey(nums[idx]-k))
        {
            map.put(nums[idx],map.getOrDefault(nums[idx],0)+1);
            solve(nums,k,idx+1);
            if(map.get(nums[idx])==1) map.remove(nums[idx]);
            else{
                map.put(nums[idx],map.get(nums[idx])-1);
            }
        }
    }
}