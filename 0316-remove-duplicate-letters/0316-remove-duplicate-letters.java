class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        boolean[] vis=new boolean[26];
        for (char ch:s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<s.length())
        {
            map.put(s.charAt(i),map.get(s.charAt(i))-1);
            if(vis[s.charAt(i)-'a'])
            {
                i++;
                continue;
            }
         if(st.isEmpty())
         {
             st.push(s.charAt(i));
             vis[s.charAt(i)-'a']=true;
             
         }else
         {
             char curr=s.charAt(i);
             char prev=st.peek();
             while(!st.isEmpty() && (int)prev>(int)curr)
             {
                 if(map.get(prev)>=1)
                 {
                     st.pop();
                     vis[prev-'a']=false;
                     if(!st.isEmpty()) prev=st.peek();
                 }else
                 {
                     break;
                 }
             }
             if(!vis[curr-'a'])
             {
                 st.push(curr);
                 vis[curr-'a']=true;
             }
             
         }
            i++;
        }
        char[] ans=new char[st.size()];
        int j=st.size()-1;
        while(j>=0) ans[j--]=st.pop();
        return new String(ans);
    }
}