class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> temp=new ArrayList<>();
        if(digits.length()==0){
            return temp;
        }
        return helper(digits,"");
    }
     public List<String> helper(String up,String p){
         if(up.length()==0){
             List<String> temp=new ArrayList<>();
             temp.add(new String(p));
             return temp;
         }
         List<String> ans=new  ArrayList<>();
         char ch=up.charAt(0);
         up=up.substring(1);
         if(ch-'0'<7){
             for(int i=(((ch-'0')-2)*3)+1;i<(((ch-'0')-2)*3)+4;i++){
                ans.addAll( helper(up,p+(char)(i-1+'a')));
             }
         }else if(ch=='7'){
         for(int i=16;i<20;i++){
             ans.addAll( helper(up,p+(char)(i-1+'a')));
         }
         }else if(ch=='8'){
           for(int i=20;i<23;i++){
             ans.addAll( helper(up,p+(char)(i-1+'a')));
         }
         }else{
            for(int i=23;i<27;i++){
             ans.addAll( helper(up,p+(char)(i-1+'a')));
         }
         }
         return ans;
     }
}