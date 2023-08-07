class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s=Arrays.stream(weights).max().getAsInt();
        int e=Arrays.stream(weights).sum();
        int ans=-1;
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            //System.out.println(s+" "+e+" "+mid);
            if(isPossible(mid,days,weights)){
                ans=mid;
                e=mid-1;
            }else
            {
                s=mid+1;  
            }
        }
        return ans;
    }
    public boolean isPossible(int weight,int days,int[] weights)
    {
        int curr=0;
        int sum=0;
        for(int i=0;i<weights.length;i++)
        {
            sum+=weights[i];
            if(sum>weight)
            {
                curr++;
                sum=weights[i];
            }
        }
        curr++;
        return curr<=days;
    }
}