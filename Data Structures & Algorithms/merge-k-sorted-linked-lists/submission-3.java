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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode l : lists){
            while(l != null) {
                minHeap.offer(l);
                l = l.next;
            }
        }

        ListNode dummy = new ListNode(-1), cur = dummy;
        while(!minHeap.isEmpty()){
            cur.next = minHeap.poll();
            cur = cur.next;
        }

        return dummy.next;
    }
}
