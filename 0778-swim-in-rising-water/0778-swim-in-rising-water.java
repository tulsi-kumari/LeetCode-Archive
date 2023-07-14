class Solution {
    public class Pair implements Comparable<Pair>{
       int i;
       int j;
       int val;
        Pair(int i,int j,int val){
            this.i=i;
            this.j=j;
            this.val=val;
        }
        @Override
        public int compareTo(Pair o){
            return this.val-o.val;
        }
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.offer(new Pair(0,0,grid[0][0]));
        
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            if(vis[p.i][p.j]) continue;
            vis[p.i][p.j]=true;
            if(p.i==grid.length-1 && p.j==grid[0].length-1){
                return p.val;
            }
            if(p.i>0){
                
                    if(grid[p.i-1][p.j]<p.val){
                        pq.offer(new Pair(p.i-1,p.j,p.val));
                    }else{
                        pq.offer(new Pair(p.i-1,p.j,grid[p.i-1][p.j]));
                    }
                    
                
            }
            if(p.i<grid.length-1){
                
                if(grid[p.i+1][p.j]<p.val){
                        pq.offer(new Pair(p.i+1,p.j,p.val));
                    }else{
                        pq.offer(new Pair(p.i+1,p.j,grid[p.i+1][p.j]));
                    }
                
            }
            if(p.j>0){
                if(grid[p.i][p.j-1]<p.val){
                        pq.offer(new Pair(p.i,p.j-1,p.val));
                    }else{
                        pq.offer(new Pair(p.i,p.j-1,grid[p.i][p.j-1]));
                    }
                 
            }
            if(p.j<grid[0].length-1){
                if(grid[p.i][p.j+1]<p.val){
                        pq.offer(new Pair(p.i,p.j+1,p.val));
                    }else{
                        pq.offer(new Pair(p.i,p.j+1,grid[p.i][p.j+1]));
                    }
                 
            }
        }
                                 return 0;
    }
}