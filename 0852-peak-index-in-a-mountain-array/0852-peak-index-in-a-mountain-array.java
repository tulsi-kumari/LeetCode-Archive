class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int ret= BS(0,arr.length-1,arr);
        return ret;
    }
    public int BS(int s,int e,int[] arr){
        while(s<=e){
            int mid=s+(e-s)/2;
            int curr=arr[mid];
            //System.out.println(curr+" "+mid);
            //System.out.println(s+" "+e);
            if(mid>0 && mid<arr.length-1 && curr>arr[mid-1] && curr>arr[mid+1]){
               return mid; 
            }
            //System.out.println(curr);
            //if in increasing side
            if((mid>=arr.length-1 || curr<arr[mid+1])&&(mid<=0 || curr>mid-1)){
               s=mid+1;
            }else {
                e=mid-1;
            }
            //System.out.println(s+" "+e);
        
        }
        return s==arr.length?e:s;
    }
}