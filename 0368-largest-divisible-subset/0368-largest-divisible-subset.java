class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n=arr.length;
        int []dp=new int[n];
        Arrays.sort(arr);
        Arrays.fill(dp,1);
        int []hash=new int[n];
        int max=0;
        int lastIndex=0;
        for(int i=0;i<n;i++)
        {
            hash[i]=i;
            for(int j=0;j<i;j++)
            {
                if((arr[i]%arr[j]==0) && 1+dp[j]>dp[i])
                {
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>max)
            {
                max=dp[i];
                lastIndex=i;
            }
        }

        List<Integer> res=new ArrayList<>();
        while(hash[lastIndex]!=lastIndex)
        {
            res.add(arr[lastIndex]);
            lastIndex=hash[lastIndex];
        }
        res.add(arr[lastIndex]);
        Collections.sort(res);
        return res;
    
    }
}