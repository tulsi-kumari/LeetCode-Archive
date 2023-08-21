class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i=1;i<=s.length()/2;i++)
        {
            String prev=s.substring(0,i);
            int len=prev.length();
            if(prev.equals(s.substring(i,i+len)))
            {
                //System.out.println(prev+" ");
                if(check(prev,s))
                {
                    return true;
                }
            }
            
        }
        return false;
    }
    public boolean check(String small,String s)
    {
        String temp=s;
        while(temp.length()!=0)
        {
            //System.out.println(temp+" ");
            if(temp.length()<small.length())
            {
                return false;
            }
           if(temp.substring(0,small.length()).equals(small))
           {
              temp=temp.substring(small.length());
           }else{
               return false;
           }
        }
        return true;
    }
}