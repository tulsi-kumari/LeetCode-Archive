class Solution {
    public String reversePrefix(String word, char ch) {
        boolean ispresent=false;
        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)==ch){
                ispresent=true;
                break;
            }
        }
        if(!ispresent) return word;
        StringBuilder sb=new StringBuilder();
        int k=0;
        while(word.charAt(k)!=ch)
        {
            sb.append(word.charAt(k));
            k++;
        }
        sb.append(ch);
        sb.reverse();
        String sbs=sb.toString();
        return sbs+word.substring(k+1,word.length());
    }
}