class Solution {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        int[] leftMin=getleftminmin(nums);
        System.out.println(Arrays.toString(leftMin));
        Stack<Integer> st=new Stack<>();
        for(int j=n-1;j>=0;j--)
        {
            if(nums[j]>leftMin[j])
            {
               while(!st.isEmpty() && (st.peek()<=leftMin[j]))
               {
                   st.pop();
               }
                if(!st.isEmpty() && st.peek()<nums[j])
                {
                    return true;
                }
                st.push(nums[j]);
            }
        }
        return false;
    }
    
    public int[] getleftminmin(int[] nums){
        int[] ans=new int[nums.length];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<nums.length;i++){
                while(!st.isEmpty() && st.peek()>=nums[i]){
                    st.pop();
                }
                if(st.isEmpty()) {
                    ans[i]=Integer.MAX_VALUE;
                    st.push(nums[i]);
                }else if(st.peek()<nums[i]){
                    ans[i]=st.peek();
                }
            
        }
        return ans;
        
    }
//     public int[] getrightmaxmin(int[] nums){
//         int[] ans=new int[nums.length];
//         Stack<Integer> st=new Stack<Integer>();
//         for(int i=nums.length-1;i>=0;i--){
//             if(st.isEmpty()){
//                 ans[i]=Integer.MIN_VALUE;
//                 a=st.push(nums[i]);
//             }else {
//                 while(!st.isEmpty() && st.peek()>=nums[i]){
//                     st.pop();
//                 }
//                 if(st.isEmpty()) {
//                     ans[i]=Integer.MAX_VALUE;
//                     st.push(nums[i]);
//                 }else if(st.peek()<nums[i]){
//                     ans[i]=st.peek();
//                 }
//             }
//         }
//         return ans;       

//     }
}