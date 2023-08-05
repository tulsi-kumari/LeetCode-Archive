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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans=solve(1,n);
        return ans;
    }
    public List<TreeNode> solve(int s,int e)
    {
        if(s>e)
        {
            List<TreeNode> ret=new ArrayList<>();
            ret.add(null);
            return ret;
        }
        if(s==e)
        {
            TreeNode root=new TreeNode(s);
             List<TreeNode> ret=new ArrayList<>();
            ret.add(root);
            return ret;
            
        }
        List<TreeNode> ans=new ArrayList<>();
        for(int i=s;i<=e;i++){
            
            List<TreeNode> templeft=solve(s,i-1);
            List<TreeNode> tempright=solve(i+1,e);
            for(TreeNode left:templeft)
            {
                for(TreeNode right : tempright)
                {
                   TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}