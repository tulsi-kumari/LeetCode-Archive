class Solution {
    HashMap<String,Integer> dp;
    public int maxLength(List<String> arr) {
        dp=new HashMap<>();
        return solve(0,arr,new boolean[26]);
    }
    public int solve(int i,List<String> arr,boolean[] mask)
    {
        if(i>=arr.size())
        {
            return 0;
        }
        String key=""+i+"$";
        for(boolean b:mask)
        {
            key+=""+b+"%";
        }
        if(dp.containsKey(key))
        {
            return dp.get(key);
        }
        String curr=arr.get(i);
        HashSet<Integer> set=new HashSet<>();
        for(int j=0;j<curr.length();j++)
        {
            int ch=curr.charAt(j)-'a';
            if(mask[ch]==true||set.contains(ch))
            {
                int ret=solve(i+1,arr,mask);
                dp.put(key,ret);
                return dp.get(key);
            }
            set.add(ch);
        }
        
        for(int j=0;j<curr.length();j++)
        {
            int ch=curr.charAt(j)-'a';
            mask[ch]=true;
        }
        int take= curr.length()+solve(i+1,arr,mask);
        for(int j=0;j<curr.length();j++)
        {
            int ch=curr.charAt(j)-'a';
            mask[ch]=false;
        }
        int nottake=solve(i+1,arr,mask);
        int ans=Math.max(take,nottake);
        dp.put(key,ans);
        return dp.get(key);
    }
}