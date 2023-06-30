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
        int state;
        int camera;
        Pair(int state,int camera){
            this.state=state;
            this.camera=camera;
        }
    }
    public int minCameraCover(TreeNode root) {
        Pair p=func(root);
        if(p.state==-1){
            p.camera++;
        }
        return p.camera;
    }
    public Pair func(TreeNode root){
        if(root==null){
            return new Pair(1,0);
        }
        
        Pair minCameraLeft=func(root.left);
        Pair minCameraRight=func(root.right);
        Pair p=new Pair(0,minCameraLeft.camera+minCameraRight.camera);
        if(minCameraLeft.state==-1||minCameraRight.state==-1){
            p.camera++;
            p.state=0;
        }else if(minCameraLeft.state==0||minCameraRight.state==0){
            p.state=1;
        }else{
            p.state=-1;
        }
        return p;
        
        
    } 
}