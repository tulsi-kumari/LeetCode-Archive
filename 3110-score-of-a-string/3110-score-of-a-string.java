class Solution {
    public int scoreOfString(String s) {
        int ans=0;
        for(int i=1;i<s.length();i++)
        {
            int last=s.charAt(i-1)-'a';
            int curr=s.charAt(i)-'a';
            ans+=Math.abs(curr-last);
        }
        return ans;
    }
}