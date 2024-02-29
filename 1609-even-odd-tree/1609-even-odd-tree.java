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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int count=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            ArrayList<Integer> al=new ArrayList<>();
            while(size-->0)
            {
                TreeNode p=q.poll();
                if(p.left!=null) q.offer(p.left);
                if(p.right!=null) q.offer(p.right);
                al.add(p.val);
            }
            if(count%2!=0)
            {
                if(al.size()==1)
                {
                    if(al.get(0)%2==0) return false;
                }
               for(int i=0;i<al.size()-1;i++)
               {
                   int curr=al.get(i);
                   int next=al.get(i+1);
                   if(curr>=next || curr%2==0 || next%2==0) return false;
               }
            }else
            {
                if(al.size()==1)
                {
                    if(al.get(0)%2!=0) return false;
                }
               for(int i=0;i<al.size()-1;i++)
               {
                   int curr=al.get(i);
                   int next=al.get(i+1);
                   if(curr<=next || curr%2!=0 || next%2!=0) return false;
               }
            }
            count++;
        }
        return true;
    }
}