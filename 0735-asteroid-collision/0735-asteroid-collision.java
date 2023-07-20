class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        int i=0;
        while(i<asteroids.length){
            int num=asteroids[i];
            if(st.isEmpty()){
                st.push(num);
            }else{
               if(st.peek()>=0  && num<0){
                  if(Math.abs(st.peek())==Math.abs(num)){
                      st.pop();
                  }else if(Math.abs(st.peek())<Math.abs(num)){
                      while(!st.isEmpty() && st.peek()>=0  && num<0 && Math.abs(st.peek())<Math.abs(num)){
                          st.pop();
                      }
                      if(st.isEmpty()){
                          st.push(num);
                      }else if(Math.abs(st.peek())==Math.abs(num) && st.peek()>0 && num<0){
                          st.pop();
                      }else if(st.peek()*num>0){
                          st.push(num);
                      }
                      
                  }
               }else{
                   st.push(num);
               } 
                
            }
            i++;
        }
        int n=st.size();
        int[] ans=new int[n];
        for(int j=n-1;j>=0;j--){
            ans[j]=st.pop();
        }
        return ans;
    }
}