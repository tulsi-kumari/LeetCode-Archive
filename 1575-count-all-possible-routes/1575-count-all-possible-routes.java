class Solution {
    long mod=1000000007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long[][] dp=new long[locations.length][fuel+1];
        for(long[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return (int)(func(locations,start,finish,fuel,dp)%(long)mod);
    }
    public long func(int[] locations, int start, int finish, int fuel,long[][] dp) {
        if(fuel<0){
            return 0;
        }
        if( (fuel==0 && start==finish)){
            return 1;
        }
        if(dp[start][fuel]!=-1){
            return dp[start][fuel];
        }
        long ans=0;
        if(start==finish) ans++;
            
        for(int i=0;i<locations.length;i++){
            if(i!=start){
                ans=((ans % ((long)(mod)))+func(locations,i,finish,fuel-Math.abs(locations[start]-locations[i]),dp))% ((long)(mod));
                
            }
        }
        
        return dp[start][fuel]= (ans% ((long)(mod)));
    }
}