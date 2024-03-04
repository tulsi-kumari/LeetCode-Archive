class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left=0;
        int right=tokens.length-1;
        int mx=0;
        int score=0;
        while(left<=right)
        {
            if(tokens[left]<=power)
            {
                score++;
                mx=Math.max(mx,score);
                power-=tokens[left];
                left++;
            }else if(score>0)
            {
                power+=tokens[right];
                score--;
                right--;
            }else
            {
                break;
            }
        }
        return mx;
        
    }
    
}