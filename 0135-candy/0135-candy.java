class Solution {
    public int candy(int[] ratings) {
        int i=0,n=ratings.length;
        
        int[] candies=new int[n];
        int prev=-1;
        while(i<n)
        {
          if(i==0)
          {
            candies[i]=1;
              prev=1;
          }else
          {
              if(ratings[i]<=ratings[i-1])
              {
                  candies[i]=1;
                  prev=1;
              }else
              {
                  candies[i]=prev+1;
                  prev++;
              }
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