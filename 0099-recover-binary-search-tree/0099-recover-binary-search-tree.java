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
    static TreeNode a=null;
    static TreeNode b=null;
    static boolean flag=false;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=a.val;
        a.val=b.val;
        b.val=temp;
        prev=null;
        a=null;
        b=null;
        flag=false;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev==null){
            prev=root;
        }
        if(prev.val>root.val){
           if(!flag){
               a=prev;
               flag=true;
           }
           b=root;
        }
        prev=root;
        inorder(root.right);
    }
}