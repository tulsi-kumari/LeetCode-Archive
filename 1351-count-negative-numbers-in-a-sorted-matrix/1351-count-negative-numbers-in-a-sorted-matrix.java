class Solution {
    public int countNegatives(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int[] row:grid){
            int j=0;
            while(j<m && row[j]>=0){
                j++;
            }
            
            ans+=m-j;
        }
        
        return ans;
    }
}