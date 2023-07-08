class Solution {
    public int regionsBySlashes(String[] grid) {
        int n=grid.length;
        int len=(n+1);
        int[] parent=new int[len*len];
        int[] rank=new int[len*len];
        Arrays.fill(rank,1);
        rank[0]=n*4;
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        for(int i=0;i<=n;i++){
            parent[i]=0;
            parent[n*(n+1) + i ]=0;
        }
        for(int j=0;j<=n;j++){
            parent[(n+1)*j]=0;
            parent[(n+1)*(j) + n ]=0;
        }
        int regions=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char ch=grid[i].charAt(j);
                if(ch=='/'){
                    int u=len*(i+1)+j;
                    int v=len*(i)+(j+1);
                    if(!union(u,v,parent,rank)){
                        regions++;
                    }
                }
                if(ch=='\\'){
                    int u=len*(i)+j;
                    int v=len*(i+1)+(j+1);
                    if(!union(u,v,parent,rank)){
                        regions++;
                    }
                }
                          
            }
        }
                   
                   return regions;
        
    }
                   
    public int findPar(int x,int[] parent){
        if(parent[x]==x){
            return x;
        }
        int temp=findPar(parent[x],parent);
        parent[x]=temp;
        return temp;
    }
    public boolean union(int u,int v,int[] parent,int[] rank){
        int parx=findPar(u,parent);
        int pary=findPar(v,parent);
        if(parx==pary){
            return false;
        }
           if(rank[parx]>rank[pary]){
              parent[pary]=parx;
           }else if(rank[parx]<rank[pary]){
               parent[parx]=pary;
           }else{
               parent[parx]=pary;
               rank[pary]++;
           }
            return true;
        
    }
}