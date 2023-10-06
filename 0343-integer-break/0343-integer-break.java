class Solution {
    
    public int integerBreak(int n) {
        if(n<=3)
        {
            return n-1;
        }
        int rem=n%3;
        return (rem==0)?(int)Math.pow(3,n/3): (rem==1)?(int)Math.pow(3,n/3-1)*4 :(int)Math.pow(3,n/3)*2;
        
    }
}