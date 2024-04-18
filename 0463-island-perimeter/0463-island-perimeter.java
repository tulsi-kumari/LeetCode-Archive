class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int perimeter=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    perimeter+=dfs(grid,i,j);
                }
            }
        }
        return perimeter;
    }
    
    public int dfs(int[][] arr,int i,int j)
    {
        if(i<0||i>=arr.length||j<0||j>=arr[0].length||arr[i][j]==0)
        {
            return 1;
        }
        if(arr[i][j]==-1) return 0;
        
        arr[i][j]=-1;
        return dfs(arr,i+1,j)+dfs(arr,i-1,j)+dfs(arr,i,j-1)+dfs(arr,i,j+1);
        
    }
}