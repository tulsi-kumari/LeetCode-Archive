class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] arr=new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            arr[i]=matrix[0][i]=='1'?1:0;
        }
        //System.out.println(Arrays.toString(arr));
        int ans=0;
        for(int i=1;i<=matrix.length;i++){
            
            
            int curr=maximumAreaOfHistogram(arr);
            ans=Math.max(ans,curr);
            //System.out.println(Arrays.toString(arr) +" "+curr);
            
           
            if(i!=matrix.length){
                for(int j=0;j<matrix[i].length;j++){
                   if(matrix[i][j]=='0'){
                       arr[j]=0;
                   }else{
                       arr[j]+=1;
                   }
                     //System.out.println(i +" "+j+" " + arr[j]);
               }
            }
            
            
        }
        return ans;
    }
    public int maximumAreaOfHistogram(int[] arr){
        int n=arr.length;
        int[] leftsm=leftsmall(arr);
        int[] rightsm=rightsmall(arr);
        // System.out.println(Arrays.toString(arr));
        //  System.out.println(Arrays.toString(leftsm));
        //  System.out.println(Arrays.toString(rightsm));
        System.out.println();
        int ans=0;
        for(int i=0;i<n;i++){
            int width=rightsm[i]-leftsm[i]-1;
            int height=arr[i];
            ans=Math.max(ans,width*height);
        }
        return ans;
    }
    public int[] leftsmall(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        int i=0;
        while(i<n){
            if(st.isEmpty()){
                ans[i]=-1;
                st.push(i);
            }else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i]=-1;
                    st.push(i);
                }else{
                    ans[i]=st.peek();
                    st.push(i);
                }
            }
            i++;
        }
        return ans;
    }
    public int[] rightsmall(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        int i=n-1;
        while(i>=0){
            if(st.isEmpty()){
                ans[i]=n;
                st.push(i);
            }else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i]=n;
                    st.push(i);
                }else{
                    ans[i]=st.peek();
                    st.push(i);
                }
            }
            i--;
        }
        return ans;
    }
    
}