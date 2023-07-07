class Solution {
    public class Node{
        int type;
        int u;
        int v;
        Node(int type,int u,int v){
           this.type=type;
            this.u=u;
            this.v=v;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        Node[] arr=new Node[edges.length];
        int k=0;
        for(int[] edge:edges){
            arr[k]=new Node(edge[0],edge[1],edge[2]);
            k++;
        }
        
        Arrays.sort(arr,new Comparator<Node>(){
            public int compare(Node o1,Node o2){
                if(o1.type<o2.type){
                    return 1;
                }else if(o1.type>o2.type){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        
        int[] dsualice=new int[n+1];
        int[] dsubob=new int[n+1];
        int remove=0;
        
        int countOfVerticesa=1;
        int countOfVerticesb=1;
        
        int[] ranka=new int[n+1];
        int[] rankb=new int[n+1];
        
        Arrays.fill(ranka,1);
         Arrays.fill(rankb,1);
        
        for(int i=0;i<=n;i++){
            dsualice[i]=i;
            dsubob[i]=i;
        }
        
        for(Node edge:arr){
           // System.out.println(edge.type+" "+edge.u+" "+edge.v);
            if(edge.type==3){
                boolean mergeda=union(dsualice,edge.u,edge.v,ranka);
                boolean mergedb=union(dsubob,edge.u,edge.v,rankb);
                if(mergeda){
                    countOfVerticesa++;
                }
                if(mergedb){
                    countOfVerticesb++;
                }
                if(!mergeda && !mergedb ){
                    remove++;
                }
               // System.out.println(countOfVerticesa +" "+countOfVerticesb);
            }else if(edge.type==2){
                if(union(dsubob,edge.u,edge.v,rankb)){
                    countOfVerticesb++;
                }else{
                    remove++;
                }
                //System.out.println(countOfVerticesa +" "+countOfVerticesb);
            }else{
                 if(union(dsualice,edge.u,edge.v,ranka)){
                    countOfVerticesa++;
                }else{
                     remove++;
                 }
                //System.out.println(countOfVerticesa +" "+countOfVerticesb);
            }
            
        }
        //System.out.println(countOfVerticesa +" "+countOfVerticesb);
        if(countOfVerticesa!=n || countOfVerticesb!=n){
            return -1;
        }
        
        
        return remove;
    }
    
    public int findPar(int[] arr,int x){
        if(arr[x]==x){
            return x;
        }
        int temp=findPar(arr,arr[x]);
        arr[x]=temp;
        return temp;
    }
    public boolean union(int[] arr,int x,int y,int[] rank){
        int parx=findPar(arr,x);
        int pary=findPar(arr,y);
        if(parx==pary){
            return false;
        }else{
            if(rank[parx]<rank[pary]){
            arr[parx]=pary;
        }else if(rank[parx]>rank[pary]){
            arr[pary]=parx;
        }else{
            arr[parx]=pary;
            rank[pary]++;
        }
        }
        return true;
    }
}