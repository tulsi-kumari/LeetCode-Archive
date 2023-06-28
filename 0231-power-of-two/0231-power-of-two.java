class Solution {
    public boolean isPowerOfTwo(int n) {
        long x=(long)n;
        if(n<0){
            return false;
        }
        if(x==0){
            return false;
        }
        if((x & x-1) ==0){
            return true;
        }
        return false;
    }
}