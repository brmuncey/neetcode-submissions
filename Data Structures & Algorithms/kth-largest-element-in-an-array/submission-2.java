class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(Integer x : nums){
            minHeap.offer(x);
            if(minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}
