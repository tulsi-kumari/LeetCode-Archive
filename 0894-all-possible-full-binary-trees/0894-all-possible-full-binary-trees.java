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
     HashMap<Integer,List<TreeNode>> map ;
    public List<TreeNode> allPossibleFBT(int n) {
       map=new HashMap<>();
        return solve(n);
    }
    public List<TreeNode> solve(int n){
        if(n%2==0){
            return new ArrayList<>();
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        List<TreeNode> res=new ArrayList<>();
        if(n==1){
            res.add(new TreeNode(0,null,null));
        }else{
             for(int i=1;i<n;i=i+2)
             {
               List<TreeNode> leftst=solve(i);
               List<TreeNode> rightst=solve(n-i-1);
               for(TreeNode left:leftst)
               {
                   for(TreeNode right:rightst)
                   {
                       res.add(new TreeNode(0,left,right));
                   }
               }
               
             }
        }
        map.put(n,res);
        return res;
       
    }
}