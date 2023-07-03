class Solution {
    public boolean buddyStrings(String s, String goal) {
        int firstIdx =0;
        int secondIdx=0;
        if(s.length() !=goal.length()){
            return false;
        }
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=goal.charAt(i)){
                count++;
                if(count<=2){
                    if(count==1) firstIdx=i;
                    if(count==2) secondIdx=i;
                }else{
                    return false;
                }
            }
        }
        if(count==0){
            HashSet<Character> set=new HashSet<>();
            for(int i=0;i<s.length();i++){
                if(set.contains(s.charAt(i))){
                    return true;
                }
                set.add(s.charAt(i));
            }
            return false;
        }
        if(count>2){
            return false;
        }
        if(goal.charAt(firstIdx)==s.charAt(secondIdx) && goal.charAt(secondIdx)==s.charAt(firstIdx)){
            return true;
        }
        return false;
    }
}