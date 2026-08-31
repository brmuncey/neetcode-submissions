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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode c1 = list1, c2 = list2, head = new ListNode(-1), cur = head;

        while(c1 != null && c2 != null){
            if(c1.val < c2.val){
                cur.next = c1;
                c1 = c1.next;
            } else {
                cur.next = c2;
                c2 = c2.next;
            }
            cur = cur.next;
        }

        if(c1 != null){
            cur.next = c1;
        } else if(c2 != null) {
            cur.next = c2;
        }

        return head.next;
    }
}