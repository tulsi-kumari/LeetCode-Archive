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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return solve(preorder,0,preorder.length-1);
        //int[] inorder=preorder.clone();
        //Arrays.sort(inorder);
        //return solve(0,preorder.length-1,preorder,0,inorder.length-1,inorder);
    }
    public TreeNode solve(int[] preorder,int s,int e){
        if(s>e){
            return null;
        }
        TreeNode root=new TreeNode(preorder[s]);
        if(s==e){
            return root;
        }
        
        int idx=s+1;
        while(idx<preorder.length && preorder[idx]<preorder[s]){
            idx++;
        }
        
        int ls=s+1;
        int le=idx-1;
        int rs=idx;
        int re=e;
        
        root.left=solve(preorder,ls,le);
        root.right=solve(preorder,rs,re);
        return root;
        
    }
//     public TreeNode solve(int ps,int pe,int[] preorder,int is,int ie,int[] inorder){
//         if(ps>pe||is>ie){
//             return null;
//         }
//         TreeNode node=new TreeNode(preorder[ps]);
         
//            int ils=is;
//            int ile=findIdx(inorder,preorder[ps])-1;
//            int irs=findIdx(inorder,preorder[ps])+1;
//            int ire=ie;
//            int pls=ps+1;
//            int ple=(ile-ils)+pls;
//            int prs=ple+1;
//            int pre=(ire-irs)+prs;
//            node.left=solve(pls,ple,preorder,ils,ile,inorder);
//            node.right=solve(prs,pre,preorder,irs,ire,inorder);

//         return node;   

//     }
//     public int findIdx(int[] arr,int x){
//         for(int i=0;i<arr.length;i++){
//             if(arr[i]==x){
//                 return i;
//             }
//         }
//         return -1;
//     }
}