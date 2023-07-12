class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        HashSet<Integer> added=new HashSet<>();       
        //System.out.println("hi");
        for(int i=0;i<graph.length;i++){
            if(graph[i].length==0){
                added.add(i);
                
            }
        }
        //System.out.println("hi");
        boolean isAdd=false;
        do{
            System.out.println(added);
            int size=added.size();
                for(int k=0;k<graph.length;k++){
                    if(!added.contains(k)){
                        int[] v=graph[k];
                        boolean flag=true;
                        for(int l=0;l<v.length;l++){
                            if(!added.contains(v[l])){
                                flag=false;
                            }
                        }
                        if(flag){
                            isAdd=true;
                            added.add(k);
                        }
                    }
                }
             if(added.size()==size){
                 isAdd=false;
             }
            
        }while(isAdd);
        //System.out.println("hi");
        List<Integer> ans=new ArrayList<>(added);
        Collections.sort(ans);
        return ans;
    }
}