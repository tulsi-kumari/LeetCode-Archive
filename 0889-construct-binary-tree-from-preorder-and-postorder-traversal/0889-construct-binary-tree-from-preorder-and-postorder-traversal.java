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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePost(0,preorder.length-1,preorder,0,postorder.length-1,postorder);
    }
    public TreeNode constructFromPrePost(int pres,int pree,int[] preorder,int posts,int poste, int[] postorder) {
        if(pres>pree){
            return null;
        }
        TreeNode root=new TreeNode(preorder[pres]);
        if(pres==pree){
            return root;
        }
        int nextleft=preorder[pres+1];
        int idx=0;
        for(int i=posts;i<=poste;i++){
            if(postorder[i]==nextleft){
                idx=i;
            }
        }
        int len=idx-posts+1;
        int prels=pres+1;
        int prers=pres+len+1;
        int prele=pres+len;
        int prere=pree;
        int postls=posts;
        int postrs=posts+len;
        int postle=posts+len-1;
        int postre=poste-1;
        root.left=constructFromPrePost(prels,prele,preorder,postls,postle,postorder);
        root.right=constructFromPrePost(prers,prere,preorder,postrs,postre,postorder);
        return root;
        
    }
}