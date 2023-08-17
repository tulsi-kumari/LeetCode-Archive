class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] leftbig=new int[n];
        int[] rightbig=new int[n];
        
        int max=0;
        for(int i=0;i<n;i++)
        {
            if(height[i]>max)
            {
                max=height[i];
            }
            leftbig[i]=max;
        }
        max=0;
        for(int i=n-1;i>=0;i--)
        {
            if(height[i]>max)
            {
                max=height[i];
            }
            rightbig[i]=max;
        }
        
        int water=0;
        for(int j=0;j<n;j++)
        {
            int min=Math.min(leftbig[j],rightbig[j]);
            water+=min-height[j];
        }
        return water;
        
        
        
        
//          int water=0;
//         int left=0,right=height.length-1,maxLeft=0,maxRight=0;
//         while(left<=right){
//             if(height[left]<=height[right]){
//                 if(height[left]>=maxLeft){
//                     maxLeft=height[left];
//                 }else {
//                     water+=maxLeft-height[left];
//                 }
//                 left++;
//             }else{
//                 if(height[right]>=maxRight){
//                     maxRight=height[right];
//                 }else{
//                     water+=maxRight-height[right];
//                 }
//                 right--;
//             }
//         }


//         return water;
    }
}