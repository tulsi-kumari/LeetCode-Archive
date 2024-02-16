class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        List<Integer> freq=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:map.entrySet())
        {
            freq.add(e.getValue());
        }
        Collections.sort(freq);
        int j=0;
        while(j<freq.size())
        {
            int curr=freq.get(j);
            if(curr<=k)
            {
                j++;
                k-=curr;
            }else
            {
                return freq.size()-j;
            }
        }
        return 0;
    }
}