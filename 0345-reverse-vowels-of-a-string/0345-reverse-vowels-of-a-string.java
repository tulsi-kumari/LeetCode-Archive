class Solution {
    public String reverseVowels(String s) {
        char[] arr=s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            while(i<=j &&!isVowel(arr[i])){
                i++;
            }
            while(j>=i&&!isVowel(arr[j])){
                j--;
            }
            if(i<=j){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        return String.valueOf(arr);
    }
    public boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            return true;
        }
        return false;
    }
    public void swap(char[] ch,int i,int j){
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
}