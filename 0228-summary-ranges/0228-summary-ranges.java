class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        int i=0;
        int j=1;
        int n=nums.length;
         String temp="";
        while(j<n && i<n){
           while(j<n && (nums[j-1]+1==nums[j])){
               j++;  
           }
           if(j==i+1){
                temp="" + nums[i];
           }else{
               temp=""+ nums[i] +"->" + nums[j-1];
           }
           
           ans.add(temp);
            temp="";
            i=j;
            j=i+1;
        }
        if(j==n){
                if(i==n-1){
                    temp="" + nums[i];
                    ans.add(temp);
                }else{
                    temp="" + nums[i] +"->" + nums[j-1];
                    ans.add(temp);
                }
        }
        
        return ans;
    }
}