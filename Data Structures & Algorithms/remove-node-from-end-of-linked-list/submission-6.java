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
        ListNode cur = head;
        int i=0;
        while(cur != null && i != n){
            cur = cur.next;
            i++;
        }

        ListNode dummy = new ListNode(-1, head), p = dummy;
        while(cur != null){
            p = p.next;
            cur = cur.next;
        }

        p.next = p.next.next;
        return dummy.next;
    }
}
