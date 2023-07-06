class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        int i=0;
        Stack<Character> st=new Stack<>();
        while(i<n){
            if(s.charAt(i)=='('){
                st.push('(');
            }else{
                if(st.peek()=='('){
                    st.pop();
                    st.push('1');
                }else{
                    int x=0;
                    while(st.peek()!='('){
                        x+=st.pop()-'0';
                    }
                    st.pop();
                    st.push((char)('0'+(int)(2*x)));
                }
            }
            i++;
            //System.out.println(st);
        }
       int y=0;
        while(!st.isEmpty()){
            y+=st.pop()-'0';
        }
        return y;
       
    }
}