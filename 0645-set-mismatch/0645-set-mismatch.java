class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans=new int[]{0,0};
        int xor=0;
        for(int i=1;i<=nums.length;i++)
        {
            int curr=nums[i-1];
            xor=xor^i;
            xor=xor^curr;
        }
        int rsb=(((xor- 1)^(xor))&xor);
        int x=0;
        int y=0;
        for(int i=1;i<=nums.length;i++)
        {
            if((rsb&i)==0)
            {
                x=x^i;
            }else
            {
                 y=y^i;
            }
        }
        for(int num:nums)
        {
            if((rsb&num)==0)
            {
                x=x^num;
            }else{
                y=y^num;
            }
        }
        if (contains(nums, x)) {
            return new int[]{x, y};
        } else {
            return new int[]{y, x};
        }
    }

    private boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

//     public int[] findErrorNums(int[] nums) {
//         int missXORRep = 0;

//         for (int i = 0; i < nums.length; i++) {
//             missXORRep ^= nums[i];
//         }

//         for (int i = 1; i <= nums.length; i++) {
//             missXORRep ^= i;
//         }

//         int lastDig = (((missXORRep - 1) ^ (missXORRep)) & missXORRep);

//         int num1 = 0, num2 = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if ((lastDig & nums[i]) != 0) {
//                 num1 ^= nums[i];
//             } else {
//                 num2 ^= nums[i];
//             }
//         }

//         for (int i = 1; i <= nums.length; i++) {
//             if ((i & lastDig) != 0) {
//                 num1 ^= i;
//             } else {
//                 num2 ^= i;
//             }
//         }

//         if (contains(nums, num1)) {
//             return new int[]{num1, num2};
//         } else {
//             return new int[]{num2, num1};
//         }
//     }

//     private boolean contains(int[] nums, int target) {
//         for (int num : nums) {
//             if (num == target) {
//                 return true;
//             }
//         }
//         return false;
//     }

}