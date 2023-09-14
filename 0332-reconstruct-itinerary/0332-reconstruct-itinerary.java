class Solution {
    HashMap<String,PriorityQueue<String>> mp;
    LinkedList<String> ans;
    public List<String> findItinerary(List<List<String>> tickets) {
        mp=new HashMap<>();
        ans=new LinkedList<>();
        for(int i=0;i<tickets.size();i++){
            String from=tickets.get(i).get(0);
            String to=tickets.get(i).get(1);
            if(mp.containsKey(from)){
                mp.get(from).add(to);
            }else{
                PriorityQueue<String> pq=new PriorityQueue<>();
                pq.add(to);
                mp.put(from,pq);
            }
        }
        
        dfs("JFK");
        
        return ans;
    }
    public void dfs(String curr)
    {
        PriorityQueue<String> pq=mp.get(curr);
        while(pq!=null && !pq.isEmpty())
        {
            String top=pq.poll();
            dfs(top);
        }
        ans.addFirst(curr);
    }
    public void getList(List<String> ans,String root, HashMap<String,List<String>> mp){
        if(!mp.containsKey(root)){
            ans.add(root);
            return;
        }
        ans.add(root);
        String prevRoot=root;
        root=mp.get(root).get(0);
        //System.out.println(root);
        mp.get(prevRoot).remove(0);
        if(mp.get(prevRoot).size()==0){
            mp.remove(prevRoot);
        }
        getList(ans,root,mp);
        
    }
}