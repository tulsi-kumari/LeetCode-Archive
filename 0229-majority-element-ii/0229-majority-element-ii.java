class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int major1=nums[0];
        int cnt1=1;
        int major2=nums[0];
        int cnt2=0;
        for(int i=1;i<nums.length;i++){
            int curr=nums[i];
            if(curr==major1||curr==major2){
                if(curr==major1){
                    cnt1++;
                }else{
                    cnt2++;
                }
            }else{
                if(cnt1==0||cnt2==0){
                    if(cnt1==0){
                        cnt1=1;
                        major1=nums[i];
                    }else{
                        cnt2=1;
                        major2=nums[i];
                    }
                }else{
                    cnt1--;
                    cnt2--;
                }
            }
        }
        //System.out.println(major1+" "+major2);
        List<Integer> ans=new ArrayList<>();
        if(major(major1,nums)){
            ans.add(major1);
        }
        if(major(major2,nums) && major1!=major2){
            ans.add(major2);
        }
        return ans;
    }
    public boolean major(int x,int[] arr){
        int cnt=0;
        for(int i:arr){
            if(i==x){
                cnt++;
            }
        }
        return cnt > Math.floor(arr.length/3) ;
    }
}