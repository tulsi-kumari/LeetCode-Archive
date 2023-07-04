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
    static TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
       boolean ans=helper(root);
        prev=null;
        
        return ans;
    }
     public boolean helper(TreeNode root){
         if(root==null){
             return true;
         }
         boolean left=helper(root.left);
         if(left==false){
             return false;
         }
         System.out.println(left);
         if(prev==null || prev.val<root.val){
             prev=root;
         }else if(prev.val>=root.val){
             return false;
         }
         boolean right=helper(root.right);
         System.out.println(right);
         return left && right;
     }
}