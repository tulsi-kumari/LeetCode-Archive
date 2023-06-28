class Solution {
    public int minAddToMakeValid(String s) {
        int ans=0;
        int op=0;
        int clos=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                op++;
            }else{
                clos++;
                if(clos>op){
                    ans+=clos-op;
                    op+=clos-op;
                }
                
            }
            //System.out.println(op+" "+clos);
        }
        ans+=op-clos;
        return ans;
    }
}