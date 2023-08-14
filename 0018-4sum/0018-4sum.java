class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans=new ArrayList<>();
        long tar=(long) target;
        for(int i=0;i<nums.length-3;i++)
        {
            if(i!=0 && nums[i]==nums[i-1])
            {
                continue;
            }
            List<List<Integer>> ret=findThree(tar-(long)nums[i],nums,i+1,nums.length);
            for(List<Integer> list:ret)
            {
                list.add(0,nums[i]);
                ans.add(0,list);
            }
        }
        return ans;
    }
    public static List<List<Integer>> findThree(long target,int[] nums,int s,int e){
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=s;i<e-2;i++)
        {
            if(i!=s&& nums[i]==nums[i-1])
            {
                continue;
            }            
            List<List<Integer>> ret=findTwo(target-(long)nums[i],nums,i+1,e);
            for(List<Integer> list:ret)
            {
                list.add(0,nums[i]);
                ans.add(0,list);
            }
        }
        return ans;
    }
    public static List<List<Integer>> findTwo(long target,int[] nums,int s,int e){
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=s;i<e-1;i++)
        {
            if(i!=s && nums[i]==nums[i-1])
            {
                continue;
            }            
            List<List<Integer>> ret=findOne(target-(long)nums[i],nums,i+1,e);
            for(List<Integer> list:ret)
            {
                list.add(0,nums[i]);

                ans.add(0,list);
            }
        }
        return ans;
    }
    public static List<List<Integer>> findOne(long target,int[] nums,int s,int e){
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=s;i<e;i++)
        {
            if(i!=s && nums[i]==nums[i-1])
            {
                continue;
            }
            if((long)nums[i]==target)
            {
                List<Integer> list =new ArrayList<>();
                list.add(nums[i]);
                ans.add(list);
            }

        }
        return ans;
    }
}