class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(ans,new ArrayList<Integer>(),n,k,0,1);
        return ans;
    }
    public void solve(List<List<Integer>> ans,List<Integer> temp,int n,int k,int cc,int curr){
        if(curr>n && cc==k){
            List<Integer> add=new ArrayList<>();
            add.addAll(temp);
            ans.add(add);
            return;
        }
        if(curr>n){
            return;
        }
        if(cc==k){
            List<Integer> add=new ArrayList<>();
            add.addAll(temp);
            ans.add(add);
            return;
        }
        for(int i=curr;i<=n;i++){
            temp.add(i);
            solve(ans,temp,n,k,cc+1,i+1);
            temp.remove(temp.size()-1);
        }
    }
}