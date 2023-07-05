class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int[] rightmin=new int[n+1];
        rightmin[n]=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            rightmin[i]=Math.min(arr[i],rightmin[i+1]);
        }
        int k=0;
        int chunks=0;
        
        int lm=0;
        while(k<n){
            lm=Math.max(lm,arr[k]);
            if(lm<=rightmin[k+1]){
                chunks++;
            }
            k++;
        }
        return chunks;
    }
}