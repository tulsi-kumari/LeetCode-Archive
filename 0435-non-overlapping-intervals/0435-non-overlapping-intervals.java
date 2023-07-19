class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = intervals[0][1];
        int current = 1;
        for(int i = 1; i < intervals.length; i++)
        {
            if(intervals[i][0] >= end)
            {
                end = intervals[i][1];
                current++;
            }
        }  
        return intervals.length - current;
       
    }
    // public int solve(int i,int[][] intervals,int prev,HashMap<String,Integer> map){
    //     if(i>=intervals.length){
    //         return 0;
    //     }
    //     String key=""+i+"@"+prev;
    //     if(map.containsKey(key)){
    //       return map.get(key);
    //     }
    //     if(prev==-1){
    //         int ret= Math.max(1+solve(i+1,intervals,i,map),solve(i+1,intervals,prev,map));
    //         map.put(key,ret);
    //         return ret;
    //     }else{
    //         int[] last =intervals[prev];
    //         int[] curr=intervals[i];
    //         if(curr[0]<last[1]){
    //             //not take
    //            int ret= solve(i+1,intervals,prev,map);
    //             map.put(key,ret);
    //             return ret;
    //         }else{
    //             int take=1+solve(i+1,intervals,i,map);
    //             int nottake=solve(i+1,intervals,prev,map);
    //             int ret= Math.max(take,nottake);
    //             map.put(key,ret);
    //             return ret;
    //         }
    //     }
    // }
}