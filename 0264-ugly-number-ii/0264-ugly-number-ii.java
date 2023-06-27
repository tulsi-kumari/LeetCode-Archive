class Solution {
    public int nthUglyNumber(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        int ptr2=1,ptr3=1,ptr5=1;
        int i=2;
        while(i<=n){
            int next2=2*dp[ptr2];
            int next3=3*dp[ptr3];
            int next5=5*dp[ptr5];
            
            int min=Math.min(next2,Math.min(next3,next5));
            dp[i]=min;
            i++;
            if(next2==min){
                ptr2++;
            }
            if(next3==min){
                ptr3++;
            }
            if(next5==min){
                ptr5++;
            }
        }
        return dp[n];
        
    }
}