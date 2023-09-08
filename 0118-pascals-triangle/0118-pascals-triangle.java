class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(0).add(1);
        for(int i=2;i<=numRows;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(j==0||j==i-1)
                {
                    ans.get(i-1).add(1);
                }else
                {
                    ans.get(i-1).add(ans.get(i-2).get(j-1)+ans.get(i-2).get(j));
                }
            }
        }
        return ans;
        
    }
}