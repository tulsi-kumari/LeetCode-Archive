/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> ans=new ArrayList<>();
        findPath(root,target,ans);
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            TreeNode prev=(i==0?null:ans.get(i-1));
            find((ans.get(i)),k-i,list,prev);
        }
        return list;

    }
    public void find(TreeNode root,  int k,List<Integer> list,TreeNode prev){
        if(root==prev || root==null){
            return ;
        }
        if(k==0){
           
               list.add(root.val);
           
           return;
        }
       // System.out.println(root.val+" "+prev);
        find(root.left,k-1,list,prev);
        find(root.right,k-1,list,prev);
       return;

    }
    public boolean findPath(TreeNode root, TreeNode target,ArrayList<TreeNode> ans){
        if(root==null){
            return false;
        }
        if(root==target){
          ans.add(root);
          return true;
      }
      boolean filc=findPath(root.left,target,ans);
      if(filc){
          ans.add(root);
          return filc;
      }
      boolean firc=findPath(root.right,target,ans);
      if(firc){
          ans.add(root);
          return firc;
      }
      return false;
      
    }
}