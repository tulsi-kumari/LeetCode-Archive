class Solution {
    public String longestPalindrome(String s) {
        int best_len=0;
        int startIndex=-1;

        for (int i = 1; i < s.length(); i++) {
            int len=0;
            int j=i-1,k=i;
            while(j>-1&&k<s.length()){
                if(s.charAt(j)==s.charAt(k)){
                    k++;
                    j--;
                }else{
                    break;
                }
            }
            if(j+1!=k){
                len=k-j-1;
            }
            if(len>best_len){
                best_len=len;
                startIndex=j+1;
            }
        }
        //for odd palindromic substring we need to take each element as the middle one
        //total partitions=n
        for (int i = 0; i < s.length(); i++) {
            int len=1;
            int j=i-1,k=i+1;
            while(j>-1&&k<s.length()){
                if(s.charAt(j)==s.charAt(k)){
                    k++;
                    j--;
                }else{
                    break;
                }
            }
            if(j+1!=k){
                len=k-j-1;
            }
            if(len>best_len){
                best_len=len;
                startIndex=j+1;
            }
        }
        String ans =s.substring(startIndex,startIndex+best_len);

       return ans;
    }
}