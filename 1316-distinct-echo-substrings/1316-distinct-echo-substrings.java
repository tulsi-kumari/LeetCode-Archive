class Solution {
    HashSet<String> set;
    public int distinctEchoSubstrings(String text) {
        set=new HashSet<>();
        func(0,text);
        System.out.println(set);
        return set.size();
    }
    public void func(int i,String text){
        if(i>=text.length()){
            return;
        }
        isValid(text.substring(i,text.length()));
        func(i+1,text);
    }
    public void isValid(String s){
        for(int i=1;i<=s.length()/2;i++){
            String fir=s.substring(0,i);
            String sec=s.substring(i,2*i);
            if(fir.equals(sec)){
                if(!set.contains(fir)){
                    set.add(fir);
                }
            }
        }
    }
}