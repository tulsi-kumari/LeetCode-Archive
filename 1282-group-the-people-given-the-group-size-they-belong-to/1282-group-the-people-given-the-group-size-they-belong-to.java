class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        TreeMap<Integer,List<List<Integer>>> map=new TreeMap<>();
        for(int num:groupSizes)
        {
           if(!map.containsKey(num))
           {
               map.put(num,new ArrayList<>());
           }
        }
        for(int i=0;i<groupSizes.length;i++)
        {
            int curr=groupSizes[i];
            List<List<Integer>> list=map.get(curr);
            if(list.size()==0)
            {
                 List<Integer> newlast=new ArrayList<>();
                    newlast.add(i);
                    list.add(newlast);
            }else
            {
                List<Integer> last=list.get(list.size()-1);
                if(last.size()==curr)
                {
                     List<Integer> newlast=new ArrayList<>();
                    newlast.add(i);
                    list.add(newlast);
                }else
                {
                    last.add(i);
                }
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int key:map.keySet())
        {
            List<List<Integer>> list=map.get(key);
            for(List<Integer> curr : list)
            {
                ans.add(curr);
            }
        }
        return ans;
    }
}