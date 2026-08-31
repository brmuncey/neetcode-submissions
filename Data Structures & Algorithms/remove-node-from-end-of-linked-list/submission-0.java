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
        if(head == null || n < 0){
            return head;
        }

        ListNode cur = head, prev = null;
        int len = len(head), t = len - n, i=0;
        while(cur != null){
            if(i != t){
                prev = cur;
                cur = cur.next;
            } else {
                if(prev != null){
                    prev.next = cur.next;
                } else {
                    head = cur.next;
                }
                cur = cur.next;
            }

            i++;
        }

        return head;
    }

    private int len(ListNode head){
        int i=0;
        while(head != null){
            head = head.next;
            i++;
        }
        return i;
    }
}
