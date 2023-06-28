class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target){
            return 0;
        }
        //to check visited buses
        HashSet<Integer> visitedBus=new HashSet<>();
        //to check visited bus stands
        HashSet<Integer> visitedBusStand=new HashSet<>();
        //to map busstands to all buses that arrive at it
        HashMap<Integer,ArrayList<Integer>> busmap=new HashMap<>();
        
        //mapping of busstands to all buses that arrive at it
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                if(!busmap.containsKey(routes[i][j])){
                    busmap.put(routes[i][j],new ArrayList<Integer>());
                }
                busmap.get(routes[i][j]).add(i);
            }
        }
        
        
        //well start traversal from all busstands that are directly connected by a single bus to start bus stand
        Queue<Integer> q=new LinkedList<>();
        for(int bus:busmap.get(source)){
            for(int i:routes[bus]){
                q.offer(i);
                visitedBusStand.add(i);
            }
            visitedBus.add(bus);
        }
        //System.out.println(q);
        
        int ans=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                int busstand=q.poll();
                if(busstand==target){
                    return ans;
                }
                
                for(int bus:busmap.get(busstand)){
                    //System.out.println();
                    if(!visitedBus.contains(bus)){
                        
                        for(int i:routes[bus]){
                            if(!visitedBusStand.contains(i)){
                                visitedBusStand.add(i);
                                q.offer(i);
                            }   
                         }
                         visitedBus.add(bus);
                        } 
                 }
                
                size--;
            }
            //System.out.println(q);
            ans++;
        }
        
        return -1;
        
    }
}