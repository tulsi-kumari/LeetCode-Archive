class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr=s.split(" ");
        if(arr.length!=pattern.length()){
            return false;
        }
        HashMap<Character,String> map=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        int j=0;
        int k=0;
        for(int i=0;i<pattern.length();i++){
            char p=pattern.charAt(i);
            String str="";
            while(j<s.length() && s.charAt(j)!=' '){
                j++;
            }
            str=s.substring(k,j);
            k=j+1;
            j=k;
            //System.out.println(p+" "+str);
            if(map.containsKey(p)){
                if(!map.get(p).equals(str)){
                    //System.out.println("here"+" "+ map+" "+set);
                    return false;
                }
            }else{
                if(set.contains(str)){
                    //System.out.println("hi"+" "+ map+" "+set);
                    return false;
                }
                set.add(str);
                map.put(p,str);
            }
        }
        // if(j<s.length()){
        //     return false;
        // }
        return true;
    }
}