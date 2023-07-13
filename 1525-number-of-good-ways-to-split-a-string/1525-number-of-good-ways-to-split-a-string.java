class Solution {
    
    public int numSplits(String s) {
        HashSet<Character> fset =new HashSet<>();
        HashSet<Character> lset =new HashSet<>(); 
        int[] f=new int[s.length()];
        int[] l=new int[s.length()];
       for(int i=0;i<s.length();i++){
           fset.add(s.charAt(i));
           f[i]=fset.size();
       }
        for(int i=s.length()-1;i>=0;i--){
           lset.add(s.charAt(i));
           l[i]=lset.size();
       }
        int ans=0;
        for(int i=0;i<s.length()-1;i++){
           if(f[i]==l[i+1]){ans++;}
       }
        return ans;
        
    }
}