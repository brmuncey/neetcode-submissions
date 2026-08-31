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

        ListNode reverse = reverse(slow), cur = head;
        while(cur != null && reverse != null){
            ListNode t = cur.next;
            cur.next = reverse;
            cur = t;

            t = reverse.next;
            reverse.next = cur;
            reverse = t;
        }

        if(cur != null) cur.next = null;
    }

    private ListNode reverse(ListNode head){
        ListNode cur = head, prev = null, next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
