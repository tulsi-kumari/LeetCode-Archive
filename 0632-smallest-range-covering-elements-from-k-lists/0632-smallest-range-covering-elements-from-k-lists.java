class Solution {
    public class Pair implements Comparable<Pair>{
        int val;
        int listno;
        int idx;
        Pair(int val,int listno,int idx)
        {
            this.val=val;
            this.listno=listno;
            this.idx=idx;
        }
        @Override
        public int compareTo(Pair o)
        {
            return this.val-o.val;
        }
        @Override
        public String toString(){
            return this.val+"";
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int largest=0;
        int[] ans=new int[2];
        int best=Integer.MAX_VALUE;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
         for(int i=0;i<nums.size();i++){
             
               pq.offer(new Pair(nums.get(i).get(0),i,0)); 
             largest=Math.max(largest,nums.get(i).get(0));
         }
        while(true){
            
           if(largest-pq.peek().val<best){
               best=largest-pq.peek().val;
               ans[0]=pq.peek().val;
               ans[1]=largest;
           }
            //System.out.println(Arrays.toString(ans)+" "+best+" "+largest+" "+pq.peek().val+" "+pq);
            Pair p=pq.poll();
            int lis=p.listno;
            int nextidx=p.idx+1;
            if(nums.get(lis).size()<=nextidx){
                
               break;
            }else{
              pq.offer(new Pair(nums.get(lis).get(nextidx),lis,nextidx));
               largest=Math.max(largest,nums.get(lis).get(nextidx)); 
            }
            
        }
        return ans;
    }
}