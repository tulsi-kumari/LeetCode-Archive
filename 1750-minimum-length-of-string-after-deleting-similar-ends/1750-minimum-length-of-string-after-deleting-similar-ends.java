class Solution {
    public int minimumLength(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right)
        {
            int start=s.charAt(left);
            int end=s.charAt(right);
            if(start!=end) break;
            
            while(left<=right && s.charAt(left)==start)
            {
                left++;
            }
            while(left<=right&&s.charAt(right)==end)
            {
                right--;
            }
        }
        return right-left+1;
    }
}