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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        solve(root,0);
        return sum;
    }
    public void solve(TreeNode root,int num)
    {
        if(root.left==null && root.right==null)
        {
            int curr=num*10+root.val;
            sum+=curr;
            return;
        }
        
        int curr=num*10+root.val;
        if(root.left!=null) solve(root.left,curr);
        if(root.right!=null) solve(root.right,curr);
        return;
    }
}