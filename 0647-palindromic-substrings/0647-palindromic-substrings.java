class Solution {
    public int countSubstrings(String s) {
        int ans=s.length();
        for(int i=0;i<=s.length();i++)
        {
            int even=isPalin(s,i,i+1);
            int odd=isPalin(s,i-1,i+1);
            ans+=even+odd;
        }
        return ans;
    }
    public int isPalin(String str,int left,int right)
    {
        int c=0;
        while(left>=0 && right<str.length() && (str.charAt(left--)==str.charAt(right++)))
        {
            c++;
        }
        return c;
    }
}