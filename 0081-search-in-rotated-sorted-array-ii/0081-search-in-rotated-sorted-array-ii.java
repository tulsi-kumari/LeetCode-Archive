class Solution {
    public boolean search(int[] arr, int target) {
        int s=0;
        int e=arr.length-1;
        while(s<=e)
        {
            
            int mid=s+(e-s)/2;
            if(arr[mid]==target)
            {
                return true;
            }
            System.out.println(s+" "+e+" "+mid);
            if( arr[mid]==arr[s]&&arr[mid]==arr[e])
            {
                s++;
                e--;
                continue;
            }
            //correct part
           if(arr[s]<=arr[mid])
           {
               if(target>=arr[s]&&target<arr[mid])
               {
                   e=mid-1;
               }else
               {
                   s=mid+1;
               }
           }else
           {
               if(target>=arr[s])
               {
                  e=mid-1;
               }else if(target<arr[mid])
               {
                   e=mid-1;
               }else
               {
                   s=mid+1;
               }
           }
        }
        return false;
    }
}