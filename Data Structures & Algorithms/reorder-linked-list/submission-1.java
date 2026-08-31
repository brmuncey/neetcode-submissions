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

        ListNode cur = slow, next = null, prev = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode first = head, second = prev;
        while(first != null && second != null){
            ListNode t = first.next;
            first.next = second;
            first = t;

            t = second.next;
            second.next = first;
            second = t;
        }

        if(first != null){
            first.next = null;
        }
    }
}
