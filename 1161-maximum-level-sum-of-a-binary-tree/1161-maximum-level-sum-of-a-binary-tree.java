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
    public int maxLevelSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q=new LinkedList<>();
        int level=1;
        q.offer(root);
        int ansLevel=1;
        int maxSum=root.val;
        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            while(size>0){
                TreeNode temp=q.poll();
                sum+=temp.val;
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
                size--;
            }
            System.out.println(sum);
            if(sum>maxSum){
                maxSum=sum;
                ansLevel=level;
            }
            level++;
        }
        
        return ansLevel;
    }
}