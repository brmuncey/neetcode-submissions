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
            if(list1 == null){
                return list2;
            }

            if(list2 == null){
                return list1;
            }

            ListNode p1 = list1, p2=list2, head = new ListNode(-1), cur=head;
            while(p1 != null && p2 != null){
                if(p1.val < p2.val){
                    cur.next = p1;
                    p1 = p1.next;
                } else {
                    cur.next = p2;
                    p2 = p2.next;
                }

                cur = cur.next;
                cur.next = null;
            }

            if(p1 != null){
                cur.next = p1;
            }

            if(p2 != null){
                cur.next = p2;
            }

            return head.next;
    }
}