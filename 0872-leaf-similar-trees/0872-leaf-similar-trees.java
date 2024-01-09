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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String seq1=leafSeq(root1);
        String seq2=leafSeq(root2);
        return seq1.equals(seq2);
    }
    public String leafSeq(TreeNode root)
    {
        if(root.left==null && root.right==null)
        {
            return ""+root.val+"#";
        }
        String ans="";
        if(root.left!=null)
        {
            ans+=leafSeq(root.left);
        }
        if(root.right!=null)
        {
            ans+=leafSeq(root.right);
        }
        return ans;
    }
}