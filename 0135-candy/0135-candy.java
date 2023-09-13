class Solution {
    public int candy(int[] ratings) {
        int i=1,n=ratings.length;
        
        int[] candies=new int[n];
        candies[0]=1;
        while(i<n)
        {
            if(ratings[i]>ratings[i-1])
            {
                candies[i]=candies[i-1]+1;
            }else
            {
                candies[i]=1;
            }
            i++;
        }
        System.out.println(Arrays.toString(candies));
        i=n-2;
        while(i>=0)
        {
            if(ratings[i]>ratings[i+1])
            {
                if(candies[i]<=candies[i+1])
                {
                    candies[i]=candies[i+1]+1;
                }
            }
            i--;
        }
        System.out.println(Arrays.toString(candies));
        int ans=Arrays.stream(candies).sum();
        return ans;
    }
}