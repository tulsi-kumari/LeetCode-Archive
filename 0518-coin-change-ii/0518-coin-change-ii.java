class Solution {
    public int change(int amount, int[] coins) {
        int[][] t=new int[coins.length+1][amount+1];
        for (int i=0;i<=coins.length;i++){
            t[i][0]=1;
        }
        for (int i=1;i<t.length;i++){
            for (int j = 1; j < t[0].length; j++) {
               if(j>=coins[i-1]){
                   t[i][j]=t[i][j-coins[i-1]]+t[i-1][j];
               }else {
                   t[i][j]=t[i-1][j];
               }
            }
        }
        return t[coins.length][amount];
    }
    
}