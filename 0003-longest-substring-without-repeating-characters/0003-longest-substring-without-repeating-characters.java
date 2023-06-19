class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        if(s.isEmpty()){
            return 0;
        }
        int prev =0;

        Map<Character,Integer> mp=new LinkedHashMap<>();
        int l=0;int r=0;
        while(l<s.length()&&r<s.length()){
            if(mp.containsKey(s.charAt(r))){
                l=mp.get(s.charAt(r))+1;
                for(int i=prev;i<l;i++){
                    if(mp.containsKey(s.charAt(i))&&mp.get(s.charAt(i))==i){
                        mp.remove(s.charAt(i));
                    }
                }
                prev=l-1;
            }
            mp.put(s.charAt(r),r);
            ans=Math.max(ans,r-l);
            r++;
        }
        return ans+1;
    }
}