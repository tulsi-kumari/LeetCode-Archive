/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int pseudoPalindromicPaths (TreeNode root) {
        return solve(root,new int[9]);
    }
    public int solve(TreeNode root,int[] map)
    {
        if(root==null)
       {
           return 0;
       }
        map[root.val-1]++;
       if(root.left==null && root.right==null && ispalin(map))
       {
           map[root.val-1]--;
          return 1;
        }
       int ans=solve(root.left,map) + solve(root.right,map);
        map[root.val-1]--;
        return ans;
        
        
    }
    public boolean ispalin(int[] map)
    {
        int odd=0;
        for(int num:map)
        {
            if(num%2!=0)
            {
                odd++;
            }
        }
        return odd<=1;
    }
    
}