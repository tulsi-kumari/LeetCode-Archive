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
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        
        ListNode prev=null;
        ListNode pres=head;
        ListNode n=head.next;
        while(n!=null){
            pres.next=prev;
            prev=pres;
            pres=n;
            n=n.next;
        }
        pres.next=prev;
       head=pres;
        return head;
    }
}