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
        ListNode result = new ListNode(-1);
        if(lists.length == 0){
            return result.next;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(ListNode head : lists){
            ListNode cur = head;
            while(cur != null){
                minHeap.add(cur.val);
                cur = cur.next;
            }
        }

        ListNode temp = result;
        while(!minHeap.isEmpty()){
            temp.next = new ListNode(minHeap.poll());
            temp = temp.next;
        }

        return result.next;
    }
}
