class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head, prev = null, next = null;
        ListNode lastGroupEnd = null, newHead = null;
        while(cur != null){
            ListNode check = cur;
            int count = 0;
            while (check != null && count < k) {
                check = check.next;
                count++;
            }
            if (count < k) {
                if (lastGroupEnd != null) lastGroupEnd.next = cur;
                if (newHead == null) return head;
                return newHead;
            }

            ListNode currentGroupStart = cur;
            prev = null;
            for(int i = 0; i < k; i++){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            if(newHead == null) {
                newHead = prev;
            } else {
                lastGroupEnd.next = prev;
            }
            lastGroupEnd = currentGroupStart;
        }
        return newHead;
    }
}