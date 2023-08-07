class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int f=tops[0];
        int s=bottoms[0];
        int getnorof=make(f,tops,bottoms);
        int getnoros=make(s,bottoms,tops);
        int getrof=make(s,tops,bottoms);
        int getros=make(f,bottoms,tops);
        int ans=Math.min(getnorof,Math.min(getnoros,Math.min(getrof,getros)));
       return  ans==Integer.MAX_VALUE?-1:ans;
    }
    public int make(int x,int[] make,int[] opp)
    {
        int ro=0;
        for(int i=0;i<make.length;i++)
        {
            if(make[i]==x)
            {
                
            }else if(opp[i]==x)
            {
                ro++;
            }else{
               return Integer.MAX_VALUE;
            }
        }
        return ro;
    }
}