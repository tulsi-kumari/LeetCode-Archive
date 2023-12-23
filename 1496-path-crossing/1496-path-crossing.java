class Solution {
    public boolean isPathCrossing(String path) {
       HashSet<String> set=new HashSet<>();
        int i=0;
        int j=0;
        set.add("0#0");
        for(char ch:path.toCharArray())
        {
            if(ch=='E')
            {
               i++; 
            }else if(ch=='W')
            {
                i--;
            }else if(ch=='N')
            {
                j++;
            }else
            {
                j--;
            }
            String curr=i+"#"+j;
            if(set.contains(curr))
            {
                return true;
            }
            set.add(curr);
        }
        return false;
    }
}