class Solution {
    public int countNegatives(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int[] row:grid){
            int i=0;
            int j=m-1;
            int tempAns=m;
            while(i<=j){
                int mid=i+(j-i)/2;
                if(row[mid]<0){
                    tempAns=mid;
                    j=mid-1;
                }else{
                    i=mid+1;;
                }
            }
            ans+=m-tempAns;
        }
        
        return ans;
    }
}