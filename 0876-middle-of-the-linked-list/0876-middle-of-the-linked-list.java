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
    public ListNode middleNode(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        if(head.next.next==null){
            return head.next;
        }
        ListNode f=head;
        ListNode s=head;
        while(f!=null&&f.next!=null){
            f=f.next.next;
            s=s.next;
        }
        return s;
    }
}