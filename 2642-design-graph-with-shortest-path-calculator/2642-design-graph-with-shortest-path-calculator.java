class Graph {
    List<List<List<Integer>>> adj;
    public Graph(int n, int[][] edges) {
        this.adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            this.adj.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            this.adj.get(u).add(new ArrayList<>());
            this.adj.get(u).get(this.adj.get(u).size()-1).add(v);
            this.adj.get(u).get(this.adj.get(u).size()-1).add(w);
        }
    }
    
    public void addEdge(int[] edge) {
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            this.adj.get(u).add(new ArrayList<>());
            this.adj.get(u).get(this.adj.get(u).size()-1).add(v);
            this.adj.get(u).get(this.adj.get(u).size()-1).add(w);
    }
    
    public int shortestPath(int node1, int node2) {
        int n=this.adj.size();
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>(Comparator.comparingInt(list->list.get(0)));
        int[] distance=new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[node1]=0;
        pq.offer(Arrays.asList(0,node1));
        while(!pq.isEmpty())
        {
            List<Integer> curr=pq.poll();
            int currCost=curr.get(0);
            int currNode=curr.get(1);
            if(currCost > distance[currNode])
            {
                continue;
            }
            if(currNode==node2){
                return currCost;
            }
            for(List<Integer> nbr:adj.get(currNode)) 
            {
                int nbrnode=nbr.get(0);
                int nbrCost=nbr.get(1);
                int newCost=currCost+nbrCost;
                if(newCost<distance[nbrnode])
                {
                    distance[nbrnode]=newCost;
                    pq.offer(Arrays.asList(newCost,nbrnode));
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */