class Solution {
    public int minTaps(int n, int[] ranges) {
        dp=new HashMap<>();
        List<int[]> list=new ArrayList<>(n+1);
        for(int i=0; i<n+1; i++) {
            if(ranges[i]==0) continue;
            int r[]=new int[2];
            r[0]=i-ranges[i];
            r[1]=i+ranges[i];
            list.add(r);
        }
        int interval[][]=new int[list.size()][2];
        int idx=0;
        for(int r[]: list) {
            interval[idx++]=r;
        }
        Arrays.sort(interval, (a, b)->a[0]-b[0]);
        int ret=util(n, interval, 0, 0);
        return ret>=Integer.MAX_VALUE-1 ? -1 : ret;
    }
    private Map<String, Integer> dp;
    private int util(int n, int interval[][], int cur, int i) {
        if(cur>=n) {
            return 0;
        }
        if(i==interval.length) {
            return Integer.MAX_VALUE-1;
        }

        String key=cur+"|"+i;
        if(dp.containsKey(key)) return dp.get(key);

        int ret;
        if(interval[i][0]<=cur) {
            int take=util(n, interval, interval[i][1], i+1);
            int notTake=util(n, interval, cur, i+1);
            ret=Math.min(1+take, notTake);
        }else {
            ret=Integer.MAX_VALUE-1;
        }
        dp.put(key, ret);
        return ret;
    }
}