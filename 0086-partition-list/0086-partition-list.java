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
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode smallHead=new ListNode(0);
        ListNode bigHead=new ListNode(0);
        ListNode temp=head,tempSmall=smallHead,tempBig=bigHead;
        while(temp!=null){
            ListNode n=new ListNode();
            n.val=temp.val;
            if(n.val<x){
                tempSmall.next=n;
                tempSmall=tempSmall.next;
            }else{
                tempBig.next=n;
                tempBig=tempBig.next;
            }
            temp=temp.next;
        }
        if(smallHead.next!=null){
            smallHead=smallHead.next;
        }else{
            return bigHead.next;
        }
        if(bigHead.next!=null){
             bigHead=bigHead.next;
        }else{
            return smallHead;
        }
        tempSmall.next=bigHead;
        return smallHead;


    }
}