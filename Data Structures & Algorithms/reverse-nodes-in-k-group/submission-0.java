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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head, prev=null;
        int len = len(head);
        while(len >= k){
            int i=0;
            ListNode prevEnd = prev, curEnd = cur, next = null;
            while(i<k){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                i++;
            }

            if(prevEnd != null){
                prevEnd.next = prev;
            } else {
                head = prev;
            }

            curEnd.next = cur;
            prev = curEnd;
            len-=k;
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
