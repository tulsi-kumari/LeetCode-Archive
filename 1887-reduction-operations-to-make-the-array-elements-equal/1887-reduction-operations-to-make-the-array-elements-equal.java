class Solution {
    public int reductionOperations(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int count=1;
        Arrays.sort(nums);
        int ans=0;
        int i=1;
        while(i<nums.length)
        {
            if(nums[i]!=nums[i-1])
            {
                int freq=map.get(nums[i]);
                ans+=freq*count;
                count++;
            }
            i++;
        }
        return ans;
    }
}