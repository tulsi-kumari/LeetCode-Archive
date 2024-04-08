class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<students.length;i++)
        {
            q.offer(students[i]);
        }
        
        Stack<Integer> st=new Stack<>();
        for(int i=sandwiches.length-1;i>=0;i--)
        {
            st.push(sandwiches[i]);
        }
        
        while(!q.isEmpty())
        {
            int curr=st.peek();
            int size=q.size();
            boolean canEat=false;
            while(size-->0)
            {
                int poll=q.poll();
                if(poll==curr)
                {
                    st.pop();
                    canEat=true;
                    break;
                }else
                {
                    q.offer(poll);
                }
            }
            if(!canEat) break;
        }
        
        return q.size();
        
    }
}