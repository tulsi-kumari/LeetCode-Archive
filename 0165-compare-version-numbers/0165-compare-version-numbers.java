class Solution {
    public int compareVersion(String version1, String version2) {
        int i=0;
        int j=0;
        while(i<version1.length() || j<version2.length())
        {
            String num1="";
            String num2="";
            while(i<version1.length() && version1.charAt(i)!='.')
            {
                num1+=version1.charAt(i);
                i++;
            }
            i++;
            if(num1=="") num1="0";
            while(j<version2.length() && version2.charAt(j)!='.')
            {
                num2+=version2.charAt(j);
                j++;
            }
            j++;
            if(num2=="") num2="0";
            Integer f=Integer.valueOf(num1);
            Integer s=Integer.valueOf(num2);
            if(f<s) return -1;
            if(f>s) return 1;
            
        }
        return 0;
    }
}