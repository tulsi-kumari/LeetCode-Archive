class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int j=piles.length-2;;
        int nop=piles.length/3;
        int ans=0;
        while(nop!=0)
        {
            ans+=piles[j];
            j-=2;
            nop--;
        }
        return  ans;
    }
}