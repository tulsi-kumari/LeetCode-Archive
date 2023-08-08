class Solution {
    public int search(int[] arr, int target) {
     int s=0;
        int e=arr.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]>=arr[0]){
                if(target<arr[mid]&&target>=arr[0]){
                    return BS(arr,0,mid,target);
                }else{
                    s=mid+1;
                }
            }else{
                if(target<arr[mid]){
                    e=mid-1;
                }else if(target>arr[mid]&&target>arr[arr.length-1]){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }
        }
        return -1;   
    }
     private static int BS(int[] arr,int s,int e,int target){
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]>target){
                e=mid-1;
            } else if (arr[mid]<target) {
                s=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}