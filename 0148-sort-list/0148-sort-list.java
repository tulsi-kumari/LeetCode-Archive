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
    public  static ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode tail=findTail(head);
        System.out.println(tail.val);
        return mergeSort(head,tail);
    }
    public static ListNode mergeSort(ListNode head,ListNode tail){
        if(head==tail){
            return head;
        }
        ListNode mid=findMid(head,tail);
        System.out.println(mid.val);
        ListNode nextTail=findTail(head);
        System.out.println(nextTail.val);
        ListNode left=mergeSort(head,nextTail);
        ListNode right=mergeSort(mid,tail);

        return merge(left,right);
    }

    public static ListNode merge(ListNode f,ListNode s){
        ListNode merged=null;
        ListNode temp=null;
        if(f==null&&s==null){
            return null;
        }else if(f==null){
            return s;
        }else if(s==null){
            return f;
        }else{
            while(f!=null && s!=null){
                if(f.val<s.val){
                    if(merged==null){
                        merged=new ListNode(f.val);
                        temp=merged;
                        f=f.next;
                    }else{
                        temp.next=new ListNode(f.val);
                        temp=temp.next;
                        f=f.next;
                    }
                }else{
                    if(merged==null){
                        merged=new ListNode(s.val);
                        temp=merged;
                    }else{
                        temp.next=new ListNode(s.val);
                        temp=temp.next;
                    }
                    s=s.next;
                }
            }
            while(f!=null){
                temp.next=new ListNode(f.val);
                temp=temp.next;
                f=f.next;
            }
            while(s!=null){
                temp.next=new ListNode(s.val);
                temp=temp.next;
                s=s.next;
            }
            return merged;
        }
    }
    public static ListNode findTail(ListNode root){
        if(root==null){
            return null;
        }
        if(root.next==null){
            return root;
        }
        ListNode temp=root;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }
    public static ListNode findMid(ListNode start ,ListNode end){
        if(start==null){
            return start;
        }
        if(start==end){
            return start;
        }
        ListNode s=start;
        ListNode f=start;
        while( f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        ListNode newHead=s.next;
        s.next=null;
        return newHead;
    }
}