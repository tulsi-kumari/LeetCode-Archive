class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> mp=new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> e:mp.entrySet()){
            if(e.getValue()==1){
                return s.indexOf(e.getKey());
            }
        }
        return -1;
    }
}