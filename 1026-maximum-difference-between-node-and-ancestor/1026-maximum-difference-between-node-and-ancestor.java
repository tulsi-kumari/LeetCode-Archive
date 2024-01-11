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
    int max=Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        helper(root);
        return max; 
    }
    public void helper(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        int[] ans=new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        min_max(root,ans);
        int tempMax=Math.max(Math.abs(root.val-ans[0]),Math.abs(root.val-ans[1]));
        max=Math.max(tempMax,max);
        helper(root.left);
        helper(root.right);
    }
    public void min_max(TreeNode root,int[] ans)
    {
        if(root==null)
        {
            return;
        }
        if(root.val<ans[0])
        {
            ans[0]=root.val;
        }
        if(root.val>ans[1])
        {
            ans[1]=root.val;
        }
        min_max(root.left,ans);
        min_max(root.right,ans);
    }
}