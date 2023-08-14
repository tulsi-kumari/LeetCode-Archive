class Solution {
    public static int findKthLargest(int[] arr, int k) {
        return quickSelect(0,arr.length-1,k,arr);
    }
    public static int quickSelect(int left,int right,int k,int[] arr){
        if(left>right){
            return 0;
        }
        int s=left;
        int e=right;
        int mid=s+(e-s)/2;
        int pivot=arr[mid];
        while(s<e){
            while(arr[s]<=pivot&&mid!=s){
                s++;
            }
            while(arr[e]>pivot&&mid!=e){
                e--;
            }
            if(s<=e){
                if(s==mid){
                    mid=e;
                }else if(e==mid){
                    mid=s;
                }
                swap(s,e,arr);
            }
        }
        if(mid==arr.length-k){
            return pivot;
        }else if(mid<arr.length-k){
            return quickSelect(mid+1,right,k,arr);
        }
        return quickSelect(left,mid-1,k,arr);

    }
    public static void swap(int i,int j,int[] arr){
          int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}