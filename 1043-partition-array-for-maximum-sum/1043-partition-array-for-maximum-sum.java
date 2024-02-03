class Solution {
    Integer[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp=new Integer[arr.length+2];
       return solve(arr,k,0); 
    }
    public int solve(int[] arr,int k,int idx)
    {
        if(idx>=arr.length) return 0;
        if(dp[idx]!=null) return dp[idx];
        int max=0;
        int ans=0;
        for(int i=idx;i<idx+k && i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
            ans=Math.max(ans,solve(arr,k,i+1)+max*(i-idx+1)); 
        }
        return dp[idx]= ans;
    }
}