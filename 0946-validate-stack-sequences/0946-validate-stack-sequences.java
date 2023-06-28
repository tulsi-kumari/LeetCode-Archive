class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int currIdx=0;
        Stack<Integer> st=new Stack<>();
        st.push(pushed[0]);
        int i=1;
        while(currIdx<popped.length){
            //System.out.println(st);
            while(i<pushed.length && (st.isEmpty() || st.peek()!=popped[currIdx]) ){
                st.push(pushed[i]);
                i++;
            }
            //System.out.println(st);
            if(i==pushed.length && st.peek()!=popped[currIdx]){
                return false;
            }
            st.pop();
            currIdx++;
        }
        if(currIdx==popped.length && st.isEmpty()){
            return true;
        }
        return false;
    }
}