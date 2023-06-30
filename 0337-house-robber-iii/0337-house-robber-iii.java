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
    public class Pair{
          int r;
          int nr;
          Pair(int r,int nr){
            this.r=r;
            this.nr=nr;
        }
    }
    public int rob(TreeNode root) {
        Pair p=robbery(root);
        return Math.max(p.r,p.nr);
  
    }
    public Pair robbery(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        Pair left =robbery(root.left);
        Pair right=robbery(root.right);
        int r=root.val+left.nr+right.nr;
        int nr=Math.max(left.r,left.nr)+Math.max(right.r,right.nr);
        return new Pair(r,nr);
    }
}