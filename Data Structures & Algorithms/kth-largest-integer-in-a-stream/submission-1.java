class KthLargest {

    PriorityQueue<Integer> minHeap;
    int pos;

    public KthLargest(int k, int[] nums) {
        pos = k;
        minHeap = new PriorityQueue<Integer>((a,b) -> a - b);
        for(Integer x : nums) add(x);
    }
    
    public int add(int val) {
        minHeap.offer(val);
        while(minHeap.size() > pos){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
