class Solution {
    public boolean isMonotonic(int[] nums) {
        if(isInc(nums)||isDec(nums))
        {
          return true;
        }
        return false;
    }
    public boolean isInc(int[] arr)
    {
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<arr[i-1])
            {
                return false;
            }
                
        }
        return true;
    }
    public boolean isDec(int[] arr)
    {
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>arr[i-1])
            {
                return false;
            }
                
        }
        return true;
    }
}