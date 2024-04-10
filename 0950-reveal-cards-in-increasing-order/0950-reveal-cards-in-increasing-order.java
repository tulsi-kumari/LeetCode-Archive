class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n=deck.length;
        int[] ans=new int[n];
        
        int i=0;
        boolean flag=false;
        int j=0;
        while(i<n)
        {
            if(ans[j]==0)
            {
                if(!flag)
                {
                    ans[j]=deck[i];
                    i++;  
                }
                flag=!flag;
            }
            
            j=(j+1)%n;
        }
        return ans;
    }
}