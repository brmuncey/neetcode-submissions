class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        for(int n : nums) pq.offer(n);
        while(!pq.isEmpty() && pq.size() > k) pq.poll();
        return pq.peek();
    }
}
