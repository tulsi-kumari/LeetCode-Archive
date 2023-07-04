class Solution {
    public int singleNumber(int[] arr) {
        long ans=0;
        int round=0;
        int[] nums=new int[arr.length];
        for(int i=0;i<nums.length;i++){
                nums[i]=Math.abs(arr[i]);
            }
        while(true){
            boolean flag=false;
            int count=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0){
                    flag=true;
                }
                if((nums[i]&1)!=0){
                    count++;
                }
                nums[i]/=2;
            }
            if(flag==false){
                break;
            }
            if(count%3!=0){
                ans+=(long)Math.pow(2,round);
            }
            round++;
        }
       // System.out.println(ans);
        long neg=-ans;
        int negCount=0;
        for(int i=0;i<nums.length;i++){
                if(arr[i]==neg){
                    negCount++;
                }
        }
        //System.out.println(neg + " " + negCount);
        if(negCount%3!=0){
            return (int)neg;
        }else{
            return (int)ans;
        }
    }
}