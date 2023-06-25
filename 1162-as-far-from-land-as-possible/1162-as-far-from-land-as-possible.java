class Solution {
    public class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int maxDistance(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int ans=-1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==1){
                    q.offer(new Pair(i,j));
                }
            }
        }
        
        while(!q.isEmpty()){
            int size=q.size();
            while(size!=0){
                Pair p=q.poll();
                int i=p.i;
                int j=p.j;
                if(i>0 && grid[i-1][j]!=1){
                    q.offer(new Pair(i-1,j));
                    grid[i-1][j]=1;
                }
                if(i<grid.length-1 && grid[i+1][j]!=1){
                    q.offer(new Pair(i+1,j));
                    grid[i+1][j]=1;
                }
                if(j>0 && grid[i][j-1]!=1){
                    q.offer(new Pair(i,j-1));
                    grid[i][j-1]=1;
                }
                if(j<grid[0].length-1 && grid[i][j+1]!=1 ){
                    q.offer(new Pair(i,j+1));
                    grid[i][j+1]=1;
                }
                size--;
            }
            ans++;
        }
        
        return ans==0?-1:ans;
    }
}