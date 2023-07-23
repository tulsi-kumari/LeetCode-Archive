class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix=new int[arr.length+1];
        int[] ans=new int[queries.length];
        int xor=0;
        prefix[0]=0;
        for(int i=1;i<=arr.length;i++){
            prefix[i]=xor^arr[i-1];
            xor=prefix[i];
        }
        int j=0;
        for(int[] query:queries){
            ans[j]=prefix[query[1]+1]^prefix[query[0]];
            j++;
        }
        return ans;
    }
}