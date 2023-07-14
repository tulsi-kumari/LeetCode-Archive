class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Arrays.stream(piles).max().getAsInt();
        if(h==piles.length){
            return max;
        }
        
        int n=piles.length;
        int s=1;
        int e=max;
        int ans=Integer.MAX_VALUE;
        while(s<=e){
            int mid=s+(e-s)/2;
            
            long currtime=0;
            //System.out.println(mid);
            
                for(int i:piles){
                    currtime+=(i%mid==0?i/mid:i/mid+1);
                    
                }
            
             //System.out.println(mid+" "+currtime);
            if(currtime>h){
                s=mid+1;
            }else{
                ans=Math.min(ans,mid);
                e=mid-1;
            }
        }
        return ans;
    }
//     int left = 1;
//         int right = Integer.MIN_VALUE;
//         for(int pile : piles){
//             right = Math.max(right,pile);
//         }
//         while(left < right){
//             int mid = left + (right - left)/2;
//             int time = 0;
//             for(int pile : piles){
//                 time += pile % mid == 0 ? pile/mid : (pile/mid)+1;
//             }
//             if(time > h){
//                 left = mid+1;
//             }else{
//                 right = mid;
//             }
//         }

//         return left;
}