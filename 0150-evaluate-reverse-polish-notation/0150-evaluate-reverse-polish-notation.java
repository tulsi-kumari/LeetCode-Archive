class Solution {
    public int evalRPN(String[] tokens) {
         Stack<Integer> st=new Stack<>();
        for(String str:tokens){
            if(st.isEmpty()){
                st.push(Integer.parseInt(str));
        }else if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")){
                int f=st.pop();
                int s=st.pop();
                int val=0;
                if(str.equals("+")){
                  val=f+s;
                }else if(str.equals("-")){
                    val=s-f;
                }else if(str.equals("*")){
                    val=s*f;
                }else{
                    val=s/f;
                }

                st.push(val);
            }else{
                st.push(Integer.parseInt(str));
            }
        }

        return st.pop();
    }
}