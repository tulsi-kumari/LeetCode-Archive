class Solution {
    public boolean isAlienSorted(String[] word, String order) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        for(int i=0;i<word.length-1;i++){
            int j=0;int k=0;
            boolean flag=false;
            while(j<word[i].length() && k<word[i+1].length()){
                if(word[i].charAt(j)==word[i+1].charAt(k)){
                    j++;
                    k++;
                }else{
                    if(map.get(word[i].charAt(j))>map.get(word[i+1].charAt(k))){
                        return false;
                    }else{
                        flag=true;
                        break;
                    }
                }
            }
            
            if(!flag ){
                if(j<word[i].length()){
                    return false;
                }
            }
        }
        return true;
    }
}