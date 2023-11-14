class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> letters=new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            letters.add(s.charAt(i));
        }
        int count=0;
        for(char ch:letters)
        {
            int fi=-1;
            int si=-1;
            for(int j=0;j<s.length();j++)
            {
                if(s.charAt(j)==ch)
                {
                    if(fi==-1)
                    {
                        fi=j;
                    }
                    si=j;
                }
            }
            if(si-fi<2)
            {
                continue;
            }
            HashSet<Character> un=new HashSet<>();
            for(int i=fi+1;i<si;i++)
            {
                un.add(s.charAt(i));
            }
            count+=un.size();
        }
        return count;
    }
}