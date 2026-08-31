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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length < 1){
            return null;
        }

        ListNode one = lists[0];
        for(int i=1 ; i<lists.length ; i++){
            one = mergeLists(one, lists[i]);
        }

        return one;
    }

    private ListNode mergeLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode p1 = l1, p2=l2, result = new ListNode(-1), cur = result;
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

        return result.next;
    }
}
