class Solution {
    public class Pair{
        int idx;
        int val;
        Pair(int idx,int val){
            this.idx=idx;
            this.val=val;
        }
    }
    public int longestSubsequence(int[] arr, int diff) {
        int ans=0;
        HashMap<Integer,ArrayList<Pair>> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
           int find=arr[i]-diff;
           if(map.containsKey(arr[i])){
               map.get(arr[i]).add(new Pair(i,1));
           }else{
               ArrayList<Pair> al=new ArrayList<Pair>();
               al.add(new Pair(i,1));
               map.put(arr[i],al);
           }
            if(map.containsKey(find)){
                int max=0;
                ArrayList<Pair> al=map.get(find);
                for(Pair p:al){
                    if(p.idx!=i){
                        max=Math.max(max,p.val);
                    }
                }
                map.get(arr[i]).get(map.get(arr[i]).size()-1).val+=max;
            }
           ans=Math.max(ans,map.get(arr[i]).get(map.get(arr[i]).size()-1).val);
        }
        return ans;
    }
}