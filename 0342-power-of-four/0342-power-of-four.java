class Solution {
    public boolean isPowerOfFour(int n) {
        if(isPowerOfTwo(n)){
            long mask=1;
            int ctr=29;
            while(ctr!=0){
                mask=(mask<<2)|1;
                ctr--;
            }
            System.out.println(Long.toBinaryString(mask));
            
            if((n&mask)!=0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
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