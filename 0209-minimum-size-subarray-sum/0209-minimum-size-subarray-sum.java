class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minCount=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int win=0;
        int winSum=0;
        while(i<nums.length){
            winSum+=nums[i];
            win++;
            if(winSum>=target){
                break;
            }
            i++;
        }
        
        
        if(winSum<target){
            return 0;
        }
        minCount=Math.min(win,minCount);
        //System.out.println(minCount+" "+i+" "+winSum);
        while(j<=i){
            while(j<=i && winSum-nums[j]>=target){
                
                win--;
                winSum-=nums[j];
                j++;
            }
            //System.out.println(minCount+" "+i+" "+winSum);
            minCount=Math.min(win,minCount);
            if(i<nums.length-1){
                i++;
                winSum+=nums[i];
                win++;
            }else{
                break;
            }
            
        }
        return minCount;
        
    }
}