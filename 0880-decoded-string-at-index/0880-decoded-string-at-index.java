class Solution {
    public String decodeAtIndex(String s, int k) {
        long length=0;
        int i=0;
        for(;length<k;i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {
                length*=ch-'0';
            }else
            {
                length++;
            }
        }
        for(int j=i-1;j>=0;j--)
        {
            char ch=s.charAt(j);
            if(Character.isDigit(ch))
            {
                length/=ch-'0';
                k=k%(int)length;
            }else
            {
                if (k == 0 || k == length) {
                    return Character.toString(s.charAt(j));
                }
                length--;
            }
        }
        return "";
    }
}
