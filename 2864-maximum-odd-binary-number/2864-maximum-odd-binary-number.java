class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='1') count++;
        }
        count--;
        StringBuilder sb=new StringBuilder();
        while(count>0)
        {
            sb.append('1');
            count--;
        }
        while(sb.length()<s.length()-1)
        {
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();    }
}