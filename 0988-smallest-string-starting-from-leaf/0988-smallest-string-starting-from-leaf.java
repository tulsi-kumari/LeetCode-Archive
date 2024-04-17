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
    String ans="";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,"");
        return ans;
    }
    public void dfs(TreeNode root,String temp)
    {
        if(root==null) return;
        temp=(char)(root.val+'a')+temp;
        if(root.left==null && root.right==null)
        {
            if(ans.isEmpty()||ans.compareTo(temp)>0) ans=temp;
        }
        
        if(root.left!=null) dfs(root.left,temp);
        if(root.right!=null) dfs(root.right,temp);
    }
}