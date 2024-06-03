class Solution {
    public int appendCharacters(String s, String t) {
        int is=0;
        int it=0;
        while(is<s.length() && it<t.length())
        {
            if(s.charAt(is)==t.charAt(it))
            {
                is++;
                it++; 
            }else
            {
                is++;
            }
        }
        if(it==t.length()) return 0;
        return t.length()-it;
    }
}