class Solution {
    public boolean halvesAreAlike(String s) {
        int half=s.length()/2;
        int fh=countVowels(s.substring(0,half));
        int sh=countVowels(s.substring(half,s.length()));
        return fh==sh;
    }
    public int countVowels(String str)
    {
        int cnt=0;
        for(char ch:str.toCharArray())
        {
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
            {
                cnt++;
            }
        }
        return cnt;
    }
}