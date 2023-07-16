class Solution {
    public class Pair{
      int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                   max=Math.max(bfs(q,grid,i,j),max);
                }
            }
        }
        return max;
    }
    public int bfs(Queue<Pair> q,int[][] grid,int x,int y){
        q.offer(new Pair(x,y));
        int ret=0;
        while(!q.isEmpty()){
            int size=q.size();
            //System.out.println(size);
            while(size-->0){
                Pair p=q.poll();
                int i=p.i;
                int j=p.j;
                if(grid[i][j]==0) continue;
                ret++;
                grid[i][j]=0;
                if(isValid(i+1,j,grid)){
                    q.offer(new Pair(i+1,j));
                }
                if(isValid(i-1,j,grid)){
                     q.offer(new Pair(i-1,j));
                }
                if(isValid(i,j+1,grid)){
                     q.offer(new Pair(i,j+1));
                }
                if(isValid(i,j-1,grid)){
                     q.offer(new Pair(i,j-1));
                }
            }
        }
        return ret;
    }
    public boolean isValid(int i,int j,int[][] grid){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0){
            return false;
        }
        return true;
    }
}