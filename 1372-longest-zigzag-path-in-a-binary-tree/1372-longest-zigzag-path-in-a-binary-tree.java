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
        int l;
        int r;
        int max;
        Pair(int l,int r,int max){
            this.l=l;
            this.r=r;
            this.max=max;
        }
    }
    public int longestZigZag(TreeNode root) {
        Pair p=func(root);
        return Math.max(p.l,Math.max(p.r,p.max));
    }
    public Pair func(TreeNode root){
        if(root==null){
            return new Pair(0,0,0);
        }
        Pair left=func(root.left);
        Pair right=func(root.right);
        int r=0;
        int l=0;
        int m=0;
        
        if(root.left!=null){
            l=1+left.r;
        }
        if(root.right!=null){
            r=1+right.l;
        }
        m=Math.max(l,r);
        m=Math.max(m,right.max);
        m=Math.max(m,left.max);
        // System.out.println(l+" "+r+" "+m);
        // System.out.println(left.r+" "+right.r);
        // System.out.println();
        return new Pair(l,r,m);
    }
}