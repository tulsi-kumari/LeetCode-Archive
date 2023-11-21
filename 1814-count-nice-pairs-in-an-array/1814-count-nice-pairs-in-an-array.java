class Solution {
    static int mod=1000000007;
    public int countNicePairs(int[] nums) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int rev=reverse(nums[i]);
            //System.out.print(rev+" ");
            int diff=nums[i]-rev;
            map.put(diff,map.getOrDefault(diff,0)+1);
            ans=((ans+map.get(diff))%mod-1)%mod;
            
            temp[i]=diff;
        }
        System.out.println(Arrays.toString(temp));
        return ans;
    }
    public int reverse(int x)
    {
        int ans=0;
        while(x!=0)
        {
            int rem=x%10;
            ans=ans*10+rem;
            x=x/10;
        }
        return ans;
    }
}