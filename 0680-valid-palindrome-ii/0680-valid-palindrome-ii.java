class Solution {
    boolean ignore;
    public boolean validPalindrome(String s) {
       ignore=true;
        int i=0;
        int j=s.length()-1;
        return solve(s,i,j);
    }
    public boolean solve(String s,int i,int j){
        if(i>=j){
            return true;
        }
         char f=s.charAt(i);
         char sec=s.charAt(j);
        //System.out.println(f+" "+sec);
            if(f==sec){
                return solve(s,i+1,j-1);
            }else{
                if(ignore){
                    ignore=false;
                    return (solve(s,i+1,j)||solve(s,i,j-1));
                }else{
                    return false;
                }
            }
    }
}