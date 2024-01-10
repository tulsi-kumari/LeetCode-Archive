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
    public int amountOfTime(TreeNode root, int start) {
        if(root.left==null && root.right==null)
            {
                return 0;
            }
        HashMap<Integer,List<Integer>> adj=new HashMap<>();
        makeGraph(root,adj);
        //System.out.println(adj);
        return bfs(start,adj);
    }
    public int bfs(int start,HashMap<Integer,List<Integer>> adj)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        int ans=0;
        HashSet<Integer> vis=new HashSet<>();
        while(!q.isEmpty())
        {
            int size=q.size();
            System.out.println(q);
            while(size-->0)
            {
                int curr=q.poll();
                if(!vis.contains(curr))
                {
                    vis.add(curr);
                    List<Integer> lis=adj.get(curr);
                    for(int i=0;i<lis.size();i++)
                    {
                        if(!vis.contains(lis.get(i))) q.add(lis.get(i));
                        
                    }
                } 
            }
            ans++; 
        }
        return ans-1;
    }
    public void makeGraph(TreeNode root,HashMap<Integer,List<Integer>> adj)
    {
        if(root==null)
        {
            return ;
        }
            if(root.left==null && root.right==null)
            {
                return;
            }
            if(root.left!=null)
            {
                List<Integer> lis=adj.getOrDefault(root.val,new ArrayList<Integer>());
                lis.add(root.left.val);
                adj.put(root.val,lis);
                List<Integer> lisl=adj.getOrDefault(root.left.val,new ArrayList<Integer>());
                lisl.add(root.val);
                adj.put(root.left.val,lisl);
                makeGraph(root.left,adj);
            }
            if(root.right!=null)
            {
                List<Integer> lis=adj.getOrDefault(root.val,new ArrayList<Integer>());
                lis.add(root.right.val);
                adj.put(root.val,lis);
                List<Integer> lisr=adj.getOrDefault(root.right.val,new ArrayList<Integer>());
                lisr.add(root.val);
                adj.put(root.right.val,lisr);
                makeGraph(root.right,adj);
            }
        
    }
}