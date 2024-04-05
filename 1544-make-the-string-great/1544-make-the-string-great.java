class Solution {
    public String makeGood(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(st.isEmpty())
            {
                st.push(ch);
            }else
            {
                if(st.peek()-'A'==ch-'a'||st.peek()-'a'==ch-'A')
                {
                    st.pop();
                }else{
                    st.push(ch);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
        {
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }
}