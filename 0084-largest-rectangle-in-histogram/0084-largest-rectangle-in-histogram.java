class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] leftsm=leftSmall(heights);
        int[] rightsm=rightSmall(heights);
        //System.out.println(Arrays.toString(leftsm));
        //System.out.println(Arrays.toString(rightsm));
        int max=0;
        for(int i=0;i<heights.length;i++){
            int width=rightsm[i]-(leftsm[i]+1);
            int height=heights[i];
            int size=width*height;
            max=Math.max(size,max);
        }
        return max;
    }
    public int[] leftSmall(int[] heights){
        int[] ans=new int[heights.length];
        Stack<Integer> st=new Stack<>();
        int i=0;
        while(i<heights.length){
            
            if(st.isEmpty()){
                ans[i]=-1;
                st.push(i);
            }else{
                while(heights[st.peek()]>=heights[i]){
                    st.pop();
                    if(st.isEmpty()){
                        ans[i]=-1;
                        st.push(i);
                        break;
                    }
                }
                if(st.peek()!=i){
                    ans[i]=st.peek();
                    st.push(i);
                }
            }
            //System.out.println(st);
            i++;
        }
        return ans;
    }
    public int[] rightSmall(int[] heights){
        int n=heights.length;
        int[] ans=new int[heights.length];
        Stack<Integer> st=new Stack<>();
        int i=n-1;
        while(i>=0){
            
            if(st.isEmpty()){
                ans[i]=n;
                st.push(i);
            }else{
                while(heights[st.peek()]>=heights[i]){
                    st.pop();
                    if(st.isEmpty()){
                        ans[i]=n;
                        st.push(i);
                        break;
                    }
                }
                if(st.peek()!=i){
                    ans[i]=st.peek();
                    st.push(i);
                }
            }
            i--;
        }
        return ans;
    }
}