class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) -> (a - b));
        maxHeap = new PriorityQueue<>((a,b) -> (b - a));
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) minHeap.offer(maxHeap.poll());
        if(maxHeap.size() > minHeap.size() + 1) minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size() + 1) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        if(minHeap.size() > maxHeap.size()) return minHeap.peek();

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
