class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        Stack<Character> st=new Stack<>();
        char[] nums=num.toCharArray();
        for(char ch:nums){
            if(st.isEmpty()){
                st.push(ch);
            }else{
                while(!st.isEmpty() && (st.peek()-'0'>ch-'0') && k>0){
                    st.pop();
                    k--;
                    
                }
                
                st.push(ch);
            }
            //System.out.println(st);
             
        }
        if(k!=0){
          while(k!=0){
              st.pop();
              k--;
          }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        String ans=sb.toString();
        int i=0;
        while(i<ans.length()&&ans.charAt(i)=='0'){
            i++;
        }
        if(i==ans.length()){
            return "0";
        }
        return ans.substring(i,ans.length());
        
    }
}