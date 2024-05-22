class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        help(s,new ArrayList<>());
        return ans;
    }
    public void help(String s,List<String> lis)
    {
        if(s==""){
            ans.add(new ArrayList<>(lis));
            return;
        }
        for(int i=1;i<=s.length();i++)
        {
            if(isPalin(s.substring(0,i)))
            {
                lis.add(s.substring(0,i));
                help(s.substring(i),lis);
                lis.remove(lis.size()-1);
            }
        }
    }
    
    public boolean isPalin(String s)
    {
     StringBuilder sB=new StringBuilder();
     sB.append(s);
     sB.reverse();
     if(s.equals(sB.toString())){
         return true;
     }
     return false;
    }
}