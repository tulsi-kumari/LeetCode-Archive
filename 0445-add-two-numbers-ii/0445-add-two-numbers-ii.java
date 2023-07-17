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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode num1=reverse(l1);
        ListNode num2=reverse(l2);
        int carry=0;
        ListNode head=new ListNode(-1);
        ListNode temp1=num1;
        ListNode temp2=num2;
        ListNode temp=head;
        while(temp1!=null&& temp2!=null){
           int curr=temp1.val+temp2.val+carry;
           carry=curr/10;
            curr=curr%10;
            ListNode node=new ListNode(curr);
            temp.next=node;
            temp=temp.next;
            temp1=temp1.next;
            temp2=temp2.next;
            
        }
        while(temp1!=null){
           int curr=temp1.val+carry;
           carry=curr/10;
            curr=curr%10;
            ListNode node=new ListNode(curr);
            temp.next=node;
            temp=temp.next;
            temp1=temp1.next;
            
        }
        while(temp2!=null){
           int curr=temp2.val+carry;
           carry=curr/10;
            curr=curr%10;
            ListNode node=new ListNode(curr);
            temp.next=node;
            temp=temp.next;
            temp2=temp2.next;
            
        }
        while(carry!=0){
           int curr=carry;
           carry=curr/10;
            curr=curr%10;
            ListNode node=new ListNode(curr);
            temp.next=node;
            temp=temp.next;
            
        }
        ListNode x=head;
        head=head.next;
        x.next=null;
        return reverse(head);
        
    }
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode curr=head;
        ListNode fwd=head.next;
        while(curr!=null){
              curr.next=prev;
              prev=curr;
            curr=fwd;
            if(fwd!=null){
                fwd=fwd.next;
            }
        }
        return prev;
    }
    
}