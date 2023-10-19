class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack=new Stack<>();
        for(int i=0; i<s.length() ; i++){
            if(s.charAt(i)!='#'){
                stack.push(s.charAt(i));
            }else{
                if(!stack.isEmpty()) stack.pop();
            }
        }
        String s_new="";
        while(!stack.isEmpty()){
            s_new+=stack.pop();
        }
        Stack<Character> stack1=new Stack<>();
        for(int i=0; i<t.length() ; i++){
            if(t.charAt(i)!='#'){
                stack1.push(t.charAt(i));
            }else{
                if(!stack1.isEmpty()) stack1.pop();
            }
        }
        String t_new="";
        while(!stack1.isEmpty()){
            t_new+=stack1.pop();
        }  
        return s_new.equals(t_new); 
    }
}