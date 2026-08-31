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
            ListNode cur = l;
            while(cur != null){
                minHeap.offer(cur);
                cur = cur.next;
            }
        }

        ListNode dummy = new ListNode(-1), temp = dummy;
        while(!minHeap.isEmpty()){
            temp.next = minHeap.poll();
            temp = temp.next;
        }

        return dummy.next;
    }
}
