class Solution {
    public class Pair{
       int i;
        int j;
        int sum;
        Pair(int i,int j,int sum){
            this.i=i;
            this.j=j;
            this.sum=sum;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums1.length;
        int m=nums2.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair o1,Pair o2){
                if(o1.sum<o2.sum){
                    return -1;
                }else if(o1.sum>o2.sum){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        for(int j=0;j<m;j++){
            pq.add(new Pair(0,j,nums1[0]+nums2[j]));
        }
        while(k>0 && !pq.isEmpty()){
            Pair p=pq.poll();
            
            int x=p.i;
            int y=p.j;
            if(x<n && y<m){
                ans.add(new ArrayList<Integer>(Arrays.asList(nums1[x],nums2[y])));
                if(x+1!=n && y!=m){
                    pq.add(new Pair(x+1,y,nums1[x+1]+nums2[y]));
                }
                
                k--;
                
            }
            
        }
        return ans;
    }
}