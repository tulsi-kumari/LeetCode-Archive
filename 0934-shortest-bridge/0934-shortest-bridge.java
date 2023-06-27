class Solution {
    public class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        boolean[][] visited=new boolean[n][n];
        Queue<Pair> q=new LinkedList<>();
        boolean flag=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    dfs(grid,visited,q,i,j);
                    flag=true;
                    j=n;
                }
            }
            if(flag){
                i=n;
            }
        }
        // for(boolean[] t:visited){
        //     System.out.println(Arrays.toString(t));
        // }
        // System.out.println(q.size());
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size!=0){
                Pair p=q.poll();
                int x=p.i;
                int y=p.j;
                if(visited[x][y]){
                    if(x<n-1 && !visited[x+1][y]){
                        if(grid[x+1][y]==1){
                            return level;
                        }else{
                           visited[x+1][y]=true;
                            q.offer(new Pair(x+1,y));
                        }
                    }
                    if(x>0 && !visited[x-1][y]){
                        if(grid[x-1][y]==1){
                            return level;
                        }else{
                           visited[x-1][y]=true;
                            q.offer(new Pair(x-1,y));
                        }
                    }
                    if(y<n-1 && !visited[x][y+1]){
                        if(grid[x][y+1]==1){
                            return level;
                        }else{
                           visited[x][y+1]=true;
                            q.offer(new Pair(x,y+1));
                        }
                    }
                    if(y>0 && !visited[x][y-1]){
                        if(grid[x][y-1]==1){
                            return level;
                        }else{
                           visited[x][y-1]=true;
                            q.offer(new Pair(x,y-1));
                        }
                    }
                }
                size--;
            }
            // for(boolean[] t:visited){
            // System.out.println(Arrays.toString(t));
            // }
            //  System.out.println(q.size());
            level++;
        }
        return -1;
    }
    public void dfs(int[][] grid,boolean[][] visited,Queue<Pair> q,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid.length||visited[i][j]==true||grid[i][j]!=1){
            return;
        }
        q.offer(new Pair(i,j));
        visited[i][j]=true;
        dfs(grid,visited,q,i+1,j);
        dfs(grid,visited,q,i-1,j);
        dfs(grid,visited,q,i,j+1);
        dfs(grid,visited,q,i,j-1);
        
    }
}