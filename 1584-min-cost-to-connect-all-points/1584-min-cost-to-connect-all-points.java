class Solution {
    public class Pair{
        int wt;
        int u;
        int v;
        Pair(int wt,int u,int v){
            this.wt=wt;
            this.u=u;
            this.v=v;
        }
        
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> q=new PriorityQueue<Pair>(new Comparator<>(){
            public int compare(Pair o1,Pair o2){
                if(o1.wt<o2.wt){
                    return -1;
                }else if(o1.wt>o2.wt){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        
           for(int i=0;i<points.length;i++){
               for(int j=i+1;j<points.length;j++){
                   int wt=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                   q.offer(new Pair(wt,i,j));
               }
           }
        //System.out.println(q.size());
        
        int[] parent=new int[points.length];
        int[] rank=new int[parent.length];
        //intialise parent and rank
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        Arrays.fill(rank,1);
        //for each elemnt in pq
        int ans=0;
        while(!q.isEmpty()){
            Pair p=q.poll();
            if(union(p.u,p.v,parent,rank)){
                ans+=p.wt;
            }
        }
        return ans;
        
        
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
        int paru=findPar(u,parent);
        int parv=findPar(v,parent);
        if(paru!=parv){
            if(rank[paru]<rank[parv]){
                parent[paru]=parv;
            }else if(rank[paru]>rank[parv]){
                parent[parv]=paru;
            }else{
                parent[parv]=paru;
                rank[paru]++;
            }
            return true;
        }
        return false;
    } 
}