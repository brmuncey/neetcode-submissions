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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode cur = prev.next;
        ListNode s = cur;
        for (int i = left; i < right; i++) {
            cur = cur.next;
        }

        ListNode tail = cur.next;
        cur.next = null;
        ListNode reversedHead = reverse(s);
        
        prev.next = reversedHead;
        s.next = tail;

        return dummy.next;
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