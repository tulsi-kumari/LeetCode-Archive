class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[][] t =new int[cost.length+2][2];

        for(int i=0;i<cost.length+2;i++){
            for(int j=0;j<2;j++){
                t[i][j]=-1;
            }
        }
       return help(0,cost,t,true);
    }
    public int help(int i,int[] cost,int[][] t,boolean prev){
        if(i==cost.length){
            return 0;
        }

         int x=0;
        if(prev){
           x=1;
        }

        if(t[i][x]!=-1){
            return t[i][x];
        }

        if(!prev){
            return t[i][x] = cost[i]+help(i+1,cost,t,true);
        }

        return t[i][x]= Math.min(cost[i]+help(i+1,cost,t,true),help(i+1,cost,t,false));
    }
}