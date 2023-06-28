class Solution {
    public String removeOuterParentheses(String s) {
        String ans="";
        int i=0;
        int j=0;
        
        while(j<s.length() && i<s.length()){
            int count=0;
            do{
                if(s.charAt(j)=='('){
                    count++;
                }else{
                    count--;
                }
                j++;
            }while(count!=0);
            ans+=s.substring(i+1,j-1);
            i=j;
        }
        return ans;
        
    }
}