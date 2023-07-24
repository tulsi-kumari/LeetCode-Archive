class Solution {
    public class Pair implements Comparable<Pair>{
        int x;
        int idx;
        Pair(int x,int idx){
            this.x=x;
            this.idx=idx;
        }
        @Override
        public int compareTo(Pair o){
            if(o.x!=this.x){
                return o.x-this.x;
            }else{
                return o.idx-this.idx;
            }
        }
    }
    public int maximumSwap(int num) {
        String s=""+num;
        PriorityQueue<Pair> q=new PriorityQueue<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            q.add(new Pair(ch-'0',i));
        }
        boolean visited[]=new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            while(visited[q.peek().idx]){
                q.poll();
            }
            if(q.peek().x>ch-'0'){
                Pair p=q.poll();
                return Integer.parseInt(swap(i,p.idx,s));
            }
            visited[i]=true;
        }
        return num;
    }
    public String swap(int i,int j,String s){
        char f=s.charAt(i);
        char sec=s.charAt(j);
        s=s.substring(0,i)+sec+s.substring(i+1,j)+f+s.substring(j+1,s.length());
        return s;
    }
}