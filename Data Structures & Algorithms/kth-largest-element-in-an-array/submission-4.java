class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);
        for(int n : nums) minHeap.offer(n);

        while(!minHeap.isEmpty() && minHeap.size() > k) minHeap.poll();

        return minHeap.isEmpty() ? 0 : minHeap.peek();
    }
}
