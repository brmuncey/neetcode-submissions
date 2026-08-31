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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        ListNode p = head;
        int i=0;
        while(p != null && i < n){
            p = p.next;
            i++;
        }

        if(p == null) return head.next;

        ListNode cur = head;
        while(p.next != null) {
            cur = cur.next;
            p = p.next;
        }

        cur.next = cur.next.next;

        return head;
    }
}
