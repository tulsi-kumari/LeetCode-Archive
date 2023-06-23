class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>[] arrMap=new HashMap[n];
        for(int i=0;i<n;i++){
            arrMap[i]=new HashMap<Integer,Integer>();
        }
        int ans=2;
        
        for(int i=1;i<n;i++){
          for(int j=0;j<i;j++){
             int diff=nums[i]-nums[j];
              if(arrMap[j].containsKey(diff)){
                  arrMap[i].put(diff,arrMap[j].get(diff)+1);
                  ans=Math.max(ans,arrMap[i].get(diff));
              }else{
                 arrMap[i].put(diff,2);
              }
          }
        }
        
        return ans;
    }
}