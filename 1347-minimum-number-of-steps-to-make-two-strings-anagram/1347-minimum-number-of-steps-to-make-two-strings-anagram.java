class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int ans=0;
        for(char ch:t.toCharArray())
        {
            if(map.containsKey(ch))
            {
                if(map.get(ch)==1)
                {
                    map.remove(ch);
                }else
                {
                    map.put(ch,map.get(ch)-1);
                }
            }else
            {
                ans++;
            }
        }
        return ans;
    }
}