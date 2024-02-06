class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         Map<String,ArrayList<String>> mp=new HashMap<>();


        for(int i=0;i<strs.length;i++){
            char[] c=strs[i].toCharArray();
            Arrays.sort(c);
            String s=new String(c);
            if(mp.containsKey(s)){
                mp.get(s).add(strs[i]);
            }else{
                mp.put(s,new ArrayList<String>());
                mp.get(s).add(strs[i]);
            }

        }

        List<List<String>> ans=new ArrayList<>();

        for(Map.Entry<String,ArrayList<String>> e:mp.entrySet()){
            ans.add(e.getValue());
        }

        return ans;
    }
}