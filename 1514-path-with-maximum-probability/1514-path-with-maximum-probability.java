class Solution {
    public class Pair{
        int i;
        double prob;
        Pair(int i,double prob){
            this.i=i;
            this.prob=prob;
        }
        
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer,List<Pair>> map=new HashMap<>();
        makeAdj(map,edges,succProb,n);
        boolean[] visited=new boolean[n];
        double ans=bfs(visited,start,end,map,n);
        return ans;
    }
    public double bfs(boolean[] visited,int start,int end,HashMap<Integer,List<Pair>> map,int n){
        double ans=0.0;
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((a, b)->Double.compare(b.prob, a.prob));
        q.offer(new Pair(start,1));
        while(!q.isEmpty()){
            int size=q.size();
            while(size!=0){
                
                Pair p=q.poll();
                int x=p.i;
                double probability=p.prob;
                
                if(x==end){
                    ans=Math.max(ans,probability);
                }else{
                    if(!visited[x]){
                        visited[x]=true;
                        List<Pair> adjacent=map.get(x);
                        for(Pair it:adjacent){
                            if(!visited[it.i]){
                                q.offer(new Pair(it.i,probability*it.prob));
                            }
                         }
                    }
                }
                

              size--;
            }
        }
        return ans;
    }
    
    
    public void makeAdj( HashMap<Integer,List<Pair>> map,int[][] edges,double[] succProb,int n){
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<Pair>());
        }
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<2;j++){
                int x=edges[i][0];
                int y=edges[i][1];
                map.get(x).add(new Pair(y,succProb[i]));
                map.get(y).add(new Pair(x,succProb[i]));
            }
        }
    }
}