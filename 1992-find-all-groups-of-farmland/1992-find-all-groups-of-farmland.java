class Solution {
    int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
    int row2,col2;
    public int[][] findFarmland(int[][] land) {
        boolean[][] visited=new boolean[land.length][land[0].length];
        List<int[]> ans=new ArrayList<>();
        for(int row1=0;row1<land.length;row1++)
        {
            for(int col1=0;col1<land[0].length;col1++)
            {
                if(land[row1][col1]==1 && !visited[row1][col1])
                {
                    row2=0;col2=0;
                    dfs(land,visited,row1,col1);
                    int[] arr=new int[]{row1,col1,row2,col2};
                    ans.add(arr);
                }
            }
        }
        
        return ans.stream().toArray(int[][] :: new);
     }
    
    private void dfs(int[][] land,boolean[][] visited,int x,int y)
    {
        visited[x][y]=true;
        row2=Math.max(row2,x);
        col2=Math.max(col2,y);
        
        for(int[] dir:dirs)
        {
            int newx=x+dir[0];
            int newy=y+dir[1];
            if(isWithinFarm(newx,newy,land.length,land[0].length) && !visited[newx][newy] && land[newx][newy]==1)
            {
                dfs(land,visited,newx,newy);
            }
        }
        
    }
    private boolean isWithinFarm(int x,int y,int N,int M)
    {
        return x>=0 && y>=0 && x<N && y<M;
    }
}