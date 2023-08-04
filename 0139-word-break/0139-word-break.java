class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] t=new int[s.length()];
        Arrays.fill(t,-1);
        return help(s,0, wordDict,t);
        
    }
    public boolean help(String s,int st,List<String> wordDict,int[] t){
       if(s==""){
           t[st-1]=1;
           return true;
       }
       if(t[st]!=-1){
           if(t[st]==1){
               return true;
           }
           return false;
       }
       for(int j=0;j<wordDict.size();j++){
           if(s.startsWith(wordDict.get(j))){
               s=s.substring(wordDict.get(j).length());
               if(help(s,st+wordDict.get(j).length(),wordDict,t)){
                    t[st]=1;
                    return true;
               }else{
                   t[st]=0;
               }
               s=wordDict.get(j)+s;
           }
       }
       t[st]=0;
       return false;
    }
}