class Solution {
    
    public int findMin(int[] arr) {
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid!=0){
                if(arr[mid]<arr[mid-1]){
                    return arr[mid];
                }
            }
            if(arr[mid]>=arr[0]){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return arr[0];
    }
}