class Solution {
     public long maxRunTime(int n, int[] batteries) {
        long lo = 1, hi = (long) 1e14+1;

        while(lo < hi){
            long  mid = lo + (hi-lo)/2;

            if(helper(batteries,n,mid)){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }

        return lo-1;
    }

    private boolean helper(int[] battries, int n, long minutes){
        long val = 0;

        for(int it : battries){
            val += Math.min(minutes,it);
        }

        return val >= (long) n*minutes;
    }
}