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

        ListNode reverse = reverse(slow);
        while(head != null && reverse != null){
            ListNode t = head.next;
            head.next = reverse;
            head = t;

            t = reverse.next;
            reverse.next = head;
            reverse = t;
        }

        if(head != null) head.next = null;
    }

    private ListNode reverse(ListNode head){
        ListNode cur = head, next = null, prev = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
