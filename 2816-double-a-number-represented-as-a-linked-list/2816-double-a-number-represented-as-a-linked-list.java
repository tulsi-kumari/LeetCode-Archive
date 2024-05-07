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
    public ListNode doubleIt(ListNode head) {
        if(head==null) return head;
        ListNode revHead=reverse(head);
        int carry=0;
        ListNode temp=revHead;
        ListNode prev=null;
        while(temp!=null)
        {
            int curr=temp.val*2+carry;
            int in=curr%10;
            carry=curr/10;
            temp.val=in;
            prev=temp;
            temp=temp.next;
        }
        temp=prev;
        while(carry!=0)
        {
           int curr=carry;
           int in=curr%10;
           carry=curr/10;
           temp.next=new ListNode(in);
           temp=temp.next; 
        }
        return reverse(revHead);
    }
    public ListNode reverse(ListNode head)
    {
        if(head==null || head.next==null) return head;
        ListNode prev=null;
        ListNode curr=head;
        ListNode fwd=curr.next;
        while(curr!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=fwd;
            if(fwd!=null) fwd=fwd.next;
        }
        return prev;
    }
}