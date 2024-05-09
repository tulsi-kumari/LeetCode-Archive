class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int i=0;
        int n=happiness.length;
        i=0;
        long ans=0;
        while(i<n && k>0)
        {
            long curr=(long)(happiness[n-1-i]-(i));
            ans+=(curr<0?0:curr);
            i++;
            k--;
        }
        return ans;
    }
}