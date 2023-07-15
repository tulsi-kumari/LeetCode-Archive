class Solution {
    public class Pair implements Comparable<Pair>{
        int s;
        int e;
        int p;
        Pair(int s,int e,int p){
          this.s=s;
            this.e=e;
            this.p=p;
        }
        @Override
        public int compareTo(Pair o){
          if(this.s<o.s){
              return -1;
          }else if(this.s>o.s){
              return 1;
          }else{
              return 0;
          }
        }
    }
    public int maxValue(int[][] events, int k) {
        ArrayList<Pair> arr=new ArrayList<>();
        for(int[] event:events){
            arr.add(new Pair(event[0],event[1],event[2]));
        }
        Collections.sort(arr);
        int n=events.length;
        HashMap<String,Integer> dp=new HashMap<>();
        
        return solve(0,arr,-1,k,dp);
    }
    public int solve(int i,ArrayList<Pair> arr,int prev,int k,HashMap<String,Integer> dp){

        if(i>=arr.size()||k<=0){
            return 0;
        }
        String key=""+i+"#"+prev+"#"+k;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int f=Integer.MIN_VALUE;
        int s=Integer.MIN_VALUE;
        if(prev==-1){
            f=arr.get(i).p+solve(i+1,arr,i,k-1,dp);
            s=solve(i+1,arr,prev,k,dp);
        }else{
            Pair pre=arr.get(prev);
            Pair curr=arr.get(i);
            if(curr.s>pre.e){
                f=curr.p+solve(i+1,arr,i,k-1,dp);
                s=solve(i+1,arr,prev,k,dp);
            }else{
                s=solve(i+1,arr,prev,k,dp);
            }
        }
        //System.out.println(prev+" "+i+" "+f+" "+s);
        dp.put(key,Math.max(f,s));
        return Math.max(f,s);
    }
    
}