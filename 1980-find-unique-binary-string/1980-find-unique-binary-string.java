class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(String num:nums)
        {
            set.add(Integer.parseInt(num,2));
        }
        for(int i=0;i<=nums.length;i++)
        {
            if(!set.contains(i))
            {
                StringBuilder sb=new StringBuilder(Integer.toBinaryString(i));
                while(sb.length()<nums.length)
                {
                    sb.insert(0,0);
                }
                return new String(sb);
            }
        }
        return "";
        
        
    }
}