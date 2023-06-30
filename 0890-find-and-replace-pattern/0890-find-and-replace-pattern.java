class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans=new ArrayList<>();
        for(String word:words){
            if(isMatch(pattern,word)){
                ans.add(word);
            } 
        }
        return ans;
    }
    public boolean isMatch(String word,String pattern){
      HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            char w=word.charAt(i);
            char p=pattern.charAt(i);
            // System.out.println(w);
            // System.out.println(p);
            if(map.containsKey(w)){
                if(map.get(w)!=p){
                    return false;
                }
            }else{
                if(set.contains(p)){
                    return false;
                }
                set.add(p);
                map.put(w,p);
            }
        }
        // System.out.println(set);
        // System.out.println(map);
        return true;
    }
}