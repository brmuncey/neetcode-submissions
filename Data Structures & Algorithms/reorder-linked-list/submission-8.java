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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow), cur = head;

        while(rev != null && cur != null){
            ListNode temp = cur.next;
            cur.next = rev;
            cur = temp;

            temp = rev.next;
            rev.next = cur;
            rev = temp;
        }

        if(cur != null) cur.next = null;

    }

    private ListNode reverse(ListNode node) {
        ListNode cur = node, prev = null, next = null;

        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
