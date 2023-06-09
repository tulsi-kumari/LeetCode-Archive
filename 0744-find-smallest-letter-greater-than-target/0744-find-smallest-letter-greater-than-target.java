class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        return help(0,letters.length,target,letters);
    }
    public char help(int s,int e,char target,char[] letters){
        while(s<letters.length && s<=e && e>=0){
            int mid=s+(e-s)/2;
            if(letters[mid]<target){
                s=mid+1;
            }else if(letters[mid]>target){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        
       
        return letters[s%letters.length];
    }
}