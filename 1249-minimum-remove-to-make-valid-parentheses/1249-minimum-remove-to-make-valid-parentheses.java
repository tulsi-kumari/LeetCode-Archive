class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(i);
            }else if(ch==')'){
                if(st.isEmpty()){
                    st.push(i);
                }else if(s.charAt(st.peek())=='('){
                    st.pop();
                }else{
                    st.push(i);
                }
            }
        }
        char[] ch=s.toCharArray();
        while(!st.isEmpty()){
            int popped=st.pop();
            ch[popped]='.';
        }
        String ans="";
        for(int i=0;i<ch.length;i++){
            if(ch[i]!='.') ans+=ch[i];
        }
        return ans;
    }
}