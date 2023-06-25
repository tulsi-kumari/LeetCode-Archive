class Solution {
    public class Pair{
        int x;
        int gap;
        Pair(int x,int gap){
            this.x=x;
            this.gap=gap;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Pair[] pairArr=new Pair[arr.length];
        for(int i=0;i<arr.length;i++){
            pairArr[i]=new Pair(arr[i],Math.abs(x-arr[i]));
        }
        Queue<Pair> q=new PriorityQueue<>(k,new Comparator<Pair>(){
           public int compare(Pair o1,Pair o2){
               if(o1.gap>o2.gap){
                   return -1;
               }else if(o1.gap<o2.gap){
                   return 1;
               }else{
                   if(o1.x<o2.x){
                       return 1;
                   }else if(o1.x>o2.x){
                       return -1;
                   }else{
                       return 0;
                   }
               }
           }
        });
        for(int i=0;i<k;i++){
            q.offer(pairArr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(q.peek().gap>pairArr[i].gap){
               q.poll();
               q.offer(pairArr[i]);
            }else if(q.peek().gap==pairArr[i].gap && q.peek().x>pairArr[i].x){
                q.poll();
                q.offer(pairArr[i]);
            }
        }
        
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().x);
        }
        Collections.sort(ans);
        return ans;
        
        
    }
}