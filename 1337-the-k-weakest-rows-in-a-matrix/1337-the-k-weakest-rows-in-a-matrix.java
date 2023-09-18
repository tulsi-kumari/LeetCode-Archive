class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] arr=new int[mat.length][2];
        for(int i=0;i<mat.length;i++)
        {
            int count=0;
            int j=0;
            while(j<mat[0].length && mat[i][j]==1)
            {
              count++;
                j++;
            }
            arr[i][0]=i;
            arr[i][1]=count;
        }
        Arrays.sort(arr,(a,b)-> a[1]-b[1]);
        int[] ans=new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i]=arr[i][0];
        }
        return ans;
        
        
    }
}