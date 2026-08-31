class MedianFinder {

    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;

    public MedianFinder() {
        minPq = new PriorityQueue<>((a,b) -> a - b);
        maxPq = new PriorityQueue<>((a,b) -> b - a);
    }
    
    public void addNum(int num) {
        if(maxPq.isEmpty() || maxPq.peek() >= num){
            maxPq.offer(num);
        } else {
            minPq.offer(num);
        }

        if(maxPq.size() > minPq.size() + 1){
            minPq.offer(maxPq.poll());
        } else if(minPq.size() > maxPq.size()) {
            maxPq.offer(minPq.poll());
        }
    }
    
    public double findMedian() {
        if(minPq.size() == maxPq.size()) return maxPq.peek() / 2.0 + minPq.peek() / 2.0;
        return maxPq.peek();
    }
}
