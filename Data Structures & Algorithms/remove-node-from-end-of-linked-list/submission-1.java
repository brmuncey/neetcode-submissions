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

        ListNode p1 = head;
        int i=0;
        while(p1 != null && i < n){
            p1 = p1.next;
            i++;
        }

        if (p1 == null) return head.next;

        ListNode cur = head;
        while(p1.next != null) {
            cur = cur.next;
            p1 = p1.next;
        }

        cur.next = cur.next.next;

        return head;
    }
}
