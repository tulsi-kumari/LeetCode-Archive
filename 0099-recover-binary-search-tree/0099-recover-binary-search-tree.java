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
        inorderMorris(root);
        int temp=a.val;
        a.val=b.val;
        b.val=temp;
        prev=null;
        a=null;
        b=null;
    }
    // public void inorder(TreeNode root){
    //     if(root==null){
    //         return;
    //     }
    //     inorder(root.left);
    //     if(prev==null){
    //         prev=root;
    //     }
    //     if(prev.val>root.val){
    //        if(!flag){
    //            a=prev;
    //            flag=true;
    //        }
    //        b=root;
    //     }
    //     prev=root;
    //     inorder(root.right);
    // }
    public TreeNode findrmNode(TreeNode lm,TreeNode curr){
        
        while(lm.right!=null && lm.right!=curr){
            lm=lm.right;
        }
        return lm;
    }
    public void inorderMorris(TreeNode root){
        TreeNode curr=root;
        
        while(curr!=null){
            TreeNode ln=curr.left;
            if(ln==null){
                
                    if(prev!=null && prev.val>curr.val){
                        if(a==null){
                            a=prev;
                        }
                        b=curr;
                    }

                prev=curr;
                curr=curr.right;
            }else{
                TreeNode rm=findrmNode(ln,curr);
                if(rm.right==curr){
                    rm.right=null;
                    if(prev.val>curr.val){
                        if(a==null){
                            a=prev;
                        }
                        b=curr;
                    }
                    prev=curr;
                    curr=curr.right;
                }else{
                    rm.right=curr;
                    curr=curr.left;
                }
            }
        }
    }
}