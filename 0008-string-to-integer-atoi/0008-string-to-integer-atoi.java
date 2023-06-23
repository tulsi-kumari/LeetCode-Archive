class Solution {
    public int myAtoi(String s) {

        if(s.length()==0){
            return 0;
        }

        long ans=0L;

        int i=0;

        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }

        boolean isNegative=false;

        if(i<s.length()&&s.charAt(i)=='-'){
           isNegative=true;
           i++;
        }else if(i<s.length()&&s.charAt(i)=='+'){
            i++;
        }
        while(i<s.length()&&s.charAt(i)=='0'){
            i++;
        }
        int j=i;
        while(j<s.length() && s.charAt(j)>='0'&& s.charAt(j)<='9'){
            j++;
        }
        if(i==j){
           return 0;
        }
        
        String str=s.substring(i,j);
        if(str.length()>15){
            if(isNegative){
             return Integer.MIN_VALUE;
            }else{
                 return Integer.MAX_VALUE;
            }
        }
        ans=Long.parseLong(str);
        if(isNegative){
            ans=ans*-1;
        }
        if(ans>=(long)Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(ans<=(long)Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)ans;
    }
}