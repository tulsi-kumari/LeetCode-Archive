/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return func(0,lists.length-1,lists);
    }
    public ListNode func(int s,int e,ListNode[] lists){
        if(s>e){
            return null;
        }
        if(s==e){
            return lists[s];
        }
        int mid=s+(e-s)/2;
        
        
        ListNode left=func(s,mid,lists);
        //System.out.println(left.val);
        ListNode right=func(mid+1,e,lists);
        // System.out.println(right.val);
        
        return merge(left,right);
    }
    public ListNode merge(ListNode left,ListNode right){
        if(left==null && right==null){
            return null;
        }else if(left==null){
            return right;
        }else if(right==null){
            return left;
        }
        
        ListNode temp=new ListNode(-1);
        ListNode tempHead=temp;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                temp.next=left;
                temp=left;
                left=left.next;
            }else if(right.val<left.val){
                temp.next=right;
                temp=right;
                right=right.next;
            }
        }
        if(left==null){
            temp.next=right;
        }
        if(right==null){
            temp.next=left;
        }
        //System.out.println("merged"+" "+tempHead.next.val);
        return tempHead.next;
        
    }
    
}
