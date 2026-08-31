class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0){
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for(Integer x : stones) maxHeap.offer(x);

        while(maxHeap.size() > 1){
            int t = maxHeap.poll();
            if(t == maxHeap.peek()){
                maxHeap.poll();
            } else {
                maxHeap.offer(Math.abs(t - maxHeap.poll()));
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
