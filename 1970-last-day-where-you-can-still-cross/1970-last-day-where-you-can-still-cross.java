class Solution {
    public class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int day=0;
        int[][] mat=new int[row][col];
        return binSearch(0,cells.length-1,cells,col,row);
    }
    public int binSearch(int s,int e,int[][] cells,int col,int row){
        if(s==e){
            int[][] mat=new int[row][col];
            for(int i=0;i<=s;i++){
              mat[cells[i][0]-1][cells[i][1]-1]=1;
            }
            if(!bfs(mat)){
                return s;
            }else{
                return s+1;
            }
        }
        if(s>e){
            return s;
        }
        
        
        int mid=s+(e-s)/2;
        //System.out.println(mid);
        int[][] mat=new int[row][col];
        for(int i=0;i<=mid;i++){
           mat[cells[i][0]-1][cells[i][1]-1]=1;
        }
        if(!bfs(mat)){
            return binSearch(s,mid-1,cells,col,row);
        }
            return binSearch(mid+1,e,cells,col,row);
        
    }
    public boolean bfs(int[][] arr){
        int[][] mat=new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    mat[i][j]=arr[i][j];
                }
            }
        }
        Queue<Pair> q=new LinkedList<>();
        for(int k=0;k<mat[0].length;k++){
            if(mat[0][k]==0){
                q.offer(new Pair(0,k));
            }
        }
        if(q.size()==0){
            return false;
        }
        
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                Pair p=q.poll();
                int i=p.i;
                int j=p.j;
                if(i==mat.length-1){
                    return true;
                }
                if(isValid(i,j,mat)){
                    mat[i][j]=1;
                    if(isValid(i+1,j,mat)){
                        q.offer(new Pair(i+1,j));
                    }
                    if(isValid(i,j+1,mat)){
                        q.offer(new Pair(i,j+1));
                    }
                    if(isValid(i-1,j,mat)){
                        q.offer(new Pair(i-1,j));
                    }
                    if(isValid(i,j-1,mat)){
                        q.offer(new Pair(i,j-1));
                    }
                }
                size--;
            }
        }
        return false;
    }
    public boolean isValid(int i,int j,int[][] mat){
        if(i<0||j<0||i>=mat.length||j>=mat[0].length||mat[i][j]==1){
            return false;
        }
        return true;
    }
}