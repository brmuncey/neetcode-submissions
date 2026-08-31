class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>((a,b) -> a - b);
        for(int n : nums) add(n);
    }
    
    public int add(int val) {
        minHeap.offer(val);
        while(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
