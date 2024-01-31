class Solution {
    
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st=new Stack<>();
        int n=temp.length;
        int[] ans=new int[n];
        int i=n-1;
        while(i>=0)
        {
            if(st.isEmpty())
            {
                ans[i]=0;
            }else
            {
                int curr=temp[i];
                while(!st.isEmpty() && temp[st.peek()]<=curr) st.pop();
                if(st.isEmpty())
                {
                    ans[i]=0;
                }else
                {
                    ans[i]=st.peek()-i;
                }
            }
            st.push(i);
            i--;
        }
        return ans;
    }
}