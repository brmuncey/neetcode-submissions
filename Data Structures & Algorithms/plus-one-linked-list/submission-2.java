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
    public ListNode plusOne(ListNode head) {
        ListNode node = reverse(head); // start from tail

        node.val++; //add 1

        int carry = 0;
        ListNode dummy = new ListNode(-1), cur = dummy;
        while(node != null || carry != 0){ // carry vals > 10 to next node
            int x = node == null ? 0 : node.val;
            x += carry;

            cur.next = new ListNode(x % 10);
            cur = cur.next;
            carry = x / 10;

            if(node != null) node = node.next;
        }

        node = reverse(dummy.next); // reverse to original
        return node;
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
