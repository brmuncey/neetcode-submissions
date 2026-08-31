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
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode dummy = new ListNode(-1);
        ListNode p1 = list1, p2 = list2, res = dummy;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                res.next = p1;
                p1 = p1.next;
            } else {
                res.next = p2;
                p2 = p2.next;
            }
            res = res.next;
        }

        if(p1 != null) {
            res.next = p1;
        }

        if(p2 != null) {
            res.next = p2;
        }

        return dummy.next;
    }
}