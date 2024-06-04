class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int len=0;
        boolean hasodd=false;
        for(char ch:map.keySet())
        {
            int val=map.get(ch);
            if(val%2==0) len+=val;
            else 
            {
                hasodd=true;
                len+=val-1;
            }
        }
        if(hasodd) len+=1;
        return len;
    }
}