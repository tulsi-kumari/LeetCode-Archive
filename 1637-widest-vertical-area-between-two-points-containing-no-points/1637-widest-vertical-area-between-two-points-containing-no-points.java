class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,new Comparator<int[]>(){
           public int compare(int[] o1,int[] o2)
           {
               if(o1[0]<o2[0])
               {
                   return -1;
               }else if(o1[0]>o2[0])
               {
                   return 1;
               }else
               {
                   return 0;
               }
           }
        });
        int max=Integer.MIN_VALUE;
        int i=1;
        while(i<points.length)
        {
            max=Math.max(max,points[i][0]-points[i-1][0]);
            i++;
        }
        return max;
    }
}