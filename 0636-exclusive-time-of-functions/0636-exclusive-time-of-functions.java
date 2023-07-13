class Solution {
    public class Pair{
        int id;
        int s;
        int mid;
        Pair(int id,int s,int mid){
          this.id=id;
            this.s=s;
            this.mid=mid;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans=new int[n];
        //make stack
        Stack<Pair> st=new Stack<>();
        for(String log:logs){
            int type=getType(log);
            int idx=getId(log);
            int time=getTime(log);
            //0-start
            //1-end
            if(type==0){
                st.push(new Pair(idx,time,0));
            }else{
                if(st.peek().id==idx){
                    int curr=time-st.peek().s+1;
                    ans[idx]+=(curr-st.peek().mid);
                    st.pop();
                    if(!st.isEmpty()){
                        st.peek().mid+=curr;
                    }
                }
            }
        }
        return ans;
    }
    public int getType(String log){
        int fi=log.indexOf(':');
        if(log.charAt(fi+1)=='s'){
            return 0;
        }
        return 1;
    }
    public int getId(String log){
        return Integer.valueOf(log.substring(0,log.indexOf(':')));
    }
    public int getTime(String log){
        int fi=log.indexOf(':');
        int si=log.indexOf(':',fi+1);
        return Integer.valueOf(log.substring(si+1,log.length()));
    }
}